package com.ssafy.gt.main.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.ssafy.gt.user.model.dao.UserDAO;
import com.ssafy.gt.user.model.dao.UserDAOImpl;
import com.ssafy.gt.user.model.dto.User;

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

	private UserDAO userDao = UserDAOImpl.getInstance();
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action == null) {
			action = "main";
		}
		try {
			

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
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
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

	private void signUp(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
		User user = new User();
		String userEmail = req.getParameter("userEmail");
		String userPassword = req.getParameter("userPassword");
		String userName = req.getParameter("userName");
		user.setUserEmail(userEmail);
		user.setUserName(userPassword);
		user.setUserPassword(userName);
		boolean signUp = userDao.signUp(user);
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

	private void signIn(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
		String userEmail = req.getParameter("userEmail");
		String userPassword = req.getParameter("userPassword");
		User user = userDao.signIn(userEmail, userPassword);
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
