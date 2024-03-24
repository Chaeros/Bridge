<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세</title>
<style>
nav {
	display: flex;
	justify-content: space-between;
	align-items: center
}

nav a {
	margin-right: 10px
}
</style>
</head>
<body>
	<jsp:include page="/header.jsp"/>
	<nav>
		<h2>게시판 상세 정보</h2>
	</nav>
	<h2>${board.title}</h2>
	<div>${board.writer}</div>
	<div>${board.content}</div>
	<br>
	<a href="${pageContext.request.contextPath}/boardindex.jsp">메인 페이지</a>
	<br>
	<a href="${pageContext.request.contextPath}/freeboard?action=remove&no=${board.no}">삭제하기</a>
	<a href="${pageContext.request.contextPath}/freeboard?action=modifyForm&no=${board.no}">수정하기</a>
	<jsp:include page="/footer.jsp"/>
</body>
</html>