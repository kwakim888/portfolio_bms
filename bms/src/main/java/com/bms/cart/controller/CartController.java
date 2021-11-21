package com.bms.cart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		
		System.out.println(cdto.getGoodsId());
		System.out.println(cdto.getCartGoodsQty());
		System.out.println(cdto.getMemberId());
		System.out.println(cdto.getGoodsTitle());
		System.out.println(cdto.getGoodsSalesPrice());
		System.out.println(cdto.getGoodsFileName());
		System.out.println(cdto.getGoodsDeliveryPrice());
		
		cartService.insertCart(cdto);
		
		return "redirect:/cart/cartList.do";
	}
	
	@RequestMapping(value="/cartList.do")
	public String cartList(Model model, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		session = request.getSession();
		session.setAttribute("sideMenu", "myPage");
		
		List<CartDto> myCartList = cartService.getAllCart();
		int cartSize = myCartList.size();
		
		model.addAttribute("myCartList" , myCartList);
		model.addAttribute("cartSize" , cartSize);
		
		return "/cart/cartListMain";
		
	}
	
	@RequestMapping(value="/orderCart.do")
	public String orderCart() throws Exception {
		
		
		return "";
	}
	
	@RequestMapping(value="deleteCart.do")
	public String deleteCart() throws Exception {
		return "";
	}
	
}
