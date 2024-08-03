package test;

import java.util.ArrayList;
import java.util.List;

public class MusicManager implements IMusicManager {
	
	private MusicManager () {}
	private static IMusicManager instance = new MusicManager();
	public static IMusicManager getInstance() {
		return instance;
	}
	
	
	private List<Song> songs = new ArrayList<Song>();

	@Override
	public boolean addSong(Song song) throws DuplicateSongException {
		for (int i = 0; i < songs.size(); i++) {
			if (songs.get(i) == song) {
				throw new DuplicateSongException();
			}
		}
		songs.add(song);
		return true;
	}

	@Override
	public List<Song> viewSongs() {
		return songs;
	}

	@Override
	public Song viewSong(int no) throws SongNotFoundException {
		for (int i = 0; i < songs.size(); i++) {
			if (songs.get(i).getNo() == no) {
				return songs.get(i);
			}
		}
		throw new SongNotFoundException(no);
	}

	@Override
	public boolean updateSong(int no, String title) throws SongNotFoundException {
		for (int i = 0; i < songs.size(); i++) {
			if (songs.get(i).getNo() == no) {
				songs.get(i).setTitle(title);
				return true;
			}
		}
		throw new SongNotFoundException(no);
	}

	@Override
	public boolean deleteSong(int no) throws SongNotFoundException {
		for (int i = 0; i < songs.size(); i++) {
			if (songs.get(i).getNo() == no) {
				songs.remove(i);
				return true;
			}
		}
		throw new SongNotFoundException(no);
	}
}
