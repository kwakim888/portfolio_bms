<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<html>
<script>
	
	function bt_bestseller() {
		var form = document.createElement("form");
		form.setAttribute("method" , "get");
		form.setAttribute("action" , "${contextPath}/main/main.do");
		
		var hidden = document.createElement("input");
		hidden.setAttribute("type" , "hidden");
		hidden.setAttribute("name" , "bestb");
		hidden.setAttribute("value" , "bestb");
		form.appendChild(hidden);
		
		document.body.appendChild(form);
		form.submit();
	}
	
	function bt_steadyseller() {
		var form = document.createElement("form");
		form.setAttribute("method" , "get");
		form.setAttribute("action" , "${contextPath}/main/main.do");
		
		var hidden = document.createElement("input");
		hidden.setAttribute("type" , "hidden");
		hidden.setAttribute("name" , "steadyb");
		hidden.setAttribute("value" , "steadyb");
		form.appendChild(hidden);
		
		document.body.appendChild(form);
		form.submit();
	}
	
	function bt_newbook() {
		var form = document.createElement("form");
		form.setAttribute("method" , "get");
		form.setAttribute("action" , "${contextPath}/main/main.do");
		
		var hidden = document.createElement("input");
		hidden.setAttribute("type" , "hidden");
		hidden.setAttribute("name" , "newb");
		hidden.setAttribute("value" , "newb");
		form.appendChild(hidden);
		
		document.body.appendChild(form);
		form.submit();
	}
	
	function bt_req_login() {
		alert("로그인 후 이용 가능합니다.");
		location.href = "${contextPath}/main/main.do"
	}
	
</script>
<body>
	<nav>
	 <ul>
	  <c:choose>
		<c:when test="${sideMenu == 'adminMode'}">
		   <li>
				<h3>주요기능</h3>
				<ul>
					<li><a href="${contextPath}/admin/member/adminMemberMain.do">회원 관리</a></li>
					<li><a href="${contextPath}/admin/goods/adminGoodsMain.do">상품 관리</a></li>
					<li><a href="${contextPath}/admin/order/adminOrderMain.do">주문 관리</a></li>
				</ul>
			</li>
			<br><br><br>
		</c:when>
		<c:when test="${sideMenu == 'myPage'}">
			<li>
				<h3>정보내역</h3>
				<ul>
					<li><a href="${contextPath}/mypage/listMyOrderHistory.do">주문내역 조회</a></li>
					<li><a href="${contextPath}/mypage/myDetailInfo.do">내 정보 수정</a></li>
					<li><a href="${contextPath}/main/main.do">메인화면으로 이동</a></li>
				</ul>
			</li>
			<br><br><br>
		</c:when>
		<c:otherwise>
			<li>
				<h3>목록 보기</h3>
				<ul>
					<li><a href="#" onclick="bt_bestseller();">베스트셀러</a></li>
					<li><a href="#" onclick="bt_steadyseller();">스테디셀러</a></li>
					<li><a href="#" onclick="bt_newbook();">신간</a></li>
				</ul>
			</li>
			<br><br><br>
		 </c:otherwise>
		</c:choose>	
	  </ul>
	</nav>
	<div class="clear"></div>
	<c:choose>
		<c:when test="${isLogOn == true and not empty memberInfo }">
			<div id="notice" align="center">
				<h1><a href="${contextPath}/notice/noticeList.do"><img width="190" height="80" src="${contextPath}/resources/image/side_notice.png"></a></h1>
			</div>
		</c:when>
		<c:otherwise>
			<div id="notice" align="center">
				<h1><a href="#" onclick="bt_req_login();"><img width="190" height="80" src="${contextPath}/resources/image/side_notice.png"></a></h1>
			</div>
		</c:otherwise>
	</c:choose>
	<div id="banner">
		<a href="#"><img width="190" height="163" src="${contextPath}/resources/image/n-pay.jpg"> </a>
	</div>
	<div id="banner">
		<a href="#"><img width="190" height="362" src="${contextPath}/resources/image/side_banner1.jpg"></a>
	</div>
	<div id="banner">
		<a href="#"><img width="190" height="104" src="${contextPath}/resources/image/call_center_logo.jpg"></a>
	</div>
	<div id="banner">
		<a href="#"><img width="190" height="69" src="${contextPath}/resources/image/QnA_logo.jpg"></a>
	</div>
</body>
</html>