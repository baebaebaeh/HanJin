package com.ssafy.ws.day10.step03;

/**
 * 잡지 정보를 나타내는 클래스
 */
public class Magazine extends Book {
	private int year;
	private int month;
	
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int quantity,
			int year, int month) {
		super(isbn, title, author, publisher, price, desc, quantity);
		this.year = year;
		this.month = month;
	}
	
	public Magazine() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Magazine [year=" + year + ", month=" + month + ", toString()=" + super.toString() + "]";
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	


	
}
