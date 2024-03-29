<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common/header.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/common/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/member/mypage.css" />
</head>

<body>
	<jsp:include page="../header.jsp" />
	<main>
		<section class="title">
			<h3>마이페이지</h3>
		</section>
		<div class="profile">
			<div class="profile_img">
				<img id="preview" src="${pageContext.request.contextPath}/img/profile-img.jpg" alt="profile-img">
				<input type="file" accept="image/*" onchange="readURL(this);">
			</div>
			<div class="p_component">
				<div class="profile_input" id="profile_input">
					<div>
						<label for="id">아이디</label>
						<p id="id">${member.id}</p>
					</div>
					<div>
						<label for="name">이름</label>
						<p id="name">${member.name}</p>
					</div>
					<div>
						<label for="nickName">닉네임</label>
						<p id="nickName">${member.nickName}</p>
					</div>
					<div>
						<label for="region">지역</label>
						<p id="region">${member.region}</p>
					</div>
					<div>
						<label for="email">이메일</label>
						<p id="email">${member.name}</p>
					</div>
				</div>

				<div class="input_button">

					<button id="fix">수정</button>
					<button id="drawal">회원 탈퇴하기</button>
				</div>
			</div>


		</div>
	</main>
		<jsp:include page="../footer.jsp" />
	<script src="${pageContext.request.contextPath}/js/mypage.js"
		type="text/javascript"></script>
</body>

</html>