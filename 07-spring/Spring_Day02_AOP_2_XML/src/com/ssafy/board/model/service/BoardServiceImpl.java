package com.ssafy.board.model.service;

import java.util.Date;

import com.ssafy.board.model.dao.BoardDao;

public class BoardServiceImpl implements BoardService {
	
	private final BoardDao boardDao;
	public BoardServiceImpl(BoardDao boardDao) {
		super();
		this.boardDao = boardDao;
	}
	
	public void listBoard() {
//		System.out.println("Time : " + new Date().toLocaleString());
		// 이렇게 100개의 메서드에 계속 추가할 상황이다 너무 힘들다...
		// 이때 aop를 사용하는거다.
		
	}

	@Override
	public void addBoard(String msg) {
//		System.out.println("Time : " + new Date().toLocaleString());
		
		System.out.println("서비스 addBoard 메서드 호출됨...");
		boardDao.insert(msg);
	}

}
