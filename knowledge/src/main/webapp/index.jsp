<%@page pageEncoding="GB18030" %>
<html>
	<head>
		<title>main</title>
		<script type="text/javascript" src="dwr/engine.js"></script>
		<script type="text/javascript" src="dwr/interface/userService.js"></script>
	</head>
		<body>
			<a href = "${pageContext.request.contextPath}/servlet/access">�Զ����ip������</a><br>
			<hr>
			jfreechart
			<br>
			<div id="invScaleDiv" style="display:none;position:absolute;top:75px;left:150px;">
			<!-- ��HTMLҳ����ص��˴���ʱ��Ҳ����WEB�������������� -->
			<img src="" id="invScaleImg">
			</div>
   		    <tr>
              <td height="18" bgcolor="#FFFFFF"><div align="left" class="STYLE2 STYLE1" style="cursor:hand" onmouseover="doOver();" onmouseout="doOut();">��ʾһ����ͼ</div></td>
            </tr>
            <a href="jfreechart/webBrokenLine.jsp">��ʾһ����ҳ�˵�����ͼjsp</a>
            <br>
            <a href="${pageContext.request.contextPath}/servlet/brokeline">��ʾһ����ҳ�˵�����ͼservlet</a>
            <hr>
            ����dwr
            <br> 
			�˺ţ�<input type="text" id="account"/><br>
			���룺<input type="password" id="password"/><br>
			<button onclick="login()">��¼</button>
			<hr>
			session������<br>
			<a href="${pageContext.request.contextPath}/servlet/sessionListener">sessionListener</a>
			<hr>
			ԭ��ajax
			ע���û�<input type = "text" name = "username" onblur = "checkUsername(this.value);"/><span id = "usernamemsg" ></span>
			<!-- <input type = "text" name ="username" onblur = "checkUsername(this.value)" /><span id = "usernamemsg"></span> -->
		</body>
</html>
<script>

/* 		function checkUsername(username){
			//����XMLHttpRequest����
			xRequest = new XMLHttpRequest();
			//ע��ص�����
			xRequest.onreadystatechange = function(){
					if(xRequest.readyState == 4){
						if(xRequest.status == 200){
							var usernamemsg = document.getElementById("usernamemsg");
							usernamemsg.innerHTML = xRequest.responseText;
						}
					}
			}
			//��ͨ��
			xRequest.open("GET","/PrjAjaxStudy1/servlet/ajax2?username="+username,true);
			//��������
			xRequest.send(null);
		} */
		//ajax
		function checkUsername(username)
		{
		//1���½�Ajax�߳�
			xRequest = new XMLHttpRequest();
		//2����Ajaxע��һ���ص�����
			xRequest.onreadystatechange = callback;
		//3��XMLHttpRequest��ͨ�������ͨ�����Ժ�����������������ӵ�
			xRequest.open("GET","${pageContext.request.contextPath}/servlet/ajax1?username="+username,true);
		//4���������󣬲���Я������
			xRequest.send(null);
		//5������ص�����
			function callback(){
				if(xRequest.readyState == 4){
					if(xRequest.status == 200){
						var usernamemsg = document.getElementById("usernamemsg");
						usernamemsg.innerHTML = xRequest.responseText;
						}else{
							alert("��������");
					}
				}
			}
		}
	//��꾭����ʾ��ҵͶ����Ͷ�ʱ����ı�״ͼ
	function doOver(){
		//��ȡinvScaleDiv
		var invScaleDiv = document.getElementById("invScaleDiv");
	
		//��ȡͼƬ
		var invScaleImg = document.getElementById("invScaleImg");
	
		//����������������������һ��ͼƬ��
		invScaleImg.src = "${pageContext.request.contextPath}/servlet/viewInvScale";
		
		//�޸���ʽ��ʾ
		invScaleDiv.style.display = "block";
	}
	
	//����뿪������ҵͶ����Ͷ�ʱ����ı�״ͼ
	function doOut(){
		
		//��ȡinvScaleDiv
		var invScaleDiv = document.getElementById("invScaleDiv");
	
		//�޸���ʽ����
		invScaleDiv.style.display = "none";
	}
	
	//����dwr
	function login() {
		 var account = document.getElementById("account").value;
		 var password = document.getElementById("password").value;
		 userService.login(account, password, function(data) {
			alert(data);	
		 });
	}

</script>