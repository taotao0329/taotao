<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
  HttpSession sess = request.getSession();
  String user = (String)sess.getAttribute("userName");
  Integer userType =(Integer)sess.getAttribute("userType");
  String enterpriseName = (String)sess.getAttribute("enterpriseName");
  String proName = (String)sess.getAttribute("proName");
  userType=2;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PTS首页</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/stylesheet.css" />
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/jquery-1.7.2.min.js"></script>
<script type=text/javascript
	src="<%=request.getContextPath() %>/js/slider.js"></script>
<script type=text/javascript
	src="<%=request.getContextPath() %>/js/slider_options.js"></script>
<script type=text/javascript
	src="<%=request.getContextPath() %>/js/startUp.js"></script>
<script type="text/javascript">

</script>
</head>

<body>
	<!-- 用于js或者jquery脚本中使用 -->
	<input type="hidden" id="path" value="<%=request.getContextPath() %>" />
	<div class="qq">在线咨询</div>
	<div class="navtop">
		<div class="navtopcon">
			<ul>
				<li><a href=""><i class="icon-share-alt"></i>退出</a></li>
				<li><a href=""><i class="icon-envelope"></i>消息<span
						class="label">5</span><b class="caret"></b></a></li>
				<li>企业名称:<%=enterpriseName %> <span class="white"><%=user %></span>
					<%
        	  if(userType==0)
        	  {%> PM <% }else if(userType==1){%> 项目成员 <%} else if(userType==2){%>
					领导过来视察了 <%} else{%> 没权限 <%} %>
				</li>
			</ul>
		</div>
	</div>
	<div class="top">
		<div class="topcon">
			<div class="logo">
				<a href="index.html"><img
					src="<%=request.getContextPath() %>/images/logo.png" /></a>
			</div>
			<div class="menu">
				<ul>
					<li class="sel"><a
						href="<%=request.getContextPath()%>/portal/main/setUp_init.action">我的首页</a></li>
					<li><a href="">产品服务</a></li>
					<li><a href="">技术支持</a></li>
					<%if(userType==0 || userType==2){%>
					<li><a
						href="<%=request.getContextPath()%>/inspection/inspection_findAll.action">服务设置</a></li>
					<%} %>
					<s:if test='resu!="0"'>
						<li><a href="">服务执行</a></li>
					</s:if>
				</ul>
			</div>
		</div>
	</div>
	<div class="banner"></div>
	<div class="content">
		<div class="orderblock">
			<div class="order">
				<div class="ordertitle">我的订购</div>
				<s:if test='null !=mainInfo && mainInfo.size!=0'>
					<s:iterator value="mainInfo" id="info">
						<div class="odercon">
							<div class="orderline">
								<div class="orderline-left">
									<span class="li-lead"><i class="icon-order"></i></span><span
										class="li-txt">订购的服务：<s:property value="#info.scheName" /></span>
								</div>
								<div class="orderline-right">
									<span class="li-lead"><i class="icon-task"></i></span><span
										class="li-txt">任务个数：<s:property value="maxCiPortal" />个
									</span>
								</div>
							</div>
							<div class="orderline">
								<div class="orderline-left">
									<span class="li-lead"><i class="icon-project"></i></span> <span
										class="li-txt">项目个数：<s:property value="#info.maxPro" />个
									</span>
								</div>
								<div class="orderline-right">
									<span class="li-lead"><i class="icon-author"></i></span><span
										class="li-txt">授权项目：<s:property value="#info.proNum" />个
									</span>
								</div>
							</div>
							<div class="orderpro">
								<span class="li-lead"><i class="icon-hands"></i></span><span
									class="li-txt"><%=proName %>项目：已经创建<s:property
										value="isCi" />个CI任务</span>
							</div>
						</div>
					</s:iterator>
				</s:if>
			</div>
			<div class="notice">
				<div class="ordertitle">通知公告</div>
				<div class="noticecon">
					<ul>
						<s:iterator value="notices" id="mess">
							<li><i class="icon-noticeli"></i><a
								href="javascript:descMess('<s:property value="#mess.noticeCode"/>');void(0);"><s:property
										value="#mess.title" /></a><span class="notice-time"><s:property
										value="#mess.publishBeginTime" /></span></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="package">
			<div class="package-title">服务套餐</div>
			<div class="package-subtitle">使用PTS服务，拥有海量服务特权，快捷高效的解决您的问题</div>
			<div class="cms-home">
				<div class="indent-col-main">
					<div class="block-slider">
						<div class="anythingslider">
							<ul id="slider_list" class="products-grid">
								<s:iterator value="ptsList" id="pts" status="p">
									<input type="hidden" id="code"
										value="<s:property value="#pts.pk_id"/>" />
									<li class="item">
										<div class="package-block">
											<div class="package-block-title">
												<s:property value="#pts.sch_name" />
											</div>
											<div class="price">
												<s:property value="#pts.sch_money" />
												RMB/年
											</div>
											<div class="package-row prwhite">
												<span class="num"><s:property
														value="#pts.sch_project_max" /></span>项目个数
											</div>
											<div class="package-row">
												<span class="num"><s:property value="#pts.sch_ci_max" /></span>任务个数
											</div>
											<div class="package-row prwhite">
												<span class="num"><s:property
														value="#pts.sch_dimensions" /></span>
											</div>
											<div class="package-button">
												<a
													href="javascript:showDesc('<s:property value="#pts.pk_id"/>');void(0);">详情查看</a>
											</div>
										</div>
									</li>
								</s:iterator>
							</ul>
						</div>
					</div>
					<div id="left_but" class="box-left"></div>
					<div id="right_but" class="box-right"></div>
				</div>
			</div>
		</div>
		<div class="introduce">
			<div class="introduce-title">服务介绍</div>
			<div class="introducecon">
				<div class="introduce-arrow"></div>
				<div class="introduce-txt">中软Professional Technology Service
					(简称PTS服务)，是中软研发质量保障系统和在线软件服务。 PTS以软件质量改进为中心、配合公司的Joint
					Force系统提供软件在线的各种质量保证服务。PTS将企业研发过程中软件版本在服务中进行有效的处理，开发人员通过在线系统平台提供的服务完成软件版本的自动编译、质量评估、内存泄露检测、代码安全扫描等。项目经理可查询该软件版本的质量评估报告等，通过多维度的分析，决定是否发布哪个软件版本。为软件版本质量保证提供有力的服务支持。</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="footercon">
			<div class="footer-left">Copyright &copy; 2015</div>
			<div class="footer-right">
				<a href="" class="f">关于我们</a><a href="" class="f">帮助中心</a>
			</div>
		</div>
	</div>
</body>
</html>