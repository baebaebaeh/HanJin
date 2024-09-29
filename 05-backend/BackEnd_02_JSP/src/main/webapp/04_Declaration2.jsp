<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%!
	String D = "DDD";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<c:set var="A" value="AAA" />
	<c:set var="B">BBB</c:set>
	<c:set var="C" value="" />
	${A}<br>
	${B}<br>
	${C}<br>
	${D}<br>
	${empty C}<br>
	${empty D}<br>
</body>
</html>







