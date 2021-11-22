package com.bms.cart.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class CartDto {

	private int cartId;
	private String memberId;
	private int goodsId;
	private int orderGoodsQty;
	private String goodsTitle;
	private int goodsSalesPrice;
	private int goodsDeliveryPrice;
	private String goodsFileName;
	private Date credate;
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getOrderGoodsQty() {
		return orderGoodsQty;
	}
	public void setOrderGoodsQty(int orderGoodsQty) {
		this.orderGoodsQty = orderGoodsQty;
	}
	public String getGoodsTitle() {
		return goodsTitle;
	}
	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}
	public int getGoodsSalesPrice() {
		return goodsSalesPrice;
	}
	public void setGoodsSalesPrice(int goodsSalesPrice) {
		this.goodsSalesPrice = goodsSalesPrice;
	}
	public int getGoodsDeliveryPrice() {
		return goodsDeliveryPrice;
	}
	public void setGoodsDeliveryPrice(int goodsDeliveryPrice) {
		this.goodsDeliveryPrice = goodsDeliveryPrice;
	}
	public String getGoodsFileName() {
		return goodsFileName;
	}
	public void setGoodsFileName(String goodsFileName) {
		this.goodsFileName = goodsFileName;
	}
	public Date getCredate() {
		return credate;
	}
	public void setCredate(Date credate) {
		this.credate = credate;
	}

}
