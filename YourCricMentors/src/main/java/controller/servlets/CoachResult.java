package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBControllerYourCric;
import model.PlayersMarks;
import model.TestModel;
import util.StringUtils;

/**
 * Servlet implementation class CoachResult
 */
@WebServlet(asyncSupported = true, urlPatterns = { StringUtils.SERVLET_URL_COACH_RESULT })
public class CoachResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBControllerYourCric controller = new DBControllerYourCric(); 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<TestModel> testsDetails = controller.getAllTestInfo();
		request.setAttribute(StringUtils.TEST_LIST, testsDetails);
		ArrayList<PlayersMarks> marksDetails = controller.getAllPlayerResultInfo();
		request.setAttribute(StringUtils.MARKS_LIST, marksDetails);
		request.getRequestDispatcher(StringUtils.PAGE_URL_RESULT_COACH).forward(request, response);
	}

}
