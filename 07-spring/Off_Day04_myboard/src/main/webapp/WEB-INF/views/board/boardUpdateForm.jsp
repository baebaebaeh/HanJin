<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
<body>
	<c:set var="path" value="${pageContext.request.contextPath }" />
	
	<h1>HELLO! DETAIL PAGE</h1>
	<a href="${path}/board/boardList">게시판 이동</a>
	
	<form action="${path}/board/boardUpdate" method="post">
		<input type="hidden" name="no" value="${board.no }">
		제목 : <input type="text" name="title" value="${board.title }"><br>
		쓰니 : <input type="text" name="writer" value="${board.writer }"><br>
		내용 : <input type="text" name="content" value="${board.content }"><br>
		<button>수정</button>
		<button type="reset">초기화</button>
	</form>
</body>
</html>
