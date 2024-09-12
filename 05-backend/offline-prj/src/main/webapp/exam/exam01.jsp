<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>jsp 연습하기</h2>
	<!-- 컨텐츠 주석문 -> 브라우저가 주석처리한다 -->
	<%-- JSP주석문 -> .jsp가 .java로 바뀔때 이 주석은 포함시키지 않는다. --%>
	<%! %> <%-- 선언문 : 멤버변수 또는 메서드를 선언시 사용, 거의 사용되지 않는다. --%>
	<%@ %> <%-- 지시문 : page, incloude, taglib --%>
	<%= %> <%-- 표현식 : 출력시 사용, out.print --%>
	<% %>  <%-- 실행문 : 기존 자바코드를 작성 --%>
</body>
</html>