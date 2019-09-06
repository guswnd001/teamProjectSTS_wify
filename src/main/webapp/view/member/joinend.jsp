<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



    <!--main content start-->
   
        <div class="row">
          <div class="col-lg-12" >
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
              <div class="custom-box" >
                <div class="servicetitle" >
                  <h4>회원가입 완료</h4>
                  <hr>
                </div>
                <div class="icn-main-container">
                  <span class="icn-container" ><i class="fa fa-smile-o"></i></span>
                </div>
                <p>${idValue } 님 가입을 축하합니다.</p>

                <a class="btn btn-theme" href="<%=request.getContextPath()%>/index">홈으로</a>
                <a class="btn btn-theme" href="<%=request.getContextPath()%>/member/login">로그인</a>
              </div>
              <!-- end custombox -->
            </div>
          </div>
          <!--  /col-lg-12 -->
        </div>
        <!--  /row -->


</body>
</html>