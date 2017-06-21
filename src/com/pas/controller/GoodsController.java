package com.pas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoodsController {
	
	@RequestMapping("/goods")  //跳转至首页
	public ModelAndView handleRequest1(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Output shop");
		System.out.println("---------------------------------------------");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("goods_detail");
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
	@RequestMapping("err")
	public String err(HttpServletRequest request,
			HttpServletResponse response,Model model) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Error .");
		
		model.addAttribute("er", "错误调用");
		
		return "admin/error";
	}
	@RequestMapping("erra")
	public String erra(HttpServletRequest request,
			HttpServletResponse response,Model model) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Error .");
		
		model.addAttribute("er", "错误调用");
		
		return test("admin/error");
		
		//return "admin/error";
	}
	
	private String test(String target){
		
		return target;
	}
	
	@RequestMapping("/suc")
	public ModelAndView success(HttpServletRequest request,
			HttpServletResponse response,Model model) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Success .");
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("target", "/admin/goods");
		mv.addObject("success", "插入成功");
		//mv.setViewName("redirect:/admin/goods");  //重定向
		mv.setViewName("/admin/success");
		
		return mv;
		//return "admin/error";
	}
	

}
