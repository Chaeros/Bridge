<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="../css/member/login.css" />
<title>Document</title>
</head>

<body>
<body class="body">
	<img class="left-content" src="${pageContext.request.contextPath}/img/mainImage.jpg" alt="" />
	<div class="right-content">
		<div class="input-content">
			<div class="title">Bridge</div>
			<form method="post"
				action="${pageContext.request.contextPath}/member">
				<input hidden="true" name="action" value="login">
				<div class="id">
					<label for="id">아이디</label> <input id="id" name="id" type="text"
						required />
				</div>
				<div class="pass">
					<label for="pass">비밀번호</label> <input type="password" id="pass"
						name="password" type="text" required />
				</div>
				<div>
					<button id="login_btn" type="submit">로그인</button>
				</div>
			</form>
			<button id="signup_btn" type="button">회원가입</button>
		</div>
	</div>
	<script src="../js/login.js" type="text/javascript"></script>
</body>

</body>

</html>