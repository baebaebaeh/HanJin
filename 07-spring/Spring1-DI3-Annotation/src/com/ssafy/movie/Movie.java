package com.ssafy.movie;

import org.springframework.stereotype.Component;

@Component
public class Movie {
	private final Director director;
	
	public Movie (Director director) {
		this.director = director;
	}

	public void display() {
		System.out.println("영화 감독 : " + director.getName());
	}
}
