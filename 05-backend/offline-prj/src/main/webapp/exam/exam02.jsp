<%-- JSP page 지시문 --%>
<!-- page 지시문 -->
<%@ page contentType="text/html; charset=UTF-8" %>
<%!
	// 클래스의 멤버 자리에 선언된다.
	String memberMsg = "member 메세지";
	public void call() {}	
%>
<% 
	// public void aaa() {}
	String msg = "jsp 연습 메세지"; // 로컬변수 선언
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