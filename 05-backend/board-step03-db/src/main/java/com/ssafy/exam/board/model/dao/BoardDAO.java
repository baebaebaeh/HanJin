package com.ssafy.exam.board.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.exam.board.model.dto.Board;

public interface BoardDAO {

	void insertBoard(Board board) throws SQLException;

	List<Board> selectBoard() throws SQLException;

	Board selectBoardByNo(int no) throws SQLException;

	void deleteBoardByNo(int no) throws SQLException;

	void updateViewCnt(int no) throws SQLException;

	void updateBoard(int no, String title, String writer, String content) throws SQLException;

}