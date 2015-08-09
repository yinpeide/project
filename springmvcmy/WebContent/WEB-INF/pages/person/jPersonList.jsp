<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function deletSubmit(){
		
		document.forms[0].action= "${pageContext.request.contextPath}/person/delete.action";
		document.forms[0].submit();
		
	}
</script>
</head>
<body>
	<form method="post">
	<div style="padding: 10px">
		<a href="${pageContext.request.contextPath}/person/tocreate.action" >新增</a>
		<a href="#" onclick="deletSubmit();">批量删除</a>
	</div>
	<table border = "1">
		<tr>
			<td>序号</td>
			<td>选择</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>入职时间</td>
			<td>操作</td>
		</tr>
		
		<c:forEach items="${personList}" var="person" varStatus="status" >
			<tr>
				<td>${status.index+1}</td>
				<td><input type="checkbox" name="id" value="${person.id }"/> </td>
				<td>${person.name}</td>
				<td>${person.age}</td>
				<td>${person.joinDate }</td>
				<td>
					<a href="${pageContext.request.contextPath}/person/toupdate.action?id=${person.id}">修改</a>
					<a href="${pageContext.request.contextPath}/person/deleteById.action?id=${person.id}">删除</a>
					
			    </td>
			</tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>