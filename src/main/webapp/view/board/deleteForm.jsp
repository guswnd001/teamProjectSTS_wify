<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <section id="main-content">
      <section class="wrapper">
         <h3>
            <i class="fa fa-angle-right"></i> 글삭제
         </h3>
         <!-- BASIC FORM ELELEMNTS -->
         <div class="row mt">
            <div class="col-lg-6 col-md-6 col-sm-6">
              <div id="message"></div>
               <form method="post" name="writeform" action="${project }/board/deletePro">
                  <input type="hidden" name="num" value="${num }">
                  <input   type="hidden" name="pageNum" value="${pageNum }">

                              
                  <div class="form-group">
                     <input type="password" name="passwd" class="form-control">
                     <div class="validate"></div>
                  </div>


                  <div class="form-send">
                     <input type="submit" value="글삭제" class="btn btn-large btn-primary" >
                     <input type="button" value="목록보기" class="btn btn-large btn-primary"  OnClick="window.location='${project }/board/list?pageNum=${pageNum}'">
                     
                  </div>
                  
                  
               </form>
            </div>
         </div>
         <!-- /row -->
         <!-- /row -->
      </section>
      <!-- /wrapper -->
   </section>

</body>
</html>