package com.ssafy.ws.day07.step02.movie;

import java.util.Arrays;

import com.ssafy.ws.day06.step02.Movie;
import com.ssafy.ws.day06.step02.SeriesMovie;

/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */
public class MovieManagerImpl implements IMovieManager {
	private MovieManagerImpl() {}
	private static IMovieManager instance = new MovieManagerImpl();
	public static IMovieManager getInstance() {
		return instance;

	private final int MAX_SIZE = 100;
	private Movie[] movieList = new Movie[MAX_SIZE];
	private int size;

	public void add(Movie movie) {
		if (size < 100) {
			movieList[size++] = movie;
		}
	}

	public Movie[] getList() {
		Movie[] tempMovieList = new Movie[size];
		for (int i = 0; i < size; i++) {
			tempMovieList[i] = movieList[i];
		}
		return tempMovieList;
	}

	public Movie[] getMovies() {
		int tempNum = 0;
		for (int i = 0; i < size; i++) {
			if (!(movieList[i] instanceof SeriesMovie))
				tempNum++;
		}

		Movie[] tempMovieList = new Movie[tempNum];
		int idx = 0;
		for (int i = 0; i < size; i++) {
			if (!(movieList[i] instanceof SeriesMovie))
				tempMovieList[idx++] = movieList[i];
		}
		return tempMovieList;
	}

	public Movie[] getSeriesMovies() {
		int tempNum = 0;
		for (int i = 0; i < size; i++) {
			if (movieList[i] instanceof SeriesMovie)
				tempNum++;
		}
		int idx = 0;
		Movie[] tempMovieList = new Movie[tempNum];
		for (int i = 0; i < size; i++) {
			if (movieList[i] instanceof SeriesMovie)
				tempMovieList[idx++] = movieList[i];
		}
		return tempMovieList;
	}

	public Movie[] searchByTitle(String word) {
		int tempNum = 0;
		for (int i = 0; i < size; i++) {
			if (movieList[i].toString().contains(word))
				tempNum++;
		}

		int idx = 0;
		Movie[] tempMovieList = new Movie[tempNum];
		for (int i = 0; i < size; i++) {
			if (movieList[i].toString().contains(word))
				tempMovieList[idx++] = movieList[i];
		}
		return tempMovieList;
	}

	public double getRunningTimeAvg() {

		double temp = 0;
		for (int i = 0; i < size; i++) {
			temp += movieList[i].getRunningTime();
		}
		temp = temp / size;
		return temp;
	}
}
