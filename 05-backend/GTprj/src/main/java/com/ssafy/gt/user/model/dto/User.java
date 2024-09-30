package com.ssafy.gt.user.model.dto;

public class User {
	private String userEmail;
	private String userPassword;
	private String userName;
	private int isUser;
	
	public User(String userEmail, String userPassword, String userName, int isUser) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.isUser = isUser;
	}
	public User() {}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getIsUser() {
		return isUser;
	}
	public void setIsUser(int isUser) {
		this.isUser = isUser;
	}
	@Override
	public String toString() {
		return "User [userEmail=" + userEmail + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", isUser=" + isUser + "]";
	}

	
}
