	<form id = "content_form" name="content_form" method="post" action="entry/edit.jsp?entry_action=save">
		<%=EntryFormToolbox.generateHiddenField("type", type)%>
		
<%
		if (fieldValidationResult != null && fieldValidationResult.generalFeedback != null)
		{
%>
			<span style="color:<%=(fieldValidationResult.success?"":"red")%>"><%=fieldValidationResult.generalFeedback%></span>
<%
		}
%>
		
<%
		List<FieldDefinition> list1 = entryTypeDef.getEntryDefinition().getInternalFields();
		for (FieldDefinition curField : list1)
		{
			String curValue = request.getParameter(curField.getName());
%>
			<%=EntryFormToolbox.generateHTMLForField(curField, fieldValues, fieldValidationResult, viewOnly)%>
<%
		}
	
%>

		<table>
<%
		List<FieldDefinition> list2 = entryTypeDef.getEntryDefinition().getDisplayFields();
		for (FieldDefinition curField : list2)
		{
			String curValue = request.getParameter(curField.getName());
%>
			<tr>
				<td>
					<%=curField.getLabel()%>
				</td>
				<td>
					<%=EntryFormToolbox.generateHTMLForField(curField, fieldValues, fieldValidationResult, viewOnly)%>
				</td>
			</tr>
<%
		}
	
%>
		</table>
		
<%
		if (!viewOnly)
		{
%>
		<table>
			<tr>
				<td><button onclick = " MainForm.submitContent(); return false;">Save</button></td>
			</tr>
		</table>
<%
		}
%>
	</form>