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
	<form method="post" action="/board/write">
		<table>
			<tr>
				<th>제목 : <input name="title"> </th>
				<th>글쓴이 : <input name="writer"> </th> 
				<th>내용 : <input name="content"> </th>
			</tr>
			</table>
		<button>게시글 등록</button>
	</form>
	<form action="/board/list">
		<button>목록으로</button>
	</form>
</body>
</html>