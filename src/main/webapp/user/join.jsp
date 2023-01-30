<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="css/join.css">
</head>
<body>
	<form action="join.hrd" method="post">
		<div id="join">
		아이디<div id="checkId" style="color: red">${useid.error }</div>
		<input type="text" name="username" value="${useid.username }"><br>
		비밀번호<br>
		<input type="password" name="password"><br>
		비밀번호확인<br>
		<input type="password" name="re_password"><br>
		이름<br>
		<input type="text" name="name" value="${useid.name }"><br>
		<button>가입완료</button>
		</div>
	</form>
</body>
</html>