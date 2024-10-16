<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<style>
  fieldset {
    width: 300px;
    height: 200px;
  }

  .form-group {
    display: flex;
    justify-content: space-between;
    margin-bottom: 10px;
  }
</style>

<body>
  <jsp:include page="header.jsp" />
  <main>
    <h2>SSAFY 사용자 관리</h2>
    <hr />
    <fieldset>
      <legend>사용자 정보 입력</legend>
      <div class="form-group">
        <label for="userId">아이디</label>
        <input type="text" id="userId" name="userId" />
      </div>
      <div class="form-group">
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" />
      </div>
      <div class="form-group">
        <label for="name">이름</label>
        <input type="text" id="name" name="name" />
      </div>
      <div class="form-group">
        <label for="email">이메일</label>
        <input type="email" id="email" name="email" />
      </div>
      <div class="form-group">
        <label for="age">나이</label>
        <input type="number" id="age" name="age" />
      </div>
      <div class="form-actions">
        <button type="submit">등록</button>
        <button type="reset" class="reset">초기화</button>
      </div>
    </fieldset>
  </main>

</body>

</html>