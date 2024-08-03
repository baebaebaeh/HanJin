package com.ssafy.ws.day10.step03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 도서리스트를 컬렉션으로 유지하며 관리하는 클래스
 */
public class BookManagerImpl implements IBookManager {
	private List<Book> books = new ArrayList<Book>();

	private BookManagerImpl() {
	}

	private static IBookManager instance = new BookManagerImpl();

	public static IBookManager getInstance() {
		return instance;
	}

	@Override
	public void add(Book book) {
		books.add(book);

	}

	@Override
	public void remove(String isbn) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn() == isbn) {
				books.remove(i);
			}
		}
	}

	@Override
	public Book[] getList() {
		Book[] temp = new Book[books.size()];
		return books.toArray(temp);
	}

	@Override
	public Book searchByIsbn(String Isbn) {
		try {
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i).getIsbn().contains(Isbn)) {
					return books.get(i);
				}
			}
			throw new ISBNNotFoundException(Isbn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book[] searchByTitle(String Title) {
		Book[] temp = new Book[books.size()];
		int idx = 0;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().contains(Title)) {
				temp[idx] = books.get(i);
				idx++;
			}
			return temp;
		}
		return null;
	}

	@Override
	public Magazine[] getMagazines() {
		Magazine[] temp = new Magazine[books.size()];
		int idx = 0;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i) instanceof Magazine) {
				temp[idx] = (Magazine) books.get(i);
				idx++;
			}
			return temp;
		}
		return null;
	}

	@Override
	public Book[] getBooks() {
		Book[] temp = new Book[books.size()];
		int idx = 0;
		for (int i = 0; i < books.size(); i++) {
			if (!(books.get(i) instanceof Magazine)) {
				temp[idx] = books.get(i);
				idx++;
			}
			return temp;
		}
		return null;
	}

	@Override
	public int getTotalPrice() {
		int sum = 0;
		for (int i = 0; i < books.size(); i++) {
			sum += books.get(i).getPrice();
			return sum;
		}
		return 0;
	}

	@Override
	public double getPriceAvg() {
		int sum = 0;
		for (int i = 0; i < books.size(); i++) {
			sum += books.get(i).getPrice();
			return sum / books.size();
		}
		return 0;
	}

	@Override
	public void sell(String isbn, int quantity) {
		try {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn() == isbn) {
				books.get(i).setQuantity(books.get(i).getQuantity() - quantity);
				break;
			}
		}
		throw new QuantityException();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void buy(String isbn, int quantity) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn() == isbn) {
				books.get(i).setQuantity(books.get(i).getQuantity() + quantity);
				break;
			}
		}

	}

	@Override
	public void saveData() {
		// TODO Auto-generated method stub

	}

}
