/**
 * 
 */function getMyBookMarkList() {
	console.log("testFetch");
	fetch(serverIp+"/bridge/bookmark?action=list", {
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
			destinationBox.innerHTML = "";
			itemList = [];
			positions = [];
			data.forEach((item, index) => {
				console.log(item);
				itemList.push(item);
				let newItem = document.createElement("div");
				newItem.classList.add("destination");

				console.log(item.firstImage);
				console.log(item.myAttractionId);
				if (item.firstImage != "") {
					newItem.innerHTML = `
   		            <h3>`+ item.title + `<button onclick="removeBookMark(` + item.myAttractionId + `)">X</button></h3>
   		            <p>`+ item.addr1 + `</p>
   		            <img src=`+ item.firstImage + ` style="width:300px; height:200px">
   		            `;
				} else if (item.firstImage2 != "") {
					newItem.innerHTML = `
   		            <h3>`+ item.title + `<button onclick="removeBookMark(` + item.myAttractionId + `)">X</button></h3>
   		            <p>`+ item.addr1 + `</p>
   		            <img src=`+ item.firstImage2 + ` style="width:300px; height:200px">
   		            `;
				} else {
					newItem.innerHTML = `
   		              <h3>`+ item.title + `<button onclick="removeBookMark(` + item.myAttractionId + `)">X</button></h3>
   		              <p>`+ item.addr1 + `</p>
   		              `;
				}

				// destination 박스에 아이템을 추가합니다.
				//   newItem.setAttribute("id", `destination-${index}`); // id 설정
				newItem.setAttribute("id", "destination-" + index); // id 설정
				destinationBox.appendChild(newItem);

				options = {
					//지도를 생성할 때 필요한 기본 옵션
					center: new kakao.maps.LatLng(item.latitude, item.longitude), //지도의 중심좌표.
					level: 6, //지도의 레벨(확대, 축소 정도)
				};
				map = new kakao.maps.Map(container, options);

				positions.push({
					title: item.title,
					addr: item.addr1,
					description: item.description,
					latlng: new kakao.maps.LatLng(item.latitude, item.longitude),
					latitude: item.latitude,
					longitude: item.longitude
				});

				for (var i = 0; i < positions.length; i++) {

					/*// 마커 이미지의 이미지 크기 입니다
					var imageSize = new kakao.maps.Size(24, 35); 
				    
					// 마커 이미지를 생성합니다    
					var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); */

					// 마커를 생성합니다
					var marker = new kakao.maps.Marker({
						map: map, // 마커를 표시할 지도
						position: positions[i].latlng, // 마커를 표시할 위치
						title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
						//image : markerImage // 마커 이미지 
					});

					var infowindow = new kakao.maps.InfoWindow({
						content: "<div><h3>" + positions[i].title + "</h3></div><p>" + positions[i].addr + "</p>"
					});

					kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
					kakao.maps.event.addListener(marker, 'click', (function(marker, i) {
						return function() {
							console.log("Marker clicked");
							console.log("Marker title: " + positions[i].title);
							console.log("Marker address: " + positions[i].addr);
							console.log("Marker description: " + positions[i].description);
							// 여기에 클릭된 마커의 정보를 사용하는 코드를 추가할 수 있습니다.
							// 예를 들어, 해당 마커의 정보를 화면에 표시하거나 다른 동작을 수행할 수 있습니다.
							detailContentBox.innerHTML = "";
							let newItem = document.createElement("div");
							newItem.classList.add("detail");
							newItem.innerHTML = `
   					              <h3>` + positions[i].title + `</h3>
   					              <p>` + positions[i].addr + `</p>
   					              <br>
   					              <p>` + positions[i].description + `</p>
   					            `;
							detailContentBox.appendChild(newItem);
							// 클릭된 마커를 현재 클릭된 마커 객체로 설정합니다
							selectedMarker = marker;

							options = {
								//지도를 생성할 때 필요한 기본 옵션
								center: new kakao.maps.LatLng(positions[i].latitude, positions[i].longitude), //지도의 중심좌표.
								level: 1, //지도의 레벨(확대, 축소 정도)
							};
							map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

							// 마커가 표시될 위치입니다
							markerPosition = new kakao.maps.LatLng(
								positions[i].latitude,
								positions[i].longitude
							);

							// 마커를 생성합니다
							marker = new kakao.maps.Marker({
								position: markerPosition,
							});

							// 마커가 지도 위에 표시되도록 설정합니다
							marker.setMap(map);
						};
					})(marker, i));
					kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));


				}

			});

			detailContentBox.innerHTML = "";
			let detailItem = document.createElement("div");
			detailItem.classList.add("detail");
			detailItem.innerHTML = `
   		          <p> 검색 결과 총 `+ data.length + `건의 결과가 조회되었습니다. </p>
   		        `;
			detailContentBox.appendChild(detailItem);

			let count = itemList.length;
			console.log(count);
			for (var i = 0; i < count; ++i) {
				console.log("destination-" + i);
				let a = document.getElementById("destination-" + i);
				a.addEventListener("click", function() {
					// console.log(a);
					// console.log(a.id);
					let str = a.id.split("-"); // 쉼표를 기준으로 문자열을 분할하여 배열에 저장
					console.log(str[1]);
					console.log(itemList[str[1]]);
					console.log(itemList[str[1]].latitude);
					console.log(itemList[str[1]].longitude);

					detailContentBox.innerHTML = "";
					let newItem = document.createElement("div");
					newItem.classList.add("detail");
					newItem.innerHTML = `
   		              <h3>`+ itemList[str[1]].title + `</h3>
   		              <p>`+ itemList[str[1]].addr1 + `</p>
   		              <br>
   		              <p>`+ itemList[str[1]].description + `</p>
   		            `;
					newItem.setAttribute("id", "detail-" + str[1].contentid); // id 설정
					detailContentBox.appendChild(newItem);
					// 지도 표기
					options = {
						//지도를 생성할 때 필요한 기본 옵션
						center: new kakao.maps.LatLng(itemList[str[1]].latitude, itemList[str[1]].longitude), //지도의 중심좌표.
						level: 1, //지도의 레벨(확대, 축소 정도)
					};
					map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

					// 마커가 표시될 위치입니다
					markerPosition = new kakao.maps.LatLng(
						itemList[str[1]].latitude,
						itemList[str[1]].longitude
					);

					// 마커를 생성합니다
					marker = new kakao.maps.Marker({
						position: markerPosition,
					});

					var infowindow = new kakao.maps.InfoWindow({
						content: "<div><h3>" + itemList[str[1]].title + "</h3></div><p>" + itemList[str[1]].addr1 + "</p>"
					});

					kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
					kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));

					// 마커가 지도 위에 표시되도록 설정합니다
					marker.setMap(map);
				});
			}

		})
		.catch((error) => {
			console.error('Error fetching data:', error);
		});
}