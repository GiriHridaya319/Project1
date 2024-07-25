package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBControllerYourCric;
import model.TestModel;
import util.StringUtils;

/**
 * Servlet implementation class SerarchTestPlayer
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SerarchTestPlayer" })
public class SerarchTestPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DBControllerYourCric controller = new DBControllerYourCric();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the test name from the request parameter
        String testName = request.getParameter("testName");

        // Call the getSearchTestInfo method with the test name
        ArrayList<TestModel> testDetail = controller.getSearchTestInfo(testName);

        // Set the test details as a request attribute
        request.setAttribute("testlists", testDetail);

        // Forward the request to your JSP to display the filtered test details
        request.getRequestDispatcher(StringUtils.PAGE_URL_RESULT_PLAYER).forward(request, response);
    }

}

