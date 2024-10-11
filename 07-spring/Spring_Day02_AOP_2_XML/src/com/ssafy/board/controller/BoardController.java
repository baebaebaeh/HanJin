package com.ssafy.board.controller;

import com.ssafy.board.model.service.BoardService;

public class BoardController {
	private final BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	public void addBoard(String msg) {
		boardService.addBoard(msg);
	}
}
