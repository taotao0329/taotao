<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>autoCode</title>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">  
         $(function(){
        	 $('#authCode').click(function(){
        		 $('#authCode').attr('src','autoCode/autoCode_autoCode.action?d='+new Date().valueOf());
        	 });
         });
         function exe()
         {
        	 $('#authCode').attr('src','autoCode/autoCode_autoCode.action?d='+new Date().valueOf());
         }
</script>
</head>
<body>
	<table border="1" width="60%">
		<tr>
			<td width="10%" align="center" colspan="2"><input type="text"
				id="code" name="code" /> <img id="authCode"
				src="autoCode/autoCode_autoCode.action" alt="验证码"> <a
				href="javascript:exe();void(0);">换一张</a></td>
		</tr>
	</table>
</body>
</html>