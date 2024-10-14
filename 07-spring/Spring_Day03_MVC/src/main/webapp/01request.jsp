<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
		<a href="${pageContext.request.contextPath}/request/test1">TEST1 호출</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath}/request/test2">TEST2 호출</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath}/request/test3">TEST3 호출</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath}/request/test4">TEST4 호출</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath}/request/test5-1">TEST5-1 호출</a>
	</h2>
		<h2>
		<a href="${pageContext.request.contextPath}/request/test5-2">TEST5-2 호출</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath}/request/test6">TEST6 호출</a>
	</h2>
	<h2>
		<form method="post" action="${pageContext.request.contextPath}/request/test7">
		<button>TEST7 호출</button>
		</form>
	</h2>
	<h2>
	<form method="get" action="${pageContext.request.contextPath}/request/test8">
		<button>TEST8 호출</button>
		</form>
	</h2>
	<h2>
	<form method="post" action="${pageContext.request.contextPath}/request/test9">
		<button>TEST9 호출</button>
		</form>
	</h2>
</body>
</html>