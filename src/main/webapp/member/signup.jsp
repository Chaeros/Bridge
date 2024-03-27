<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="../css/header.css" />
<link rel="stylesheet" href="../css/footer.css" />
<link rel="stylesheet" href="../css/signup.css" />
<title>Document</title>
</head>

<body>
	<main>
		<div class="all-form">
			<div class="logo">Bridge</div>
			<div class="title">ȸ������</div>
			<form method="post" action="${pageContext.request.contextPath}/member">
				<div class="input-form">
					<input type="hidden" name="action" value="add">
					<div class="input-form-content">
						<label for="name">�̸�</label> <input type="text" id="name"
							name="name" />
					</div>
					<div class="input-form-content">
						<label for="userid">���̵�</label> <input type="text" id="userId"
							name="id" />
					</div>
					<div class="input-form-content">
						<label for="nickName">�г���</label> <input type="text" id="nickName"
							name="nickName" />
					</div>
					<div class="input-form-content">
						<label for="userpwd">��й�ȣ</label> <input type="text" id="userpwd"
							name="password" />
					</div>
					<div class="input-form-content">
						<label for="userpwd-confirm">��й�ȣ Ȯ��</label> <input type="text"
							id="userpwd-confirm" />
					</div>
					<div class="input-form-content">
						<label for="email">�̸���</label> <input type="text" id="email"
							name="email" />
					</div>
					<div class="input-form-content">
						<label for="region">����</label> <input type="text" id="region"
							name="region" />
					</div>
				</div>
				<div>
					<button id="signup_btn" class="submit" type="submit">�����ϱ�</button>
				</div>
			</form>
		</div>
	</main>
	<script src="./js/signup.js" type="text/javascript"></script>

</body>

</html>