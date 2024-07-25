package controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBControllerYourCric;
import model.PlayerModel;
import util.StringUtils;

/**
 * Servlet implementation class PlayerProfile
 */
@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.SERVLET_PLAYER_PROFILE})
public class PlayerProfile extends HttpServlet {

    private static final long serialVersionUID = 1L;
    DBControllerYourCric controller = new DBControllerYourCric();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the username of the logged-in user from session or wherever you store it
        String loggedInUsername = (String) request.getSession().getAttribute("player_ID");
        
        // Retrieve details for the logged-in user
        PlayerModel loggedInPlayer = controller.getDetailsUser(loggedInUsername);
        
        // Set the logged-in user's details as a request attribute
        request.setAttribute("loggedInPlayer", loggedInPlayer);
        
        // Forward the request to the JSP page
        request.getRequestDispatcher(StringUtils.PAGE_URL_PROFILE_PLAYER).forward(request, response);
    }
}
