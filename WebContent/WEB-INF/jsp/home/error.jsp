<%@ page contentType="text/html;charset=utf-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>发生了一个错误</title>
</head>
<body>

${param.error},<span id="time">3</span>秒后返回上一层
 或者点击 <a href="javascript:history.go(-1);">返回</a>.
<script type="text/javascript" src="basic/js/jquery-1.7.min.js"></script>
<script type="text/javascript">
  $(function () {

      setTimeout(ChangeTime, 1000);

    });

    function ChangeTime() {

      var time;

      time = $("#time").text();    

      time = parseInt(time);

      time--;

      if (time <= 0) {

        window.history.go(-1);

      } else {

        $("#time").text(time);

        setTimeout(ChangeTime, 1000);

      }

    }

</script>
</body>
</html>