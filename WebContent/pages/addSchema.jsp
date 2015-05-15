<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	href="<%=request.getContextPath()%>/css/backpage.css" />
<script src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/jquery-ui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/jquery-ui-timepicker-addon.css" />
<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<script
	src="<%=request.getContextPath()%>/js/jquery-ui-timepicker-addon.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui-sliderAccess.js"></script>
<script type="text/javascript">
   $(function(){
	   /* 设置时间控件格式   用于定时执行 单次*/
	   $('#time1').datetimepicker({
		   dateFormat: "yy-mm-dd",
		   timeFormat: "HH:mm:ss"
	   });
	  /*  $('#time2').datetimepicker({
		   dateFormat: "yy-mm-dd",
		   timeFormat: "HH:mm:ss"
	   }); */
	   /* 默认手工检查 */
	   $('input:radio[name="sche.ins_build_type"][value="1"]').prop('checked', true);
	   /* 页面加载完成 隐藏定时执行的附件 */
	   $("#pp1,#pp2").hide();
	   $("#bbb").change(function(){
		   $('#time2').val('');
		   var value = $(this).val();
		   if(value==0 || value==2)
			  {
				  $("#bbb1").show();
				  /* 设置时间类型 时分秒 */
				  $('#time2').timepicker({
					   timeFormat: "HH:mm:ss"
				   });
			  }else
			  {
				  $("#bbb1").hide();
		      }
	   });
	   $("#aaa").change(function(){
		  var val = $(this).val();/* 获取select的value */
		  var text = $(this).find("option:selected").text();/* 获取select的text */
		  var index = $(this).get(0).selectedIndex;/* 获取select选择的索引 */
		  if(val==1)
		  {
			  // 循环
			  $("#time1").attr("disabled",true);
			  $("#pp2").show();
			  var value = $("#bbb").val();
			  if(value==0 || value==2)
			  {
				  $("#bbb1").show();
				  /* 设置时间类型 时分秒 */
				  $('#time2').timepicker({
					   timeFormat: "HH:mm:ss"
				   });
			  }else
			  {
				  $("#bbb1").hide();
		      }
		  }else
		  {
			  //单次
			  $("#time1").attr("disabled",false);
			  $("#pp2").hide();
		  }
	   });
	   $("input:radio[name='sche.ins_build_type']").change(function (){
		   /* alert('aa'); */
		   var resu = $(this).val();
		   if(resu ==1)
			{
			   //手工检查
			   $("#pp1,#pp2").hide();
			}else
			{
				$("#pp1,#pp2").show();
				//定时执行
				var selVal=$("#aaa").val();
				if(selVal==1)
				  {
					  // 循环
					  $("#time1").attr("disabled",true);
					  $("#pp2").show();
				  }else
				  {
					  //单次
					  $("#time1").attr("disabled",false);
					  $("#pp2").hide();
				  }
			}
		  
	   });
	   /* 名称 */
	   $("#ins_ci_scheme").focus(function(){
		   $("#infoscheme").text("");
	   }).blur(function(){
		   if($("#ins_ci_scheme").val()=='')
		   {
			   $("#infoscheme").text("*必填项").css("color","red");
		   }
	   });
	   /* 定时执行单次构建时间 */
	   $("#time1").focus(function(){
		   $("#infoTime1").text("");
	   }).blur(function(){
		   if($("#time1").val()=='')
		   {
			   $("#infoTime1").text("*必填项").css("color","red");
		   }
	   });
	   /* 定时执行循环构建时间 */
	   $("#time2").focus(function(){
		   $("#infoTime2").text("");
	   }).blur(function(){
		   if($("#time2").val()=='')
		   {
			   $("#infoTime2").text("*必填项").css("color","red");
		   }
	   });
	   /* 提交 */
	   $("#submitBut").bind("click", function()
	    {  
		    
		    if($("#ins_ci_scheme").val()=='')
		    {
		    	$("#infoscheme").text("*必填项").css("color","red");
		    	return;
		    }
		    if($("#s1").val()==-1)
		    {
		    	$("#branchInfo").text("*必填项").css("color","red");
		    	return;
		    }
		    /* 定时执行 */
		    if($("#ins_build_type2").prop('checked'))
		    {
		    	/* 单次 */
		    	if($("#aaa").val()==0)
		    	{
		    		
		    		/* 单次的构建时间不能为空 */
		    		if($("#time1").val()=='')
			    	{
			    		$("#infoTime1").text("*必填项").css("color","red");
			    		return;
			    	}
		    	}else{
		    	
	               if ($("#time2").val() == '')
	               {
						$("#infoTime2").text("*必填项").css("color", "red");
						return;
					}
				}
			}
			$("#submitForm").submit();
		});
	});
</script>
<script type="text/javascript">
function change()
{
	$("#branchInfo").text("");
	var id = $("#s1").val();
	var url= $("#path").val()+"/inspection/inspection_getBranch2.action";
	var params ={
			'id':id
	};
	$.post(url,params,callback);
};
function callback(result,textStatus)
{  
    if(textStatus == 'success'){  
        if(result != null){  
        	/* alert(result);
            var select2 = $("#s2");  
            select2.empty();  
            var tmp = result.split(":");
            select2.append("<option value = '"+tmp[0]+"'>"+tmp[1]+"</option>"); */
        	document.getElementById("s2").innerHTML=result;
        }  
    }  
}   
</script>
</head>
<body>
	<input type="hidden" id="path" value="<%=request.getContextPath() %>" />
	<div class="top">PTS专家技术服务</div>
	<div class="page-wrapper">
		<div class="left">
			<div class="menu">
				<ul>
					<li><a
						href="<%=request.getContextPath() %>/inspection/inspection_findAll.action">服务设置</a></li>
					<li><a
						href="<%=request.getContextPath() %>/permiss/permiss_access.action">权限设置</a></li>
					<li><a
						href="<%=request.getContextPath() %>/inspection/inspection_loadAttr.action">新增方案</a></li>
					<li><a
						href="<%=request.getContextPath() %>/execute/execute_getObj.action">结果呈现</a></li>
				</ul>
			</div>
		</div>
		<form id="submitForm"
			action="<%=request.getContextPath() %>/inspection/inspection_saveInspe.action"
			method="post">
			<div class="main">
				<div class="main-content">
					<h1>新增方案</h1>
					<!-- <div class="min-title">标题维度</div> -->
					<div class="mc-block">
						<p>
							名 称：<input id="ins_ci_scheme" name="sche.ins_ci_scheme"
								type="text" /><span id="infoscheme"></span>
						</p>
						<p>
							代码库：
							<!-- GIT仓库 -->
							<select name="sche.ins_gitlab_name" id="s1" onchange="change()">
								<option value="-1" selected="selected">----请选择----</option>
								<s:iterator value="storage" id="st">
									<option value="<s:property value="key"/>">
										<s:property value="value" />
									</option>
								</s:iterator>
							</select>
							<!-- 分支 -->
							<select name="sche.ins_gitlab_branch" id="s2">
								<option value="-1" selected="selected">----请选择----</option>
								<%-- <s:iterator value="branch" id="br">
       	  	     <option value="<s:property value="key"/>">
       	  	     <s:property value="value"/>
       	  	     </option>
       	  	  </s:iterator> --%>
							</select><span id="branchInfo"></span>
						</p>
						<p>
							<!-- 维度 -->
							<s:iterator value="diment" id="dim">
								<input name="diments" type="checkbox"
									value="<s:property value="key"/>" />
								<s:property value="value" />
							</s:iterator>
						</p>
					</div>
					<!-- <div class="min-title">标题维度</div> -->
					<div class="mc-block">
						<p>
							<input id="ins_build_type1" name="sche.ins_build_type"
								type="radio" value="1" />手工检查
						</p>
						<p>
							<input id="ins_build_type2" name="sche.ins_build_type"
								type="radio" value="2" />定时执行
						</p>
						<p id="pp1">
							<!-- <input name="" type="button" value="设置" /> -->
							<select name="sche.ins_time_build_type" id="aaa">
								<option value="0">单次</option>
								<option value="1">循环</option>
							</select> 时间<input id="time1" name="beginTime1" type="text"
								readonly="readonly" /><span id="infoTime1"></span>
						</p>
						<p id="pp2">
							<!--  <input name="check1" type="radio" value="" />定时执行<input name="" type="button" value="设置" />
            <select name="">
        	  <option value="循环">循环</option>
        	  <option value="单次">单次</option>
       	  	</select> -->
							周期 <select id="bbb" name="sche.ins_cyc_type">
								<option value="0">每月</option>
								<option value="1">每天</option>
								<option value="2">每周</option>
							</select>
							<!-- <select name="">
        	  <option value="1号">1号</option>
        	  <option value="2号">2号</option>
        	  <option value="3号">3号</option>
       	  	</select> -->
							<input id="bbb1" name="sche.ins_month_days" type="text" /> 时间<input
								id="time2" name="beginTime2" type="text" readonly="readonly" /><span
								id="infoTime2"></span>
						</p>
						<div class="button">
							<input id="submitBut" type="button" value="确定" />
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>