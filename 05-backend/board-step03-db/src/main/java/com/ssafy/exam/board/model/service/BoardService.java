package com.ssafy.exam.board.model.service;

import java.util.List;

import com.ssafy.exam.board.model.dto.Board;

public interface BoardService {

	void delete(int no) throws Exception;

	Board detail(int no) throws Exception;

	List<Board> list() throws Exception;

	void write(Board board) throws Exception;

}