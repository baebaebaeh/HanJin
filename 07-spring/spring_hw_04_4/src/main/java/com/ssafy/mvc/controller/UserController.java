package com.ssafy.mvc.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.mvc.model.dto.User;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/user")
public class UserController {
	
	@PostMapping("/login")
	public String login(Model model, User user, HttpSession session) {
		if (user.getUserId().equals("ssafy") && user.getUserPass().equals("1234")) {
			user.setUserName("김싸피");
			session.setAttribute("loginUser", user);
			return "redirect:/";
		}
		model.addAttribute("msg", "alert");
		return "/index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/index";
	}
	
}
