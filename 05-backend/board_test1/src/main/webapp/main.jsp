<%@page import="com.ssafy.ws.step5.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

User user = (User)session.getAttribute("memberInfo");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
	<%
	if (user == null) {
	%>
	<a href="<%= request.getContextPath() %>/main?action=signInForm">로그인</a>
	<a href="<%= request.getContextPath() %>/main?action=signUpForm">회원가입</a>
	<%
	} else {
		String userId = user.getUserId();
		String password = user.getPassword();
		String userName = user.getUserName();
		String nickName = user.getNickName();
		String email = user.getEmail();
	%>
	<p><%= userName %>님 반갑습니다.</p>
	<a href="<%= request.getContextPath() %>/main?action=signOut">로그아웃</a>
	<%
		}
	%>
</body>
</html>