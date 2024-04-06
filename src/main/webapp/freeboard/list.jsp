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
	href="${pageContext.request.contextPath}/css/freeboard/list.css" />
<title>게시판</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

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
			<h1>
				게시판
				<h1>
		</nav>
		<div class="link">
			<br> <a
				href="${pageContext.request.contextPath}/freeboard?action=addForm">등록하기</a>
		</div>
		<div>
			<label for="find">작성자</label> 
			<input type="text" id="find" name="find">
			<button id="searchBtn" type="button">검색</button>
		</div>
		<div class="link">
			<a href="${pageContext.request.contextPath}/freeboard?action=list">등록순</a>
			<a href="${pageContext.request.contextPath}/freeboard?action=hitList">조회순</a>
		</div>
		<section>
			<table>
				<thead>
					<tr>
						<th>no</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>작성일자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${boards}">
						<tr>
							<td>${board.no}</td>
							<td><a
								href="${pageContext.request.contextPath}/freeboard?action=detail&no=${board.no}">${board.title}</a></td>
							<td>${board.writer}</td>
							<td>${board.hit}</td>
							<td>${board.writeDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
		${navigation.navigator}
	</main>
	<jsp:include page="/footer.jsp" />
	<script src="${pageContext.request.contextPath}/javascript/list.js"></script>
</body>
</html>