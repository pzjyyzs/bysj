<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<link rel="stylesheet" href="http://cdn.bootcss.com/normalize/5.0.0/normalize.min.css"/>
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
				<a class="btn write-btn" target="_blank">
					<i class="glyphicon glyphicon-leaf">写文章</i>
				</a>
				<div class="user">
					<div class="avatar">
						<a href="/">
							<img src="">
						</a>
					</div>
				</div>
				<div class="container">
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav">
							<li>
								<a href="/">
									<span>关注</span>
								</a>
							</li>
							<li class="notification">
								<a href="/">
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
		<div class="container index">
			<div class="row">
				<div id="indexCarousel" class="carousel slide">
					<div class="carousel-inner">
						<div class="item active">
							<a target="_blank" href="/">
								<img src="img/f9acf8c489f37ad53b643fadf94bbaedee2fbcd9.jpg" alt="First slide" height="270px"/>
							</a>
						</div>
						<div class="item">
							<a target="_blank" href="/">
								<img src="img/e010ca25bf9caae6e5f9751840ec9266aed7b253.jpg" alt="Second slide" height="270px"/>
							</a>
						</div>
						<div class="item">
							<a target="_blank" href="/">
								<img src="img/d94049874f73053457c75f36d7cea1779c5252d9.jpg" alt="Third slide" height="270px"/>
							</a>
						</div>
					</div>
					<a class="left carousel-control"  href="#indexCarousel"  role="button" data-slide="prev">
						<i class="glyphicon glyphicon-chevron-left"></i>
					</a>
					<a class="right carousel-control"  href="#indexCarousel" role="button"  data-slide="next">
						<i class="glyphicon glyphicon-chevron-right"></i>
					</a>
				</div>
				<div class="col-md-8 main">
					<div class="recommend-collection">
						<a target="_blank" class="collection" href="/">
							<img src=""/ alt="195">
							<div class="name">漫画·手绘</div>
						</a>
						<a class="more-hot-collection" target="_blank" href="/">
							更多热门专题
							<i class="glyphicon glyphicon-link"></i>
						</a>
					</div>
					<div class="split-line">
						
					</div>
					<div class="list-container">
						<ul class="note-list">
							<li class="have-img" id="node-">
								<a class="wrap-img" href="" target="_blank">
									<img src="">
								</a>
								<div class="content">
									<div class="author">
										<a class="avatar" target="_blank" href="">
											<img src="" />
										</a>
										<div class="name">
											<a class="blue-link" target="_blank" href="">作者</a>
											<span class="time">时间</span>
										</div>
									</div>
									<a class="title" target="_blank" href="">标题</a>
									<p class="abstract">部分内容显示</p>
									<div class="meta">
										<a class="collection-tag" target="_blank" href="">专题名称</a>
										<a target="_blank" href="">
											<i class="glyphicon glyphicon-record"></i>
											阅读数量
										</a>
										<a target="_blank" href="">
											<i class="glyphicon glyphicon-comment"></i>
											评论数量
										</a>
										<a target="_blank" href="">
											<i class="glyphicon glyphicon-heart"></i>
											点赞数量
										</a>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="aside">
					<div class="board">
						<a target="_blank" href="/">
							<img src="img/banner-s-1-b8ff9ec59f72ea88ecc8c42956f41f78.png" width="280px" height="50px">
						</a>
						<a target="_blank" href="/">
							<img src="img/banner-s-3-7123fd94750759acf7eca05b871e9d17.png" width="280px" height="50px">
						</a>
						<a target="_blank" href="/">
							<img src="img/banner-s-4-b70da70d679593510ac93a172dfbaeaa.png" width="280px" height="50px">
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="side-tool"></div>
		<footer class="container">
			<div class="row">
				<div class="col-xs-8 main">
					<a href="/">关于易读</a>
					<em> · </em>
					<a href="/">联系我们</a>
					<em> · </em>
					<a href="/">加入我们</a>
					<em> · </em>
					<a href="/">帮助中心</a>
					<em> · </em>
					<a href="/">合作伙伴</a>
					<em> · </em>
					<div class="icp">
						@2017 天津龙利鱼信息科技有限公司  / Tel: 110 / 易读  / 津ICP备11018329号-5
					</div>
				</div>
			</div>
		</footer>
		
		
	</body>
  </body>
</html>