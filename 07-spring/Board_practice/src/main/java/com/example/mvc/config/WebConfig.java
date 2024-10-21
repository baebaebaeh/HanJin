package com.example.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.mvc.intercepter.BoardInterceptor;

public class WebConfig implements WebMvcConfigurer {
	
	
	private final BoardInterceptor boardInterceptor;
	@Autowired
	public WebConfig(BoardInterceptor boardInterceptor) {
		this.boardInterceptor = boardInterceptor;
	}
	
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(boardInterceptor).addPathPatterns("/");
	}
	
}
