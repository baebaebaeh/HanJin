package com.ssafy.music;

import java.util.List;

public class MusicTest {
	public static void main(String[] args) {
		IMusicManager musicManger = MusicManager.getInstance();
		musicManger.add(new Song(1, "토마토송", "토마토", "토마토"));
		musicManger.add(new Song(2, "우유송", "우유", "서울우유"));
//		musicManger.add(new Song(2, "당근송", "당근", "서울당근"));
		System.out.println("등록성공");
		
		List<Song> list = musicManger.viewSongs();
		System.out.println(list.size());
		System.out.println(list);
		try {
			musicManger.updateSong(1, "방울토마토");
			list = musicManger.viewSongs();
			System.out.println(list);
			
		} catch (SongNotFoundException e) {
			System.out.println("3번 노래가 존재하지 않습니다.");
		}

		try {
			musicManger.deleteSong(1);
			list = musicManger.viewSongs();
			System.out.println(list);
			
		} catch (SongNotFoundException e) {
			System.out.println("1번 노래가 존재하지 않습니다.");
		}
	}
	
}






