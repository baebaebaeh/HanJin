package com.ssafy.board.model.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.board.model.dto.Board;

//싱글턴
public class BoardRepositoryImpl implements BoardRepository {
	
	private static BoardRepository repo = new BoardRepositoryImpl();
	
	//게시글을 관리를 하겠다.
	//메모리를 DB라고 생각
	private List<Board> list = new ArrayList<>();	//리스트로 관리 (해볼것)
	private Map<Integer, Board> boards = new HashMap<>(); //맵으로 관리 V
	
	
	
	private BoardRepositoryImpl() {
		boards.put(1, new Board("SSAFY 완벽가이드", "양띵균", "1학기를 잘 이수하는방법은...."));
	}
	
	public static BoardRepository getInstance() {
		return repo;
	}
	
	
	
	@Override
	public List<Board> selectAll() {
//		return list; //리스트로 관리했으면 요거면 끝
//		return (List<Board>)boards.values();
		
		List<Board> tmp = new ArrayList<>();
		for(int key : boards.keySet()) {
			tmp.add(boards.get(key));
		}
		
		return tmp;
	}

	@Override
	public Board selectOne(int id) {
		
		//리스트였으면 반복문 돌면서 찾고
		
		
		return boards.get(id);
	}

	@Override
	public void insertBoard(Board board) {
		boards.put(board.getId(), board);	//ID를 키로 해서 맵으로관리
		list.add(board); //리스트로 목록을 관리
	}

	@Override
	public void updateBoard(Board board) {
		boards.put(board.getId(), board); //맵으로
	}

	@Override
	public void deleteBoard(int id) {
		//리스트면 반복문 돌려서 지우기
		boards.remove(id); //맵
	}

	@Override
	public void updateViewCnt(int id) {
		Board b = boards.get(id);
		b.setViewCnt(b.getViewCnt()+1);
	}

}
