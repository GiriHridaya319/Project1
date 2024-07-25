package model;

public class PlayersMarks {

	String player_ID;
	String testID;
	String totalTestTaken;
	String total_attempt;
	String marks_obtained;
	
	
	public PlayersMarks(String player_ID, String testID, String totalTestTaken, String total_attempt,
			String marks_obtained) {
		this.player_ID = player_ID;
		this.testID = testID;
		this.totalTestTaken = totalTestTaken;
		this.total_attempt = total_attempt;
		this.marks_obtained = marks_obtained;
	}

	public PlayersMarks() {
		
	}

	public String getPlayer_ID() {
		return player_ID;
	}


	public void setPlayer_ID(String player_ID) {
		this.player_ID = player_ID;
	}


	public String getTestID() {
		return testID;
	}


	public void setTestID(String testID) {
		this.testID = testID;
	}


	public String getTotalTestTaken() {
		return totalTestTaken;
	}


	public void setTotalTestTaken(String totalTestTaken) {
		this.totalTestTaken = totalTestTaken;
	}


	public String getTotal_attempt() {
		return total_attempt;
	}


	public void setTotal_attempt(String total_attempt) {
		this.total_attempt = total_attempt;
	}


	public String getMarks_obtained() {
		return marks_obtained;
	}


	public void setMarks_obtained(String marks_obtained) {
		this.marks_obtained = marks_obtained;
	}
	
	
	
	
}


