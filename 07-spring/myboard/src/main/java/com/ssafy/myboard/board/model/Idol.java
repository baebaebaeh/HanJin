package com.ssafy.myboard.board.model;

public class Idol {
	private int no;
	private String name;
	private String gender;
	public Idol() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Idol(int no, String name, String gender) {
		super();
		this.no = no;
		this.name = name;
		this.gender = gender;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
