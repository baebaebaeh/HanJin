package com.ssafy.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.mvc.model.dto.User;

import org.springframework.web.bind.annotation.RequestParam;
 

@Controller
public class RestController1 {
	
	
	@GetMapping("/rest1/test1")
	public String test1() {
		return "Hello REST API";
	}
	
	
	
	// responseBody라는게 뭐냐
	// 위는 Hello REST API.jsp로 가버리는데 얘는 그냥 String을 반환해버린다.
	@GetMapping("/rest1/test2")
	@ResponseBody
	public String test2() {
		return "Hello REST API";
	}
	
	
	// map객체를 보냈는데 왜
	@GetMapping("/rest1/test3")
	@ResponseBody
	public Map<String, String> test3() {
		// 키=벨류
		Map<String, String> data = new HashMap<>();
		data.put("id", "ssafy");
		data.put("pw", "1234");
		
		return data;
	}
	
	@GetMapping("/rest1/test4")
	@ResponseBody
	public User test4() {
		User user = new User("ssafy", "1234", "김싸피"); 
		
		return user;
	}
	
	@GetMapping("/rest1/test5")
	@ResponseBody
	public List<User> test5() {
		List<User> list = new ArrayList<>();
		list.add(new User("ssafy", "ssafy", "ssafy"));
		list.add(new User("ssafy", "ssafy", "ssafy"));
		list.add(new User("ssafy", "ssafy", "ssafy"));
		list.add(new User("ssafy", "ssafy", "ssafy"));
		list.add(new User("ssafy", "ssafy", "ssafy"));
		list.add(new User("ssafy", "ssafy", "ssafy"));
		return list;
	}
	
	
	
	
	
	
	
	
}
