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
	<h2>TextBox Size</h2>
	<p>The textbox can vary in size.</p>
	<div style="margin:20px 0 40px 0;"></div>
	<div style="margin-bottom:40px">
		<input class="easyui-textbox" data-options="iconCls:'icon-search',iconWidth:28,prompt:'Search small...'" style="width:250px;height:22px;">
	</div>
	<div style="margin-bottom:40px">
		<input class="easyui-textbox" data-options="iconCls:'icon-search',iconWidth:28,prompt:'Search large...'" style="width:250px;height:26px;">
	</div>
	<div style="margin-bottom:40px">
		<input class="easyui-textbox" data-options="iconCls:'icon-search',iconWidth:28,prompt:'Search big...'" style="width:250px;height:32px;">
	</div>
	<div style="margin-bottom:40px">
		<input class="easyui-textbox" data-options="iconCls:'icon-search',iconWidth:28,prompt:'Search huge...'" style="width:250px;height:40px;">
	</div>
</body>
</html>