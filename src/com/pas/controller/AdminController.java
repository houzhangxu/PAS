package com.pas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pas.model.GoodsModel;
import com.pas.service.GoodsService;
import com.pas.service.GoodsServiceImp;
import com.pas.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private GoodsServiceImp gs;
	
	
	//首页
	@RequestMapping("")
	public ModelAndView admin(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Login");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/index");
		return mv;
	}
	
	//登录
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Login");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/login");
		return mv;
	}
	

	
	//用户列表
	@RequestMapping("/user")
	public ModelAndView user(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch User");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/user_list");
		return mv;
	}
	
	//商品列表
	@RequestMapping("/goods")
	public ModelAndView goods(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Goods");
		ModelAndView mv = new ModelAndView();


		List<GoodsModel> list = gs.getAllGoods();
		
		
		mv.addObject("list", list);
		mv.setViewName("/admin/goods_list");
		return mv;
	}
	
	//添加商品
	@RequestMapping(path="/goods/add",method=RequestMethod.GET)
	public ModelAndView goodsAdd(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Goods Add");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/goods_add");
		return mv;
	}
	
	//添加商品
	@RequestMapping(path="/goods/doadd",method={RequestMethod.POST})
	public ModelAndView goodsDoAdd(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		ModelAndView mv = new ModelAndView();
		//request.setCharacterEncoding("UTF-8");
		
		if(this.isEmpty(request.getParameter("goods_name"))){
			mv.setViewName("/admin/error");
			mv.addObject("er", "商品名称未输入");
			return mv;
		}
		
		if(this.isEmpty(request.getParameter("goods_main"))){
			mv.setViewName("/admin/error");
			mv.addObject("er", "商品详情未输入");
			return mv;
		}
		
		if(this.isEmpty(request.getParameter("price"))){
			mv.setViewName("/admin/error");
			mv.addObject("er", "价格未输入");
			return mv;
		}
		
		if(this.isEmpty(request.getParameter("total"))){
			mv.setViewName("/admin/error");
			mv.addObject("er", "库存未输入");
			return mv;
		}
		
		String name = request.getParameter("goods_name").trim();
		String main = request.getParameter("goods_main").trim();
		double price = 0;
		double total = 0;
		
		try {
			price = Double.parseDouble(request.getParameter("price"));
		} catch (Exception e) {
			// TODO: handle exception
			mv.setViewName("/admin/error");
			mv.addObject("er", "价格输入不合法");
			return mv;
		}
		
		try {
			total = Double.parseDouble(request.getParameter("total"));
		} catch (Exception e) {
			// TODO: handle exception
			mv.setViewName("/admin/error");
			mv.addObject("er", "库存输入不合法");
			return mv;
		}
		
		GoodsModel gm = new GoodsModel();
		gm.setGoods_name(name); //设置名称
		gm.setGoods_main(main);  //设置详情
		gm.setPrice(price);  //设定价格
		gm.setTotal(total);  //设定库存
		gm.setGoods_type(1);  //设定商品类型
		gm.setCreator(1);  //设定创建者
		gm.setCreate_time(new Date().getTime());
		
		
		
		System.out.println("Fetch Goods DoAdd");
		System.out.println(name);
		System.out.println(main);
		System.out.println(price);
		System.out.println(total);
		
		try{
			gs.addGoods(gm);
		}catch (Exception e) {
			// TODO: handle exception
			mv.setViewName("/admin/error");
			mv.addObject("er", "商品添加失败");
			return mv;
		}
		//mv.addObject("list", "123456");
		//mv.setViewName("/admin/goods_add");
		//response.sendRedirect("/PAS/admin/goods");
		mv.addObject("target", "/PAS/admin/goods");
		//mv.setViewName("redirect:/admin/goods");  //重定向
		mv.addObject("success", "商品添加成功");
		mv.setViewName("/admin/success");
		return mv;
	}
	
	//修改商品页面
	@RequestMapping(path="/goods/update/{id}",method=RequestMethod.GET)
	public ModelAndView goodsUpdate(@PathVariable("id") int id,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//			String username = request.getParameter("username");
		System.out.println("Fetch Goods Update "+id);
		ModelAndView mv = new ModelAndView();
		
		
		GoodsModel gm = gs.findGoods(id);
		
		mv.addObject("goods", gm);
		//mv.addObject("list", "123456");
		
		mv.setViewName("/admin/goods_update");
		return mv;
	}
	
	
	//修改商品操作
	@RequestMapping(path="/goods/doupdate",method={RequestMethod.POST})
	public ModelAndView goodsDoUpdate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//			String username = request.getParameter("username");
		
		ModelAndView mv = new ModelAndView();
		//request.setCharacterEncoding("UTF-8");
		
		if(this.isEmpty(request.getParameter("goods_name"))){
			mv.setViewName("/admin/error");
			mv.addObject("er", "商品名称未输入");
			return mv;
		}
		
		if(this.isEmpty(request.getParameter("goods_main"))){
			mv.setViewName("/admin/error");
			mv.addObject("er", "商品详情未输入");
			return mv;
		}
		
		if(this.isEmpty(request.getParameter("price"))){
			mv.setViewName("/admin/error");
			mv.addObject("er", "价格未输入");
			return mv;
		}
		
		if(this.isEmpty(request.getParameter("total"))){
			mv.setViewName("/admin/error");
			mv.addObject("er", "库存未输入");
			return mv;
		}
		
		if(this.isEmpty(request.getParameter("g_id"))){
			mv.setViewName("/admin/error");
			mv.addObject("er", "无法定位更新行");
			return mv;
		}
		
		String name = request.getParameter("goods_name").trim();
		String main = request.getParameter("goods_main").trim();
		double price = 0;
		double total = 0;
		int g_id = 0;
		
		try {
			price = Double.parseDouble(request.getParameter("price"));
		} catch (Exception e) {
			// TODO: handle exception
			mv.setViewName("/admin/error");
			mv.addObject("er", "价格输入不合法");
			return mv;
		}
		
		try {
			total = Double.parseDouble(request.getParameter("total"));
		} catch (Exception e) {
			// TODO: handle exception
			mv.setViewName("/admin/error");
			mv.addObject("er", "库存输入不合法");
			return mv;
		}
		
		try {
			g_id = Integer.parseInt(request.getParameter("g_id"));
		} catch (Exception e) {
			// TODO: handle exception
			mv.setViewName("/admin/error");
			mv.addObject("er", "gid不合法");
			return mv;
		}
		
		
		GoodsModel gm = new GoodsModel();
		gm.setG_id(g_id);
		gm.setGoods_name(name); //设置名称
		gm.setGoods_main(main);  //设置详情
		gm.setPrice(price);  //设定价格
		gm.setTotal(total);  //设定库存
		gm.setCreator(1);  //设定创建者
		gm.setCreate_time(new Date().getTime());
		
		try{
			gs.updateGoods(gm);
		}catch (Exception e) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "商品修改失败");
			return mv;
		}
		
		mv.addObject("target", "/PAS/admin/goods");
		mv.addObject("success", "商品修改成功");
		mv.setViewName("/admin/success");
		return mv;
	}
	
	//删除商品
	@RequestMapping("/goods/dodelete/{id}")
	public ModelAndView goodsDodelete(@PathVariable("id") int id,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch delete");
		ModelAndView mv = new ModelAndView();
		
		int g_id = id;
		
		if(g_id < 1){
			mv.setViewName("/admin/error");
			mv.addObject("er", "商品不存在");
			return mv;
		}
		
		try{
			gs.deleteGoods(g_id);
		}catch (Exception e) {
			
			mv.setViewName("/admin/error");
			mv.addObject("er", "商品删除失败");
			return mv;
		}
		
		mv.addObject("target", "/PAS/admin/goods");
		mv.addObject("success", "商品删除成功");
		mv.setViewName("/admin/success");
		
		return mv;
	}
	
	//管理员列表
	@RequestMapping("/manager")
	public ModelAndView manager(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Manager");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/admin_list");
		return mv;
	}
	
	//管理员添加
	@RequestMapping("/manager/add")
	public ModelAndView managerAdd(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Manager Add");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/admin_add");
		return mv;
	}
	
	//所有订单
	@RequestMapping("/orders")
	public ModelAndView adminOrders(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Order");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/index");
		return mv;
	}
	
	//退出登录
	@RequestMapping("/sigout")
	public ModelAndView sigout(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String username = request.getParameter("username");
		System.out.println("Fetch Sigout");
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list", "123456");
		mv.setViewName("/admin/index");
		return mv;
	}
	
	private boolean isEmpty(String name){
		if(name == null || name.trim().isEmpty()){
			return true;
		}
		return false;
	}
	
}
