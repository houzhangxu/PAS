<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminPA | Index</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="/PAS/static/admin/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/PAS/static/admin/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="/PAS/static/admin/dist/css/skins/_all-skins.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="/PAS/static/admin/plugins/iCheck/flat/blue.css">
  <!-- Morris chart -->
  <link rel="stylesheet" href="/PAS/static/admin/plugins/morris/morris.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="/PAS/static/admin/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Date Picker -->
  <link rel="stylesheet" href="/PAS/static/admin/plugins/datepicker/datepicker3.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="/PAS/static/admin/plugins/daterangepicker/daterangepicker.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="/PAS/static/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

   <jsp:include page="Public/header.jsp" />
  <!-- Left side column. contains the logo and sidebar -->
 
   <jsp:include page="Public/aside.jsp" />

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        商品管理
        <small>添加商品</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="/PAS/admin"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li><a href="/PAS/admin/goods">商品管理</a></li>
        <li class="active">添加商品</li>
      </ol>
    </section>
 <div class="row">
      <div class="col-md-6" style="margin-left:auto;margin-right: auto;float: none;">
    <div class="box box-primary" style="margin-top:10px;">
   
      <!-- form start -->
      <form role="form" action="/PAS/admin/goods/doadd" method="post" style="padding-top: 10px;">
        <div class="box-body">
          <div class="form-group">
            <label for="exampleInputEmail1">商品名称</label>
            <input type="text" class="form-control" name="goods_name" id="goods_name"  placeholder="商品名称">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">商品详情</label>
            <textarea class="form-control" name="goods_main" id="goods_main" required placeholder="商品详情"></textarea>
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">商品价格</label>
            <div class="input-group">
                <span class="input-group-addon">¥</span>
                <input type="text" name="price"  id="price" class="form-control">
              </div>
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">库存数量</label>
            <input type="text" class="form-control" required name="total" id="total" placeholder="商品数量">
          </div>
         <input type="hidden" name="goods_type" id="goods_type" value="0" />
        </div>
        <!-- /.box-body -->

        <div class="box-footer">
          <button type="submit" class="btn btn-primary pull-right">添加</button>
        </div>
      </form>
      </div>
      </div>
    </div>

  </div>
  <!-- /.content-wrapper -->
  <!-- Footer -->
<jsp:include page="Public/footer.jsp" />
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="/PAS/static/admin/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="/PAS/static/admin/bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="/PAS/static/admin/plugins/morris/morris.min.js"></script>
<!-- Sparkline -->
<script src="/PAS/static/admin/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="/PAS/static/admin/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/PAS/static/admin/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="/PAS/static/admin/plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="/PAS/static/admin/plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="/PAS/static/admin/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="/PAS/static/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="/PAS/static/admin/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/PAS/static/admin/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/PAS/static/admin/dist/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="/PAS/static/admin/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/PAS/static/admin/dist/js/demo.js"></script>


</body>
</html>
