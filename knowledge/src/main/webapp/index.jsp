<%@page pageEncoding="GB18030" %>
<html>
	<head>
		<title>main</title>
		<script type="text/javascript" src="dwr/engine.js"></script>
		<script type="text/javascript" src="dwr/interface/userService.js"></script>
	</head>
		<body>
			<a href = "${pageContext.request.contextPath}/servlet/access">自定义的ip过滤器</a><br>
			<hr>
			jfreechart
			<br>
			<div id="invScaleDiv" style="display:none;position:absolute;top:75px;left:150px;">
			<!-- 当HTML页面加载到此处的时候也会向WEB服务器发送请求。 -->
			<img src="" id="invScaleImg">
			</div>
   		    <tr>
              <td height="18" bgcolor="#FFFFFF"><div align="left" class="STYLE2 STYLE1" style="cursor:hand" onmouseover="doOver();" onmouseout="doOut();">显示一个饼图</div></td>
            </tr>
            <a href="jfreechart/webBrokenLine.jsp">显示一个网页端的折线图jsp</a>
            <br>
            <a href="${pageContext.request.contextPath}/servlet/brokeline">显示一个网页端的折线图servlet</a>
            <hr>
            测试dwr
            <br> 
			账号：<input type="text" id="account"/><br>
			密码：<input type="password" id="password"/><br>
			<button onclick="login()">登录</button>
			<hr>
			session监听器<br>
			<a href="${pageContext.request.contextPath}/servlet/sessionListener">sessionListener</a>
			<hr>
			原生ajax
			注册用户<input type = "text" name = "username" onblur = "checkUsername(this.value);"/><span id = "usernamemsg" ></span>
			<!-- <input type = "text" name ="username" onblur = "checkUsername(this.value)" /><span id = "usernamemsg"></span> -->
		</body>
</html>
<script>

/* 		function checkUsername(username){
			//创建XMLHttpRequest对象
			xRequest = new XMLHttpRequest();
			//注册回调函数
			xRequest.onreadystatechange = function(){
					if(xRequest.readyState == 4){
						if(xRequest.status == 200){
							var usernamemsg = document.getElementById("usernamemsg");
							usernamemsg.innerHTML = xRequest.responseText;
						}
					}
			}
			//打开通道
			xRequest.open("GET","/PrjAjaxStudy1/servlet/ajax2?username="+username,true);
			//发送请求
			xRequest.send(null);
		} */
		//ajax
		function checkUsername(username)
		{
		//1、新建Ajax线程
			xRequest = new XMLHttpRequest();
		//2、给Ajax注册一个回调函数
			xRequest.onreadystatechange = callback;
		//3、XMLHttpRequest打开通道，这个通道是以后浏览器跟服务器连接的
			xRequest.open("GET","${pageContext.request.contextPath}/servlet/ajax1?username="+username,true);
		//4、发送请求，并且携带数据
			xRequest.send(null);
		//5、定义回调函数
			function callback(){
				if(xRequest.readyState == 4){
					if(xRequest.status == 200){
						var usernamemsg = document.getElementById("usernamemsg");
						usernamemsg.innerHTML = xRequest.responseText;
						}else{
							alert("其他错误");
					}
				}
			}
		}
	//鼠标经过显示企业投资人投资比例的饼状图
	function doOver(){
		//获取invScaleDiv
		var invScaleDiv = document.getElementById("invScaleDiv");
	
		//获取图片
		var invScaleImg = document.getElementById("invScaleImg");
	
		//向服务器发送请求请求的是一个图片。
		invScaleImg.src = "${pageContext.request.contextPath}/servlet/viewInvScale";
		
		//修改样式显示
		invScaleDiv.style.display = "block";
	}
	
	//鼠标离开隐藏企业投资人投资比例的饼状图
	function doOut(){
		
		//获取invScaleDiv
		var invScaleDiv = document.getElementById("invScaleDiv");
	
		//修改样式隐藏
		invScaleDiv.style.display = "none";
	}
	
	//测试dwr
	function login() {
		 var account = document.getElementById("account").value;
		 var password = document.getElementById("password").value;
		 userService.login(account, password, function(data) {
			alert(data);	
		 });
	}

</script>