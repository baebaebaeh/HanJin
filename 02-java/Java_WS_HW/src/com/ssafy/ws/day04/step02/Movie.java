package com.ssafy.ws.day04.step02;

public class Movie {
	int id;
	String title;
	String director;
	String genre;
	int runningTime;

	Movie() {
	}

	Movie(int id, String title, String director, String genre, int runningTime) {
		this.id = id;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.runningTime = runningTime;
	}

	void show() {
		System.out.println(id);
		System.out.println(title);
		System.out.println(director);
		System.out.println(genre);
		System.out.println(runningTime);

	}

}
