package com.mylog.entries.def;

public class FieldDefinition
{

	private String name;
	private String label;
	private boolean nullable;

	private String fieldType;
	private int length;

	public FieldDefinition(String name, String label, boolean nullable, String fieldType, int length)
	{
		super();
		this.name = name;
		this.label = label;
		this.nullable = nullable;
		this.fieldType = fieldType;
		this.length = length;
	}

	public String getName()
	{
		return name;
	}

	public String getLabel()
	{
		return label;
	}

	public boolean isNullable()
	{
		return nullable;
	}

	public String getFieldType()
	{
		return fieldType;
	}

	public int getLength()
	{
		return length;
	}

	public boolean isInternalField()
	{
		return getFieldType().equals(FieldType.INTERNAL);
	}

	public static class FieldType
	{
		public static final String TEXT = "TEXT";
		public static final String DATE = "DATE";
		public static final String AMOUNT = "AMOUNT";
		public static final String INTERNAL = "INTERNAL";
	}
}
