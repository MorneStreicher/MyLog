package com.mylog.entries.def;

import java.util.List;

import com.mylog.dao.AppUser;

public abstract class AEntrySearch
{
	public abstract void setParamaters(Object[] parameters) throws Exception;

	public abstract List<? extends AEntryObject> search(AppUser user) throws Exception;
}
