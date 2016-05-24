<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
  <%@  taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
<head>
<title>饿了么</title>
<meta name="Robots" content="index,follow">
<meta name="keywords"
	content="">
<meta name="description"
	content="">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script language="JavaScript" type="text/JavaScript">function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
</script>
<link href="css.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.css" rel="stylesheet"/>
<link href="css/bootstrap-responsive.css" rel="stylesheet"/>
<link href="css/bootstrap-modal-bs3patch.css" rel="stylesheet">
<link href="css/bootstrap-modal.css" rel="stylesheet">
<script src='js/jquery.js'></script>
<script src='js/bootstrap.js'></script>
<script src="js/bootstrap-modal.js"></script>

<script src="js/bootstrap-modalmanager.js"></script>
<script>
window.onload = function(){
	setTi;
}
function aa(){
	window.location.reload();
}
	$(function(){
	    $(".clearBkt").click(function(){
	    	$(".modal-body").empty();
	    	$(".modal").css("top","750px");
	    });
	    $(".f12-2f848f").click(function(){
	    	$(".modal-body").append($(this).text() + "<br/>");
	    	var modalHeight = $(".modal").css("height");
	    	height = parseInt = (modalHeight.substring(0,modalHeight.indexOf("px")));
	    	$(".modal").css("top",$(window).height() - height);
	    });
	    
	    $(".btn-primary").click(function(){
			
			var text = $(".modal-body").html();
			//var params = new Object();
			var order = new Object();
			order.products = new Array();
			var rows = text.split("<br>");
			
			
			for(var i = 0; i < rows.length-1; i++){
				var row = rows[i];
				var arr = row.split(" ");
				var product = new Object();
				product.pid = arr[0];
				product.proName = arr[1];
				product.price = arr[2];
				order.products.push(product);		
				
				//{'order':[]}
			}
			
			//getOrderForm.do
			//test
			order.courierId = 4;
			order.createTime = new Date();
			$.post("getOrderForm.action",order,function(d){
				alert(d);
			});//结算的action url,params,function(){}
			
			
		});
	});
	
	//继续大神的东西
	



</script>


<style type="text/css">
#main{
	background-color: #c4e1ff;
}

.modal{
		position:fixed;
		top:750px;
		left:89%;
		overflow:auto;
		width:350px;
	
	}
</style>
</head>
<body id="main">
<table>
	<c:forEach items="${items }" var="ob">
		<tr>
			<td>${ob.id }</td>
			<td>${ob.productName }</td>
			<td>${ob.price }</td>
		</tr>		
	</c:forEach>
</table>	
	
	
	<table width="1002" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="246"><table border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td><img src="images/head.jpg" width="1001" height="246">
						</td>


					</tr>

				</table>
			</td>
		</tr>
		<tr>
			<td><table width="1004" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="93"><a href="index.asp"
						>首页
						</a>
						</td>

						<td width="93"><a href="intro.html">我的订单
						</a>
						</td>

						<td width="93"><a href="honor.html"
						>反馈留言
						</a>
						</td>

						<td width="93"><a href="service.html"
							>购物车
						</a>
						</td>

						<td width="93"><a href="caipu.html"
						>本周菜谱
						</a>
						</td>

						<td width="93"><a href="dishes.asp?sid=1"
						>菜品展示
						</a>
						</td>

						<td width="93"><a href="contact.html"
						>联系我们
						</a>
						</td>
						<td width="249"
							height="38">
						</td>

						<td><c:if test="${loginCustomer==null}">
                   <li>  <a href="firstlogin.jsp">还没注册？ </a> </li>
                   <li>  <a href="buyer_login.jsp">登陆</a></li></c:if>
				<c:if test="${loginCustomer!=null}">
				<li><a href="personalinfo.jsp">${loginCustomer.customerName}</a></li>
				<li><a href="ExitSysAction.action">退出</a></li>
				</c:if>
				</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table width="1002" border="0" align="center" cellpadding="0"
		cellspacing="0" bgcolor="#FFFFFF">
		<tr>
			<td width="220" valign="top" background=""><img
				src="images/left5.jpg" width="221" height="172"><img
				src="images/dcd.jpg" width="221" height="112">
			</td>
			<td width="628" align="center" valign="top" class="bg"><table
					width="90%" height="50" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>&nbsp;</td>
					</tr>
				</table>
				<table width="96%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="31" align="left" bgcolor="#EEEEEE">您可能喜欢的餐品：</td>
					</tr>
					<tr>
						<td align="right">&nbsp;</td>
					</tr>
				</table>

				<table width="90%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr align="center">
						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=54" target="_blank"><img
														src="newspic/1.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">1 油酥饼 12.5</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=44" target="_blank"><img
														src="newspic/2.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">2 烩麻食 12.5</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=45" target="_blank"><img
														src="newspic/3.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">3 红烧排骨面 45.1</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=46" target="_blank"><img
														src="newspic/4.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">西红柿鸡蛋面</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr align='center'>
						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=47" target="_blank"><img
														src="newspic/5.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">红烧牛肉面</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=48" target="_blank"><img
														src="newspic/6.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">葱油拌面</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=49" target="_blank"><img
														src="newspic/7.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">烩面片</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=50" target="_blank"><img
														src="newspic/8.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">水饺</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr align='center'>
						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=51" target="_blank"><img
														src="newspic/9.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">肉丝炒面</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=43" target="_blank"><img
														src="newspic/10.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">岐山哨子面</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=53" target="_blank"><img
														src="newspic/11.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">蛋炒面</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=42" target="_blank"><img
														src="newspic/12.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">农家哨子面</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr align='center'>
						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=58" target="_blank"><img
														src="newspic/13.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">油泼面</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=60" target="_blank"><img
														src="newspic/14.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">凉皮</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=61" target="_blank"><img
														src="newspic/15.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">肉夹馍</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=40" target="_blank"><img
														src="newspic/16.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">酸汤面</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr align='center'>
						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=41" target="_blank"><img
														src="newspic/17.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">北京炸酱面</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=52" target="_blank"><img
														src="newspic/18.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">丸子汤</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=57" target="_blank"><img
														src="newspic/19.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">汤圆</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=56" target="_blank"><img
														src="newspic/20.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">南瓜饼</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr align='center'>
						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=55" target="_blank"><img
														src="newspic/21.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">春卷</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=59" target="_blank"><img
														src="newspic/22.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">醪糟</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr align='center'>
				</table>
				<table width="90%" height="30" border="0" align="center"
					cellpadding="1" cellspacing="2">
					<tr>

					</tr>
				</table></td>
			<td width="154" height="476" valign="bottom"
				background="images/index_20.jpg"><table width="100%" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td height="443" align="center">&nbsp;</td>
					</tr>
					<tr>
					
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr align="center">
			<td height="65" background="images/test.jpg" colspan="3"><table
					width="95%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="txt2">饿了么餐饮公司版权所有 Copyright 2007 &copy; <a
							href="http://www.elm.cn">www.at9.cn</a> All Rights Reserved <br>
							<span class="txt1">网络实名:西安快餐 西安外卖 西安会议餐 西安工作餐 西安订餐</span>&nbsp;&nbsp;&nbsp;&nbsp;<font
							color="#FF0000"><strong>订餐热线：</strong>
						</font><font color="#FF0000">13891903352 13379005653</font>
						</td>
				</table>
			</td>
		</tr>
	</table>
<div class="modal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h3>购物车</h3>
		</div>
		<div class="modal-body">
		</div>
		<div class="modal-footer">
			<a href="#" class="btn clearBkt">清空</a> <a href="#" class="btn btn-primary">去结算</a>
		</div>
	</div>







	<SCRIPT language=JavaScript> 
	

								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=54" target="_blank"><img
														src="newspic/1.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">1 油酥饼 13.5</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=44" target="_blank"><img
														src="newspic/2.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">2 烩麻食 10</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=45" target="_blank"><img
														src="newspic/3.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">3 红烧排骨面 4.2</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=46" target="_blank"><img
														src="newspic/4.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">4 西红柿鸡蛋面 11.1</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr align='center'>
						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=47" target="_blank"><img
														src="newspic/5.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">红烧牛肉面</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=48" target="_blank"><img
														src="newspic/6.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">葱油拌面</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=49" target="_blank"><img
														src="newspic/7.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">烩面片</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=50" target="_blank"><img
														src="newspic/8.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">水饺</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr align='center'>
						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=51" target="_blank"><img
														src="newspic/9.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">肉丝炒面</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=43" target="_blank"><img
														src="newspic/10.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">岐山哨子面</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=53" target="_blank"><img
														src="newspic/11.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">蛋炒面</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=42" target="_blank"><img
														src="newspic/12.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">农家哨子面</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr align='center'>
						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=58" target="_blank"><img
														src="newspic/13.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">油泼面</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=60" target="_blank"><img
														src="newspic/14.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">凉皮</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=61" target="_blank"><img
														src="newspic/15.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">肉夹馍</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=40" target="_blank"><img
														src="newspic/16.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">酸汤面</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr align='center'>
						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=41" target="_blank"><img
														src="newspic/17.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">北京炸酱面</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=52" target="_blank"><img
														src="newspic/18.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">丸子汤</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=57" target="_blank"><img
														src="newspic/19.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">汤圆</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=56" target="_blank"><img
														src="newspic/20.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">南瓜饼</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr align='center'>
						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=55" target="_blank"><img
														src="newspic/21.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">春卷</td>
								</tr>
							</table>
						</td>

						<td><table width="150" border="0" cellpadding="0"
								cellspacing="5" class="f13pro">
								<tr bgcolor="#FFFFFF">
									<td width="30%" height="120" align="center"><table
											border="0" cellpadding="0" cellspacing="2" bgcolor="#996600">
											<tr>
												<td><a href="news_nn.asp?id=59" target="_blank"><img
														src="newspic/22.jpg" width="140" height="110" border="0">
												</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="28" align="center" bgcolor="#F3F3F3"
										class="f12-2f848f">醪糟</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr align='center'>
				</table>
				<table width="90%" height="30" border="0" align="center"
					cellpadding="1" cellspacing="2">
					<tr>

					</tr>
				</table></td>
			<td width="154" height="476" valign="bottom"
				background="images/index_20.jpg"><table width="100%" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td height="443" align="center">&nbsp;</td>
					</tr>
					<tr>
						<td align="right"><img src="images/test.jpg" width="133"
							height="33">
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<div class="modal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h3>购物车</h3>
		</div>
		<div class="modal-body">
			<p>One fine body…</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn">清空</a> <a href="#" class="btn btn-primary">去结算</a>
		</div>
	</div>
	







	<SCRIPT language=JavaScript> 
>>>>>>> .r90
nereidFadeObjects = new Object();
nereidFadeTimers = new Object();
function nereidFade(object, destOp, rate, delta){
if (!document.all)
return
    if (object != "[object]"){  //do this so I can take a string too
        setTimeout("nereidFade("+object+","+destOp+","+rate+","+delta+")",0);
        return;
    }
    clearTimeout(nereidFadeTimers[object.sourceIndex]);
    diff = destOp-object.filters.alpha.opacity;
    direction = 1;
    if (object.filters.alpha.opacity > destOp){
        direction = -1;
    }
    delta=Math.min(direction*diff,delta);
    object.filters.alpha.opacity+=direction*delta;
    if (object.filters.alpha.opacity != destOp){
        nereidFadeObjects[object.sourceIndex]=object;
        nereidFadeTimers[object.sourceIndex]=setTimeout("nereidFade(nereidFadeObjects["+object.sourceIndex+"],"+destOp+","+rate+","+delta+")",rate);
    }
}
</SCRIPT>
	<SCRIPT language=JavaScript type=text/JavaScript>function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
</SCRIPT>


<!--  




	<SCRIPT>
var online= new Array();
if (!document.layers)
document.write('<div id="divStayTopLeft" style="position:absolute">')
</SCRIPT>
	<TABLE class=sbody cellSpacing=0 cellPadding=0 align=center border=0>
		<TBODY>
			<TR>
				<TD><IMG height=55 src="images/test.jpg" width=118 border=0>
				</TD>
			</TR>



			<script src="http://webpresence.qq.com/getonline?Type=1&45017763:"></script>
			<TR>
				<TD vAlign=center background=images/head.jpg height=30><SCRIPT>
if (online[0]==0)
document.write("&nbsp;&nbsp;<img src=images/test.jpg height='20' width='20' border=0 align=middle><a target=blank href='http://wpa.qq.com/msgrd?V=1&Uin=45017763&Site=在线咨询&Menu=no' title='客服QQ一不在线，请留言'> 客服QQ一</a>");
else
document.write("&nbsp;&nbsp;<img src=images/test.jpg height='20' width='20' border=0 align=middle><a target=blank href='http://wpa.qq.com/msgrd?V=1&Uin=45017763&Site=在线咨询&Menu=no' title='客服QQ一在线可以即时交谈'> 客服QQ一</a>");
</SCRIPT></TD>
			</TR>



			<script src="http://webpresence.qq.com/getonline?Type=1&56050673:"></script>
			<TR>
				<TD vAlign=center background=images/head.jpg height=30><SCRIPT>
if (online[0]==0)
document.write("&nbsp;&nbsp;<img src=qq/images/llo.gif border=0 align=middle><a target=blank href='http://wpa.qq.com/msgrd?V=1&Uin=56050673&Site=在线咨询&Menu=no' title='客服QQ二不在线，请留言'> 客服QQ二</a>");
else
document.write("&nbsp;&nbsp;<img  src=qq/images/llon.gif  border=0 align=middle><a target=blank href='http://wpa.qq.com/msgrd?V=1&Uin=56050673&Site=在线咨询&Menu=no' title='客服QQ二在线可以即时交谈'> 客服QQ二</a>");

</SCRIPT></TD>
			</TR>
			<TR>
				<TD><IMG height=21 src="images/kefu_down.gif" width=118
					border=0>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	



	<SCRIPT type=text/javascript>

//Enter "frombottom" or "fromtop"
var verticalpos="frombottom"
if (!document.layers)
document.write('</div>')
function JSFX_FloatTopDiv()
{
	var startX =870,
	startY = 280;
	var ns = (navigator.appName.indexOf("Netscape") != -1);
	var d = document;
	function ml(id)
	{
		var el=d.getElementById?d.getElementById(id):d.all?d.all[id]:d.layers[id];
		if(d.layers)el.style=el;
		el.sP=function(x,y){this.style.left=x;this.style.top=y;};
		el.x = startX;
		if (verticalpos=="fromtop")
		el.y = startY;
		else{
		el.y = ns ? pageYOffset + innerHeight : document.body.scrollTop + document.body.clientHeight;
		el.y -= startY;
		}
		return el;
	}
	window.stayTopLeft=function()
	{
		if (verticalpos=="fromtop"){
		var pY = ns ? pageYOffset : document.body.scrollTop;
		ftlObj.y += (pY + startY - ftlObj.y)/8;
		}
		else{
		var pY = ns ? pageYOffset + innerHeight : document.body.scrollTop + document.body.clientHeight;
		ftlObj.y += (pY - startY - ftlObj.y)/8;
		}
		ftlObj.sP(ftlObj.x, ftlObj.y);
		setTimeout("stayTopLeft()", 10);
	}
	ftlObj = ml("divStayTopLeft");
	stayTopLeft();
}
JSFX_FloatTopDiv();
</SCRIPT>

-->



		<script type="text/javascript">

	<script type="text/javascript">

var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Fe44511a4a187fbc76120979371f4288d' type='text/javascript'%3E%3C/script%3E"));
</script>


</body>
</html>

