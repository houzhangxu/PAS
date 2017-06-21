<%@ page contentType="text/html;charset=utf-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>首页</title>

		<jsp:include page="Public/head.jsp" />

	</head>

	<body>
		<div class="hmtop">
			<!--顶部导航条 -->
			<jsp:include page="Public/header.jsp" />
				<!--悬浮搜索框-->

				<div class="nav white">


					<div class="search-bar pr" style="padding:120px 0px 20px 0px;">
						<a name="index_none_header_sysc" href="#"></a>
						<form action="/PAS/search" method="get" style="margin:0 auto;">
							<input style="padding-left: 20px;font-size: 14px;" id="searchInput" name="key" type="text" require placeholder="商品名称" value="${key}" autocomplete="off">
							<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
						</form>
					</div>
				</div>

				<div class="clear"></div>
			</div>

			<jsp:include page="Public/footer.jsp" />
			
		<!--引导 -->
		<div class="navCir">
			<li class="active"><a href="home.html"><i class="am-icon-home "></i>首页</a></li>
			<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
			<li><a href="shopcart.html"><i class="am-icon-shopping-basket"></i>购物车</a></li>	
			<li><a href="../person/index.html"><i class="am-icon-user"></i>我的</a></li>					
		</div>



		<script>
			window.jQuery || document.write('<script src="basic/js/jquery.min.js "><\/script>');
		</script>
		<script type="text/javascript " src="/PAS/static/home/basic/js/quick_links.js "></script>
	</body>

</html>