package com.ssafy.myboard.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.board.model.service.BoardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/board")
public class BoardController {
	private final BoardService boardService;
	public BoardController(BoardService boardservice) {
		this.boardService = boardservice;
	}
	
	
	// 반환타입은 일단 ModelAndView, void, 
	@GetMapping("/list")
	public String list(Model model) throws Exception { // 이렇게 하든 반환타입을 MaV로 하든 둘중하나고르자 왜? 데이터를 보내야 하니까
		model.addAttribute("list", boardService.list());
		return "/board/list";
	}
	
	@GetMapping("/write")
	public String writeForm() {
		return "/board/write";
	}
	
	@PostMapping("/write")
	public String write(Board board) throws Exception {
		boardService.addBoard(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/detail")
	public String detail(Board board) throws Exception {
		int no = board.getNo();
		boardService.getBoardByNo(no);
		return new String();
	}
	
	
}
