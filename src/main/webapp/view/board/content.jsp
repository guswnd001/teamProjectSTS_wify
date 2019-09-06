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
                        <form class="form-horizontal"  action="writePro" style="margin: 0 auto; width:400px;">
                          <input type="hidden" name="num" value="${QnAcontent.num}">



                          <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 100%;">분류</label>
                        <div class="col-lg-6" style="width: 100%;">
                        <input type="text" name="cat_name" class="form-control" value="${QnAcontent.cat_name}" readonly="readonly">
                         </div>
                          </div>
                  
                          <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 100%;">제목</label>
                            <div class="col-lg-6" style="width: 100%;">
                              <input type="text" name="subject" class="form-control" value="${QnAcontent.subject}" readonly="readonly" >
                            </div>
                            </div>

                          <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 100%;">작성자</label>
                            <div class="col-lg-6" style="width: 100%;">
                              <input type="text"  name="writer" class="form-control" value="${QnAcontent.writer}" readonly="readonly">
                            </div>
                          </div>
                          
                          <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 100%;">내용</label>
                            <div class="col-lg-6" style="width: 100%;">
                          <textarea class="form-control" type="text" name="content" rows="5" readonly="readonly">${QnAcontent.content}</textarea>
                              <!-- <input type="text"  name="content" class="form-control" data-rule="required"> -->
                            </div>
                          </div>
                            <div class="col-lg-offset-2 col-lg-10">
                              <a class="btn btn-theme04" href="${project }/board/list?pageNum=${pageNum}">목록으로가기</a>
                              <a class="btn btn-theme04" href="${project }/board/update?num=${QnAcontent.num}&pageNum=${pageNum}">글수정</a>
                              <a class="btn btn-theme04" href="${project }/board/delete?num=${QnAcontent.num}&pageNum=${pageNum}">글삭제</a>
                         <%--      <a class="btn btn-theme04" href="${project }/board/writeForm?num=${QnAcontent.num}&pageNum=${pageNum}${pageNum}&ref=${article.ref}&re_step=${article.re_step}&re_level=${article.re_level}">답글쓰기</a>  --%>   
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