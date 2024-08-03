package com.ssafy.board;

public class Test {
	public static void main(String[] args) {
		Board b1 = new Board(1, "첫번째 글", "홍길동1", "연습입니다1.");
		Board b2 = new Board(2, "두번째 글", "홍길동2", "연습입니다2.");
		Board b3 = new Board(3, "세번째 글", "홍길동3", "연습입니다3.");
		Board b4 = new Board(4, "네번째 글", "홍길동4", "연습입니다4.");
		BoardManager manager = BoardManager.getInstance();
		System.out.println(manager.add(b1));
		System.out.println(manager.add(b2));
		System.out.println(manager.add(b3));
		System.out.println(manager.add(b4));
		
		manager.modify(3, "수정된 세번째 글");
		
		Board[] list = manager.getBoard();
		for (Board b : list) {
			System.out.println(b);
		}
		manager.delete(2);
		list = manager.getBoard();
		for (Board b : list) {
			System.out.println(b);
		}
		
		Board board = manager.getBoard(3);
		System.out.println(board);
	}
}






