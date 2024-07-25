<%@page import="util.StringUtils"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
		
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/HomePage.css" />
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/NewFile.css" />
	
	
    <title>YourCricMentor</title>
    <%  String contextPath = request.getContextPath(); %>
    
    <style>
        /* Add some basic styling to the button */
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
}


    </style>
    
</head>

<body>
    <nav class="navbar">

        <div class="navbar-container container">
            <input type="checkbox" name="" id="">
            <div class="hamburger-lines">
                <span class="line line1"></span>
                <span class="line line2"></span>
                <span class="line line3"></span>
            </div>
            <ul class="menu-items">
    <li><a href="HomePage.jsp">Home</a></li>
    <li><a href="pages/AboutUs.jsp">About Us</a></li>
    <li><a href="pages/LoginPage.jsp">Login</a></li>
    <li><a href="Pages/Register.jsp">Register</a></li>
</ul>
<img src="${pageContext.request.contextPath}/resources/images/other/MainLogo.png" class="main-logo" alt="YourCricMentor">

            <h1 class="logo">YourCricMentor</h1>
        </div>
    </nav>
    
    
    
    <header class="section__container header__container">
    
        <div class="header__content">
          <span class="bg__blur"></span>
          <span class="bg__blur header__blur"></span>
          <h4>BEST CRICKET MENTOR IN THE TOWN</h4>
          <h1><span>CHECK </span> YOUR CRICKET SKILLS</h1>
          
          <br>  <a href="<%=contextPath + StringUtils.PAGE_URL_REGISTER%>" class="btn" style="margin-left: 200px;">Register Now</a>


        </div>
        <div class="header__image">
         
          <a href=""><img src="${pageContext.request.contextPath}/resources/images/other/Display.png"/></a>
          
        </div>
      </header> 


      <section class="section__container class__container">
        <div class="class__image">
          <span class="bg__blur"></span>
          
          <a href=""><img src="${pageContext.request.contextPath}/resources/images/other/Display2.png" class="class__img-1"/></a>
          <a href=""><img src="${pageContext.request.contextPath}/resources/images/other/Display3.png" class="class__img-2"/></a>
        </div>
        <div class="class__content">
          <h2 class="section__header">THE CLASS YOU WILL GET HERE</h2>
          <p>
            
          YourCricMentor is a specialized platform for cricket players, 
          coaches, and academies nationwide. It manages and showcases 
          players' performance data from tests, exams, and matches.
          Coaches have exclusive access to evaluate and manage player
            records, while players can view their own results. 
            The platform also offers valuable tips to enhance cricket skills.
          </p>
          <a href="<%=contextPath + StringUtils.PAGE_URL_REGISTER%>" class="btn" >Register Now</a>
        </div>
      </section>
  



      <section class="section__container explore__container">
    <h2 class="section__header">Our Top Coaches </h2>

    <div class="explore__grid">	
        <c:if test="${empty coachLists}">
            <p>Be the First Coach to be listed</p>
        </c:if>
        <c:if test="${not empty coachLists}">
            <c:forEach var="coach" items="${coachLists}" varStatus="loop">
                <c:if test="${loop.index < 4}">
                    <div class="explore__card"> 
                        <div class="card">
                            <img src="${pageContext.request.contextPath}/resources/images/Coach/${coach.imageUrlFromPart}" 
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


      <div class="join__grid">
        <div class="join__card">
        
          <div class="join__card__content">
            <h4>WANNA BE ONE OF THEM ? </h4>
            <a href="<%=contextPath + StringUtils.PAGE_URL_REGISTER%>" class="btn" style="margin-left: 10px;">Register Now</a>
          </div>
        </div>
      </div>


<!-- Slider HTML -->
<div class="slider">
  <div class="slides">
    <!-- Radio buttons -->
    <input type="radio" name="radio-btn" id="radio1">
    <input type="radio" name="radio-btn" id="radio2">
    <input type="radio" name="radio-btn" id="radio3">
    <input type="radio" name="radio-btn" id="radio4">
    <!-- Slide images -->
    <div class="slide first">
      <a href=""><img src="${pageContext.request.contextPath}/resources/images/other/SliderImage1.jpg" /></a>
    </div>
    <div class="slide">
      <a href=""><img src="${pageContext.request.contextPath}/resources/images/other/SliderImage2.jpg" /></a>
    </div>
    <div class="slide">
      <a href=""><img src="${pageContext.request.contextPath}/resources/images/other/SliderImage3.jpg" /></a>
    </div>
    <div class="slide">
      <a href=""><img src="${pageContext.request.contextPath}/resources/images/other/SliderImage4.jpg" /></a>
    </div>
  </div>
  <!-- Manual navigation -->
  <div class="navigation-manual">
    <label for="radio1" class="manual-btn"></label>
    <label for="radio2" class="manual-btn"></label>
    <label for="radio3" class="manual-btn"></label>
    <label for="radio4" class="manual-btn"></label>
  </div>
</div>

<!-- Slider JavaScript -->
<script type="text/javascript">
  var counter = 1;
  setInterval(function(){
    document.getElementById('radio' + counter).checked = true;
    counter++;
    if(counter > 4){
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

      <div class="join__grid">
        <div class="join__card">
          
          <div class="join__card__content">
            <h4>Wanna be One of Them?</h4>
            <a href="<%=contextPath + StringUtils.PAGE_URL_REGISTER%>" class="btn" style="margin-left: 10px;">Register Now</a>
          </div>
        </div>
      </div>


      
  
      <footer class="hero">
        <div class="container flex">
            <div class="container__about">
                <h2>About</h2>
                <p>Learning the concept of JSP, servlet and webpages.</p>
            </div>
            <div class="container-pages flex">

                
                <div class="container__more">
                    <h2>Lets Stay connected</h2>
                    <ul>
                        <li><a href="https://www.instagram.com/hridayagirii/">Connect now</a></li>
                        
                    </ul>
	
                </div>
            </div>
        </div>
        <div class="line__separete"></div>
        <div class="by flex">
            <p>Copyright © 2022 All Rights Reserved by Hridaya Giri.</p>
            <div class="icons">
                <a href="https://www.instagram.com/hridayagirii/" class="icon1 icon--instagram">
                    <i class="ri-instagram-line"></i>
                </a>
                	
            </div>
        </div>

    </footer>
    
    
</body>

</html>


