/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M15
 * Generated at: 2018-01-16 20:39:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Currency;
import com.tu.lunchy.dao.objects.*;
import com.tu.lunchy.dao.impl.*;
import com.tu.lunchy.util.*;
import java.util.List;

public final class AddNewMealPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("com.tu.lunchy.util");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.tu.lunchy.dao.objects");
    _jspx_imports_packages.add("com.tu.lunchy.dao.impl");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.Currency");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<style>\r\n");
      out.write("div {\r\n");
      out.write("\tmargin: 20px;\r\n");
      out.write("}\r\n");
      out.write("/* -------------------- Rounded Corners */\r\n");
      out.write(".rounded {\r\n");
      out.write("\t-webkit-border-radius: 20px;\r\n");
      out.write("\t-moz-border-radius: 20px;\r\n");
      out.write("\tborder-radius: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* -------------------- Colors: Background */\r\n");
      out.write(".slate {\r\n");
      out.write("\tbackground-color: #ddd;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".green {\r\n");
      out.write("\tbackground-color: #779126;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".blue {\r\n");
      out.write("\tbackground-color: #3b8ec2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".yellow {\r\n");
      out.write("\tbackground-color: #eec111;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".black {\r\n");
      out.write("\tbackground-color: #000;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* -------------------- Colors: Text */\r\n");
      out.write(".slate select {\r\n");
      out.write("\tcolor: #000;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".green select {\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".blue select {\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".yellow select {\r\n");
      out.write("\tcolor: #000;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".black select {\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* -------------------- Select Box Styles: danielneumann.com Method */\r\n");
      out.write("/* -------------------- Source: http://danielneumann.com/blog/how-to-style-dropdown-with-css-only/ */\r\n");
      out.write("#mainselection select {\r\n");
      out.write("\tborder: 0;\r\n");
      out.write("\tcolor: #EEE;\r\n");
      out.write("\tbackground: transparent;\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tpadding: 2px 10px;\r\n");
      out.write("\twidth: 378px;\r\n");
      out.write("\t*width: 350px;\r\n");
      out.write("\t*background: #58B14C;\r\n");
      out.write("\t-webkit-appearance: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#mainselection {\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\twidth: 350px;\r\n");
      out.write("\t-moz-border-radius: 9px 9px 9px 9px;\r\n");
      out.write("\t-webkit-border-radius: 9px 9px 9px 9px;\r\n");
      out.write("\tborder-radius: 9px 9px 9px 9px;\r\n");
      out.write("\tbox-shadow: 1px 1px 11px #330033;\r\n");
      out.write("\tbackground: #58B14C url(\"http://i62.tinypic.com/15xvbd5.png\") no-repeat\r\n");
      out.write("\t\tscroll 319px center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* -------------------- Select Box Styles: stackoverflow.com Method */\r\n");
      out.write("/* -------------------- Source: http://stackoverflow.com/a/5809186 */\r\n");
      out.write("select#soflow, select#soflow-color {\r\n");
      out.write("\t-webkit-appearance: button;\r\n");
      out.write("\t-webkit-border-radius: 2px;\r\n");
      out.write("\t-webkit-box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.1);\r\n");
      out.write("\t-webkit-padding-end: 20px;\r\n");
      out.write("\t-webkit-padding-start: 0px;\r\n");
      out.write("\t-webkit-user-select: none;\r\n");
      out.write("\tbackground-image: url(http://i62.tinypic.com/15xvbd5.png),\r\n");
      out.write("\t\t-webkit-linear-gradient(#FAFAFA, #F4F4F4 40%, #E5E5E5);\r\n");
      out.write("\tbackground-position: 97% center;\r\n");
      out.write("\tbackground-repeat: no-repeat;\r\n");
      out.write("\tborder: 1px solid #AAA;\r\n");
      out.write("\tcolor: #555;\r\n");
      out.write("\tfont-size: inherit;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\tpadding: 8px 10px;\r\n");
      out.write("\ttext-overflow: ellipsis;\r\n");
      out.write("\twhite-space: nowrap;\r\n");
      out.write("\twidth: 350px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("select#soflow-color {\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\tbackground-image: url(http://i62.tinypic.com/15xvbd5.png),\r\n");
      out.write("\t\t-webkit-linear-gradient(#779126, #779126 40%, #779126);\r\n");
      out.write("\tbackground-color: #779126;\r\n");
      out.write("\t-webkit-border-radius: 20px;\r\n");
      out.write("\t-moz-border-radius: 20px;\r\n");
      out.write("\tborder-radius: 20px;\r\n");
      out.write("\tpadding-left: 15px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<title>Lunchy</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("<link href='//fonts.googleapis.com/css?family=Open+Sans'\r\n");
      out.write("\trel='stylesheet' type='text/css'>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!----start-header----->\r\n");
      out.write("\t<div class=\"header\">\r\n");
      out.write("\t\t<div class=\"wrap\">\r\n");
      out.write("\t\t\t<div class=\"top-header\">\r\n");
      out.write("\t\t\t\t<div style=\"float: left; color: white; padding: 10px 15px;\">\r\n");
      out.write("\t\t\t\t\t<p\r\n");
      out.write("\t\t\t\t\t\tstyle=\"font-size: 35px; font-style: oblique; font-weight: bold; color: darkgoldenrod;\">Lunchy.\r\n");
      out.write("\t\t\t\t\t\tMake your life tasty.</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"float: right;\">\r\n");
      out.write("\t\t\t\t\t<form method=\"post\" action=\"/Lunchy/LogoutServlet\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" class=\"mybutton\" value=\"Log out\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div style=\"float: right; color: wheat; padding: 10px 15px;\">\r\n");
      out.write("\t\t\t\t\t<h2>\r\n");
      out.write("\t\t\t\t\t\tWelcome,\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(SessionUtil.getLoggedInUser(request).getFullName());
      out.write("\r\n");
      out.write("\t\t\t\t\t</h2>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!---start-top-nav---->\r\n");
      out.write("\t\t\t<div class=\"top-nav\">\r\n");
      out.write("\t\t\t\t<div class=\"top-nav-left\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t");

							AccountType userAccountType = AccessUtil
									.getUserAccess(SessionUtil.getLoggedInUser(request).getAccountType());

							if (userAccountType == AccountType.ADMINISTRATOR) {
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"HomePage.jsp\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"MenuPage.jsp\">Menu</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"active\"><a href=\"AddNewMealPage.jsp\">Add New\r\n");
      out.write("\t\t\t\t\t\t\t\tMeal</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"AddNewUserPage.jsp\">Add New User</a></li>\r\n");
      out.write("\t\t\t\t\t\t");

							} else if (userAccountType == AccountType.RESTAURANT_WORKER) {
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"HomePage.jsp\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"MenuPage.jsp\">Menu</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"AddMenuPage.jsp\">Add New Menu</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"active\"><a href=\"AddNewMealPage.jsp\">Add New\r\n");
      out.write("\t\t\t\t\t\t\t\tMeal</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"ShowAllOrders.jsp\">Show Orders</a></li>\r\n");
      out.write("\t\t\t\t\t\t");

							} else if (userAccountType == AccountType.CLIENT) {
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li class=\"active\"><a href=\"HomePage.jsp\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"MenuPage.jsp\">Menu</a></li>\r\n");
      out.write("\t\t\t\t\t\t");

							}
						
      out.write("\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!---End-top-nav---->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!----End-header----->\r\n");
      out.write("\t<!---start-contact---->\r\n");
      out.write("\t<div class=\"contact\">\r\n");
      out.write("\t\t<div class=\"wrap\">\r\n");
      out.write("\t\t\t<div class=\"section group\">\r\n");
      out.write("\t\t\t\t<div class=\"col span_2_of_3\">\r\n");
      out.write("\t\t\t\t\t<div class=\"contact-form\">\r\n");
      out.write("\t\t\t\t\t\t<h3>Add New Meal</h3>\r\n");
      out.write("\t\t\t\t\t\t<form id=\"addNewMealForm\" method=\"post\"\r\n");
      out.write("\t\t\t\t\t\t\taction=\"/Lunchy/AddNewMealServlet\">\r\n");
      out.write("\t\t\t\t\t\t\t<div style=\"float: left;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span><label>Select Menu</label></span> <select name=\"menuName\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"float: left;\" id=\"soflow\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");

										List<Menu> menus = MenuDaoImpl.getMenus();

										for (Menu menu : menus) {
									
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option>");
      out.print(menu.getMenuName());
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");

										}
									
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span><label>Meal name</label></span> <span><input\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"mealName\" type=\"text\" class=\"textbox\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span><label>Meal Description</label></span> <span><textarea\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname=\"description\"> </textarea></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span><label>Meal Ingredients</label></span> <span><textarea\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname=\"ingredients\"> </textarea></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span><label>Meal Price</label></span> <span\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"display: flex;\"><input name=\"price\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"textbox\" style=\"width: 85%;\"> <select\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"currencySelector\" style=\"width: 15%;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");

											for (String currency : Util.getSupportedCurrencies()) {
										
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");

											if (currency.equalsIgnoreCase(Util.APPLICATION_CURRENCY.toString())) {
										
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option selected=\"selected\">");
      out.print(currency);
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");

											} else {
										
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option>");
      out.print(currency);
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");

											}
										
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");

											}
										
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</select></span>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span><input type=\"submit\" class=\"mybutton\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvalue=\"Add Meal\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tfunction myFunction() {\r\n");
      out.write("\t\t\tdocument.getElementById(\"addNewMealForm\").reset();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<div class=\"copy-right\"\r\n");
      out.write("\t\tstyle=\"position: absolute; width: 100%; bottom: 35px\">\r\n");
      out.write("\t\t<div class=\"top-to-page\">\r\n");
      out.write("\t\t\t<a href=\"#top\" class=\"scroll\"> </a>\r\n");
      out.write("\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<p>Lunchy. All Rights Reserved | Design by Desislav Hristov</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!---End-footer---->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
