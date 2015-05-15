<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
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
	href="<%=request.getContextPath()%>/css/backpage.css" />
<script src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
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

  function del_sure()
  {
	  var resu = confirm("确认删除?");
	  if(resu)
	  {
		  return true;
	  }else
	  {
		  return false;
	  }
  }
  //变更服务方案状态
  function chooseStatus(id,status){
	  var url = $("#path").val()+"/inspection/inspection_startService.action?id="+id+"&typeStatus="+status;
	  showUnitInfo();
	    $.post(url, function(data){
			var res=eval("("+data+")");
			if(res.message=="ok"){
				alert("操作成功");
				window.location.href=$("#path").val()+"/inspection/inspection_findAll.action";
				hiddenUnitInfo(); 
			}
			else{
				alert("操作失败！");
				hiddenUnitInfo();
			}
	 	});
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
					<!--Todo 加action  user/user_save.action-->
					<li><a
						href="<%=request.getContextPath() %>/inspection/inspection_findAll.action">服务设置</a></li>
					<li><a
						href="<%=request.getContextPath() %>/permiss/permiss_access.action">权限设置</a></li>
					<li><a
						<s:if test='sign!="1"'> href="<%=request.getContextPath() %>/inspection/inspection_loadAttr.action" </s:if>>新增方案</a></li>
					<li><a
						href="<%=request.getContextPath() %>/execute/execute_getObj.action">结果呈现</a></li>
				</ul>
			</div>
		</div>
		<div class="main">
			<div class="main-content">

				<h1>
					项目名称:
					<%-- <s:property value="projectName" /> --%><%=proName %></h1>
				<div class="newsolution">

					<a
						<s:if test='sign!="1"'>href="<%=request.getContextPath() %>/inspection/inspection_loadAttr.action" </s:if>>新增方案</a>

					<s:else>
                                    方案已经最大数
           </s:else>
				</div>
				<div class="pro-table">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>序号</td>
							<td>CI方案</td>
							<td>GIT仓库名称</td>
							<td>分支</td>
							<td>所属维度</td>
							<td>操作</td>
						</tr>
						<s:iterator value="list" id="t" status="L">
							<s:if test='#t.ins_ignore==0'>
								<tr>
									<td><s:property value="#L.index+1" /></td>
									<td><s:property value="#t.ins_ci_scheme" /></td>
									<td><s:if test='#t.ins_gitlab_name=="1"'>GIT仓库1</s:if> <s:elseif
											test='#t.ins_gitlab_name=="2"'>GIT仓库2</s:elseif> <%-- <s:property value="#t.ins_gitlab_name"/> --%>
									</td>
									<td><s:if test='#t.ins_gitlab_branch=="1"'>Master1</s:if>
										<s:elseif test='#t.ins_gitlab_branch=="2"'>Master2</s:elseif>
										<s:elseif test='#t.ins_gitlab_branch=="3"'>Master3</s:elseif>
										<s:elseif test='#t.ins_gitlab_branch=="4"'>Master4</s:elseif>
										<s:elseif test='#t.ins_gitlab_branch=="5"'>Test1</s:elseif> <s:elseif
											test='#t.ins_gitlab_branch=="6"'>Test2</s:elseif> <s:elseif
											test='#t.ins_gitlab_branch=="7"'>Test3</s:elseif> <s:elseif
											test='#t.ins_gitlab_branch=="8"'>Test4</s:elseif> <s:elseif
											test='#t.ins_gitlab_branch=="master"'>master</s:elseif> <%-- <s:property value="#t.ins_gitlab_branch"/> --%>
									</td>
									<td><s:generator val="#t.ins_check_diment" separator=","
											id="iter1">
										</s:generator> <s:iterator status="st" value="iter1" id="name">
											<s:if test='#name=="1"'>规范</s:if>
											<s:elseif test='#name=="2"'>可维护</s:elseif>
											<s:elseif test='#name=="3"'>可靠</s:elseif>
											<s:elseif test='#name=="4"'>编译</s:elseif>
										</s:iterator></td>
									<td>
										<!-- 逻辑删除后某些按钮不可用 --> <s:if test="#t.ins_scheme_state==0">
											<a
												<s:if test='#t.ins_ignore==0'> href="#" onclick="chooseStatus('<s:property value='#t.pk_id'/>','1');" </s:if>>
												启动</a>&nbsp;&nbsp;
            </s:if> <s:if test="#t.ins_scheme_state==1">
											<a
												<s:if test='#t.ins_ignore==0'> href="#" onclick="chooseStatus('<s:property value='#t.pk_id'/>','0');" </s:if>>停用</a>&nbsp;&nbsp;
            </s:if> <a
										<s:if test='#t.ins_ignore==0'> href="inspection/inspection_getInspect.action?branchName=<s:property value="#t.ins_gitlab_name"/>&id=<s:property value="#t.pk_id"/>" </s:if>>修改</a>
										<a
										<s:if test='#t.ins_ignore==0'> href="inspection/inspection_deleteInspec.action?id=<s:property value="#t.pk_id"/>" onclick="javascript:return del_sure();" </s:if>>删除</a>
										<a
										<s:if test='#t.ins_ignore==0'> href="<%=request.getContextPath() %>/permiss/permiss_access.action" </s:if>>权限设置</a>
									</td>
								</tr>
							</s:if>
						</s:iterator>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div style="display: none" id="mess">正在处理，请稍后....</div>
</body>
</html>
