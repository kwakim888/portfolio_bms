<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
</head>
<body>
	<h3>공지사항 게시판</h3>
	<table class="list_view">
		<tbody align="center">
			<tr style="background:#8e00ff; color:#fff; height: 50px;">
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
				<td>등록날짜</td>
			</tr>
  			<c:choose>
    			<c:when test="${empty noticeList }">			
					<tr>
				       <td colspan="5" class="fixed"><strong>조회된 공지사항이 없습니다.</strong></td>
				    </tr>
			 	</c:when>
			 	<c:otherwise>
     				<c:forEach var="ndto" items="${noticeList}">
						<tr>       
							<td><strong>${ndto.noticeNum }</strong></td>
							<td>
								<a href="${contextPath}/notice/noticeInfo.do?noticeNum=${ndto.noticeNum }">
								    <strong>${ndto.noticeSubject } </strong>
								</a> 
							</td>
							<td><strong>${ndto.memberId }</strong></td>
							<td><strong>${ndto.noticeReadCount }</strong></td>
							<td><strong><fmt:formatDate value="${ndto.noticeRegDate }" pattern="yyyy-MM-dd"/></strong></td>
						</tr>
					</c:forEach>
				</c:otherwise>
  			</c:choose>	        
		</tbody>
	</table>
	<br>
	<c:if test="${memberId == 'admin' }">
		<div align="right">
			<input class="btn btn-indigo btn-sm" type="button" onclick="location.href='${contextPath}/notice/noticeWrite.do'" value="공지사항 쓰기">
		</div>
	</c:if>
</body>
</html>