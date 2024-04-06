
document.getElementById("searchBtn").onclick = function() {

	let find = document.getElementById("find").value;
	if(find){
		let url = "/bridge/freeboard?action=searchList&find=" + `${find}`;
		window.location.href = url;
	}
};