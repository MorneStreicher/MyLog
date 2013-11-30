package com.mylog.ui;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.mylog.entries.def.AEntryObject;
import com.mylog.entries.def.EntryTypeDefinition;
import com.mylog.entries.def.FieldDefinition;
import com.mylog.service.MyLogSession;
import com.mylog.util.ApplicationLog;

public class EntryFormToolbox
{

	/**
	 * Generates a hidden HTML field, with a given name value pair
	 *
	 * @param field
	 *            The field name
	 * @param value
	 *            The field value
	 * @return The HTML representation for this field
	 */

	public static String generateHiddenField(String field, String value)
	{
		return "<input type = 'hidden' name = '" + field + "' value = '" + value + "'>";
	}

	/**
	 * Generates the HTML for an entry field
	 *
	 * @param field
	 *            The field name
	 * @param fieldValues
	 *            The field values to be used
	 * @param fieldValidationResult
	 *            The outcome of validations done before the form is rendered.
	 *            May be <code>null</code>.
	 * @param viewOnly
	 *            <code>true</code> if the element needs to be rendered in read
	 *            only mode
	 * @return The HTML representation for this field
	 *
	 */

	public static String generateHTMLForField(FieldDefinition field,
			Map<String, String> fieldValues, FieldValidationResult fieldValidationResult,
			boolean viewOnly)
	{
		String value = null;
		if (fieldValues.containsKey(field.getName()))
		{
			value = fieldValues.get(field.getName());
		}

		if (fieldValidationResult != null
				&& !field.getName().equals(fieldValidationResult.fieldName))
		{
			fieldValidationResult = null;
		}

		if (field.getFieldType().equals(FieldDefinition.FieldType.TEXT))
		{
			return generateHTMLForText(field, value, fieldValidationResult, viewOnly);
		}
		else
			if (field.getFieldType().equals(FieldDefinition.FieldType.AMOUNT))
			{
				return generateHTMLForText(field, value, fieldValidationResult, viewOnly);
			}
			else
				if (field.getFieldType().equals(FieldDefinition.FieldType.DATE))
				{
					return generateHTMLForText(field, value, fieldValidationResult, viewOnly);
				}
				else
					if (field.getFieldType().equals(FieldDefinition.FieldType.INTERNAL))
					{
						//return generateHTMLForText(field, value, fieldValidationResult, viewOnly);
						return generateHiddenField(field.getName(), value);
					}
					else
					{
						throw new RuntimeException("Unknown field type: " + field.getFieldType());
					}
	}

	public static String generateHTMLForText(FieldDefinition field, String value,
			FieldValidationResult fieldValidationResult, boolean viewOnly)
	{
		String html = "";
		if (fieldValidationResult != null)
		{
			html += "<span style = 'color: red'>" + fieldValidationResult.fieldValidationMessage
					+ "</span></br>";
		}

		html += "<input  type=\"text\" name=\"FIELD_" + field.getName() + "\" maxlength=\""
				+ field.getLength() + "\" size=\"" + field.getLength() + "\" value = \""
				+ (value == null ? "" : value) + "\"  " + (viewOnly ? "DISABLED" : "") + " >";

		return html;
	}

	public static void prepareForAddUpdateAction(String entry_type, String entry_action,
			String entry_id, HttpServletRequest request, Map<String, String> fieldValues)
			throws Exception
	{
		MyLogSession session = new MyLogSession(request);
		EntryTypeDefinition entryTypeDef = EntryFormToolbox.getEntryTypeDefinition(entry_type,
				request);

		if (entry_action.equals(EntryAction.ADD))
		{
			AEntryObject entryObject = entryTypeDef.getEntryDefinition().getBusinessObjectClass()
					.newInstance();
			entryObject.initForNewInstance(session.getAppUser());
			entryObject.getFieldValuesMap(fieldValues, entryTypeDef.getEntryDefinition());
		}

		if (entry_action.equals(EntryAction.UPDATE))
		{
			AEntryObject entryObject = entryTypeDef.getEntryDefinition().getBusinessObjectClass()
					.newInstance();
			entryObject.loadFromDatabase(entry_id);
			entryObject.getFieldValuesMap(fieldValues, entryTypeDef.getEntryDefinition());
		}
	}

	public static void getFormValues(String entry_type, HttpServletRequest request,
			Map<String, String> fieldValues) throws Exception
	{
		EntryTypeDefinition entryTypeDef = getEntryTypeDefinition(entry_type, request);
		for (FieldDefinition cur : entryTypeDef.getEntryDefinition().getAllFields())
		{
			String name = "FIELD_" + cur.getName();
			if (request.getParameter(name) != null && !"".equals(request.getParameter(name)))
			{

				fieldValues.put(cur.getName(), request.getParameter(name));
			}
		}

		System.out.println(fieldValues);
	}

	public static FieldValidationResult validateFields(String entry_type,
			HttpServletRequest request, Map<String, String> fieldValues) throws Exception
	{
		EntryTypeDefinition entryTypeDef = EntryFormToolbox.getEntryTypeDefinition(entry_type,
				request);

		AEntryObject entryObject = entryTypeDef.getEntryDefinition().getBusinessObjectClass()
				.newInstance();

		entryObject.setFieldValuesFromMap(fieldValues, entryTypeDef.getEntryDefinition());

		AEntryObject.ValidationResult result = entryObject.validateObject();

		FieldValidationResult result2 = new FieldValidationResult(result);
		if (!result2.success && result2.generalFeedback == null)
		{
			result2.generalFeedback = "Some fields failed validation. Correct the fields and resubmit the form.";
		}

		return result2;
	}

	public static FieldValidationResult saveEntry(String entry_type, HttpServletRequest request,
			Map<String, String> fieldValues) throws Exception
	{
		EntryTypeDefinition entryTypeDef = EntryFormToolbox.getEntryTypeDefinition(entry_type,
				request);

		AEntryObject entryObject = entryTypeDef.getEntryDefinition().getBusinessObjectClass()
				.newInstance();

		entryObject.setFieldValuesFromMap(fieldValues, entryTypeDef.getEntryDefinition());

		AEntryObject.ValidationResult result = entryObject.validateObject();
		if (!result.success)
		{
			FieldValidationResult result2 = new FieldValidationResult(result);
			if (!result2.success && result2.generalFeedback == null)
			{
				result2.generalFeedback = "Some fields failed validation. Correct the fields and resubmit the form.";
			}

			return result2;
		}

		try
		{
			entryObject.saveToDataBase(new MyLogSession(request));
		}
		catch (Exception e)
		{
			ApplicationLog.getInstance().log("Error saving entry object to database", e);

			return new FieldValidationResult(false, "Error saving entry to database"
					+ e.getMessage());
		}

		return new FieldValidationResult(true, "Log entry saved successfully"); // Success

	}

	public static EntryTypeDefinition getEntryTypeDefinition(String entry_type,
			HttpServletRequest request) throws Exception
	{
		MyLogSession session = new MyLogSession(request);
		EntryTypeDefinition def = null;
		for (EntryTypeDefinition cur : session.getEntryTypeDefinitions())
		{
			if (cur.getName().equals(entry_type))
			{
				return cur;
			}
		}

		throw new Exception("Entry type [" + entry_type + "] does not exist for the user.");
	}

	public static class FieldValidationResult
	{
		// General feedback
		public boolean success = true;
		public String generalFeedback;

		// Field specific validation
		public String fieldName;
		public String fieldValidationMessage;

		public FieldValidationResult(AEntryObject.ValidationResult result)
		{
			this.success = result.success;
			this.generalFeedback = result.generalFeedback;
			this.fieldName = result.fieldName;
			this.fieldValidationMessage = result.fieldValidationMessage;
		}

		public FieldValidationResult()
		{

		}

		public FieldValidationResult(boolean success, String generalFeedback)
		{
			this.success = success;
			this.generalFeedback = generalFeedback;
		}
	}

	public static class EntryAction
	{
		public static final String ADD = "add";
		public static final String UPDATE = "update";
		public static final String SAVE = "save";
	}

}
