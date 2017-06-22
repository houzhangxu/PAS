<%@ page contentType="text/html;charset=utf-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>搜索页面</title>

		<link href="/PAS/static/home/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="/PAS/static/home/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />

		<link href="/PAS/static/home/basic/css/demo.css" rel="stylesheet" type="text/css" />

		<link href="/PAS/static/home/css/seastyle.css" rel="stylesheet" type="text/css" />
<link href="/PAS/static/home/css/hmstyle.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="/PAS/static/home/basic/js/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="/PAS/static/home/js/script.js"></script>
	</head>

	<body>
<%
  List all = (List)request.getAttribute("list");
%>
		<!--顶部导航条 -->
		<jsp:include page="Public/header.jsp" />

			<!--悬浮搜索框-->

			<div class="nav white">
				<div class="search-bar pr" style="padding:20px 0px 20px 0px;">
						<a name="index_none_header_sysc" href="#"></a>
						<form action="/PAS/search" method="get" style="margin:0 auto;">
							<input style="padding-left: 20px;font-size: 14px;" id="searchInput" name="key" type="text" placeholder="商品名称" value="${param.key}" autocomplete="off">
							<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
						</form>
					</div>
			</div>

			<div class="clear"></div>
			<b class="line" style="top:125px;"></b>
           <div class="search">
			<div class="search-list">

			
				
					<div class="am-g am-g-fixed">
						<div class="am-u-sm-12 am-u-md-12" style="min-height:300px;padding-bottom:80px;">

							<div class="search-content" style="margin:0 auto;float:none;">

								<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes">
								<%
				                  if(all != null){
				                    Iterator iter = all.iterator();
				                    while(iter.hasNext()){
				                      pageContext.setAttribute("goods",iter.next());

				                %>
									<li>
										<div class="i-pic limit">
											<p class="title" style="height: 200px;background-color: #f5f5f5;padding: 0 10px;margin-top: 0px;position: relative;">
												<a href="/PAS/cart/add/${goods.g_id}" style="position: absolute;bottom: 10px;right: 10px;">添加</a>
											</p>
											<p class="title fl">${goods.goods_name}</p>
											<p class="price fl">
												<b>¥</b>
												<strong>${goods.price}</strong>
											</p>
											<p class="number fl">
												总量<span>${goods.total}</span>
											</p>
										</div>
									</li>
									<%
									}
									} else{
										%>
										<h2 style="text-align: center;font-size:18px;height:300px;line-height:300px;">数据?不存在的.</h2>
										<%
									}
									%>
								</ul>
							</div>
							<div class="clear"></div>

						</div>
					</div>
					
				</div>

			</div>
<jsp:include page="Public/footer.jsp" />
		<!--引导 -->
		<div class="navCir">
			<li><a href="home.html"><i class="am-icon-home "></i>首页</a></li>
			<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
			<li><a href="shopcart.html"><i class="am-icon-shopping-basket"></i>购物车</a></li>	
			<li><a href="person/index.html"><i class="am-icon-user"></i>我的</a></li>					
		</div>

		<!--菜单 -->
		
		<script>
			window.jQuery || document.write('<script src="/PAS/static/home/basic/js/jquery-1.9.min.js"><\/script>');
		</script>
		<script type="text/javascript" src="/PAS/static/home/basic/js/quick_links.js"></script>

<div class="theme-popover-mask"></div>

	</body>

</html>