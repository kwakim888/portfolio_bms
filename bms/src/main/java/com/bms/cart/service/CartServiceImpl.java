package com.bms.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.cart.dao.CartDao;
import com.bms.cart.dto.CartDto;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	
	@Override
	public void insertCart(CartDto cdto) throws Exception {
		cartDao.insertCart(cdto);
	}

	@Override
	public List<CartDto> getAllCart() throws Exception {
		return cartDao.getAllCart();
	}

}
