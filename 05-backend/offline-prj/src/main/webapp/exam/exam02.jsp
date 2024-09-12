<%-- JSP page 지시문 --%>
<!-- page 지시문 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
	String memberMsg = "member 메세지";
	public void call() {}
%>
<%
	// public void aaa() {}
	String msg = "JSP연습페이지";
// 로컬변수 선언
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>메세지 : <%= msg %></h2>
	<h2>메세지 : <% out.print(msg); %></h2>
</body>
</html>