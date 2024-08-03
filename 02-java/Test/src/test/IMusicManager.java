package test;

import java.util.List;

public interface IMusicManager {
	boolean addSong(Song song) throws DuplicateSongException;
	List<Song> viewSongs();
	Song viewSong(int no) throws SongNotFoundException;
	boolean updateSong(int no, String title) throws SongNotFoundException;
	boolean deleteSong(int no) throws SongNotFoundException;
}
