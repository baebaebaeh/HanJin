package com.ssafy.mvc.interceptor;

import java.time.LocalTime;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 오전 2시부터 3시까지 (서버시간 기준)
 * 메인화면, 리스트, 상세보기 요청을 제외한 요청이 들어오면
 * 서버 점검 안내페이지로 보내는 인터셉터
 */
public class CheckingTheServerInterceptor implements HandlerInterceptor{
	//코드작성
}
