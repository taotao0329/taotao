<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Highcharts Example</title>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
<script src="<%=request.getContextPath()%>/js/highcharts.js"></script>
<%-- <script src="<%=request.getContextPath()%>/js/default.js"></script> --%>




<script type="text/javascript">
	var chart;
	var chart2;
	var chart3;
	$(function() {
		    var data1 = $("#data1").val();
			var tmp = eval("(" + data1 + ")");

			var data2 = $("#data2").val();
			var tmp2 = eval("(" + data2 + ")");

			var data3 = $("#data3").val();
			var tmp3 = eval("(" + data3 + ")");

			var data4 = $("#data4").val();
			var tmp4 = eval("(" + data4 + ")");
			
			var tmp5=[{name : '长春',y : 45.2,color : 'red'},{name : '沈阳',y : 44,color : 'black'},{name : '哈尔滨',y : 47.7,color : 'green'}];
			
			var constant ={renderTos:[{renderTo:'container'},{renderTo:'container1'},{renderTo:'container2'}],
					text:'2011年东北三大城市水果消费量统计图',
					xAxis:{categories:['柑橘', '香蕉', '苹果', '梨子'],labels:18},
					yAxis:{title:'消费量（万吨）',lineWidth:2},
					labels:{items:[{html:'水果消费总量对比',style:{left : '48px',top : '28px'}}]},
					credits:{text:'',href:''},
					series:[{type : 'column',name : '长春',data : tmp,color : '#FF9655'},{type : 'column',name : '沈阳',data : tmp2},{type : 'column',name : '哈尔滨',data : tmp3},{type : 'spline',name : '平均值',data : tmp4},{type : 'pie',name : '水果消费总量',data:tmp5}]
					};
			
			
		chart3 = new Highcharts.Chart({
			colors: ['#058DC7', '#50B432', '#ED561B', '#DDDF00', '#24CBE5', '#64E572', '#FF9655', 
			         '#FFF263', '#6AF9C4'] ,
				chart : {
					renderTo : constant.renderTos[2].renderTo,
					plotBackgroundColor : null,
					plotBorderWidth : null,
					plotShadow : false,
					backgroundColor:'',
					defaultSeriesType:'line'
				},
				title : {
					text : 'Browser market shares at a specific website, 2010',
					style:{color: 'red',fontSize:'26px'}
				},
				Subtitle:{
					text : '这是副标题OK',
					style:{color: '#058DC7',fontSize:'10px'}
				},
				tooltip : {
					formatter : function() {
						return '<b>' + this.point.name + '</b>: ' + this.y + ' %';
					}
				},
				plotOptions : {
					pie : {
						allowPointSelect : true,
						cursor : 'pointer',
						dataLabels : {
							enabled : true,
							color : '#000000',
							connectorColor : '#000000',
							formatter : function() {
								return '<b>' + this.point.name + '</b>: ' + this.y
										+ ' %';
							}
						}
					}
				},
				series : [ {
					
					type : 'pie',
					name : 'Browser share',
					data : [ [ 'Firefox', 45.0 ], [ 'IE', 26.8 ], {
						name : 'Chrome',
						y : 12.8,
						sliced : true,
						selected : true
					}, [ 'Safari', 8.5 ], [ 'Opera', 6.2 ], [ 'Others', 0.7 ] ]
				} ]
				
			}); 
			
		chart = new Highcharts.Chart({
			chart : {
				renderTo : constant.renderTos[0].renderTo //关联页面元素div#id 
			},
			title : { //图表标题 
				text : constant.text
			},
			xAxis : { //x轴 
				categories : constant.xAxis.categories, //X轴类别 
				labels : {
					y : constant.xAxis.labels
				}
			//x轴标签位置：距X轴下方18像素 
			},
			yAxis : { //y轴 
				title : {
					text : constant.yAxis.title
				}, //y轴标题 
				lineWidth : constant.yAxis.lineWidth
			//基线宽度 
			},
			tooltip : { /* 数据点提示框 plotOptions：数据点选项 */
				formatter : function() { //格式化鼠标滑向图表数据点时显示的提示框 
					var s;
					if (this.point.name) { // 饼状图 
						s = '<b>' + this.point.name + '</b>: <br>' + this.y
								+ '万吨2(' + /* twoDecimal(this.percentage) */ + '%)';
					} else {
						s = '' + this.x + ': ' + this.y + '万吨';
					}
					return s;
				}
			},
			labels : { //图表标签 
				items : [ {
					html : constant.labels.items[0].html,
					style : {
						left : constant.labels.items[0].style.left,
						top : constant.labels.items[0].style.top
					}
				} ]
			},
			exporting : {
				enabled : false
			//设置导出按钮不可用 
			},
			credits : {
				text : constant.text, /* 出现一个tag */
				href : constant.href
			},
			series : [ { //数据列 
				type : constant.series[0].type,
				name : constant.series[0].name,
				data : constant.series[0].data,
				color : constant.series[0].color
			}, {
				type : constant.series[1].type,
				name :  constant.series[1].name,
				data : constant.series[1].data,
			}, {
				type : constant.series[2].type,
				name : constant.series[2].name,
				data : constant.series[2].data,
			}, {
				type :  constant.series[3].type,
				name : constant.series[3].name,
				data : [6.5, 9.4, 13.2, 18.6],
			}, {
				type : constant.series[4].type, //饼状图 
				name : constant.series[4].name,
				data : constant.series[4].data,
				center : [ 100, 80 ], //饼状图坐标 
				size : 100, //饼状图直径大小 
				dataLabels : {
					enabled : false
				//不显示饼状图数据标签 
				}
			} ]
		});

		chart2 = new Highcharts.Chart({
			chart : {
				renderTo : constant.renderTos[1].renderTo/* constant.renderTo */ //关联页面元素div#id 
			},
			title : { //图表标题 
				text : constant.text
			},
			xAxis : { //x轴 
				categories : constant.xAxis.categories, //X轴类别 
				labels : {
					y : constant.xAxis.labels
				}
			//x轴标签位置：距X轴下方18像素 
			},
			yAxis : { //y轴 
				title : {
					text : constant.yAxis.title
				}, //y轴标题 
				lineWidth : constant.yAxis.lineWidth
			//基线宽度 
			},
			tooltip : { /* 数据点提示框 plotOptions：数据点选项 */
				formatter : function() { //格式化鼠标滑向图表数据点时显示的提示框 
					var s;
					if (this.point.name) { // 饼状图 
						s = '<b>' + this.point.name + '</b>: <br>' + this.y
								+ '万吨2(' + /* twoDecimal(this.percentage) */ + '%)';
					} else {
						s = '' + this.x + ': ' + this.y + '万吨';
					}
					return s;
				}
			},
			labels : { //图表标签 
				items : [ {
					html : constant.labels.items[0].html,
					style : {
						left : constant.labels.items[0].style.left,
						top : constant.labels.items[0].style.top
					}
				} ]
			},
			exporting : {
				enabled : false
			//设置导出按钮不可用 
			},
			credits : {
				text : constant.text, /* 出现一个tag */
				href : constant.href
			},
			series : [ { //数据列 
				type : constant.series[0].type,
				name : constant.series[0].name,
				data : constant.series[0].data,
				color : constant.series[0].color
			}, {
				type : constant.series[1].type,
				name :  constant.series[1].name,
				data : constant.series[1].data,
			}, {
				type : constant.series[2].type,
				name : constant.series[2].name,
				data : constant.series[2].data,
			}, {
				type : constant.series[3].type,
				name : constant.series[3].name,
				data : constant.series[3].data,
			}, {
				type : constant.series[4].type, //饼状图 
				name : constant.series[4].name,
				data : constant.series[4].data,
				center : [ 100, 80 ], //饼状图坐标 
				size : 100, //饼状图直径大小 
				dataLabels : {
					enabled : false
				//不显示饼状图数据标签 
				}
			} ]
		});
	/* 	test(); */

	});
</script>
</head>
<body>
	<!-- 用于js或者jquery脚本中使用 -->
	<input type="hidden" id="path" value="<%=request.getContextPath()%>" />

	<div id="container"
		style="min-width: 800px; height: 400px; margin: 0 auto"></div>
	<div id="container1"
		style="min-width: 800px; height: 400px; margin: 0 auto"></div>
	<div id="container2"
		style="min-width: 800px; height: 400px; margin: 0 auto"></div>
	<input type="hidden" id="data1" value="${data1}" />
	<input type="hidden" id="data2" value="${data2}" />
	<input type="hidden" id="data3" value="${data3}" />
	<input type="hidden" id="data4" value="${data4}" />
	<input type="button" id="test" value="测试" />
	<span id="test2">test</span>
</body>
</html>
