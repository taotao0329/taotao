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
	href="<%=request.getContextPath()%>/css/backpage.css" />
<script src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
function downLoad()
{
	/* var url = $("#path").val()+"/execute/execute_getObj.action";
	alert(url); */
	window.location.href="#";
}
function compileDesc(exeId,inspId)
{
	//window.loction.href
	window.location.href=$("#path").val()+"/execute/execute_getCompDesc.action?id="+exeId+"&code="+inspId;
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
					<li><a <% if(!sign.equals("1")) {%>
						href="<%=request.getContextPath() %>/inspection/inspection_loadAttr.action"
						<%} %>>新增方案</a></li>
					<li><a
						href="<%=request.getContextPath() %>/execute/execute_getObj.action">结果呈现</a></li>
				</ul>
			</div>
		</div>
		<div class="main">
			<div class="main-content">
				<%-- <div class="newsolution">
        	请输入构建次数：<input name="" type="text" /><input name="" type="button" value="搜索" />
            <select name="">
        	  <option value="构建历史">构建历史</option>
        	  <option value="√  #5   2015-4-2  8：00：00">√  #5   2015-4-2  8：00：00</option>
       	  	</select>
        </div> --%>
				<div class="newsolution">
					<a href="#" onclick="javascript:downLoad();">下载报告</a>
				</div>
				<!-- <div class="min-title">CI方案-1第5次构建</div> -->
				<div class="pro-table">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>序号</td>
							<td>CI方案名称</td>
							<td>状态</td>
							<td>成功率</td>
							<td>操作时间</td>
							<td>操作</td>
						</tr>
						<s:iterator value="historyRecord" id="his" status="stat">
							<tr>
								<td><s:property value="#stat.index+1" /></td>
								<s:if test='#stat.index=="0"'>
									<td rowspan="<s:property value="historyRecord.size()"/>"><s:property
											value="#his.scheName" /></td>
								</s:if>
								<td><s:if test='#his.state=="0"'>
                                                                       失败
                   </s:if> <s:elseif test='#his.state=="1"'>
                                                                       成功
                   </s:elseif> <s:else>
                        ...
                   </s:else></td>
								<s:if test='#stat.index=="0"'>
									<!-- 跨行操作 -->
									<td rowspan="<s:property value="historyRecord.size()"/>"><s:property
											value="#his.odds" /></td>
								</s:if>
								<td><s:property value="#his.createTime" /></td>
								<td><a href="#"
									onclick="javascript:compileDesc('<s:property value="#his.exeId"/>','<s:property value="#his.inspId"/>');">编译详情</a></td>
							</tr>
						</s:iterator>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>