package com.ssafy.gt.main.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.gt.user.model.dao.ReviewDAO;
import com.ssafy.gt.user.model.dao.ReviewDAOImpl;
import com.ssafy.gt.user.model.dao.UserDAO;
import com.ssafy.gt.user.model.dao.UserDAOImpl;
import com.ssafy.gt.user.model.dao.VideoDAO;
import com.ssafy.gt.user.model.dao.VideoDAOImpl;
import com.ssafy.gt.user.model.dto.Review;
import com.ssafy.gt.user.model.dto.User;
import com.ssafy.gt.user.model.dto.Video;

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
	private VideoDAO videoDao = VideoDAOImpl.getInstance();
	private ReviewDAO reviewDao = ReviewDAOImpl.getInstance();

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
			case "forgotPasswordForm": {
				forgotPasswordForm(req, resp);
				break;
			}
			case "updatePassword": {
				updatePassword(req, resp);
				break;
			}
			case "writeReview": {
				writeReview(req, resp);
				break;
			}
			case "viewReview": {
				viewReview(req, resp);
				break;
			}
			case "reviewForm": {
				reviewForm(req, resp);
				break;
			}
			case "videoCntUp": {
				videoCntUp(req, resp);
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	private void videoCntUp(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		String videoId = req.getParameter("videoId");
		videoDao.reviewCntUp(videoId);
		resp.sendRedirect(req.getContextPath() + "/main?action=reviewForm&videoId=" + videoId);
	}

	private void reviewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		String videoId = req.getParameter("videoId");
		Video video = videoDao.searchById(videoId);
		req.setAttribute("video", video);
		List<Review> reviews = reviewDao.findReviewById(videoId);
		req.setAttribute("reviews", reviews);
		RequestDispatcher rd = req.getRequestDispatcher("/review/review2.jsp");
		rd.forward(req, resp);
	}

	private void viewReview(HttpServletRequest req, HttpServletResponse resp) {
		
	}

	private void writeReview(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, SQLException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("memberInfo");
		System.out.println(user);
		String videoId = req.getParameter("videoId");
		String reviewTitle = req.getParameter("reviewTitle");
		String reviewContent = req.getParameter("reviewContent");
		String reviewScore = req.getParameter("reviewScore");
        String reviewEmail = user.getUserEmail();
        Review review = new Review();
        review.setReviewId(videoId);
        review.setReviewTitle(reviewTitle);
        review.setReviewContent(reviewContent);
        review.setReviewScore(reviewScore);
        review.setReviewEmail(reviewEmail);
        reviewDao.addReview(review);
		resp.sendRedirect(req.getContextPath() + "/main?action=reviewForm&videoId=" + videoId);
	}

	private void updatePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		String userEmail = req.getParameter("userEmail");
		String userPassword = req.getParameter("userPassword");
		String userName = req.getParameter("userName");
		
		boolean forgotPassword = userDao.forgotPassword(userEmail, userName, userPassword);
		
		// 비밀번호 변경 성공
		if (forgotPassword) {
			 req.setAttribute("message", "비밀번호가 성공적으로 변경되었습니다.");
			 req.setAttribute("type", "success"); // 성공 메시지 타입
			
		}
		// 비밀번호 변경 실패 
		else {
			req.setAttribute("message", "비밀번호 변경에 실패했습니다. 이메일 또는 이름을 확인하세요.");
	        req.setAttribute("type", "error"); // 실패 메시지 타입
		}
		
		
		// 비밀번호 변경 페이지로 리다이렉트
	    RequestDispatcher dispatcher = req.getRequestDispatcher("/main?action=forgotPasswordForm");
	    dispatcher.forward(req, resp);
		
	}

	private void forgotPasswordForm(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/sign/forgotPasswordForm.jsp");
		rd.forward(req, resp);

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

	private void signUp(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, ServletException {
	    User user = new User();
	    String userEmail = req.getParameter("userEmail");
	    String userPassword = req.getParameter("userPassword");
	    String userName = req.getParameter("userName");

	    user.setUserEmail(userEmail);
	    user.setUserName(userName); // 수정: userName을 userPassword 자리에 세팅
	    user.setUserPassword(userPassword);

	    boolean signUp = userDao.signUp(user);

	    if (signUp) {
	        // 회원가입 성공
	        HttpSession session = req.getSession();
	        session.setAttribute("memberInfo", user);
	        req.setAttribute("message", "회원가입에 성공했습니다.");
	        req.setAttribute("type", "success"); // 성공 메시지 타입
	    } else {
	        // 회원가입 실패
	        req.setAttribute("message", "회원가입에 실패했습니다. 다시 시도해 주세요.");
	        req.setAttribute("type", "error"); // 실패 메시지 타입
	    }
	    
	    
	 // 회원가입 페이지로 리다이렉트
	    RequestDispatcher dispatcher = req.getRequestDispatcher("/main?action=signUpForm");
	    dispatcher.forward(req, resp);
	}


	private void signIn(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, ServletException {
	    String userEmail = req.getParameter("userEmail");
	    String userPassword = req.getParameter("userPassword");
	    User user = userDao.signIn(userEmail, userPassword);
	    
	    if (user == null) {
	        // 로그인 실패
	        req.setAttribute("message", "로그인에 실패했습니다. 이메일 또는 비밀번호를 확인하세요.");
	        req.setAttribute("type", "error");
	        RequestDispatcher dispatcher = req.getRequestDispatcher("/main?action=signInForm");
	        dispatcher.forward(req, resp);
	    } else {
	        // 로그인 성공
	        HttpSession session = req.getSession();
	        session.setAttribute("memberInfo", user);
	        req.setAttribute("message", "로그인에 성공했습니다.");
	        req.setAttribute("type", "success");
	        resp.sendRedirect(req.getContextPath() + "/main");
	    }
	}


	private void signInForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/sign/signInForm.jsp");
		rd.forward(req, resp);
	}

	private void main(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		List<Video> videos = videoDao.selectAll();
		for (Video v : videos) {
			System.out.println(v);
		}
		req.setAttribute("videos", videos);
		System.out.println(videos.size());
		RequestDispatcher rd = req.getRequestDispatcher("/main.jsp");
		rd.forward(req, resp);
	}
}