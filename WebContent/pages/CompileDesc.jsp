<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
HttpSession sess = request.getSession();
String sign = (String)sess.getAttribute("sign");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <base href="<%=basePath%>"> --%>
<title>PTS专家技术服务</title>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/stylesheet.css" />
<script src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
<script src="<%=request.getContextPath()%>/js/KPI.js"></script>
<script src="<%=request.getContextPath()%>/js/highcharts.js"></script>
<script type="text/javascript">

var chart;
$(function(){
	chart = new Highcharts.Chart({
		chart : {
			renderTo : 'container2',
			plotBackgroundColor : null,
			plotBorderWidth : null,
			plotShadow : false
			},
		title : {
			text : '当前构建呈现图',
			color : 'red'
			},
		credits : {
			enabled : false
			},
		exporting : {
			enabled : false
			},
		tooltip : {/**数据点提示信息 */
			formatter : function() 
			  {
				return '<b>'+ this.point.name+ '</b>: '+ Highcharts.numberFormat(this.percentage,2);
			  }
			},
		plotOptions : {
			pie : {
				allowPointSelect : true,
				cursor : 'pointer',
				showInLegend : true,
				dataLabels : 
				  {
						enabled : true,
						color : '#000000',
						connectorColor : '#000000',
						formatter : function()
						   {
									return '<b>'
											+ this.point.name
											+ '</b>: '
											+ Highcharts.numberFormat(
													this.percentage, 2) + ' %';
							}
					}
			  }
		},
					series : [{ 
					         type : 'pie',
					         name : '',
					         data : data1
					        	 
					}]
				});
	//通过Ajax获取图表数据
	/* var data1;
	$.get($("#path").val() + "/execute/execute_getDatas.action",function(data, textStatus) 
	  {
		if (textStatus == 'success')
		 {
			data1 = eval("(" + data + ")");
			chart.series[0].setData(data1);
		}
	}); */
	var data1 = [];
	var url = $("#path").val() + "/execute/execute_getDatas.action";
	var param={'callBackDims':$("#highChar").val()};
	$.get(url,param,function(data, textStatus) 
	  {
		if (textStatus == 'success')
		 {
			var res  = eval("(" + data + ")");
			$.each(res,function(inde,val){
				data1.push(val);
			});
			chart.series[0].setData(data1[0]);
		}
	});
	var data2={};
	var url2 =$("#path").val() + "/execute/execute_getOthers.action";
	$.get(url2,function(data,state){
		/* <li><span class="gc-list-infor">代码总行数</span><span class="gc-list-num">1000行</span></li> */
			$("#codeRow").after(data.row+"行");
			$("#packCount").after(data.package_+"个");
			$("#fileCount").after(data.file+"个");
			$("#classCount").after(data.class_+"个");
			$("#functionCount").after(data.function_+"个");
			$("#zhushiRow").after(data.zhushi+"行");
	},'json');

})
</script>
</head>
<body>
	<input type="hidden" id="path" value="<%=request.getContextPath() %>" />
	<input type="hidden" id="highChar"
		value="<s:property value="superDims"/>" />
	<input type="hidden" id="others" />
	<div class="navtop">
		<div class="navtopcon">
			<ul>
				<li><a href=""><i class="icon-share-alt"></i>退出</a></li>
				<li><a href=""><i class="icon-envelope"></i>消息<span
						class="label">5</span><b class="caret"></b></a></li>
				<li>中软国际科技服务有限公司<span class="white">张三</span>(普通用户)
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
					<li><a href="">我的首页</a></li>
					<li><a href="">产品服务</a></li>
					<li><a href="">技术支持</a></li>
					<li><a href="">服务设置</a></li>
					<li class="sel"><a href="">服务执行</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="sitemap">
		<div class="sitemapcon">
			<div class="sitemapcon-left">
				<i class="icon-sitemap"></i>结果详情
			</div>
			<div class="sitemapcon-right">
				当前位置：<a href="">服务执行</a> > <a href="">结果呈现</a> > <a href="">结果详情</a>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="graphics">
			<div class="graphics-result">
				<div class="ordertitle">检测结果</div>
				<div class="graphics-con">
					<div class="gc-score">
						<!--score01为绿色样式score02为橙色样式score03为红色样式-->
						<div class="gc-score-pic">
							<div
								<s:if test="score lte 60">class="score03"
            	</s:if>
								<s:elseif test="score gte 60 && score lte 80">class="score02"</s:elseif>
								<s:else>class="score01"</s:else>>
								<span class="s-num"><s:property value="score" /></span><span
									class="s-word">分</span>
							</div>
						</div>
						<div class="gc-score-txt">
							<s:if test="score lte 60">那啥啥啥啥
            	</s:if>
							<s:elseif test="score gte 60 && score lte 80">您的检测状态良好，请继续保持！</s:elseif>
							<s:else>击败了90%的用户</s:else>
						</div>
						<div class="gc-score-button">
							<input name="" type="button" value="下载报告" />
						</div>
					</div>
					<ul class="gc-list">
						<li><span class="gc-list-infor">代码总行数</span><span
							class="gc-list-num" id="codeRow"></span></li>
						<li><span class="gc-list-infor">包个数</span><span
							class="gc-list-num" id="packCount"></span></li>
						<li><span class="gc-list-infor">文件数</span><span
							class="gc-list-num" id="fileCount"></span></li>
						<li><span class="gc-list-infor">类个数</span><span
							class="gc-list-num" id="classCount"></span></li>
						<li><span class="gc-list-infor">函数个数</span><span
							class="gc-list-num" id="functionCount"></span></li>
						<li><span class="gc-list-infor">注释总行数</span><span
							class="gc-list-num" id="zhushiRow"></span></li>
					</ul>
				</div>
			</div>
			<div class="graphics-chart">
				<div class="ordertitle">图形展示</div>
				<div class="graphics-con">
					<%-- <img src="<%=request.getContextPath() %>/images/pic2.jpg" /> --%>
					<div id="container2"
						style="min-width: 600px; height: 300px; margin: 0 auto"></div>
				</div>
			</div>
		</div>
		<div class="overview">
			<div class="introduce-title">概要分析</div>
			<div class="overview-txt">
				<p>中国最有影响力的新闻评论与观点咨询平台,收集各媒体社评,社会各界对新近发生的新闻事件所发表的言论,提供包括时事、财经、体育、娱乐各类评论分析文章,深度新浪评论,中国最有影响力的新闻评论与观点咨询平台,收集各媒体社评,社会各界对新近发生的新闻事件所发表的言论,提供包括时事、财经、体育、娱乐各类评论分析文章,深度新浪评论,中国最有影响力的新闻评论与观点咨询平台,收集各媒体社评,社会各界对新近发生的新闻事件所发表的言论,提供包括时事、财经、体育、娱乐各类评论分析文章,深度。</p>
			</div>
		</div>
		<div class="metric">
			<div class="introduce-title">度量指标</div>
			<div class="metriccon">
				<!--  start-->
				<s:iterator value="result" id="su" status="off">
					<s:set value="value" id="desc"></s:set>
					<div
						class="metric-tilte mt<s:if test='key=="编译"'>d</s:if><s:elseif test='key=="规范"'>a</s:elseif><s:elseif test='key=="可维护"'>b</s:elseif><s:elseif test='key=="可靠"'>c</s:elseif>">
						<div class="mtleft">
							<s:property value="key" />
						</div>
						<div class="mtright">
							<span class="grey">共</span>
							<s:property value="value.size" />
							<span class="grey">项</span> <a class="open"
								id="open<s:property value="#off.index"/>"
								onclick="javascript:closedParent('<s:property value="#off.index"/>')"></a>
						</div>
					</div>
					<div class="metric-list"
						id="metric-list<s:property value="#off.index"/>">
						<s:iterator value="desc" id="de" status="chil">
							<s:set value="value" id="child" />
							<div class="ml-title">
								<span class="mlt-bt"> <s:property value="key" />（<span
									class="font01">10分</span>） <a href="" class="helplabel"> <img
										src="<%=request.getContextPath() %>/images/helplabel.png" />
								</a>
								</span>
								<button class="arrow01"
									id="arrow01<s:property value="#chil.index"/>"></button>

							</div>
							<ul id="ul<s:property value="#chil.index"/>">
								<s:iterator value="child" id="cd" status="stat">
									<li>
										<div <s:if test='#stat.index%2=="0"'>class="licon-grey"</s:if>
											<s:else>class="licon-white"</s:else>>
											<span class="lg-bt"><s:property value="#cd.childTag" /></span>
											<span class="lg-r"><b>得分：<s:property
														value="#cd.score" />分
											</b><b>1分/个</b><b>状态：优</b></span>
										</div>
									</li>
								</s:iterator>
							</ul>
						</s:iterator>
					</div>
				</s:iterator>
				<!--  -->
				<!--  end-->
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
</body>
</html>