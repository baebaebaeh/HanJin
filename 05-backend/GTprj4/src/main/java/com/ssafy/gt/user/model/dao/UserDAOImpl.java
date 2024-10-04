package com.ssafy.gt.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.ssafy.gt.user.model.dto.User;
import com.ssafy.gt.util.DBUtil;

public class UserDAOImpl implements UserDAO {
	private UserDAOImpl() {}
	private static UserDAO instance = new UserDAOImpl();
	public static UserDAO getInstance() {
		return instance;
	}
	
	
	

	@Override
	public User signIn(String userEmail, String userPassword) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기
		Connection con = dbUtil.getConnection();
		String sql = "select * from tb_user where user_email=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userEmail);
		ResultSet rs = pstmt.executeQuery();
		if (!rs.next()) {
			System.out.println(11);
		} else {
			String email = rs.getString("user_email");
			String password = rs.getString("user_password");
			String name = rs.getString("user_name");
			int isUser = rs.getInt("is_user");
			if (password.equals(userPassword)) {
				// 받아주기
				User user = new User();
				user.setUserEmail(email);
				user.setUserPassword(password);
				user.setUserName(name);
				user.setIsUser(isUser);
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean signUp(User user) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기
		Connection con = dbUtil.getConnection();
		String sql = "select * from tb_user where user_email=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserEmail());
		ResultSet rs = pstmt.executeQuery();
		if (!rs.next()) {
			sql = "insert into tb_user (user_email, user_password, user_name) values(?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserEmail());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.executeUpdate();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getNickName(int userSeq) {
		return null;
	}


	@Override
	public boolean forgotPassword(String userEmail, String userName, String userPassword) throws SQLException {
	    DBUtil dbUtil = DBUtil.getInstance();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	   
	    try {
	        // 데이터베이스 연결하기
	        con = dbUtil.getConnection();
	        String sql = "select * from tb_user where user_email=? ";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, userEmail);
	        rs = pstmt.executeQuery();
	        
	        if (!rs.next()) {
	            System.out.println("sql에 값 없어용!");
	            return false;
	        } else {
	            String email = rs.getString("user_email");
	            String password = rs.getString("user_password");
	            String name = rs.getString("user_name");
	            int isUser = rs.getInt("is_user");
	            
	            // 이메일, 아이디 정보 일치 한다면 -> 비밀번호 변경
	            if (email.equals(userEmail) && name.equals(userName)) {
	                sql = "update tb_user set user_password = ? where user_email = ?";
	                pstmt = con.prepareStatement(sql);
	                pstmt.setString(1, userPassword);
	                pstmt.setString(2, userEmail);
	                pstmt.executeUpdate();
	                return true;
	            }
	            // 이메일 정보 있지만, 아이디 정보 일치 하지 않는다면
	            return false;
	        }
	    } finally {
	        // 자원 해제
	        if (rs != null) rs.close();
	        if (pstmt != null) pstmt.close();
	        if (con != null) con.close();
	    }
	}


//	@Override
//	public boolean forgotPassword(String userEmail, String userName, String userPassword) throws SQLException {
//		DBUtil dbUtil = DBUtil.getInstance();
//		// 데이터베이스 연결하기
//		Connection con = dbUtil.getConnection();
//		String sql = "select * from tb_user where user_email=? ";
//		PreparedStatement pstmt = con.prepareStatement(sql);
//		pstmt.setString(1, userEmail);
//		ResultSet rs = pstmt.executeQuery();
//		
//		
//		if (!rs.next()) {
//			System.out.println("sql에 값 없어용!");
//			// 해당 이메일로 가입된 정보가 없음   -> 정보 숨긴다 "비밀번호 변경 실패"
//			return false;
//		} 
//		else {
//			String email = rs.getString("user_email");
//			String password = rs.getString("user_password");
//			String name = rs.getString("user_name");
//			int isUser = rs.getInt("is_user");
//			
//			// 이메일, 아이디 정보 일치 한다면 -> 비밀번호 변경
//			if (email.equals(userEmail) && name.equals(userName)) {
//				sql = "update tb_user set user_password = ? where user_email = ?";
//				pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, userPassword);
//				pstmt.setString(2, userEmail);
//				pstmt.executeUpdate();
//				return true;
//			}
//			
//			// 이메일 정보 있지만, 아이디 정보 일치 하지 않는다면 -> 정보 숨긴다 "비밀번호 변경 실패"  
//			return false;
//		}
//	}
}
