<%@page import="util.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
String contextPath = request.getContextPath();
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">



<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/Register.css" />



<title>Register Page</title>
</head>

<body>
	<div class="container" id="container">

		<div class="form-container sign-up-container">
			<form action="<%=contextPath%>/RegisterCoachServlet" method="post"
				enctype="multipart/form-data">
				<h1 id="title">Create Account for a coach</h1>

				<label for="name" id="name-label">Username <input
					type="text" id="name" name="Coach_ID" placeholder="Ram@11" required>
				</label> <label for="password" id="name-label">Password <input
					type="password" id="password" name="Coach_password" required>
				</label> <label for="password" id="name-label">Retype Password <input
					type="password" id="password" name="Coach_password_retype" required>
				</label> <label for="name" id="name-label">First Name <input
					type="text" id="name" name="Coach_FirstName" placeholder="Ram"
					required>
				</label> <label for="name" id="name-label">Last Name <input
					type="text" id="name" name="Coach_LastName" placeholder="Bahadur"
					required>
				</label> <label for="Experience" id="Experience">Total Experience(in
					years) <input type="number" id="experience"
					name="Total_Experience(in years)" placeholder="2" required>
				</label> <label for="PhoneNumber" id="number-label">Phone Number <input
					type="text" id="PhoneNumber" name="Coach_PhoneNumber"
					placeholder="9877211233" required>
				</label> <label for="cert-level" id="cert-level"> Type: <select
					id="dropdown" name="Coach_Type">
						<option value="Bowling Coach">Bowling Coach</option>
						<option value="Batting Coach">Batting Coach</option>
						<option value="Fielding Coach">Fielding Coach</option>
						<option value="Fitness Coach">Fitness Coach</option>
				</select>
				</label> <label for="email" id="email-label">Email <input
					type="text" id="PhoneNumber" name="Coach_Email"
					placeholder="iliketurtles@turtleclub.com" required>
				</label> <label class="header">Profile Photo:</label> <input id="image"
					type="file" name="Coach_image" placeholder="Photo" accept="image/*">


				<button type="submit">Submit</button>
			</form>

			<!-- messages -->

			<%
		String errMsg = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
		String successMsg = (String) request.getAttribute(StringUtils.MESSAGE_SUCCESS);

		if (errMsg != null) {
			// print
		%>
			<h4 class="error-msg">
				<%
			out.println(errMsg);
			%>
			</h4>
			<%
		}

		if (successMsg != null) {
		// print
		%>
			<h4 class="success-msg">
				<%
			out.println(successMsg);
			%>
			</h4>
			<%
		}
		%>

		</div>

		<div class="form-container sign-in-container">


			<form action="<%=contextPath%>/registerplayers" method="post"
				enctype="multipart/form-data">
				<h1 id="title">Create Account for a Player</h1>
				<label for="username" id="name-label">Username <input
					type="text" id="name" name="player_ID" placeholder="Ram@11"
					required>
				</label> <label for="password" id="password-label">Password <input
					type="password" id="password" name="Player_Password" required>
				</label> <label for="password" id="password-label">Retype Password <input
					type="password" id="password" name="RetypePlayer_Password" required>
				</label> <label for="name" id="firstname-label">First Name <input
					type="text" id="name" name="Player_FirstName" placeholder="Ram"
					required>
				</label> <label for="lastname" id="lastname-label">Last Name <input
					type="text" id="name" name="Player_LastName" placeholder="Bahadur"
					required>
				</label> <label for="email" id="email-label">Email Address <input
					type="email" id="email" name="Player_Email"
					placeholder="iliketurtles@turtleclub.com" required>
				</label> <label for="Address" id="address-label">Address <input
					type="text" id="name" name="Player_Address" placeholder="Kalanki"
					required>
				</label> <label for="PhoneNumber" id="number-label">Phone Number <input
					type="text" id="name" name="Player_PhoneNum"
					placeholder="9866072017" required>
				</label> <label for="cert-level" id="cert-level"> Role: <select
					id="dropdown" name="Player_Role">
						<option value="Pure Batsman">Pure Batsman</option>
						<option value="Pure Bowler">Pure Bowler</option>
						<option value="Batting Allrounder">Batting Allrounder</option>
						<option value="Bowling Allrounder">Bowling Allrounder</option>
				</select>
				</label> <label for="dob" id="dob">Date of Birth <input type="date"
					id="dob" name="Player_date_of_birth">
				</label> <label class="header">Profile Photo:</label> <input id="image"
					type="file" name="Player_Image" placeholder="Photo" accept="image/*">


				<button type="submit">Submit</button>
			</form>


			<%
		String errMsgPlayer = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
		String successMsgPlayer = (String) request.getAttribute(StringUtils.MESSAGE_SUCCESS);

		if (errMsgPlayer != null) {
			// print
		%>
			<h4 class="error-msg">
				<%
			out.println(errMsgPlayer);
			%>
			</h4>
			<%
		}

		if (successMsgPlayer != null) {
		// print
		%>
			<h4 class="success-msg">
				<%
			out.println(successMsgPlayer);
			%>
			</h4>
			<%
		}
		%>



		</div>

		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1 id="title">Hello! If you are registering for Player</h1>
					<p>Press the button bellow</p>

					<button class="ghost" id="signIn">Sign Up</button>
				</div>


				<div class="overlay-panel overlay-right">
					<h1 id="title">Hello! If you are registering for coach</h1>
					<p>Press the button bellow</p>

					<button class="ghost" id="signUp">Sign Up</button>
				</div>
			</div>
		</div>
	</div>

<script>

const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});
</script>
</body>


</html>