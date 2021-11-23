package com.bms.cart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.bms.order.dto.OrderDto;
import com.bms.order.service.OrderService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
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
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		CartDto cdto = cartService.getOneCart(data);
		Map<String, Object> goodsInfo = new HashMap<String, Object>();
		goodsInfo.put("cartId", cdto.getCartId());
		goodsInfo.put("memberId", cdto.getMemberId());
		goodsInfo.put("goodsId", cdto.getGoodsId());
		goodsInfo.put("orderGoodsQty", cdto.getOrderGoodsQty());
		goodsInfo.put("goodsTitle", cdto.getGoodsTitle());
		goodsInfo.put("goodsSalesPrice", cdto.getGoodsSalesPrice());
		goodsInfo.put("goodsDeliveryPrice", cdto.getGoodsDeliveryPrice());
		goodsInfo.put("goodsFileName", cdto.getGoodsFileName());
		goodsInfo.put("credate", cdto.getCredate());
		
		MemberDto memberInfo = (MemberDto)session.getAttribute("memberInfo");
		
		session.setAttribute("goodsInfo", goodsInfo);
		session.setAttribute("orderer", memberInfo);
		mv.addObject("goodsInfo", goodsInfo);
		
		return mv;
	}
	
	@RequestMapping(value="/payToOrderGoods.do")
	public ModelAndView payToOrderGoods(@RequestParam Map<String, String> receiverMap , HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/order/payToOrderGoods");
		
		HttpSession session = request.getSession();
		Map<String,Object> goodsInfo= (Map<String,Object>)session.getAttribute("goodsInfo");
		MemberDto memberDto = (MemberDto)session.getAttribute("orderer");
		String memberId =  "";
		if (memberDto != null) 
			memberId = memberDto.getMemberId();
		
		String ordererName = "";
		if (memberDto != null)
			ordererName = memberDto.getMemberName();
		
		String ordererHp = memberDto.getHp1() + "-" + memberDto.getHp2() + "-" + memberDto.getHp3();
		
		
		OrderDto orderDto = new OrderDto();
		orderDto.setMemberId(memberId);
		orderDto.setOrdererName(ordererName);
		orderDto.setGoodsId(Integer.parseInt(String.valueOf(goodsInfo.get("goodsId"))));
		orderDto.setGoodsTitle((String)goodsInfo.get("goodsTitle"));
		orderDto.setGoodsSalesPrice(Integer.parseInt(String.valueOf(goodsInfo.get("goodsSalesPrice"))));
		orderDto.setOrderGoodsQty(Integer.parseInt(String.valueOf(goodsInfo.get("orderGoodsQty"))));
		orderDto.setReceiverName(receiverMap.get("receiverName"));
		orderDto.setReceiverHp1(receiverMap.get("receiverHp1"));
		orderDto.setReceiverHp2(receiverMap.get("receiverHp2"));
		orderDto.setReceiverHp3(receiverMap.get("receiverHp3"));
		orderDto.setReceiverTel1(receiverMap.get("receiverTel1"));
		orderDto.setReceiverTel2(receiverMap.get("receiverTel2"));
		orderDto.setReceiverTel3(receiverMap.get("receiverTel3"));
		orderDto.setDeliveryAddress(receiverMap.get("deliveryAddress"));
		
		if (receiverMap.get("deliveryMessage") == null) orderDto.setDeliveryMessage("");
		else	orderDto.setDeliveryMessage(receiverMap.get("deliveryMessage"));
		
		orderDto.setDeliveryMethod(receiverMap.get("deliveryMethod"));
		orderDto.setGiftWrapping(receiverMap.get("giftWrapping"));
		orderDto.setPayMethod(receiverMap.get("payMethod"));
		orderDto.setCardComName(receiverMap.get("cardComName"));
		orderDto.setCardPayMonth(receiverMap.get("cardPayMonth"));
		orderDto.setPayOrdererHpNum(receiverMap.get("payOrdererHpNum"));	
		orderDto.setOrdererHp(ordererHp);
		
	    orderService.addNewOrder(orderDto);
		mv.addObject("myOrderInfo",receiverMap);
		mv.addObject("goodsInfo",goodsInfo);
		
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
