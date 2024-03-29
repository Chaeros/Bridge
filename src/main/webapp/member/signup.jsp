<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/member/signup.css" />
<title>Document</title>
</head>

<body>
	<main>
		<div class="all-form">
			<div class="logo" id="logo">Bridge</div>
			<div class="title">회원가입</div>
			<form method="post"
				action="${pageContext.request.contextPath}/member">
				<div class="input-form">
					<input type="hidden" name="action" value="add">
					<div class="input-form-content">
						<label for="name">이름</label> <input type="text" id="name"
							name="name" required />
					</div>
					<div class="input-form-content">
						<label for="userid">아이디</label> <input type="text" id="userId"
							name="id" required />
					</div>
					<div class="input-form-content">
						<label for="nickName">닉네임</label> <input type="text" id="nickName"
							name="nickName" required />
					</div>
					<div class="input-form-content">
						<label for="userpwd">비밀번호</label> <input type="password"
							id="userpwd" name="password" required />
					</div>
					<div class="input-form-content">
						<label for="userpwd-confirm">비밀번호 확인</label> <input
							type="password" id="userpwd-confirm" required />
					</div>
					<div class="input-form-content">
						<label for="email">이메일</label> <input type="email" id="email"
							name="email" required />
					</div>
					<div class="input-form-content">
						<label for="region">지역</label> <input type="text" id="region"
							name="region" required />
					</div>
				</div>
				<div>
					<button id="signup_btn" class="submit" type="submit">가입하기</button>
				</div>
			</form>
		</div>
	</main>
	<script src="${pageContext.request.contextPath}/javascript/signup.js" type="text/javascript"></script>

</body>

</html>