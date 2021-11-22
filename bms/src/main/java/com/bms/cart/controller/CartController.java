package com.bms.cart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bms.cart.dto.CartDto;
import com.bms.cart.service.CartService;
import com.bms.member.dto.MemberDto;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/insertCart.do" , method=RequestMethod.POST)
	public String insertCart(CartDto cdto) throws Exception {
		
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
	public ModelAndView orderCart(@RequestParam("selectCartId") String selectCartId, HttpServletRequest request) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/cart/orderCart");
		
		String[] data = selectCartId.split("/");
		
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		CartDto cartDto = cartService.getOneCart(data);
		MemberDto memberInfo = (MemberDto)session.getAttribute("memberInfo");
		
		session.setAttribute("goodsInfo", cartDto);
		session.setAttribute("orderer", memberInfo);
		mv.addObject("goodsInfo", cartDto);
		
		return mv;
	}
	
	@RequestMapping(value="/deleteCart.do")
	public String deleteCart(@RequestParam("selectCartId") String selectCartId) throws Exception {
		
		String[] data = selectCartId.split("/");
		
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
		
		cartService.deleteCart(data);
		return "redirect:/cart/cartList.do";
	}
	
}
