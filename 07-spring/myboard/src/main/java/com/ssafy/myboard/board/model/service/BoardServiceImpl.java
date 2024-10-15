package com.ssafy.myboard.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.myboard.board.model.dao.BoardDao;
import com.ssafy.myboard.board.model.dto.Board;



@Service
public class BoardServiceImpl implements BoardService {
	private final BoardDao boardDao;
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<Board> list() throws Exception {
		return boardDao.selectBoard();
	}

	@Override
	public boolean addBoard(Board board) throws Exception {
		boardDao.addBoard(board);
		return true;
	}

	@Override
	public Board getBoardByNo(int no) throws Exception {
		Board board = boardDao.searchByNo(no);
		return board;
	}

}
