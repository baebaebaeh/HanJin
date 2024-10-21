package com.example.mvc.model.dto;

public class Board {
	private int no;
	private String title;
	private String content;
	private String writer;
	private String regDate;
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int no, String title, String content, String writer, String regDate) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regDate="
				+ regDate + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
}