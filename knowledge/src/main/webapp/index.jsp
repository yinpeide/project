<%@page pageEncoding="GB18030" %>
<html>
	<head>
		<title>main</title>
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
		</body>
</html>
<script>

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

</script>