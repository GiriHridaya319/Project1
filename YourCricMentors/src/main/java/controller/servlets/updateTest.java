package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBControllerYourCric;
import model.TestModel;
import util.StringUtils;

/**
 * Servlet implementation class updateTest
 */
@WebServlet(asyncSupported = true, urlPatterns = { StringUtils.SERVLET_UPDATE_TEST_DETAIL})
public class updateTest extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    DBControllerYourCric controller = new DBControllerYourCric();

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Retrieve the Test ID from request parameter
	        String testID = request.getParameter(StringUtils.UPDATE_Test_ID);
	        
	        // Retrieve details for the Test ID
	        TestModel testDetail = controller.getDetailsTest(testID);
	        
	        // Set the test details as a request attribute
	        request.setAttribute("loggedInTests", testDetail);
        
        // Forward the request to the JSP page
        request.getRequestDispatcher(StringUtils.PAGE_URL_UPDATE_NEW_TEST).forward(request, response);
    }
}

