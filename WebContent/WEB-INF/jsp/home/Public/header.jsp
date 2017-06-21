<%@ page contentType="text/html;charset=utf-8"%>
<div style="width:100%;background-color: #f5f5f5">
	<div class="am-container header">
		<ul class="message-l">
			<div class="topMessage">
				<div class="menu-hd">
				<%
					
					if(session.getAttribute("username") != null){
				%>
					欢迎您:${sessionScope.username}
					<a href="/sigout">退出</a>

				<%
					}else{

					%>
					<a href="/PAS/login" target="_top" class="h">请登录</a>
					<a href="/PAS/register" target="_top">免费注册</a>
					<%
				}
				%>
					
				</div>
			</div>
		</ul>
		<ul class="message-r">
			<div class="topMessage home">
				<div class="menu-hd"><a href="/PAS" target="_top" class="h">商城首页</a></div>
			</div>

			<div class="topMessage mini-cart">
				<div class="menu-hd"><a id="mc-menu-hd" href="/PAS/cart" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span></a></div>
			</div>

		</ul>
	</div>
</div>