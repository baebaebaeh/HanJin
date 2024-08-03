package com.ssafy.hw.day04.step03;

/**
 * 도서 정보를 나타내는 클래스
 */
public class Book {
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;
	
	public String toString() {
		return isbn + " | " + title + " | " + author + " | " + publisher + " | " + price + " | " + desc;
	}
	
	Book() {
	}
	
	Book(String isbn, String title, String author, String publisher, int price, String desc) {
		this.author = author;
		this.desc = desc;
		this.isbn = isbn;
		this.price = price;
		this.publisher = publisher;
		this.title = title;
	}
	
}
