<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>About Us Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/AboutUs.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/NewFile.css" />
</head>
<body>

	<nav class="navbar">
		<div class="navbar-container container">
			<input type="checkbox" name="" id="">
			<div class="hamburger-lines">
				<span class="line line1"></span> <span class="line line2"></span> <span
					class="line line3"></span>
			</div>
			<ul class="menu-items">
				<li><a href="HomePage.jsp">Home</a></li>
				<li><a href="/AboutUs.jsp">About Us</a></li>
				<li><a href="/LoginPage.jsp">Login</a></li>
				<li><a href="/Register.jsp">Register</a></li>
			</ul>

			<h1 class="logo">YourCricMentor</h1>
		</div>
	</nav>



	<section id="aboutUs">
		<a href=""><img
			src="${pageContext.request.contextPath}/resources/images/other/aboutuspage.png" /></a>
		<div class="content">
			<h2>About Us</h2>

			<p class="description">YourCricMentor is a specialized platform
				for cricket players, coaches, and academies nationwide. It provides
				comprehensive tools for managing and showcasing performance data,
				with coaches having exclusive access to player records. Players can
				track their progress while accessing valuable tips to enhance their
				cricket skills. Join us to redefine cricket excellence together.</p>

		</div>
	</section>


</body>
</html>


