<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html >
<html>
<head>
<meta   charset="utf-8">
<script>

	$().ready(function(){
		
		$("#getSearchKeyWord").click(function(){
			var search_condition = $("#search_condition").val();
			var searchKeyWord = $("#searchKeyWord").val();
			var url = "${contextPath}/mypage/getSearchWord.do?";
				url += "search_condition=" + search_condition;
				url += "&searchKeyWord=" + searchKeyWord;
			location.href=url;
		});
			
		
	});
	

	function search_order_history(fixedSearchPeriod){
		
		var formObj = document.createElement("form");
		
		var i_fixedSearch_period = document.createElement("input");
		i_fixedSearch_period.name = "fixedSearchPeriod";
		i_fixedSearch_period.value = fixedSearchPeriod;
	    
		formObj.appendChild(i_fixedSearch_period);
	    
		document.body.appendChild(formObj); 
	    
		formObj.method = "get";
	    formObj.action = "${contextPath}/mypage/listMyOrderHistory.do";
	    formObj.submit();
	    
	}
	
	function fn_cancel_order(orderId){
		
		var answer = confirm("주문을 취소하시겠습니까?");
		
		if (answer) {
		    location.href = "${contextPath}/mypage/cancelMyOrder.do?orderId=" + orderId;
		}
		
	}

</script>
</head>
<body>
	<h3>주문 배송 조회</h3>
	<div class="clear"></div>
		<table class="list_view">
		<tbody align=center >
			<tr style="background:#33ff00" >
				<td>선택</td>
				<td class="fixed">번호</td>
				<td>상품번호</td>
				<td>상품개수</td>
				<td class="fixed">주문일자</td>
			</tr>
		   <c:choose>
		   		<c:when test="${empty myOrderHistList }">			
					<tr>
				       <td colspan=8 class="fixed">
						  <strong>장바구니에 상품이 없습니다.</strong>
					   </td>
				     </tr>
				</c:when>
			 	<c:otherwise> 
			    	<c:forEach var="cart" items="${myCartList }" varStatus="i">
				 		<tr>       
							<td>
								<input type="checkbox" name="selectCart" id="selectCart">
							</td>
							<td>
						 		<strong>${cart.cartId }</strong> 
							</td>
							<td>
						   		<strong>${cart.goodsId }</strong>
							</td>
							<td>
						  		<strong>${cart.cartGoodsQty }(개)</strong>
							</td>
							<td>
						    	<strong>
							   		<fmt:formatDate value="${cart.credate }" pattern="yyyy-MM-dd"/>
							 	</strong>
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
		  	</c:choose>			   
		</tbody>
		</table>
	<div class="clear"></div>
		<div align="right">
			<input class="btn btn-indigo btn-sm" type="button" onclick="location.href='${contextPath}/cart/orderCart.do'" value="공지사항 쓰기">
		</div>
</body>
</html>