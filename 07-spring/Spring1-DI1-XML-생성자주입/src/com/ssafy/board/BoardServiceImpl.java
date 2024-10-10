package com.ssafy.board;

public class BoardServiceImpl implements BoardService {
	private BoardDAO boardDao;

	public BoardServiceImpl(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public void addBoard(String board) {
		boardDao.insertBoard(board);
	}	
	
	
}
