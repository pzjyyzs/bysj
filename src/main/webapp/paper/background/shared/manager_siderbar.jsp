<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="rightbox">
	<br />
	<div class="itembox">
		<div class="rightBoxesTop">
			<h3>管理目录</h3>
		</div>
		<div class="rightContent">
			<ul id="sidebarLinks">
				
					<li><a href="#" value="文章管理" /></a></li>
					
					<li><a href="#" value="评论管理" /></a></li>
				
			</ul>
		</div>
	</div>
</div>
