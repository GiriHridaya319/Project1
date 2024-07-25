<%@page import="util.StringUtils"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
    <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/NewFile.css" />
	
<style>
   button {
    padding: 10px 20px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

.avatar-img {
    max-width: 50px;
    height: 50px;
    border-radius: 50%; /* Makes the image circular */
    margin-right: 10px; /* Adjust margin as needed */
}

.main-logo {
    max-width: 100px;
    height: auto;
    margin-left: 10px; /* Adjust margin as needed */
    </style>
<%
    // Get the session and request objects
    HttpSession coachSession = request.getSession();
    String currentPlayer = (String) coachSession.getAttribute(StringUtils.COACH_USERNAME_ID);
    String contextPath = request.getContextPath();
    
%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">


<nav class="navbar">

        <div class="navbar-container container">
            <input type="checkbox" name="" id="">
            <div class="hamburger-lines">
                <span class="line line1"></span>
                <span class="line line2"></span>
                <span class="line line3"></span>
            </div>
            <ul class="menu-items">
    <li><a href="<%= contextPath + StringUtils.SERVLET_URL_HOME %>">Home</a></li>
    <li><a href="<%= contextPath + StringUtils.SERVLET_URL_COACH_RESULT %>">Results</a></li>
<li><a href="<%= contextPath + StringUtils.SERVLET_COACH_PROFILE %>">Profile</a></li>
	
<li>
        <form action="<%
            // Conditionally set the action URL based on user session
            if (currentPlayer != null) {
                out.print(contextPath + StringUtils.SERVLET_URL_LOGOUT);
            } else {
                out.print(contextPath + StringUtils.PAGE_URL_LOGIN_COACH);
            }
        %>" method="post">
            <button class="login-button"><i class="fas fa-sign-in-alt"></i> ><%
                // Conditionally set the button label based on user session
                if (currentPlayer != null) {
                    out.print("Logout");
                } else {
                    out.print("Login");
                }
            %></button>
        </form>
    </li>

</ul>
<img src="${pageContext.request.contextPath}/resources/images/other/MainLogo.png" style="max-width: 100px; height: auto;" />


            <h1 class="logo">YourCricMentor</h1>
            
            <c:if test="${not empty coachImageData}">
    <img src="${pageContext.request.contextPath}/resources/images/Coach/${coachImageData}" 
         class="avatar-img" alt="...">
</c:if>
        </div>
    </nav>
