package model;


public class PlayerLoginModel {
	
	private String player_ID;
	private String player_Password;
	
	public  PlayerLoginModel(String player_ID, String player_Password) {
		this.player_ID = player_ID;
		this.player_Password = player_Password;
	}

	public String getPlayer_ID() {
		return player_ID;
	}

	public void setPlayer_ID(String player_ID) {
		this.player_ID = player_ID;
	}

	public String getPlayer_Password() {
		return player_Password;
	}

	public void setPlayer_Password(String player_Password) {
		this.player_Password = player_Password;
	}
	
	
	
}
	