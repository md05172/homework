<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
<link rel="stylesheet" href="css/write.css">
</head>
<jsp:include page="../header.jsp"/>
<body>
		<div id="write" style="margin-top: 20px">
			<div id="inwrite">
			조회수: <span>${vo.viewcnt }</span><br>
			작성자: <br><input type="text" value="${vo.user.username }(${vo.user.name })"><br>
			제목: <br><input type="text" value="${vo.subject }"><br>
			내용: <br><textarea rows="10">${vo.content }</textarea><br>
			<button><a href="${pageContext.request.contextPath }/list.hrd">목록</a></button>
			<button><a href="${pageContext.request.contextPath }/update.hrd?id=${vo.id}">수정</a></button>
			<button><a href="${pageContext.request.contextPath }/write.hrd">작성</a></button>
			</div>
		</div>
</body>
</html>