<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mypage.css" />
</head>

<body>
	<header class="header">
		<div class="header-content">
			<h1 class="title">Bridge</h1>
			<div class="nav">
				<a>관광지 찾기</a> <a>내 정보</a> <a>로그아웃</a>
			</div>
		</div>
	</header>

	<main>
		<section class="title">
			<h3>마이페이지</h3>
		</section>
		<div class="profile">
			<div class="profile_img">
				<img id="preview" src="../img/profile-img.jpg" alt="profile-img">
				<input type="file" accept="image/*" onchange="readURL(this);">
			</div>
			<div class="p_component">
				<div class="profile_input" id="profile_input">
					<div>
						<label for="name">이름</label>
						<p id="name">${member.name}</p>
					</div>
					<div>
						<label for="id">아이디</label>
						<p id="id">${member.id}</p>
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
	<footer class="footer"></footer>
	<script src="${pageContext.request.contextPath}/js/mypage.js" type="text/javascript"></script>
</body>

</html>