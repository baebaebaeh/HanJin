package com.ssafy.music;

public class Album {
	private Artist artist;

	public Album(Artist artist) {
		this.artist = artist;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	public void display() {
		System.out.println(artist.getName()); 
	}
}
