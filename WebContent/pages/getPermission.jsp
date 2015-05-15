<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>PTS专家技术服务</title>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/colorpicker.css" />
<link rel="stylesheet" href="css/datepicker.css" />
<link rel="stylesheet" href="css/uniform.css" />
<link rel="stylesheet" href="css/select2.css" />
<link rel="stylesheet" href="css/maruti-style.css" />
<link rel="stylesheet" href="css/maruti-media.css" class="skin-color" />
<link rel="stylesheet" href="css/add.css" />
<script src="js/jquery.min.js"></script>
<script src="js/jquery.ui.custom.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-colorpicker.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/jquery.uniform.js"></script>
<script src="js/select2.min.js"></script>
<script src="js/maruti.js"></script>
<script src="js/maruti.form_common.js"></script>
<script type="text/javascript">

</script>
</head>

<body>
	<div id="header">
		<h1>
			<a href="dashboard.html"></a>
		</h1>
	</div>
	<div class="btn-group rightzero">
		<a class="top_message tip-left" title="Manage Files"><i
			class="icon-file"></i></a> <a class="top_message tip-bottom"
			title="Manage Users"><i class="icon-user"></i></a> <a
			class="top_message tip-bottom" title="Manage Comments"><i
			class="icon-comment"></i><span class="label label-important">5</span></a>
		<a class="top_message tip-bottom" title="Manage Orders"><i
			class="icon-shopping-cart"></i></a>
	</div>
	<div id="user-nav" class="navbar navbar-inverse">
		<ul class="nav">
			<li class=""><a title="" href="#"><i class="icon icon-user"></i>
					<span class="text">张三</span></a></li>
			<li class=" dropdown" id="menu-messages"><a href="#"
				data-toggle="dropdown" data-target="#menu-messages"
				class="dropdown-toggle"><i class="icon icon-envelope"></i> <span
					class="text">消息</span> <span class="label label-important">5</span>
					<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a class="sAdd" title="" href="#">通知</a></li>
					<li><a class="sInbox" title="" href="#">消息</a></li>
					<li><a class="sOutbox" title="" href="#">公告</a></li>
					<li><a class="sTrash" title="" href="#">提醒</a></li>
				</ul></li>
			<li class=""><a title="" href="#"><i class="icon icon-cog"></i>
					<span class="text">设置</span></a></li>
			<li class=""><a title="" href="login.html"><i
					class="icon icon-share-alt"></i> <span class="text">退出</span></a></li>
		</ul>
	</div>
	<div id="sidebar">
		<ul>
			<li class="active"><a href="index.html"><i
					class="icon icon-home"></i> <span>网站首页</span></a></li>
			<li><a href="charts.html"><i class="icon icon-signal"></i> <span>产品服务</span></a>
			</li>
			<li><a href="widgets.html"><i class="icon icon-inbox"></i> <span>技术支持</span></a>
			</li>
			<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>提交工单</span> <span class="label">1</span></a>
				<ul>
					<li><a href="">帮助中心</a></li>
				</ul></li>
			<li><a href="tables.html"><i class="icon icon-th"></i> <span>服务设置</span></a></li>
			<li><a href="grid.html"><i class="icon icon-fullscreen"></i>
					<span>服务执行</span></a></li>
		</ul>
	</div>
	<div id="content">
		<div id="content-header">
			<div id="breadcrumb">
				<a href="index.html" title="返回首页" class="tip-bottom"><i
					class="icon-home"></i> 首页</a> <a href="#" class="tip-bottom">服务设置</a> <a
					href="#" class="current">权限设置</a>
			</div>
			<!-- <h1>权限设置</h1> -->
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<%-- <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <!-- <h5>权限列表</h5> -->
            <span class="label label-info"><a href="">修改</a></span> </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th width="100">序号</th>
                  <th>姓名</th>
                  <th>查看权限</th>
                  <th>执行权限</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
                 <s:iterator value="list" id="per" status="stat">
                 <s:if test='#per.userType=="0"'>
                 <tr>
                     <td><s:property value="#stat.index+1"/></td>
                     <td><s:property value="#per.powName"/></td>
                     <td><s:if test='#per.isLook=="0"'>
                        <i class="icon-remove"></i>
                     </s:if>
                     <s:elseif test='#per.isLook=="1"'>
                     <i class="icon-ok"></i>
                     </s:elseif>
                     </td>
                     <td>
                     <s:if test='#per.isExe=="0"'>
                        <i class="icon-remove"></i>
                     </s:if>
                     <s:elseif test='#per.isExe=="1"'>
                     <i class="icon-ok"></i>
                     </s:elseif>
                     </td>
                     <td><span class="label label-info"><a href="permiss/permiss_updatePermiss.action?code=<s:property value="#per.pk_id"/>">修改</a></span></td>
                 </tr>
                 </s:if>
                 </s:iterator>
              </tbody>
            </table>
          </div>
        </div>
      </div> --%>
			</div>
			<div class="row-fluid">
				<%-- <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
           <!--  <h5>新增列表</h5> -->
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th width="100">序号</th>
                  <th>用户名</th>
                  <th>姓名</th>
                  <th>查看权限</th>
                  <th>执行权限</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
              <s:iterator value="list" id="per" status="stat">
               <s:if test='#per.userType=="1"'>
                 <tr>
                     <td><s:property value="#stat.index+1"/></td>
                     <td><s:property value="#per.powUser"/></td>
                     <td><s:property value="#per.powName"/></td>
                     <td><s:if test='#per.isLook=="0"'>
                        <i class="icon-remove"></i>
                     </s:if>
                     <s:elseif test='#per.isLook=="1"'>
                     <i class="icon-ok"></i>
                     </s:elseif>
                     </td>
                     <td>
                     <s:if test='#per.isExe=="0"'>
                        <i class="icon-remove"></i>
                     </s:if>
                     <s:elseif test='#per.isExe=="1"'>
                     <i class="icon-ok"></i>
                     </s:elseif>
                     </td>
                     <td><span class="label label-info"><a href="permiss/permiss_deletePer.action?code=<s:property value="#per.pk_id"/>" onclick="javascript:return del_sure();">删除</a></span></td>
                 </tr>
                 </s:if>
                 </s:iterator>
              </tbody>
            </table>
          </div>
        </div>
      </div> --%>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-info-sign"></i>
							</span>
							<h5>修改权限</h5>
						</div>
						<div class="widget-content nopadding">
							<form class="form-horizontal" method="post"
								action="permiss/permiss_updatePermiss.action"
								name="number_validate" id="number_validate" novalidate>
								<!--  <div class="control-group">
                <label class="control-label">姓名</label>
                <div class="controls">
                  <input type="text" name="pms.powUser" id="min" readonly="readonly"/>
                </div>
              </div> -->
								<input name="pms.pk_id" type="hidden"
									value="<s:property value="pms.pk_id"/>"></input>
								<!-- 获取主键列 -->
								<div class="control-group">
									<label class="control-label">姓名</label>
									<div class="controls">
										<input type="text" name="pms.powName"
											value="<s:property value="pms.powName"/>" id="max"
											readonly="readonly" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">赋予权限</label>
									<div class="controls">
										<s:iterator id="m" value="mapLook">
											<label><input
												<s:if test='pms.isLook=="1"'>checked</s:if> name="isLook"
												type="checkbox" value="<s:property value="key"/>">
											<s:property value="value" /></input> </label>
										</s:iterator>
										<s:iterator id="m" value="mapExe">
											<label><input
												<s:if test='pms.isExe=="1"'>checked</s:if> name="isExe"
												type="checkbox" value="<s:property value="key"/>">
											<s:property value="value" /></input> </label>
										</s:iterator>
									</div>
								</div>
								<div class="form-actions">
									<input type="submit" value="确认" class="btn btn-success">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<div class="row-fluid">
		<div id="footer" class="span12">2015 &copy; 中软国际</div>
	</div>
</body>
</html>
