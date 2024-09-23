<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<body>
	<%
		if(session.getAttribute("userid") ==null){
			response.sendRedirect("07_LoginForm.jsp");
			//request.getParameter("password");
		}else{%>
			<%=session.getAttribute("userid") %>
			
			<a href="07_Logout.jsp">로그아웃</a>
			
			<form action="07_Logout.jsp" method="POST">
				<input type="submit" value="로그아웃">
			</form>
			
			
			
			<% 
		}
	%>
	
	


</body>
</html>