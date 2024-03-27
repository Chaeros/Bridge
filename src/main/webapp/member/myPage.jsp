<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link rel="stylesheet" href="../css/header.css" />
<link rel="stylesheet" href="../css/footer.css" />
<link rel="stylesheet" href="../css/mypage.css" />
</head>

<body>
	<header class="header">
		<div class="header-content">
			<h1 class="title">Bridge</h1>
			<div class="nav">
				<a>������ ã��</a> <a>�� ����</a> <a>�α׾ƿ�</a>
			</div>
		</div>
	</header>

	<main>
		<section class="title">
			<h3>����������</h3>
		</section>
		<div class="profile">
			<div class="profile_img">
				<img id="preview" src="../img/profile-img.jpg" alt="profile-img">
				<input type="file" accept="image/*" onchange="readURL(this);">
			</div>
			<div class="p_component">
				<div class="profile_input" id="profile_input">
					<div>
						<label for="name">�̸�</label>
						<p id="name">${member.name}</p>
					</div>
					<div>
						<label for="id">���̵�</label>
						<p id="id">${member.id}</p>
					</div>
					<div>
						<label for="region">����</label>
						<p id="region">${member.region}</p>
					</div>
					<div>
						<label for="email">�̸���</label>
						<p id="email">${member.name}</p>
					</div>
				</div>

				<div class="input_button">

					<button id="fix">����</button>
					<button id="drawal">ȸ�� Ż���ϱ�</button>
				</div>
			</div>


		</div>
	</main>
	<footer class="footer"></footer>
	<script src="../js/mypage.js" type="text/javascript"></script>
</body>

</html>