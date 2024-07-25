<%@page import="util.StringUtils"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
String contextPath = request.getContextPath();
String errMsg = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
String successMsg = (String) request.getAttribute(StringUtils.MESSAGE_SUCCESS);
String username_coach = (String) request.getAttribute(StringUtils.COACH_USERNAME_ID);
String successParam = request.getParameter(StringUtils.SUCCESS);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Log In Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/LoginPage.css" />

</head>
<body>


	<div class="login-box">
		<h2>Log In For Coach</h2>
		<form action="<%=contextPath + StringUtils.SERVLET_URL_LOGIN_COACH%>"
			method="post">
			<div class="user-box">
				<input type="text" id="username" name="Coach_ID"
					placeholder="Username"
					value="<%if (username_coach != null && !username_coach.isBlank()) {
	out.println(username_coach);
}%>"
					required />
			</div>

			<div class="user-box">
				<input type="password" id="pwd" name="Coach_password"
					placeholder="Password" required />
			</div>

			<div class="forgot-password">
				<p>
					<a class="forgot-password-link"
						href="<%=contextPath + StringUtils.PAGE_URL_REGISTER%>">forgot
						password?</a>
				</p>
			</div>

			<div class="forgot-password">
				<p>
					<a class="forgot-password-link"
						href="<%=contextPath + StringUtils.PAGE_URL_LOGIN_PLAYER%>">Switch
						to Player login</a>
				</p>
			</div>



			<button type="submit" class="submit">
				<span></span> <span></span> <span></span> <span></span> LOGIN
			</button>



			<div class="sign-up">
				<p>
					Don't have an account? <a class="sign-up-link" target="_blank"
						href="<%=contextPath + StringUtils.PAGE_URL_REGISTER%>"><strong>Sign
							Up</strong></a>
				</p>
			</div>
		</form>

		<%
		if (errMsg != null) {
		%>
		<p class="error-msg">
			<%
			out.println(errMsg);
			%>
		</p>
		<%
		}

		if (successParam != null && successParam.equals(StringUtils.TRUE)) {
		%>
		<h2 class="success-msg">Registration Successful!</h2>
		<%
		}
		%>

	</div>


</body>
</html>