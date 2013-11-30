package com.mylog.ui;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mylog.dao.AppUser;
import com.mylog.entries.def.EntryTypeDefinition;
import com.mylog.service.MyLogSession;

public class MainForm
{
	private HttpServletRequest request;
	private MyLogSession session;

	/**
	 * Constructor.
	 *
	 * @param request
	 * 			A handle to the request object for this page
	 */
	public MainForm(HttpServletRequest request)
	{
		this.request = request;
		this.session = new MyLogSession(request);
	}

	/**
	 *
	 * @return
	 * 		A list of sections, applicable to the user currently logged in
	 */

	public List<Section> getSections()
		throws Exception
	{
		if (session.getAppUser() == null)
		{
			return getSectionsForAnonymousUser();
		}
		else
		{
			return getSectionsForUser(session.getAppUser());
		}
	}

	/**
	 *
	 * @return
	 * 		A list of sections, applicable to the user currently logged in
	 */

	private List<Section> getSectionsForAnonymousUser()
	{
		ArrayList<Section> list = new ArrayList<MainForm.Section>();

		Section section = new Section("Welcome!", new ArrayList<MainForm.SectionItem>());
		section.getItems().add(new SectionItem("Welcome", "welcome/welcome_not_logged_in.jsp"));
		section.getItems().add(new SectionItem("Login", "login/login.jsp"));
		section.getItems().add(new SectionItem("Register", "register/register.jsp"));
		list.add(section);

		return list;
	}

	/**
	 *
	 * @return
	 * 		A list of sections, applicable to the user currently logged in
	 */

	private List<Section> getSectionsForUser(AppUser user)
		throws Exception
	{
		ArrayList<Section> list = new ArrayList<MainForm.Section>();

		//
		// The add/search entry type section
		//
		Section section = new Section("My Log", new ArrayList<MainForm.SectionItem>());
		section.getItems().add(new SectionItem("Welcome", "welcome/welcome_user.jsp"));

		List<EntryTypeDefinition> listEntryTypes = session.getEntryTypeDefinitions();
		for (EntryTypeDefinition cur : listEntryTypes)
		{
			section.getItems().add(new SectionItem(cur.getName() + " - Add", "entry/edit.jsp?entry_action=add&type=" + URLEncoder.encode(cur.getName())));
			section.getItems().add(new SectionItem(cur.getName() + " - Search", "entry/search.jsp"));
		}

		list.add(section);

		//
		// The add/search entry type section
		//
		section = new Section("Reporting", new ArrayList<MainForm.SectionItem>());
		section.getItems().add(new SectionItem("Reporting", "reporting/reporting.jsp"));

		listEntryTypes = session.getEntryTypeDefinitions();
		for (EntryTypeDefinition cur : listEntryTypes)
		{
			section.getItems().add(new SectionItem(cur.getName(), "reporting/report.jsp"));
		}

		list.add(section);

		//
		// Account / Settings section
		//
		section = new Section("Account", new ArrayList<MainForm.SectionItem>());
		section.getItems().add(new SectionItem("Edit profile", "cc"));
		list.add(section);

		return list;
	}

	/**
	 *
	 * A class, representing a single item in a section
	 *
	 */

	public class SectionItem
	{
		private String name;
		private String url;
		public SectionItem(String name, String url) {
			super();
			this.name = name;
			this.url = url;
		}

		public String getName() {
			return name;
		}

		public String getUrl() {
			return url;
		}
	}

	/**
	 *
	 * A class, representing a section on the Main Form
	 *
	 */

	public class Section
	{
		private String name;
		private List<SectionItem> items;

		public Section(String name, List<SectionItem> items) {
			super();
			this.name = name;
			this.items = items;
		}

		public String getName() {
			return name;
		}

		public List<SectionItem> getItems() {
			return items;
		}
	}
}
