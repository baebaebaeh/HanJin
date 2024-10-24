<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=[YOUR_CLIENTID]"></script>
</head>
<body>
	<h2>메인페이지</h2>
	<a href="${pageContext.request.contextPath}/board/list">게시판 이동</a>
	<div id="map" style="width: 100%; height: 1600px;"></div>
	<script>
		var mapOptions = {
			center : new naver.maps.LatLng(37.3595704, 127.105399),
			zoom : 10
		};

		var map = new naver.maps.Map('map', mapOptions);
		var map = new naver.maps.Map('map', {
		    center: new naver.maps.LatLng(37.3646656, 127.108828),
		    zoom: 16
		});

		var polyline = new naver.maps.Polyline({
		    map: map,
		    path: [
		        new naver.maps.LatLng(36.34810911738359, 127.29855438568136),
		        new naver.maps.LatLng(36.34880350462073, 127.29655180830008),
		        new naver.maps.LatLng(36.35086460570155, 127.29759568692997),
		        new naver.maps.LatLng(36.35345490378596, 127.2996331752597),
		        new naver.maps.LatLng(36.355058200139744, 127.29995126919269)
		    ],
		    clickable: true,
		    strokeColor: '#5347AA',
		    strokeStyle: 'longdash',
		    strokeOpacity: 0.5,
		    strokeWeight: 5
		});

		naver.maps.Event.addListener(polyline, 'mouseover', function() {

		    polyline.setOptions({
		        strokeColor: '#E51D1A',
		        strokeStyle: 'solid',
		        strokeOpacity: 1
		    });
		});

		naver.maps.Event.addListener(polyline, 'mouseout', function() {

		    polyline.setOptions({
		        strokeColor: '#5347AA',
		        strokeStyle: 'longdash',
		        strokeOpacity: 0.5
		    });
		});
	</script>
</body>
</html>



