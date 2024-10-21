package com.example.mvc.model.dao;

import java.util.List;

import com.example.mvc.model.dto.Board;

public interface BoardDao {
	public List<Board> selectBoardAll();
}
