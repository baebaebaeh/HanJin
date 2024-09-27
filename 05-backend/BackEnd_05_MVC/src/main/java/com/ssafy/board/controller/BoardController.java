package com.ssafy.board.controller;

import java.io.IOException;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private BoardService service = BoardServiceImpl.getInstance();
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch (action) {
		case "writeform": 
			doWriteForm(request, response);
			break;
		case "write":
			doWrite(request, response);
			break;
		case "list":
			doList(request, response);
			break;
		case "detail":
			doDetail(request, response);
			break;
		case "delete":
			doRemove(request, response);
			break;
		case "updateform":
			doUpdateForm(request, response);
			break;
		case "update":
			doUpdate(request, response);
			break;
		default:
			System.out.println("에러페이지로 가라");
			break;
		}
			
		
		
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Board board = service.getBoard(Integer.parseInt(request.getParameter("id")));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		
		service.modifyBoard(board);
		
		response.sendRedirect("board?action=list");
	}

	private void doUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Board board = service.getBoard(id);
		request.setAttribute("board", board);
		request.getRequestDispatcher("/WEB-INF/board/updateform.jsp").forward(request, response);
	}

	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		service.removeBoard(id);
		response.sendRedirect("board?action=list");
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("board", service.getBoard(id));
		request.getRequestDispatcher("/WEB-INF/board/detail.jsp").forward(request, response);
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", service.getList());
		request.getRequestDispatcher("/WEB-INF/board/list.jsp").forward(request, response);
	}

	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		//객체를 만들겠다.
		Board board = new Board(title, writer, content);
		
		service.writeBoard(board);
		
		//1. 등록한 게시글을 보러가는법
		
		//2. 게시글 전체목록으로 가는법 (V)
		response.sendRedirect("board?action=list");
		
		
		
	}

	private void doWriteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/board/writeform.jsp").forward(request, response);
	}
	
	
}
