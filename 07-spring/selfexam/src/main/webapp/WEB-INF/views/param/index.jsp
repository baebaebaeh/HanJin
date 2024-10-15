<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/">abcd로</a>
	
	<h2>파라미터 처리</h2>
		<a href="${pageContext.request.contextPath}/param/test1?id=hong&pass=1111">HttpServletRequest</a>
		<br>
		<a href="${pageContext.request.contextPath}/param/test2?id=hong&pass=1111">@RequestParam</a>
		<br>
		<a href="${pageContext.request.contextPath}/param/test3-1?id=hong&pass=1111">@RequestParam - map</a>
		<br>
		<a href="${pageContext.request.contextPath}/param/test3-2?id=hong&pass=1111">map</a>
		<br>
		<a href="${pageContext.request.contextPath}/param/test4?id=hong&pass=1111">DTO객체</a>
		<br>
</body>
</html>