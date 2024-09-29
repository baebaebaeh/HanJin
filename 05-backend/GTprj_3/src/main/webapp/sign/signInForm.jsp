<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그인</h3>
	<form method="post" action="<%= request.getContextPath() %>/main">
		<input type="hidden" name="action" value="signIn">
		<div><input type="text" name="userEmail" placeholder="아이디"></div>
		<div><input type="password" name="userPassword" placeholder="비밀번호"></div>
		<div><button>로그인</button></div>
	</form>
	<a href="<%= request.getContextPath() %>/main">메인으로</a>
</body>
</html> --%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>로그인 페이지</title>
  <link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/images/logos/seodashlogo.png" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/css/styles.min.css" />
</head>

<body>
  <!--  Body Wrapper -->
  <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
    data-sidebar-position="fixed" data-header-position="fixed">
    <div
      class="position-relative overflow-hidden radial-gradient min-vh-100 d-flex align-items-center justify-content-center">
      <div class="d-flex align-items-center justify-content-center w-100">
        <div class="row justify-content-center w-100">
          <div class="col-md-8 col-lg-6 col-xxl-3">
            <div class="card mb-0">
              <div class="card-body">
                <a href="./index.html" class="text-nowrap logo-img text-center d-block py-3 w-100">
                  <img src="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/images/logos/SSAFIT.PNG" alt="" style="width: 300px;">
                </a>
                <p class="text-center">로그인만해도 운동 절반은 한거에요! </p>
                <form>
                	<input type="hidden" name="action" value="signIn">
                	
                  <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">User email</label>
                    <input input type="text" name="userEmail" placeholder="아이디" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                  <div class="mb-4">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input input type="password" name="userPassword" placeholder="비밀번호" class="form-control" id="exampleInputPassword1">
                  </div>
                  <div class="d-flex align-items-center justify-content-between mb-4">
                    <div class="form-check">
                      <input class="form-check-input primary" type="checkbox" value="" id="flexCheckChecked" checked>
                      <label class="form-check-label text-dark" for="flexCheckChecked">
                        Remeber this Device
                      </label>
                    </div>
                    <a class="text-primary fw-bold" href="./index.html">Forgot Password ?</a>
                  </div>
                  
                  <a href="${pageContext.request.contextPath}/main" class="btn btn-primary w-100 py-8 fs-4 mb-4">Sign In</a>
                  <div class="d-flex align-items-center justify-content-center">
                    <p class="fs-4 mb-0 fw-bold">New To Our Site?</p>
                    <a class="text-primary fw-bold ms-2" href="./authentication-register.html">Create an account</a>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/libs/jquery/dist/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/SEODash-1.0.0/src/assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/iconify-icon@1.0.8/dist/iconify-icon.min.js"></script>
</body>

</html>