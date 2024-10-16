package com.ssafy.mvc.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/* 등록요청이나 상세보기 요청이 들어온 경우 세션에 로그인 정보가 있는지 확인
 * 로그인 정보가 있다면 그대로 진행하고, 없다면 메인 화면으로 돌려보낸다.
 */

import org.springframework.web.servlet.HandlerInterceptor;

public class SessionInterceptor implements HandlerInterceptor{
	//코드작성		
}
