<%@page import="util.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
String contextPath = request.getContextPath();
String errMsg = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
String successMsg = (String) request.getAttribute(StringUtils.MESSAGE_SUCCESS);
String username = (String) request.getAttribute(StringUtils.PLAYER_USERNAME_ID);
String successParam = request.getParameter(StringUtils.SUCCESS);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8	">
<meta name="viewport" content="width-device-width, initial-scale-1.0">


<title>Log In Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/LoginPage.css" />


</head>

<body>
	<div class="login-box">
		<h2>Log In For User</h2>
		<form action="<%=contextPath + StringUtils.SERVLET_URL_LOGIN_PLAYER%>"
			method="post">
			<div class="user-box">
				<input type="text" id="username" name="player_ID"
					placeholder="Username"
					value="<%if (username != null && !username.isBlank()) {
	out.println(username);
}%>"
					required />
			</div>

			<div class="user-box">
				<input type="password" id="pwd" name="Player_Password"
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
						href="<%=contextPath + StringUtils.PAGE_URL_LOGIN_COACH%>">Switch
						to Coach login</a>
				</p>
			</div>



			<button type="submit" class="submit">
				<span></span> <span></span> <span></span> <span></span> LOGIN
			</button>



			<div class="sign-up">
				<p>
					Don't have an account? <a class="sign-up-link"
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