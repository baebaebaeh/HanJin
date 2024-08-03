package com.ssafy.music;

public class Song {
	private int no;
	private String title;
	private String artist;
	private String album;
	public Song() {
	}
	public Song(int no, String title, String artist, String album) {
		super();
		this.no = no;
		this.title = title;
		this.artist = artist;
		this.album = album;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	@Override
	public String toString() {
		return "Song [no=" + no + ", title=" + title + ", artist=" + artist + ", album=" + album + "]";
	}
}
