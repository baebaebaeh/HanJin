package com.example.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mvc.model.dto.Board;
import com.example.mvc.model.service.BoardService;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/board")
public class BoardController {
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/list")
	public String BoardList(Model model) {
		List<Board> board = boardService.getAllBoards();
		
		return "/boardList";
	}
}
