<%@page import="util.StringUtils"%>
<%@page import="model.CoachModel"%>
<%@page import="model.PlayerModel"%>
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
<title>Coach Dash Board</title>



<style>
.upload{
  width: 100px;
  position: relative;
  margin: auto;
}

.upload img{
  border-radius: 50%;
  border: 6px solid #eaeaea;
}

.upload .round{
  position: absolute;
  bottom: 0;
  right: 0;
  background: #00B4FF;
  width: 32px;
  height: 32px;
  line-height: 33px;
  text-align: center;
  border-radius: 50%;
  overflow: hidden;
}

.upload .round input[type = "file"]{
  position: absolute;
  transform: scale(2);
  opacity: 0;
}

input[type=file]::-webkit-file-upload-button{
    cursor: pointer;
}

</style>


<%
// Get the session and request objects
HttpSession coachSession = request.getSession();
String currentCoach = (String) coachSession.getAttribute(StringUtils.COACH_USERNAME_ID);
String contextPath = request.getContextPath();
%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/UserDashBoard.css" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/NewFile.css" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/UserProfile.css" />


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>


<body>

	<jsp:include page="<%=StringUtils.PAGE_URL_LOGGED_HEADER_COACH%>" />
	<br>
	<br>

	<div class="container">
		<div class="sidebar">
			<h2>Coach Dashboard</h2>
			<br> <br> <br>

			<c:if test="${not empty coachImageData}">
				<img
					src="${pageContext.request.contextPath}/resources/images/Coach/${coachImageData}"
					class="card-img-top rounded-image" alt="...">
			</c:if>
			<br> 
			<br> 
			 <a href="#profile"
				class="nav-item">Profile</a> <a href="#general-info"
				class="nav-item">General Info</a> <a href="#change-password"
				class="nav-item">Change Password</a>
		</div>

		<div class="content">
			
			<div id="profile"></div>

			<div id="general-info">

				<form id="deleteForm-${loggedInCoach.coach_ID}" method="post"
					action="<%=contextPath + StringUtils.SERVLET_MODIFY_COACH %>">
					<input type="hidden" name="<%=StringUtils.DELETE_ID %>"
						value="${loggedInCoach.coach_ID}" />
					<button class="delete-button" type="button"
						onclick="confirmDelete('${loggedInCoach.coach_ID}')">
						<i class="fas fa-trash-alt"></i> DELETE ACCOUNT
					</button>
				</form>
				<BR> <BR>


				<form method="post"
					action="<%=contextPath + StringUtils.SERVLET_MODIFY_COACH%>">
					<input type="hidden" name="<%=StringUtils.UPDATE_ID_COACH %>"
						value="${loggedInCoach.coach_PhoneNumber}" />

					<h1>Coach Profile</h1>
					<div class="input-container">
						<label for="Address" id="address-label">Username <input
							type="text" id="username" placeholder="Username" name="Coach_ID"
							value="${loggedInCoach.coach_ID}" readonly="readonly">
						</label>
						
						<div class="upload">
    <img src="${pageContext.request.contextPath}/resources/images/Coach/${loggedInCoach.imageUrlFromPart}" 
         width="100" height="100" class="card-img-top rounded-image" alt="Profile Photo">
    <div class="round">
        <input type="file" id="image" placeholder="Image URL" name="Coach_image" value="${loggedInCoach.imageUrlFromPart}">
        <i class="fa fa-camera" style="color: #fff;"></i>
    </div>
</div>
						
						
						
						
					</div>
					<br> 
					<br>
					<h1>General Information</h1>

					<label for="Address" id="address-label">First Name: <input
						type="text" placeholder="First Name" name="Coach_FirstName"
						value="${loggedInCoach.coach_FirstName}">
					</label> <label for="Address" id="address-label">Last Name: <input
						type="text" placeholder="Last Name" name="Coach_LastName"
						value="${loggedInCoach.coach_LastName}">
					</label> <label for="Address" id="address-label">Email: <input
						type="text" placeholder="Phone Number" name="Coach_PhoneNumber"
						value="${loggedInCoach.coach_PhoneNumber}">
					</label> <label for="Address" id="address-label">Phone Number: <input
						type="text" placeholder="Email Address" name="Coach_Email"
						value="${loggedInCoach.coach_Email}">
					</label> <label for="Address" id="address-label">Total Experience:
						<input type="text" id="phoneNum" placeholder="Total Exprience"
						name="Total_Experience(in years)"
						value="${loggedInCoach.total_Experience}">
					</label> <br> <br>

					<button type="submit">Update Info</button>
				</form>

			</div>
			<div id="change-password">
				<h1>Change Password</h1>
				<form>
					<input type="password" id="old-password" placeholder="Old Password">
					<input type="password" id="new-password" placeholder="New Password">
					<input type="password" id="confirm-password"
						placeholder="Confirm New Password">
					<button type="submit">Change Password</button>
				</form>
			</div>
		</div>
	</div>



</body>

<script>
	function confirmDelete(userName) {
		if (confirm("Are you sure you want to delete the Coach: " + userName
				+ "?")) {
			document.getElementById("deleteForm-" + userName).submit();
		}
	}
</script>

</html>

