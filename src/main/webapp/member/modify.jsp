<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
			<label for="name">�̸�</label> <input id="name"
				value="${member.name}">
		</div>
		<div>
			<label for="id">���̵�</label> <input id="id"
				value="${member.id}">
		</div>
		<div>
			<label for="region">����</label> <input id="region"
				value="${member.region}">
		</div>
		<div>
			<label for="email">�̸���</label> <input type="email" id="email"
				value="${member.email}">
		</div>
	</form>
</body>
</html>