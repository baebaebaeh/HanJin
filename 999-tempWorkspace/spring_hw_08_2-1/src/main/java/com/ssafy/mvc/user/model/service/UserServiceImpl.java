package com.ssafy.mvc.user.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.user.model.dao.UserDao;
import com.ssafy.mvc.user.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserDao userDao;
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public List<User> allUser() {
		List<User> list = userDao.selectAll();
		return list;
	}
	
}
