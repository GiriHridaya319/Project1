package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBControllerYourCric;
import util.StringUtils;
import util.ValidationUtil;

/**
 * Servlet implementation class ModifyCoachServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { StringUtils.SERVLET_MODIFY_COACH })
public class ModifyCoachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBControllerYourCric dbController;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyCoachServlet() {
    	this.dbController = new DBControllerYourCric();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String updateIdCoach = request.getParameter(StringUtils.UPDATE_ID_COACH);
	    String deleteIdCoach = request.getParameter(StringUtils.DELETE_ID);

	    if (updateIdCoach != null && !updateIdCoach.isEmpty()) {
	        doPut(request, response);
	    } else if (deleteIdCoach != null && !deleteIdCoach.isEmpty()) {
	        doDelete(request, response);
	    }
	   
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse resp)
	        throws ServletException, IOException {
		String coach_id = request.getParameter("Coach_ID");
		String firstName = request.getParameter("Coach_FirstName");
		String lastName = request.getParameter("Coach_LastName");
		String email = request.getParameter("Coach_Email");
		String phoneNumber = request.getParameter("Coach_PhoneNumber");
		String experience = request.getParameter("Total_Experience(in years)");
		String image = request.getParameter("Coach_image");
		
		if (!ValidationUtil.isTextOnly(firstName) ||
			    !ValidationUtil.isTextOnly(lastName) ||
			    !ValidationUtil.isAlphanumeric(coach_id) ||
			    !ValidationUtil.isAlphanumeric(experience) ||
			    !ValidationUtil.isEmail(email) ||
			   
			    !ValidationUtil.isNumbersOnly(phoneNumber)) {

			    request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_INCORRECT_DATA);
			    resp.sendRedirect(request.getContextPath() + StringUtils.SERVLET_COACH_PROFILE);
			}
		
			
		else {
		
		int rowsAffected = dbController.updateCoachInfo(coach_id, firstName, lastName, email, phoneNumber, experience, image);

	    
	    if (rowsAffected == 1) {
	        request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_UPDATE);
	        resp.sendRedirect(request.getContextPath() + StringUtils.SERVLET_COACH_PROFILE);
	    } else {
	        request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_UPDATE);
	        request.getRequestDispatcher(StringUtils.SERVLET_URL_HOME_COACH).forward(request, resp);
	    }
	    
	    
	    
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result = dbController.deleteCoachInfo(req.getParameter(StringUtils.DELETE_ID));
		if ( result== 1) {
			req.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_DELETE);
			resp.sendRedirect(req.getContextPath() + StringUtils.PAGE_URL_LOGIN_COACH);
		} else {
			req.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_DELETE);
			resp.sendRedirect(req.getContextPath() + StringUtils.PAGE_URL_PROFILE_COACH);
		}
	}
	


}
