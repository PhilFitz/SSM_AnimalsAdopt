<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//System.out.println(basePath);//这里获得的就是 协议名://服务器名:请求端口号/项目名/
%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=basePath %>/css/updateInf.css">
</head>
<body>
	<form action="<%=basePath %>update.do" method="post" class="form-update">

		<h3>修改个人资料</h3>
		<table>
			<tr>
				<td><label for="name">姓名：</label></td>
				<td><input type="text" name="name" id="name"
					value="${sessionScope.user.name }"></td>
			</tr>
			<tr>
				<td><label for="phone">电话：</label>${msg }</td>
				<td><input type="text" name="phone" id="phone"
					value="${user.phone }"></td>
			</tr>
			<tr>
				<td><label for="email">邮件：</label></td>
				<td><input type="text" name="email" id="email"
					value="${user.email }"></td>
			</tr>
			<tr>
				<td><label for="passwd">密码：</label></td>
				<td><input type="text" name="pwd" id="passwd" value="${user.pwd }"></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button type="submit" class="sub">提交</button> <a href="<%=basePath %>exit.do">退出登录</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

