<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function loginSubmit(){
		document.forms[0].action= "${pageContext.request.contextPath}/login.action";
		document.forms[0].submit();
	}
</script>
</head>
<body>
	<span >${error }</span>
	<form method="post" >
		账号
		<input type="text" name="userName" ><br>
		密码
		<input type="text" name="password"><br>
		<input type="submit" name="zhuce" value="登录" onclick="loginSubmit();">
	</form>
</body>
</html>