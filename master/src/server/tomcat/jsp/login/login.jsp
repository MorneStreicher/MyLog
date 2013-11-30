<%@ page language="java" session="true" contentType="text/html; charset=iso-8859-1" %>
<%@ page import="com.mylog.ui.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.mylog.service.rest.login.*" %>

<%
	Login login = new Login();
	LoginResult result = null;
	if (request.getParameter("userId") != null)
	{
		result = login.doLogin (request, request.getParameter("userId"), request.getParameter("password"));
	}
%>

<%
	if (result != null && result.successLogon)
	{
%>
		<script>
			// We need to refresh the entire page, for the menus to become available
			location.reload(true);
		</script>
<%
	}
	else
	{
%>
		<h1>Login</h1>
		<% if (result != null) { %> <p><%=result.errorMessage%></p> <% } %> 
		<form id = "content_form" name="content_form" method="post" action="login/login.jsp">
			<table>
				<tr>
					<td>User name: </td>
					<td><input  type="text" name="userId" maxlength="30" size="30"></td>
				</tr>
				<tr>
					<td>Password: </td>
					<td><input  type="password" name="password" maxlength="30" size="30"></td>
				</tr>
				<tr>
					<td></td>
					<td><button onclick = " MainForm.submitContent(); return false;">Login</button></td>
				</tr>
			</table>
		 </form>
		
<%
	}
%>

