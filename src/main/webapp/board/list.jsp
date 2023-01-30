<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글목록</h3>
	<table>
		<tr>
			<th>#</th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
            <th>작성일</th>
		</tr>
		<c:forEach items="${list }" var="vo">
			<tr>
				<td>${vo.id }</td>
				<td><a href="detail.hrd?id=${vo.id }">${vo.subject }</a></td>
				<td>${vo.user.name }</td>
				<td>${vo.viewcnt }</td>
				<td>${vo.regdate }</td>
			</tr>
		</c:forEach>
		<a href="write.hrd">작성</a>
	</table>


</body>
</html>