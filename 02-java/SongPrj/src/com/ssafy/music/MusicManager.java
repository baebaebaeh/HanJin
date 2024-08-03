package com.ssafy.music;

import java.util.ArrayList;
import java.util.List;

public class MusicManager implements IMusicManager {
	private MusicManager() {}
	private static IMusicManager instance = new MusicManager();
	public static IMusicManager getInstance() {
		return instance;
	}
	
	private List<Song> list = new ArrayList<>();
	@Override
	public boolean add(Song song) throws DuplicateSongException {
		for (int i = 0; i < list.size(); i++) {
			Song s = list.get(i);
			if (s.getNo() == song.getNo()) throw new DuplicateSongException();
		}
		
		return list.add(song);
	}

	@Override
	public List<Song> viewSongs() {
		return list;
	}

	@Override
	public Song viewSong(int no) throws SongNotFoundException {
		for (int i = 0; i < list.size(); i++) {
			Song s = list.get(i);
			if (s.getNo() == no) return s;
		}
		throw new SongNotFoundException();
	}

	@Override
	public boolean updateSong(int no, String title) throws SongNotFoundException {
		for (int i = 0; i < list.size(); i++) {
			Song s = list.get(i);
			if (s.getNo() == no) {
				s.setTitle(title);
				return true;
			}
		}
		throw new SongNotFoundException();
	}

	@Override
	public boolean deleteSong(int no) throws SongNotFoundException {
		for (int i = 0; i < list.size(); i++) {
			Song s = list.get(i);
			if (s.getNo() == no) {
				list.remove(i);
				return true;
			}
		}
		throw new SongNotFoundException();
	}

}
