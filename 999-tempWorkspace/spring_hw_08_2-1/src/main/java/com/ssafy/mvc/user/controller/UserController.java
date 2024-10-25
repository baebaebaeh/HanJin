package com.ssafy.mvc.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.user.model.dto.User;
import com.ssafy.mvc.user.model.service.UserService;

@RestController
@RequestMapping("/userapi")
public class UserController {
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/user")
	public ResponseEntity<Object> allUser() {
		List<User> list = userService.allUser();
		ResponseEntity<Object> responseEntity;
		try {
			if (list.isEmpty()) {
				responseEntity = new ResponseEntity<Object>(list, HttpStatus.NO_CONTENT);
			} else {	
				responseEntity = new ResponseEntity<Object>(list, HttpStatus.OK);
			}
		} catch (Exception e) {
			responseEntity = new ResponseEntity<Object>("문제가 발생했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
}
