package com.ssafy.myboard.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.board.model.dto.BoardFile;
import com.ssafy.myboard.board.model.service.BoardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
		model.addAttribute(model)
	}

	@GetMapping("/write")
	public String writeForm() {
		return "/board/write";
	}

	@PostMapping("/write")
	public String write(Board board, @RequestParam("attach") MultipartFile attach) throws Exception {

		String oriName = attach.getOriginalFilename();

		if (oriName.length() > 0) {
			// 서버의 특정 디렉토리에 저장
			String subDir = new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date());
			File dir = new File("c:/SSAFY/uploads" + subDir); // 그래서 디렉토리를 만들거다.
			dir.mkdirs();
			String systemName = UUID.randomUUID().toString() + oriName;
			attach.transferTo(new File(dir, systemName)); // 메모리에 파일정보를 특정 위치에 저장
			BoardFile boardFile = new BoardFile();
			boardFile.setFilePath(subDir);
			boardFile.setOriName(oriName);
			boardFile.setSystemName(systemName);
			board.setBoardFile(boardFile);
		}
		
		
		boardService.addBoard(board);

		return "redirect:/board/list";
	}

	@GetMapping("/detail")
	public String detail(@RequestParam int no, Model model) throws Exception {
		Board board = boardService.getBoardByNo(no);
		model.addAttribute(board);
		return "/board/detail";
	}

}

// 멀티파트형태로 보낸다.
/*
 * ------WebKitFormBoundarykhhAmEqGJ3XMwoBk Content-Disposition: form-data;
 * name="title"
 * 
 * avasd ------WebKitFormBoundarykhhAmEqGJ3XMwoBk Content-Disposition:
 * form-data; name="writer"
 * 
 * advcfa ------WebKitFormBoundarykhhAmEqGJ3XMwoBk Content-Disposition:
 * form-data; name="content"
 * 
 * asdf ------WebKitFormBoundarykhhAmEqGJ3XMwoBk Content-Disposition: form-data;
 * name="attach"; filename="a.txt" Content-Type: text/plain
 * 
 * 
 * ------WebKitFormBoundarykhhAmEqGJ3XMwoBk--
 */