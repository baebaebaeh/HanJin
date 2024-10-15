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
	<h2>페이지 이동 테스트 하기</h2>
	<a href="${pageContext.request.contextPath}/pagemove/mav">mav</a><br>
	<a href="${pageContext.request.contextPath}/pagemove/index">void 메서드</a> <br>
	<a href="${pageContext.request.contextPath}/pagemove/plain">plain 메서드</a>
</body>
</html>