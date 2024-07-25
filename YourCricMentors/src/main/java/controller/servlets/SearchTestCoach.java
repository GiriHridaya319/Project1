package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TestModel;
import util.StringUtils;
import controller.database.DBControllerYourCric;

/**
 * Servlet implementation class searchTest
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/searchTest" })
public class SearchTestCoach extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DBControllerYourCric controller = new DBControllerYourCric();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the Test ID from request parameter
    	String testName = request.getParameter("testName");

        // Call the getSearchTestInfo method with the test name
        ArrayList<TestModel> testDetail = controller.getSearchTestInfo(testName);

        // Set the test details as a request attribute
        request.setAttribute("testlists", testDetail);

        // Forward the request to your JSP to display the filtered test details
        request.getRequestDispatcher(StringUtils.PAGE_URL_RESULT_COACH).forward(request, response);
    }
}
