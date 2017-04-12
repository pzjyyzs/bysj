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
    
    <title>My JSP 'wenzhang.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="icon" href="img/logo.ico" />
		<link rel="stylesheet" href="css/normalize.css" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/wenzhang.css" />
		<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script src="js/showdown.min.js"></script>
		<script type="text/javascript" src="js/wenzhang.js"></script>
  </head>
  
  <body>
		<!-- 	全局顶部导航-->
		<nav class="navbar">
			<div class="width-limit">
				<!-- 左上方Logo-->
				<a class="logo">
					<img src="img/title.png" width="75px" height="50px" />
				</a>
				<!-- 右上角-->
				<!-- 登录显示写文章-->
				<a class="btn write-btn" target="_blank">
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
								<a href="/">
									<span>消息</span>
								</a>
							</li>
							<li class="search">
								<form target="_blank" action="">
									<input type="text" name="q" id="q" placeholder="搜索" class="search-input" />
									<a class="search-btn" href="javascript:void(null)">
										<i class="glyphicon glyphicon-search"></i>
									</a>
								</form>
							</li>
						</ul>
					</div>
				</div>
		</nav>

		<div class="note">
			<div class="article">
				<div class="nierong-information">
					<h1 class="art-title"><c:out value="${sessionScope.article.articlename }"></c:out>  </h1>
					<!-- 作者区域 -->
					<div class="art-author">

						<a class="avatar" href="/u/5c83f83802db">
							<img src="img/icon1.png" alt="144">
						</a>
						<div class="info">
							<span class="tag">作者</span>
							<span class="name"><a href="#"><c:out value="${sessionScope.auser.username }"></c:out></a></span>
							<!-- 关注用户按钮 -->
							<a class="btn btn-success follow"><i class="iconfont ic-follow"></i><span>关注</span></a>
							<!-- 文章数据信息 -->
							<div class="meta">
								<!-- 如果文章更新时间大于发布时间，那么使用 tooltip 显示更新时间 -->
								<span class="publish-time" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="最后编辑于 2017.04.07 20:42">2017.04.07 20:26*</span>
					
								<span class="views-count">阅读 <c:out value="${sessionScope.article.articleread }"></c:out></span>
								<span class="comments-count">评论 24</span>
								<span class="likes-count">喜欢 22</span>
						</div>
						<!-- 如果是当前作者，加入编辑按钮 -->
					</div>
				</div>
				<input type="hidden" value="${sessionScope.article.articlecontent }" id="wznr"/>
				<div class="art-content" id="art-content"></div>
			</div>
			<div class="meta-bottom">
				<div class="like">
					<div class="btn like-group">
						<div class="btn-like">
							<a>
								<i class="glyphicon glyphicon-heart">喜欢</i>
							</a>
						</div>
						<div class="modal-wrap">
							<a>0</a>
						</div>
					</div>
				</div>
			</div>
			<div class="pinglun">
				<div>
					<form class="new-comment">
						<textarea placeholder="写下你的评论" id="writecomment"></textarea>
						<a class="btn btn-send" id="btn-send-com">发送</a>
					</form>
				</div>
				<div id="comment-list" class="comment-list">
				<c:forEach items="${sessionScope.comlist }" var="comment">
					<div>
						<div class="author">
							<a target="_blank" class="avatar">
								<img src="">
							</a>
							<div class="info">
							<c:set var="flag" value="0" />
							<c:forEach items="${sessionScope.usercomlist }" var="user">
							
							<c:if test="${flag==0}">
								<c:if test="${comment.comuserid == user.uid }">
									<a target="_blank" class="name">${user.username }</a>
									 <c:set var="flag" value="1"/>
								</c:if>	
							</c:if>
							</c:forEach>
								<div class="meta">
									<span>${comment.comtime }</span>
								</div>
							</div>
						</div>
						<div class="comment-wrap">
							<p>${comment.comtext }</p>
							<div class="tool-group">
								<a>
									<i class="glyphicon glyphicon-comment"></i>
									<span>回复</span>
								</a>
							</div>
						</div>
					</div>
				 </c:forEach>
				</div>
			</div>
		</div>
		</div>
		<div class="include-collection">
			<div class="main">
				<div class="title">被以下专题收入</div>
				<div class="include-collection">
					<a href="" target="_blank" class="item">
						<img src="img/enhanced-buzz-wide-16461-1372163238-8.jpg">
						<div class="name">生活家</div>
					</a>
				</div>
			</div>
		</div>
	</body>

</html>
