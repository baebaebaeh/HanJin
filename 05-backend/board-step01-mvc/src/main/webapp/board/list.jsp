<%@page import="com.ssafy.exam.Board"%>
<%@page import="java.util.List"%>


<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
%>
<%
	// list메서드에서 보내준 list받아주자
	// 컨트롤 스페이스로 임포트 자동으로 해주자
	List<Board> list = (List<Board>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>대전 4반 게시판</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
		<%
			for(Board b : list) {
		%>
		<tr>
			<td><%= b.getNo() %></td>
			<td>연습중</td>
			<td>쌤</td>
			<td>4</td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="/board-step01-mvc/board?action=writeForm">글쓰기</a>
</body>
</html>