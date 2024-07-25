<%@page import="util.StringUtils"%>
<%@page import="model.PlayerModel"%>
<%@page import="model.CoachModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/HomePage.css" />

<title>YourCricMentor</title>

<%
// Get the session and request objects
HttpSession playerSession = request.getSession();
String currentPlayer = (String) playerSession.getAttribute(StringUtils.PLAYER_USERNAME_ID);
String contextPath = request.getContextPath();
%>


</head>

<body>
	<jsp:include page="<%=StringUtils.PAGE_URL_LOGGED_HEADER_PLAYER%>" />


	<%
	String userSession = (String) session.getAttribute(StringUtils.PLAYER_USERNAME_ID);

	String cookieUsername = null;
	String cookieSessionID = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(StringUtils.PLAYER))
		cookieUsername = cookie.getValue();
			if (cookie.getName().equals(StringUtils.JSESSIONID))
		cookieSessionID = cookie.getValue();
		}
	}
	%>


	<header class="section__container header__container">
		<div class="header__content">
			<span class="bg__blur"></span> <span class="bg__blur header__blur"></span>
			<h4>BEST CRICKET MENTOR IN THE TOWN</h4>
			<h1>
				HELLO PLAYER <span><%=cookieUsername%></span> WELCOME TO
				YourCricMentor!
			</h1>

		</div>
		<div class="header__image">
			<a href=""><img
				src="${pageContext.request.contextPath}/resources/images/other/Display.png" /></a>
		</div>
	</header>


	<section class="section__container class__container">
		<div class="class__image">
			<span class="bg__blur"></span> <a href=""><img
				src="${pageContext.request.contextPath}/resources/images/other/Display2.png"
				class="class__img-1" /></a> <a href=""><img
				src="${pageContext.request.contextPath}/resources/images/other/Display3.png"
				class="class__img-2" /></a>
		</div>
		<div class="class__content">
			<h2 class="section__header">
				SO WHAT IS <span>YourCricMentor</span> ?
			</h2>
			<p>YourCricMentor is a specialized platform for cricket players,
				coaches, and academies nationwide. It manages and showcase players'
				performance data from tests, exams, and matches. Coaches have
				exclusive access to evaluate and manage player records, while
				players can view their own results. The platform also offers
				valuable tips and test for the playres to enhance their cricket
				skills.</p>

		</div>
	</section>



	<section class="section__container explore__container">
		<h2 class="section__header">Our Top Coaches</h2>

		<div class="explore__grid">
			<c:if test="${empty coachLists}">
				<p>Be the First Coach to be listed</p>
			</c:if>
			<c:if test="${not empty coachLists}">
				<c:forEach var="coach" items="${coachLists}" varStatus="loop">
					<c:if test="${loop.index < 4}">
						<div class="explore__card">
							<div class="card">
								<img
									src="${pageContext.request.contextPath}/resources/images/Coach/${coach.imageUrlFromPart}"
									class="card-img-top" alt="...">
								<div class="card-body">
									<h4 class="card-title">${coach.coach_FirstName}
										${coach.coach_LastName}</h4>
									<h5 class="card-text">${coach.coach_Type}</h5>
								</div>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</c:if>
		</div>
	</section>


	<!-- Slider HTML -->
	<div class="slider">
		<div class="slides">
			<!-- Radio buttons -->
			<input type="radio" name="radio-btn" id="radio1"> <input
				type="radio" name="radio-btn" id="radio2"> <input
				type="radio" name="radio-btn" id="radio3"> <input
				type="radio" name="radio-btn" id="radio4">
			<!-- Slide images -->
			<div class="slide first">
				<a href=""><img
					src="${pageContext.request.contextPath}/resources/images/other/SliderImage1.jpg" /></a>
			</div>
			<div class="slide">
				<a href=""><img
					src="${pageContext.request.contextPath}/resources/images/other/SliderImage2.jpg" /></a>
			</div>
			<div class="slide">
				<a href=""><img
					src="${pageContext.request.contextPath}/resources/images/other/SliderImage3.jpg" /></a>
			</div>
			<div class="slide">
				<a href=""><img
					src="${pageContext.request.contextPath}/resources/images/other/SliderImage4.jpg" /></a>
			</div>
		</div>
		<!-- Manual navigation -->
		<div class="navigation-manual">
			<label for="radio1" class="manual-btn"></label> <label for="radio2"
				class="manual-btn"></label> <label for="radio3" class="manual-btn"></label>
			<label for="radio4" class="manual-btn"></label>
		</div>
	</div>

	<!-- Slider JavaScript -->
	<script type="text/javascript">
		var counter = 1;
		setInterval(function() {
			document.getElementById('radio' + counter).checked = true;
			counter++;
			if (counter > 4) {
				counter = 1;
			}
		}, 3000);
	</script>





	<section class="section__container explore__container">
		<h2 class="section__header">Our Top Players</h2>

		<div class="explore__grid">
			<c:if test="${empty playerLists}">
				<p>Be the First Player to be listed</p>
			</c:if>
			<c:if test="${not empty playerLists}">
				<c:forEach var="player" items="${playerLists}" varStatus="loop">
					<c:if test="${loop.index < 4}">
						<div class="explore__card">
							<div class="card">
								<img
									src="${pageContext.request.contextPath}/resources/images/Player/${player.imageUrlFromPart}"
									class="card-img-top" alt="...">
								<div class="card-body">
									<h4 class="card-title">${player.player_FirstName}
										${player.player_LastName}</h4>
									<h5 class="card-text">${player.player_Email}</h5>
								</div>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</c:if>
		</div>
	</section>




</body>

</html>