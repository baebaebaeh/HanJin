package com.ssafy.user.model.dao;

import org.springframework.stereotype.Repository;

import com.ssafy.user.model.dto.User;
import com.ssafy.user.service.UserService;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Override
	public boolean searchUser(User user) {
		if (user.getId().equals("ssafy") && user.getPw().equals("1234")) {
			return true;
		}
		System.out.println("로그인정보가 다릅니다");
		return false;
	}
	
}
