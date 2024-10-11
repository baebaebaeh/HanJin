package com.ssafy.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ssafy.board.model.service.BoardService;

@Controller
public class BoardController {
	private final BoardService boardService;
	//@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	public void addBoard(String msg) {
		boardService.addBoard(msg);
	}
}
