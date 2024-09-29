package com.ssafy.gt.user.service;

import java.sql.SQLException;

import com.ssafy.gt.user.model.dto.User;

public interface UserService {

	User signIn(String userEmail, String userPassword) throws SQLException;

	boolean signUp(User user) throws SQLException;

	String getNickName(int userSeq);

}