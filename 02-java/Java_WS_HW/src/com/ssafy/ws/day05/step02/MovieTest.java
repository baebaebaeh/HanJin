package com.ssafy.ws.day05.step02;

public class MovieTest {

	public static void main(String[] args) {
		MovieManager mm = MovieManager.getInstance();
		Movie m1 = new Movie(001, "해리포더1", "JK롤링", "판타지", 100);
		Movie m2 = new Movie(002, "해리포더2", "JK롤링", "판타지", 110);
		Movie m3 = new Movie(003, "해리포더3", "JK롤링", "판타지", 120);

		mm.add(m3);
		mm.add(m2);
		mm.add(m1);
		for (Movie a : mm.getList()) {			
			System.out.println(a);
		}
		
		System.out.println(mm.searchByTitle("1"));
		
		
	}
}
