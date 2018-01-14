<%@page import="java.util.Currency"%>
<%@page import="com.tu.lunchy.dao.objects.*"%>
<%@page import="com.tu.lunchy.dao.impl.*"%>
<%@page import="com.tu.lunchy.util.*"%>

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
	<!----End-header----->
	<!---start-contact---->
	<div class="contact">
		<div class="wrap">
			<div class="section group">
				<div class="col span_2_of_3">
					<div class="contact-form">
						<h3>Add New Meal</h3>
						<form id="addNewMealForm" method="post"
							action="/Lunchy/AddNewMealServlet">
							<div>
								<span><label>Meal name</label></span> <span><input
									name="mealName" type="text" class="textbox"></span>
							</div>
							<div>
								<span><label>Meal Description</label></span> <span><textarea
										name="description"> </textarea></span>
							</div>
							<div>
								<span><label>Meal Ingredients</label></span> <span><textarea
										name="ingredients"> </textarea></span>
							</div>
							<div>
								<span><label>Meal Price</label></span> <span
									style="display: flex;"><input name="price" type="text"
									class="textbox" style="width: 85%;"> <select
									name="currencySelector" style="width: 15%;">
										<%
											for (String currency : Util.getSupportedCurrencies()) {
										%>
										<%
											if (currency.equalsIgnoreCase(Util.APPLICATION_CURRENCY.toString())) {
										%>
										<option selected="selected"><%=currency%></option>
										<%
											} else {
										%>
										<option><%=currency%></option>
										<%
											}
										%>
										<%
											}
										%>
								</select></span>

							</div>
							<div>
								<span><input type="submit" class="mybutton"
									value="Add Meal"></span>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		function myFunction() {
			document.getElementById("addNewMealForm").reset();
		}
	</script>
	<div class="copy-right">
		<div class="top-to-page">
			<a href="#top" class="scroll"> </a>
			<div class="clear"></div>
		</div>
		<p>© Lunchy. All Rights Reserved | Design by Desislav Hristov</p>
	</div>
	<!---End-footer---->
</body>
</html>