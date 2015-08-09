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
	<h2>TextBox with Icons</h2>
	<p>Click the icons on textbox to perform actions.</p>
	<div style="margin:20px 0 40px 0;"></div>
    <div style="margin:10px 0 20px 0">
        <span>Select Icon Align: </span>
        <select onchange="$('#tt').textbox({iconAlign:this.value})">
            <option value="right">Right</option>
            <option value="left">Left</option>
        </select>
    </div>
	<input id="tt" class="easyui-textbox" style="width:400px" data-options="
			prompt: 'Input something here!',
			iconWidth: 22,
			icons: [{
				iconCls:'icon-add',
				handler: function(e){
					$(e.data.target).textbox('setValue', 'Something added!');
				}
			},{
				iconCls:'icon-remove',
				handler: function(e){
					$(e.data.target).textbox('clear');
				}
			},{
				iconCls:'icon-search',
				handler: function(e){
					var v = $(e.data.target).textbox('getValue');
					alert('The inputed value is ' + (v ? v : 'empty'));
				}
			}]
			">
</body>
</html>