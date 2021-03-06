<%@ page contentType="text/html;charset=utf-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
	<head lang="en">
		<meta charset="UTF-8">
		<title>登录</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link rel="stylesheet" href="/PAS/static/home/AmazeUI-2.4.2/assets/css/amazeui.css" />
		<link href="/PAS/static/home/css/dlstyle.css" rel="stylesheet" type="text/css">
	</head>

	<body>

		<div class="login-boxtitle">
			
		</div>

		<div class="login-banner">
			<div class="login-main">
				
				<div class="login-box" style="margin:0 auto;position:relative;right:0;top:20px;">

							<h3 class="title" style="margin-top: 50px;">登录商城</h3>

							<div class="clear"></div>
						
						<div class="login-form" style="background:none;">
						  <form action="/PAS/dologin" method="post">
							   <div class="user-name">
								    <label for="user"><i class="am-icon-user"></i></label>
								    <input type="text" name="username" id="username" placeholder="用户名">
                 </div>
                 <div class="user-pass">
								    <label for="password"><i class="am-icon-lock"></i></label>
								    <input type="password" name="password" id="password" placeholder="请输入密码">
                 </div>
                 <div class="am-cf" style="position: relative;top: 50px;">
									<input type="submit" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm">
								</div>
              </form>
           </div>
           <a href="/PAS" class="zcnext am-fr am-btn-default" style="top:65px;width:66px;left: 20px;">返回首页</a>
            <a href="/PAS/register" class="zcnext am-fr am-btn-default" style="top:65px;">注册</a>

								
					

				</div>
			</div>
		</div>


					<div class="footer ">
						<div class="footer-bd ">
							<p style="text-align: center;">
								<em>© 2015-2025 PAS.com 版权所有</em>
							</p>
						</div>
					</div>
	</body>

</html>