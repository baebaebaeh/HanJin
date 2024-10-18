package com.ssafy.mvc.controller;

import java.net.BindException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {
	private static Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	@ExceptionHandler(Exception.class)
	public String handleException(Model model, Exception e) {
		logger.error("예외발생", e.getCause());
		
		if (e instanceof BindException) {
			model.addAttribute("message", "파라미터가 잘 등록되지 않았습니다.");
		}
		
		return "/error/errorpage";
	}
}
