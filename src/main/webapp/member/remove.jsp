<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common/header.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common/footer.css" />
</head>
<body>
	<jsp:include page="../header.jsp" />
	<form method="post" action="${pageContext.request.contextPath}/member">
		<input hidden="ture" name="action" value="remove"> <label
			for="password">비밀번호 </label> 
			<input id="password" name="password" required>
			<div>
				<button type="submit">탈퇴하기</button>
			</div>
	</form>
		<jsp:include page="../footer.jsp" />
</body>
</html>