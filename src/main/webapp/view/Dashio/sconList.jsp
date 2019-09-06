<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
${project = pageContext.request.contextPath ; ''}
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
									<th class="hidden-phone"><i class="fa fa-question-circle"></i>주카테고리</th>
									<th><i class="fa fa-bookmark"></i>보조카테고리</th>
									<th><i class=" fa fa-edit"></i>조건별명</th>
									<th>상표</th>
									<th>상품명</th>
									<th>가격조건</th>
									<th>등록일</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="sconditionList" items="${sconditionList}">
									<tr>
										<td><a href="basic_table.html#">${sconditionList.scon_no}</a>
										</td>
										<td class="hidden-phone">${sconditionList.main_cat }</td>
										<td>${sconditionList.sub_cat }</td>
										<td><span class="label label-info label-mini">${sconditionList.scon_title }</span></td>
										<td>${sconditionList.brand }</td>
										<td>${sconditionList.product_name }</td>
										<td>${sconditionList.wish_price }</td>
										<td>${sconditionList.reg_date }</td>
										<td>
											<button class="btn btn-success btn-xs">
												<i class="fa fa-check"></i>
											</button>
											<button class="btn btn-primary btn-xs">
												<i class="fa fa-pencil"></i>
											</button>
											<button class="btn btn-danger btn-xs" OnClick="window.location='<%=request.getContextPath()%>/Dashio/deleteCondition?scon_no=${sconditionList.scon_no}'">
												<i class="fa fa-trash-o "></i>
											</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

				</div>
			</div>


			<div class="w3-center">
				<c:if test="${ startPage>bottomLine}">

					<a href="<%=request.getContextPath() %>/Dashio/sconlist?pageNum=${startPage - bottomLine}">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">

					<a href="<%=request.getContextPath() %>/Dashio/sconlist?pageNum=${i}">[${i}] </a>
				</c:forEach>

				<c:if test="${ endPage<pageCount}">

					<a href="<%=request.getContextPath() %>/Dashio/sconlist?pageNum=${startPage + bottomLine}">[다음]</a>
				</c:if>


			</div>
		</c:if>
	</div>
