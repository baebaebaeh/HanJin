package com.example.mvc.model.dto;

public class BoardFile {
	private int no;
	private String path;
	private String oriName;
	private String systemName;
	private String boardNo;
	public BoardFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardFile(int no, String path, String oriName, String systemName, String boardNo) {
		super();
		this.no = no;
		this.path = path;
		this.oriName = oriName;
		this.systemName = systemName;
		this.boardNo = boardNo;
	}
	@Override
	public String toString() {
		return "BoardFile [no=" + no + ", path=" + path + ", oriName=" + oriName + ", systemName=" + systemName
				+ ", boardNo=" + boardNo + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	
	
}
