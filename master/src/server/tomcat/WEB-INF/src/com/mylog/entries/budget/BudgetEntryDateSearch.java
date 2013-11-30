package com.mylog.entries.budget;

import java.util.ArrayList;
import java.util.List;

import com.mylog.dao.AppUser;
import com.mylog.dao.LogEntry;
import com.mylog.entries.def.AEntryObject;
import com.mylog.entries.def.AEntrySearch;

public class BudgetEntryDateSearch extends AEntrySearch
{

	@Override
	public void setParamaters(Object[] parameters) throws Exception
	{

	}

	@Override
	public List<? extends AEntryObject> search(AppUser user) throws Exception
	{
		List<BudgetEntry> list = new ArrayList<BudgetEntry>();

		for (LogEntry cur : user.getLogEntries())
		{

		}

		return list;
	}

}
