<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="main-content">
<section class="wrapper">
<div class="container">
<h3>상품 검색</h3>
<form action="<%=request.getContextPath()%>/Dashio/shoppingPro">
<input type="hidden" name="scon_no" value="${scon_no}">
<h5>카테고리</h5>
  <div class="form-group">
    <select class="form-control" id="selectDemoSize" name="main_cat">
      <option>주카테고리</option>
      <option>핸드폰</option>
      <option>카메라</option>
      <option>음향기기</option>
    </select>
  </div>
  <div class="form-group">
    <select class="form-control" id="selectDemoSize" name="sub_cat">
      <option>보조카테고리</option>
      <option>블루투스 이어폰</option>
      <option>홈씨어터</option>
      <option>오디오</option>
      <option>일반 헤드폰</option>
    </select>
  </div>
<h5>Product Information</h5>
  <div class="form-group">
    <input type="text" class="form-control" id="NameDemoSize" aria-describedby="nameHelp" placeholder="상품명 검색" name="product_name">
  </div>
  <div class="form-group form-control-sm">
    <input type="text" class="form-control" id="NameDemoSize2" aria-describedby="nameHelp" placeholder="가격대 검색" name="wish_price">
  </div>
  <div class="form-group">
    <select class="form-control" id="selectDemoSize" name="brand">
      <option>Brand</option>
      <option>LG전자</option>
      <option>갤럭시</option>
      <option>제이비엘</option>
      <option>큐씨와이</option>
      <option>엠피지오</option>
    </select>
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
 OnClick="window.location='<%=request.getContextPath()%>/Dashio/sconList?pageNum=${pageNum }'">나의 조건 목록 보기</button>
</form>
</div>
</section>
</section>
