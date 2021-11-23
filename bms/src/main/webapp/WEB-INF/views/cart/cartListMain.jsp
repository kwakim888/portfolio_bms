<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html >
<html>
<head>
<meta   charset="utf-8">
<script>

	
	function order_cart() {
		
		var cnt = 0;
		var isDelete = false;
		for (var i = 0; i < ${cartSize }; i++) {
			if (document.getElementsByName("selectCart")[i].checked == true) {
				cnt++;
				isDelete = true;
			}
		}
		
		if (cnt > 1) {
			alert("1개만 선택해주세요.");
			return;
		}
		
		if (!isDelete) {
			alert("주문할 항목을 선택해주세요.");
			return;
		}
		
		if (isDelete) {
			// for문 안에 var ""를 넣어서 계속 리셋되어진다 그래서 빈칸 그래서 밖으로 빼줘야한다.
			var send_data = "";
			for (var i = 0; i < ${cartSize }; i++) {
				if (document.getElementsByName("selectCart")[i].checked == true) {
					send_data += document.getElementById(i).value + "/";
				}
			}
			location.href = "${contextPath}/cart/orderCart.do?selectCartId="+send_data;
		}
		
	}
	
	function delete_cart() {
		
		var cnt = 0;
		var isDelete = false;
		for (var i = 0; i < ${cartSize }; i++) {
			if (document.getElementsByName("selectCart")[i].checked == true) {
				cnt++;
				isDelete = true;
			}
		}
		
		if (!isDelete) {
			alert("삭제할 항목을 선택해주세요.");
			return;
		}
		
		if (isDelete) {
			// for문 안에 var ""를 넣어서 계속 리셋되어진다 그래서 빈칸 그래서 밖으로 빼줘야한다.
			var send_data = "";
			for (var i = 0; i < ${cartSize }; i++) {
				if (document.getElementsByName("selectCart")[i].checked == true) {
					send_data += document.getElementById(i).value + "/";
				}
			}
			alert("삭제되었습니다.")
			location.href = "${contextPath}/cart/deleteCart.do?selectCartId="+send_data;
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
			    	<c:forEach var="cart" items="${myCartList }" varStatus="status" >
				 		<tr>       
							<td>
								<input type="checkbox" name="selectCart" id="selectCart">
							</td>
							<td>
						 		<strong>${status.count }</strong>
						 		<input type="hidden" id="${status.index }" value="${cart.cartId }" />
							</td>
							<td>
								<img alt="상품 이미지" src="${contextPath}/thumbnails.do?goodsId=${cart.goodsId}&fileName=${cart.goodsFileName}">
							</td>
							<td>
						   		<strong>${cart.goodsTitle }</strong>
							</td>
							<td>
								<strong>${cart.orderGoodsQty }</strong>
							</td>
							<td>
						    	<strong>
							   		<fmt:formatDate value="${cart.credate }" pattern="yyyy-MM-dd"/>
							 	</strong>
							</td>
							<td>
								<strong><span id="goodsSalesPrice" >${cart.goodsSalesPrice * cart.orderGoodsQty }</span></strong>
								<input type="hidden" value="${cart.goodsSalesPrice * cart.orderGoodsQty }" id="goodsSalesPrice_hidden">
							</td>
							<td>
								<strong>${cart.goodsDeliveryPrice }</strong>
							</td>
						</tr>
						<c:set var="total" value="${total + cart.goodsSalesPrice * cart.orderGoodsQty + cart.goodsDeliveryPrice }" />
					</c:forEach>
				</c:otherwise>
		  	</c:choose>
		</tbody>
		</table>
	<div class="clear"></div>
	<h3 style="color: black">총 합계 : ${total }</h3>
	<br><br>
		<div align="right">
			<input class="btn btn-success btn-sm" type="button" onclick="order_cart();" value="장바구니 결제하기">
			<input type="button" value="삭제하기" class="btn btn-outline-danger btn-sm" onclick="delete_cart();" id="delete_cart" />			
		</div>
</body>
</html>