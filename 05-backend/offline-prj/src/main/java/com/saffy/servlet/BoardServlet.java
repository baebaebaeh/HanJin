package com.saffy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

class Board {
	String title;
	String writer;
	@Override
	public String toString() {
		return "Board [title=" + title + ", writer=" + writer + "]";
	}
	public Board(String title, String writer) {
		super();
		this.title = title;
		this.writer = writer;
	}
	public Board() {}
}

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
/*
		사용자가 전송한 제목 내용 작성자 파라미터를 꺼낸다.
		꺼낸 데이터를 사용자에게 확인 시켜준다.
		-----------------------------------------
		번호            제목              작성자
		-----------------------------------------
		1 			   작성한 제목         작성한 이름
		-----------------------------------------
 */
	List<Board> boards = new ArrayList<>();
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		Board board = new Board(title, writer);
		boards.add(board);
		
		PrintWriter out = response.getWriter();
		out.print(
				"""
				<!DOCTYPE html>
				<html lang="en">
				<head>
				  <meta charset="UTF-8">
				  <meta name="viewport" content="width=device-width, initial-scale=1.0">
				  <title>Document</title>
				</head>
				<body>
				<table>
				  <thead>
				    <tr>
				      <th>번호</th>
				      <th>제목</th>
				      <th>작성자</th>
				    </tr>
				  </thead>
				  <tbody>
				""");
		for (int i = 1; i <= boards.size(); i++) {
			out.print(
					"""
				    <tr>
				      <th>%s</th>
				      <th>%s</th>
				      <th>%s</th>
				    </tr>
					""".formatted(i, boards.get(i - 1).title, boards.get(i - 1).writer));
		}
		out.print(
				"""
				  </tbody>
				  </table>
				</body>
				</html>
				""");

	}
}






















