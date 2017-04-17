<%@ page language="java" import="java.util.*" import="com.yidu.lly.model.User" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'indexuser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/indexuser.css" />
		<script type="text/javascript" src="js/jquery-3.1.1.min.js" ></script>
		<script type="text/javascript" src="js/flushSsession.js"></script>
		<script src="js/bootstrap.min.js"></script>
  </head>
  
  <body>
<jsp:include page="header.jsp"/>
<input class="myguanzhuId" type="hidden" value="${user.uid}">
  <input class="otherguanzhuId" type="hidden" value="${OtherUser.uid}">
<div class="container person">

			<div class="row">
				<div class="col-xs-16 main">
					<div class="main-top">
						<a class="avatar" href="/">
							<img src="${OtherUser.img}" style="width: 80px;height: 80px;">
							<!--<img src="${user.img }">-->
						</a>
						<span style="${str1}"><a class="btn btn-default following" href="friend/addfriend.do?username=${OtherUser.username}&userid=${OtherUser.uid}">关注</a></span>
					 <span style="${str2}"><a class="btn btn-default following" href="friend/delfriend.do?username=${OtherUser.username}&userid=${OtherUser.uid}">取消关注</a></span>
	
						<a class="btn btn-hollow" href="mail/showSession.do?userid=${OtherUser.uid}">发私信</a>
						<div class="title">

							<a class="name" href="">${OtherUser.username}</a>
						</div>
						<div class="info">
							<ul>
								<li>
									<div class="meta-block">
										<a href="/users/b795f5968940/following">
											<p>${hisfriend} </p>
											关注 <i class="iconfont ic-arrow"></i>
										</a>
									</div>
								</li>
								<li>
									<div class="meta-block">
										<a href="/users/b795f5968940/followers">
											<p> ${hisfans} </p>
											粉丝 <i class="iconfont ic-arrow"></i>
										</a>
									</div>
								</li>
								<li>
									<div class="meta-block">
										<a href="/u/b795f5968940">
											<p>0</p>
											文章 <i class="iconfont ic-arrow"></i>
										</a>
									</div>
								</li>
								<li>
									<div class="meta-block">
										<p>0</p>
										<div>字数</div>
									</div>
								</li>
								<li>
									<div class="meta-block">
										<p>0</p>
										<div>收获喜欢</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<div id="outer-container">
						<ul class="trigger-menu" data-pjax-container="#list-container">
							<li class="active"><a href="/u/b795f5968940?order_by=shared_at"><i class="iconfont ic-articles"></i> 文章</a></li>
							<li class=""><a href="/users/b795f5968940/timeline"><i class="iconfont ic-feed"></i> 动态</a></li>
							<li class=""><a href="/u/b795f5968940?order_by=commented_at"><i class="iconfont ic-latestcomments"></i> 最新评论</a></li>
							<li class=""><a href="/u/b795f5968940?order_by=top"><i class="iconfont ic-hot"></i> 热门</a></li>
						</ul>

						<div id="list-container">
							<!-- 文章列表模块 -->
							<ul class="note-list" infinite-scroll-url="/u/b795f5968940?order_by=shared_at">
							</ul>
						</div>
					</div>

				</div>

				<div class="col-xs-7 col-xs-offset-1 aside">
					<div class="title">个人介绍</div>

					<div class="description">
						${OtherUser.userintroduce} 
					</div>

					<div>
						<div>
							<!---->
							<div class="title">他创建的专题</div>
							<ul class="list">
								<li>
									<a href="/c/664e44a59ecf" target="_blank" class="avatar-collection">
										<img src="img/135425.jpg"></a>
									<a href="/c/664e44a59ecf" target="_blank" class="name">欧陆漫记</a>
								</li>
							</ul>

						</div>
						<!---->
						<!---->
					</div>
				</div>
			</div>
</div>

  </body>		
  

</html>
