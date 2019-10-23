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
	href="<%=basePath%>css/list.css">
</head>
<body>
	<div>
		<br>
		<c:if test="${adopted eq '1' }">
			<p>
				<i class=" icon-ok"></i>这些星人已经找到Family啦~~~
			</p>
			<br>
		</c:if>
		<c:if test="${adopted eq '0' }">
			<p>
				<i class="icon-magic"></i>这些星人因为种种原因正在寻找新的Family，如果你的条件允许，欢迎你带走它~
			</p>
			<br>
		</c:if>
		<c:forEach items="${List }" var="s">
			<dl>
				<dt>
					<img title="${s.name }" src="<%=basePath%>download.do?file=${s.photo }"
						class="starpic">
				</dt>
				<dd>
					<a href="<%=basePath%>showStar.do?id=${s.id }" class="ajax-link">Name:${s.name }</a>
				</dd>
			</dl>
		</c:forEach>

	</div>
</body>
</html>
