<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
  HttpSession sess = request.getSession();
  String user = (String)sess.getAttribute("userName");
  Integer userType =(Integer)sess.getAttribute("userType");
  String enterpriseName = (String)sess.getAttribute("enterpriseName");
  String proName = (String)sess.getAttribute("proName");
  String role = "";
  if(userType==0)
  {
	  role="PM";
  }else if(userType==1)
  {
	  role="项目组成员";
  }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>PTS专家技术服务-首页</title>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/topanv.js"></script>
<script src="js/jquery.event.drag-1.5.min.js"></script>
<script src="js/jquery.touchSlider.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	$(".main_visual").hover(function(){
		$("#btn_prev,#btn_next").fadeIn()
		},function(){
		$("#btn_prev,#btn_next").fadeOut()
		})
	$dragBln = false;
	$(".main_image").touchSlider({
		flexible : true,
		speed : 200,
		btn_prev : $("#btn_prev"),
		btn_next : $("#btn_next"),
		paging : $(".flicking_con a"),
		counter : function (e) {
			$(".flicking_con a").removeClass("on").eq(e.current-1).addClass("on");
		}
	});
	$(".main_image").bind("mousedown", function() {
		$dragBln = false;
	})
	$(".main_image").bind("dragstart", function() {
		$dragBln = true;
	})
	$(".main_image a").click(function() {
		if($dragBln) {
			return false;
		}
	})
	timer = setInterval(function() { $("#btn_next").click();}, 5000);
	$(".main_visual").hover(function() {
		clearInterval(timer);
	}, function() {
		timer = setInterval(function() { $("#btn_next").click();}, 5000);
	})
	$(".main_image").bind("touchstart", function() {
		clearInterval(timer);
	}).bind("touchend", function() {
		timer = setInterval(function() { $("#btn_next").click();}, 5000);
	})
});
</script>
</head>

<body>
	<div class="header">
		<div class="main-header">
			<div class="logo">
				<img src="image/PTSlogo.png" width="176" height="57" />
			</div>
			<div class="menu">
				<div class="defu">
					<a href="#" target="_self">网站首页</a>
				</div>
				<div class="defu">
					<a href="#" target="_self">产品服务</a>
				</div>
				<div id="menuslider">
					<div selec="support" class="posbox">
						<a href="#">技术支持</a>
					</div>
					<div id="seledbox" class="posiabox"
						style="display: none; left: 1px;"></div>
				</div>
				<div class="defu">
					<a href="#" target="_self">提交工单</a>
				</div>
			</div>
			<div class="nav-right">退出</div>
		</div>
	</div>
	<div class="banner">
		<div class="banner-txt">图片上可放PTS特色服务</div>
		<div class="main_visual">
			<div class="flicking_con">
				<div class="flicking_inner">
					<a href="javascript:">1</a> <a href="javascript:">2</a>
				</div>
			</div>
			<div class="main_image">
				<ul>
					<li><span class="img_1"></span></li>
					<li><span class="img_2"></span></li>
				</ul>
				<a href="javascript:;" id="btn_prev"></a> <a href="javascript:;"
					id="btn_next"></a>
			</div>
		</div>
	</div>
	<div class="notice">
		<%-- <div class="notice-txt">
		当前用户:<%=user %>&nbsp;&nbsp;&nbsp;角色:<%=role %> <br/>
		 通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告通知公告</div> --%>
		<div class="notice-txt">
			<!--  mainInfo-->
			<s:if test='null !=mainInfo && mainInfo.size!=0'>
				<s:iterator value="mainInfo" id="info">
					<p>
						1、<%=enterpriseName %>订购
						<s:property value="#info.scheName" />
						:PTS服务，包含
						<s:property value="#info.maxPro" />
						个项目，
						<s:property value="#info.maxCi" />
						个CI方案
					</p>
					<p>
						2、已授权项目有
						<s:property value="#info.proNum" />
						个
					</p>
					<p>
						3、<%=proName %>项目已经创建
						<s:property value="isCi" />
						个CI方案
					</p>
				</s:iterator>
			</s:if>
		</div>
	</div>
	<div class="serviceblock">
		<div class="service-title">
			<p class="stbt">PTS专家技术服务</p>
		</div>
		<div class="button">
			<!-- disp_get.action -->
			<a href="inspection/inspection_findAll.action"><div
					class="button01"></div></a>
			<!-- resu -->
			<s:if test='resu!="0"'>
				<div class="button02"></div>
			</s:if>
			<%-- <s:else>
			    <div class="button02" style="background-color:#F00;"></div>
			</s:else> --%>
		</div>
	</div>
	<div class="footer">
		<div class="footer-top">
			<div class="footer-top-con">
				<div class="ftc-block">
					<div class="ftc-bt">关于</div>
					<ul class="ftc-bc">
						<li><a href="">关于我们</a></li>
						<li><a href="">用户协议</a></li>
						<li><a href="">安全声明</a></li>
					</ul>
				</div>
				<div class="ftc-block">
					<div class="ftc-bt">新手指南</div>
					<ul class="ftc-bc">
						<li><a href="">成为接包方</a></li>
						<li><a href="">接包指南</a></li>
						<li><a href="">问题中心</a></li>
						<li><a href="">规则中心</a></li>
					</ul>
				</div>
				<div class="ftc-block">
					<div class="ftc-bt">支持</div>
					<ul class="ftc-bc">
						<li><a href="">问题反馈</a></li>
						<li><a href="">服务渠道</a></li>
					</ul>
				</div>
				<div class="ftc-block">
					<div class="ftc-bt">微信公众号</div>
				</div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="footer-bottom-con">
				Copyright © 2015 中软国际<span>京ICP备041626号</span>
			</div>
		</div>
	</div>
</body>
</html>
