<%@ page language="java" session="true" contentType="text/html; charset=iso-8859-1" %>
<%@ page import="com.mylog.ui.*" %>
<%@ page import="java.util.*" %>

<!doctype html>
<head>
	<title>Morne Test - Main</title>

	<link rel="stylesheet" href="../lib/jquery/jquery-ui.css">
	<link rel="stylesheet" href="../css/common.css">

	<script src="../lib/jquery/jquery-1.9.1.js"></script>
	<script src="../lib/jquery/jquery-ui.js"></script>
	<script src="../js/main.js"></script>

	<style>
		<style type=text/css>
			div.ui-accordion-content {
				font-size : 10pt;
			}
	</style>

	<script>
		$(function() {
			$( "#accordion" ).accordion({
				heightStyle: "fill"
			});
		});
	</script>
</head>
	<body id = "main-body">
		<div id = "div-logo" style = "text-align: center">
			<img src = "../images/logo/mylog_topleft_logo.jpg" width = "120px" height = "76px"/>
		</div>

		<div id = "div-header">
			<table border = 0 width = "100%" height = "100%">
				<tr>
					<td width="200px"><span style = "font-size: 40pt; color: #AAAAAA;">My Log</span></td>
					<td style = "vertical-align:bottom">
						<span style = "font-size: 14pt; color: #909090; vertical-align:bottom">
							An online application for all your logging requirements
						</span>
					</td>
				</tr>
			</table>
		</div>

		<div id = "div-left">

			<div id="accordion">
<%
			MainForm mainForm = new MainForm (request);
			List<MainForm.Section> sections = mainForm.getSections();
			String firstUrl = sections.get(0).getItems().get(0).getUrl();
			for (MainForm.Section cur: sections)
			{
%>
				<h1 style = "font-size : 10pt;"><%=cur.getName()%></h1>
				<div>
<%
				List<MainForm.SectionItem> items = cur.getItems();
				for (MainForm.SectionItem curItem: items)
				{
%>
					<p style = "font-size : 10pt;">
						<a href = "" onclick = "MainForm.loadContent('<%=curItem.getUrl()%>'); return false;"><%=curItem.getName()%></a>
					</p>
<%
				}
%>
				</div>
<%
			}
%>
			</div>
		</div>

		<div id = "div-main">
			Main content to be placed here
		</div>
	</body>
</html>
<%
	// We load the first screen by default
%>
<script>
	MainForm.loadContent('<%=firstUrl%>');
</script>