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
	public void insertBoard(Board board) {
		board.setNo(++boardNo);
		boardList.add(board);
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
	public Board selectBoardByNo(int no) {
		for (Board b : boardList) {
			if (b.getNo() == no) {
				return b;
			}
		}
		return null;
	}
	@Override
	public void deleteBoardByNo(int no) {
		for (Board b : boardList) {
			if (b.getNo() == no) {
				boardList.remove(b);
				return;
			}
		}
		return;
	}
	@Override
	public void updateViewCnt(int no) {
		for (Board b : boardList) {
			if (b.getNo() == no) {
				b.setViewCnt(b.getViewCnt() + 1); 
				return;
			}
		}
	}
	@Override
	public void updateBoard(int no, String title, String writer, String content) {
		for (Board b : boardList) {
			if (b.getNo() == no) {
				b.setContent(content);
				b.setTitle(title);
				b.setWriter(writer);
				b.setViewCnt(0);
			}
		}
	}
}





