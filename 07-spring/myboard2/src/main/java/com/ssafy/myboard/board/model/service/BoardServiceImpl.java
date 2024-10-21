package com.ssafy.myboard.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.myboard.board.model.dao.BoardDao;
import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.board.model.dto.BoardFile;

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
		BoardFile boardFile = board.getBoardFile();
		if (boardFile != null) {
			boardFile.setNo(board.getNo());
			boardDao.insertBoardFile(board.getBoardFile());
			return true;
		}
		return false;
	}

	@Override
	public Board getBoardByNo(int no) throws Exception {
		Board board = boardDao.searchByNo(no);
		board.setBoardFile(boardDao.selectBoardFileByNo(no));

		return board;
	}

}
