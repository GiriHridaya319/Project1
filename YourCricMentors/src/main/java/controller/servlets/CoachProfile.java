package controller.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBControllerYourCric;
import model.CoachModel;
import util.StringUtils;

/**
 * Servlet implementation class CocachProfile
 */
@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.SERVLET_COACH_PROFILE  })
public class CoachProfile extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	DBControllerYourCric controller = new DBControllerYourCric();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String loggedInUsername = (String) request.getSession().getAttribute("Coach_ID");
	        
	        // Retrieve details for the logged-in user
	        CoachModel loggedInCoach = controller.getDetailsCoach(loggedInUsername);
	        
	        // Set the logged-in user's details as a request attribute
	        request.setAttribute("loggedInCoach", loggedInCoach);
		request.getRequestDispatcher(StringUtils.PAGE_URL_PROFILE_COACH).forward(request, response);
	}
	
	
}
