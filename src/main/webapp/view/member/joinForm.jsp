<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
function join() {
	var form = eval("document.joinform");
	if(form.passwd.value != form.joincfmPwd.value){
		alert("비밀번호가 동일하지 않습니다. 동일하게 입력해주세요.");
		return false;
	}
	return true;
}

</script>


        <div class="row mt">

          <!-- /col-lg-12 -->
          <div class="col-lg-12 mt" >
            <div class="row content-panel" style="margin-right: 400px; margin-left: 400px;">
              <div class="panel-heading">
 
                    <div class="row">
                      <div class="col-lg-8 col-lg-offset-2 detailed mt">
                        <h3 class="mb" align="center">회원가입</h3>
                        <hr>

                        <form class="form-horizontal" name="joinform" action="joinPro" style="margin: 0 auto; width:250px;" onsubmit="return join();">
                          <div class="form-group" >
                            <label class="col-lg-2 control-label" >ID</label>
                            <div class="col-lg-6" style="width: 100%;">
                              <input type="text" name="id" class="form-control" required="required">
                              <c:if test="${error }"><span>이미 등록된 ID 입니다.</span></c:if>
                              
                            </div>
                          </div>
                          
                          <div class="form-group">
                            <label class="col-lg-2 control-label" >PASSWORD</label>
                            <div class="col-lg-6" style="width: 100%;">
                              <input type="password"  name="password" class="form-control" required="required" id="passwd">
                            </div>
                          </div>
                          
                          <div class="form-group">
                            <label class="col-lg-2 control-label">CONFIRM PASSWORD</label>
                            <div class="col-lg-6" style="width: 100%;">
                              <input type="password"  id="joincfmPwd" class="form-control">
                            </div>
                          </div>
                          
                          <div class="form-group">
                            <label class="col-lg-2 control-label" >GENDER</label>
                         <div class="col-lg-6" style="width: 100%;" >
                              &nbsp;&nbsp;&nbsp;<input type="radio" name="gender" value="f" id="f" >여성  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                              <input type="radio" name="gender" value="m" id="m">남성
                          </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label" >NAME</label>
                            <div class="col-lg-6" style="width: 100%;">
                              <input type="text"  name="name" class="form-control" required="required">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label" >EMAIL</label>
                            <div class="col-lg-6" style="width: 100%;">
                              <input type="email" name="email" class="form-control" required="required">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label" >PHONE</label>
                            <div class="col-lg-6" style="width: 100%;">
                              <input type="text" name="phone" class="form-control" required="required" pattern="\d{11}">
                            </div>
                          </div>
                          
                            <div class="col-lg-offset-2 col-lg-10">
                              <button class="btn btn-theme" type="submit">회원가입</button>
                              <button class="btn btn-theme04" type="reset">다시입력</button>
                            </div>
                        
                        </form>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>



</body>
</html>