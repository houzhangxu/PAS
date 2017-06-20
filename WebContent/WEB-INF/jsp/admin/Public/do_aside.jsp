<%@ page contentType="text/html;charset=utf-8"%>
<%
String active = request.getParameter("active");

%>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="/PAS/static/admin/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${sessionScope.admin_name} Admin</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-user"></i> <span>用户管理
            </span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
           
            <li>
              <a href="/PAS/admin/user"><i class="fa fa-users"></i> 用户列表
              </a>
            </li>
          </ul>
        </li>


        <li class="<treeview">
          <a href="#">
            <i class="fa fa-shopping-cart"></i> <span>商品管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="/PAS/admin/goods/add"><i class="fa fa-cart-plus"></i> 添加商品</a></li>
            <li><a href="/PAS/admin/goods"><i class="fa fa-cart-arrow-down"></i> 商品列表</a></li>
          </ul>
        </li>

        <li class="treeview">
          <a href="#">
            <i class="fa fa-unlock-alt"></i> <span>后台管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="/PAS/admin/manager/add"><i class="fa fa-user-plus"></i> 添加管理员</a></li>
            <li><a href="/PAS/admin/manager"><i class="fa fa-user-secret"></i> 管理员列表</a></li>
          </ul>
        </li>


        <li class="treeview">
          <a href="#">
            <i class="ion ion-clipboard"></i> <span>订单管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-file-text-o"></i> 所有订单</a></li>
            <li><a href="#"><i class="fa fa-file-o"></i> 未处理订单</a></li>
            <li><a href="#"><i class="fa fa-circle-o-notch"></i> 已完成订单</a></li>
          </ul>
        </li>

      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>