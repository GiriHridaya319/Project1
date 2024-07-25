package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBControllerYourCric;
import model.CoachModel;
import model.PlayerModel;
import util.StringUtils;

/**
 * Servlet implementation class MainPageServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/MainPageServlet" })
public class MainPageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	DBControllerYourCric controller = new DBControllerYourCric();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CoachModel> coach = controller.getAllCoachInfo();
		ArrayList<PlayerModel> player = controller.getAllStudentsInfo();
		request.setAttribute(StringUtils.COACH_LIST, coach);
		request.setAttribute(StringUtils.PLAYER_LIST, player);
		request.getRequestDispatcher(StringUtils.PAGE_URL_HOMEPAGE).forward(request, response);
	}
	
	
}
