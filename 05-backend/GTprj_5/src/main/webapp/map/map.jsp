<%@page import="com.ssafy.gt.user.model.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MAP</title>
<link rel="shortcut icon" type="image/png"
	href="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/images/logos/image.png" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/css/styles.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/css/rotate.css">
</head>

<body>

	
<h2 style="text-align: center; margin: 20px 0;">WARNING! 헬스인 출몰 지역</h2>


	<!--  Body Wrapper -->
	<div class="page-wrapper" id="main-wrapper" data-layout="vertical"
		data-navbarbg="skin6" data-sidebartype="full"
		data-sidebar-position="fixed" data-header-position="fixed">
		<!-- Sidebar Start -->
		<aside class="left-sidebar">
			<!-- Sidebar scroll-->
			<div>
				<div
					class="brand-logo d-flex align-items-center justify-content-between">
					<a href="./index.html" class="text-nowrap logo-img"> <img
						src="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/images/logos/image_unborder.png"
						alt="" width="100px" />
					</a>
					<div
						class="close-btn d-xl-none d-block sidebartoggler cursor-pointer"
						id="sidebarCollapse">
						<i class="ti ti-x fs-8"></i>
					</div>
				</div>
				<!-- Sidebar navigation-->
				<nav class="sidebar-nav scroll-sidebar" data-simplebar="">
					<ul id="sidebarnav">

						<li class="nav-small-cap"><i
							class="ti ti-dots nav-small-cap-icon fs-6"></i> <span
							class="hide-menu">Home</span></li>
						<li class="sidebar-item"><a class="sidebar-link"
							href="${pageContext.request.contextPath}/main?action=main" aria-expanded="false"> <span> <iconify-icon
										icon="solar:home-smile-bold-duotone" class="fs-6"></iconify-icon>
							</span> <span class="hide-menu">HOME</span>
						</a></li>

					</ul>

				</nav>
				<!-- End Sidebar navigation -->
			</div>
			<!-- End Sidebar scroll-->

		</aside>




	<!-- 지도  -->	
	<div class="container" style="height: 100%;">
    <section class="section" id="section-3" style="height: 100%;">
        <div id="map" style="width: 100%; height: 80vh; margin: auto"></div>
        <code id="snippet" class="snippet"></code>
    </section>
</div>
	

	<!-- 각자 발급받은 Client ID 값 넣기 -->
	<script type="text/javascript"
		src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=evua0scpqg">
	</script>
			
		
<script id="code">
    var locations = [
        {
            position: new naver.maps.LatLng(36.355271, 127.298598),  // 유성연수원 좌표
            content: "SSAFY Daejeon Campus",
            icon: "${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/images/logos/ssafy_round.png"
        },
        {
            position: new naver.maps.LatLng(36.341797, 127.306181),  // 1
            content: "하츄핑보다는...도핑?",
            icon: "${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/images/logos/ping_round.png"
        },
        {
            position: new naver.maps.LatLng(36.350507, 127.338395),  // 2
            content: "회식때만 출몰한다는 희귀 잔망루미",
            icon: "${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/images/logos/loopy_round.png"
        },
        {
            position: new naver.maps.LatLng(36.354013, 127.339405),  // 3
            content: "Annoying GIM...Gyuri",
            icon: "${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/images/logos/guri_round.png"
        }
    ];

    var map = new naver.maps.Map('map', {
        center: new naver.maps.LatLng(36.355271, 127.298598),
        zoom: 16,
        minZoom: 8,
        zoomControl: true,
        zoomControlOptions: {
            position: naver.maps.Position.TOP_RIGHT
        }
    });

    // 마커와 인포윈도우 배열 생성
    var markers = [];
    var infoWindows = [];

    locations.forEach(function(location) {
        // 마커 생성 (크기를 두 배로 조정)
        var marker = new naver.maps.Marker({
            position: location.position,
            map: map,
            icon: {
                url: location.icon,
                scaledSize: new naver.maps.Size(60, 74),  
                origin: new naver.maps.Point(0, 0)
            }
        });

        // 마커마다 인포윈도우 생성 (마커 위로 위치 조정)
        var contentString = [
            '<div class="iw_inner" style="padding:5px; margin: 5px 0px 5px 0px; width: 140px; height: 45px; text-align: center;">',
            '   <p style="font-size: 0.8rem; margin: 0;">' + location.content + '</p>',
            '</div>'
        ].join('');

        var infowindow = new naver.maps.InfoWindow({
            content: contentString,
            maxWidth: 200,
            height: 50,
            backgroundColor: "white",
            borderColor: "black",
            borderWidth: 2,
            disableAnchor: true,
            textAlign: "center",
            pixelOffset: new naver.maps.Point(0, -20)  // 인포윈도우 위치 조정
        });

        // 마커 클릭 이벤트 처리 (독립적인 인포윈도우 작동)
        naver.maps.Event.addListener(marker, "click", function() {
            if (infowindow.getMap()) {
                infowindow.close();
            } else {
                infoWindows.forEach(function(iw) {
                    iw.close();  // 다른 인포윈도우 닫기
                });
                infowindow.open(map, marker);
            }
        });

        markers.push(marker);
        infoWindows.push(infowindow);
    });

    // 줌 레벨 변경에 따라 마커 및 인포윈도우 표시/숨기기
    naver.maps.Event.addListener(map, 'zoom_changed', function() {
        var zoom = map.getZoom();
        markers.forEach(function(marker, index) {
            if (zoom >= 13) {
                marker.setMap(map);
            } else {
                marker.setMap(null);
                infoWindows[index].close();
            }
        });
    });
</script>










</body>