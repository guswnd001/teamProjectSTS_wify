<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="${project}/Dashio/lib/theater.js" type="text/javascript"></script>

<div class="row mt">
	<div class="col-md-12">
		<div class="form-panel">
			<h4 class="mb"><i class="fa fa-angle-right"></i> 등록하기 </h4>
			
	<form class="form-horizontal style-form" method="post" action="registration" name="form" onsubmit="return check(form);">

		<div class="temp" id="temp">
			<input type="hidden" name="id" value="${id }">
		</div>
		<div class="form-group">
			<label class="col-sm-2 col-sm-2 control-label"> 조건명</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="condition_name" required="required">
				
			</div>
		</div>
	
		<div class="form-group">
			<label class="col-sm-2 col-sm-2 control-label"> 영화 선택</label>
			<div class="col-sm-10">
				<select name="movie_name" class="btn btn-theme dropdown-toggle" style="display:block; width: 500px;" required="required">
					<c:forEach items="${movieList }" var="movie"> 
						<option value="${movie }">${movie }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 col-sm-2 control-label"> 지역 선택</label>
			<div class="col-sm-10">
				<select name="region_code" class="btn btn-theme dropdown-toggle" style="display:block; width: 500px;"
				id="region" onchange="regionSelect(this.value)" required="required">
					<option></option>
					<c:forEach items="${regionList }" var="region">
						<option value="${region.REGION_CODE}">${region.REGION_NAME}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 col-sm-2 control-label"> 영화관 선택</label>
			<div class="col-sm-10">
				<select name="theater_code" class="btn btn-theme dropdown-toggle" style="display:block; width: 500px;"
				id="theater" onchange="theaterSelect(this.value)" required="required">
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 col-sm-2 control-label"> 특별관 선택</label>
			<div class="col-sm-10">
				<select name="room" class="btn btn-theme dropdown-toggle" style="display:block; width: 300px;"
				id="roomType" required="required">
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 col-sm-2 control-label"> 날짜 선택</label>
			<div class="col-sm-10">
				<input class="form-control form-control-inline input-medium default-date-picker"
				size="16" type="text" name="dateValue" id="date" autocomplete=off required="required" >
				<span class="help-block">오늘을 기준으로 3일 후까지만 선택할 수 있습니다.</span>
			</div>
		</div>
		
		
		<div class="form-group" style="padding-bottom: 0px; border-bottom: none;">
			<div class="pull-right">
				<button type="submit" class="btn btn-theme" style="margin-right:30px" ><i class="fa fa-check"></i> 등록</button>
			</div>
		</div>

			

              </form>
            </div>
          </div>
          <!-- col-lg-12-->
        </div>

</body>

</html>

