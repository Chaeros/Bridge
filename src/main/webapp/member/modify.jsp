<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common/header.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/member/modify.css" />
</head>
<body>
	<jsp:include page="../header.jsp" />
	<main>
		<section class="title">
			<h3>마이페이지</h3>
		</section>
		<div class="profile">
			<form method="post"
				action="${pageContext.request.contextPath}/member">
				<input hidden="true" name="action" value="modify">
				<div class="profile_input">
					<label for="id">아이디</label> <input id="id" value="${member.id}"
						readonly>
				</div>
				<div class="profile_input">
					<label for="name">이름</label> <input id="name"
						value="${member.name}" name="name" required>
				</div>
				<div class="profile_input">
					<label for="nickName">닉네임</label> <input id="nickName"
						value="${member.nickName}" name="nickName" required>
				</div>
				<div class="profile_input">
					<label for="region">지역</label> <input id="region"
						value="${member.region}" name="region" required>
				</div>
				<div class="profile_input">
					<label for="email">이메일</label> <input type="email" id="email"
						value="${member.email}" name="email" required>
				</div>
				<div class="profile_input">
					<label for="password">비밀번호 확인</label> <input type="password"
						id="password" name="password" required>
				</div>
				<div class="input_button">
				<button type="submit">수정</button>
				</div>
			</form>
		</div>
	</main>
	<jsp:include page="../footer.jsp" />
</body>
</html>