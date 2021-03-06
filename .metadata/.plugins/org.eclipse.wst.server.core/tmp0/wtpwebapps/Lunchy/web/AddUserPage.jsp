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
<style>
div {
	margin: 20px;
}
/* -------------------- Rounded Corners */
.rounded {
	-webkit-border-radius: 20px;
	-moz-border-radius: 20px;
	border-radius: 20px;
}

/* -------------------- Colors: Background */
.slate {
	background-color: #ddd;
}

.green {
	background-color: #779126;
}

.blue {
	background-color: #3b8ec2;
}

.yellow {
	background-color: #eec111;
}

.black {
	background-color: #000;
}

/* -------------------- Colors: Text */
.slate select {
	color: #000;
}

.green select {
	color: #fff;
}

.blue select {
	color: #fff;
}

.yellow select {
	color: #000;
}

.black select {
	color: #fff;
}

/* -------------------- Select Box Styles: danielneumann.com Method */
/* -------------------- Source: http://danielneumann.com/blog/how-to-style-dropdown-with-css-only/ */
#mainselection select {
	border: 0;
	color: #EEE;
	background: transparent;
	font-size: 20px;
	font-weight: bold;
	padding: 2px 10px;
	width: 378px;
	*width: 350px;
	*background: #58B14C;
	-webkit-appearance: none;
}

#mainselection {
	overflow: hidden;
	width: 350px;
	-moz-border-radius: 9px 9px 9px 9px;
	-webkit-border-radius: 9px 9px 9px 9px;
	border-radius: 9px 9px 9px 9px;
	box-shadow: 1px 1px 11px #330033;
	background: #58B14C url("http://i62.tinypic.com/15xvbd5.png") no-repeat
		scroll 319px center;
}

/* -------------------- Select Box Styles: stackoverflow.com Method */
/* -------------------- Source: http://stackoverflow.com/a/5809186 */
select#soflow, select#soflow-color {
	-webkit-appearance: button;
	-webkit-border-radius: 2px;
	-webkit-box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.1);
	-webkit-padding-end: 20px;
	-webkit-padding-start: 0px;
	-webkit-user-select: none;
	background-image: url(http://i62.tinypic.com/15xvbd5.png),
		-webkit-linear-gradient(#FAFAFA, #F4F4F4 40%, #E5E5E5);
	background-position: 97% center;
	background-repeat: no-repeat;
	border: 1px solid #AAA;
	color: #555;
	font-size: inherit;
	margin: 0px;
	overflow: hidden;
	padding: 8px 10px;
	text-overflow: ellipsis;
	white-space: nowrap;
	width: 350px;
}

select#soflow-color {
	color: #fff;
	background-image: url(http://i62.tinypic.com/15xvbd5.png),
		-webkit-linear-gradient(#779126, #779126 40%, #779126);
	background-color: #779126;
	-webkit-border-radius: 20px;
	-moz-border-radius: 20px;
	border-radius: 20px;
	padding-left: 15px;
}
</style>
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
							AccountType userAccountType = AccessUtil
									.getUserAccess(SessionUtil.getLoggedInUser(request).getAccountType());

							if (userAccountType == AccountType.ADMINISTRATOR) {
						%>
						<li><a href="HomePage.jsp">Home</a></li>
						<li><a href="MenuPage.jsp">Menu</a></li>
						<li class="active"><a href="AddNewUserPage.jsp">Add New
								User</a></li>
						<%
							} else if (userAccountType == AccountType.RESTAURANT_WORKER) {
						%>
						<li><a href="HomePage.jsp">Home</a></li>
						<li><a href="MenuPage.jsp">Menu</a></li>
						<li><a href="AddMenuPage.jsp">Add New Menu</a></li>
						<li class="active"><a href="AddNewMealPage.jsp">Add New
								Meal</a></li>
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
						<h3>Add New User</h3>
						<form id="addNewUserForm" method="post"
							action="/Lunchy/AddUserServlet">
							<div style="float: left;">
								<span><label>Select Account Type</label></span> <select
									name="accountType" style="float: left;" id="soflow">
									<option>Adminitrator</option>
									<option>Restaurant Employee</option>
									<option>Client</option>
								</select>
							</div>
							<div class="clear"></div>
							<div>
								<span><label>Username</label></span> <span><input
									name="userName" type="text" class="textbox"></span>
							</div>

							<div>
								<span><label>First Name</label></span> <span><input
									name="firstName" type="text" class="textbox"></span>
							</div>
							<div>
								<span><label>Last Name</label></span> <span><input
									name="lastName" type="text" class="textbox"></span>
							</div>
							<div>
								<span><label>Initial Password</label></span> <span><input
									name="password" type="text" class="textbox"></span>
							</div>
							<br></br>
							<div>
								<span><input type="submit" class="mybutton"
									value="Add User"></span>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		function myFunction() {
			document.getElementById("addNewUserForm").reset();
		}
	</script>
	<!---End-footer
	<div class="copy-right"
		style="position: absolute; width: 100%; bottom: 35px">
		<div class="top-to-page">
			<a href="#top" class="scroll"> </a>
			<div class="clear"></div>
		</div>
		<p>Lunchy. All Rights Reserved | Design by Desislav Hristov</p>
	</div>
	---->
</body>
</html>