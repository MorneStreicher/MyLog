package com.mylog.entries.def;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

import com.mylog.util.ApplicationLog;

public abstract class AEntryObjectValueMapper
{
	public abstract Class<? extends Object> getValueClass();

	public abstract String toString(Object obj);

	public abstract Object fromString(String string_value);

	public abstract boolean isValidStringValue(String string_value);

	public static AEntryObjectValueMapper getMapper(FieldDefinition fieldDef)
	{
		if (fieldDef.getFieldType().equals(FieldDefinition.FieldType.TEXT)
				|| fieldDef.getFieldType().equals(FieldDefinition.FieldType.INTERNAL))
		{
			return new TextValueMapper();
		}

		if (fieldDef.getFieldType().equals(FieldDefinition.FieldType.AMOUNT))
		{
			return new AmountValueMapper();
		}

		if (fieldDef.getFieldType().equals(FieldDefinition.FieldType.DATE))
		{
			return new DateValueMapper();
		}

		throw new RuntimeException("Invalid type: [" + fieldDef.getFieldType() + "]");
	}

	private static class TextValueMapper extends AEntryObjectValueMapper
	{
		public Class<? extends Object> getValueClass()
		{
			return String.class;
		}

		public String toString(Object obj)
		{
			if (obj == null)
			{
				return null;
			}
			else
			{
				return obj.toString();
			}
		}

		public Object fromString(String string_value)
		{
			return string_value;
		}

		public boolean isValidStringValue(String string_value)
		{
			return true;
		}
	}

	private static class AmountValueMapper extends AEntryObjectValueMapper
	{
		public Class<? extends Object> getValueClass()
		{
			return Double.TYPE;
		}

		public String toString(Object obj)
		{
			if (obj == null)
			{
				return null;
			}
			else
			{
				return obj.toString();
			}
		}

		public Object fromString(String string_value)
		{
			if (string_value == null)
			{
				return null;
			}
			else
			{
				return Double.parseDouble(string_value);
			}
		}

		public boolean isValidStringValue(String string_value)
		{
			if (string_value == null)
			{
				return true;
			}
			else
			{
				try
				{
					Double.parseDouble(string_value);
					return true;
				}
				catch (NumberFormatException e)
				{
					ApplicationLog.getInstance().log(e.getMessage(), e);
					return false;
				}
			}
		}
	}

	private static class DateValueMapper extends AEntryObjectValueMapper
	{
		public Class<? extends Object> getValueClass()
		{
			return Date.class;
		}

		public String toString(Object obj)
		{
			if (obj == null)
			{
				return null;
			}
			else
			{
				return DateFormat.getInstance().format((Date) obj);
			}
		}

		public Object fromString(String string_value)
		{
			if (string_value == null)
			{
				return null;
			}
			else
			{
				try
				{
					return DateFormat.getInstance().parse(string_value);
				}
				catch (ParseException e)
				{
					ApplicationLog.getInstance().log(e.getMessage(), e);

					throw new RuntimeException(e);
				}
			}
		}

		public boolean isValidStringValue(String string_value)
		{
			if (string_value == null)
			{
				return true;
			}
			else
			{
				try
				{
					DateFormat.getInstance().parse(string_value);
					return true;
				}
				catch (ParseException e)
				{
					ApplicationLog.getInstance().log(e.getMessage(), e);

					return false;
				}
			}
		}
	}

}
