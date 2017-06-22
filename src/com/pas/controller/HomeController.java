package com.pas.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pas.model.GoodsModel;
import com.pas.model.ShoppingCartModel;
import com.pas.model.UserModel;
import com.pas.service.GoodsServiceImp;
import com.pas.service.ShoppingCartService;
import com.pas.service.ShoppingCartServiceImp;
import com.pas.service.UserServiceImp;

@Controller
public class HomeController {

	@Autowired
	private GoodsServiceImp goodsService;
	@Autowired
	private UserServiceImp userService;
	@Autowired
	private ShoppingCartServiceImp shoppingCartService;
	
	
	// 登录页面
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Home Login");
		ModelAndView mv = new ModelAndView();
		// mv.addObject("list", "123456");
		mv.setViewName("/home/login");
		return mv;
	}

	// 登录操作
	@RequestMapping("/dologin")
	public ModelAndView dologin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Fetch Home Dologin");
		ModelAndView mv = new ModelAndView();

		if (this.isEmpty(request.getParameter("username"))) {
			mv.setViewName("/home/error");
			mv.addObject("error", "用户名未输入");
			return mv;
		}
		if (this.isEmpty(request.getParameter("password"))) {
			mv.setViewName("/home/error");
			mv.addObject("error", "密码未输入");
			return mv;
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		int id = userService.doLogin(username, password);

		if (id == 0) {
			mv.setViewName("/home/error");
			mv.addObject("error", "密码错误");
			return mv;
		}
		if (id == -1) {
			mv.setViewName("/home/error");
			mv.addObject("error", "用户名不存在");
			return mv;
		}

		UserModel um = userService.findUser(id);

		HttpSession session = request.getSession();
		session.setAttribute("username", um.getUsername());
		session.setAttribute("uid", um.getU_id());

		mv.addObject("success", "登录成功");
		mv.addObject("target", "/PAS");
		mv.setViewName("/home/success");
		return mv;
	}

	// 退出页面
	@RequestMapping("/sigout")
	public ModelAndView sigout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Fetch Home Sigout");

		ModelAndView mv = new ModelAndView();

		// mv.addObject("list", "123456");
		mv.setViewName("/pas");

		HttpSession session = request.getSession();
		session.setAttribute("uid", Integer.valueOf(0));
		session.setAttribute("username", null);

		return mv;
	}

	// 注册页面
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Home Register");

		ModelAndView mv = new ModelAndView();

		// mv.addObject("list", "123456");
		mv.setViewName("/home/register");
		return mv;
	}

	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Home Login");
		ModelAndView mv = new ModelAndView();
		// mv.addObject("list", "123456");
		mv.setViewName("/admin/index");
		return mv;
	}

	@RequestMapping("/")
	public ModelAndView indexp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Home Login");
		ModelAndView mv = new ModelAndView();
		// mv.addObject("list", "123456");
		mv.setViewName("/home/index");
		return mv;
	}

	@RequestMapping("")
	public ModelAndView indexpa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Home Login");
		ModelAndView mv = new ModelAndView();
		// mv.addObject("list", "123456");
		mv.setViewName("/home/index");
		return mv;
	}

	@RequestMapping("/search")
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Home Login");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/home/search_list");

		if (this.isEmpty(request.getParameter("key"))) {
			mv.setViewName("/home/search_list");
			return mv;
		}
		String key = request.getParameter("key").trim();

		List<GoodsModel> list = goodsService.getGoodsByName(key);
		mv.addObject("list", list);

		return mv;
	}

	@RequestMapping("/cart")
	public ModelAndView shoppingCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Home Login");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/home/shopping_cart");

		// mv.addObject("list", list);

		return mv;
	}

	@RequestMapping(path = "/cart/add/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView shoppingCart(@PathVariable("id") int goods_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Home Cart add" + goods_id);
		ModelAndView mv = new ModelAndView();

		
		HttpSession session = request.getSession();
	    if (session.getAttribute("uid") != null)
	    {
	      int u_id = ((Integer)session.getAttribute("uid")).intValue();
	      ShoppingCartModel scm = new ShoppingCartModel();
	      scm.setG_id(goods_id);
	      scm.setU_id(u_id);
	      scm.setCreate_time(new Date().getTime());
	      
	      if ()
	      {
	    	
	        return mv;
	      }
	      
	      return mv;
	    }
		
		int i = 1;

		if (i > 0) {

			mv.addObject("error", "添加到购物车失败");
			mv.addObject("target", "/PAS/home/cart");
			mv.setViewName("/home/error");
		}

		mv.addObject("success", "添加到购物车成功");
		mv.addObject("target", "/PAS/home/cart");

		mv.setViewName("/home/success");
		return mv;
	}

	private boolean isEmpty(String name) {
		if (name == null || name.trim().isEmpty()) {
			return true;
		}
		return false;
	}
}
