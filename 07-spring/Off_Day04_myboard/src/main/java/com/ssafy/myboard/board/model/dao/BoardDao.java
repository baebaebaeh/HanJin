package com.ssafy.myboard.board.model.dao;

import java.util.List;

import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.board.model.dto.BoardFile;
import com.ssafy.myboard.board.model.dto.BoardSearch;

public interface BoardDao {
	List<Board> selectBoardAll(BoardSearch boardSearch);
	
//	게시물 페이징 처리를 위한 전체 데이터 카운트
	int selectBoardCount(BoardSearch boardSearch);

	Board selectBoardOne(int no);

	void insertBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(int no);

	void insertBoardFile(BoardFile boardFile);

	BoardFile selectBoardFileByNo(int no);
	
	void updateViewCntByNo(int no);
}
