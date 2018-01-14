<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.tu.lunchy.dao.objects.*"%>
<%@page import="com.tu.lunchy.dao.impl.*"%>
<%@page import="com.tu.lunchy.util.*"%>
<%@page import="java.util.Currency"%>
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

<script>
	function setOrderForOffice() {
		var isChecked = document.getElementById("isForTheOfficeCheckBox").checked;
		document.getElementById("isForTheOffice").innerHTML = isChecked;
	}
</script>
<style>
#orders {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#orders td, #customers th {
	border: 2px solid #ddd;
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
	border: 2px solid #ddd;
	padding-bottom: 12px;
	text-align: center;
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
							User user = SessionUtil.getLoggedInUser(request);
							AccountType userAccountType = AccessUtil.getUserAccess(user.getAccountType());

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
						<li><a href="MyOrdersPage.jsp">My Orders</a></li>
						<%
							}
						%>
					</ul>
				</div>
				<div class="top-nav-right">
					<%
						Orders userOrders = SessionUtil.getUserOrders(request);
					%>
					<p style="color: white; font-size: 24px;">
						Orders total price:
						<%=userOrders.getOrdersPrice() + " " + Util.APPLICATION_CURRENCY%>
					</p>
				</div>
				<div class="clear"></div>
			</div>
			<!---End-top-nav---->
		</div>
	</div>


	<div class="wrap" style="padding: 40px 0px 10px 0px">
		<table id="orders">
			<tr>
				<th>Menu</th>
				<th>Meal</th>
				<th>Meal price</th>
				<th>Order status</th>
				<th>Order for time</th>
				<th>Order for the office</th>		
				<th> </th>	
			</tr>
			<%
				SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm ");

				for (Order order : userOrders.getOrders()) {
					Meal meal = MealDaoImpl.getMeal(order.getMealId());
			%>
			<tr>
				<td><%=order.getMenuName()%></td>
				<td><%=meal.getMealName()%></td>
				<td><%=meal.getPrice() + " " + Util.APPLICATION_CURRENCY%></td>
				<%
				String statusColor ="black";	
				String orderStatus = order.getOrderStatus();
				String orderStatusToShow = null;
				
				if(orderStatus.equalsIgnoreCase(OrderStatus.PENDING.toString())) {
					statusColor = "red";
					orderStatusToShow = "NOT PURCHASED";
				} else if(orderStatus.equalsIgnoreCase(OrderStatus.READY.toString())) {
					statusColor = "green";
					orderStatusToShow = OrderStatus.READY.toString();
				} else if(orderStatus.equalsIgnoreCase(OrderStatus.ACCEPTED.toString())) {
					statusColor = "yellow";
					orderStatusToShow = "ORDER IS ACCEPTED";
				} else if(orderStatus.equalsIgnoreCase(OrderStatus.COOKING.toString())) {
						statusColor = "orange";
						orderStatusToShow = OrderStatus.COOKING.toString();
				}
				%>
				<td style="color: <%=statusColor%>; font-size: 16px;"><%=orderStatusToShow%></td>
				<%
					if (order.getOrederedForTime() == null) {
				%>
				<td><form method="post"
						action="/Lunchy/UpdateOrderedForTimeServlet">
						<input type="hidden" name="orderId"
							value="<%=order.getOrderId()%>"> <input type="hidden"
							id="isForTheOffice"> <input type="time"
							name="orderForTime"> <input type="submit" value="SET">
					</form></td>
				<%
					
				%>
				<%
					} else {
				%>
				<td><%=sdf.format(order.getOrederedForTime())%></td>
				<%
					}
				%>
				<%
					if (order.isOrderedForTheOffice()) {
				%>
				<td>YES</td>
				<%
					
				%>
				<%
					} else {
				%>
				<td><form method="post"
						action="/Lunchy/UpdateIsForTheOfficeServlet">
						<input type="hidden" name="orderId"
							value="<%=order.getOrderId()%>"> <input type="checkbox"
							name="isOrderedForTheOffice"
							onclick="if(this.checked){this.form.submit()}"> Yes
					</form></td>
				<%
					}
				%>
				<td>
					<form method="post" action="/Lunchy/AddOrderServlet">
						<input style="color: red;" type="submit" value="Remove">
					</form>
				</td>
			</tr>
			<%
				}
			%>

		</table>


		<div style="padding: 50px 0px 10px 0px">
			<form method="post" action="/Lunchy/AddOrderServlet">
				<input type="submit" class="mybutton" value="Order Now">
			</form>
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