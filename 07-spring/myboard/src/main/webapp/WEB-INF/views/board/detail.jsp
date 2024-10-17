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
			<th>번호</th><td>${board.no}</td>
		</tr>
		<tr>
			<th>제목</th><td>${board.title}</td>
		</tr>
		<tr>
			<th>글쓴이</th><td>${board.writer}</td>
		</tr>
		<tr>
			<th>내용</th><td>${board.writer}</td>
		</tr>
		<tr>
			<th>조회수</th><td>${board.viewCnt}</td>
		</tr>
		<tr>
			<th>등록일</th><td>${board.regDate}</td>
		</tr>
		<c:if test="${board.boardFile.oriName != null}">
		<tr>
			<th>파일이름</th><td>${board.boardFile.oriName}</td>
		</tr>		
		</c:if>
	</table>
	<a href="${pageContext.request.contextPath}/board/write">게시글등록</a>
</body>
</html>