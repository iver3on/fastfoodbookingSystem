<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>jQuery/CSS3分步骤注册表单切换动画在线演示</title>
<link rel="stylesheet" media="screen" href="css/zzs.css" />
</head>
<div style="text-align:center;clear:both">
<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script><script src="/follow.js" type="text/javascript"></script></div>
<form id="msform">
	<!-- progressbar -->
	
	<!-- fieldsets -->
	<fieldset>
		<h2 class="fs-title">登录</h2>
		<h3 class="fs-subtitle"></h3>
		<input type="text" name="email" placeholder="用户名" />
		<input type="password" name="pass" placeholder="密码" />
		<input type="text" name="capture" placeholder="验证码"/><img src="imgServlet" height="40" weight="120"/>
		
		<input type="button" name="buyerlogin" class="next action-button" value="用户登陆" />
		<input type=button value="商家登录" class="next action-button" onclick="window.location.href='seller_login.jsp'"/> 
	</fieldset>
	
</form>
<script src="http://thecodeplayer.com/uploads/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="http://thecodeplayer.com/uploads/js/jquery.easing.min.js" type="text/javascript"></script>
<script src="js/zzsc.js" type="text/javascript"></script>
<br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br>

</body>
</html>
