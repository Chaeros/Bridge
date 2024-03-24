<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bridge main</title>
<style>
nav {
	display : flex;
	justify-content : space-between;
	align-items : center
}
nav a {
	margin-right: 10px
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<nav>
		<h1>메인 페이지 입니다.</h1>
	</nav>
	<a href="${pageContext.request.contextPath}/freeboard?action=addForm">게시물 등록 페이지</a>
	<a href="${pageContext.request.contextPath}/freeboard?action=list">게시물 목록 페이지</a>
	<br>
	<br>
	<jsp:include page="footer.jsp"/>
</body>
</html>