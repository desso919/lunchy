<%@page import="com.tu.lunchy.dao.objects.*"%>
<%@page import="com.tu.lunchy.dao.impl.*"%>
<%@page import="com.tu.lunchy.util.*"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>

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

<style>
#orders {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#orders td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#orders tr:nth-child(even) {
	background-color: #f2f2f2;
}

#orders tr:hover {
	background-color: #ddd;
}

#orders th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #afad4c;
	color: white;
}
</style>
</head>
<body>
	<!----start-header----->
	<div class="header">
		<div class="wrap">
			<div class="top-header">
				<div class="logo">
					<a href="index.html"><img src="images/logo.png" title="logo" /></a>
				</div>
				<div class="clear"></div>
			</div>
			<!---start-top-nav---->
			<div class="top-nav">
				<div class="top-nav-left">
					<ul>
						<%
							AccountType userAccountType = AccessUtil
									.getUserAccess(SessionUtil.getLoggedInUser(request).getAccountType());

							if (userAccountType == AccountType.ADMINISTRATOR) {
						%>
						<li class="active"><a href="HomePage.jsp">Home</a></li>
						<li><a href="MenuPage.jsp">Menu</a></li>
						<li><a href="AddNewMealPage.jsp">Add New Meal</a></li>
						<li><a href="AddNewUserPage.jsp">Add New User</a></li>
						<%
							} else if (userAccountType == AccountType.RESTAURANT_WORKER) {
						%>
						<li class="active"><a href="HomePage.jsp">Home</a></li>
						<li><a href="MenuPage.jsp">Menu</a></li>
						<li><a href="AddNewMealPage.jsp">Add New Meal</a></li>
						<li><a href="ShowAllOrders.jsp">Show Orders</a></li>
						<%
							} else if (userAccountType == AccountType.CLIENT) {
						%>
						<li class="active"><a href="HomePage.jsp">Home</a></li>
						<li><a href="MenuPage.jsp">Menu</a></li>
						<%
							}
						%>

					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<!---End-top-nav---->
		</div>
	</div>

	<div>
		<div class="wrap">
			<table id="orders">
				<tr>
					<th>Order Id</th>
					<th>User</th>
					<th>Menu</th>
					<th>Meal</th>
					<th>Order Status</th>
					<th>Order Time</th>
					<th>Order For</th>
					<th>Is ordered for the office</th>
				</tr>
				<%
				   SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm ");
							
					List<Order> orders = OrderDaoImpl.getAllOrders();
					for (Order order : orders) {
						User user = UserDaoImpl.getUserById(order.getUserId());
						Meal meal = MealDaoImpl.getMeal(order.getMealId());
				%>
				<tr>
					<td><%=order.getOrderId()%></td>
					<td><%=user.getUsername()%></td>
					<td><%=order.getMenuId()%></td>
					<td><%=meal.getMealName()%></td>
					<td><%=order.getOrderStatus()%></td>
					<td><%=sdf.format(order.getOrederTime())%></td>
					<td><%=sdf.format(order.getOrederedForTime())%></td>
					<td><%=order.isOrderedForTheOffice()%></td>
				</tr>
				<%
					}
				%>

			</table>
		</div>
	</div>

	<div class="copy-right">
		<div class="top-to-page">
			<a href="#top" class="scroll"> </a>
			<div class="clear"></div>
		</div>
		<p>� Lunchy. All Rights Reserved | Design by Desislav Hristov</p>
	</div>
	<!---End-footer---->
</body>
</html>