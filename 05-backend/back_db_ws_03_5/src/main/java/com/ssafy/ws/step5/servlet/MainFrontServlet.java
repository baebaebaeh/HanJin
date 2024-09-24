package com.ssafy.ws.step5.servlet;

import java.io.IOException;

import com.ssafy.ws.step5.dto.User;
import com.ssafy.ws.step5.manager.UserManager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@WebServlet("/main")
public class MainFrontServlet extends HttpServlet {

	private UserManager um = UserManager.getInstance();
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action == null) {
			action = "main";
		}
		switch (action) {
		case "main": {
			main(req, resp);
			break;
		}
		case "signIn": {
			signIn(req, resp);
			break;
		}
		case "signInForm": {
			signInForm(req, resp);
			break;
		}
		case "signUp": {
			signUp(req, resp);
			break;
		}
		case "signUpForm": {
			signUpForm(req, resp);
			break;
		}
		case "signOut": {
			signOut(req, resp);
			break;
		}
		}
	}

	private void signOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect(req.getContextPath() + "/main");
	}

	private void signUpForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/sign/signUpForm.jsp");
		rd.forward(req, resp);
	}

	private void signUp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		User user = new User();
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		String userName = req.getParameter("userName");
		String nickName = req.getParameter("nickName");
		String email = req.getParameter("email");
		user.setEmail(email);
		user.setNickName(nickName);
		user.setPassword(password);
		user.setUserId(userId);
		user.setUserName(userName);
		boolean signUp = um.signUp(user);
		if (signUp) {
			// 회원가입 성공
			HttpSession session = req.getSession();
			session.setAttribute("memberInfo", user);
			resp.sendRedirect(req.getContextPath() + "/main");
		} else {
			// 회원가입 실패
			resp.sendRedirect(req.getContextPath() + "/error/signUpError.jsp");
		}
	}

	private void signIn(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		User user = um.login(userId, password);
		if (user == null) {
			// 로그인 실패
			resp.sendRedirect(req.getContextPath() + "/main?action=signInForm");
		} else {
			// 로그인 성공
			HttpSession session = req.getSession();
			session.setAttribute("memberInfo", user);
			resp.sendRedirect(req.getContextPath() + "/main");
		}
	}

	private void signInForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/sign/signInForm.jsp");
		rd.forward(req, resp);
	}

	private void main(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/main.jsp");
		rd.forward(req, resp);
	}
}
