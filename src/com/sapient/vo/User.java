package com.sapient.vo;

public class User {
	private int userId;
	private String userName;
	private String userCompany;
	private String userContact;
	private String  userNationality;
	private String userPassword;
	
	public void setUserId(int userId) {
		this.userId=userId;
	}
	public int getUserId(){
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserCompany() {
		return userCompany;
	}
	public void setUserCompany(String userCompany) {
		this.userCompany = userCompany;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getUserNationality() {
		return userNationality;
	}
	public void setUserNationality(String userNationality) {
		this.userNationality = userNationality;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public User() {
	}
	public User(String userName, String userCompany, String userContact,
			String userNationality, String userPassword) {
		this.userName = userName;
		this.userCompany = userCompany;
		this.userContact = userContact;
		this.userNationality = userNationality;
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userCompany=" + userCompany + ", userContact="
				+ userContact + ", userNationality=" + userNationality
				+ ", userPassword=" + userPassword + "]";
	}
	
}
