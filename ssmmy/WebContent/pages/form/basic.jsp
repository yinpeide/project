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
	<script>
		function submitForm(){
			$('#ff').form('submit',{
				url:'${pageContext.request.contextPath}/form/basic.action',
				queryParams:{
					params :JSON.stringify({
						par1:1,
						par2:2
					})
				},
				ajax:true,
				onBeforeLoad:function(){
					console.log('beforeLoad');
				},
				onSubmit:function(param){
					console.log('onSubmit',param);
					if($(this).form('enableValidation').form('validate')){
						return true;//可以阻止表单提交	
					}else{
						console.log('不能提交');
						return false;
					}
				},
				success:function(data){
					console.log('success',data);//成功了以后调用的方法
				}
			})
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>	
</head>
<body>
	<h2>Basic Form</h2>
	<p>Fill the form and submit it.</p>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="New Topic" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" method="post" >
	    	<table cellpadding="5">
	    		<tr>
	    			<td>Name:</td>
	    			<td><input class="easyui-textbox" type="text" name="userName" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>Email:</td>
	    			<td><input class="easyui-textbox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>Subject:</td>
	    			<td><input class="easyui-textbox" type="text" name="subject" data-options="required:true,novalidate:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>Message:</td>
	    			<td><input id="message" class="easyui-textbox" name="message" data-options="multiline:true"  style="height:60px"></input></td>
	    		</tr>
				
	    		<tr>
	    			<td>Language:</td>
	    			<td>
	    				<select class="easyui-combobox" name="language"><option value="ar">Arabic</option><option value="bg">Bulgarian</option><option value="ca">Catalan</option><option value="zh-cht">Chinese Traditional</option><option value="cs">Czech</option><option value="da">Danish</option><option value="nl">Dutch</option><option value="en" selected="selected">English</option><option value="et">Estonian</option><option value="fi">Finnish</option><option value="fr">French</option><option value="de">German</option><option value="el">Greek</option><option value="ht">Haitian Creole</option><option value="he">Hebrew</option><option value="hi">Hindi</option><option value="mww">Hmong Daw</option><option value="hu">Hungarian</option><option value="id">Indonesian</option><option value="it">Italian</option><option value="ja">Japanese</option><option value="ko">Korean</option><option value="lv">Latvian</option><option value="lt">Lithuanian</option><option value="no">Norwegian</option><option value="fa">Persian</option><option value="pl">Polish</option><option value="pt">Portuguese</option><option value="ro">Romanian</option><option value="ru">Russian</option><option value="sk">Slovak</option><option value="sl">Slovenian</option><option value="es">Spanish</option><option value="sv">Swedish</option><option value="th">Thai</option><option value="tr">Turkish</option><option value="uk">Ukrainian</option><option value="vi">Vietnamese</option></select>
	    			</td>
	    		</tr>		
				

	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
	    </div>
	    </div>
	</div>
	success data的传值
</body>
</html>