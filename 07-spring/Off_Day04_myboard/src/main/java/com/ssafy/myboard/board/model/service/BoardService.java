package com.ssafy.myboard.board.model.service;

import java.util.Map;

import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.board.model.dto.BoardSearch;

public interface BoardService {
	Map<String, Object> getBoardList(BoardSearch boardSearch);

	Board getBoard(int no);

	void addBoard(Board board);

	void modifyBoard(Board board);

	void removeBoard(int no);

	void modifyViewCntByNo(int no);
}
