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
                          <input type="hidden" name="num" value="${num}">
<input type="hidden" name="pageNum" value="${pageNum}">
<input type="hidden" name="ref" value="${ref}">
<input type="hidden" name="re_step" value="${re_step}">
<input type="hidden" name="re_level" value="${re_level}">
                          <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 100%;">분류</label>
<select class="btn btn-theme dropdown-toggle" style="display:block; width: 300px; margin-left: 15px;" required="required" name="cat_name">
   <option value="영화">영화</option>
   <option value="쇼핑">쇼핑</option>
   <option value="투어">투어</option>
   <option value="기타">기타</option>
</select>

                          </div>
                  
                          <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 100%;">제목</label>
                            <div class="col-lg-6" style="width: 100%;">
                            
                            
                            
                            
                              <c:if test="${num==0 }">
                              <input type="text" name="subject" class="form-control" required="required" >
                                </c:if>
                                <c:if test="${num>0 }">
                              <input type="text" name="subject" class="form-control" value="[답변]" required="required" >
                                </c:if>
                                
                                
                                
                                
                            </div>
                            </div>

                          <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 100%;">작성자</label>
                            <div class="col-lg-6" style="width: 100%;">
                              <input type="text"  name="writer" class="form-control" required="required">
                            </div>
                          </div>
                          
                          <div class="form-group">
                            <label class="col-lg-2 control-label" style="width: 100%;">내용</label>
                            <div class="col-lg-6" style="width: 100%;">
                          <textarea class="form-control" type="text" name="content" rows="5" required="required"></textarea>
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