package com.pas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoodsController {
	
	@RequestMapping("/goods")
	public ModelAndView handleRequest1(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Output shop");
		System.out.println("---------------------------------------------");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("goods_detail.jsp");
		return mv;
	}
	
	@RequestMapping("/goods/{id}")
	public ModelAndView getUser(@PathVariable("id") long id) {  
        System.out.println("Fetching User with id " + id);  
        ModelAndView mv = new ModelAndView();
		mv.setViewName("goods_detail");
        return mv;
    } 
	
	@RequestMapping("/good/{id}")
	public String getUsera(@PathVariable("id") long id) {  
        System.out.println("Fetching User with id " + id);  
		//mv.setViewName("goods_detail	");
        return "goods_detail";
    } 
	@RequestMapping("/good.pa")
	public String getUseraa() {  
		//mv.setViewName("goods_detail	");
        return "goods_detail";
    } 
}
