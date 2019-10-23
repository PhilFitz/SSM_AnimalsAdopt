<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//System.out.println(basePath);//这里获得的就是 协议名://服务器名:请求端口号/项目名/
%>
<style>
	.showStar{
		font-family:"方正稚艺简体";
		width:350px;
		height:400px;
		padding:20px;
		margin:20px;
		margin-left:80px;
		border:5px solid #ccc;
	}
	img{
		width:100px;
		height: 100px;
	}
	tr td{
		padding: 10px 10px 5px 5px;
	}
	.starImg{
		border: 1px solid #B2D0E7;
	}
</style>
<div class="showStar">
<h3>星人名片</h3>
<table>
	<tr>
		<td>名字：</td>
		<td>${showStar.name }</td>
	</tr>
	<tr>
		<td>年龄：</td>
		<td>${showStar.age }</td>
	</tr>
	<tr>
		<td>头像：</td>
		<td><img class="starImg" src="<%=basePath %>download.do?file=${showStar.photo }"></td>
	</tr>
	<tr>
		<td>性别：</td>
		<td>这是一枚${showStar.sex == 0 ? "小公举" :"王子"}</td>
	</tr>
	<tr>
		<td>呆在：</td>
		<td>${showStar.address }</td>
	</tr>
	<tr>
		<td>联系电话：</td>
		<td>${showStar.phone }</td>
	</tr>
	<tr>
		<td>品种：</td>
		<td>${showStar.breed }</td>
	</tr>
	<tr>
		<td>领养状况：</td>
		<td>
			<c:if test="${showStar.adopted == 1 }">
				已被${user.name }领养
			</c:if>
			<c:if test="${showStar.adopted == 0 }">
				<a href="<%=basePath %>adopt.do?id=${user.id == '' ? 0 : user.id}&starId=${showStar.id}"  class="ajax-link">点击领养</a>
			</c:if>
		</td>
	</tr>
</table>
</div>