package com.bms.main;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bms.goods.service.GoodsService;

@Controller
@EnableAspectJAutoProxy
public class MainController {
	
	@Autowired
	private GoodsService goodsService;

	@RequestMapping(value= "/")
	public ModelAndView home() throws Exception{
		return new ModelAndView("redirect:/main/main.do");
	}
	
	
	@RequestMapping(value= "/main/main.do")
	public ModelAndView main(HttpServletRequest request,
							@RequestParam(name="bestb" , defaultValue="allb") String bestb,
							@RequestParam(name="steadyb" , defaultValue="alls") String steadyb,
							@RequestParam(name="newb" , defaultValue="alln") String newb) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/main/main");
		
		HttpSession session = request.getSession();
		session.setAttribute("sideMenu", "user");
		
		List<Map<String, Object>> bestseller   = goodsService.listGoods("bestseller");
		List<Map<String, Object>> newbook      = goodsService.listGoods("newbook");
		List<Map<String, Object>> steadyseller = goodsService.listGoods("steadyseller");
		
		if (bestb.equals("bestb")) {
			mv.addObject("bestseller" , bestseller);
		}
		else if (steadyb.equals("steadyb")) {
			mv.addObject("steadyseller" , steadyseller);
		}
		else if (newb.equals("newb")) {
			mv.addObject("newbook" , newbook);
		}
		else if (bestb.equals("allb") && steadyb.equals("alls") && newb.equals("alln")){
			mv.addObject("bestseller" , bestseller);
			mv.addObject("steadyseller" , steadyseller);
			mv.addObject("newbook" , newbook);
		}
		
		return mv;

	}
	
}
