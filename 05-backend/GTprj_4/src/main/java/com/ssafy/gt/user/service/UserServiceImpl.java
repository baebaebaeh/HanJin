package com.ssafy.gt.user.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.ssafy.gt.user.model.dao.UserDAO;
import com.ssafy.gt.user.model.dto.User;
import com.ssafy.gt.util.DBUtil;

public class UserServiceImpl implements UserDAO, UserService {
	private UserServiceImpl() {}
	private static UserDAO instance = new UserServiceImpl();
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
}
