<%@ page contentType="text/html;charset=utf-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>成功</title>
</head>
<body>

${success},<span id="time">1</span>秒后跳转
 或者点击 <a href="${target}">跳转</a>.
<script type="text/javascript" src="/PAS/static/home/basic/js/jquery-1.7.min.js"></script>
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

        window.location = "${target}";

      } else {

        $("#time").text(time);

        setTimeout(ChangeTime, 1000);

      }

    }

</script>
</body>
</html>