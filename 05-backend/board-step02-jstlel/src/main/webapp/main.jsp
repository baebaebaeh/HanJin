<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%-- 
pageContext.setAttribute("a1", "b1");
request.setAttribute("a2", "b2");
session.setAttribute("a3", "b3");
application.setAttribute("a4", "b4");

<c:set var="a1" value="b1" scope="pageContext" />
<c:set var="a2" value="b2" scope="request" />
<c:set var="a3" value="b3" scope="session" />
<c:set var="a4" value="b4" scope="application" />
<c:set >
 --%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="page" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
</head>
<body>
	<header>
		<nav>
			<ul>
			<c:choose>
				<c:when test="${ empty sessionScope.memberInfo }">
					<li><a href="${contextPath}/member?action=loginForm">로그인</a></li>
					<li><a href="${contextPath}/member?action=joinForm">회원가입</a></li>				
				</c:when>
				<c:otherwise>
					<li><a href="">마이페이지</a></li>
					<li><a href="${contextPath}/member?action=logout">로그아웃</a></li>				
				</c:otherwise>
			</c:choose>
			</ul>
		</nav>
	</header>

	<h2>대전 4반 - 메인 페이지</h2>
	<div>
		<a href="${contextPath}/board?action=list">게시판 이동</a>
		
		
		
	</div>
</body>
</html>





