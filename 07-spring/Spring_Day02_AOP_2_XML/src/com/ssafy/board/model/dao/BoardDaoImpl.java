package com.ssafy.board.model.dao;

public class BoardDaoImpl implements BoardDao {

	@Override
	public void insert(String msg) {
		System.out.println("게시글 등록 : " + msg);
	}

}
