<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" href="css/friendatlist.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>


<body>


	<%-- <div>
	<jsp:include page="/paper/MyFriend.jsp" />
	</div> --%>
	
			<div class="list-container">
				<!--文章详情显示列表-->
			<ul class="note-list">
				<c:forEach items="${articlelist}" var="articlelist">
					<c:if test="${not empty article.aimgaddress }">
						<!--有图片的文章详情显示-->
						<li class="hava-img"><a class="wrap-img" href=""
							target="_blank"> <img src="img/135425.jpg" />
						</a>
							<div class="content">
								<div class="author">
									<a class="avatar" target="_blank" href="javascript:void(null)">
										<img src="${articlelist.img}" />
									</a>
									<div class="name">

										<a class="blue-link" target="_blank"
											href="user/showOtheruser.do?userid=${articlelist.uid}">

											${articlelist.username} </a> <span class="time">${articlelist.articletime}</span>
									</div>
								</div>
								<a class="title" target="_blank"
									href="article/showArticleId.do?aid=${articlelist.aid }">${articlelist.articlename}</a>
								<p class="abstract">${articlelist.articlecontent}</p>
								<div class="meta">
									<a target="_blank" href="javascript:void(null)"> <i
										class="glyphicon glyphicon-record"> </i> 阅读量

									</a> <a target="_blank" href="javascript:void(null)"> <i
										class="glyphicon glyphicon-comment"></i>
										评论数量${articlelist.comcount}
									</a> <a target="_blank" href="javascript:void(null)"> <i
										class="glyphicon glyphicon-heart"></i>
										点赞数量${articlelist.likecount}
									</a>
								</div>
							</div></li>
					</c:if>

					<!--没有图片的文章详情显示-->
					<c:if test="${empty article.aimgaddress }">
						<li class="no-img">
							<div class="content">
								<div class="author">
									<a class="avatar" target="_blank" href="javascript:void(null)">
										<img src="${articlelist.img}" />
									</a>
									<div class="name">


										<a class="blue-link" target="_blank"
											href="user/showOtheruser.do?userid=${user.uid}">
											${articlelist.username} </a> <span class="time">${articlelist.articletime}</span>
									</div>
								</div>
								<a class="title" target="_blank"
									href="article/showArticleId.do?aid=${article.aid }">${articlelist.articlename}</a>
								<p class="abstract">${articlelist.articlecontent}</p>
								<div class="meta">
									<a target="_blank" href="javascript:void(null)"> <i
										class="glyphicon glyphicon-record"></i> 阅读量
									</a> <a target="_blank" href="javascript:void(null)"> <i
										class="glyphicon glyphicon-comment"></i>
										评论数量${articlelist.comcount}
									</a> <a target="_blank" href="javascript:void(null)"> <i
										class="glyphicon glyphicon-heart"></i>
										点赞数量${articlelist.likecount}
									</a>
								</div>
							</div>
						</li>
					</c:if>


				</c:forEach>
			</ul>
		</div>
		
	
</body>



</html>
