<%@ page contentType="text/html;charset=utf-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminPA | Admin Manager</title>
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
        商品管理
        <small>商品列表</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="index.jsp"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li><a href="goods_list.jsp">商品管理</a></li>
        <li class="active">商品列表</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">


          <div class="box">
            <div class="box-header">
              <h3 class="box-title">商品列表</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th style="width:40px;">操作</th>
                  <th>管理员名称</th>
                  <th>创建日期</th>
                </tr>
                </thead>
                <tbody>
                <jsp:useBean id="myDate" class="java.util.Date"/> 
                <c:forEach items="${list }" var="admin">
                <tr>
                  <td>
                    <a href="/PAS/admin/manager/dodelete/${admin.a_id}" class="btn btn-default btn-sm" style="padding:0px 5px 0px 5px; "><i class="fa fa-trash-o"></i></a>
                    <a href="/PAS/admin/manager/update/${admin.a_id}" class="btn btn-default btn-sm" style="padding:0px 5px 0px 5px; "><i class="fa fa-edit"></i></a>
                  </td>
                  <td>${admin.admin_name}</td>
                  <c:set target="${myDate}" property="time" value="${ admin.create_time }"/>
                  <td><fmt:formatDate value="${myDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>
                 </c:forEach>

               
                </tbody>

               
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
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
