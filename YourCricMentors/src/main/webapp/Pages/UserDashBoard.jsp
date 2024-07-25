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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Player Dashboard</title>
    
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
HttpSession playerSession = request.getSession();
String currentPlayer = (String) playerSession.getAttribute(StringUtils.PLAYER_USERNAME_ID);
String contextPath = request.getContextPath();
%>
    
    
    <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/UserDashBoard.css" />
	
	 <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/UserProfile.css" />
	

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

    

<jsp:include page="<%=StringUtils.PAGE_URL_LOGGED_HEADER_PLAYER%>" />

<br>
<br>

<div class="container">
    <div class="sidebar">
        <h2>User Dashboard</h2>
        <br>
        <br>
        <br>
        
        <c:if test="${not empty playerImageData}">
    <img src="${pageContext.request.contextPath}/resources/images/Player/${playerImageData}" 
         class="card-img-top rounded-image" alt="...">
</c:if>
<br>
<br>
<br>

        
        <br>
        <br>
        
        <a href="#profile" class="nav-item">Profile</a>
        <a href="#general-info" class="nav-item">General Info</a>
        <a href="#change-password" class="nav-item">Change Password</a>
          
    </div>
    
    <div class="content">
        <!-- Content will be loaded dynamically here -->
        <div id="profile">
            
            
          
</div> 

<div id="general-info">
    <form id="deleteForm-${loggedInPlayer.player_ID}" method="post" action="<%=contextPath + StringUtils.SERVLET_MODIFY_PLAYER %>">
            <input type="hidden" name="<%=StringUtils.DELETE_ID %>" value="${loggedInPlayer.player_ID}" />
            <button class="delete-button" type = "button" onclick="confirmDelete('${loggedInPlayer.player_ID}')">
                <i class="fas fa-trash-alt"></i> DELETE ACCOUNT
            </button>
        </form>
        <BR>
        <BR>
        
    <form method="post"  action="<%=contextPath + StringUtils.SERVLET_MODIFY_PLAYER%>" >
    <input type="hidden" name="<%=StringUtils.UPDATE_ID %>" value="${loggedInPlayer.phoneNumber}" />
    
    <h1>User Profile</h1>
    <div class="input-container">
    <label for="Address" id="address-label">Username
    <input type="text" id="username" placeholder="Username" name="player_ID" value="${loggedInPlayer.player_ID}" readonly="readonly" >
    </label>
   
    
    <div class="upload">
    <img src="${pageContext.request.contextPath}/resources/images/Player/${loggedInPlayer.imageUrlFromPart}" 
         width="100" height="100" class="card-img-top rounded-image" alt="Profile Photo">
    <div class="round">
        <input type="file" id="image" placeholder="Image URL" name="Player_image" value="${loggedInPlayer.imageUrlFromPart}">
        <i class="fa fa-camera" style="color: #fff;"></i>
    </div>
</div>

     

         
    
    
</div>
<br>
<br>

    <h1>General Information</h1>
    
    <label for="Address" id="address-label">First Name:	
    <input type="text" placeholder="First Name" name="Player_FirstName" value="${loggedInPlayer.player_FirstName}">
     </label>
     <label for="Address" id="address-label">Last Name:
    <input type="text" placeholder="Last Name" name="Player_LastName" value="${loggedInPlayer.player_LastName}">
    </label>
    <label for="Address" id="address-label">Address:
    <input type="text" placeholder="Address" name="Player_Address" value="${loggedInPlayer.player_Address}">
    </label>
    
    <label for="Address" id="address-label">Address:
    <input type="text" placeholder="Email Address" name="Player_Email" value="${loggedInPlayer.player_Email}">
    </label>
    <label for="Address" id="address-label">Phone:
     <input type="text" id="phoneNum" placeholder="Phone Number" name= "Player_PhoneNumber" value="${loggedInPlayer.phoneNumber}">
     </label>
     
    <br>
    <br>
    
    <button type="submit">Update Info</button>
</form>

    
</div>
        <div id="change-password">
            <h1>Change Password</h1>
            <form>
                <input type="password" id="old-password" placeholder="Old Password">
                <input type="password" id="new-password" placeholder="New Password">
                <input type="password" id="confirm-password" placeholder="Confirm New Password">
                <button type="submit">Change Password</button>
            </form>
            <br>
            <br>
    
            
        </div>
    </div>
</div>



</body>
<script>
	function confirmDelete(userName) {
		if (confirm("Are you sure you want to delete the Player: " + userName
				+ "?")) {
			document.getElementById("deleteForm-" + userName).submit();
		}
	}
</script>
</html>
    