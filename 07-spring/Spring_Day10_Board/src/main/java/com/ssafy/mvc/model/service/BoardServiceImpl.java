package com.ssafy.mvc.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.BoardSearch;
import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.util.PageResult;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;
	
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	
	@Override
	public Map<String, Object> getBoardList(BoardSearch boardSearch) {
		System.out.println("모든 게시글 가지고 왔습니다.");
		Map<String, Object> map = new HashMap<>();
		List<Board> list = boardDao.selectAll(boardSearch);
		System.out.println(list.get(0));
		map.put("boards", list);
		PageResult pr = new PageResult(boardSearch.getNowPage(),
				boardDao.countBoards(),
				boardSearch.getListSize(),
				boardSearch.getTabSize());
		map.put("pr", pr);
		return map;
	}

	@Override
	public Board readBoard(int id) {
		System.out.println(id+"번 글을 읽어옵니다.");
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Transactional
	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글 작성했습니다.");
		boardDao.insertBoard(board);
	}

	@Transactional
	@Override
	public void removeBoard(int id) {
		System.out.println("게시글 삭제합니다.");
		boardDao.deleteBoard(id);
	}

	@Transactional
	@Override
	public void modifyBoard(Board board) {
		System.out.println("게시글을 수정합니다.");
		boardDao.updateBoard(board);
	}


	@Override
	public Map<String, Object> search(SearchCondition condition) {
		Map<String, Object> map = new HashMap<>();
		List<Board> list = boardDao.search(condition);
		map.put("list", list);
		int count
		return map;
	}


	@Override
	public int countBoards() {
		return boardDao.countBoards();
		
	}

}
