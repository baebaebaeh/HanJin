package com.ssafy.ws.day10.step03;

/**
 * 도서리스트를 관리하기 위한 클래스를 위한 명세역할의 인터페이스
 */
public interface IBookManager {
	void add(Book book);
	void remove(String isbn);
	Book[] getList();
	Book searchByIsbn(String Isbn) throws ISBNNotFoundException;
	Book[] searchByTitle(String Title);
	Magazine[] getMagazines();
	Book[] getBooks();
	int getTotalPrice();
	double getPriceAvg();
	void sell(String isbn, int quantity) throws QuantityException;
	void buy(String isbn, int quantity);
	void saveData();
}
