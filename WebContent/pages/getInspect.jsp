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
	href="<%=request.getContextPath() %>/css/backpage.css" />
<script src="<%=request.getContextPath() %>/js/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/jquery-ui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/jquery-ui-timepicker-addon.css" />
<script src="<%=request.getContextPath() %>/js/jquery-ui.min.js"></script>
<script
	src="<%=request.getContextPath() %>/js/jquery-ui-timepicker-addon.js"></script>
<script
	src="<%=request.getContextPath() %>/js/jquery-ui-sliderAccess.js"></script>
<script type="text/javascript">
   $(function(){
	   /* 设置时间控件格式 */
	   $('#time1').datetimepicker({
		   dateFormat: "yy-mm-dd",
		   timeFormat: "HH:mm:ss"
	   });
	  /*  $('#time2').datetimepicker({
		   dateFormat: "yy-mm-dd",
		   timeFormat: "HH:mm:ss"
	   }); */
	   /* 周期下拉框事件 */
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
	  /*提交from  */
	  $("#submitBut").bind("click",function(){
		  $("#submitForm").submit();
	  });
   });
</script>
<script type="text/javascript">
function change()
{
	/* $("#branchInfo").text(""); */
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
						href="<%=request.getContextPath() %>/pages/permissionSetup.jsp">权限设置</a></li>
					<li><a
						href="<%=request.getContextPath() %>/inspection/inspection_loadAttr.action">新增方案</a></li>
					<li><a
						href="<%=request.getContextPath() %>/execute/execute_getObj.action">结果呈现</a></li>
				</ul>
			</div>
		</div>
		<form id="submitForm"
			action="<%=request.getContextPath() %>/inspection/inspection_updateInspe.action"
			method="post">
			<div class="main">
				<div class="main-content">
					<h1>修改方案</h1>
					<!-- <div class="min-title">标题维度</div> -->
					<div class="mc-block">
						<p>
							名 称：<input name="sche.ins_ci_scheme" type="text"
								value="<s:property value="sche.ins_ci_scheme" />" />
						</p>
						<p>
							代码库：
							<!-- GIT仓库 -->
							<select name="sche.ins_gitlab_name" id="s1" onchange="change()"<%-- disabled="disabled" --%>>
								<s:iterator value="storage" id="st">
									<s:set name="status" value="key"></s:set>
									<option value="<s:property value="key"/>"
										<s:if test='sche.ins_gitlab_name==#status'>selected</s:if>><!-- 填充 -->
										<s:property value="value" />
									</option>
								</s:iterator>
							</select>
							<!--test  -->
							<%-- <select>
       	  	<s:iterator value="testMap" id="test" status="stat">
       	  	  <s:set value="#stat.index" name="offset"/>
       	  	     <option value="">
       	  	        <s:property value="value[#offset]"/>
       	  	     </option>
       	  	</s:iterator>
       	  	</select> --%>

							<!-- end -->
							<!-- 分支 -->
							<select name="sche.ins_gitlab_branch" id="s2"<%-- disabled="disabled" --%>>
								<s:iterator value="branch" id="br">
									<s:set name="status" value="key" />
									<option value="<s:property value="key"/>"
										<s:if test='sche.ins_gitlab_branch==#status'>selected</s:if>>
										<s:property value="value" />
									</option>
								</s:iterator>
							</select>
						</p>
						<p>
							<s:iterator value="diment" id="dim">
								<!-- 所有的checkbox -->
								<s:set value="key" name="comp" />
								<!-- 遍历数据库存储的checkbox -->
								<s:generator val="sche.ins_check_diment" separator=","
									id="iter1">
								</s:generator>
								<input name="diments"
									<s:iterator  value="iter1" id="name">
          	            <s:if test='#name==#comp'> checked</s:if> 
          	            </s:iterator>
									type="checkbox" value="<s:property value="key"/>" />
								<s:property value="value" />
								<!-- end -->
							</s:iterator>

						</p>
					</div>
					<!-- <div class="min-title">标题维度</div> -->
					<div class="mc-block">
						<!-- 传递js判断 -->
						<input name="sche.pk_id" type="hidden" id="code"
							value="<s:property value="sche.pk_id"/>"></input>
						<!-- 由于actin采用原型模式 需要传递标示 -->
						<input name="sche.ins_enterprise_tag" type="hidden" id="code"
							value="<s:property value="sche.ins_enterprise_tag"/>"></input> <input
							name="sche.ins_enterprise_name" type="hidden" id="code"
							value="<s:property value="sche.ins_enterprise_name"/>"></input> <input
							name="sche.ins_project_tag" type="hidden" id="code"
							value="<s:property value="sche.ins_project_tag"/>"></input> <input
							name="sche.ins_project_name" type="hidden" id="code"
							value="<s:property value="sche.ins_project_name"/>"></input> <input
							name="sche.fk_ins_sub_id" type="hidden" id="code"
							value="<s:property value="sche.fk_ins_sub_id"/>"></input> <input
							name="sche.fk_ins_ser_ip" type="hidden" id="code"
							value="<s:property value="sche.fk_ins_ser_ip"/>"></input> <input
							name="sche.ins_gitlab_url" type="hidden" id="code"
							value="<s:property value="sche.ins_gitlab_url"/>"></input>
						<%-- <input name="sche.ins_build_type" type="hidden" id="hidd" value="<s:property value="sche.ins_build_type"/>"></input> --%>
						<input name="sche.ins_scheme_state" type="hidden" id="hidd"
							value="<s:property value="sche.ins_scheme_state"/>"></input>
						<%--  <input type="hidden" id="hidd" value="<s:property value="sche."/>"></input> --%>
						<p>
							<input name="sche.ins_build_type" type="radio" value="1"
								<s:if test='sche.ins_build_type=="1"'> checked</s:if> />手工检查
						</p>
						<p>
							<input name="sche.ins_build_type" type="radio" value="2"
								<s:if test='sche.ins_build_type=="2"'> checked</s:if> />定时执行
						</p>
						<p id="pp1">
							<!-- 传递js判断  -->
							<input type="hidden" id="sign"
								value="<s:property value="sche.ins_time_build_type"/>" /> <select
								name="sche.ins_time_build_type" id="aaa">
								<option value="0"
									<s:if test='sche.ins_time_build_type=="0"'>selected</s:if>>单次</option>
								<option value="1"
									<s:if test='sche.ins_time_build_type=="1"'>selected</s:if>>循环</option>
							</select> 时间<input id="time1" name="beginTime1" type="text"
								readonly="readonly" value="<s:property value="format" />" />
						</p>
						<p id="pp2">
							周期 <select id="bbb" name="sche.ins_cyc_type">
								<option value="0"
									<s:if test='sche.ins_cyc_type=="0"'>selected</s:if>>每月</option>
								<option value="1"
									<s:if test='sche.ins_cyc_type=="1"'>selected</s:if>>每天</option>
								<option value="2"
									<s:if test='sche.ins_cyc_type=="2"'>selected</s:if>>每周</option>
							</select> <input id="bbb1" name="sche.ins_month_days" type="text"
								value="<s:property value="sche.ins_month_days"/>" /> 时间<input
								id="time2" name="beginTime2" type="text"
								value="<s:property value="sche.ins_exetime"/>"
								readonly="readonly" />
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