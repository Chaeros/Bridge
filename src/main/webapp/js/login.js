let signup_btn = document.getElementById("signup_btn");

signup_btn.addEventListener('click', function() {
	console.log("ok");
	window.location.href = "/bridge/member/signup.jsp";
});

document.addEventListener('DOMContentLoaded', function() {
    // 로그인 버튼 클릭 시
    document.getElementById('login_btn').addEventListener('click', function() {
        // 아이디와 비밀번호 값 가져오기
        var id = document.getElementById('id').value;
        var password = document.getElementById('password').value;

		if ( id == "" ){
			alert("아이디를 입력해주세요!");
			return;
		}
		if ( password == ""){
			alert("비밀번호를 입력해주세요!");
			return;
		}
		
        // 로그인 처리를 위해 폼 전송
        var form = document.getElementById('loginForm');
        form.submit(); // 또는 다른 로그인 처리 코드를 작성
    });
});