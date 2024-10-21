package com.ssafy.myboard.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.board.model.dto.BoardFile;
import com.ssafy.myboard.config.MyBatisConfig;
import com.ssafy.myboard.util.DBUtil;

import jakarta.servlet.jsp.jstl.sql.Result;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	private final String NS = "com.ssafy.myboard.board.model.dao.BoardDao.";
	
	private SqlSessionFactory sqlFactory;

	public BoardDaoImpl() {
		sqlFactory = MyBatisConfig.getFactory();
	}

	@Override
	public List<Board> selectBoard() { // 마이바티스가 runtimeexception으로 바꿔줘서 sqlexception을 안 던져도 된다.
		try (SqlSession sqlSession = sqlFactory.openSession()) {
			List<Board> list = sqlSession.selectList(NS + "selectBoard");
			sqlSession.commit();
			return list;
			
		}
	}

	@Override
	public boolean addBoard(Board board) {
		try (SqlSession sqlSession = sqlFactory.openSession()) {
			sqlSession.insert(NS + "addBoard", board);
			sqlSession.commit();
		}
		return true;
	}

	@Override
	public Board searchByNo(int no) {
		try (SqlSession sqlSession = sqlFactory.openSession()) {
			sqlSession.commit();
			return sqlSession.selectOne(NS + "searchByNo", no);
		}
	}

	@Override
	public void insertBoardFile(BoardFile boardFile) {
		
		try (SqlSession sqlSession = sqlFactory.openSession()) {
			sqlSession.insert(NS + "insertBoardFile", boardFile);
			sqlSession.commit();
		}
	}

	@Override
	public BoardFile selectBoardFileByNo(int no) {
		try (SqlSession sqlSession = sqlFactory.openSession()) {
			sqlSession.commit();
			return sqlSession.selectOne(NS + "selectBoardFileByNo", no);
		}
	}
}
