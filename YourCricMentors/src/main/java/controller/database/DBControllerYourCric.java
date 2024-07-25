package controller.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CoachLoginModel;
import model.CoachModel;
import model.PlayerLoginModel;
import model.PasswordEncryptionWithAes;
import model.PlayerModel;
import model.PlayersMarks;
import model.TestModel;
import util.StringUtils;

/**
 * Servlet implementation class DBController
 */
public class DBControllerYourCric {

	public Connection getConnection() throws SQLException, ClassNotFoundException {

		Class.forName(StringUtils.DRIVER_NAME);

		return DriverManager.getConnection(StringUtils.LOCALHOST_URL, StringUtils.LOCALHOST_USERNAME,
				StringUtils.LOCALHOST_PASSWORD);
	}

	public int register_player(PlayerModel player) {

		try {
			
			PreparedStatement statement = getConnection().prepareStatement(StringUtils.QUERY_REGISTER_PLAYER);

			
			statement.setString(1, player.getPlayer_ID());
			statement.setString(2, player.getPlayer_FirstName());
			statement.setString(3, player.getPlayer_LastName());
			statement.setString(4, player.getPlayer_Email());
			statement.setString(5, player.getPlayer_Address());
			statement.setString(6, player.getPlayer_Role());
			statement.setDate(7, Date.valueOf(player.getPlayer_DATE_OF_BIRTH()));
			statement.setString(8,
					PasswordEncryptionWithAes.encrypt(player.getPlayer_ID(), player.getPlayer_Password()));
			statement.setString(9, player.getImageUrlFromPart());
			statement.setString(10, player.getPhoneNumber());

			
			int player_registered = statement.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (player_registered > 0) {
				return 1; // to show Registration successful
			} else {
				return 0; // Registration is not succeed
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; 
		}

	}

	public int addNewTest(TestModel Test) {

		try {
			// Prepare a statement using the predefined query for student registration
			PreparedStatement statement = getConnection().prepareStatement(StringUtils.QUERY_INSERT_NEW_TEST);

			// Set the student information in the prepared statement
			statement.setString(1, Test.getTestID());
			statement.setString(2, Test.getTestName());
			statement.setString(3, Test.getLocation_of_Test());
			statement.setDate(4, Date.valueOf(Test.getTest_Date()));
			statement.setString(5, Test.getTest_Status());
			statement.setString(6, Test.getTestDescription());

			// Execute the update statement and store the number of affected rows
			int test_added = statement.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (test_added > 0) {
				return 1; 
			} else {
				return 0; 
			}

		} catch (ClassNotFoundException | SQLException ex) {
			
			ex.printStackTrace();
			return -1; 
		}

	}

	public int getPlayerLoginInfo(PlayerLoginModel Loginplayer) {

		try {
			PreparedStatement statement = getConnection().prepareStatement(StringUtils.QUERY_LOGIN_PLAYER_CHECK);

			statement.setString(1, Loginplayer.getPlayer_ID());
			ResultSet resultPlayer = statement.executeQuery();

			if (resultPlayer.next()) {
				String playerData = resultPlayer.getString(StringUtils.PLAYER_USERNAME_ID);

				String encryptedPwdPlayer = resultPlayer.getString(StringUtils.PLAYER_PASSWORD);

				String decryptedPwdPlayer = PasswordEncryptionWithAes.decrypt(playerData, encryptedPwdPlayer);

				if (playerData.equals(Loginplayer.getPlayer_ID())
						&& decryptedPwdPlayer.equals(Loginplayer.getPlayer_Password())) {
					return 1;

				} else {
					return 0;
				}
			} else {
				return -1;
			}

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			// Return -2 to indicate an internal error
			return -2;
		}

	}

	public ArrayList<PlayerModel> getAllStudentsInfo() {

		try {
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_GET_ALL_PLAYER);
			ResultSet result = stmt.executeQuery();

			ArrayList<PlayerModel> players = new ArrayList<PlayerModel>();

			while (result.next()) {
				PlayerModel player = new PlayerModel();
				player.setPlayer_FirstName(result.getString("Player_FirstName"));
				player.setPlayer_LastName(result.getString("Player_LastName"));
				player.setPlayer_Email(result.getString("Player_Email"));
				player.setPlayer_Address(result.getString("Player_Address"));
				player.setPlayer_Role(result.getString("Player_Role"));
				player.setPlayer_DATE_OF_BIRTH(result.getDate("Player_DATE_OF_BIRTH").toLocalDate());
				player.setPlayer_Password(result.getString("Player_Password"));
				player.setImageUrlFromDB(result.getString("Player_image"));
				player.setPhoneNumber(result.getString("Player_PhoneNumber"));

				players.add(player);
			}
			return players;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	

	public int register_coach(CoachModel coach) {

		try {
			// Prepare a statement using the predefined query for student registration
			PreparedStatement statement = getConnection().prepareStatement(StringUtils.QUERY_REGISTER_COACH);

			// Set the student information in the prepared statement
			statement.setString(1, coach.getCoach_ID());
			statement.setString(2, coach.getCoach_FirstName());
			statement.setString(3, coach.getCoach_LastName());
			statement.setString(4, coach.getCoach_Type());
			statement.setString(5, coach.getCoach_Email());
			statement.setString(6, coach.getCoach_PhoneNumber());
			statement.setString(7, coach.getTotal_Experience());
			statement.setString(8, PasswordEncryptionWithAes.encrypt(coach.getCoach_ID(), coach.getCoach_password()));
			statement.setString(9, coach.getImageUrlFromPart());

			// Execute the update statement and store the number of affected rows
			int coach_registered = statement.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (coach_registered > 0) {
				return 1; 
			} else {
				return 0; 
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1;
		}

	}

	public int getCoachLoginInfo(CoachLoginModel LoginCoach) {

		try {
			PreparedStatement statement = getConnection().prepareStatement(StringUtils.QUERY_LOGIN_COACH_CHECK);

			statement.setString(1, LoginCoach.getCoach_ID());
			ResultSet resultPlayer = statement.executeQuery();

			if (resultPlayer.next()) {
				String coachData = resultPlayer.getString(StringUtils.COACH_USERNAME_ID);

				String encryptedPwdCoach = resultPlayer.getString(StringUtils.COACH_PASSWORD);

				String decryptedPwdcoach = PasswordEncryptionWithAes.decrypt(coachData, encryptedPwdCoach);

				if (coachData.equals(LoginCoach.getCoach_ID())
						&& decryptedPwdcoach.equals(LoginCoach.getCoach_password())) {
					return 1;

				} else {
					return 0;
				}
			} else {
				return -1;
			}

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			// 
			return -2;
		}

	}

	public ArrayList<CoachModel> getAllCoachInfo() {

		try {
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_GET_ALL_COACH);
			ResultSet result = stmt.executeQuery();

			ArrayList<CoachModel> Coaches = new ArrayList<CoachModel>();

			while (result.next()) {
				CoachModel coach = new CoachModel();
				coach.setCoach_FirstName(result.getString("Coach_FirstName"));
				coach.setCoach_LastName(result.getString("Coach_LastName"));
				coach.setCoach_Type(result.getString("Coach_Type"));
				coach.setCoach_Email(result.getString("Coach_Email"));
				coach.setCoach_PhoneNumber(result.getString("Coach_PhoneNumber"));
				coach.setTotal_Experience(result.getString("Total_Experience"));
				coach.setImageUrlFromDB(result.getString("Coach_image"));

				Coaches.add(coach);
			}
			return Coaches;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<TestModel> getAllTestInfo() {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_GET_ALL_TEST);
			ResultSet result = stmt.executeQuery();

			ArrayList<TestModel> testsDetails = new ArrayList<TestModel>();

			while (result.next()) {
				TestModel tests = new TestModel();
				tests.setTestID(result.getString("Test_ID"));
				tests.setTestName(result.getString("Test_Name"));
				tests.setLocation_of_Test(result.getString("Location_of_Test"));
				tests.setTest_Date(result.getDate("Test_Date").toLocalDate());
				tests.setTest_Status(result.getString("Test_Status"));
				tests.setTestDescription(result.getString("Test_Description"));

				testsDetails.add(tests);
			}

			return testsDetails;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<PlayersMarks> getAllPlayerResultInfo() {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_GET_ALL_MARKS);
			ResultSet result = stmt.executeQuery();

			ArrayList<PlayersMarks> marksDetails = new ArrayList<PlayersMarks>();

			while (result.next()) {
				PlayersMarks marks = new PlayersMarks();
				marks.setTestID(result.getString("Test_ID"));
				marks.setPlayer_ID(result.getString("player_ID"));
				marks.setTotalTestTaken(result.getString("Total_Test_Taken"));
				marks.setTotal_attempt(result.getString("Total_Attempt"));
				marks.setMarks_obtained(result.getString("Marks_Obtained"));

				marksDetails.add(marks);
			}

			return marksDetails;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<TestModel> getSearchTestInfo(String testName) {
		try {
			// a wildcard parameter for Test_Name
			PreparedStatement statement = getConnection().prepareStatement(StringUtils.QUERY_SEARCH_ALL_TEST);
			statement.setString(1, "%" + testName + "%"); 

			ResultSet resultTest = statement.executeQuery();

			ArrayList<TestModel> searchTest = new ArrayList<TestModel>();

			while (resultTest.next()) {
				TestModel test = new TestModel();
				test.setTestID(resultTest.getString("Test_ID"));
				test.setTestName(resultTest.getString("Test_Name"));
				test.setTest_Date(resultTest.getDate("Test_Date").toLocalDate());
				test.setLocation_of_Test(resultTest.getString("Location_of_Test"));
				test.setTestDescription(resultTest.getString("Test_Description"));
				test.setTest_Status(resultTest.getString("Test_Status"));

				searchTest.add(test);
			}
			return searchTest;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			
			return null;
		}
	}

	public String getImagePlayer(PlayerModel username) {
		try {
			PreparedStatement statement = getConnection().prepareStatement(StringUtils.QUERY_IMAGE_OF_USER);

			statement.setString(1, username.getPlayer_ID());
			ResultSet resultPlayer = statement.executeQuery();

			if (resultPlayer.next()) {

				return resultPlayer.getString(StringUtils.PLAYER_IMAGE);
			} else {
				return null; // Return null if no image found for the player
			}

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			
			return null;
		}
	}

	public PlayerModel getDetailsUser(String username) {
		try {
			PreparedStatement statement = getConnection().prepareStatement(StringUtils.QUERY_LOGIN_PLAYER_CHECK);
			statement.setString(1, username);
			ResultSet resultPlayer = statement.executeQuery();

			PlayerModel player = new PlayerModel();
			while (resultPlayer.next()) {
				player.setPlayer_ID(resultPlayer.getString("player_ID"));
				player.setPlayer_FirstName(resultPlayer.getString("Player_FirstName"));
				player.setPlayer_LastName(resultPlayer.getString("Player_LastName"));
				player.setPlayer_Email(resultPlayer.getString("Player_Email"));
				player.setPlayer_Address(resultPlayer.getString("Player_Address"));
				player.setPlayer_Role(resultPlayer.getString("Player_Role"));
				player.setPlayer_DATE_OF_BIRTH(resultPlayer.getDate("Player_DATE_OF_BIRTH").toLocalDate());
				player.setPlayer_Password(resultPlayer.getString("Player_Password"));
				player.setImageUrlFromDB(resultPlayer.getString("Player_image"));
				player.setPhoneNumber(resultPlayer.getString("Player_PhoneNumber"));

			}
			return player;

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			
			return null;
		}

	}

	public CoachModel getDetailsCoach(String username) {
		try {
			PreparedStatement statement = getConnection().prepareStatement(StringUtils.QUERY_LOGIN_COACH_CHECK);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();

			CoachModel coach = new CoachModel();
			while (result.next()) {
				coach.setCoach_ID(result.getString("Coach_ID"));
				coach.setCoach_FirstName(result.getString("Coach_FirstName"));
				coach.setCoach_LastName(result.getString("Coach_LastName"));
				coach.setCoach_Type(result.getString("Coach_Type"));
				coach.setCoach_Email(result.getString("Coach_Email"));
				coach.setCoach_PhoneNumber(result.getString("Coach_PhoneNumber"));
				coach.setTotal_Experience(result.getString("Total_Experience"));
				coach.setImageUrlFromDB(result.getString("Coach_image"));

			}
			return coach;

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			
			return null;
		}

	}

	public TestModel getDetailsTest(String testID) {
		try {
			PreparedStatement statement = getConnection().prepareStatement(StringUtils.QUERY_TEST_INFO);
			statement.setString(1, testID);
			ResultSet resultPlayer = statement.executeQuery();

			TestModel test = new TestModel();
			while (resultPlayer.next()) {
				test.setTestID(resultPlayer.getString("Test_ID"));
				test.setTestName(resultPlayer.getString("Test_Name"));
				test.setTest_Date(resultPlayer.getDate("Test_Date").toLocalDate());
				test.setLocation_of_Test(resultPlayer.getString("Location_of_Test"));
				test.setTestDescription(resultPlayer.getString("Test_Description"));
				test.setTest_Status(resultPlayer.getString("Test_Status"));

			}
			return test;

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			
			return null;
		}

	}

	public String getImageCoach(CoachModel coachUserName) {
		try {
			PreparedStatement statement = getConnection().prepareStatement(StringUtils.QUERY_IMAGE_OF_COACH);

			
			statement.setString(1, coachUserName.getCoach_ID());
			ResultSet resultCoach = statement.executeQuery();

			if (resultCoach.next()) {
				
				return resultCoach.getString(StringUtils.COACH_IMAGE);
			} else {
				return null; // Return null if no image found for the player
			}

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			// Return null to indicate an internal error
			return null;
		}
	}

	public int deleteTestInfo(String testId) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtils.QUERY_DELETE_TEST);
			st.setString(1, testId);
			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); 
			return -1;
		}
	}

	public int deletePlayerInfo(String playerId) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtils.QUERY_DELETE_PLAYER);
			st.setString(1, playerId);
			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); 
			return -1;
		}
	}

	public int deleteCoachInfo(String coachId) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtils.QUERY_DELETE_COACH);
			st.setString(1, coachId);
			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); 
			return -1;
		}
	}

	public int updatePlayerInfo(String player_id, String firstName, String lastName, String email, String address,
			String phoneNum, String image) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtils.QUERY_UPDATE_PLAYER);

			st.setString(1, image);
			st.setString(2, firstName);
			st.setString(3, phoneNum);
			st.setString(4, lastName);
			st.setString(5, email);
			st.setString(6, address);
			st.setString(7, player_id);

			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); 
			return -1;
		}
	}

	public int updateCoachInfo(String coach_id, String firstName, String lastName, String email, String phone,
			String experience, String image) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtils.QUERY_UPDATE_COACH);

			st.setString(1, image);
			st.setString(2, firstName);
			st.setString(3, phone);
			st.setString(4, lastName);
			st.setString(5, email);
			st.setString(6, experience);
			st.setString(7, coach_id);

			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); 
			return -1;
		}
	}

	public int updateTestInfo(String test_id, String test_name, String location_of_test, String test_status,
			String test_description) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtils.QUERY_UPDATE_TEST);

			st.setString(1, test_name);
			st.setString(2, location_of_test);
			st.setString(3, test_status);
			st.setString(4, test_description);
			st.setString(5, test_id);

			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); 
			return -1;
		}
	}

}
