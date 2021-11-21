<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html >
<html>
<head>
<meta   charset="utf-8">
<script>

	
	function change_price() {
		var price = document.getElementById("goodsSalesPrice_hidden").value;
		var qty = document.getElementById("cartGoodsQty").value;
		
		alert(qty);
		alert(price);
		
	}
	
	function delete_cart() {
		var send_data = 
		for (var i = 0; i < ${cartSize }; i++) {
			
			if (document.getElementsByName("selectCart")[i].checked == true) {
				var index = i + 1;
				alert(document.getElementById(index).value);
				
			}
			
		}
	
	}
	
	
</script>
</head>
<body>
	<c:set var="total" value="0" />
	<h3>장바구니</h3>
	<div class="clear"></div>
		<table class="list_view">
		<tbody align=center >
			<tr style="background:#33ff00" >
				<td>선택</td>
				<td class="fixed">번호</td>
				<td>상품이미지</td>
				<td>상품</td>
				<td>상품개수</td>
				<td class="fixed">등록일자</td>
				<td>금액</td>
				<td>배송비</td>
			</tr>
		   <c:choose>
		   		<c:when test="${empty myCartList }">			
					<tr>
				       <td colspan=8 class="fixed">
						  <strong>장바구니에 상품이 없습니다.</strong>
					   </td>
				     </tr>
				</c:when>
			 	<c:otherwise>
			    	<c:forEach var="cart" items="${myCartList }">
				 		<tr>       
							<td>
								<input type="checkbox" name="selectCart" id="selectCart">
							</td>
							<td>
						 		<strong>${cart.cartId }</strong>
						 		<input type="hidden" id="${cart.cartId }" value="${cart.goodsTitle }" />
							</td>
							<td>
								<img alt="상품 이미지" src="${contextPath}/thumbnails.do?goodsId=${cart.goodsId}&fileName=${cart.goodsFileName}">
							</td>
							<td>
						   		<strong>${cart.goodsTitle }</strong>
							</td>
							<td>
								<strong>${cart.cartGoodsQty }</strong>
							</td>
							<td>
						    	<strong>
							   		<fmt:formatDate value="${cart.credate }" pattern="yyyy-MM-dd"/>
							 	</strong>
							</td>
							<td>
								<strong><span id="goodsSalesPrice" >${cart.goodsSalesPrice * cart.cartGoodsQty }</span></strong>
								<input type="hidden" value="${cart.goodsSalesPrice * cart.cartGoodsQty }" id="goodsSalesPrice_hidden">
							</td>
							<td>
								<strong>${cart.goodsDeliveryPrice }</strong>
							</td>
						</tr>
						<c:set var="total" value="${total + cart.goodsSalesPrice * cart.cartGoodsQty + cart.goodsDeliveryPrice }" />
					</c:forEach>
				</c:otherwise>
		  	</c:choose>
		</tbody>
		</table>
	<div class="clear"></div>
	<h3 style="color: black">총 합계 : ${total }</h3>
	<br><br>
		<div align="right">
			<input class="btn btn-success btn-sm" type="button" onclick="location.href='${contextPath}/cart/orderCart.do'" value="장바구니 결제하기">
			<input type="button" value="삭제하기" class="btn btn-outline-danger btn-sm" onclick="delete_cart();" id="delete_cart" />			
		</div>
</body>
</html>