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
 * Servlet implementation class HomePageServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { StringUtils.SERVLET_URL_HOME_COACH })
public class HomePageCoachServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	DBControllerYourCric controller = new DBControllerYourCric();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CoachModel> Coaches = controller.getAllCoachInfo();
		ArrayList<PlayerModel> players = controller.getAllStudentsInfo();
		request.setAttribute(StringUtils.PLAYER_LIST, players);
		request.setAttribute(StringUtils.COACH_LIST, Coaches);
		request.getRequestDispatcher(StringUtils.PAGE_URL_HOME_PLAYER).forward(request, response);
	}
	
	
}

