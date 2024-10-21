<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/includes/setting.jsp" />
	<h2>메인화면</h2>
	<a href="${contextPath}/board/list">게시물 보기</a>
	<a href="${contextPath}/board/files">파일 보기</a>
</body>
</html>