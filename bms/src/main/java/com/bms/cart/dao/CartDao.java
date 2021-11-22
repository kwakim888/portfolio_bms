package com.bms.cart.dao;

import java.util.List;

import com.bms.cart.dto.CartDto;

public interface CartDao {
	
	public void insertCart(CartDto cdto) throws Exception;
	public List<CartDto> getAllCart() throws Exception;
	public void deleteCart(String[] data) throws Exception;
	public CartDto getOneCart(String[] data) throws Exception;
	
}
