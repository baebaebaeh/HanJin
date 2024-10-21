package com.example.mvc.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mvc.model.dto.Board;
import com.example.mvc.model.service.BoardService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/board")
public class BoardController {
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/list")
	public String boardList(Model model) {
		List<Board> board = boardService.getAllBoards();
		System.out.println(board.size());
		for (Board b : board) {
			System.out.println(b);
		}
		model.addAttribute("boards", board);
		return "/board/boardList";
	}
	
	@GetMapping("/writeForm")
	public String boardWrite() {
		return "/writeForm";
	}
	
	
}
