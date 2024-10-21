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
	<jsp:include page="/WEB-INF/includes/setting.jsp" />
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>			
			<th>등록일</th>			
		</tr>
		<c:forEach items="${boards}" var="board">
		<tr>
			<th>${board.no}</th>
			<th>${board.title}</th>
			<th>${board.writer}</th>			
			<th>${board.regDate}</th>			
		</tr>
		</c:forEach>

	</table>
</body>
</html>