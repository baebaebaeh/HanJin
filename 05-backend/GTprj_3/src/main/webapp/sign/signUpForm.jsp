<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입</h3>
	<form method="post" action="<%= request.getContextPath() %>/main">
		<input type="hidden" name="action" value="signUp">
		<div><input type="text" name="userEmail" placeholder="이메일"></div>
		<div><input type="password" name="userPassword" placeholder="비밀번호"></div>
		<div><input type="text" name="userName" placeholder="이름"></div>
		<div><button>계정 만들기</button></div>
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
  <title>회원가입 페이지</title>
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
                <p class="text-center">당신의 건강을 책임집니다</p>
                <form method="post" action="${pageContext.request.contextPath}/main">
                	<input type="hidden" name="action" value="signUp">
                  <div class="mb-3">
                    <label for="exampleInputtext1" class="form-label">Email Address</label>
                    <input type="text"  name="userEmail" placeholder="이메일" class="form-control" id="exampleInputtext1" aria-describedby="textHelp">
                  </div>
                  <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Password</label>
                    <input type="password" name="userPassword" placeholder="비밀번호" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                  <div class="mb-4">
                    <label for="exampleInputPassword1" class="form-label">Name</label>
                    <input type="text" name="userName" placeholder="이름" class="form-control" id="exampleInputPassword1">
                  </div>
                  <a href="${pageContext.request.contextPath}/main?action=signInForm" class="btn btn-primary w-100 py-8 fs-4 mb-4">Sign Up</a>
                  <div class="d-flex align-items-center justify-content-center">
                    <p class="fs-4 mb-0 fw-bold">Already have an Account?</p>
                    <a class="text-primary fw-bold ms-2" href="./authentication-login.html">Sign In</a>
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