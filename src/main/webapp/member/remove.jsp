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
			for="password">��й�ȣ </label> 
			<input id="password" name="password">
			<div>
				<button type="submit">Ż���ϱ�</button>
			</div>
	</form>
</body>
</html>