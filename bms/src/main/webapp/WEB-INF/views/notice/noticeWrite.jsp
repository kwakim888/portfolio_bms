<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />	
<!DOCTYPE html>
<meta charset="utf-8">
<head>
<script>

	function check() {
		
		var subject = document.noticeform.noticeSubject;
		var writer = document.noticeform.memberId;
		var date = document.noticeform.noticeRegDate;
		
		if (subject.value == "") {
			alert("제목을 작성해주세요");
			subject.focus();
			return false;
		}
		
		if (writer.value == "") {
			alert("작성자를 작성해주세요");
			writer.focus();
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
	<form name="noticeform" action="${contextPath}/notice/noticeWrite.do" method="post" onsubmit="return check()">
		<h1>공지사항 작성</h1>
		<br><br><br>
			<table class="table table-bordered table-hover">
				<tr>
					<td>공지사항 제목</td>
					<td><input name="noticeSubject" id="noticeSubject" type="text" class="form-control"/></td>
				</tr>
				<tr>
					<td >작성자</td>
					<td><input name="memberId" id="memberId" type="text" class="form-control" value="admin"/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea rows="50" cols="80" class="form-control" id="noticeContent" name="noticeContent"></textarea>
				    	<script>CKEDITOR.replace('noticeContent');</script>
				    </td>
				</tr>
			</table>	
			<p align="right">
				  <input type="submit" value="작성하기" class="btn btn-outline-danger btn-sm">
			</p>
	</form>	
</body>
 