package com.ssafy.ws.day06.step03;

public class BookTest {
	public static void main(String[] args) {
		Book b1 = new Book("978-0-1234-5678-9", "반지의제왕1", "작가", "퍼블리셔", 20000, "1");
		Book b2 = new Book("978-1-2345-6789-0", "반지의제왕2", "작가", "퍼블리셔", 20000, "2");
		Book b3 = new Book("978-2-3456-7890-1", "반지의제왕3", "작가", "퍼블리셔", 20000, "3");
		Magazine m1 = new Magazine("978-3-4567-8901-2", "반지의제왕4", "작가", "퍼블리셔", 20000, "4");
		Magazine m2 = new Magazine("978-4-5678-9012-3", "반지의제왕5", "작가", "퍼블리셔", 20000, "5");
		
		BookManager bm = new BookManager();
		
		bm.add(b1);
		bm.add(b2);
		bm.add(b3);
		bm.add(m1);
		bm.add(m2);
		System.out.println("************************도서 전체 목록************************");
		for (Book a : bm.getList()) {
			System.out.println(a);
		}
		System.out.println("************************일반 도서 목록************************");
		for (Book a : bm.getBooks()) {
			System.out.println(a);
		}
		System.out.println("************************잡지 목록************************");
		for (Magazine a : bm.getMagazines()) {
			System.out.println(a);
		}
		System.out.println("************************도서 제목 포함 검색: 4************************");
		for (Book a : bm.searchByTitle("4")) {
			System.out.println(a);
		}
		
		System.out.println(bm.getTotalPrice());
		
		System.out.println(bm.getPriceAvg());
		
	}
}
