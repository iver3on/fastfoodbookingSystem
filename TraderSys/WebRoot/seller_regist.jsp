<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>jQuery/CSS3�ֲ���ע����л�����������ʾ</title>
<link rel="stylesheet" media="screen" href="css/zzsr.css" />
</head>
<div style="text-align:center;clear:both">
<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script><script src="/follow.js" type="text/javascript"></script></div>
<form id="msform">
	<!-- progressbar -->
	
	<!-- fieldsets -->
	<fieldset>
		<h2 class="fs-title">�̻�ע����Ϣ</h2>
		
		<input type="text" name="trader.name" placeholder="�̻�����" /></br><font color="red"><s:fielderror name="uname"></s:fielderror></font>
		<input type="password" name="trader.password" placeholder="����" /></br><font color="red"><s:fielderror name="pwdNull"></s:fielderror></font>
		<input type="password" name="pwd2" placeholder="ȷ������" /></br><font color="red"><s:fielderror name="pwd2"></s:fielderror></font>
		
		<input type="text" name="trader.phone" placeholder="��ϵ�绰/�ֻ���" />
		<input type="text" name="trader.qq" placeholder="QQ" />
		
		<input type="text" name="trader.licenseId" placeholder="���֤���" /></br><font color="red"><s:fielderror name="license"></s:fielderror></font>
		<input type="text" name="trader.address" placeholder="�̼ҵ�ַ" />
		<input type="text" name="trader.openingTime" placeholder="Ӫҵʱ��" />
		<input type="text" name="trader.ranking" placeholder="ע�����" />
		<input type="file" name="trader.logo"></br><font color="red"><s:fielderror name="logo"></s:fielderror></font>
		<input type="submit" value="�������logo">
		<input type="button" name="sellerregist" class="next action-button" onclick="window.location.href='traderRegist.action'" value="ע��" />
		
		
	</fieldset>
</form>
<script src="http://thecodeplayer.com/uploads/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="http://thecodeplayer.com/uploads/js/jquery.easing.min.js" type="text/javascript"></script>
<script src="js/zzsc.js" type="text/javascript"></script>
<br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br>

</body>
</html>
