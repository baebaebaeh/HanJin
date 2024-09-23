package com.ssafy.ws.step5.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.ws.step5.dto.User;

public class UserManager {
	private Map<String, User> users = new HashMap<>();
	private int userSeq;
	
	
	private UserManager() {}
	private static UserManager instance = new UserManager();
	public static UserManager getInstance() {
		return instance;
	}
	
	public User login(String id, String pw) {
		User user = users.get(id);
		if (user != null && user.getPassword().equals(pw)) {
			return user;
		}
		return null;
	}
	public boolean signUp(User user) {
		String userId = user.getUserId();
		User existUser = users.get(userId);
		if (existUser == null) {
			users.put(userId, user);
			return true;
		}
		return false;
	}
	public String getNickName(int userSeq) {
		return null;
	}
}
