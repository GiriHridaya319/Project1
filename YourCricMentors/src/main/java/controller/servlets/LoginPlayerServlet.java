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
import model.PlayerLoginModel;
import model.PlayerModel;
import util.StringUtils;

/**
 * Servlet implementation class LoginPlayerServlet
 */

@WebServlet(urlPatterns = StringUtils.SERVLET_URL_LOGIN_PLAYER, asyncSupported = true)
public class LoginPlayerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	 private final DBControllerYourCric dbController;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPlayerServlet() {
        this.dbController = new DBControllerYourCric();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			String player_username = request.getParameter(StringUtils.PLAYER_USERNAME_ID);
	        String player_password = request.getParameter(StringUtils.PLAYER_PASSWORD);
	        
	        PlayerLoginModel loginModelPlayer = new PlayerLoginModel(player_username, player_password);
	        
	        int loginResultPlayer = dbController.getPlayerLoginInfo(loginModelPlayer);
	        
	        
	        if(loginResultPlayer == 1) {
	        	
	        	PlayerModel playerModel = new PlayerModel();
	            playerModel.setPlayer_ID(player_username);
	            String playerImageDatas = dbController.getImagePlayer(playerModel);
	            
	            // Set the image data in session or request scope
	            request.getSession().setAttribute("playerImageData", playerImageDatas);
	        	
	        	
	        	
	        	HttpSession userSession = request.getSession();
				userSession.setAttribute(StringUtils.PLAYER_USERNAME_ID, player_username);
				userSession.setMaxInactiveInterval(30*60);
				Cookie userCookie= new Cookie(StringUtils.PLAYER, player_username);
				userCookie.setMaxAge(30*60);
				response.addCookie(userCookie);
				
	            request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_LOGIN);
	            response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_HOME_PLAYER);
	        	
	
	        }else if(loginResultPlayer == 0) {
	        	
	        	 request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_LOGIN);
	        	 request.setAttribute(StringUtils.PLAYER_USERNAME_ID, player_username);
	        	 request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN_PLAYER).forward(request, response);
	             
	        	
	        }else if(loginResultPlayer==-1) {
	        	request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_CREATE_ACCOUNT);
	        	request.setAttribute(StringUtils.PLAYER_USERNAME_ID, player_username);
	        	request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN_PLAYER).forward(request, response);
	           
	        }else {
	        	request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
	        	request.setAttribute(StringUtils.PLAYER_USERNAME_ID, player_username);
	        	request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN_PLAYER).forward(request, response);
	            
	        }
	        
	        
	        
	        
		}

	
	}
