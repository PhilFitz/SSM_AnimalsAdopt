<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//System.out.println(basePath);//这里获得的就是 协议名://服务器名:请求端口号/项目名/
%> 
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/add.css">

<body>
	<div class="addStar">
		<!-- name,age,sex，address,phone,type,breed,isAdopt,momId,photo -->
		<form action="<%=basePath %>/addStar.do" method="post" class="ajax-form">
			<label for="name">名字</label> 
				<input type="text" name="name" id="name">
				<br>
			<label for="age">年龄</label> 
			<select name="age" id="age">
				<c:forEach var="index" begin="1" end="30">
					<option value="${index }">${index }</option>
				</c:forEach>
			</select> <br> <label for="photo">照片</label> 
			<input type="hidden" name="photo" id="photo" value=""> 
			<img alt="" src="" id="showimg">
			<button id="choose" class="ajax-link">选择头像</button><br> 
			<label for="sex">性别</label> 
				<input type="radio" name="sex" value="0" class="radio">公举 
				<input type="radio" name="sex" value="1" class="radio">王子 <br> 
			<label for="address">地址</label>
				<input type="text" name="address" id="address">  
				<br>
			<label for="phone">电话</label> 
				<input type="text" name="phone" id="phone">	
				<br>
			<label for="type">类型</label> 
				<input type="radio"	name="type" value="1" class="radio" id="type">汪
				<input type="radio" name="type" value="2" class="radio" id="type">喵
				<input type="radio"	name="type" value="3" class="radio" id="type">其他  
				<br>
			<label for="breed">品种</label> 
				<input type="text" name="breed" id="breed">
			<br>
			<button type="submit" id="submit">提交</button>

		</form>
		<form action="<%=basePath %>/upload.do" method="post" id="img-form"	enctype="mulipart/form-data" style="display: none">
			<input type="file" name="img" id="img">
		</form>
	</div>
</body>
 
<script type="text/javascript">
	jQuery(function($){
		 
		$("#choose").on("click",function(evt){
			evt.preventDefault();
			$("#img").trigger("click");
		});
		 
		$("#img").on("change",function(){
			var form = $("#img-form");
			var formdata = new FormData(form.get(0));
			$.ajax({
				type:"post",
				data : formdata,
				url : form.attr('action'),
				processData : false,
				contentType : false,
				cache : false,
				success : function(rt) {
					$('#showimg').attr('src', '<%=basePath %>/download.do?file=' + rt);
							$('#showimg').css({
								width : "100px",
								height : "100px",
								border : "1px solid #ccc",
								padding : "5px",
								margin : "5px"
							});
							$('#photo').val(rt);
						}
					});
				});
		
	});
</script>
<!-- -->
