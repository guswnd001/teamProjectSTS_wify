<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<div class="w3-container">
		
		<p class="w3-right w3-padding-right-large">
			<a
				href="<%=request.getContextPath() %>/Dashio/shopping?pageNum=${pageNum}">글쓰기</a>
		</p>
		<c:if test="${count==0 }">
			<table class="w3-table-all" width="700">
				<tr class="w3-grey">
					<td align="center" width="50">저장된 글이 없습니다</td>
				</tr>
			</table>
		</c:if>

		<c:if test="${count>0 }">
			<div class="row mt">
				<div class="col-md-12">
					<div class="content-panel" style="margin-left:210px;">
					<span class="w3-center  w3-large">
						<h3>(전체 글:${count})</h3>
					</span>
						<table class="table table-striped table-advance table-hover">
							<h4>
								<i class="fa fa-angle-right"></i> 나의 조건 목록
							</h4>
							<hr>
							<thead>
								<tr>
									<th><i class="fa fa-bullhorn"></i>번호</th>
<!-- 									<th class="hidden-phone"><i class="fa fa-question-circle"></i>주카테고리</th>
									<th><i class="fa fa-bookmark"></i>보조카테고리</th>
									<th><i class=" fa fa-edit"></i>조건별명</th> -->
									<th>상품명</th>
									<th>가격</th>
									<th>브랜드</th>
<!-- 									<th>등록일</th>
									<th></th>  -->
								</tr>
							</thead>
							<tbody>
								<c:forEach var="cl" items="${crawlingList}">
									<c:if test="${sc.brand == cl.brand }">
									<tr>
										<td>${cl.num }</td>
										<td>${cl.title }</td>
										<td>${cl.price }</td>
										<td>${cl.brand }</td>
									</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
					</div>

				</div>
			</div>


			<div class="w3-center">
				<c:if test="${ startPage>bottomLine}">

					<a href="list?pageNum=${startPage - bottomLine}">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">

					<a href="list?pageNum=${i}">[${i}] </a>
				</c:forEach>

				<c:if test="${ endPage<pageCount}">

					<a href="list?pageNum=${startPage + bottomLine}">[다음]</a>
				</c:if>


			</div>
		</c:if>
	</div>
