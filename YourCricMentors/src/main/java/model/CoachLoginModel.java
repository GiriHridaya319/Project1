package model;

/**
 * Servlet implementation class CoachLoginModel
 */
public class CoachLoginModel  {
	
	
	private String Coach_ID;
	private String Coach_password;
	
	public CoachLoginModel(String coach_ID, String coach_password) {
		Coach_ID = coach_ID;
		Coach_password = coach_password;
	}

	public String getCoach_ID() {
		return Coach_ID;
	}

	public void setCoach_ID(String coach_ID) {
		Coach_ID = coach_ID;
	}

	public String getCoach_password() {
		return Coach_password;
	}

	public void setCoach_password(String coach_password) {
		Coach_password = coach_password;
	}
	
	
}
