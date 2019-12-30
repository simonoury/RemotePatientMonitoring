package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <script>\n");
      out.write("        window.onload = function () {\n");
      out.write("\n");
      out.write("            var dps = []; // dataPoints\n");
      out.write("            var chart = new CanvasJS.Chart(\"chartContainer\", {\n");
      out.write("                title :{\n");
      out.write("                    text: \"Dynamic Data\"\n");
      out.write("                },\n");
      out.write("                axisY: {\n");
      out.write("                    includeZero: false\n");
      out.write("                },\n");
      out.write("                data: [{\n");
      out.write("                    type: \"line\",\n");
      out.write("                    dataPoints: dps\n");
      out.write("                }]\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            var xVal = 0;\n");
      out.write("            var yVal = 100;\n");
      out.write("            var updateInterval = 1000;\n");
      out.write("            var dataLength = 20; // number of dataPoints visible at any point\n");
      out.write("\n");
      out.write("            var updateChart = function (count) {\n");
      out.write("\n");
      out.write("                count = count || 1;\n");
      out.write("\n");
      out.write("                for (var j = 0; j < count; j++) {\n");
      out.write("                    yVal = yVal +  Math.round(5 + Math.random() *(-5-5));\n");
      out.write("                    dps.push({\n");
      out.write("                        x: xVal,\n");
      out.write("                        y: yVal\n");
      out.write("                    });\n");
      out.write("                    xVal++;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                if (dps.length > dataLength) {\n");
      out.write("                    dps.shift();\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                chart.render();\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            updateChart(dataLength);\n");
      out.write("            setInterval(function(){updateChart()}, updateInterval);\n");
      out.write("\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div id=\"chartContainer\" style=\"height: 300px; width: 100%;\"></div>\n");
      out.write("<script src=\"https://canvasjs.com/assets/script/canvasjs.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
