package com.pas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pas.model.GoodsModel;
import com.pas.service.GoodsServiceImp;

@Controller
public class HomeController {
	
	@Autowired
	private GoodsServiceImp goodsService;
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Home Login");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/home/login");
		return mv;
	}
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Home Register");
		ModelAndView mv = new ModelAndView();
		
		//mv.addObject("list", "123456");
		mv.setViewName("/home/register");
		return mv;
	}
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Home Login");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/index");
		return mv;
	}
	@RequestMapping("/")
	public ModelAndView indexp(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Home Login");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/home/index");
		return mv;
	}
	@RequestMapping("")
	public ModelAndView indexpa(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Home Login");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/home/index");
		return mv;
	}
	
	@RequestMapping("/search")
	public ModelAndView search(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Home Login");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/home/search_list");
		
		if (this.isEmpty(request.getParameter("key"))) {
			mv.setViewName("/home/search_list");
			return mv;
		}
		String key = request.getParameter("key").trim();
		
		List<GoodsModel>  list = goodsService.getGoodsByName(key);
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping("/cart")
	public ModelAndView shoppingCart(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Home Login");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/home/shopping_cart");
		
		
		//mv.addObject("list", list);
		
		return mv;
	}
	
	private boolean isEmpty(String name) {
		if (name == null || name.trim().isEmpty()) {
			return true;
		}
		return false;
	}
}
