<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/person/insert.action" method="post">
	<table>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>年龄</td>
			<td><input type="text" name="age"></td>
		</tr>
		<tr>
			<td>入职日期</td>
			<td><input type="text" name="joinDate"/></td>
		</tr> 
		<tr>
			<td><input type="submit" name="Insert" value="新增"/></td>
		</tr>
	</table>
	</form>
</body>
</html>