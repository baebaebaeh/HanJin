<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판정보</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		<tr>
			<td>${board.no}</td>
			<td><a href="/board/detail?no=${board.no}">${board.title}</a></td>
			<td>${board.writer}</td>
			<td>${board.viewCnt}</td>
			<td>${board.regDate}</td>
		</tr>			
	</table>
	<a href="${pageContext.request.contextPath}/board/write">게시글등록</a>
</body>
</html>