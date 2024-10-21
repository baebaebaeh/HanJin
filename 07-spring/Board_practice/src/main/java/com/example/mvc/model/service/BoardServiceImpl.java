package com.example.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mvc.model.dao.BoardDao;
import com.example.mvc.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardDao boardDao;
	
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	

	@Override
	public List<Board> getAllBoards() {
		List<Board> boards = boardDao.selectBoardAll();
		return boards;
	}
	
}
