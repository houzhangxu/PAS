<%@ page contentType="text/html;charset=utf-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminPA | Admin User</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="/PAS/static/admin/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="/PAS/static/admin/plugins/datatables/dataTables.bootstrap.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/PAS/static/admin/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="/PAS/static/admin/dist/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<%
  List all = (List)request.getAttribute("list");
%>
<div class="wrapper">

<jsp:include page="Public/do_header.jsp" />
  <!-- Left side column. contains the logo and sidebar -->
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
<jsp:include page="Public/do_aside.jsp">
<jsp:param name="active" value="goods"/>
</jsp:include>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        订单管理
        <small>订单详情</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="/PAS/admin"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li><a href="/PAS/admin/orders">订单管理</a></li>
        <li class="active">订单详情</li>
      </ol>
    </section>


<jsp:useBean id="myDate" class="java.util.Date"/>
<c:set target="${myDate}" property="time" value="${ order.create_time }"/>
<section class="invoice" style="margin-bottom: 0px; padding-bottom: 20px;">
      <!-- title row -->
      <div class="row">
        <div class="col-xs-12">
          <h2 class="page-header" style="text-transform: uppercase;">
            <i class="fa fa-globe"></i>${user.username}.USER
            <small class="pull-right">Date: <fmt:formatDate value="${myDate }" pattern="yyyy-MM-dd HH:mm:ss"/></small>
          </h2>
        </div>
        <!-- /.col -->
      </div>

      <!-- Table row -->
      <div class="row">
        <div class="col-xs-12 table-responsive">
          <table class="table table-striped">
            <thead>
            <tr>
              <th>商品号</th>
              <th>名称</th>
              <th>数量</th>
              <th>商品描述</th>
              <th>单价</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${goods}" var="g">
            <tr>
              <td>${g.g_id}</td>
              <td>${g.goods_name}</td>
              <td>${g.total}</td>
              <td>${g.goods_main}</td>
              <td>${g.price}¥</td>
            </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->

      <div class="row">
        <!-- accepted payments column -->
        <!-- /.col -->
        <div class="col-xs-6">
          <p class="lead"><fmt:formatDate value="${myDate }" pattern="yyyy-MM-dd"/></p>

          <div class="table-responsive">
            <table class="table">
              <tbody>
              <tr>
                <th>件数:</th>
                <td>${sum_total}</td>
              </tr>
              <tr>
                <th>总价:</th>
                <td>${sum_price}¥</td>
              </tr>
            </tbody></table>
          </div>
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->

      <!-- this row will not appear when printing -->
      <div class="row no-print">
        <div class="col-xs-12">
          <a href="invoice-print.html" target="_blank" class="btn btn-default"><i class="fa fa-print"></i> Print</a>
          <a href="/PAS/admin/orders/do/${order.o_id}" class="btn btn-success pull-right"><i class="fa fa-credit-card"></i> 同意订单
          </a>
        	<a href="/PAS/admin/orders/no/${order.o_id}" class="btn btn-primary pull-right" style="margin-right: 5px;">
            <i class="fa fa-download"></i> 拒绝订单
          </a>
        </div>
      </div>
    </section>

    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <!-- 
  Footer
   -->
<jsp:include page="Public/do_footer.jsp" />
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="/PAS/static/admin/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/PAS/static/admin/bootstrap/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="/PAS/static/admin/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="/PAS/static/admin/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="/PAS/static/admin/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/PAS/static/admin/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/PAS/static/admin/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/PAS/static/admin/dist/js/demo.js"></script>
<!-- page script -->
<script>
  $(function () {
    $("#example1").DataTable({
      "paging": true,
      "lengthChange": true,
      "searching": true,
      "ordering": true,
      "info": true,
      "autoWidth": false
    });
  });
</script>
</body>
</html>