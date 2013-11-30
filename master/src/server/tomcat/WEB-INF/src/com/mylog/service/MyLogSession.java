package com.mylog.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mylog.dao.AppUser;
import com.mylog.entries.EntryTypeForUsersFactory;
import com.mylog.entries.def.EntryTypeDefinition;

public class MyLogSession {

	private HttpServletRequest request;
	private HttpSession session;

	public MyLogSession(HttpServletRequest request)
	{
		this.request = request;
		this.session = request.getSession();

		//AutoLogin
		setAppUser(new AppUser());
		getAppUser().setUserId("20131118140000000001");
	}

	public AppUser getAppUser()
	{
		if (session != null)
		{
			return (AppUser) session.getAttribute(MyLogSession.MYLOG_APPU_SER_ATTR_KEY);
		}

		return null;
	}

	public void setAppUser(AppUser user)
	{
		if (session == null)
		{
			session = request.getSession(true);
		}

		session.setAttribute(MYLOG_APPU_SER_ATTR_KEY, user);
	}

	public List<EntryTypeDefinition> getEntryTypeDefinitions()
			throws Exception
	{
		List<EntryTypeDefinition> list = (List<EntryTypeDefinition>) session.getAttribute(MYLOG_ENTRY_TYPE_DEFINITIONS);
		if (list == null)
		{
			list = EntryTypeForUsersFactory.createForUser(getAppUser());
			session.setAttribute(MYLOG_ENTRY_TYPE_DEFINITIONS, list);
		}

		return list;
	}


	private static final String MYLOG_APPU_SER_ATTR_KEY = "MyLogAppUser";
	private static final String MYLOG_ENTRY_TYPE_DEFINITIONS = "MyLogEntryTypeDefinitions";

}
