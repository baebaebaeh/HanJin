package com.ssafy.mvc.model.dto;

public class BoardSearch {
	private int nowPage;
	private int listSize;
	private int tabSize;
	
	public BoardSearch() {
		this(1, 10, 9);
	}

	public BoardSearch(int nowPage) {
		this(nowPage, 10, 9);
	}
	
	public BoardSearch(int nowPage, int listSize) {
		this(nowPage, listSize, 9);
	}
	
	public BoardSearch(int nowPage, int listSize, int tabSize) {
		this.nowPage = nowPage;
		this.listSize = listSize;
		this.tabSize = tabSize;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getTabSize() {
		return tabSize;
	}

	public void setTabSize(int tabSize) {
		this.tabSize = tabSize;
	}
	
	public int getOffset() {
		return (nowPage - 1) / listSize;
	}
	
}

