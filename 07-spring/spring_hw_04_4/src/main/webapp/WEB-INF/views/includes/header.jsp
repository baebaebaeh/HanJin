<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header">
	<div class="child">
		<button onclick="location.href='${pageContext.request.contextPath}/'">
			<img
				src="${pageContext.request.contextPath}/resources/img/ssafy_logo.png"
				width="150" />
		</button>
	</div>
	<div class="child">
		<h1 id="title">샤핑몰</h1>
	</div>
	<!-- 코드작성 -->
	<div class="child">
		<c:if test="${sessionScope.loginUser==null}">
			<form action="${pageContext.request.contextPath}/user/login"
				method="POST">
				<input type="text" name="userId" placeholder="아이디"> <input
					type="text" name="userPass" placeholder="비밀번호">
				<button>로그인</button>
			</form>
		</c:if>
		<c:if test="${sessionScope.loginUser!=null}">
			<a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>
		</c:if>
	</div>
</div>