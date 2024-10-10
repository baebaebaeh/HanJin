package com.ssafy.movie;

public class Movie {
	private Director director;

	public void setDirector(Director director) {
		this.director = director;
	}
	public void display() {
		System.out.println("영화 감독 : " + director.getName());
	}
}
