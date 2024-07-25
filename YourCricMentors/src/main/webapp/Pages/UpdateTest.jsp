<%@page import="util.StringUtils"%>
<%@page import="model.TestModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<%
String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<!-- Created By CodingLab - www.codinglabweb.com -->
<html lang="en" dir="ltr">
<head>
<meta charset="UTF-8">
<title>Responsive Registration Form | CodingLab</title>
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
		<div class="title">UPDATE TEST</div>
		<div class="content">
			<form method="post"
				action="<%=contextPath + StringUtils.SERVLET_UPDATE_TEST%>">
				<input type="hidden" name="<%=StringUtils.UPDATE_Test_ID %>"
					value="${loggedInTests.testName}" />
				<div class="user-details">
					<div class="input-box">
						<span class="details">TEST ID: </span> <input type="text"
							name="Test_ID" placeholder="Enter the test ID"
							value="${loggedInTests.testID}" readonly="readonly">
					</div>
					<div class="input-box">
						<span class="details">TEST NAME: </span> <input type="text"
							name="Test_Name" placeholder="Enter the test name"
							value="${loggedInTests.testName}" required>
					</div>
					<div class="input-box">
						<span class="details">LOCATION OF TEST </span> <input type="text"
							name="Location_of_Test" placeholder="Enter location of test"
							value="${loggedInTests.location_of_Test}" required>
					</div>

					<div class="input-box">
						<span class="details">TEST DESCRIPTION</span>
						<textarea placeholder="Enter description of the test"
							name="Test_Description" required>${loggedInTests.testDescription}</textarea>
					</div>


				</div>
				<div class="input-box">
					<span class="details">TEST STATUS</span> <select name="Test_Status"
						required>
						<option value="Completed"
							${loggedInTests.test_Status == 'Completed' ? 'selected' : ''}>Completed</option>
						<option value="Ongoing"
							${loggedInTests.test_Status == 'Ongoing' ? 'selected' : ''}>Ongoing</option>
						<option value="Upcoming"
							${loggedInTests.test_Status == 'Upcoming' ? 'selected' : ''}>Upcoming</option>
					</select>
				</div>

				<div class="button">
					<input type="submit" value="UPDATE">

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