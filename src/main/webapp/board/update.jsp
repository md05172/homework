<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
<link rel="stylesheet" href="css/write.css">
</head>
<jsp:include page="../header.jsp"/>
<body>
	<form action="">
		<div id="write" style="margin-top: 20px">
			<div id="inwrite">
			작성자: <br><input><br>
			제목: <br><input><br>
			내용: <br><textarea rows="10"></textarea><br>
			<button><a href="#">목록</a></button>
			<button><a href="#">수정완료</a></button>
			</div>
		</div>
	</form>
</body>
</html>