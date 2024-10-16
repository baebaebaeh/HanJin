package com.ssafy.user.service;

import org.springframework.stereotype.Repository;

import com.ssafy.user.model.dao.UserDao;
import com.ssafy.user.model.dto.User;

@Repository
public class UserServiceImpl implements UserService {
	private final UserDao userDao;
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public boolean searchUser(User user) {
		if (userDao.searchUser(user)) {
			return true;
		}
		return false;
	}
}
