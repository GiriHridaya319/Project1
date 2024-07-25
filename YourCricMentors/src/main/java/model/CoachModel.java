package model;

import java.io.File;

import javax.servlet.http.Part;

import util.StringUtils;

/**
 * Servlet implementation class CoachModel
 */

public class CoachModel  {
	
	private String Coach_ID;
	private String Coach_FirstName;
	private String Coach_LastName;
	private String Coach_Type;
	private String Coach_Email;
	private String Coach_PhoneNumber;
	private String Total_Experience;
	private String Coach_password;
	private String imageUrlFromPart;
	
	
	
	public CoachModel(String coach_ID, String coach_FirstName, String coach_LastName, String coach_Type,
			String coach_Email, String coach_PhoneNumber, String total_Experience, String coach_password,
			Part imagePart) {
		this.Coach_ID = coach_ID;
		this.Coach_FirstName = coach_FirstName;
		this.Coach_LastName = coach_LastName;
		this.Coach_Type = coach_Type;
		this.Coach_Email = coach_Email;
		this.Coach_PhoneNumber = coach_PhoneNumber;
		this.Total_Experience = total_Experience;
		this.Coach_password = coach_password;
		this.imageUrlFromPart = getImageUrl(imagePart);
	}



	public CoachModel() {
		// TODO Auto-generated constructor stub
	}



	public String getCoach_ID() {
		return Coach_ID;
	}



	public void setCoach_ID(String coach_ID) {
		Coach_ID = coach_ID;
	}



	public String getCoach_FirstName() {
		return Coach_FirstName;
	}



	public void setCoach_FirstName(String coach_FirstName) {
		Coach_FirstName = coach_FirstName;
	}



	public String getCoach_LastName() {
		return Coach_LastName;
	}



	public void setCoach_LastName(String coach_LastName) {
		Coach_LastName = coach_LastName;
	}



	public String getCoach_Type() {
		return Coach_Type;
	}



	public void setCoach_Type(String coach_Type) {
		Coach_Type = coach_Type;
	}



	public String getCoach_Email() {
		return Coach_Email;
	}



	public void setCoach_Email(String coach_Email) {
		Coach_Email = coach_Email;
	}



	public String getCoach_PhoneNumber() {
		return Coach_PhoneNumber;
	}



	public void setCoach_PhoneNumber(String coach_PhoneNumber) {
		Coach_PhoneNumber = coach_PhoneNumber;
	}



	public String getTotal_Experience() {
		return Total_Experience;
	}



	public void setTotal_Experience(String total_Experience) {
		Total_Experience = total_Experience;
	}



	public String getCoach_password() {
		return Coach_password;
	}



	public void setCoach_password(String coach_password) {
		Coach_password = coach_password;
	}



	public String getImageUrlFromPart() {
		return imageUrlFromPart;
	}



	public void setImageUrlFromPart(String imageUrlFromPart) {
		this.imageUrlFromPart = imageUrlFromPart;
	}
	
	public void setImageUrlFromDB(String imageUrl) {
		this.imageUrlFromPart = imageUrl;
	}
	private String getImageUrl(Part part) {
		String savePath = StringUtils.IMAGE_DIR_SAVE_PATH_COACH;
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
	
	
}
