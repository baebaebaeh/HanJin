package com.ssafy.ws.day06.step02;

public class MovieTest {
	public static void main(String[] args) {
		MovieManager mm = new MovieManager();
		Movie a1 = new Movie(20153614, "올드보이", "박찬욱", "스릴러", 100);
		Movie a2 = new Movie(20153614, "abc", "박v찬욱", "스asdf", 100);
		Movie a3 = new Movie(20153614, "ddef", "박찬afc욱", "asdf러", 101);
		SeriesMovie a4 = new SeriesMovie(20153614, "asdfv", "박cdasdf찬c욱", "스dfsa릴러", 100,15,"avxd");
		SeriesMovie a5 = new SeriesMovie(20153614, "werv", "박c찬casdf욱", "스릴sadf", 100,15,"abcv");
		mm.add(a1);
		mm.add(a2);
		mm.add(a3);
		mm.add(a4);
		mm.add(a5);
		
		
		
		for (Movie b : mm.getList())
			System.out.println(b);
		
		for (Movie b : mm.getMovies())
			System.out.println(b);
		
		for (Movie b : mm.getSeriesMovies())
			System.out.println(b);
		
			System.out.println(mm.getRunningTimeAvg());
	}
}
