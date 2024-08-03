package com.ssafy.ws.day05.step02;

import java.util.ArrayList;
import java.util.List;

/**
 * 영화리스트를 배열로 관리하는 클래스
 * 
 * @author
 *
 */
public class MovieManager {
	private static final int MAX_SIZE = 100;
	private Movie[] movieList = new Movie[MAX_SIZE];
	private int size = 0;
	private List<Movie> movies = new ArrayList<Movie>();
	
	private MovieManager() {}
	private static MovieManager instance = new MovieManager();
	public static MovieManager getInstance() {
		return instance;
	}
	
	public void add(Movie movie) {
		if (size < MAX_SIZE) {
			movies.add(movie);
		} else {
			System.out.println("최대 영화 개수에 도달했습니다. 영화 등록에 실패했습니다.");
		}
	}
	
	public Movie[] getList() {
		Movie[] temp = new Movie[movies.size()];
		for (int i = 0; i < movies.size(); i++) {
			temp[i] = movies.get(i);
		}
		return temp;
	}
	
	public Movie searchByTitle(String title) {
		for (int i = 0; i < movies.size(); i++) {
			if (movies.get(i).getTitle().contains(title)) {
				return movies.get(i);
			}
		}
		return null;
	}
}
