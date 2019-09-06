<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
${project = pageContext.request.contextPath ; ''}



<section id="main-content">
<section class="wrapper">
<div class="container">

<h3>상품 검색</h3>
<form action="${project }/Dashio/search?pageNum=${pageNum}">

<h5>카테고리</h5>
  <div class="form-group">
    <select class="form-control" id="selectDemoSize" name="main_cat" onchange="onedepth(this.value)">
      <option value="" selected disabled hidden>주카테고리</option>
      <option>음향기기</option>
      <option>태블릿</option>
      <option>카메라</option>
      <option>PC/노트북</option>
    </select>
  </div>
  <div class="form-group">
    <select class="form-control" name="sub_cat" onchange="twodepth(this.value)" id="two">
      <option value="" selected disabled hidden>보조카테고리</option>
      
    </select>
  </div>
  
  <div class="form-group">
    <select class="form-control" name="brand" id="three">
     <option value="" selected disabled hidden>브랜드</option>
    </select>
  </div>
  
<h5>Product Information</h5>
  <div class="form-group">
    <input type="text" class="form-control" id="NameDemoSize" aria-describedby="nameHelp" placeholder="상품명 검색" name="product_name">
  </div>
  <div class="form-group form-control-sm">
    <input type="text" class="form-control" id="NameDemoSize2" aria-describedby="nameHelp" placeholder="가격대 검색" name="wish_price">
  </div>
  
  <div class="form-group form-control-sm">
    <input type="text" class="form-control" id="NameDemoSize2" aria-describedby="nameHelp" placeholder="조건 별명" name="scon_title">
  </div>  
<!-- <h5>Select dropdowns sizes</h5>  
  <div class="form-group">
    <select class="form-control" id="selectDemoSize">
      <option>Normal</option>
      <option>....</option>
    </select>
  </div>

  <div class="form-group">
    <select class="form-control form-control-lg" id="selectDemoSize">
      <option>Large - form-control-lg</option>
      <option>....</option>
    </select>
  </div>
  
  <div class="form-group">
    <select class="form-control form-control-sm" id="selectDemoSize">
      <option>Small - form-control-sm</option>
      <option>....</option>
    </select>
  </div>   -->
<button type="submit" class="btn btn-success ">상품 검색</button>
<button type="reset" class="btn btn-success ">다시입력</button>
<button type="button" class="btn btn-success "
 OnClick="window.location='${project }/Dashio/sconList?pageNum=${pageNum }'">나의 조건 목록 보기</button>
 
   

<script type="text/javascript">

function onedepth(value) {
   switch(value) {
   case "음향기기":
      $("#two").find("option").remove().end().append("<option></option>");
      $("#two").append("<option value=\"일반 이어폰\">일반 이어폰</option>");
      $("#two").append("<option value=\"블루투스 이어폰\">블루투스 이어폰</option>");
      $("#two").append("<option value=\"사운드바\">사운드바</option>");
      $("#two").append("<option value=\"홈시어터\">홈시어터</option>");
      $("#two").append("<option value=\"포터블\">포터블</option>");
      $("#two").append("<option value=\"마이크\">마이크</option>");
      $("#two").append("<option value=\"오디오\">오디오</option>");
      $("#two").append("<option value=\"일반 헤드폰\">일반 헤드폰</option>");      
      break;
   case "태블릿":
	  $("#two").find("option").remove().end().append("<option></option>");
	  $("#two").append("<option value=\"안드로이드 태블릿\">안드로이드 태블릿</option>");
	  $("#two").append("<option value=\"윈도우 태블릿\">윈도우 태블릿</option>");
	  $("#two").append("<option value=\"전자사전\">전자사전</option>");
	  $("#two").append("<option value=\"PMP\">PMP</option>");
	  $("#two").append("<option value=\"아이패드\">아이패드</option>");	 	  
	  break;
   case "카메라":
      $("#two").find("option").remove().end().append("<option></option>");
      $("#two").append("<option value=\"DSLR\">DSLR</option>");
      $("#two").append("<option value=\"디지털 카메라\">디지털 카메라</option>");
      $("#two").append("<option value=\"미러리스\">미러리스</option>");
      break;
      
   case "PC/노트북":
	      $("#two").find("option").remove().end().append("<option></option>");
	      $("#two").append("<option value=\"노트북\">노트북</option>");
	      $("#two").append("<option value=\"조립PC\">조립PC</option>");
	      $("#two").append("<option value=\"브랜드 데스크탑\">브랜드 데스크탑</option>");
	      $("#two").append("<option value=\"올인원PC\">올인원PC</option>");
	      break;
   };
}
function twodepth(value) {
	   switch(value) {
	   case "일반 이어폰":
	      $("#three").find("option").remove().end().append("<option></option>");
	      $("#three").append("<option value=\"소니\">소니</option>");
	      $("#three").append("<option value=\"애플\">애플</option>");
	      $("#three").append("<option value=\"삼성전자\">삼성전자</option>");
	      $("#three").append("<option value=\"보스\">보스</option>");
	      $("#three").append("<option value=\"젠하이저\">젠하이저</option>");
	      $("#three").append("<option value=\"Beats\">Beats</option>");
	      $("#three").append("<option value=\"오디오테크니카\">오디오테크니카</option>");
	      $("#three").append("<option value=\"슈어\">슈어</option>");
	      $("#three").append("<option value=\"아이리버\">아이리버</option>");
	      $("#three").append("<option value=\"크레신\">크레신</option>");
	      $("#three").append("<option value=\"스컬캔디\">스컬캔디</option>");
	      $("#three").append("<option value=\"파나소닉\">파나소닉</option>");
	      $("#three").append("<option value=\"LG전자\">LG전자</option>");
	      
	      break;
	   
	   case "블루투스 이어폰":
	      $("#three").find("option").remove().end().append("<option></option>");
	      $("#three").append("<option value=\"소니\">소니</option>");
	      $("#three").append("<option value=\"플랜트로닉스\">플랜트로닉스</option>");
	      $("#three").append("<option value=\"Beats\">Beats</option>");
	      $("#three").append("<option value=\"삼성전자\">삼성전자</option>");
	      $("#three").append("<option value=\"자브라\">자브라</option>");
	      $("#three").append("<option value=\"모비프렌\">모비프렌</option>");
	      $("#three").append("<option value=\"LG전자\">LG전자</option>");
	      $("#three").append("<option value=\"브리츠\">브리츠</option>");
	      $("#three").append("<option value=\"피스넷\">피스넷</option>");
	      $("#three").append("<option value=\"탄노이\">탄노이</option>");
	      $("#three").append("<option value=\"브리츠\">브리츠</option>");
	      $("#three").append("<option value=\"큐씨와이\">큐씨와이</option>");
	      $("#three").append("<option value=\"펜톤\">펜톤</option>");
	      $("#three").append("<option value=\"샤오미\">샤오미</option>");
	      break;
	      
	   case "사운드바":
		      $("#three").find("option").remove().end().append("<option></option>");
		      $("#three").append("<option value=\"삼성전자\">삼성전자</option>");
		      $("#three").append("<option value=\"LG전자\">LG전자</option>");
		      $("#three").append("<option value=\"필립스\">필립스</option>");
		      $("#three").append("<option value=\"야마하\">야마하</option>");
		      
		      break;
		      
	   case "홈시어터":
		      $("#three").find("option").remove().end().append("<option></option>");
		      $("#three").append("<option value=\"삼성전자\">삼성전자</option>");
		      $("#three").append("<option value=\"LG전자\">LG전자</option>");
		      $("#three").append("<option value=\"야마하\">야마하</option>");
		      $("#three").append("<option value=\"보스\">보스</option>");
		      $("#three").append("<option value=\"필립스\">필립스</option>");
		      break;
		      
	   case "포터블":
		      $("#three").find("option").remove().end().append("<option></option>");
		      $("#three").append("<option value=\"브리츠\">브리츠</option>");
		      $("#three").append("<option value=\"아이리버\">아이리버</option>");
		      $("#three").append("<option value=\"코원\">코원</option>");
		      $("#three").append("<option value=\"엠피지오\">엠피지오</option>");
		      $("#three").append("<option value=\"쉬크\">쉬크</option>");
		      break;
		      
	   case "마이크":
		      $("#three").find("option").remove().end().append("<option></option>");
		      $("#three").append("<option value=\"오페라\">오페라</option>");
		      $("#three").append("<option value=\"VOTEX\">VOTEX</option>");
		      $("#three").append("<option value=\"브리츠\">브리츠</option>");
		      $("#three").append("<option value=\"컴소닉\">컴소닉</option>");
		      $("#three").append("<option value=\"로이체\">로이체</option>");
		      $("#three").append("<option value=\"유니콘\">유니콘</option>");
		      break;
		      
	   case "오디오":
		      $("#three").find("option").remove().end().append("<option></option>");
		      $("#three").append("<option value=\"브리츠\">브리츠</option>");
		      $("#three").append("<option value=\"bbb\">bbb</option>");
		      break;
		      
	   case "일반 헤드폰":
		      $("#three").find("option").remove().end().append("<option></option>");
		      $("#three").append("<option value=\"엑토\">엑토</option>");
		      $("#three").append("<option value=\"브리츠\">브리츠</option>");
		      $("#three").append("<option value=\"SHURE\">SHURE</option>");
		      $("#three").append("<option value=\"소니\">소니</option>");
		      $("#three").append("<option value=\"블랭크\">블랭크</option>");
		      $("#three").append("<option value=\"젠하이저\">젠하이저</option>");
		      $("#three").append("<option value=\"크라이저\">크라이저</option>");
		      $("#three").append("<option value=\"코시\">코시</option>");
		      break;
		      
	   case "안드로이드 태블릿":
		      $("#three").find("option").remove().end().append("<option></option>");
		      $("#three").append("<option value=\"레노버\">레노버</option>");
		      $("#three").append("<option value=\"화웨이\">화웨이</option>");
		      $("#three").append("<option value=\"삼성전자\">삼성전자</option>");
		      $("#three").append("<option value=\"엠피지오\">엠피지오</option>");
		      $("#three").append("<option value=\"아이뮤즈\">아이뮤즈</option>");
		      break;
		      
	   case "전자사전":
		      $("#three").find("option").remove().end().append("<option></option>");
		      $("#three").append("<option value=\"BESTA\">BESTA</option>");
		      $("#three").append("<option value=\"엠피지오\">엠피지오</option>");
		      $("#three").append("<option value=\"에듀플레이어\">에듀플레이어</option>");
		      $("#three").append("<option value=\"아이리버\">아이리버</option>");
		      break;
		      
	   case "PMP":
		      $("#three").find("option").remove().end().append("<option></option>");
		      $("#three").append("<option value=\"코원\">코원</option>");
		      $("#three").append("<option value=\"사파\">사파</option>");
		      
		      break;
		      
	   case "아이패드":
		      $("#three").find("option").remove().end().append("<option></option>");
		      $("#three").append("<option value=\"애플\">애플</option>");
		      
		      break;
		      
	   case "윈도우 태블릿":
		      $("#three").find("option").remove().end().append("<option></option>");
		      $("#three").append("<option value=\"삼성전자\">삼성전자</option>");
		      $("#three").append("<option value=\"엠피지오\">엠피지오</option>");
		      $("#three").append("<option value=\"아이뮤즈\">아이뮤즈</option>");
		      $("#three").append("<option value=\"엘리트\">엘리트</option>");
		      $("#three").append("<option value=\"샤오미\">샤오미</option>");
		      $("#three").append("<option value=\"아수스\">아수스</option>");
		      break;
		      
	   case "DSLR":
		      $("#three").find("option").remove().end().append("<option></option>");
		      $("#three").append("<option value=\"캐논\">캐논</option>");
		      $("#three").append("<option value=\"니콘\">니콘</option>");

		      break;
		      
	   case "디지털 카메라":
		      $("#three").find("option").remove().end().append("<option></option>");
		      $("#three").append("<option value=\"니콘\">니콘</option>");
		      $("#three").append("<option value=\"후지필름\">후지필름</option>");
		      $("#three").append("<option value=\"올림푸스\">올림푸스</option>");
		      $("#three").append("<option value=\"소니\">소니</option>");
		      $("#three").append("<option value=\"라이카\">라이카</option>");
		      $("#three").append("<option value=\"리코\">리코</option>");
		      $("#three").append("<option value=\"파인픽스\">파인픽스</option>");
		      break;
		      
	   case "미러리스":
		      $("#three").find("option").remove().end().append("<option></option>");
		      $("#three").append("<option value=\"소니\">소니</option>");
		      $("#three").append("<option value=\"올림푸스\">올림푸스</option>");
		      $("#three").append("<option value=\"니콘\">니콘</option>");
		      $("#three").append("<option value=\"라이카\">라이카</option>");
		      $("#three").append("<option value=\"캐논\">캐논</option>");
		      break;
		      
	   case "노트북":
		      $("#three").find("option").remove().end().append("<option></option>");
		      $("#three").append("<option value=\"레노버\">레노버</option>");
		      $("#three").append("<option value=\"삼성전자\">삼성전자</option>");
		      $("#three").append("<option value=\"HP\">HP</option>");
		      $("#three").append("<option value=\"Dell\">Dell</option>");
		      $("#three").append("<option value=\"라이프북\">라이프북</option>");
		      $("#three").append("<option value=\"LG전자\">LG전자</option>");
		      $("#three").append("<option value=\"에이수스\">에이수스</option>");
		      $("#three").append("<option value=\"아이디어패드\">아이디어패드</option>");
		      $("#three").append("<option value=\"에이서\">에이서</option>");
		      $("#three").append("<option value=\"한성컴퓨터\">한성컴퓨터</option>");
		      $("#three").append("<option value=\"마이크로소프트\">마이크로소프트</option>");
		      break;
		      
	   case "조립PC":
		      $("#three").find("option").remove().end().append("<option></option>");
		      $("#three").append("<option value=\"삼성전자\">삼성전자</option>");
		      $("#three").append("<option value=\"아싸컴\">아싸컴</option>");
		      $("#three").append("<option value=\"포유컴\">포유컴</option>");
		      $("#three").append("<option value=\"프리플로우\">프리플로우</option>");
		      $("#three").append("<option value=\"이엑스코리아\">이엑스코리아</option>");
		      break;
		      
	   case "올인원PC":
		      $("#three").find("option").remove().end().append("<option></option>");
		      $("#three").append("<option value=\"HP\">HP</option>");
		      $("#three").append("<option value=\"애플\">애플</option>");
		      $("#three").append("<option value=\"에이수스\">에이수스</option>");
		      $("#three").append("<option value=\"LG전자\">LG전자</option>");
		      $("#three").append("<option value=\"Dell\">Dell</option>");
		      $("#three").append("<option value=\"레노버\">레노버</option>");
		      break;
		      
	   case "브랜드 데스크탑":
		      $("#three").find("option").remove().end().append("<option></option>");
		      $("#three").append("<option value=\"HP\">HP</option>");
		      $("#three").append("<option value=\"삼성전자\">삼성전자</option>");
		      $("#three").append("<option value=\"한성컴퓨터\">한성컴퓨터</option>");
		      $("#three").append("<option value=\"레노버\">레노버</option>");
		      break;
	   };
	}
</script>
 
</form>
</div>
</section>
</section>
