<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
<title>欢迎</title>
<script type="text/javascript">
function goTo()
{
	/* 异常之后跳转的action */
	var url = $("#path").val()+"/portal/main/setUp_init.action";
	window.location.href=url;
}
</script>
</head>
<body>
	<input type="hidden" id="path" value="<%=request.getContextPath() %>" />
	<s:property value="exception" />
	<%-- <s:property value="exceptionStack"/> <%=request.getContextPath() %>/disp/disp_init.action--%>
	<a href="#" onclick="javascript:goTo();">返回登陆页面,初始化数据</a>
</body>
</html>