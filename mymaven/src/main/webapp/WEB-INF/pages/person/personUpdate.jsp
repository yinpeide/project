<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<span>${name}</span>
    <form action="${pageContext.request.contextPath}/person/update.action" method="post" enctype="multipart/form-data">
    	<input type="hidden" name="id" value="${person.id }"><br>
		姓名<input type="text" name="userName" value="${person.userName }"><br>
		年龄<input type="text" name="userAge" value="${person.userAge }"><br>
		备注<input type="text" name="remark" value="${person.remark }"><br>
		入职日期<input type="text" name="joinDate" value="${person.joinDate }"><br>
		<fmt:formatDate value="${person.joinDate}" pattern="yyyy－MM－dd"/>
		文件<input type="file" name="uploadfile">
		<input type="submit" name="update" value="修改"/>
		
	</form>	
</body>
</html>