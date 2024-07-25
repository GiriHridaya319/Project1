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
 * Servlet implementation class modifyTestServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.SERVLET_UPDATE_TEST })
public class modifyTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private final DBControllerYourCric dbController;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyTestServlet() {
    	this.dbController = new DBControllerYourCric();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String updateTestId = request.getParameter(StringUtils.UPDATE_Test_ID);
	    String deleteId = request.getParameter(StringUtils.DELETE_ID);

	    if (updateTestId != null && !updateTestId.isEmpty()) {
	        doPut(request, response);
	    } else if (deleteId != null && !deleteId.isEmpty()) {
	        doDelete(request, response);
	    }
	   
	}
    
	    protected void doPut(HttpServletRequest request, HttpServletResponse resp)
		        throws ServletException, IOException {
	    	String test_id = request.getParameter("Test_ID");
			String test_name = request.getParameter("Test_Name");
			String test_location = request.getParameter("Location_of_Test");
			String test_status = request.getParameter("Test_Status");
			String test_description = request.getParameter("Test_Description");
			
			
	
			if (!ValidationUtil.isTextOnly(test_name) ||
				    !ValidationUtil.isTextOnly(test_status) ||
				    !ValidationUtil.isAlphanumeric(test_location) ||
				    !ValidationUtil.isAlphanumeric(test_id) ||
				    !ValidationUtil.isAlphanumeric(test_description))
				    {

				    request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_INCORRECT_DATA);
				    request.getRequestDispatcher(StringUtils.PAGE_URL_UPDATE_NEW_TEST).forward(request, resp);
				}
			else {
				int rowsAffected = dbController.updateTestInfo(test_id, test_name, test_location, test_status, test_description);
		    if (rowsAffected == 1) {
		        request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_UPDATE);
		        resp.sendRedirect(request.getContextPath() + StringUtils.SERVLET_URL_COACH_RESULT);
		    } else {
		        request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_UPDATE);
		        request.getRequestDispatcher(StringUtils.SERVLET_URL_HOME_COACH).forward(request, resp);
		    }
			}
		    
	    
	}
	    
	    @Override
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			if (dbController.deleteTestInfo(req.getParameter(StringUtils.DELETE_ID)) == 1) {
				req.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_DELETE);
				resp.sendRedirect(req.getContextPath() + StringUtils.PAGE_URL_RESULT_COACH);
			} else {
				req.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_DELETE);
				resp.sendRedirect(req.getContextPath() + StringUtils.PAGE_URL_RESULT_COACH);
			}
		}
    

}
