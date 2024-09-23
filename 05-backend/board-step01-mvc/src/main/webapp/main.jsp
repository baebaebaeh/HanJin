<%@page import="com.ssafy.exam.Member"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%
	// 					session.setAttribute("memberInfo", member);
	Member memberInfo = (Member)session.getAttribute("memberInfo");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
</head>
<body>
	<header>
		<nav>
			<ul>
			<%
			if (memberInfo == null) {
			%>
				<li><a href="<%= request.getContextPath() %>/member?action=loginForm">로그인</a></li>
				<li><a href="<%= request.getContextPath() %>/member?action=joinForm">회원가입</a></li>
			
			<%
			} else {
			%>
				<li><a href="">마이페이지</a></li>
				<li><a href="<%= request.getContextPath() %>/member?action=logout">로그아웃</a></li>
			<%
			}
			%>
			</ul>
		</nav>
	</header>

	<h2>대전 4반 - 메인 페이지</h2>
	<div>
		<a href="<%= request.getContextPath() %>/board?action=list">게시판 이동</a>
		
		
		
	</div>
</body>
</html>






