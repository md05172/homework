<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<form action="${pageContext.request.contextPath }/login.hrd" method="post">
		<div id="login">
		아이디<br>
		<input type="text" name="username"><br>
		비밀번호<br>
		<input type="password" name="password"><br>
		<button>로그인</button>
		</div>
	</form>
</body>
</html>