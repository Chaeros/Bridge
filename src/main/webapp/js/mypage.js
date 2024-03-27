
/*let correction_btn = document.getElementById("correction");*/

/*correction_btn.addEventListener('click', function() {
	let name = document.getElementById("name").value;
	let id = document.getElementById("id").value;
	let region = document.getElementById("region").value;
	let email = document.getElementById("email").value;

	localStorage.setItem("name", name);
	localStorage.setItem("id", id);
	localStorage.setItem("email", email);
	localStorage.setItem("region", region);

	console.log("name: " + localStorage.getItem("name") +
		" id: " + localStorage.getItem("id") +
		"email: " + localStorage.getItem("email") +
		"region: " + localStorage.getItem("region"));

	let html = `<div>
	<label for="name">이름</label>
	<input id="name" value="${localStorage.getItem("name")}" readonly>
</div>
<div>
	<label for="id">아이디</label>
	<input id="id" value="${localStorage.getItem("id")}" readonly>
</div>
<div>
	<label for="region">지역</label>
	<input id="region" value="${localStorage.getItem("region")}" readonly>
</div>
<div>
	<label for="email">이메일</label>
	<input type ="email" id="email" value="${localStorage.getItem("email")}" readonly>
</div>`

	let profile_detail = document.getElementById("profile_input");
	profile_detail.innerHTML = html;
});*/

function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			document.getElementById('preview').src = e.target.result;
		};
		reader.readAsDataURL(input.files[0]);
	} else {
		document.getElementById('preview').src = "";
	}
}

let fix_btn = document.getElementById("fix");

fix_btn.addEventListener('click', function() {
	console.log("수정 버튼")
	window.location.href = "/bridge/member?action=modify"
});

let drawal = document.getElementById("drawal");

drawal.addEventListener('click', function() {

	window.location.href = "/bridge/member?action=removeForm";
})