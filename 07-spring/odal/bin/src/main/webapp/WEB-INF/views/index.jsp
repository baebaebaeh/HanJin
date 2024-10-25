<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=[CLIENT_ID]"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h2>메인페이지</h2>
	<a href="${pageContext.request.contextPath}/gps">gps 이동</a>
	<div id="map" style="width: 100%; height: 1600px;"></div>
	<script>
		var position = new naver.maps.LatLng(37.3595704, 127.105399);

		var map = new naver.maps.Map('map', {
			center : position,
			zoom : 15
		});

		var marker = new naver.maps.Marker({
			position : position,
			map : map
		});

		naver.maps.Event.addListener(map, 'click', function(e) {
			marker.setPosition(e.coord);
			console.log(marker.getPosition());
		    // JavaScript에서 값 저장
		    var posi = marker.getPosition();

		    // AJAX를 사용하여 Java로 값 전달
		    $.ajax({
		        url: '/savePosition',  // Spring Controller에서 처리할 경로
		        type: 'POST',
		        data: JSON.stringify({ lat: posi.lat(), lng: posi.lng() }),  // 위도와 경도를 JSON 형태로 전달
		        contentType: 'application/json',
		        success: function(response) {
		            console.log('Position saved successfully');
		        },
		        error: function(err) {
		            console.log('Error saving position:', err);
		        }
		    });
		});
	</script>
</body>
</html>



