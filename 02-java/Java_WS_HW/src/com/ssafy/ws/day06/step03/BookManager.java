package com.ssafy.ws.day06.step03;

import java.util.Arrays;

public class BookManager {
	final int MAX_SIZE = 100;
	Book[] books = new Book[MAX_SIZE];
	int size = 0;
	
	public void add(Book book) {
		books[size++] = book;
	}
	
	public void remove(String isbn) {
		for (int i= 0; i < size; i++) {
			if (books[i].getIsbn()== isbn) {
				books[i] = books[size];
				books[size] = null;
				size--;
			}
		}
	}
	
	public Book[] getList() {
		Book[] tempBooks = new Book[size];
		for (int i = 0; i < size; i++) {
			tempBooks[i] = books[i];
		}
		return tempBooks;
	}
	
	public Book searchByIsbn(String isbn) {
		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn().contains(isbn)) {
				return books[i];
			}
		}
		return null;
	}
	public Book[] searchByTitle(String title) {
		int temp = 0;
		for (int i = 0; i < size; i++) {
			if (books[i].getTitle().contains(title)) {
				temp++;
			}
		}
		int bookIdx = 0;
		Book[] tempBooks = new Book[temp];
		for (int i = 0; i < size; i++) {
			if (books[i].getTitle().contains(title)) {
				tempBooks[bookIdx] = books[bookIdx];
				bookIdx++;
			}
		}
		return tempBooks;
	}
	public Magazine[] getMagazines() {
		int temp = 0;
		for (int i = 0; i < size; i++) {
			if (books[i] instanceof Magazine) {
				temp++;
			}
		}
		int bookIdx = 0;
		Magazine[] tempBooks = new Magazine[temp];
		for (int i = 0; i < size; i++) {
			if (books[i] instanceof Magazine) {
				tempBooks[bookIdx] = (Magazine) books[i];
				bookIdx++;
			}
		}
		return tempBooks;
	}
	public Book[] getBooks() {
		int temp = 0;
		for (int i = 0; i < size; i++) {
			if (!(books[i] instanceof Magazine)) {
				temp++;
			}
		}
		int bookIdx = 0;
		Book[] tempBooks = new Book[temp];
		for (int i = 0; i < size; i++) {
			if (!(books[i] instanceof Magazine)) {
				tempBooks[bookIdx] = books[i];
				bookIdx++;
			}
		}
		return tempBooks;
	}
	
	public int getTotalPrice() {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += books[i].getPrice();
		}
		return sum;
	}
	public int getPriceAvg() {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += books[i].getPrice();
		}
		sum = sum/size;
		return sum;
	}
}

























