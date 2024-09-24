<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EQ</title>
</head>
<body>

	<!-- 	url에서 쿼리스트링을 작성해주자.
	http://localhost:8080/BackEnd_04_El_JSTL/05_eq.jsp?id=ssafy
	 -->
	<%= request.getParameter("id") %> <br>
	${param.id } <br> <!-- null이여서 출력되지 않았다. -->
	
	== : <%= request.getParameter("id") == "ssafy" %> <br>
	equals() : <%= request.getParameter("id").equals("ssafy") %> <br>
	
	== (EL) : ${ param.id == "ssafy" } <br>
	eq (EL) : ${ param.id eq "ssafy" } <br>
	
</body>
</html>