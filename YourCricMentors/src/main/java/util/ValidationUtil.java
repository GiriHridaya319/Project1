package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidationUtil {

public Connection getConnection() throws SQLException, ClassNotFoundException{
		
		Class.forName(StringUtils.DRIVER_NAME);
		
		return DriverManager.getConnection(StringUtils.LOCALHOST_URL,
				StringUtils.LOCALHOST_USERNAME, StringUtils.LOCALHOST_PASSWORD);
	}
	
	  public static boolean isTextOnly(String text) {
	        return text.matches("[a-zA-Z\\s]+"); // Match letters and whitespace only
	    }

	    /**
	     * Validates if the provided text contains only digits (0-9).
	     * 
	     * @param text The text to be validated.
	     * @return True if the text contains only digits, false otherwise.
	     */
	    public static boolean isNumbersOnly(String text) {
	        return text.matches("\\d+"); // Match digits only
	    }

	    /**
	     * Validates if the provided text is alphanumeric, containing only letters and digits.
	     * 
	     * @param text The text to be validated.
	     * @return True if the text is alphanumeric, false otherwise.
	     */
	    public static boolean isAlphanumeric(String text) {
	        return text.matches("[a-zA-Z0-9\\s]+"); // Match letters, digits, and whitespace
	    }

	    /**
	     * Validates if the provided text is a valid email address format.
	     * 
	     * @param email The email address to be validated.
	     * @return True if the email address has a valid format, false otherwise.
	     */
	    public static boolean isEmail(String email) {
	        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$"); // Match standard email pattern
	    }

	    /**
	     * Validates if the provided text contains no special characters other than letters, digits, and whitespace.
	     * 
	     * @param text The text to be validated.     
	     * @return True if the text contains no special characters, false otherwise.
	     */
	    public static boolean hasNoSpecialCharacters(String text) {
	        return text.matches("[a-zA-Z0-9\\s]+"); // Match only letters, digits, and whitespace
	    }
	    
	    public static boolean doPasswordsMatch(String password, String retypePassword) {
	        return password.equals(retypePassword);
	    }
	    

	    /**
	     * Validates if the provided password meets complexity requirements:
	     * - Contains at least one uppercase letter (A-Z)
	     * - Contains at least one lowercase letter (a-z)
	     * - Contains at least one digit (0-9)
	     * - Contains at least one symbol (@$!%*?&).
	     * 
	     * @param password The password to be validated.
	     * @return True if the password meets complexity requirements, false otherwise.
	     */
	    public static boolean isValidPassword(String password) {
	        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]*$");
	    }
	    /**
	     * Validates if the provided text has the specified length.
	     * 
	     * @param text The text to be validated.
	     * @param length The expected length of the text.
	     * @return True if the text has the specified length, false otherwise.
	     */
	    public static boolean hasLength(String text, int length) {
	        return text.length() == length;
	    }
	    
	    
	    
	    public static boolean isUsernameTaken(String username) {
	        try (Connection conn =new ValidationUtil().getConnection();
	             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM player_info WHERE player_ID = ?")) {
	            stmt.setString(1, username);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    int count = rs.getInt(1);
	                    return count > 0; // Username exists if count is greater than 0
	                }
	            }
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	    
	    
	    public static boolean isEmailTaken(String email) {
	        try (Connection conn = new ValidationUtil().getConnection();
	             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM player_info WHERE Player_Email = ?")) {
	            stmt.setString(1, email);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    int count = rs.getInt(1);
	                    return count > 0; // Email exists if count is greater than 0
	                }
	            }
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	    
	    public static boolean isPhoneNumberTaken(String phoneNumber) {
	        try (Connection conn = new ValidationUtil().getConnection();
	             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM player_info WHERE Player_PhoneNumber = ?")) {
	            stmt.setString(1, phoneNumber);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    int count = rs.getInt(1);
	                    return count > 0; // Phone number exists if count is greater than 0
	                }
	            }
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	    
	    
	    
	    public static boolean isUsernameTakenCoach(String username) {
	        try (Connection conn =new ValidationUtil().getConnection();
	             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM coach_info WHERE Coach_ID = ?")) {
	            stmt.setString(1, username);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    int count = rs.getInt(1);
	                    return count > 0; // Username exists if count is greater than 0
	                }
	            }
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	    
	    public static boolean isIDTaken(String id) {
	        try (Connection conn =new ValidationUtil().getConnection();
	             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM test_info WHERE Test_ID = ?")) {
	            stmt.setString(1, id);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    int count = rs.getInt(1);
	                    return count > 0; // Username exists if count is greater than 0
	                }
	            }
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	    
	    
	    public static boolean isEmailTakenCoach(String email) {
	        try (Connection conn = new ValidationUtil().getConnection();
	             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM coach_info WHERE Coach_Email = ?")) {
	            stmt.setString(1, email);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    int count = rs.getInt(1);
	                    return count > 0; // Email exists if count is greater than 0
	                }
	            }
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	    
	    public static boolean isPhoneNumberTakenCoach(String phoneNumber) {
	        try (Connection conn = new ValidationUtil().getConnection();
	             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM coach_info WHERE Coach_PhoneNumber = ?")) {
	            stmt.setString(1, phoneNumber);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    int count = rs.getInt(1);
	                    return count > 0; // Phone number exists if count is greater than 0
	                }
	            }
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	    
	    
	    
}
