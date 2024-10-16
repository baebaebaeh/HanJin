<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<style>
header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 10px 0;
}
</style>
<header>
	<c:if test="${sessionScope.loginUser==null}">
		<form action="${pageContext.request.contextPath}/user/login"
			method="POST">
			<input type="text" name="id" placeholder="아이디"> <input
				type="text" name="pw" placeholder="비밀번호">
			<button>로그인</button>
		</form>
	</c:if>
	<c:if test="${sessionScope.loginUser!=null}">
		<a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>
	</c:if>
</header>
<hr />
<script>
		if(${msg}){
			alert("로그인에 실패했습니다");
		}
</script>