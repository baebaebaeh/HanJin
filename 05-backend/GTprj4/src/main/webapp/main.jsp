<%-- <%@page import="com.ssafy.gt.user.model.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
User user = (User)session.getAttribute("memberInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
	<%
	if (user == null) {
	%>
	<a href="<%= request.getContextPath() %>/main?action=signInForm">로그인</a>
	<a href="<%= request.getContextPath() %>/main?action=signUpForm">회원가입</a>
	<%
	} else {
		String userEmail = user.getUserEmail();
		String userPassword = user.getUserPassword();
		String userName = user.getUserName();
		int isUser = user.getIsUser();
	%>
	<p><%= userName %>님 반갑습니다.</p>
	<a href="<%= request.getContextPath() %>/main?action=signOut">로그아웃</a>
	<%
	}
	%>
</body>
</html> --%>





<%@page import="com.ssafy.gt.user.model.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%
User user = (User) session.getAttribute("memberInfo");
%>

<!-- 패널 숨기고 , 키는 기능 위해서 -->
<%@ page session="true"%>


<!doctype html>
<html lang="en">
<style>
.link-primary {
  all: unset; /* 모든 기본 스타일을 제거 */
  display: inline-block; /* 버튼이 차지하는 공간을 유지 */
  cursor: pointer; /* 버튼 위에 마우스를 올리면 커서가 손가락 모양으로 바뀜 */
  text-align: center; /* 텍스트 가운데 정렬 */
}

</style>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SSAFIT DAEJEON 4반</title>
<link rel="shortcut icon" type="image/png"
	href="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/images/logos/image.png" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/css/styles.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/css/rotate.css">
</head>

<body>
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
							href="./index.html" aria-expanded="false"> <span> <iconify-icon
										icon="solar:home-smile-bold-duotone" class="fs-6"></iconify-icon>
							</span> <span class="hide-menu">HOME</span>
						</a></li>
						<li class="nav-small-cap"><iconify-icon
								icon="solar:menu-dots-linear" class="nav-small-cap-icon fs-6"></iconify-icon>
							<span class="hide-menu">AUTH</span></li>

						<!-- 로그인 상태에 따라 링크를 표시 -->
						<c:if test="${empty sessionScope.memberInfo}">
							<li class="sidebar-item"><a class="sidebar-link"
								href="${pageContext.request.contextPath}/main?action=signInForm"
								aria-expanded="false"> <span> <iconify-icon
											icon="solar:login-3-bold-duotone" class="fs-6"></iconify-icon>
								</span> <span class="hide-menu">Login</span>
							</a></li>
							<li class="sidebar-item"><a class="sidebar-link"
								href="${pageContext.request.contextPath}/main?action=signUpForm"
								aria-expanded="false"> <span> <iconify-icon
											icon="solar:user-plus-rounded-bold-duotone" class="fs-6"></iconify-icon>
								</span> <span class="hide-menu">Register</span>
							</a></li>
						</c:if>

						<!-- 로그인한 경우 Logout 링크 표시 -->
						<c:if test="${not empty sessionScope.memberInfo}">
							<li class="sidebar-item"><a class="sidebar-link"
								href="${pageContext.request.contextPath}/main?action=signOut"
								aria-expanded="false"> <span> <iconify-icon
											icon="solar:logout-bold-duotone" class="fs-6"></iconify-icon>
								</span> <span class="hide-menu">Logout</span>
							</a></li>
						</c:if>
					</ul>
				</nav>
				<!-- End Sidebar navigation -->
			</div>
			<!-- End Sidebar scroll-->
		</aside>
		<!--  Sidebar End -->
		<!--  Main wrapper -->
		<div class="body-wrapper">
			<!--  Header Start -->
			<header class="app-header">
				<nav class="navbar navbar-expand-lg navbar-light">
					<ul class="navbar-nav">
						<li class="nav-item d-block d-xl-none"><a
							class="nav-link sidebartoggler nav-icon-hover"
							id="headerCollapse" href="javascript:void(0)"> <i
								class="ti ti-menu-2"></i>
						</a></li>
						<li class="nav-item"><a class="nav-link nav-icon-hover"
							href="javascript:void(0)"> <i class="ti ti-bell-ringing"></i>
								<div class="notification bg-primary rounded-circle"></div>
						</a></li>
					</ul>
					<div class="navbar-collapse justify-content-end px-0"
						id="navbarNav">
						<ul
							class="navbar-nav flex-row ms-auto align-items-center justify-content-end">
							<!-- <a href="#" target="_blank"
                class="btn btn-primary me-2"><span class="d-none d-md-block">Check Pro Version</span> <span class="d-block d-md-none">Pro</span></a>
              <a href="#" target="_blank"
                class="btn btn-success"><span class="d-none d-md-block">Download Free </span> <span class="d-block d-md-none">Free</span></a> -->
							<c:if test="${not empty sessionScope.memberInfo}">
								<li class="nav-item dropdown"><a
									class="nav-link nav-icon-hover" href="javascript:void(0)"
									id="drop2" data-bs-toggle="dropdown" aria-expanded="false">
										<img
										src="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/images/logos/프사1.PNG"
										alt="" width="50" height="50" class="rounded-circle">
								</a>
									<div
										class="dropdown-menu dropdown-menu-end dropdown-menu-animate-up"
										aria-labelledby="drop2">
										<div class="message-body">
											<a href="javascript:void(0)"
												class="d-flex align-items-center gap-2 dropdown-item"> <i
												class="ti ti-user fs-6"></i>
												<p class="mb-0 fs-3">My Profile</p>
											</a> <a href="javascript:void(0)"
												class="d-flex align-items-center gap-2 dropdown-item"> <i
												class="ti ti-mail fs-6"></i>
												<p class="mb-0 fs-3">My Account</p>
											</a> <a href="javascript:void(0)"
												class="d-flex align-items-center gap-2 dropdown-item"> <i
												class="ti ti-list-check fs-6"></i>
												<p class="mb-0 fs-3">My Task</p>
											</a> <a href="${pageContext.request.contextPath}/main?action=signOut"
												class="btn btn-outline-primary mx-3 mt-2 d-block">Logout</a>
										</div>
									</div></li>
							</c:if>
						</ul>
					</div>
				</nav>
			</header>
			<!--  Header End -->
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-8">
						<div class="card">
							<div class="card-body">
								<div>
									<p style="font-size: 24px;">༼ ᓄºل͟º ༽ᓄ 오늘의 식곤증 예방 사무실 스트레칭
									</p>
								</div>
								<iframe width="560" height="315"
									src="https://www.youtube.com/embed/MTU4iCDntjs"
									title="4 Minute OFFICE STRETCHING(full body) - Allblanc TV"
									frameborder="0"
									allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
									allowfullscreen> </iframe>


							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="card">
							<div style="display: flex; align-items: center;">
								<img
									src="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/images/logos/muscle.png"
									alt="" style="width: 50px; margin-right: 10px;">
								<p style="font-size: 24px; margin: 0;">오늘의 둑근둑근 뉴스</p>
								<img
									src="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/images/logos/mustle2.gif"
									alt="" style="width: 50px; margin-right: 10px;">

							</div>
							<a href="https://sports.khan.co.kr/article/202408010230003?pt=nv"
								target="_blank"> <img
								src="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/images/logos/news1.png"
								alt="image" class="img-fluid" width="500px">
							</a>

						</div>
					</div>
					
					<c:forEach var="video" items="${videos}">
					<div class="col-lg-4">
						<div class="card overflow-hidden hover-img">
							<div class="position-relative">
								<a href="javascript:void(0)">
									<iframe width="100%" height="100%" src="https://www.youtube.com/embed/${video.videoId}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
								</a> 
								<span class="badge text-bg-light text-dark fs-2 lh-sm mb-9 me-9 py-1 px-2 fw-semibold position-absolute bottom-0 end-0">
									${video.videoLength}
								</span>
							</div>
							<form method="post" action="${pageContext.request.contextPath}/main">
							<input type="hidden" name="action" value="videoCntUp">
							<input type="hidden" name="videoId" value="${video.videoId}">
							<div class="card-body p-4">
								<span class="badge text-bg-light fs-2 py-1 px-2 lh-sm  mt-3">
									${video.videoPart}
								</span>
								<button class="d-block my-4 fs-5 text-dark fw-semibold link-primary">
									${video.videoTitle}
								</button>
								<div class="d-flex align-items-center gap-4">
									<div class="d-flex align-items-center gap-2">
										<i class="ti ti-eye text-dark fs-5"></i>${video.videoViewcnt}
									</div>
									<div class="d-flex align-items-center gap-2">
										<i class="ti ti-message-2 text-dark fs-5"></i>${video.videoReviewcnt}
									</div>
									<div class="d-flex align-items-center fs-2 ms-auto">
									</div>
								</div>
							</div>
							</form>
						</div>
					</div>
					</c:forEach>
					<div class="py-6 px-6 text-center">
						<p>&copy; Design and Developed by DAEJEON CLASS-4 SOUN,
							SEOUNGHO, MINA</p>
					</div>
				</div>
			</div>


		</div>
		<script
			src="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/libs/jquery/dist/jquery.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/libs/apexcharts/dist/apexcharts.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/libs/simplebar/dist/simplebar.js"></script>
		<script
			src="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/js/sidebarmenu.js"></script>
		<script
			src="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/js/app.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/js/dashboard.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/iconify-icon@1.0.8/dist/iconify-icon.min.js"></script>
</body>

</html>






