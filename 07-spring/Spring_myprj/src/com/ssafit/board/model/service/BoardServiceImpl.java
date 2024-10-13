package com.ssafit.board.model.service;

import org.springframework.stereotype.Service;

import com.ssafit.board.model.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardDAO boardDAO;

	public BoardServiceImpl(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public void createVideo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readVideo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVideo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteVideo() {
		// TODO Auto-generated method stub
		
	}

}
