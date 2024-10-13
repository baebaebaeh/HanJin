package com.ssafit.board.controller;

import org.springframework.stereotype.Controller;

import com.ssafit.board.model.service.BoardService;

@Controller
public class MainController {
	private final BoardService boardService;

	public MainController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	
}
