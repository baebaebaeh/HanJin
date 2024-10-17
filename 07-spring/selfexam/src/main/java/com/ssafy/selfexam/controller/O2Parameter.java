package com.ssafy.selfexam.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.selfexam.dto.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/param")
public class O2Parameter {
	
	@GetMapping("index")
	public String index() {
		return "param/index";
	}
	
	@GetMapping("test1")
	public String test1(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		System.out.println(id + "," + pass);
		return "param/index";
	}
	
	@GetMapping("test2")
	public String test2(@RequestParam String id, 
						@RequestParam(value = "pass") String password,
						@RequestParam(required = false) String name,  // 필수는 아니야~ 그리고 기본값으로 null값을 넣어줄께
//						@RequestParam(required = false, value = "pas") String n,
						@RequestParam(defaultValue = "ssafy@ssafy.com") String email){
		
		System.out.println(id + "," + password + "," + name + "," + email);
		
 		return "param/index";
	}
	// map은 살짝 불안하다.
	// 왜냐하면 id였다가 pw였다가 해도 
	@GetMapping("test3-1")
	public String test3_1(@RequestParam Map<String, String> map){
		// 데이터를 파라미터로 받을때 사용
		System.out.println(map);
		return "param/index";
	}
	
	@GetMapping("test3-2")
	public String test3_2(Map<String, String> map){
		// 데이터를 화면에 공유할때 사용
		System.out.println(map);
		return "param/index";
	}
	
	@GetMapping("test4")
	public String test4(User user){
		System.out.println(user);
		return "param/index";
	}
	
	
}