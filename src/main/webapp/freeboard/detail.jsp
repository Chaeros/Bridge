<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common/header.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/freeboard/detail.css" />
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
	<jsp:include page="/header.jsp" />
	<main>
		<nav>
			<h2>게시판 상세 정보</h2>
		</nav>
		<div class="board">
			<div class="title">
				<h2>${board.title}</h2>
			</div>
			<div class="wirter">${board.writer}</div>
			<div class="content">${board.content}</div>
		</div>
		<div class="link">
			<br> <a href="${pageContext.request.contextPath}/freeboard?action=list">게시판 목록</a> <br>
			<c:choose>
				<c:when test="${board.writer eq member.id}">
					<a href="${pageContext.request.contextPath}/freeboard?action=remove&no=${board.no}">삭제하기</a>
					<a href="${pageContext.request.contextPath}/freeboard?action=modifyForm&no=${board.no}">수정하기</a>
				</c:when>
			</c:choose>
		</div>
	</main>
	<jsp:include page="/footer.jsp" />
</body>
</html>