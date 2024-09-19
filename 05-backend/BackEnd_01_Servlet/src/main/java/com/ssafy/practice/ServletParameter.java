package com.ssafy.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");
		
		String text = req.getParameter("text");
		System.out.println(text);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		
		String text = req.getParameter("text");
		System.out.println(text);
	}

}
