<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><i class="fa fa-angle-right"></i> ${condition.movie_name } <button type="submit" class="btn btn-theme" style="margin-right:30px; float:right; margin-bottom:15px;"
				onclick="location.href='${project}/theater/regFirst'"> 추가</button></h3>
				

<div class="row">
<div class="col-lg-12">
<div class="row content-panel">
	<div class="col-md-4 profile-text mt mb centered">
		<div class="right-divider hidden-sm hidden-xs">

			<h4>${condition.condition_name }</h4>
			<h6>조건명</h6>
			<h4>${condition.movie_name }</h4>
			<h6>영화제목</h6>
		</div>
	</div>
	<div class="col-md-4 profile-text mt mb centered">
		<div class="right-divider hidden-sm hidden-xs">

			<h4>${condition.region_name } / ${condition.theater_name }</h4>
			<h6>극장</h6>
			<h4>${condition.room }</h4>
			<h6>특별관 정보</h6>
		</div>
	</div>

	<div class="col-md-4 profile-text mt mb centered">
		<div class="right-divider hidden-sm hidden-xs">

			<h4><fmt:formatDate value="${condition.target_date }" pattern="yyyy.MM.dd" /></h4>
			<h6>목표날짜</h6>
			<h4><fmt:formatDate value="${condition.reg_date}" pattern="yyyy.MM.dd" /></h4>
			<h6>조건설정일</h6>
		</div>
	</div>
</div>
</div>
</div>         
          

<c:if test="${movie == null }">
<div class="row">
	<div class="col-md-4 mb" style="float: left; margin-left: 30%;margin-top: 2%;">
		<div class="white-panel pn">
			<i class="fa fa-exclamation-triangle" style="font-size: 100px;margin-top: 50px;"></i>
			<p style="font-size: 18px;margin-top: 10px;">결과가 없습니다.</p>
		</div>
	</div>
</div>
</c:if>

<c:if test="${movie != null }">

	
<div class="row">
<div class="col-lg-12">
	
		<c:forEach items="${movie.roomlist }" var="room" end="2">
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
		<div class="custom-box">
			<div class="servicetitle">
				<h4>${room.room_name } ${room.room_type }</h4> <hr style="width:80%;">
			</div>
                <ul class="pricing">
                	<c:forEach items="${room.timelist }" var="time">
						<li>${time.timeinfo } : ${time.seatinfo } <a class="btn btn-theme btn-xs" href="http://www.cgv.co.kr/${time.reserveurl }" target="_blank">예매하기</a></li>
					</c:forEach>
                </ul>
		</div>
		</div>
		</c:forEach>
</div>
<div class="col-lg-12">
		<c:forEach items="${movie.roomlist }" var="room" begin="3" end="5">
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
		<div class="custom-box">
			<div class="servicetitle">
				<h4>${room.room_name } ${room.room_type }</h4> <hr style="width:80%;">
			</div>
                <ul class="pricing">
                	<c:forEach items="${room.timelist }" var="time">
						<li>${time.timeinfo } : ${time.seatinfo } <a class="btn btn-theme btn-xs" href="http://www.cgv.co.kr/${time.reserveurl }" target="_blank">예매하기</a></li>

					</c:forEach>
                </ul>
                
		</div>
		</div>
		</c:forEach>
</div>
<div class="col-lg-12">
		<c:forEach items="${movie.roomlist }" var="room" begin="6" end="8">
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
		<div class="custom-box">
			<div class="servicetitle">
				<h4>${room.room_name } ${room.room_type }</h4> <hr style="width:80%;">
			</div>
                <ul class="pricing">
                	<c:forEach items="${room.timelist }" var="time">
						<li>${time.timeinfo } : ${time.seatinfo } <a class="btn btn-theme btn-xs" href="http://www.cgv.co.kr/${time.reserveurl }" target="_blank">예매하기</a></li>

					</c:forEach>
                </ul>
                
		</div>
		</div>
		</c:forEach>
</div>
</div>
</c:if>

</body>
</html>