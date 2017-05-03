<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<html>
  <head>
	
		<script type="text/javascript" src="js/remind.js" ></script>
		<link rel="stylesheet" href="css/header.css" />
		<script type="text/javascript" src="js/likeAndcomremind.js" ></script>
		<script type="text/javascript" src="js/likeAndcomremind2.js" ></script>
</head>


<body>
    	
<input id="remindid" type="hidden" value="${user.uid}">
		<!-- 	全局顶部导航-->
		<nav class="navbar">
			<div class="width-limit">
				<!-- 左上方Logo-->
				<a class="logo" href="paper/index.jsp">
					<img src="img/title.png" width="75px" height="50px"/>
				</a>
				<!-- 右上角-->
				<!-- 登录显示写文章-->
				<a class="btn write-btn" target="_blank" href="article/showWrite.do">
					<i class="glyphicon glyphicon-leaf">写文章</i>
				</a>
				<div class="user">
					<div class="avatar">
						<a href="user/showmyuser.do">
							<img src="${user.img}">
						</a>
					</div>
				</div>
				<div class="container">
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav">
							<li>
								<a href="friend/showmyfriend.do">
									<span>读友圈</span>
								</a>
							</li>
							<li class="">
								<a href="mail/showObjectUserList.do?">
									<span id="Allxiaoxi">消息</span>
								</a>
							</li>
							<li class="search">
								<form target="_blank" action="">
									<input  type="text" name="q" id="q" placeholder="搜索" class="search-input"/>
									<a class="search-btn" href="javascript:void(null)">
										<i class="glyphicon glyphicon-search"></i>
									</a>
								</form>
							</li>
						</ul>
					</div>
				</div>
		</nav>
 	</body>
 	</html>
