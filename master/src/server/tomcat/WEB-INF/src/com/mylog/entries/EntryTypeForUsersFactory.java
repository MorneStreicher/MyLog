package com.mylog.entries;

import java.util.ArrayList;
import java.util.List;

import com.mylog.dao.AppUser;
import com.mylog.entries.budget.BudgetTypeFactory;
import com.mylog.entries.def.EntryTypeDefinition;

public class EntryTypeForUsersFactory {

	public static List<EntryTypeDefinition> createForUser(AppUser user)
		throws Exception
	{
		ArrayList<EntryTypeDefinition> list = new ArrayList<EntryTypeDefinition>();
		list.add(new BudgetTypeFactory().createEntryTypeDefinition());
		return list;
	}

}
