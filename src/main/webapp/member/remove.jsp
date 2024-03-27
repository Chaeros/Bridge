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
		<input hidden="ture" name="action" value="remove"> <label
			for="password">비밀번호 </label> 
			<input id="password" name="password" required>
			<div>
				<button type="submit">탈퇴하기</button>
			</div>
	</form>
</body>
</html>