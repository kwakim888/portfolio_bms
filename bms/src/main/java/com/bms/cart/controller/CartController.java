package com.bms.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bms.cart.dto.CartDto;
import com.bms.cart.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/insertCart.do" , method=RequestMethod.POST)
	public String insertCart(CartDto cdto) throws Exception {
		
		System.out.println(cdto.getCartGoodsQty() + "," + cdto.getGoodsId() + "," + cdto.getMemberId()); // 1, 2, qwe
		
		cartService.insertCart(cdto);
		
		
		return "redirect:/cart/cartList.do";
	}
	
	@RequestMapping(value="/cartList.do")
	public String cartList(Model model) throws Exception {
		
		cartService.getAllCart();
		
		return "/cart/cartListMain";
	}
	
	@RequestMapping(value="/orderCart.do")
	public String orderCart() throws Exception {
		
		
		return "";
	}
	
	

}
