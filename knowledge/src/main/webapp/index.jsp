<%@page pageEncoding="GB18030" %>
<html>
	<head>
		<title>main</title>
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
		</body>
</html>
<script>

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

</script>