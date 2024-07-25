package model;

import java.io.File;
import java.time.LocalDate;

import javax.servlet.http.Part;

import util.StringUtils;

/**
 * Servlet implementation class PlayerModel
 */

public class PlayerModel   {
	
	
	private String player_ID;
	private String player_FirstName;
	private String player_LastName;
	private String player_Email;
	private String player_Address;
	private String player_Role;
	private LocalDate player_DATE_OF_BIRTH;
	private String player_Password;
	private String imageUrlFromPart;
	private String PhoneNumber;
	
	public PlayerModel(String player_ID, String player_FirstName, String player_LastName, String player_Email,
			String player_Address, String player_Role, LocalDate player_DATE_OF_BIRTH, String player_Password,
			Part imagePart, String phoneNumber) {
		this.player_ID = player_ID;
		this.player_FirstName = player_FirstName;
		this.player_LastName = player_LastName;
		this.player_Email = player_Email;
		this.player_Address = player_Address;
		this.player_Role = player_Role;
		this.player_DATE_OF_BIRTH = player_DATE_OF_BIRTH;
		this.player_Password = player_Password;
		this.imageUrlFromPart = getImageUrl(imagePart);
		this.PhoneNumber = phoneNumber;
	}



public PlayerModel() {
		// TODO Auto-generated constructor stub
	}



public String getPlayer_ID() {
	return player_ID;
}


public void setPlayer_ID(String player_ID) {
	this.player_ID = player_ID;
}


public String getPlayer_FirstName() {
	return player_FirstName;
}


public void setPlayer_FirstName(String player_FirstName) {
	this.player_FirstName = player_FirstName;
}


public String getPlayer_LastName() {
	return player_LastName;
}


public void setPlayer_LastName(String player_LastName) {
	this.player_LastName = player_LastName;
}


public String getPlayer_Email() {
	return player_Email;
}


public void setPlayer_Email(String player_Email) {
	this.player_Email = player_Email;
}


public String getPlayer_Address() {
	return player_Address;
}


public void setPlayer_Address(String player_Address) {
	this.player_Address = player_Address;
}


public String getPlayer_Role() {
	return player_Role;
}


public void setPlayer_Role(String player_Role) {
	this.player_Role = player_Role;
}


public LocalDate getPlayer_DATE_OF_BIRTH() {
	return player_DATE_OF_BIRTH;
}


public void setPlayer_DATE_OF_BIRTH(LocalDate player_DATE_OF_BIRTH) {
	this.player_DATE_OF_BIRTH = player_DATE_OF_BIRTH;
}


public String getPlayer_Password() {
	return player_Password;
}


public void setPlayer_Password(String player_Password) {
	this.player_Password = player_Password;
}


public String getImageUrlFromPart() {
	return imageUrlFromPart;
}


public void setImageUrlFromPart(Part part) {
	this.imageUrlFromPart = getImageUrl(part);
}


public void setImageUrlFromDB(String imageUrl) {
	this.imageUrlFromPart = imageUrl;
}
private String getImageUrl(Part part) {
	String savePath = StringUtils.IMAGE_DIR_SAVE_PATH_PLAYER;
	File fileSaveDir = new File(savePath);
	String imageUrlFromPart = null;
	if (!fileSaveDir.exists()) {
		fileSaveDir.mkdir();
	}
	String contentDisp = part.getHeader("content-disposition");
	String[] items = contentDisp.split(";");
	for (String s : items) {
		if (s.trim().startsWith("filename")) {
			imageUrlFromPart = s.substring(s.indexOf("=") + 2, s.length() - 1);
		}
	}
	if (imageUrlFromPart == null || imageUrlFromPart.isEmpty()) {
		 imageUrlFromPart = "default.png";
	}
	return imageUrlFromPart;
}


	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}



}

