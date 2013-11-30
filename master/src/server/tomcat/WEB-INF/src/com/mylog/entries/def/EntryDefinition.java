package com.mylog.entries.def;

import java.util.ArrayList;
import java.util.List;

public class EntryDefinition
{

	private Class<? extends AEntryObject> businessObjectClass;
	private List<FieldDefinition> fields;

	public EntryDefinition(Class<? extends AEntryObject> businessObjectClass,
			List<FieldDefinition> fields)
	{
		this.businessObjectClass = businessObjectClass;
		this.fields = fields;
	}

	public Class<? extends AEntryObject> getBusinessObjectClass()
	{
		return businessObjectClass;
	}

	public List<FieldDefinition> getAllFields()
	{
		return fields;
	}

	public List<FieldDefinition> getDisplayFields()
	{
		ArrayList<FieldDefinition> list = new ArrayList<FieldDefinition>();
		for (FieldDefinition cur : fields)
		{
			if (!cur.isInternalField())
			{
				list.add(cur);
			}
		}
		return list;
	}

	public List<FieldDefinition> getInternalFields()
	{
		ArrayList<FieldDefinition> list = new ArrayList<FieldDefinition>();
		for (FieldDefinition cur : fields)
		{
			if (cur.isInternalField())
			{
				list.add(cur);
			}
		}
		return list;
	}
}
