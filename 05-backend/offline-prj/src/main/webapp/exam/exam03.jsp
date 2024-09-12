<%-- JSP page 지시문 --%>
<!-- page 지시문 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int dan = 1;
	dan = Integer.parseInt(request.getParameter("dan"));
// request변수 선언 안햇는데0 왜 문제가 없을까?
// request는 jsp내장객체이다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		margin: 0; padding: 0; box-sizing: 0;
	}
	.container {
		width: 500px;
		margin: 100px auto;
	}
	table {
		width: 500px;
	}
	table, td {
		border: 1px solid #3455;
	}
	td, th {
		pdding: 4px;
	}
</style>
</head>
<body>
 	<div class="container">
 		<table>
 			<tr>
 				<th>3단</th>
 			</tr>
 			<% 
 			for (int i = 1; i < 10; i++) { 
 			%>
 			<tr>
 				<td><%= dan %> * <%= i %> = <%= dan * i %></td>
 			</tr>
 			<%
 			}
 			%>
 		</table>
 	</div>
</body>
</html>