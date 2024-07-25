package controller.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.database.DBControllerYourCric;
import model.PlayerModel;
import util.StringUtils;
import util.ValidationUtil;

/**
 * Servlet implementation class RegisterPlayerServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { StringUtils.SERVLET_URL_REGISTER_PLAYER})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class RegisterPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBControllerYourCric dbController;

	
    public RegisterPlayerServlet() {
        this.dbController = new DBControllerYourCric();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String player_id = request.getParameter(StringUtils.PLAYER_USERNAME_ID);
		String player_first_name = request.getParameter(StringUtils.PLAYER_FIRST_NAME);
		String player_last_name = request.getParameter(StringUtils.PLAYER_LAST_NAME);
		String player_email = request.getParameter(StringUtils.PLAYER_EMAIL);
		String player_address = request.getParameter(StringUtils.PLAYER_ADDRESS);
		String player_role = request.getParameter(StringUtils.PLAYER_ROLE);
		LocalDate player_Dob = LocalDate.parse(request.getParameter(StringUtils.PLAYER_DATE_OF_BIRTH));
		String player_password = request.getParameter(StringUtils.PLAYER_PASSWORD);
		String player_password_retype = request.getParameter("RetypePlayer_Password");
		
		Part imageUrlFromPart = request.getPart(StringUtils.PLAYER_IMAGE);
		String PhoneNumber = request.getParameter(StringUtils.PLAYER_PHONENUMBER);

		

		if (!ValidationUtil.isTextOnly(player_first_name) ||
		    !ValidationUtil.isTextOnly(player_last_name) ||
		    !ValidationUtil.isAlphanumeric(player_id) ||
		    !ValidationUtil.isAlphanumeric(player_address) ||
		    !ValidationUtil.isEmail(player_email) ||
		    !ValidationUtil.isValidPassword(player_password) ||
		    !ValidationUtil.isValidPassword(player_password_retype) ||
		    !ValidationUtil.isNumbersOnly(PhoneNumber)) {

		    request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_INCORRECT_DATA);
		    request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
		}
		else if(ValidationUtil.isEmailTaken(player_email)) {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_EMAIL);
			request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
		}
		else if(ValidationUtil.isPhoneNumberTaken(PhoneNumber) ) {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_PHONE_NUMBER);
			request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
		}
		else if(ValidationUtil.isUsernameTaken( player_id)) {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_USERNAME);
			request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
		}
		else if(!ValidationUtil.doPasswordsMatch(player_password,player_password_retype)) {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_PASSWORD_UNMATCHED);
			request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
		    
		}

		else {
			PlayerModel player = new PlayerModel(player_id, player_first_name, player_last_name,
			        player_email, player_address, player_role, player_Dob, player_password, imageUrlFromPart, PhoneNumber);
			
		int register = dbController.register_player(player);
		
		
		if(register == 1) {
			String savePath = StringUtils.IMAGE_DIR_SAVE_PATH_PLAYER;
		    String fileName = player.getImageUrlFromPart();
		    if(!fileName.isEmpty() && fileName != null)
		    	imageUrlFromPart.write(savePath + fileName);
		    
			request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_REGISTER);
			response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_LOGIN_PLAYER + "?success=true");
		}
		else if(register==0) {
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
