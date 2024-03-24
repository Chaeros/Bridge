<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
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
		<h2>게시글 등록</h2>
	</nav>

	<form id="addForm" method="post" action="${pageContext.request.contextPath}/freeboard">
		<input type="hidden" name="action" value="add">
		<div class="form-group">
			<label for="title">제목</label> <input type="text"
				id="title" name="title" placeholder="제목 입력">
		</div>
		<div class="form-group">
			<label for="writer">작성자</label> <input type="text" id="writer"
				name="writer">
		</div>
		<div class="form-group">
			<label for="content">내용</label> 
			<textarea class="form-control" id="content" name="content" rows="7"></textarea>
		</div>
		
		<button type="submit" id="regist">등록</button>
		<a href="${pageContext.request.contextPath}/boardindex.jsp"}>취소</a>
	</form>
	<jsp:include page="/footer.jsp"/>
</body>
</html>