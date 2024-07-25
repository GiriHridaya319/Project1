<%@page import="util.StringUtils"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
String contextPath = request.getContextPath();
%>


<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>
<meta charset="UTF-8">
<title>Add new test</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/AddNewTest.css" />

<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

	<div class="container">
		<p>
			<a class="sign-up-link"
				href="<%=contextPath + StringUtils.SERVLET_URL_COACH_RESULT%>"><strong>CANCEL</strong></a>
		</p>
		<div class="title">ADD NEW TEST</div>
		<div class="content">
			<form action="<%=contextPath%>/AddNewTest" method="post">
				<div class="user-details">
					<div class="input-box">
						<span class="details">TEST ID: </span> <input type="text"
							name="Test_ID" placeholder="Enter new id for the test" required>
					</div>
					<div class="input-box">
						<span class="details">TEST NAME: </span> <input type="text"
							name="Test_Name" placeholder="Enter the test name" required>
					</div>
					<div class="input-box">
						<span class="details">LOCATION OF TEST </span> <input type="text"
							name="Location_of_Test" placeholder="Enter location of test"
							required>
					</div>
					<div class="input-box">
						<span class="details">Test Date</span> <input type="date"
							name="Test_Date" placeholder="Enter date of the test" required>
					</div>

					<div class="input-box">
						<span class="details">TEST DESCRIPTION</span>
						<textarea placeholder="Enter description of the test"
							name="Test_Description" required></textarea>
					</div>


				</div>
				<div class="gender-details">
					<span class="gender-title">TEST STATUS</span>
					<div class="category">
						<select name="Test_Status" id="test-status-select">
							<option value="upcoming">Upcoming</option>
							<option value="ongoing">Ongoing</option>
							<option value="finished">Finished</option>
						</select>
					</div>
				</div>

				<div class="button">
					<input type="submit" value="ADD">
				</div>
			</form>


			<%
			String errMsgTest = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
			String successMsgTest = (String) request.getAttribute(StringUtils.MESSAGE_SUCCESS);

			if (errMsgTest != null) {
				// print
			%>
			<h4 class="error-msg">
				<%
				out.println(errMsgTest);
				%>
			</h4>
			<%
			}

			if (successMsgTest != null) {
			// print
			%>
			<h4 class="success-msg">
				<%
				out.println(successMsgTest);
				%>
			</h4>
			<%
			}
			%>

		</div>
	</div>

</body>
</html>