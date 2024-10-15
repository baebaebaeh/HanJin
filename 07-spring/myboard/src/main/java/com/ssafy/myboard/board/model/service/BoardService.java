package com.ssafy.myboard.board.model.service;

import java.util.List;

import com.ssafy.myboard.board.model.dto.Board;

public interface BoardService {
	List<Board> list() throws Exception;

	boolean addBoard(Board board) throws Exception;

	Board getBoardByNo(int no) throws Exception;
}
