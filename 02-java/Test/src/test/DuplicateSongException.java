package test;

public class DuplicateSongException extends RuntimeException {
	public DuplicateSongException() {
		System.out.println("이미 존재하는 곡 입니다.");
	}
}
