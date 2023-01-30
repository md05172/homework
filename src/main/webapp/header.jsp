<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/header.css">
</head>
<body>
	<div id="menu">
		<ul>
			<li><a href="#">HOME</a></li>
			<li><a href="#">누구나</a></li>
			<li><a href="#">멤버</a></li>
			<li><a href="#">어드민</a></li>
		</ul>
		<c:choose>
			<c:when test="${empty sessionScope.saveid }">
				<button>
					<a href="${pageContext.request.contextPath}/login.hrd"
						style="color: black">Login</a>
				</button>
			</c:when>
			<c:otherwise>
				<div id="id">
					<form action="${pageContext.request.contextPath}/logout.hrd"
						method="POST">
						<!--TODO : 로그아웃후 다시 돌아오기 -->
						<span> <span><span>${sessionScope.saveid.username }(${sessionScope.saveid.name })</span>
								님 환영합니다</span> <span><button type="submit">Logout</button></span>
						</span>
					</form>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>