package com.pas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	//登录
	@RequestMapping("/admin/login")
	public ModelAndView adminLogin(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Login");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/login");
		return mv;
	}
	
	//首页
	@RequestMapping("/admin")
	public ModelAndView admin(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Login");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/index");
		return mv;
	}
	
	//用户列表
	@RequestMapping("/admin/user")
	public ModelAndView adminUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Login");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/user_list");
		return mv;
	}
	
	//商品列表
	@RequestMapping("/admin/goods")
	public ModelAndView adminGoods(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Login");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/goods_list");
		return mv;
	}
	
	//添加商品
	@RequestMapping("/admin/goods/add")
	public ModelAndView adminGoodsAdd(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Login");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/goods_add");
		return mv;
	}
	
	//管理员列表
	@RequestMapping("/admin/manager")
	public ModelAndView adminManager(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Login");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/admin_list");
		return mv;
	}
	
	//管理员添加
	@RequestMapping("/admin/manager/add")
	public ModelAndView adminManagerAdd(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Login");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/admin_add");
		return mv;
	}
	
	//所有订单
	@RequestMapping("/admin/orders")
	public ModelAndView adminOrders(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Login");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/index");
		return mv;
	}
	
}
