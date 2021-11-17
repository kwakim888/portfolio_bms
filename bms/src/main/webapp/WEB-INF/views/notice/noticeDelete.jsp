<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />	
<!DOCTYPE html>
<meta charset="utf-8">
<head>
<script>

	function check() {
		
	}

</script>
<style>
	td:first-child {
		text-align: center;
		font-weight: bold;
	}
</style>
</head>
<body>
	<form name="noticeUpdateform" action="${contextPath}/notice/noticeDelete.do" method="post" onsubmit="return check()">
			<h1>공지사항 삭제</h1>
			<br><br><br>
			<table class="table table-bordered table-hover">
				<tr>
					<td>공지사항 제목</td>
					<td><input name="noticeSubject" id="noticeSubject" value="${ndto.noticeSubject }" type="text" class="form-control"/></td>
				</tr>
				<tr>
					<td >작성자</td>
					<td>${ndto.memberId }</td>
				</tr>
				<tr>
					<td>등록날짜</td>
					<td><fmt:formatDate value="${ndto.noticeRegDate }" pattern="yyyy-MM-dd"/></td>
				</tr>
			</table>	
		<p align="right">
			<input type="hidden" name="noticeNum" value="${ndto.noticeNum }" />
			<input type="submit" value="삭제하기" class="btn btn-outline-danger btn-sm" />
		</p>
	</form>	
</body>
