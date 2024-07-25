package controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.database.DBControllerYourCric;
import model.CoachModel;
import util.StringUtils;
import util.ValidationUtil;

/**
 * Servlet implementation class RegisterCoachServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { StringUtils.SERVLET_URL_REGISTER_COACH})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class RegisterCoachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBControllerYourCric dbController;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCoachServlet() {
    	this.dbController = new DBControllerYourCric();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String coach_id = request.getParameter(StringUtils.COACH_USERNAME_ID);
		String coach_first_name = request.getParameter(StringUtils.COACH_FIRST_NAME);
		String coach_last_name = request.getParameter(StringUtils.COACH_LAST_NAME);
		String coach_type = request.getParameter(StringUtils.COACH_TYPE);
		String coach_email = request.getParameter(StringUtils.COACH_EMAIL);
		String coach_phone = request.getParameter(StringUtils.COACH_PHONE_NUM);
		String coach_experience = request.getParameter(StringUtils.COACH_TOTAL_EXP);
		String coach_password = request.getParameter(StringUtils.COACH_PASSWORD);
		String coach_password_retype = request.getParameter(StringUtils.COACH_PASSWORD_RETYPE);
		Part coach_imageUrlFromPart = request.getPart(StringUtils.COACH_IMAGE);
		
		
		
		
		
		if (!ValidationUtil.isTextOnly(coach_first_name) ||
			    !ValidationUtil.isTextOnly(coach_last_name) ||
			    !ValidationUtil.isAlphanumeric(coach_id) ||
			    !ValidationUtil.isAlphanumeric(coach_experience) ||
			    !ValidationUtil.isValidPassword(coach_password) ||
			    !ValidationUtil.isValidPassword(coach_password_retype) ||
			    !ValidationUtil.isEmail(coach_email) ||
			   
			    !ValidationUtil.isNumbersOnly(coach_phone)) {

			    request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_INCORRECT_DATA);
			    request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
			}
		
		else if(ValidationUtil.isEmailTakenCoach(coach_email)) {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_EMAIL);
			request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
		}
		else if(ValidationUtil.isPhoneNumberTakenCoach(coach_phone) ) {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_PHONE_NUMBER);
			request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
		}
		else if(ValidationUtil.isUsernameTaken( coach_id)) {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_USERNAME);
			request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
		}
		else if(!ValidationUtil.doPasswordsMatch(coach_password,coach_password_retype)) {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_PASSWORD_UNMATCHED);
			request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
		}

		
		else {
			
			CoachModel coach = new CoachModel(coach_id,coach_first_name,coach_last_name,coach_type,coach_email
					,coach_phone,coach_experience,coach_password,coach_imageUrlFromPart);
	    
	    int register_coach = dbController.register_coach(coach);
	
	    
	    if(register_coach == 1) {
	    	String savePath = StringUtils.IMAGE_DIR_SAVE_PATH_COACH ;
		    String fileName = coach.getImageUrlFromPart();
		    if(!fileName.isEmpty() && fileName != null)
		    	coach_imageUrlFromPart.write(savePath + fileName);
		    
			request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_REGISTER);
			request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN_COACH ).forward(request, response);
			
		}
		else if(register_coach==0) {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_REGISTER);
			request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
		}
		
		else {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
			request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
		}
	    
	    
	}
	}

}
