package com.ssafy.selfexam.dto;


public class User {
	private String id;
	private String pass;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", pass=" + pass + "]";
	}
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}
	
	
}
