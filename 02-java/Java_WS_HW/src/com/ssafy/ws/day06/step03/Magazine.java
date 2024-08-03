package com.ssafy.ws.day06.step03;

public class Magazine extends Book {
	int year;
	int month;
	public Magazine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc) {
		super(isbn, title, author, publisher, price, desc);
		// TODO Auto-generated constructor stub
	}
	public Magazine(int year, int month) {
		super();
		this.year = year;
		this.month = month;
	}
	@Override
	public String toString() {
		return "Magazine " + "[isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", price=" + price + ", desc=" + desc  + "year=" + year + ", month=" + month + "]";
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
