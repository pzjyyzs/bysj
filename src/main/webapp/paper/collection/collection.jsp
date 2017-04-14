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
    
    <title>专题 - 易读</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="icon" href="img/logo.ico"/>
	<link rel="stylesheet" href="css/collection.css" />
	<link rel="stylesheet" href="css/normalize.css"/>
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<script type="text/javascript" src="js/jquery-3.1.1.min.js" ></script>
	<script src="js/bootstrap.min.js"></script>

  </head>
  
  <body  style="overflow-y: scroll;">
   <jsp:include page="../header.jsp"/> 
   <div class="container collection">
			<div class="row">
				<div class="col-xs-8 main">
					<!-- 专题头部模块  -->
					<div class="main-top">
						<a class="avatar-collection" href="javascript:void(null)">
							<img src="${sessionScope.collection.collectionimg }">
						</a>
						<a class="btn btn-success follow">
							<i class="glyphicon glyphicon-plus"></i>
							<span>收藏</span>
						</a>
						<div class="btn btn-hollow js-contribute-button">
							投稿
						</div>
						<div class="title">
							<a class="name" href="javascript:void(null)">${sessionScope.collection.collectionname }</a>
						</div>
						<div class="info">
							收录了${sessionScope.colArticAidSize }篇文章 · xxx人收藏 
						</div>
					</div>
					<ul class="trigger-menu">
						<li class="active">
							<a href="">
								<i class="glyphicon glyphicon-tasks">
									最新收录
								</i>
							</a>
						</li>
						<li>
							<a href="">
								<i class="glyphicon glyphicon-fire">
									热门
								</i>
							</a>
						</li>
					</ul>
					<div id="list-container">
						<ul class="note-list">
						 <c:if test="${sessionScope.flagcolartc == true }">
						 	<c:forEach items="${sessionScope.colArticle }" var="article">
						 	<c:if test="${not empty article.aimgaddress }">
							<li class="hava-img">
								<a class="wrap-img" href="" target="_blank">
									<img src="${article.aimgaddress }" />
								</a>
								<div class="content">
									<div class="author">
										<a class="avatar" target="_blank" href="javascript:void(null)">
											<img src="" />
										</a>
										<div class="name">
											<a class="blue-link" target="_blank" href="">
											<c:set var="flag" value="0" />
											<c:forEach items="${sessionScope.colArticleUser }" var="user">
											<c:if test="${flag==0}">
												<c:if test="${user.uid==article.uid }">
												${user.username }
												<c:set var="flag" value="1"/>
												</c:if>
											</c:if>	
											</c:forEach>
											</a>
											<span class="time">${article.articletime }</span>
										</div>
									</div>
									<a class="title" target="_blank" href="article/showArticleId.do?aid=${article.aid }">${article.articlename }</a>
									<p class="abstract">${article.articlecontent }</p>
									<div class="meta">
										<a target="_blank" href="javascript:void(null)">
											<i class="glyphicon glyphicon-record"></i>
											${article.articleread }
										</a>
										<a target="_blank" href="javascript:void(null)">
											<i class="glyphicon glyphicon-comment"></i>
											评论数量
										</a>
										<a target="_blank" href="javascript:void(null)">
											<i class="glyphicon glyphicon-heart"></i>
											点赞数量
										</a>
									</div>
								</div>
							</li>
							</c:if>
							<c:if test="${empty article.aimgaddress }">
							<li class="no-img">
									<div class="content">
										<div class="author">
											<a class="avatar" target="_blank" href="javascript:void(null)">
												<img src="" />
											</a>
											<div class="name">
												<a class="blue-link" target="_blank" href="">
													<c:set var="flag" value="0" />
											<c:forEach items="${sessionScope.colArticleUser }" var="user">
											<c:if test="${flag==0}">
												<c:if test="${user.uid==article.uid }">
												${user.username }
												<c:set var="flag" value="1"/>
												</c:if>
											</c:if>	
											</c:forEach>
												</a>
												<span class="time">${article.articletime }</span>
											</div>
										</div>
										<a class="title" target="_blank" href="article/showArticleId.do?aid=${article.aid }">${article.articlename }</a>
										<p class="abstract">${article.articlecontent }</p>
										<div class="meta">
											<a target="_blank" href="javascript:void(null)">
												<i class="glyphicon glyphicon-record"></i>
												${article.articleread }
											</a>
											<a target="_blank" href="javascript:void(null)">
												<i class="glyphicon glyphicon-comment"></i>
												评论数量
											</a>
											<a target="_blank" href="javascript:void(null)">
												<i class="glyphicon glyphicon-heart"></i>
												点赞数量
											</a>
										</div>
									</div>
								</li>
								</c:if>
								</c:forEach>
							</c:if>
						</ul>
					</div>
				</div>
				<div class="col-xs-4 aside">
					<p class="title">专题公告</p>
					<div class="description">${sessionScope.collection.collectionintroduce }</div>
					<div class="share">
						<span>分享至</span>
					</div>
					<div>
						<div>
							<p class="title">管理员</p>
							<ul class="list">
								<li>
									<a href="" class="avatar">
										<img src="${sessionScope.collectionUser.img }">
									</a>
									<a href="" class="name">${sessionScope.collectionUser.username }</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="user-action">
						<c:if test="${sessionScope.collection.uid == sessionScope.user.uid }">
							<a class="name" href="updateColl.jsp">编辑专题</a>
						</c:if>
					</div>
				</div>
			</div>
		</div>
  </body>
</html>
