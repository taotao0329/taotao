<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
  HttpSession sess = request.getSession();
  String proName = (String)sess.getAttribute("proName");
  String sign = (String)sess.getAttribute("sign");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<style type="text/css">
.mask {
	position: absolute;
	z-index: 998;
	top: 0px;
	left: 0px;
	background: rgb(50, 50, 50);
	background: rgba(0, 0, 0, 0.5);
	display: none;
}

#mess {
	position: absolute;
	width: 400px;
	z-index: 900;
	padding: 10px;
	background: #fff;
	border-radius: 5px;
	display: none;
}
</style>
<script type="text/javascript">
    function build(id)
    {
    	 var url = $("#path").val()+"/execute/execute_promptlyBuild.action?id="+id;
    	 showUnitInfo();
   	    $.post(url, function(data){
   			 var res=eval("("+data+")");
   			if(res.message=="ok"){
   				alert("操作成功！");
   				window.location.href=$("#path").val()+"/execute/execute_getObj.action";
   				hiddenUnitInfo(); 
   			}
   			else{
   				alert("操作失败！");
   				hiddenUnitInfo(); 
   			}
   	 	});
    	
    }
    function build_History(code)
    {
    	location.href=$("#path").val()+"/execute/execute_getBuildHistory.action?code="+code;
    }
    
    function showUnitInfo()
    {
  	  $("#yinying").css("height",$(document).height());     
        $("#yinying").css("width",$(document).width());
        $("#yinying").show();    
        $("#mess").show(); 
    }
    function hiddenUnitInfo()
    {
  	  /* $("#yinying").css("display", "none"); */
  	  $("#yinying").hide();
  	  $("#mess").hide();
    }
    
</script>
</head>
<body>
	<input type="hidden" id="path" value="<%=request.getContextPath() %>" />
	<div style="display: none" id="yinying" class="mask"></div>
	<div class="top">PTS专家技术服务</div>
	<div class="page-wrapper">
		<div class="left">
			<div class="menu">
				<ul>
					<li><a href="<%= path%>/inspection/inspection_findAll.action">服务设置</a></li>
					<li><a href="<%= path%>/permiss/permiss_access.action">权限设置</a></li>
					<li><a <% if(!sign.equals("1")) {%>
						href="<%= path%>/inspection/inspection_loadAttr.action" <%} %>>新增方案</a>


					</li>
					<li><a href="<%= path%>/execute/execute_getObj.action">结果呈现</a></li>
				</ul>
			</div>
		</div>
		<div class="main">
			<div class="main-content">
				<h1>
					项目名称:<%=proName %></h1>
				<div class="pro-table">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>序号</td>
							<td>CI方案</td>
							<td>GIT仓库名称</td>
							<td>分支</td>
							<td>最终构建情况</td>
							<!-- <td>成功率</td> -->
							<td>构建历史</td>
							<td>最新持续时间</td>
							<td>操作</td>
						</tr>
						<s:iterator value="list3" id="t3" status="st">
							<tr>
								<td><s:property value="#st.index+1" /></td>
								<td><s:property value="#t3.scheme" /></td>
								<td><s:if test='#t3.gitName=="1"'>GIT仓库1</s:if> <s:elseif
										test='#t3.gitName=="2"'>GIT仓库2</s:elseif> <%-- <s:property value="#t3.gitName"/> --%>
								</td>
								<td><s:if test='#t3.gitBranch=="1"'>Master1</s:if> <s:elseif
										test='#t3.gitBranch=="2"'>Master2</s:elseif> <s:elseif
										test='#t3.gitBranch=="3"'>Master3</s:elseif> <s:elseif
										test='#t3.gitBranch=="4"'>Master4</s:elseif> <s:elseif
										test='#t3.gitBranch=="5"'>Test1</s:elseif> <s:elseif
										test='#t3.gitBranch=="6"'>Test2</s:elseif> <s:elseif
										test='#t3.gitBranch=="7"'>Test3</s:elseif> <s:elseif
										test='#t3.gitBranch=="8"'>Test4</s:elseif> <s:elseif
										test='#t3.gitBranch=="master"'>master</s:elseif> <%-- <s:property value="#t3.gitBranch"/> --%>
								</td>
								<td><s:if test='#t3.state=="0"'>失败</s:if> <s:elseif
										test='#t3.state=="1"'>
                                                                成功                         
                </s:elseif> <s:else>
                  ...
                </s:else></td>
								<%-- <td><s:property value="#t3.odds"/></td> --%>
								<td><a
									href="javascript:build_History('<s:property value="#t3.id"/>'); void(0);">构建历史</a></td>
								<td><s:property value="#t3.operTime" /></td>
								<td><a
									href="javascript:build('<s:property value="#t3.id"/>','<s:property value="#t3.code"/>'); void(0);">立即构建</a>
								</td>
							</tr>
						</s:iterator>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div style="display: none" id="mess">正在处理，请稍后....</div>
</body>
</html>