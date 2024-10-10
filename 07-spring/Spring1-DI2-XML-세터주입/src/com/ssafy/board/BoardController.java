package com.ssafy.board;

public class BoardController {
	private BoardService boardService;
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	public void addBoard(String board) {
		boardService.addBoard(board);
	}
}
