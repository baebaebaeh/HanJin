package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
	
	@GetMapping({"/", "/index"})
	public String home() {
		return "/index";
	}
	
}
