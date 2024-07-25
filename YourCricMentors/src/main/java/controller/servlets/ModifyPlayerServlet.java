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
 * Servlet implementation class ModifyPlayerServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { StringUtils.SERVLET_MODIFY_PLAYER })
public class ModifyPlayerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final DBControllerYourCric dbController;
	
	
	public ModifyPlayerServlet() {
		this.dbController = new DBControllerYourCric();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String updateId = request.getParameter(StringUtils.UPDATE_ID);
	    String deleteId = request.getParameter(StringUtils.DELETE_ID);

	    if (updateId != null && !updateId.isEmpty()) {
	        doPut(request, response);
	    } else if (deleteId != null && !deleteId.isEmpty()) {
	        doDelete(request, response);
	    }
	   
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse resp)
	        throws ServletException, IOException {
		String player_id = request.getParameter("player_ID");
		String firstName = request.getParameter("Player_FirstName");
		String lastName = request.getParameter("Player_LastName");
		String email = request.getParameter("Player_Email");
		String address = request.getParameter("Player_Address");
		String phoneNum = request.getParameter("Player_PhoneNumber");
		String image = request.getParameter("Player_image");
		
		if (!ValidationUtil.isTextOnly(firstName) ||
			    !ValidationUtil.isTextOnly(lastName) ||
			    !ValidationUtil.isAlphanumeric(player_id) ||
			    !ValidationUtil.isAlphanumeric(address) ||
			    !ValidationUtil.isEmail(email) ||
			    !ValidationUtil.isNumbersOnly(phoneNum)) {

			    request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_INCORRECT_DATA);
			    resp.sendRedirect(request.getContextPath() + StringUtils.SERVLET_PLAYER_PROFILE);
			}
		else {
		
		int rowsAffected = dbController.updatePlayerInfo(player_id, firstName, lastName, email, address, phoneNum, image);
	    	
	    if (rowsAffected == 1) {
	        request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_UPDATE);
	        resp.sendRedirect(request.getContextPath() + StringUtils.SERVLET_PLAYER_PROFILE);
	    } else {
	        request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_UPDATE);
	        request.getRequestDispatcher(StringUtils.SERVLET_URL_HOME).forward(request, resp);
	    }
	    
		}
	}
		
	

	
	
	@Override
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int result = dbController.deletePlayerInfo(req.getParameter(StringUtils.DELETE_ID));
			if ( result== 1) {
				req.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_DELETE);
				resp.sendRedirect(req.getContextPath() + StringUtils.PAGE_URL_LOGIN_PLAYER);
			} else {
				req.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_DELETE);
				resp.sendRedirect(req.getContextPath() + StringUtils.PAGE_URL_PROFILE_PLAYER);
			}
		}
	
	}
