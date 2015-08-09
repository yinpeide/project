<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<img alt="" src="${pageContext.request.contextPath}/images/tomcat.png">
	<sf:form action="${pageContext.request.contextPath}/person/update.action" 
	method="post" 
	modelAttribute="person"
	enctype="multipart/form-data">
	 <sf:hidden path="id"/>
	<table>
		<tr>
			<td>姓名</td>
			<td>
				<sf:input path="name"/></font>
				
			</td>
		</tr>
		<tr>
			<td>年龄</td>
			<td>
				<sf:input path="age"/>
			</td>
		</tr>
		<tr>
			<td>图片</td>
			<td><input type="file" name="uploadfile"/></td>
		</tr>
		<tr>
			<td><input type="submit" name="update" value="修改"/></td>
		</tr>
	</table>
	</sf:form>
</body>
</html>