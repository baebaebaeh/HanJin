<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
	<h3>로그인</h3>
	<form method="post" action="<%= request.getContextPath() %>/main">
		<input type="hidden" name="action" value="signIn">
		<div><input type="text" name="userId" placeholder="아이디"></div>
		<div><input type="password" name="password" placeholder="비밀번호"></div>
		<div><button>로그인</button></div>
	</form>
	<a href="<%= request.getContextPath() %>/main">메인으로</a>
</body>
</html>