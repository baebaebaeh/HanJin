package test;

public class MusicTest {
	public static void main(String[] args) {
		IMusicManager mm = MusicManager.getInstance();
		Song s1 = new Song(1, "A", "뉴진스", "a");
		Song s2 = new Song(2, "B", "르세라핌", "b");
		Song s3 = new Song(1, "C", "아이브", "c");
		mm.addSong(s1);
		mm.addSong(s2);
		mm.addSong(s3);
		
		
		try {
			mm.deleteSong(1);
		} catch (SongNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
