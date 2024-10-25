package com.ssafy.mvc.user.model.dao;

import java.util.List;

import com.ssafy.mvc.user.model.dto.User;

public interface UserDao {

	List<User> selectAll();

}
