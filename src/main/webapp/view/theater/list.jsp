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
	<div class="col-md-12">
		
<c:if test="${count !=0 }">
<div class="content-panel">
			<div class="pull-right">
				<button type="submit" class="btn btn-theme" style="margin-right:30px"
				onclick="location.href='${project}/theater/regFirst'"> 조건추가</button>
			</div>
			<table class="table table-striped table-advance table-hover">
				<h4><i class="fa fa-angle-right"></i> CGV 조건</h4>
				<thead>
	<tr>
		<th><i class="fa fa-bullhorn"></i> 조건명</th>
		<th><i class="fa fa-bullhorn"></i> 영화명</th>
		<th><i class="fa fa-question-circle"></i> 지역</th>
		<th><i class="fa fa-bookmark"></i> 영화관</th>
		<th><i class="fa fa-bookmark"></i> 특별관</th>
		<th><i class="fa fa-bookmark"></i> 목표날짜</th>
		<th><i class="fa fa-bookmark"></i> 등록일</th>
		<th><i class=" fa fa-edit"></i> 상태</th> <!-- 여기에 현재 유효한 조건인지, 아니면 유효하지 않은지 표시하기 -->
		
	</tr>
				</thead>
				<tbody>
<c:forEach items="${conditionList }" var="con">
	<tr>
		<td>
			<c:if test="${con.target_date >= today }">
				<a href="detail?num=${con.num }">${con.condition_name }</a>
			</c:if>
			<c:if test="${con.target_date < today }">
				${con.condition_name }
			</c:if>
		</td>
		<td>${con.movie_name }</td>
		<td>${con.region_name }</td>
		<td>${con.theater_name }</td>
		<td>${con.room}</td>
		<td><fmt:formatDate value="${con.target_date }" pattern="yyyy.MM.dd" /></td>
		<td><fmt:formatDate value="${con.reg_date}" pattern="yyyy.MM.dd" /></td>
		<td>
			<c:if test="${con.target_date >= today }">
				<span class="label label-success label-mini">ing</span>
			</c:if>
			<c:if test="${con.target_date < today }">
				<span class="label label-warning label-mini">end</span>
			</c:if>
			
		</td>
		<td>
			<button class="btn btn-danger btn-xs" onclick="location.href='${project}/theater/delete?num=${con.num}'"><i class="fa fa-trash-o "></i></button> <!-- 삭제 버튼 -->
		</td>
	</tr>
</c:forEach>
                </tbody>
              </table>
              </div>
</c:if>
<c:if test="${count == 0}">



<div class="col-lg-4 col-md-4 col-sm-4 mb" style="margin-left: 35%;">
<div class="weather-3 pn centered" style="background: #4ECDC4;">
<i class="fa fa-frown-o" style="margin-top: 40px;"></i>
<h3 style="margin-top: 50px; color: white;">설정된 조건이 없습니다.</h3>
<button type="submit" class="btn btn-theme02" style="margin-right:30px" 
onclick="location.href='${project}/theater/regFirst'"> 조건추가</button>
</div>
</div>
</c:if>       

            
          </div>
        </div>

<!-- <span class="label label-success label-mini">ing</span>
<span class="label label-warning label-mini">ing</span>
<span class="label label-info label-mini">ing</span> -->


</body>
</html>