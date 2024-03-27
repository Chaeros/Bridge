<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/member">
		<input hidden="true" name="action" value="modify">
		<div>
			<label for="name">이름</label> <input id="name"
				value="${member.name}">
		</div>
		<div>
			<label for="id">아이디</label> <input id="id"
				value="${member.id}">
		</div>
		<div>
			<label for="region">지역</label> <input id="region"
				value="${member.region}">
		</div>
		<div>
			<label for="email">이메일</label> <input type="email" id="email"
				value="${member.email}">
		</div>
	</form>
</body>
</html>