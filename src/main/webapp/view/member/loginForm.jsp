<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>


<div id="login-page">
    <div class="container">
      <form class="form-login" action="loginPro" name="loginform">
        <h2 class="form-login-heading">sign in now</h2>
        <div class="login-wrap">
        
        <c:if test="${error == null }">
        	<input type="text" class="form-control" name="id" placeholder="User ID" autofocus required="required"><br>
        	<input type="password" class="form-control" name="passwd" placeholder="Password" required="required"><br>
        </c:if>
        
        <c:if test="${error.id }">
        	<input type="text" class="form-control" name="id" placeholder="User ID" autofocus required="required">
        	없는 아이디 입니다.<br>
        	<input type="password" class="form-control" name="passwd" placeholder="Password" required="required">
        	<br>
        </c:if>
        
		<c:if test="${error.passwd }">
			<input type="text" class="form-control" name="id" placeholder="User ID"  required="required" value="${idValue}"><br>
			<input type="password" class="form-control" name="passwd" placeholder="Password" autofocus required="required">
			잘못된 비밀번호 입니다.<br>
		</c:if>
          
          <button class="btn btn-theme btn-block" type="submit"><i class="fa fa-lock"></i> SIGN IN</button>

        </div>

      </form>
    </div>
  </div>
  

</body>
</html>