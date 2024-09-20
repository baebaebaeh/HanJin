package com.ssafy.exam;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * action 파라미터의 값으로 각각의 동작을 구분
 * 등록폼 : writeForm
 * 등록 : write
 * 목록 : list
 * 삭제 : delete
 */


@WebServlet("/board")
public class BoardController extends HttpServlet {
	
	private BoardDAO boardDao;
	public BoardController() {
		boardDao = BoardDAO.getInstance();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		switch (action) {
		case "list" : {
			// 목록페이지
			list(req, resp);
			break;
		}
		case "writeForm" : {
			writeForm(req, resp);
			break;
		}
		case "write" : {
			write(req, resp);
			break;
		}
		}
	}
	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 화면에 보여줄 데이터 준비한다.
		List<Board> list = boardDao.selectBoard();
		System.out.println(list);
		// req는 jsp랑 현재 메서드와 공유한다
		// 그래서 같이볼 수 잇는 곳에 올린다.(공유영역)
		req.setAttribute("list", list);
		// 화면 페이지로 이동한다.
		RequestDispatcher rd = req.getRequestDispatcher("/board/list.jsp");
		rd.forward(req, resp);
	}
	private void write(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 등록할 데이터를 파라미터에서 꺼낸다.
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		boardDao.insertBoard(board);
		
		System.out.println("title : " + title);
		System.out.println("writer : " + writer);
		System.out.println("content : " + content);
		// 등록한다.
		// http://localhost/board-step01-mvc/board
		// 목록페이지로 이동한다. (목록에 필요한 데이터를 준비하는 서블릿으로 이동)
		// 이때 forward 방식을 사용해야할까? 아니면 redirection을 사용해야할까?
		// redirect를 사용해야한ㄴ다.
		
		// 아래forward방식 사용하고 f5눌러보면 계속 등록시도한다.
//		RequestDispatcher rd = req.getRequestDispatcher("/board?action=list");
//		rd.forward(req, resp);
		//아래꺼 사용해야함
		resp.sendRedirect("/board-step01-mvc/board?action=list");
		
		// 아래는 뭐임?
//		list(req, resp);
	}
	private void writeForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 등록 페이지로 이동한다.
		RequestDispatcher rd = req.getRequestDispatcher("/board/writeForm.jsp");
		rd.forward(req, resp);
	}

}
