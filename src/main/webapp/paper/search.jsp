<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'search.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" href="css/search.css"/>
	<script type="text/javascript" src="js/jquery-3.1.1.min.js" ></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/search.js" ></script>
  </head>
  
  <body>
    <jsp:include page="header.jsp"/>
    <div class="container search">
			<div class="row">
				<div class="aside">
					<ul class="menu">
						<li>
							<a>
								<div class="setting-icon">
									<i class="glyphicon glyphicon-book"></i>
								</div>
								<span>文章</span>
							</a>
						</li>
						<li>
							<a>
								<div class="setting-icon">
									<i class="glyphicon glyphicon-user"></i>
								</div>
								<span>用户</span>
							</a>
						</li>
						<li>
							<a>
								<div class="setting-icon">
									<i class="glyphicon glyphicon-th-large"></i>
								</div>
								<span>专题</span>
							</a>
						</li>
					</ul>
				</div>
				<div class="col-xs-offset-4 col-xs-6 main">
					<div class="search-content">
						<ul class="note-list">
							<li>
								<div class="content">
									<div class="author">
										<a class="avatar">
											<img src="">
										</a>
										<div class="name">
											<a href="">Mr希灵</a>
										</div>
									</div>
									<a class="title">软件测试总结</a>
									<p class="abstract"></p>
								</div>		
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
  </body>
</html>
