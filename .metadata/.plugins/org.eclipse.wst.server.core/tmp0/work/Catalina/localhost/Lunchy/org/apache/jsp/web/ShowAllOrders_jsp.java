/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M15
 * Generated at: 2018-01-15 20:48:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.tu.lunchy.dao.objects.*;
import com.tu.lunchy.dao.impl.*;
import com.tu.lunchy.util.*;
import java.util.List;
import java.text.SimpleDateFormat;

public final class ShowAllOrders_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
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
      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Lunchy</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("<link href='//fonts.googleapis.com/css?family=Open+Sans'\r\n");
      out.write("\trel='stylesheet' type='text/css'>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("#orders {\r\n");
      out.write("\tfont-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\r\n");
      out.write("\tborder-collapse: collapse;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#orders td, #customers th {\r\n");
      out.write("\tborder: 2px solid #ddd;\r\n");
      out.write("\tpadding: 8px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#orders tr:nth-child(even) {\r\n");
      out.write("\tbackground-color: #f2f2f2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#orders tr:hover {\r\n");
      out.write("\tbackground-color: #ddd;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#orders th {\r\n");
      out.write("\tpadding-top: 12px;\r\n");
      out.write("\tborder: 2px solid #ddd;\r\n");
      out.write("\tpadding-bottom: 12px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tbackground-color: #afad4c;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!----start-header----->\r\n");
      out.write("\t<div class=\"header\">\r\n");
      out.write("\t\t<div class=\"wrap\">\r\n");
      out.write("\t\t\t<div class=\"top-header\">\r\n");
      out.write("\t\t\t\t<div class=\"logo\">\r\n");
      out.write("\t\t\t\t\t<a href=\"index.html\"><img src=\"images/logo.png\" title=\"logo\" /></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<span><input type=\"submit\" style=\"float: right;\"\r\n");
      out.write("\t\t\t\t\tclass=\"mybutton\" value=\"Log out\"></span>\r\n");
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
      out.write("\t\t\t\t\t\t<li class=\"active\"><a href=\"HomePage.jsp\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"MenuPage.jsp\">Menu</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"AddNewMealPage.jsp\">Add New Meal</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"AddNewUserPage.jsp\">Add New User</a></li>\r\n");
      out.write("\t\t\t\t\t\t");

							} else if (userAccountType == AccountType.RESTAURANT_WORKER) {
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li class=\"active\"><a href=\"HomePage.jsp\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"MenuPage.jsp\">Menu</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"AddNewMealPage.jsp\">Add New Meal</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"ShowAllOrders.jsp\">Show Orders</a></li>\r\n");
      out.write("\t\t\t\t\t\t");

							} else if (userAccountType == AccountType.CLIENT) {
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li class=\"active\"><a href=\"HomePage.jsp\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"MenuPage.jsp\">Menu</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"MyOrdersPage.jsp\">My Orders</a></li>\r\n");
      out.write("\t\t\t\t\t\t");

							}
						
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!---End-top-nav---->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<div class=\"wrap\" style=\"padding: 40px 0px 10px 0px\">\r\n");
      out.write("\t\t\t<table id=\"orders\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>Order Id</th>\r\n");
      out.write("\t\t\t\t\t<th>User</th>\r\n");
      out.write("\t\t\t\t\t<th>Meal</th>\r\n");
      out.write("\t\t\t\t\t<th>Price</th>\r\n");
      out.write("\t\t\t\t\t<th>Order Status</th>\r\n");
      out.write("\t\t\t\t\t<th>Order Time</th>\r\n");
      out.write("\t\t\t\t\t<th>Order For</th>\r\n");
      out.write("\t\t\t\t\t<th>Is ordered for the office</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

					SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm ");

					for (Order order : OrderDaoImpl.getAllOrders()) {
						Meal meal = MealDaoImpl.getMeal(order.getMealId());
				
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(order.getOrderId());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(UserDaoImpl.getUserById(order.getUserId()).getUsername());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(meal.getMealName());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(meal.getPrice() + " " + Util.APPLICATION_CURRENCY);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t");

						String statusColor = "black";
							String orderStatus = order.getOrderStatus();
							String orderStatusToShow = null;

							if (orderStatus.equalsIgnoreCase(OrderStatus.PENDING.toString())) {
								statusColor = "red";
								orderStatusToShow = "NOT PURCHASED";
							} else if (orderStatus.equalsIgnoreCase(OrderStatus.READY.toString())) {
								statusColor = "green";
								orderStatusToShow = OrderStatus.READY.toString();
							} else if (orderStatus.equalsIgnoreCase(OrderStatus.ACCEPTED.toString())) {
								statusColor = "yellow";
								orderStatusToShow = "ORDER IS ACCEPTED";
							} else if (orderStatus.equalsIgnoreCase(OrderStatus.COOKING.toString())) {
								statusColor = "orange";
								orderStatusToShow = OrderStatus.COOKING.toString();
							}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<td style=\"color: ");
      out.print(statusColor);
      out.write("; font-size: 16px;\">");
      out.print(orderStatusToShow);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t");

						if (order.getOrederTime() == null) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<td>Not Selected</td>\r\n");
      out.write("\t\t\t\t\t");

						} else {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(sdf.format(order.getOrederTime()));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t");

						if (order.getOrederedForTime() == null) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<td>Not Selected</td>\r\n");
      out.write("\t\t\t\t\t");

						} else {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(sdf.format(order.getOrederedForTime()));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t");

						if (order.isOrderedForTheOffice()) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<td>YES</td>\r\n");
      out.write("\t\t\t\t\t");

						
					
      out.write("\r\n");
      out.write("\t\t\t\t\t");

						} else {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<td>NO</td>\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"copy-right\" style=\"position: absolute; width:100%; bottom:35px\">\r\n");
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
