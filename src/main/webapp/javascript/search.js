/**
 * 
 */

  var count = document.getElementsByClassName("destination");

  var container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
  // 마커가 표시될 위치입니다
  var markerPosition = new kakao.maps.LatLng(33.450701, 126.570667);

  // 마커를 생성합니다
  var marker = new kakao.maps.Marker({
    position: markerPosition,
  });

  // 마커가 지도 위에 표시되도록 설정합니다
  marker.setMap(map);
  var options = {
    //지도를 생성할 때 필요한 기본 옵션
    center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
    level: 3, //지도의 레벨(확대, 축소 정도)
  };

  var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

  let keyword = document.querySelector("#keyword").value;
  let areacode = document.querySelector(".main-category").value;
  let sigunguCode = document.querySelector(".sub-category").value;
  let contentTypeId = document.querySelector(".type-category").value;

  let areaSelect = document.querySelector(".main-category");
  let subSelect = document.querySelector(".sub-category");
  let typeSelect = document.querySelector(".type-category");

  let destinationBox = document.querySelector(".destinations");
  let detailContentBox = document.querySelector(".detail-content");
  let itemList = [];

  let contentBox = document.querySelector(".destination");

  areaSelect.addEventListener("change", function () {
    console.log("dd");
    requestAreaCode(this.value);
  });

  function getResult() {
    keyword = document.querySelector("#keyword").value;
    areacode = document.querySelector(".main-category").value;
    sigunguCode = document.querySelector(".sub-category").value;
    contentTypeId = document.querySelector(".type-category").value;

    if (keyword == "") {
      console.log("no keyword");
      return;
    }
    requestTourDestination(keyword, areacode, sigunguCode, contentTypeId);
  }
  
  function getAttractionList(){
	keyword = document.querySelector("#keyword").value;
    areacode = document.querySelector(".main-category").value;
    sigunguCode = document.querySelector(".sub-category").value;
    contentTypeId = document.querySelector(".type-category").value;
	console.log("dd");
	console.log(keyword, areacode, sigunguCode, contentTypeId);
	fetch("http://localhost:8080/bridge/attractionInfo?action=list", {
	    method: 'POST', // 요청 메서드를 POST로 설정합니다.
	    headers: {
	        'Content-Type': 'application/json' // 요청 헤더에 JSON 형식의 데이터를 전송한다고 명시합니다.
	    },
	    body: JSON.stringify({ // 요청 본문에 JSON 형식의 데이터를 문자열로 변환하여 전송합니다.
	        sidoCode : areacode,
	        gugunCode : sigunguCode,
	        contentTypeId : contentTypeId,
	        title : keyword
	    })
	})
	.then((res) => res.json())
	.then((data) => {
	    console.log(data);
	    console.log(data[0]);
	    console.log(data[0].addr1);
	})
	.catch((error) => {
	    console.error('Error fetching data:', error);
	});
  }
  
  function bringJson(){
	console.log("dd");
	fetch("http://localhost:8080/bridge/attractionInfo?action=search", {
	    method: 'POST', // 요청 메서드를 POST로 설정합니다.
	    headers: {
	        'Content-Type': 'application/json' // 요청 헤더에 JSON 형식의 데이터를 전송한다고 명시합니다.
	    },
	    body: JSON.stringify({ // 요청 본문에 JSON 형식의 데이터를 문자열로 변환하여 전송합니다.
	        contentId: 125266
	    })
	})
	.then((res) => res.json())
	.then((data) => {
	    console.log(data);
	})
	.catch((error) => {
	    console.error('Error fetching data:', error);
	});
  }

  function requestTourDestination(keyword, areacode, sigunguCode, contentTypeId) {
    console.log(keyword);
    console.log(areacode);
    console.log(contentTypeId);
    fetch(
      "https://apis.data.go.kr/B551011/KorService1/searchKeyword1?MobileOS=ETC&MobileApp=enjoytrip&_type=json" +
        "&keyword=" +
        keyword +
        "&areaCode=" +
        areacode +
        "&sigunguCode=" +
        sigunguCode +
        "&contentTypeId=" +
        contentTypeId +
        "&serviceKey=cC%2Fi2fzAkLUaYPLWZ1Sb2Pr4mHhP9DGSOWdgIIZy%2BhEuPuSikioikDZeOkH12hULZijVPSw7f2r9VOlzTGuzGQ%3D%3D"
    )
      .then((res) => res.json())
      .then((data) => {
        destinationBox.innerHTML = "";
        itemList = [];
        data.response.body.items.item.forEach((item, index) => {
          itemList.push(item);
          let newItem = document.createElement("div");
          newItem.classList.add("destination");

          if (item.firstimage != "") {
            newItem.innerHTML = `
            <h3>`+item.title+`</h3>
            <p>`+item.addr1+`</p>
            <img src=`+item.firstimage+` width=300px>
            `;
          } else if (item.firstimage2 != "") {
            newItem.innerHTML = `
            <h3>`+item.title+`</h3>
            <p>`+item.addr1+`</p>
            <img src=`+item.firstimage2+` width=300px>
            `;
          } else {
        	  newItem.innerHTML = `
              <h3>`+item.title+`</h3>
              <p>`+item.addr1+`</p>
              `;
          }
          // 아이템의 내용을 추가합니다.

          // destination 박스에 아이템을 추가합니다.
          //   newItem.setAttribute("id", `destination-${index}`); // id 설정
          newItem.setAttribute("id", "destination-"+index); // id 설정
          destinationBox.appendChild(newItem);
        });

        let count = itemList.length;
        console.log(count);
        for (var i = 0; i < count; ++i) {
        	console.log("destination-"+i);
          	let a = document.getElementById("destination-"+i);
          	a.addEventListener("click", function () {
            // console.log(a);
            // console.log(a.id);
            let str = a.id.split("-"); // 쉼표를 기준으로 문자열을 분할하여 배열에 저장
            console.log(str[1]);
            console.log(itemList[str[1]]);
            console.log(itemList[str[1]].mapx);
            console.log(itemList[str[1]].mapy);

            detailContentBox.innerHTML = "";
            let newItem = document.createElement("div");
            newItem.classList.add("detail");
            newItem.innerHTML = `
              <h3>`+itemList[str[1]].title+`</h3>
              <p>`+itemList[str[1]].addr1+`</p>
            `;
            newItem.setAttribute("id", "detail-"+str[1].contentid); // id 설정
            detailContentBox.appendChild(newItem);
            // 지도 표기
            options = {
              //지도를 생성할 때 필요한 기본 옵션
              center: new kakao.maps.LatLng(itemList[str[1]].mapy, itemList[str[1]].mapx), //지도의 중심좌표.
              level: 1, //지도의 레벨(확대, 축소 정도)
            };
            map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

            // 마커가 표시될 위치입니다
            markerPosition = new kakao.maps.LatLng(
              itemList[str[1]].mapy,
              itemList[str[1]].mapx
            );

            // 마커를 생성합니다
            marker = new kakao.maps.Marker({
              position: markerPosition,
            });

            // 마커가 지도 위에 표시되도록 설정합니다
            marker.setMap(map);
          });
        }

        console.log(itemList);
      });
  }

  function requestAreaCode(areacode) {
    console.log("count=" + count.length);
    console.log("ddd");

    if (areacode == -1) {
      subSelect.innerHTML = "";
      let option = document.createElement("option");
      option.value = -1;
      option.innerText = "--선택해주세요--";
      subSelect.appendChild(option);
      return;
    }

    fetch(
      "https://apis.data.go.kr/B551011/KorService1/areaCode1?MobileOS=ETC&MobileApp=test&" +
        "areaCode=" +
        areacode +
        "&_type=json" +
        "&serviceKey=cC%2Fi2fzAkLUaYPLWZ1Sb2Pr4mHhP9DGSOWdgIIZy%2BhEuPuSikioikDZeOkH12hULZijVPSw7f2r9VOlzTGuzGQ%3D%3D"
    )
      .then((res) => res.json())
      .then((data) => {
        // select 요소 초기화
        subSelect.innerHTML = "";

        let startoption = document.createElement("option");
        startoption.value = "";
        startoption.innerText = "--전체--";
        subSelect.appendChild(startoption);

        // data 안의 item들을 리스트에 추가
        data.response.body.items.item.forEach((item) => {
          // 각 item의 이름을 option 요소로 만들어서 select 요소에 추가
          let option = document.createElement("option");
          option.value = item.code;
          option.innerText = item.name;
          subSelect.appendChild(option);
        });
      });
  }