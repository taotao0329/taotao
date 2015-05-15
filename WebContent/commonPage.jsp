<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
<title>欢迎</title>
<script type="text/javascript">
$(function(){
	alert($("#message").val());
	window.location.href=$("#path").val()+$("#url").val();
});
</script>
</head>
<body>
	<input type="hidden" id="path" value="<%=request.getContextPath() %>" />
	<input type="hidden" id="message" value="<s:property value="isOk"/>" />
	<input type="hidden" id="url" value="<s:property value="url"/>" />
</body>
</html>