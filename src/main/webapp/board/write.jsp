<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성</title>
<link rel="stylesheet" href="css/write.css">
</head>
<jsp:include page="../header.jsp"/>
<body>
	<form action="write.hrd" method="post">
		<div id="write" style="margin-top: 20px">
			<div id="inwrite">
			<input type="hidden" name="id" value="${sessionScope.saveid.id }">
			작성자: <br><input type="text" value="${sessionScope.saveid.username }(${sessionScope.saveid.name })"><br>
			제목: <br><input type="text" name="subject"><br>
			내용: <br><textarea rows="10" name="content"></textarea><br>
			<button><a href="${pageContext.request.contextPath }/list.hrd">목록</a></button>
			<button>작성완료</button>
			</div>
		</div>
	</form>
</body>
</html>