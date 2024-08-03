package test;

public class SongNotFoundException extends Exception {

	public SongNotFoundException(int no) {
		super("번호 " + no + " 노래를 찾을 수 없습니다");
	}
}
