package com.pas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
	@RequestMapping("/login")
	public ModelAndView handleRequest1(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Home Login");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/login");
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
		mv.setViewName("/admin/index");
		return mv;
	}
	@RequestMapping("")
	public ModelAndView indexpa(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Home Login");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/index");
		return mv;
	}
}
