package com.ssafy.myboard.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.util.DBUtil;

import jakarta.servlet.jsp.jstl.sql.Result;


@Repository
public class BoardDaoImpl implements BoardDao{
	
	private DBUtil db;
	public BoardDaoImpl() {
		db = DBUtil.getInstance();
	}
	@Override
	public List<Board> selectBoard() throws SQLException {
		try (Connection con = db.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"""
					select no, title, writer, view_cnt, reg_date
					  from board
					 order by no desc
					"""
														  );
			) {
			List<Board> list = new ArrayList<>();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setRegDate(rs.getString("reg_date"));
				list.add(board);
			}
			return list;
		}
	}
	
	@Override
	public boolean addBoard(Board board) throws SQLException {
		
		try (
				Connection con = db.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"""
						insert into board (title, writer, content, view_cnt)
						value (?, ?, ?, ?);
						""")) {
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, 0);
			pstmt.executeUpdate();
		}
		return false;
	}
	@Override
	public Board searchByNo(int no) throws SQLException {
		try (
				Connection con = db.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"""
						select no, title, writer, content, view_cnt, reg_date
						  from board
						  where no = ?
						"""
						)){
			pstmt.setInt(1, no);
		}
		return null;
	}

}
