package com.mylog.entries.def;

public class SearchDefinition
{
	private String name;
	private String description;
	private Class<? extends AEntrySearch> classSearchImpl;
	private Object[] parameters;

	public SearchDefinition(String name, String description,
			Class<? extends AEntrySearch> classSearchImpl, Object[] parameters)
	{
		this.name = name;
		this.description = description;
		this.classSearchImpl = classSearchImpl;
		this.parameters = parameters;
	}

	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return description;
	}

	public Class<? extends AEntrySearch> getClassSearchImpl()
	{
		return classSearchImpl;
	}

	public Object[] getParameters()
	{
		return parameters;
	}
}
