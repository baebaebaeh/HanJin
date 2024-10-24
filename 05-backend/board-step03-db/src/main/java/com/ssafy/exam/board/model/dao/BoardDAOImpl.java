package com.ssafy.exam.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.exam.board.model.dto.Board;
import com.ssafy.exam.util.DBUtil;

// CRUD
/*
 * 데이터베이스 처리 기준
 * 
 * R : selectBoard(전체)
 *   : selectBoardByPK(하나조회)
 * C : insertBoard  
 * U : updateBoard  
 * D : deleteBoard  
 */
public class BoardDAOImpl implements BoardDAO {
	
	public static void main(String[] args) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		Connection con = dbUtil.getConnection();
		System.out.println(con); // 연결한 객체 주소가 나온다. com.mysql.cj.jdbc.ConnectionImpl@1807e3f6 이렇게 나오면 연결 되었다는 뜻.
	}
	
	// 여기가 db랑 연결해야하는부분.
	// 게시글 번호
	private static int boardNo;
	private static BoardDAO instance = new BoardDAOImpl();
	private BoardDAOImpl() {}
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private List<Board> boardList = new ArrayList<>();
	@Override
	public void insertBoard(Board board) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기
		Connection con = dbUtil.getConnection();
		String sql = "insert into board (title, writer, content) values (?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getWriter());
		pstmt.setString(3, board.getContent());
		pstmt.executeUpdate();
	}
	
	
	
	// db랑 연결해보자~!
	@Override
	public List<Board> selectBoard() throws SQLException {
		List<Board> list = new ArrayList<>();
		DBUtil dbUtil = DBUtil.getInstance();
		//데이터베이스 연결하기
		Connection con = dbUtil.getConnection();
		//실행할 SQL문 작성 (string으로 직접 보내줘야한다.)
		String sql = "select no, title, writer, view_cnt from board order by no desc";
		//SQL문을 실행할 객체를 얻어온다.
		PreparedStatement pstmt = con.prepareStatement(sql);
		//sql문 실행하기 : select문을 실행하려면 executeQuery, select절 이외는 executeUpadate
		ResultSet rs = pstmt.executeQuery();
		// 데이터가 들어온 개수만큼 반복돈다
		while (rs.next()) { // rs에 다음 데이터가 있나? true
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			int veiwCnt = rs.getInt("view_cnt"); // 네이밍룰 조심~~!~!~!
			Board board = new Board();
			board.setNo(no);
			board.setTitle(title);
			board.setViewCnt(veiwCnt);
			board.setWriter(writer);
			list.add(board);
		}
		
		return list;
	}
	
	
	
	
	
	@Override
	public Board selectBoardByNo(int no) throws SQLException {

		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기
		Connection con = dbUtil.getConnection();
		// 실행할 SQL 문 작성
		// 값이 들어갈 자리는 ?를 준다.
		String sql = "select no, title, writer, content, view_cnt from board where no = ?";
		// SQL문을 실행할 객체를 얻어온다.
		PreparedStatement pstmt = con.prepareStatement(sql);

		// SQL문을 실행 전에 ?에 값을 설정하자.
		// pstmt.setInt(no의 ?번째, no)
		pstmt.setInt(1, no);

		// SQL문 실행하기 : select(executeQuery), select절 이외(executeUpdate)
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			String content = rs.getString("content");
			int viewCnt = rs.getInt("view_cnt");
			Board board = new Board();
			board.setNo(no);
			board.setTitle(title);
			board.setWriter(writer);
			board.setContent(content);
			board.setViewCnt(viewCnt);
			return board;
		}
		return null;
	}
	@Override
	public void deleteBoardByNo(int no) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기
		Connection con = dbUtil.getConnection();
		String sql = "delete from board where no = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.executeUpdate();
	}
	@Override
	public void updateViewCnt(int no) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기
		Connection con = dbUtil.getConnection();

		String sql = "update board set view_cnt = view_cnt + 1 where no = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.executeUpdate();
	}
	@Override
	public void updateBoard(int no, String title, String writer, String content) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기
		Connection con = dbUtil.getConnection();
		String sql = "update board set title = ?, writer = ?, content = ? where no = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, writer);
		pstmt.setString(3, content);
		pstmt.setInt(4, no);
		pstmt.executeUpdate();
	}
}





