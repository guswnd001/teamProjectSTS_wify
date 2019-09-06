<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



   
<div class="row">


<div class="col-md-12 mt">


<c:if test="${count==0 }">
<div class="col-lg-4 col-md-4 col-sm-4 mb" style="margin-left: 35%;">
<div class="weather-3 pn centered" style="background: #4ECDC4;">
<i class="fa fa-frown-o" style="margin-top: 40px;"></i>
<h3 style="margin-top: 50px; color: white;">게시글이 없습니다.</h3>
<a href="${project }/board/write?pageNum=${pageNum}" class="btn btn-round btn-primary" style="margin-left: 10px;">글쓰기</a>
</div>
</div>
   
   
   
   </c:if>


<c:if test="${count>0 }">
<div class="content-panel">
<table class="table table-hover">

<h4><i class="fa fa-angle-right" withd ="50%"></i> 공지사항 </h4>

<hr>

<a href="${project }/board/write?pageNum=${pageNum}" class="btn btn-round btn-primary" style="margin-left: 10px;">글쓰기</a>


         <thead>
         <tr>
            <td align="center" width="50">번호</td>
            <td align="center" width="50">분류</td>
            <td align="center" width="250">제 목</td>
            <td align="center" width="100">작성자</td>
            <td align="center" width="150">작성일</td>
            <td align="center" width="50">조 회</td>
         </tr>
         </thead>
         <tbody>
         <c:forEach var="article" items="${qnaList }">
            <tr height="30">
               <td align="center" width="50"><c:out value="${number}" /></td>
               
               <td align="center" width="50">${article.cat_name}</td>
               
               
               <c:set var="number" value="${number-1 }" />
               <td width="250" align="center" >
               <c:if test="${article.re_level > 0 }">

                     <img src="<%=request.getContextPath() %>/images/level.gif"
                        width="${5*article.re_level}" height="16">
                     <img src="<%=request.getContextPath()%>/images/re.gif">
                  </c:if>
                  <a href="${project }/board/content?num=${article.num}&pageNum=${pageNum}">${article.subject}</a>

                  </td>
               <td align="center" width="100">${article.writer}</td>





               <td align="center" width="150">
               <fmt:formatDate type="date" value="${article.reg_date}"/></td>
               <td align="center" width="50">${article.readcount}</td>
            </tr>
            
         </c:forEach>
         </tbody>


      </table>
      <h4><div class="w3-center"  align="center">
         <c:if test="${ startPage>bottomLine}">
            <a href="list?pageNum=${startPage - bottomLine}">[이전]</a>
         </c:if>
         <c:forEach var="i" begin="${startPage }" end="${endPage }">
            <a href="list?pageNum=${i}">[${i}] </a>
         </c:forEach>
         <c:if test="${ endPage<pageCount}">
            <a href="list?pageNum=${startPage + bottomLine}">[다음]</a>
         </c:if>
      </div></h4>
      </div>
      </c:if>
      
      </div>
      </div>
   
</body>
</html>