<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

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
	<jsp:include page="/header.jsp"/>
	<nav>
		<h1>상품 목록 페이지</h1>
	</nav>
	<a href="${pageContext.request.contextPath}/boardindex.jsp">메인 페이지</a>
	<br>
	<a href="${pageContext.request.contextPath}/freeboard?action=addForm">등록하기</a>
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
					<td><a href="${pageContext.request.contextPath}/freeboard?action=detail&no=${board.no}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.hit}</td>
					<td>${board.writeDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<jsp:include page="/footer.jsp"/>
</body>
</html>