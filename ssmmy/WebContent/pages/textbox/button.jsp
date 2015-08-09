<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Load Form Data - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="../../css/easyui.css">
	<link rel="stylesheet" type="text/css" href="../../css/icon.css">
	<link rel="stylesheet" type="text/css" href="../../css/demo.css">
	<script type="text/javascript" src="../../js/jquery.min.js"></script>
	<script type="text/javascript" src="../../js/jquery.easyui.min.js"></script>
</head>
<body>
	<h2>TextBox with Button</h2>
	<p>The button can be attached to a textbox.</p>
	<div style="margin:20px 0 40px 0;"></div>
	<div style="margin-bottom:40px">
		<input class="easyui-textbox" data-options="buttonText:'SEARCH',prompt:'Search...'" style="width:250px;height:32px;">
	</div>
	<div style="margin-bottom:40px">
		<input class="easyui-textbox" data-options="buttonText:'Search',buttonIcon:'icon-search',prompt:'Search...'" style="width:450px;height:24px;">
	</div>
</body>
</html>