<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/common/frame.css" />
    <link rel="stylesheet" href="../css/attraction/search.css" />
    <title>Document</title>
  </head>
  <body>
    <header class="header">
      <div class="header-position">
        <div class="header-content">
          <h1 class="title">Bridge</h1>
          <div class="nav">
            <a>관광지 찾기</a>
            <a>내 정보</a>
            <a>로그아웃</a>
          </div>
        </div>
      </div>
    </header>

    <div class="wrap">
      <div class="all-content">
        <div class="left-content">
          <div class="subtitle">지역별 관광 정보<button onclick="test()">★</button></div>
          <div class="selectinfo">
            <div>
              <div class="selectinfo-title">지역</div>
              <select class="main-category">
                <option value="">--전체--</option>
                <option value="1">서울</option>
                <option value="2">인천</option>
                <option value="3">대전</option>
                <option value="4">대구</option>
                <option value="5">광주</option>
                <option value="6">부산</option>
                <option value="7">울산</option>
                <option value="8">세종</option>
                <option value="31">경기</option>
                <option value="32">강원</option>
                <option value="33">충북</option>
                <option value="34">충남</option>
                <option value="35">경북</option>
                <option value="36">경남</option>
                <option value="37">전북</option>
                <option value="38">전남</option>
                <option value="39">제주</option>
              </select>
            </div>
            <div>
              <div class="selectinfo-title">시/군/구</div>
              <select class="sub-category">
                <option value="">--전체--</option>
              </select>
            </div>
            <!-- 관광타입(12:관광지, 14:문화시설, 15:축제공연행사, 25:여행코스, 28:레포츠, 32:숙박, 38:쇼핑, 39:음식점) ID -->
            <div>
             <div class="selectinfo-title">분류</div>
              <select class="type-category">
                <option value="">--전체--</option>
                <option value="12">관광지</option>
                <option value="14">문화시설</option>
                <option value="15">축제공연행사</option>
                <option value="25">여행코스</option>
                <option value="28">레포츠</option>
                <option value="32">숙박</option>
                <option value="38">쇼핑</option>
                <option value="39">음식점</option>
              </select>
            </div>
            <div>
              <div class="selectinfo-title">키워드</div>
              <input id="keyword" type="text" />
            </div>
            <button id="submitbtn" onclick="getAttractionList()">검색</button>
          </div>
          <div class="destinations"></div>
        </div>
        <div class="right-content">
          <div class="map" id="map" style="width: 100%; height: 500px"></div>
          <div class="detail-content"></div>
        </div>
      </div>
    </div>

    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=40760ed76b3f09175bb64a80868ef451"
    ></script>
    
    <script>
    	function test(){
   			console.log("testFetch");
   			fetch("http://localhost:8080/bridge/bookmark?action=add", {
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
    </script>

    <script src="../javascript/search.js"></script>
    <footer class="footer"></footer>
  </body>
</html>
