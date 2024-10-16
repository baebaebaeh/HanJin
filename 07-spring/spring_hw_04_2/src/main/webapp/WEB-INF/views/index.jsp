<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<main>
		<h2>사용자관리</h2>
		<hr />
		<ul>
			<li><a href="${pageContext.request.contextPath}/user/regist">사용자
					등록</a></li>
			<li><a href="${pageContext.request.contextPath}/user/list">사용자
					목록</a></li>
		</ul>
	</main>
</body>
</html>