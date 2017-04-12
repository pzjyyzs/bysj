<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<title>首页 - 易读</title>
		<link rel="icon" href="img/logo.ico"/>
		<link rel="stylesheet" href="css/index.css" />
		<link rel="stylesheet" href="css/normalize.css"/>
		<link rel="stylesheet" href="css/bootstrap.min.css"/>
		<script type="text/javascript" src="js/jquery-3.1.1.min.js" ></script>
		<script src="js/bootstrap.min.js"></script>
  </head>
  
  <body>
    <body>
		<!-- 	全局顶部导航-->
		<nav class="navbar">
			<div class="width-limit">
				<!-- 左上方Logo-->
				<a class="logo">
					<img src="img/title.png" width="75px" height="50px"/>
				</a>
				<!-- 右上角-->
				<!-- 登录显示写文章-->
				<a class="btn write-btn" target="_blank" href="paper/article/write.jsp">
					<i class="glyphicon glyphicon-leaf">写文章</i>
				</a>
				<div class="user">
					<div class="avatar">
						<a href="user/showmyuser.do">
							<img src="">
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
							<li class="notification">
								<a href="Message/ToMessage.do">
									<span>消息</span>
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
  </body>
</html>
