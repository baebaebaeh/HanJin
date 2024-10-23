package com.ssafy.util;

public class PageResult {
	private static int firstPage = 1;
	private static final int LIST_SIZE = 10;
	private static final int TAB_SIZE = 9;
	
	private int beginPage;
	private int endPage;
	private int lastPage;
	private boolean next;
	private boolean prev;
	
	
	private int nowPage;
	private int numberOfBoard;
	
	public PageResult() {
		
	}
	
	public PageResult(int numberOfBoard) {
		this(1, numberOfBoard, LIST_SIZE, TAB_SIZE);
	}
	
	public PageResult(int nowPage, int numberOfBoard) {
		this(nowPage, numberOfBoard, LIST_SIZE, TAB_SIZE);
	}
	
	public PageResult(int nowPage, int numberOfBoard, int listSize) {
		this(nowPage, numberOfBoard, listSize, TAB_SIZE);
	}

	public PageResult(int nowPage, int numberOfBoard, int listSize, int tabSize) {
		this.nowPage = nowPage;
		this.numberOfBoard = numberOfBoard;
		
		// calculate start
		
		// lastPage calculate
		this.lastPage = (numberOfBoard - 1) / listSize + 1;
		
		// beginPage calculate
		int tmpTabSize = -1;
		if (tabSize % 2 == 1) tmpTabSize = (tabSize - 1) / 2;
		else tmpTabSize = (tabSize - 2) / 2;
		int tmpBeginPage = nowPage - tmpTabSize / 2;
		if (tmpBeginPage >= 1) {
			this.beginPage = tmpBeginPage;
		} else {
			this.beginPage = 1;
		}
		
		// endPage calculate
		int tmpEndPage = nowPage + tmpTabSize / 2;
		if (tmpEndPage <= lastPage) {
			this.endPage = tmpEndPage;
		} else {
			this.endPage = lastPage;
		}
		
		// next calculate
		this.next = (lastPage == nowPage) ?  false : true;
		
		// prev calculate
		this.prev = (firstPage == nowPage) ? false : true;
		
		// calculate end
		
	}

	public static int getFirstPage() {
		return firstPage;
	}

	public static void setFirstPage(int firstPage) {
		PageResult.firstPage = firstPage;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getNumberOfBoard() {
		return numberOfBoard;
	}

	public void setNumberOfBoard(int numberOfBoard) {
		this.numberOfBoard = numberOfBoard;
	}
	
}
