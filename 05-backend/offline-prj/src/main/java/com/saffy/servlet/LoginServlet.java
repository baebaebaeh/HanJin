package com.saffy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private Map<String, String> members = new HashMap<>();
	public LoginServlet() {
		members.put("ssafy", "ssafy");
		members.put("admin", "admin");
	}
	//http://localhost:8080/offline-prj/login?id=ssafy&password=1234
	// 쿼리스트링 파라미터
	public void service(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		String result = "로그인 실패하였습니다.";
		String pass = members.get(id);
		if (pass != null) {
			if (pass.equals(password)) {
				result = "로그인 성공하였습니다.";
			}
		}
		
		System.out.println("로그인 처리");
		
		out.print(
				"""
				<html>
					<head><title>연습</title></head>
					<body>
						<h2>아이디 : %s</h2>
						<h2>패스워드 : %s</h2>
						<h2>결과 : %s</h2>
					</body>
				</html>
				""".formatted(id, password, result));
		out.close();
	}
}
