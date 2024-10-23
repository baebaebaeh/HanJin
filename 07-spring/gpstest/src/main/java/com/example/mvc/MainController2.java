package com.example.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController2 {
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
}