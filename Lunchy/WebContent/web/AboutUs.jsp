<%@page import="com.tu.lunchy.dao.objects.*"%>
<%@page import="com.tu.lunchy.dao.impl.*"%>
<%@page import="com.tu.lunchy.util.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Multicusine a Hotels and Restaurants Category Website
	Template | Contact :: W3layouts</title>
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
						<li><a href="MenuPage.jsp">Menu</a></li>
						<li><a href="AddNewMealPage.jsp">Add New Meal</a></li>
						<li><a href="AddNewUserPage.jsp">Add New User</a></li>
						<%
							} else if (userAccountType == AccountType.RESTAURANT_WORKER) {
						%>
						<li><a href="HomePage.jsp">Home</a></li>
						<li><a href="MenuPage.jsp">Menu</a></li>
						<li><a href="AddMenuPage.jsp">Add New Menu</a></li>
						<li><a href="AddNewMealPage.jsp">Add New Meal</a></li>
						<li><a href="ShowAllOrders.jsp">Show Orders</a></li>
						<%
							} else if (userAccountType == AccountType.CLIENT) {
						%>
						<li><a href="HomePage.jsp">Home</a></li>
						<li><a href="MenuPage.jsp">Menu</a></li>
						<li><a href="MyOrdersPage.jsp">My Orders</a></li>
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
	<!---start-content---->
	<div class="content">
		<!---start-contact---->
		<div class="contact">
			<div class="wrap">
				<div class="section group">
					<div class="col span_1_of_3">
						<div class="contact_info">
							<h3>Find Us Here</h3>
							<div class="map">
								<iframe width="100%" height="175" frameborder="0" scrolling="no"
									marginheight="0" marginwidth="0"
									src="https://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265&amp;output=embed"></iframe>
								<br> <small><a
									href="https://maps.google.co.in/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265"
									style="color: #666; text-align: left; font-size: 0.85em">View
										Larger Map</a></small>
							</div>
						</div>
						<div class="company_address">
							<h3>Information :</h3>
							<p>Address: street "Angel Kunchev" 11, 1000 Center, Sofia</p>
							<p>Bulgaria</p>
							<p>Phone:(00) 222 666 444</p>
							<p>
								Email: <span><a href="mailto:info@example.com">lunchy@gmail.com</a></span>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="copy-right"
		style="position: absolute; width: 100%; bottom: 35px">
		<div class="top-to-page">
			<a href="#top" class="scroll"> </a>
			<div class="clear"></div>
		</div>
		<p>Lunchy. All Rights Reserved | Design by Desislav Hristov</p>
	</div>
	<!---End-footer---->
</body>
</html>