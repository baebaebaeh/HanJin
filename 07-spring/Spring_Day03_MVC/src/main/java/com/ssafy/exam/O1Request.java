/*
1. 사용자 요청 -> 서버 응답
백앤드 @WebServlet("/주소"), class위에서 선언
스프링 @RequestMapping("/주소"), class에서 선언
     @GetMapping("/주소"), @PostMapping("/주소"), method에 선언

2. 파라미터 받기
백엔드 request.getParameter("~~")
스프링 @RequestParam, @RequestParam Map
	 DTO객체
	 
3. 페이지 이동
백엔드 forward, redirect
스프링 ??

4. 공유 처리
백엔드 request.setAttribute(~~);
스프링 ??
 */


package com.ssafy.exam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// /request가 중복이라 빼준다.
@RequestMapping("/request")
public class O1Request {
	
	public O1Request() {
		System.out.println("O1Request 생성자 호출됨...");
	}

	@RequestMapping("/test1")
	public String test1() {
		System.out.println("test1 호출됨..");
		// redirect가 붙으면 redirect 안붙으면 forward방식
		// 얘는 redirect인데 /붙여준다.
		return "redirect:/01request.jsp";
	}
	
	@RequestMapping("test2")
	public String test2() {
		System.out.println("test2 호출됨..");
		// redirect가 붙으면 redirect 안붙으면 forward방식
		return "redirect:/01request.jsp";
	}
	
//	@RequestMapping(value = "/test3") // value가 생략되어있다.
	@RequestMapping("/test3") // value가 생략되어있다.
	public String test3() {
		System.out.println("test3 호출됨..");
		// redirect가 붙으면 redirect 안붙으면 forward방식
		return "redirect:/01request.jsp";
	}
	
	@RequestMapping(path = "/test4") // value가 생략되어있다.
	public String test4() {
		System.out.println("test4 호출됨..");
		// redirect가 붙으면 redirect 안붙으면 forward방식
		return "redirect:/01request.jsp";
	}
	
	@RequestMapping(path = {"/test5-1", "/test5-2"}) // 배열로 가능
	public String test5() {
		System.out.println("test5 호출됨..");
		// redirect가 붙으면 redirect 안붙으면 forward방식
		return "redirect:/01request.jsp";
	}
	
	@RequestMapping(value = "/test6", method= RequestMethod.GET) // 속성이 두개면 생략 불가능
	public String test6() {
		System.out.println("test6 호출됨..");
		// redirect가 붙으면 redirect 안붙으면 forward방식
		return "redirect:/01request.jsp";
	}
	
	@RequestMapping(value = "/test7", method= RequestMethod.POST) // 속성이 두개면 생략 불가능
	public String test7() {
		System.out.println("test7 호출됨..");
		// redirect가 붙으면 redirect 안붙으면 forward방식
		return "redirect:/01request.jsp";
	}
	
	// spring 4.3버전부터 지원
	@GetMapping("/test8")
	public String test8() {
		System.out.println("test8 호출됨..");
		// redirect가 붙으면 redirect 안붙으면 forward방식
		return "redirect:/01request.jsp";
	}
	
	@PostMapping("/test9")
	public String test9() {
		System.out.println("test9 호출됨..");
		// redirect가 붙으면 redirect 안붙으면 forward방식
		return "redirect:/01request.jsp";
	}
}















