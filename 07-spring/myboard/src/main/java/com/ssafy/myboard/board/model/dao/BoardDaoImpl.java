package com.ssafy.myboard.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.board.model.dto.BoardFile;
import com.ssafy.myboard.util.DBUtil;

import jakarta.servlet.jsp.jstl.sql.Result;

@Repository
public class BoardDaoImpl implements BoardDao {

	private DBUtil db;

	public BoardDaoImpl() {
		db = DBUtil.getInstance();
	}

	@Override
	public List<Board> selectBoard() throws SQLException {
		try (Connection con = db.getConnection(); PreparedStatement pstmt = con.prepareStatement("""
				select no, title, writer, view_cnt, reg_date
				  from board
				 order by no desc
				""");) {
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

		try (Connection con = db.getConnection(); PreparedStatement pstmt = con.prepareStatement("""
				insert into board (title, writer, content, view_cnt)
				value (?, ?, ?, ?);
				""")) {
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, 0);
			pstmt.executeUpdate();
			try (PreparedStatement pstmt2 = con.prepareStatement("""
					select last_insert_id() from dual
					""");) {
				ResultSet rs = pstmt2.executeQuery();
				if (rs.next()) {
					board.setNo(rs.getInt("last_insert_id()"));
				}
			}
		}
		return false;
	}

	@Override
	public Board searchByNo(int no) throws SQLException {
		System.out.println(no);
		try (Connection con = db.getConnection(); PreparedStatement pstmt = con.prepareStatement("""
				select no, title, writer, content, view_cnt, reg_date
				  from board
				  where no = ?
				""")) {
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			Board board = new Board();
			rs.next();
			board.setNo(rs.getInt("no"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setContent(rs.getString("content"));
			board.setViewCnt(rs.getInt("view_cnt"));
			board.setRegDate(rs.getString("reg_date"));
			return board;
		}
	}

	@Override
	public void insertBoardFile(BoardFile boardFile) throws SQLException {

		try (Connection con = db.getConnection(); PreparedStatement pstmt = con.prepareStatement("""
				insert into board_file (file_path, ori_name, system_name, no)
				value (?, ?, ?, ?)
				""")) {
			System.out.println(boardFile.getFilePath());
			pstmt.setString(1, boardFile.getFilePath());
			pstmt.setString(2, boardFile.getOriName());
			pstmt.setString(3, boardFile.getSystemName());
			pstmt.setInt(4, boardFile.getNo());
			pstmt.executeUpdate();
		}
	}

	@Override
	public BoardFile selectBoardFileByNo(int no) throws SQLException {
		try (Connection con = db.getConnection(); PreparedStatement pstmt = con.prepareStatement("""
				select file_no, file_path, ori_name, system_name, no
				  from board_file
				  where no = ?
				""")) {
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			BoardFile board = new BoardFile();
			rs.next();
			board.setFileNo(rs.getInt("file_no"));
			board.setNo(rs.getInt("no"));
			board.setFilePath(rs.getString("file_path"));
			board.setOriName(rs.getString("ori_name"));
			board.setSystemName(rs.getString("system_name"));
			return board;
		}
	}


}
