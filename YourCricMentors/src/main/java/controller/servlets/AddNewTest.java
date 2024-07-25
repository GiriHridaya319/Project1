
package controller.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBControllerYourCric;
import model.TestModel;
import util.StringUtils;
import util.ValidationUtil;



/**
 * Servlet implementation class AddNewTest
 */
@WebServlet(asyncSupported = true, urlPatterns = { StringUtils.SERVLET_ADD_TEST})
public class AddNewTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBControllerYourCric dbController;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewTest() {
    	 this.dbController = new DBControllerYourCric();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String test_id = request.getParameter(StringUtils.TEST_ID);
		String test_name = request.getParameter(StringUtils.TEST_NAME);
		String test_location = request.getParameter(StringUtils.TEST_LOCATION);
		LocalDate test_date = LocalDate.parse(request.getParameter(StringUtils.TEST_DATE));
		String test_status = request.getParameter(StringUtils.TEST_STATUS);
		String test_description = request.getParameter(StringUtils.TEST_DESCRIPTION);
		
		
		
		
		if (!ValidationUtil.isTextOnly(test_name) ||
			    !ValidationUtil.isTextOnly(test_status) ||
			    !ValidationUtil.isAlphanumeric(test_location) ||
			    !ValidationUtil.isAlphanumeric(test_id) ||
			    !ValidationUtil.hasNoSpecialCharacters(test_description))
			    {

			    request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_INCORRECT_DATA);
			    request.getRequestDispatcher(StringUtils.PAGE_URL_ADD_NEW_TEST).forward(request, response);
			}
		else if(ValidationUtil.isIDTaken( test_id)) {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_USERNAME);
			request.getRequestDispatcher(StringUtils.PAGE_URL_ADD_NEW_TEST).forward(request, response);
		}
		else {
			
			TestModel test = new TestModel(test_id, test_name,test_location,
					test_date,test_status, test_description);
		
		
		
		int add = dbController.addNewTest(test);
		
		
		if(add == 1) {
			
		    
			request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_REGISTER);
			response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_RESULT_COACH + "?success=true");
		}
		else if(add==0) {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_REGISTER);
			request.getRequestDispatcher(StringUtils.PAGE_URL_ADD_NEW_TEST).forward(request, response);
		}
		
		else {
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
			request.getRequestDispatcher(StringUtils.PAGE_URL_ADD_NEW_TEST).forward(request, response);
		}
		}
		
	}

}
