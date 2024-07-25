package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DBControllerYourCric;
import model.CoachLoginModel;
import model.CoachModel;
import util.StringUtils;

/**
 * Servlet implementation class LoginCoachServlet
 */
@WebServlet(urlPatterns = StringUtils.SERVLET_URL_LOGIN_COACH, asyncSupported = true)
public class LoginCoachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBControllerYourCric dbController;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCoachServlet() {
    	this.dbController = new DBControllerYourCric();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String coach_username = request.getParameter(StringUtils.COACH_USERNAME_ID);
        String coach_password = request.getParameter(StringUtils.COACH_PASSWORD);
        
        CoachLoginModel loginModelCoach = new CoachLoginModel(coach_username, coach_password);
        
        int loginResultCoach = dbController.getCoachLoginInfo(loginModelCoach);
        
        
        if(loginResultCoach == 1) {
        	
        	CoachModel coachModel = new CoachModel();
        			coachModel.setCoach_ID(coach_username);
        	String coachImage = dbController.getImageCoach(coachModel);
        	
        	request.getSession().setAttribute("coachImageData", coachImage);
        	
        	HttpSession userSession = request.getSession();
			userSession.setAttribute(StringUtils.COACH_USERNAME_ID, coach_username);
			userSession.setMaxInactiveInterval(30*60);
			
			Cookie userCookie= new Cookie(StringUtils.COACH, coach_username);
			userCookie.setMaxAge(30*60);
			response.addCookie(userCookie);
			
            request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_LOGIN);
            response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_HOME_COACH);
        	

        }else if(loginResultCoach == 0) {
        	
        	 request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_LOGIN);
        	 request.setAttribute(StringUtils.COACH_USERNAME_ID, coach_username);
        	 request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN_COACH).forward(request, response);
             
        	
        }else if(loginResultCoach==-1) {
        	request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_CREATE_ACCOUNT);
        	request.setAttribute(StringUtils.COACH_USERNAME_ID, coach_username);
        	request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN_COACH).forward(request, response);
           
        }else {
        	request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
        	request.setAttribute(StringUtils.COACH_USERNAME_ID, coach_username);
        	request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN_COACH).forward(request, response);
            
        }
        
		
		
		
		
	}

}
