<%@page import="com.tu.lunchy.dao.objects.*"%>
<%@page import="com.tu.lunchy.dao.impl.*"%>
<%@page import="com.tu.lunchy.util.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Lunchy</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='//fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<!----start-header----->
	<div class="header">
		<div class="wrap">
			<div class="top-header">
				<div style="float: left; color: white; padding: 10px 15px;">
					<p
						style="font-size: 35px; font-style: oblique; font-weight: bold; color: darkgoldenrod;">Lunchy.
						Make your life tasty.</p>
				</div>
				<div style="float: right;">
					<form method="post" action="/Lunchy/LogoutServlet">
						<input type="submit" class="mybutton" value="Log out">
					</form>
				</div>

				<div style="float: right; color: wheat; padding: 10px 15px;">
					<h2>
						Welcome,
						<%=SessionUtil.getLoggedInUser(request).getFullName()%>
					</h2>
				</div>
				<div class="clear"></div>
			</div>
			<!---start-top-nav---->
			<div class="top-nav">
				<div class="top-nav-left">
					<ul>
						<%
							User user = SessionUtil.getLoggedInUser(request);
							AccountType userAccountType = AccessUtil.getUserAccess(user.getAccountType());

							if (userAccountType == AccountType.ADMINISTRATOR) {
						%>
						<li><a href="HomePage.jsp">Home</a></li>
						<li class="active"><a href="MenuPage.jsp">Menu</a></li>
						<li><a href="AddUserPage.jsp">Add New User</a></li>
						<%
							} else if (userAccountType == AccountType.RESTAURANT_WORKER) {
						%>
						<li><a href="HomePage.jsp">Home</a></li>
						<li class="active"><a href="MenuPage.jsp">Menu</a></li>
						<li><a href="AddMenuPage.jsp">Add New Menu</a></li>
						<li><a href="AddNewMealPage.jsp">Add New Meal</a></li>
						<li><a href="ShowAllOrders.jsp">Show Orders</a></li>
						<%
							} else if (userAccountType == AccountType.CLIENT) {
						%>
						<li><a href="HomePage.jsp">Home</a></li>
						<li class="active"><a href="MenuPage.jsp">Menu</a></li>
						<li><a href="MyOrdersPage.jsp">My Orders</a></li>
						<%
							}
						%>
					</ul>
				</div>
				<div class="top-nav-right">
					<%
						if (userAccountType == AccountType.CLIENT) {
							Orders userOrders = SessionUtil.getUserOrders(request);
					%>
					<p style="color: white; font-size: 24px;">
						Orders total price:
						<%=userOrders.getOrdersPrice() + " " + Util.APPLICATION_CURRENCY%>
					</p>
					<%
						}
					%>
				</div>
				<div class="clear"></div>
			</div>
			<!---End-top-nav---->
		</div>
	</div>
	<!----End-header----->
	<!---start-content---->
	<!---start-gallery----->
	<div class="gallerys">
		<div class="wrap">
			<h3>MENU</h3>
			<div class="gallery-grids">

				<%
					List<Menu> menus = MenuDaoImpl.getMenus();

					for (Menu menu : menus) {
						for (Meal meal : menu.getMealsForThisMenu()) {
							String mealName = meal.getMealName();
				%>
				<div class="gallery-grid grid2">
					<h2><%=menu.getMenuName()%></h2>
					<br></br> <a href="#"><img src="images/slider1.jpg" alt=""><span><%=meal.getPrice() + " " + Util.APPLICATION_CURRENCY%></span></a>
					<h4><%=meal.getMealName()%></h4>
					<p><%=meal.getDescription()%></p>
					<p>
						Ingredients:
						<%=meal.getIngredients()%></p>

					<%
						if (userAccountType == AccountType.CLIENT) {
					%>
					<div class="gallery-button">
						<form method="post" action="/Lunchy/AddOrderToSessionServlet">
							<input type="hidden" name="mealId" value="<%=meal.getMealId()%>">
							<input type="hidden" name="userId" value="<%=user.getUserId()%>">
							<input type="hidden" name="menuId" value="<%=menu.getMenuId()%>">
							<span><input type="submit" class="mybutton" value="Order"></span>
						</form>
					</div>
					<br></br>
					<%
						}
					%>
				</div>
				<%
					}
					}
				%>
			</div>
		</div>
	</div>
	<!---End-gallery----->
	<!---End-content---->
</body>
</html>

