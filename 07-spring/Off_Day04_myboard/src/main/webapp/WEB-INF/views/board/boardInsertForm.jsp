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
	
	<form action="${path}/board/boardInsert" method="post" enctype="multipart/form-data">
		제목 : <input type="text" name="title"><br>
		쓰니 : <input type="text" name="writer"><br>
		내용 : <input type="text" name="content"><br>
		파일 첨부 : <input type="file" name="attach"><br>
		<button>입력</button>
		<button type="reset">초기화</button>
	</form>
</body>
</html>
