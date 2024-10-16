package com.ssafy.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.user.model.dto.User;
import com.ssafy.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@PostMapping("/login")
	public String login(Model model, User user, HttpSession session) {
		if (userService.searchUser(user)) {
			session.setAttribute("loginUser", user);
			return "redirect:/";
		}
		model.addAttribute("msg", true);
		return "/index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/regist")
	public String regist() {
		return "/regist";
	}
	
}
