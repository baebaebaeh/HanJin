package com.ssafy.ws.day04.step02;

public class MovieTest {

	public static void main(String[] args) {
		Movie movie1 = new Movie();
		movie1.id = 990504;
		movie1.title = "올드보이";
		movie1.director = "봉준호";
		movie1.genre = "스릴러";
		movie1.runningTime = 100;
		
		Movie movie2 = new Movie(9954, "올드보이", "봉준호", "스릴러",100);
		System.out.println(movie1.id);
		System.out.println(movie1.title);
		System.out.println(movie1.director);
		System.out.println(movie1.genre);
		System.out.println(movie1.runningTime);
		System.out.println(movie2.id);
		System.out.println(movie2.title);
		System.out.println(movie2.director);
		System.out.println(movie2.genre);
		System.out.println(movie2.runningTime);

	}

}