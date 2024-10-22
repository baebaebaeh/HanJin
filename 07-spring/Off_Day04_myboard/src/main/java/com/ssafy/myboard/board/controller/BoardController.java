package com.ssafy.myboard.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.board.model.dto.BoardFile;
import com.ssafy.myboard.board.model.dto.BoardSearch;
import com.ssafy.myboard.board.model.service.BoardService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("board")
public class BoardController {
	private final BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("boardList")
	public String boardList(BoardSearch boardSearch, Model model) {
		Map<String, Object> result = boardService.getBoardList(boardSearch); 
		model.addAttribute("list", result.get("list"));
		model.addAttribute("lastPage", result.get("lastPage"));
		return "board/boardList";
	}

	@GetMapping("boardDetail")
	public String boardDetail(@RequestParam int no, Model model) {
		boardService.modifyViewCntByNo(no);
		Board board = boardService.getBoard(no);
		model.addAttribute("board", board);
		if (board.getBoardFile() != null) {
			model.addAttribute("imagePath", "/board/download?filePath=" + board.getBoardFile().getFilePath()
					+ "&systemName=" + board.getBoardFile().getSystemName());
		}

		return "board/boardDetail";
	}

	@GetMapping("boardInsert")
	public String boardInsert() {
		return "board/boardInsertForm";
	}

	@PostMapping("boardInsert")
	public String boardInsert(@RequestParam("attach") MultipartFile attach, Board board)
			throws IllegalStateException, IOException {

		String oriName = attach.getOriginalFilename();

		if (oriName.length() > 0) {
			String subDir = new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date());
			File dir = new File("c:/SSAFY/uploads" + subDir);
			dir.mkdirs();

			String systemName = UUID.randomUUID().toString() + oriName;
			attach.transferTo(new File(dir, systemName));

			// DB에 저장하기 위한 준비
			BoardFile boardFile = new BoardFile();
//			boardFile.setFileNo(0); // 데이터 입력시 자동 입력
			boardFile.setFilePath(subDir);
			boardFile.setOriName(oriName);
			boardFile.setSystemName(systemName);
//			boardFile.setNo(0); //board 테이블에 데이터가 입력된 다음 가능
			board.setBoardFile(boardFile);
		}

		boardService.addBoard(board);
		return "redirect:/board/boardList";
	}

	@GetMapping("boardUpdate")
	public String boardUpdate(@RequestParam int no, Model model) {
		model.addAttribute("board", boardService.getBoard(no));
		return "board/boardUpdateForm";
	}

	@PostMapping("boardUpdate")
	public String boardUpdate(Board board) {
		boardService.modifyBoard(board);
		return "redirect:/board/boardDetail?no=" + board.getNo();
	}

	@PostMapping("boardDelete")
	public String boardDelete(@RequestParam int no) {
		boardService.removeBoard(no);
		return "redirect:/board/boardList";
	}

	@GetMapping("download")
	public void downloadFile(@RequestParam String filePath, @RequestParam String systemName,
			HttpServletResponse response) throws IOException {
		// 파일의 전체 경로를 생성합니다.
		String fullPath = "C:/SSAFY/uploads" + filePath + "/" + systemName;
		File file = new File(fullPath);

		System.out.println("Attempting to download file: " + fullPath); // 디버깅 로그 추가

		if (file.exists()) {
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition",
					"attachment; filename=\"" + URLEncoder.encode(systemName, "UTF-8") + "\"");
			response.setContentLength((int) file.length());

			try (FileInputStream inStream = new FileInputStream(file);
					OutputStream outStream = response.getOutputStream()) {

				byte[] buffer = new byte[4096];
				int bytesRead;

				while ((bytesRead = inStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}
			}
		} else {
			// 파일이 존재하지 않을 경우의 처리
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found: " + fullPath);
		}
	}
}
