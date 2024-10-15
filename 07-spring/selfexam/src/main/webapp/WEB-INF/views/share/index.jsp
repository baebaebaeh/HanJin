<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/">abcd로 이동하기</a>
	<h2>데이터 공유</h2>
	<h2>공유된 데이터 확인 User : ${user}</h2>
	<h2>공유된 데이터 확인 u : ${u}</h2>
	<a href="${pageContext.request.contextPath}/share/test1?id=abcd&password=1111">ModelAttribute 공유</a>
	<br>
	<a href="${pageContext.request.contextPath}/share/test2?id=abcd&password=1111">ModelAttribute 공유</a>
	<br>
	<a href="${pageContext.request.contextPath}/share/test3">Model 공유</a>
	<div>${msg}:::${hello}</div>
	<br>
	<a href="${pageContext.request.contextPath}/share/test4?id=abcd&password=1111">map 공유</a>
	<br>
</body>
</html>