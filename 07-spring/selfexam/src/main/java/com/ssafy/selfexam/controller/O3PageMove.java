package com.ssafy.selfexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pagemove")
public class O3PageMove {
	
	// 얘는 언제쓰냐 model과 view가 같이있을때
	@GetMapping("/mav")
	public ModelAndView mav() {
		System.out.println("mav 불러옴");
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("msg", "하이 스프링부트"); // 이렇게 하면 공유영역에 올린다.
//		mav.setViewName("pagemove/index");
//		return mav;
		
		return new ModelAndView("pagemove/index"); // 이렇게 생성하면서 리턴 할 수 있다.
	}
	
	
	@GetMapping("/index")
	public void index() {
		System.out.println("void 메서드 불러옴");
		// return "pagemove/index";
		// void 일땐 url이 위와 같아진다.
	}
	
	
	
	
	@GetMapping("/plain")
	public String plain() {
		System.out.println("plain 메서드 불러옴");
		return "pagemove/index";
	}
	
	
	
	
}
