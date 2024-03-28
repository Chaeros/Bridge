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
	href="${pageContext.request.contextPath}/css/freeboard/modify.css" />
<title>게시글 수정</title>
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
			<h2>게시글 수정</h2>
		</nav>

		<form id="editForm" method="post"
			action="${pageContext.request.contextPath}/freeboard">
			<input type="hidden" name="action" value="modify"> <input
				type="hidden" name="no" value="${board.no}">
			<div class="form-group">
				<label for="title">제목</label> <input type="text" id="title"
					name="title" value="${board.title}">
			</div>
			<div class="form-group">
				<label for="writer">작성자</label> <input type="text" id="writer"
					name="writer" value="${board.writer}" readonly>
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control" id="content" name="content" rows="7">${board.content}</textarea>
			</div>

			<div class="form-btn">
				<button type="submit" id="regist">수정</button>
				<a href="${pageContext.request.contextPath}/boardindex.jsp"}>취소</a>
			</div>
		</form>
	</main>
	<jsp:include page="/footer.jsp" />
</body>
</html>