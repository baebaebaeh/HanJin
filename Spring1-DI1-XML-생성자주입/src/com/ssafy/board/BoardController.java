package com.ssafy.board;

public class BoardController {
	private BoardService boardService;
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	public void addBoard(String board) {
		boardService.addBoard(board);
	}
}
