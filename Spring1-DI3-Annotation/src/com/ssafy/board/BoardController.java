package com.ssafy.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component
@Controller // controller는 component를 쓸 수 있지만 그냥 이렇게 쓰는걸 권장
public class BoardController {
	private final BoardService boardService;
//	@Autowired //이게 붙어있다 4.3이후버전부터는 자동으로 붙여줌 하나밖에 생성자가 없으니
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	public void addBoard(String board) {
		boardService.addBoard(board);
	}
}
