<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Order.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <table>
  	<tr>
  		<td>Product name</td>
  		<td>Product price</td>
  	</tr>
    <c:forEach items="${orders }" var="order">
    	<c:forEach items="order.prolist" var="pro">
    		<tr>
    			<td>pro.proName</td>
    			<td>pro.price</td>
    		</tr>
    	</c:forEach>
    </c:forEach>
    </table>
    <br/>
    	总价：${orders.totalPrice} 
    <script type="text/javascript">
    	
    	  window.setTimeout(function(){
    	   document.location.href="xxx.action";
    	   },10000);
    </script>
  </body>
</html>
