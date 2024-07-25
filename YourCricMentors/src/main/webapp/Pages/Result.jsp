<%@page import="util.StringUtils"%>
<%@page import="model.TestModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Result page</title>


<%
// Get the session and request objects
HttpSession playerSession = request.getSession();
String currentCoach = (String) playerSession.getAttribute(StringUtils.COACH_USERNAME_ID);
String contextPath = request.getContextPath();
%>

<style>

/* Style for main card container */
.maina_cards {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-around;
}

/* Style for individual card */
.card0 {
	width: 300px;
	background-color: #f9f9f9;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	margin: 20px;
	padding: 20px;
}

.card-header {
	background-color: #3498db;
	color: white;
	border-radius: 10px 10px 0 0;
	padding: 10px;
}

.card-text {
	margin: 10px 0;
}

.details-container {
	margin-top: 20px;
}

.detail {
	margin-bottom: 10px;
}

.btn {
	background-color: #3498db;
	color: white;
	border: none;
	padding: 10px 20px;
	border-radius: 5px;
	cursor: pointer;
	margin-bottom: 10px
}

.btn:hover {
	background-color: #2980b9;
}

.table {
    width: 200%
    border-collapse: collapse;
}

.table th, .table td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
}

.table th {
    background-color: #3498db;
}

</style>



<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/UserDashBoard.css" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/NewFile.css" />

</head>

<body>
	<jsp:include page="<%=StringUtils.PAGE_URL_LOGGED_HEADER_COACH%>" />


<br>
<br>
<br>
<br>

	<main class="main">
	<a href="<%= contextPath + StringUtils.SERVLET_URL_COACH_RESULT %>">
  <button class="refresh-button">
    <i class="fas fa-sync-alt"></i> Refresh
  </button>
</a>


    <br>

         <form action="<%= request.getContextPath() + "/searchTest" %>" method="post">
    <input type="text" class="animated-input" name="testName" placeholder="Enter the name of the test">
    
    <button type="submit" class="submit-button">Submit</button>
</form>



    <c:if test="${empty testlists}">
        <p>No test details found.</p>
    </c:if>

    <div class="maina_cards">
        <c:forEach var="tests" items="${testlists}">
            <!-- Card -->
            <div class="card0">
                <div class="card-header">
                    <h2 class="card-text">${tests.testID}</h2>
                </div>

                <h2 class="card-text">
                    <strong>Name:</strong>${tests.testName}
                </h2>
                <p class="card-text">
                    <strong>Description:</strong>${tests.testDescription}
                </p>
                <div class="details-container">
                    <p class="detail">
                        <strong>Location:</strong> ${tests.location_of_Test}
                    </p>
                    <p class="detail">
                        <strong>Date:</strong> ${tests.test_Date}
                    </p>
                    <p class="detail">
                        <strong>Status:</strong> ${tests.test_Status}
                    </p>
                </div>
                <br>
                <br>
                <form action="<%=contextPath + StringUtils.SERVLET_UPDATE_TEST_DETAIL%>">
                    <input type="hidden" name="<%=StringUtils.UPDATE_Test_ID %>" value="${tests.testID}" />
                   <button class="update-button">
                   <i class="fas fa-edit"></i> Update
                   </button>
                </form>
<br>
                <form id="deleteForm-${tests.testID}" method="post" action="<%=contextPath + StringUtils.SERVLET_UPDATE_TEST %>">
                    <input type="hidden" name="<%=StringUtils.DELETE_ID %>" value="${tests.testID}" />
                    <button class="delete-button" type="button" onclick="confirmDelete('${tests.testID}')">
                    <i class="fas fa-trash-alt"></i> Delete
                    </button>
                </form>
            </div>
            <!-- End of Card -->
        </c:forEach>

        <div class="maina_cards">
            <div class="card0" style="width: 350px;">
                <h1>Want to Add new test to the players?</h1>
                <br>
                <br>
                <br>
                <br>
                <div class="card-content">
                    <form action="<%=contextPath + StringUtils.PAGE_URL_ADD_NEW_TEST%>" method="get">
                        <button class="button add" type="submit">
                            <span>Add</span>
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
	

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<h1>THE RESULT OF RECENT TESTS </h1>
	<br>
	<br>
	<br>




	<main class="main">

    <div class="card">
    <div style="overflow-x:auto;">
        <!-- Your table content here -->
        <table class="table" style="width: 220%;">
            <thead>
                <tr>
                    <th>Player ID</th>
                    <th>Test ID</th>
                    <th>Total Test Taken</th>
                    <th>Marks Obtained in 100</th>
                </tr>
            </thead>
            <tbody>
                <!-- Loop through your data from the database -->
                <c:forEach var="marks" items="${markslists}">
                    <tr>
                        <td>${marks.player_ID}</td>
                        <td>${marks.testID}</td>
                        <td>${marks.totalTestTaken}</td>
                        <td>${marks.marks_obtained}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</main>


</body>

<script>
	function confirmDelete(userName) {
		if (confirm("Are you sure you want to delete the testID: " + userName
				+ "?")) {
			document.getElementById("deleteForm-" + userName).submit();
		}else {
            return false;
        }
	}
</script>

</html>