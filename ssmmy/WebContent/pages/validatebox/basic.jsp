<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic Form - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="../../css/easyui.css">
	<link rel="stylesheet" type="text/css" href="../../css/icon.css">
	<link rel="stylesheet" type="text/css" href="../../css/demo.css">
	<script type="text/javascript" src="../../js/jquery.min.js"></script>
	<script type="text/javascript" src="../../js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		$(function(){
			
		});
		
		function destroy(){
			$('#phoneId').validatebox('destroy');//直接干掉改inpute框
		}
	</script>
</head>
<body>
	<h2>Basic ValidateBox</h2>
	<p>It's easy to add validate logic to a input box.</p>
	<div style="margin:20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="destroy()">destroyPhone</a>
	</div>
		<div class="easyui-panel" title="Register" style="width:400px;padding:10px 60px 20px 60px">
			<table cellpadding="5">
				<tr>
					<td>User Name:</td>
					<td><input class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]',missingMessage:'姓名不能为空',invalidMessage:'长度必须在3-10之间',tipPosition:'bottom'"></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input class="easyui-validatebox textbox" data-options="required:true,validType:'email',missingMessage:'邮件不能为空',invalidMessage:'格式必须为邮件格式',deltaX:33,deltaY:-50"></td>
				</tr>
				<tr>
					<td>Birthday:</td>
					<td><input class="easyui-datebox textbox"></td>
				</tr>
				<tr>
					<td>URL:</td>
					<td><input class="easyui-validatebox textbox" 
											data-options="required:true,
											validType:'url',
											missingMessage:'URL不能为空',
											novalidate:true
											"></td><!-- onValidate:alert('onValidate') -->
				</tr>
				<tr>
					<td>Phone:</td>
					<td><input id="phoneId" class="easyui-validatebox textbox" 
								data-options="required:true,
												missingMessage:'电话不能为空',
												delay:200
												"></td><!-- onBeforeValidate:alert('onBeforeValidate') -->
				</tr>
			</table>
		</div>
	<style scoped="scoped">
		.textbox{
			height:20px;
			margin:0;
			padding:0 2px;
			box-sizing:content-box;
		}
	</style>
</body>
</html>