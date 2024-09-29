<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%! 
	int A;
	int B = 20;
	String D;
	
	String name = "SSAFY";
	
	public int add(int A, int B) {
		return A + B;
	}
	
	public int abs(int A) {
		return A > 0 ? A : -A;
	}
	
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언부</title>
</head>
<body>


	<%
		int C = -10;
		out.print(add(A, B));
		out.print("<br>");
		out.print(abs(C));
		out.print("<br>");
		out.print(D);
	
	
	
	%>
	<a href="index.html">홈으로</a>
</body>
</html>