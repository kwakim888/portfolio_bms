<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />	
<!DOCTYPE html>
<meta charset="utf-8">
<head>
<style>
	td:first-child {
		text-align: center;
		font-weight: bold;
	}
</style>
</head>
<body>
	<form name="noticeInfoform">
		<h1>공지사항 세부정보</h1>
		<br><br><br>
		<table class="table table-bordered table-hover">
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tr>
				<td>공지사항 제목</td>
				<td>${ndto.noticeSubject }</td>
			</tr>
			<tr>
				<td >작성자</td>
				<td>${ndto.memberId }</td>
			</tr>
			<tr>
				<td>등록날짜</td>
				<td><fmt:formatDate value="${ndto.noticeRegDate }" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${ndto.noticeContent};</td>
			</tr>
		</table>	
	</form>	
	<c:if test="${memberId == 'admin' }">
		<p align="right">
			  <input type="button" value="수정하기" class="btn btn-outline-danger btn-sm" onclick="location.href='${contextPath}/notice/noticeUpdate.do?noticeNum=${ndto.noticeNum }'">
			  <input type="button" value="삭제하기" class="btn btn-outline-danger btn-sm" onclick="location.href='${contextPath}/notice/noticeDelete.do?noticeNum=${ndto.noticeNum }'">
		</p>
	</c:if>
</body>
 