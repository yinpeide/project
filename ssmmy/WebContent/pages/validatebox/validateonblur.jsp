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
</head>
<body>
	<h2>Validate On Blur</h2>
	<p>Active validation on first blur event.</p>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="Register" style="width:400px;padding:10px 60px 20px 60px">
		<table cellpadding="5">
			<tr>
				<td>User Name:</td>
				<td><input class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]',novalidate:true"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input class="easyui-validatebox textbox" data-options="required:true,validType:'email',novalidate:true"></td>
			</tr>
			<tr>
				<td>Birthday:</td>
				<td><input class="easyui-datebox textbox" data-options="required:true,novalidate:true"></td>
			</tr>
			<tr>
				<td>URL:</td>
				<td><input class="easyui-validatebox textbox" data-options="required:true,validType:'url',novalidate:true"></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input class="easyui-validatebox textbox" data-options="required:true,novalidate:true"></td>
			</tr>
		</table>
	</div>
	<script type="text/javascript">
		$(function(){
			$('.validatebox-text').bind('blur', function(){
				$(this).validatebox('enableValidation').validatebox('validate');
			});
		})

	</script>
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