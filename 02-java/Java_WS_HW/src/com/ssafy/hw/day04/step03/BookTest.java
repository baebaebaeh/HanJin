package com.ssafy.hw.day04.step03;

/**
 * 도서 객체를 생성하고 정보를 출력하는 클래스
 */
public class BookTest {
	public static void main(String[] args) {
		Book list = new Book();
		
		System.out.println("************************도서목록************************");
		
		Book list1 = new Book("21424"  , "Java Pro"   , "김하나" , "jaen.kr" , 15000  , "Java 기본 문법");
		System.out.println(list1.toString());
		Book list2 = new Book("21424"  , "Java Pro"   , "김하나" , "jaen.kr" , 15000  , "SW 모델링");
		System.out.println(list2.toString());
	}
}

