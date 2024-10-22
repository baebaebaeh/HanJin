<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
<body>
	<c:set var="path" value="${pageContext.request.contextPath }" />

	<h1>HELLO! LIST PAGE</h1>
	<a href="${path }/board/boardList">게시판 이동</a>

	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>쓰니</td>
			<td>내용</td>
			<td>조회수</td>
			<td>날짜</td>
		</tr>
		<c:forEach items="${list }" var="board">
			<tr>
				<td>${board.no }</td>
				<td><a href="${path }/board/boardDetail?no=${board.no}">${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.content }</td>
				<td>${board.viewCnt }</td>
				<td>${board.regDate }</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<c:forEach var="i" begin="1" end="${lastPage }">
			<a href="boardList?page=${i }">[${i }]</a>
		</c:forEach>
	</div>
	<div>
		<span><a href="${path }/board/boardInsert">입력창</a></span>
	</div>

</body>
</html>
