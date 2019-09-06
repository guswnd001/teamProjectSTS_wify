<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="row mt">

          <!-- /col-lg-12 -->
          <div class="col-lg-12 mt" >
            <div class="row content-panel" style="margin-right: 400px; margin-left: 400px;">
              <div class="panel-heading">
 
                    <div class="row">
                    
                      <div class="col-lg-8 col-lg-offset-2 detailed mt">
                        <h3 class="mb" align="center">QnA 작성하기</h3>
                        <hr>
                        <form class="form-horizontal"  action="updatePro" style="margin: 0 auto; width:400px;">
                          <input type="hidden" name="num" value="${upQnA.num}">
                    <input type="hidden" name="pageNum" value="${pageNum}">


                          <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 100%;">분류</label>
                        <div class="col-lg-6" style="width: 100%;">
                        <input type="text" name="cat_name" class="form-control" value="${upQnA.cat_name}" readonly="readonly">
                         </div>
                          </div>
                  
                          <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 100%;">제목</label>
                            <div class="col-lg-6" style="width: 100%;">
                              <input type="text" name="subject" class="form-control" value="${upQnA.subject}" required="required" >
                            </div>
                            </div>

                          <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 100%;">작성자</label>
                            <div class="col-lg-6" style="width: 100%;">
                              <input type="text"  name="writer" class="form-control" value="${upQnA.writer}" readonly="readonly">
                            </div>
                          </div>
                          
                          <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 100%;">내용</label>
                            <div class="col-lg-6" style="width: 100%;">
                          <textarea class="form-control" type="text" name="content" rows="5">${upQnA.content}</textarea>
                              <!-- <input type="text"  name="content" class="form-control" data-rule="required"> -->
                            </div>
                          </div>
                          
                          
                          
                          
                          <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 100%;">비밀번호</label>
                            <div class="col-lg-6" style="width: 100%;">
                              <input type="password"  name="password" class="form-control" required="required">
                            </div>
                          </div>
                          
                            <div class="col-lg-offset-2 col-lg-10">
                              <a class="btn btn-theme04" href="${project }/board/list?pageNum=${pageNum}">목록으로가기</a>
                              <button class="btn btn-theme" type="submit">작성완료</button>
                              <button class="btn btn-theme04" type="reset">다시입력</button>
                            </div>

                        </form>
                        
                      </div>
                      <!-- /col-lg-8 -->
                    </div>
                    <!-- /row -->
                  </div>
                  <!-- /tab-pane -->
                </div>
                <!-- /tab-content -->
              </div>
              <!-- /panel-body -->
            </div>
</body>
</html>