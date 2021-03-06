package com.pas.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.COMM_FAILURE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pas.model.AdminModel;
import com.pas.model.GoodsModel;
import com.pas.model.OrderGoodsModel;
import com.pas.model.OrderMoreModel;
import com.pas.model.OrdersModel;
import com.pas.model.UserModel;
import com.pas.service.AdminServiceImp;
import com.pas.service.GoodsService;
import com.pas.service.GoodsServiceImp;
import com.pas.service.OrderGoodsServiceImp;
import com.pas.service.OrdersServiceImp;
import com.pas.service.UserService;
import com.pas.service.UserServiceImp;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private GoodsServiceImp gs;
	@Autowired
	private AdminServiceImp admin;
	@Autowired
	private UserServiceImp userService;
	@Autowired
	private OrdersServiceImp ordersService;
	@Autowired
	private OrderGoodsServiceImp orderGoodsService;

	// 首页
	@RequestMapping("")
	public ModelAndView admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Login");
		ModelAndView mv = new ModelAndView();

		int order = ordersService.getCount();
		int user = userService.getCount();
		int goods = gs.getCount();
		int admin_n = admin.getCount();

		mv.addObject("order", order);
		mv.addObject("user", user);
		mv.addObject("goods", goods);
		mv.addObject("admin", admin_n);

		System.out.println(order);
		mv.setViewName("/admin/index");
		return mv;
	}

	// 登录
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Login");
		ModelAndView mv = new ModelAndView();
		// mv.addObject("list", "123456");
		mv.setViewName("/admin/login");
		return mv;
	}

	// 登录操作
	@RequestMapping("/dologin")
	public ModelAndView dologin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Fetch Home Dologin");
		ModelAndView mv = new ModelAndView();

		if (this.isEmpty(request.getParameter("username"))) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "用户名未输入");
			return mv;
		}
		if (this.isEmpty(request.getParameter("password"))) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "密码未输入");
			return mv;
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		int a_id = admin.doLogin(username, password);

		if (a_id == 0) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "密码错误");
			return mv;
		}
		if (a_id == -1) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "用户名不存在");
			return mv;
		}

		AdminModel am = admin.findAdmin(a_id);

		HttpSession session = request.getSession();
		session.setAttribute("admin_name", am.getAdmin_name());
		session.setAttribute("aid", am.getA_id());

		mv.addObject("success", "登录成功");
		mv.addObject("target", "/PAS/admin");
		mv.setViewName("/admin/success");
		return mv;
	}

	// 退出登录
	@RequestMapping("/sigout")
	public ModelAndView sigout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Sigout");
		ModelAndView mv = new ModelAndView();
		// mv.addObject("list", "123456");

		HttpSession session = request.getSession();
		session.setAttribute("aid", Integer.valueOf(0));
		session.setAttribute("admin_name", null);

		mv.addObject("success", "退出成功");
		mv.addObject("target", "/PAS/admin/login");
		mv.setViewName("/admin/success");
		return mv;
	}

	// 用户列表
	@RequestMapping("/user")
	public ModelAndView user(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch User");
		ModelAndView mv = new ModelAndView();

		List<UserModel> list = userService.getAllUser();

		mv.addObject("list", list);
		mv.setViewName("/admin/user_list");
		return mv;
	}

	// 商品列表
	@RequestMapping("/goods")
	public ModelAndView goods(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Goods");
		ModelAndView mv = new ModelAndView();

		List<GoodsModel> list = gs.getAllGoods();

		mv.addObject("list", list);
		mv.setViewName("/admin/goods_list");
		return mv;
	}

	// 添加商品
	@RequestMapping(path = "/goods/add", method = RequestMethod.GET)
	public ModelAndView goodsAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Goods Add");
		ModelAndView mv = new ModelAndView();
		// mv.addObject("list", "123456");
		mv.setViewName("/admin/goods_add");
		return mv;
	}

	// 添加商品
	@RequestMapping(path = "/goods/doadd", method = { RequestMethod.POST })
	public ModelAndView goodsDoAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		ModelAndView mv = new ModelAndView();
		// request.setCharacterEncoding("UTF-8");

		if (this.isEmpty(request.getParameter("goods_name"))) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "商品名称未输入");
			return mv;
		}

		if (this.isEmpty(request.getParameter("goods_main"))) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "商品详情未输入");
			return mv;
		}

		if (this.isEmpty(request.getParameter("price"))) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "价格未输入");
			return mv;
		}

		if (this.isEmpty(request.getParameter("total"))) {
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
		gm.setGoods_name(name); // 设置名称
		gm.setGoods_main(main); // 设置详情
		gm.setPrice(price); // 设定价格
		gm.setTotal(total); // 设定库存
		gm.setGoods_type(1); // 设定商品类型
		gm.setCreator(1); // 设定创建者
		gm.setCreate_time(new Date().getTime());

		System.out.println("Fetch Goods DoAdd");
		System.out.println(name);
		System.out.println(main);
		System.out.println(price);
		System.out.println(total);

		try {
			gs.addGoods(gm);
		} catch (Exception e) {
			// TODO: handle exception
			mv.setViewName("/admin/error");
			mv.addObject("er", "商品添加失败");
			return mv;
		}
		// mv.addObject("list", "123456");
		// mv.setViewName("/admin/goods_add");
		// response.sendRedirect("/PAS/admin/goods");
		mv.addObject("target", "/PAS/admin/goods");
		// mv.setViewName("redirect:/admin/goods"); //重定向
		mv.addObject("success", "商品添加成功");
		mv.setViewName("/admin/success");
		return mv;
	}

	// 修改商品页面
	@RequestMapping(path = "/goods/update/{id}", method = RequestMethod.GET)
	public ModelAndView goodsUpdate(@PathVariable("id") int id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Goods Update " + id);
		ModelAndView mv = new ModelAndView();

		if (id < 1) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "商品不存在");
			return mv;
		}

		GoodsModel gm = gs.findGoods(id);

		mv.addObject("goods", gm);
		// mv.addObject("list", "123456");

		mv.setViewName("/admin/goods_update");
		return mv;
	}

	// 修改商品操作
	@RequestMapping(path = "/goods/doupdate", method = { RequestMethod.POST })
	public ModelAndView goodsDoUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");

		ModelAndView mv = new ModelAndView();
		// request.setCharacterEncoding("UTF-8");

		if (this.isEmpty(request.getParameter("goods_name"))) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "商品名称未输入");
			return mv;
		}

		if (this.isEmpty(request.getParameter("goods_main"))) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "商品详情未输入");
			return mv;
		}

		if (this.isEmpty(request.getParameter("price"))) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "价格未输入");
			return mv;
		}

		if (this.isEmpty(request.getParameter("total"))) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "库存未输入");
			return mv;
		}

		if (this.isEmpty(request.getParameter("g_id"))) {
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
		gm.setGoods_name(name); // 设置名称
		gm.setGoods_main(main); // 设置详情
		gm.setPrice(price); // 设定价格
		gm.setTotal(total); // 设定库存
		gm.setCreator(1); // 设定创建者
		gm.setCreate_time(new Date().getTime());

		try {
			gs.updateGoods(gm);
		} catch (Exception e) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "商品修改失败");
			return mv;
		}

		mv.addObject("target", "/PAS/admin/goods");
		mv.addObject("success", "商品修改成功");
		mv.setViewName("/admin/success");
		return mv;
	}

	// 删除商品
	@RequestMapping("/goods/dodelete/{id}")
	public ModelAndView goodsDodelete(@PathVariable("id") int id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch delete");
		ModelAndView mv = new ModelAndView();

		int g_id = id;

		if (g_id < 1) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "商品不存在");
			return mv;
		}

		try {
			gs.deleteGoods(g_id);
		} catch (Exception e) {

			mv.setViewName("/admin/error");
			mv.addObject("er", "商品删除失败");
			return mv;
		}

		mv.addObject("target", "/PAS/admin/goods");
		mv.addObject("success", "商品删除成功");
		mv.setViewName("/admin/success");

		return mv;
	}

	// 管理员列表
	@RequestMapping("/manager")
	public ModelAndView manager(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Manager");
		ModelAndView mv = new ModelAndView();
		List<AdminModel> list = admin.getAllAdmin();
		mv.addObject("list", list);
		mv.setViewName("/admin/admin_list");
		return mv;
	}

	// 管理员添加
	@RequestMapping("/manager/add")
	public ModelAndView managerAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Manager Add");
		ModelAndView mv = new ModelAndView();
		// mv.addObject("list", "123456");

		mv.setViewName("/admin/admin_add");
		return mv;
	}

	// 管理员添加操作
	@RequestMapping(path = "/manager/doadd", method = { RequestMethod.POST })
	public ModelAndView managerDoAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		ModelAndView mv = new ModelAndView();
		// request.setCharacterEncoding("UTF-8");

		if (this.isEmpty(request.getParameter("admin_name"))) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "管理员名称未输入");
			return mv;
		}

		if (this.isEmpty(request.getParameter("password"))) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "管理员密码未输入");
			return mv;
		}

		String username = request.getParameter("admin_name").trim();
		String password = request.getParameter("password").trim();

		AdminModel am = new AdminModel();
		am.setAdmin_name(username);
		am.setPassword(password);
		am.setStatus(1);
		am.setCreate_time(new Date().getTime());

		System.out.println("Fetch Manager DoAdd");

		try {
			admin.addAdmin(am);
		} catch (Exception e) {
			// TODO: handle exception
			mv.setViewName("/admin/error");
			mv.addObject("er", "管理员添加失败");
			return mv;
		}
		mv.addObject("target", "/PAS/admin/manager");
		mv.addObject("success", "管理员添加成功");
		mv.setViewName("/admin/success");
		return mv;
	}

	// 管理员修改
	@RequestMapping("/manager/update/{id}")
	public ModelAndView managerUpdate(@PathVariable("id") int id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Manager Update " + id);
		ModelAndView mv = new ModelAndView();
		AdminModel am = admin.findAdmin(id);

		if (id < 1) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "管理员不存在");
			return mv;
		}

		mv.addObject("admin", am);

		mv.setViewName("/admin/admin_update");
		return mv;
	}

	// 管理员修改操作
	@RequestMapping(path = "/manager/doupdate", method = { RequestMethod.POST })
	public ModelAndView managerDoUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		ModelAndView mv = new ModelAndView();
		// request.setCharacterEncoding("UTF-8");

		if (this.isEmpty(request.getParameter("admin_name"))) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "管理员名称未输入");
			return mv;
		}

		if (this.isEmpty(request.getParameter("password"))) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "管理员密码未输入");
			return mv;
		}

		if (this.isEmpty(request.getParameter("id"))) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "无法定位修改行");
			return mv;
		}

		String username = request.getParameter("admin_name").trim();
		String password = request.getParameter("password").trim();

		int a_id = 0;
		try {
			a_id = Integer.parseInt(request.getParameter("id").trim());
		} catch (Exception e) {
			// TODO: handle exception
			mv.setViewName("/admin/error");
			mv.addObject("er", "id非法");
			return mv;
		}

		if (a_id < 0) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "id非法");
			return mv;
		}

		AdminModel am = new AdminModel();
		am.setA_id(a_id);
		am.setAdmin_name(username);
		am.setPassword(password);
		am.setStatus(1);
		am.setCreate_time(new Date().getTime());

		System.out.println("Fetch Manager DoAdd");

		try {
			admin.updateAdmin(am);
		} catch (Exception e) {
			// TODO: handle exception
			mv.setViewName("/admin/error");
			mv.addObject("er", "管理员修改失败");
			return mv;
		}
		mv.addObject("target", "/PAS/admin/manager");
		mv.addObject("success", "管理员添加成功");
		mv.setViewName("/admin/success");
		return mv;
	}

	// 删除商品
	@RequestMapping("/manager/dodelete/{id}")
	public ModelAndView managerDodelete(@PathVariable("id") int id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch delete");
		ModelAndView mv = new ModelAndView();

		int a_id = id;

		if (a_id < 1) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "管理员不存在");
			return mv;
		}

		try {
			admin.deleteAdmin(a_id);
		} catch (Exception e) {

			mv.setViewName("/admin/error");
			mv.addObject("er", "管理员删除失败");
			return mv;
		}

		mv.addObject("target", "/PAS/admin/manager");
		mv.addObject("success", "管理员删除成功");
		mv.setViewName("/admin/success");

		return mv;
	}

	// 未处理订单
	@RequestMapping("/orders")
	public ModelAndView adminOrders(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Order");
		ModelAndView mv = new ModelAndView();
		// mv.addObject("list", "123456");

		List<OrdersModel> list = ordersService.getAllOrdersEn(0);
		List<OrderMoreModel> o = new ArrayList<>();
		for (OrdersModel order : list) {
			int u_id = order.getU_id();
			OrderMoreModel omm = new OrderMoreModel();
			omm.setU_id(u_id);
			omm.setO_id(order.getO_id());
			omm.setStatus(order.getStatus());
			omm.setUsername(userService.findUser(u_id).getUsername());
			omm.setCreate_time(order.getCreate_time());
			o.add(omm);
		}

		mv.addObject("list", o);
		mv.setViewName("/admin/order_list");
		return mv;
	}

	// 已完成订单
	@RequestMapping("/orders/en")
	public ModelAndView adminOrdersEn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Order");
		ModelAndView mv = new ModelAndView();
		// mv.addObject("list", "123456");

		List<OrdersModel> list = ordersService.getAllOrdersEn(1);
		List<OrderMoreModel> o = new ArrayList<>();
		for (OrdersModel order : list) {
			int u_id = order.getU_id();
			OrderMoreModel omm = new OrderMoreModel();
			omm.setU_id(u_id);
			omm.setO_id(order.getO_id());
			omm.setStatus(order.getStatus());
			omm.setUsername(userService.findUser(u_id).getUsername());
			omm.setCreate_time(order.getCreate_time());
			o.add(omm);
		}

		mv.addObject("list", o);
		mv.setViewName("/admin/order_list");
		return mv;
	}

	// 未完成订单
	@RequestMapping("/orders/er")
	public ModelAndView adminOrdersEr(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String username = request.getParameter("username");
		System.out.println("Fetch Order");
		ModelAndView mv = new ModelAndView();
		// mv.addObject("list", "123456");

		List<OrdersModel> list = ordersService.getAllOrdersEn(-1);
		List<OrderMoreModel> o = new ArrayList<>();
		for (OrdersModel order : list) {
			int u_id = order.getU_id();
			OrderMoreModel omm = new OrderMoreModel();
			omm.setU_id(u_id);
			omm.setO_id(order.getO_id());
			omm.setStatus(order.getStatus());
			omm.setUsername(userService.findUser(u_id).getUsername());
			omm.setCreate_time(order.getCreate_time());
			o.add(omm);
		}

		mv.addObject("list", o);
		mv.setViewName("/admin/order_list");
		return mv;
	}

	// 所有订单
	@RequestMapping("/orders/{id}")
	public ModelAndView adminOrderDetail(@PathVariable("id") int o_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Fetch Order" + o_id);
		ModelAndView mv = new ModelAndView();
		double sum_price = 0;
		double sum_total = 0;
		OrdersModel order = ordersService.findOrdersByOId(o_id); // 订单信息
		if (order == null) {
			mv.setViewName("/admin/error");
			mv.addObject("er", "订单处理失败");
			return mv;
		}
		int u_id = order.getU_id();
		UserModel user = userService.findUser(u_id); // 用户信息
		List<OrderGoodsModel> ogm = orderGoodsService.selectOrderGoodsByOId(o_id); // 根据订单信息去查订单详情表
		List<GoodsModel> gm = new ArrayList<>();

		for (OrderGoodsModel orderGoodsModel : ogm) {
			int goods_id = orderGoodsModel.getG_id();
			GoodsModel g = gs.findGoods(goods_id);
			g.setTotal(orderGoodsModel.getTotal());
			sum_price += (g.getPrice() * g.getTotal());
			sum_total += g.getTotal();
			gm.add(g);
		}

		//
		mv.addObject("order", order);
		mv.addObject("user", user);
		mv.addObject("orderGoods", ogm);
		mv.addObject("goods", gm);
		mv.addObject("sum_total", sum_total);
		mv.addObject("sum_price", sum_price);
		mv.setViewName("/admin/order_detail");
		return mv;
	}

	// 同意订单
	@RequestMapping("/orders/do/{id}")
	public ModelAndView adminDoOrder(@PathVariable("id") int o_id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Fetch Order" + o_id);
		ModelAndView mv = new ModelAndView();
		OrdersModel om = new OrdersModel();
		om.setO_id(o_id);
		om.setStatus(1);
		if(ordersService.updateStatus(om) < 1){
			mv.setViewName("/admin/error");
			mv.addObject("er", "订单处理失败");
			return mv;
		}
		mv.addObject("success", "订单处理成功");
		mv.addObject("target", "/PAS/admin/login");
		mv.setViewName("/admin/success");
		return mv;
	}

	// 拒绝订单
		@RequestMapping("/orders/no/{id}")
		public ModelAndView adminNoOrder(@PathVariable("id") int o_id, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			System.out.println("Fetch Order" + o_id);
			ModelAndView mv = new ModelAndView();
			OrdersModel om = new OrdersModel();
			om.setO_id(o_id);
			om.setStatus(-1);
			if(ordersService.updateStatus(om) < 1){
				mv.setViewName("/admin/error");
				mv.addObject("er", "订单处理失败");
				return mv;
			}
			mv.addObject("success", "订单处理成功");
			mv.addObject("target", "/PAS/admin/login");
			mv.setViewName("/admin/success");
			return mv;
		}
	
	private boolean isEmpty(String name) {
		if (name == null || name.trim().isEmpty()) {
			return true;
		}
		return false;
	}

}
