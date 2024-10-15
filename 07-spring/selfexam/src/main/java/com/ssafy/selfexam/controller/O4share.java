package com.ssafy.selfexam.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.selfexam.dto.User;

@Controller
@RequestMapping("/share")
public class O4share {
	@GetMapping("/index")
	public void index() {}
	
	@GetMapping("/test1")
	// 클래스 이름을 기반으로(클래스 이름의 첫글자를 소문자로 바꾼이름을) view에 보내준다.
	public String test1(User user) {
		System.out.println(user);
		return "share/index";
	}
	
	@GetMapping("/test2")
	// 클래스 이름을 기반으로 보내주기 싫으면 
	public String test2(@ModelAttribute("u") User u) {
		System.out.println(u);
		return "share/index";
	}
	@GetMapping("/test3")
	public String test3(Model model) {
		model.addAttribute("msg", "공유 1");
		model.addAttribute("hello", "하이~");
		return "share/index";
	}
	@GetMapping("/test4")
	public String test4(Map<String, String> map) {
		map.put("msg", "맵 공유 1");
		map.put("hello", "맵 하이~");
		return "share/index";
	}
	
}
