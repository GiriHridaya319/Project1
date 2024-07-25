package util;

import java.io.File;

/**
 * Servlet implementation class StringUtils
 */

public class StringUtils {
	
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String LOCALHOST_URL = "jdbc:mysql://localhost:3306/yourcricmentor";
	public static final String LOCALHOST_USERNAME = "root";
	public static final String LOCALHOST_PASSWORD = "";
	
	public static final String IMAGE_DIR_PLAYER ="Users\\Nitro\\eclipse-workspace\\YourCricMentors\\src\\main\\webapp\\resources\\images\\Player\\";
	public static final String IMAGE_DIR_SAVE_PATH_PLAYER ="C:" + File.separator + IMAGE_DIR_PLAYER;
	
	
	public static final String IMAGE_DIR_COACH = "Users\\Nitro\\eclipse-workspace\\YourCricMentors\\src\\main\\webapp\\resources\\images\\Coach\\";
	public static final String IMAGE_DIR_SAVE_PATH_COACH ="C:" + File.separator + IMAGE_DIR_COACH;
	
	public static final String QUERY_REGISTER_PLAYER = "INSERT INTO player_info ("+
			 "player_ID,Player_FirstName, Player_LastName, Player_Email, Player_Address, Player_Role, Player_DATE_OF_BIRTH, Player_Password, Player_image, Player_PhoneNumber) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
	
	public static final String QUERY_REGISTER_COACH = "INSERT INTO coach_info ("+
			 "Coach_ID ,Coach_FirstName, Coach_LastName, Coach_Type, Coach_Email, Coach_PhoneNumber, Total_Experience, Coach_password, Coach_image) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
	
	
	
	
	public static final String QUERY_INSERT_NEW_TEST = "INSERT INTO test_info ("+
			 "Test_ID ,Test_Name, Location_of_Test, Test_Date, Test_Status, Test_Description) "
			+ "VALUES (?, ?, ?, ?, ?, ?)";
	
	public static final String QUERY_LOGIN_COACH_CHECK = "SELECT * FROM coach_info WHERE Coach_ID = ?";
	public static final String QUERY_GET_ALL_COACH = "SELECT * FROM coach_info";
	
	//user photo
	public static final String QUERY_IMAGE_OF_USER = "SELECT Player_image  FROM player_info WHERE player_ID = ?";

	
	public static final String QUERY_IMAGE_OF_COACH = "SELECT Coach_image  FROM coach_info WHERE Coach_ID = ?";
	
	public static final String QUERY_LOGIN_PLAYER_CHECK = "SELECT * FROM player_info WHERE player_ID = ?";
	public static final String QUERY_TEST_INFO = "SELECT * FROM test_info WHERE Test_ID = ?";
	public static final String QUERY_GET_ALL_PLAYER = "SELECT * FROM player_info";
	
	//test
	public static final String QUERY_GET_ALL_TEST = "SELECT * FROM test_info";
	public static final String QUERY_SEARCH_ALL_TEST = "SELECT * FROM test_info WHERE Test_Name LIKE ?";
	
	// result coach
	public static final String QUERY_GET_ALL_MARKS = "SELECT * FROM test_details";
	
	public static final String QUERY_DELETE_PLAYER = "DELETE FROM player_info WHERE player_ID = ?";
	public static final String QUERY_DELETE_COACH = "DELETE FROM coach_info WHERE coach_ID = ?";
	public static final String QUERY_DELETE_TEST = "DELETE FROM test_info WHERE Test_ID = ?";
	public static final String QUERY_UPDATE_PLAYER = "UPDATE player_info SET  Player_image = ?, Player_FirstName = ?,Player_PhoneNumber = ?, Player_LastName = ?, Player_Email = ?, Player_Address = ? WHERE player_ID=?";
	public static final String QUERY_UPDATE_COACH = "UPDATE coach_info  SET Coach_image = ?, Coach_FirstName = ?,Coach_PhoneNumber = ?, Coach_LastName = ?, Coach_Email = ?, Total_Experience = ? WHERE Coach_ID=?";
	public static final String QUERY_UPDATE_TEST = "UPDATE test_info SET Test_Name = ?, Location_of_Test = ?, Test_Status = ?, Test_Description = ? WHERE Test_ID = ?";
	
	
	
	
	
	public static final String COACH_USERNAME_ID = "Coach_ID";
	public static final String COACH_FIRST_NAME = "Coach_FirstName";
	public static final String COACH_LAST_NAME = "Coach_LastName";
	public static final String COACH_PHONE_NUM = "Coach_PhoneNumber";
	public static final String COACH_EMAIL = "Coach_Email";
	public static final String COACH_TYPE = "Coach_Type";
	public static final String COACH_TOTAL_EXP = "Total_Experience(in years)";
	public static final String COACH_PASSWORD = "Coach_password";
	public static final String COACH_PASSWORD_RETYPE = "Coach_password_retype";
	
	public static final String COACH_IMAGE = "Coach_image";
	
	
	public static final String PLAYER_USERNAME_ID = "player_ID";
	public static final String PLAYER_FIRST_NAME = "Player_FirstName";
	public static final String PLAYER_LAST_NAME = "Player_LastName";
	public static final String PLAYER_EMAIL = "Player_Email";
	public static final String PLAYER_ADDRESS = "Player_Address";
	public static final String PLAYER_ROLE = "Player_Role";
	public static final String PLAYER_DATE_OF_BIRTH = "Player_date_of_birth";
	public static final String PLAYER_PASSWORD = "Player_Password";
	public static final String PLAYER_RETYPE_PASSWORD = "RetypePlayer_Password";
	public static final String PLAYER_PHONENUMBER = "Player_PhoneNum";
	public static final String PLAYER_IMAGE = "Player_Image";
	
	
	//test
	public static final String TEST_ID = "Test_ID";
	public static final String TEST_NAME = "Test_Name";
	public static final String TEST_LOCATION = "Location_of_Test";
	public static final String TEST_DATE = "Test_Date";
	public static final String TEST_STATUS = "Test_Status";
	public static final String TEST_DESCRIPTION = "Test_Description";
	
	
	//login
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	
	public static final String MESSAGE_SUCCESS_REGISTER = "Successfully Registered!";
	public static final String MESSAGE_ERROR_REGISTER = "Please correct the form data.";
	public static final String MESSAGE_ERROR_USERNAME = "Username is already registered.";
	public static final String MESSAGE_ERROR_EMAIL = "Email is already registered.";
	public static final String MESSAGE_ERROR_PHONE_NUMBER = "Phone number is already registered.";
	public static final String MESSAGE_ERROR_PASSWORD_UNMATCHED = "Password is not matched.";
	public static final String MESSAGE_ERROR_INCORRECT_DATA = "Please correct all the fields.";
	
	public static final String MESSAGE_SUCCESS_LOGIN = "Successfully LoggedIn!";
	public static final String MESSAGE_ERROR_LOGIN = "Either username or password is not correct!";
	public static final String MESSAGE_ERROR_CREATE_ACCOUNT = "Account for this username is not registered! Please create a new account.";

	// Other Messages
	public static final String MESSAGE_ERROR_SERVER = "An unexpected server error occurred.";
	public static final String MESSAGE_SUCCESS_DELETE = "Successfully Deleted!";
	public static final String MESSAGE_ERROR_DELETE = "Cannot delete the user!";
	
	public static final String MESSAGE_SUCCESS_UPDATE = "Successfully Updated!";
	public static final String MESSAGE_ERROR_UPDATE = "Cannot update the user!";
	

	public static final String MESSAGE_SUCCESS = "successMessage";
	public static final String MESSAGE_ERROR = "errorMessage";
	// End: Validation Messages
	
	

	// Start: JSP Route
		public static final String PAGE_URL_LOGIN_PLAYER = "/Pages/LoginPage.jsp";
		public static final String PAGE_URL_LOGIN_COACH = "/Pages/LoginForCoach.jsp";
		public static final String PAGE_URL_REGISTER = "/Pages/Register.jsp";
		public static final String PAGE_URL_HOMEPAGE = "/HomePage.jsp";
		public static final String PAGE_URL_HOME_PLAYER = "/Pages/UserLoginHomePage.jsp";
		public static final String PAGE_URL_HOME_COACH = "/Pages/CoachLoginHomePage.jsp";
		public static final String PAGE_URL_RESULT_COACH = "/Pages/Result.jsp";
		public static final String PAGE_URL_RESULT_PLAYER = "/Pages/PlayersResult.jsp";
		public static final String PAGE_URL_PROFILE_PLAYER = "/Pages/UserDashBoard.jsp";
		public static final String PAGE_URL_PROFILE_COACH = "/Pages/CoachDashBoard.jsp";
		public static final String PAGE_URL_ABOUT_US = "/Pages/AboutUs.jsp";
		public static final String PAGE_URL_LOGGED_HEADER_PLAYER = "/Pages/LoggedInHeader.jsp";
		public static final String PAGE_URL_LOGGED_HEADER_COACH = "/Pages/LoggedInheaderCoach.jsp";
		public static final String PAGE_URL_ADD_NEW_TEST= "/Pages/AddNewTest.jsp";
		public static final String PAGE_URL_UPDATE_NEW_TEST= "/Pages/UpdateTest.jsp";
		
	// Start: Servlet Route player
		
		public static final String SERVLET_URL_LOGIN_PLAYER  = "/LoginPlayerServlets";
		public static final String SERVLET_URL_REGISTER_PLAYER = "/registerplayers";
		public static final String SERVLET_URL_HOME = "/HomePageServlet";
		public static final String SERVLET_URL_HOME_COACH = "/HomePageCoachServlet";
		public static final String SERVLET_URL_MAIN_PAGE  = "/MainPageServlet" ;
		public static final String SERVLET_URL_LOGOUT = "/LogOutServlet";
		public static final String SERVLET_URL_LOGIN_COACH  = "/LoginCoachServlet";
		public static final String SERVLET_URL_TEST_INFO  = "/PlayerResult";
		public static final String SERVLET_URL_COACH_RESULT  = "/CoachResult";
		public static final String SERVLET_PLAYER_PROFILE  = "/PlayerProfile";
		public static final String SERVLET_COACH_PROFILE  ="/CocachProfile";
		public static final String SERVLET_MODIFY_PLAYER  = "/ModifyPlayerServlet";
		public static final String SERVLET_ADD_TEST = "/AddNewTest";
		public static final String SERVLET_UPDATE_TEST =  "/modifyTestServlet";
		public static final String SERVLET_UPDATE_TEST_DETAIL =  "/updateTest";
		public static final String SERVLET_MODIFY_COACH  ="/ModifyCoachServlet";
		// servlet route coach  
		
		public static final String SERVLET_URL_REGISTER_COACH = "/RegisterCoachServlet";
		
		
		
	
		public static final String PLAYER = "user";
		public static final String COACH = "coach";
		public static final String SUCCESS = "success";
		public static final String TRUE = "true";
		public static final String JSESSIONID = "JSESSIONID";
		public static final String LOGIN = "Login";
		public static final String LOGOUT = "Logout";
		public static final String PLAYER_MODEL = "playerModel";
		public static final String PLAYER_LIST = "playerLists";
		public static final String COACH_LIST = "coachLists";
		public static final String TEST_LIST = "testlists";
		public static final String MARKS_LIST = "markslists";
		public static final String SLASH= "/";
		public static final String UPDATE_ID = "updateId";
		public static final String UPDATE_ID_COACH = "updateIdCoach";
		public static final String DELETE_ID = "deleteId";
		public static final String UPDATE_Test_ID = "updateTestId";
		public static final String DELETE_ID_ = "deleteId";
		
}
