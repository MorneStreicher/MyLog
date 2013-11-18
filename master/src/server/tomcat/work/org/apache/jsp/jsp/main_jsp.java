package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.mylog.ui.*;
import java.util.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=iso-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>Morne Test - Main</title>\r\n");
      out.write("\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../lib/jquery/jquery-ui.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../css/common.css\">\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"../lib/jquery/jquery-1.9.1.js\"></script>\r\n");
      out.write("\t<script src=\"../lib/jquery/jquery-ui.js\"></script>\r\n");
      out.write("\t<script src=\"../js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<style>\r\n");
      out.write("\t\t<style type=text/css>\r\n");
      out.write("\t\t\tdiv.ui-accordion-content {\r\n");
      out.write("\t\t\t\tfont-size : 10pt;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$( \"#accordion\" ).accordion({\r\n");
      out.write("\t\t\t\theightStyle: \"fill\"\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("\t<body id = \"main-body\">\r\n");
      out.write("\t\t<div id = \"div-logo\" style = \"text-align: center\">\r\n");
      out.write("\t\t\t<img src = \"../images/logo/mylog_topleft_logo.jpg\" width = \"120px\" height = \"76px\"/>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id = \"div-header\">\r\n");
      out.write("\t\t\t<table border = 0 width = \"100%\" height = \"100%\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"200px\"><span style = \"font-size: 40pt; color: #AAAAAA;\">My Log</span></td>\r\n");
      out.write("\t\t\t\t\t<td style = \"vertical-align:bottom\">\r\n");
      out.write("\t\t\t\t\t\t<span style = \"font-size: 14pt; color: #909090; vertical-align:bottom\">\r\n");
      out.write("\t\t\t\t\t\t\tAn online application for all your logging requirements\r\n");
      out.write("\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id = \"div-left\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id=\"accordion\">\r\n");

			MainForm mainForm = new MainForm (request);
			List<MainForm.Section> sections = mainForm.getSections();
			String firstUrl = sections.get(0).getItems().get(0).getUrl();
			for (MainForm.Section cur: sections)
			{

      out.write("\r\n");
      out.write("\t\t\t\t<h1 style = \"font-size : 10pt;\">");
      out.print(cur.getName());
      out.write("</h1>\r\n");
      out.write("\t\t\t\t<div>\r\n");

				List<MainForm.SectionItem> items = cur.getItems();
				for (MainForm.SectionItem curItem: items)
				{

      out.write("\r\n");
      out.write("\t\t\t\t\t<p style = \"font-size : 10pt;\">\r\n");
      out.write("\t\t\t\t\t\t<a href = \"\" onclick = \"MainForm.loadContent('");
      out.print(curItem.getUrl());
      out.write("'); return false;\">");
      out.print(curItem.getName());
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t</p>\r\n");

				}

      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");

			}

      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id = \"div-main\">\r\n");
      out.write("\t\t\tMain content to be placed here\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");

	// We load the first screen by default

      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tMainForm.loadContent('");
      out.print(firstUrl);
      out.write("');\r\n");
      out.write("</script>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
