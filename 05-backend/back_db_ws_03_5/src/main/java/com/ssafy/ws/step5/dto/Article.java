package com.ssafy.ws.step5.dto;

import java.util.Date;

public class Article {
	private int articledId;
	private String title;
	private String content;
	private int userSeq;
	private  int viewCnt;
	private Date regDate;
	public Article(int articledId, String title, String content, int userSeq, int viewCnt, Date regDate) {
		super();
		this.articledId = articledId;
		this.title = title;
		this.content = content;
		this.userSeq = userSeq;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
	}
	public Article() {}
	
	public int getArticledId() {
		return articledId;
	}
	public void setArticledId(int articledId) {
		this.articledId = articledId;
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
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Article [articledId=" + articledId + ", title=" + title + ", content=" + content + ", userSeq="
				+ userSeq + ", viewCnt=" + viewCnt + ", regDate=" + regDate + "]";
	}
}
