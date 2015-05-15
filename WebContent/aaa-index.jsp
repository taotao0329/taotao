<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>
	<form action="user/user_save.action" method="post">
		<table border="1" width="60%">
			<tr>
				<td width="10%" align="center" id="hi">用户名:</td>
				<td width="10%" align="left"><input name="user.userName"
					value="SPG" type="text" /></td>
			</tr>
			<tr>
				<td width="10%" align="center">密 &nbsp;码:</td>
				<td width="10%" align="left"><input name="user.passWord"
					value="IMS" type="text" /></td>
			</tr>
			<tr>
				<td width="10%" align="center" colspan="2"><input type="submit"
					value="保存" /></td>
			</tr>
		</table>
	</form>

	<a href="pages/tmp.jsp">servlet</a>
	<a href="pages/autoCode.jsp">验证码</a>
</body>
</html>