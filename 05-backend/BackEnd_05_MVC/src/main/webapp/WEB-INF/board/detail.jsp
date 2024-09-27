<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
</head>
<body>
	<div>${board.title }</div>
	<div>${board.content }</div>
	
	<a href="board?action=delete&id=${board.id}">삭제</a>
	<a href="board?action=updateform&id=${board.id}">수정</a>
</body>
</html>