<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
</head>
<body>
	<a href="/imgs/${fileName}">${fileName}</a>
	<img src="/imgs/${fileName}">
	
	<a href="/download?fileName=${fileName}">이미지다운로드</a>
	
</body>
</html>