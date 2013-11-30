<%@ page language="java" session="true" contentType="text/html; charset=iso-8859-1" %>
<%@ page import="com.mylog.ui.*" %>
<%@ page import="com.mylog.service.*" %>
<%@ page import="com.mylog.entries.def.*" %>
<%@ page import="java.util.*" %>

<%
	String type = request.getParameter("type");	// The entry type name
	String entry_action = request.getParameter("entry_action");	// add, update
	String entry_id = request.getParameter("entry_id");	// The entry ID
%>
<h1><%=type%> - add entry</h1>
<%
	MyLogSession myLogSession = new MyLogSession(request);
	EntryTypeDefinition entryTypeDef = EntryFormToolbox.getEntryTypeDefinition(type, request);
	
	boolean doForm = false;
	boolean viewOnly = false;
	
	
	EntryFormToolbox.FieldValidationResult fieldValidationResult = new EntryFormToolbox.FieldValidationResult();
	Map<String, String> fieldValues = new HashMap<String, String>();
	
	if (entry_action.equals("add") || entry_action.equals("update"))
	{
		EntryFormToolbox.prepareForAddUpdateAction(type, entry_action, entry_id, request, fieldValues);
		doForm = true;
	}
	
	if (entry_action.equals("save"))
	{
		EntryFormToolbox.getFormValues(type, request, fieldValues);
		fieldValidationResult = EntryFormToolbox.validateFields (type, request, fieldValues);
		if (!fieldValidationResult.success)
		{
			doForm = true;
		}
		else
		{
			fieldValidationResult = EntryFormToolbox.saveEntry (type, request, fieldValues);
			if (!fieldValidationResult.success)
			{
				doForm = true;
			}
		}
	}
	
	if (doForm)
	{
%>
		<%@ include file="include_form.jsp" %>
<%
	}
	else
	{
		viewOnly = true;
%>
		<%@ include file="include_form.jsp" %>
<%
	}
%>



