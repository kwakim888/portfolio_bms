<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html >
<html>
<head>
<meta   charset="utf-8">
<script>


</script>
</head>
<body>
	<h3>장바구니</h3>
	<div class="clear"></div>
		<table class="list_view">
		<tbody align=center >
			<tr style="background:#33ff00" >
				<td>선택</td>
				<td class="fixed">번호</td>
				<td>상품번호</td>
				<td>상품개수</td>
				<td class="fixed">등록일자</td>
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
			    	<c:forEach var="cart" items="${myCartList }" varStatus="i">
				 		<tr>       
							<td>
								<input type="checkbox" name="selectCart" id="selectCart">
							</td>
							<td>
						 		<strong>${cart.cartId }</strong> 
							</td>
							<td>
						   		<strong>${cart.goodsTitle }</strong>
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
	<br><br>
		<div align="right">
			<input class="btn btn-success btn-sm" type="button" onclick="location.href='${contextPath}/cart/orderCart.do'" value="장바구니 결제하기">
		</div>
</body>
</html>