<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />	
<!DOCTYPE html>
<meta charset="utf-8">
<head>
<script>

	function check() {
	
		var subject = document.noticeUpdateform.noticeSubject;
		var content = document.noticeUpdateform.noticeContent;
		
		if (subject.value == "") {
			alert("제목을 작성해주세요");
			subject.focus();
			return false;
		}
		
		if (content.value == "") {
			alert("내용을 작성해주세요");
			content.focus();
			return false;
		}
		
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
	<form name="noticeUpdateform" action="${contextPath}/notice/noticeUpdate.do" method="post" onsubmit="return check()">
			<h1>공지사항 수정</h1>
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
				<tr>
					<td>내용</td>
					<td>
						<textarea rows="50" cols="80" id="noticeContent" name="noticeContent">${ndto.noticeContent }</textarea>
				    	<script>CKEDITOR.replace('noticeContent');</script>
				    </td>
				</tr>
			</table>	
		<p align="right">
			<input type="hidden" name="noticeNum" value="${ndto.noticeNum }" />
			<input type="submit" value="수정하기" class="btn btn-outline-danger btn-sm" />
		</p>
	</form>	
</body>
 