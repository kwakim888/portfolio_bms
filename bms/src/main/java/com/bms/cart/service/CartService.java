package com.bms.cart.service;

import java.util.List;

import com.bms.cart.dto.CartDto;

public interface CartService {
	
	public void insertCart(CartDto cdto) throws Exception;
	public List<CartDto> getAllCart() throws Exception;
	public void deleteCart(String[] data) throws Exception;
	public CartDto getOneCart(String[] data) throws Exception;

}
