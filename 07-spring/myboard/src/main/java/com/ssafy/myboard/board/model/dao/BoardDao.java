package com.ssafy.myboard.board.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.board.model.dto.BoardFile;

public interface BoardDao {
	List<Board> selectBoard() throws SQLException;

	boolean addBoard(Board board) throws SQLException;

	Board searchByNo(int no) throws SQLException;
	
	void insertBoardFile(BoardFile boardFile) throws SQLException;

	BoardFile selectBoardFileByNo(int no) throws SQLException;

}
