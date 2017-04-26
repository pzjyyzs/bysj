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

</head>


<body>
	<style type="text/css">
	

.list-container {
	text-align: left;
	float: left;
	margin-top: 100px;
	margin-left:320px;
}

.index .main .list-container .note-list {
	width: 625px;
	height: 200px;
	margin: 0;
	padding: 0;
	list-style: none;
}

.index .main .list-container .note-list li {
	position: relative;
	width: 100%;
	margin: 0 0 17px; 
	padding: 0 2px 17px 0; 
	border-bottom: 1px solid #f0f0f00;
	word-wrap: break-word;
	display: block;
}

.index .main .list-container .note-list li .have-img {
	min-height: 140px;
}

.note-list .hava-img .wrap-img {
	position: absolute;
	top: 30%;
	left: 75%;
	margin-top: -68px;
	right: 0;
	width: 150px;
	height: 120px;
}

.note-list .hava-img .wrap-img img {
	width: 100%;
	height: 100%;
	border-radius: 4px;
	border: 1px solid #f0f0f0;
}

.note-list .have-img>div {
	padding-right: 160px;
}

.note-list .author {
	margin-bottom: 14px;
	font-size: 13px;
}

.content .author .avatar {
	width: 32px;
	height: 32px;
	cursor: pointer;
}

.avatar img {
	width: 100%;
	height: 100%;
	border: 1px solid #ddd;
	border-radius: 50%;
}

.note-list .author .avatar,.note-list .author .name {
	display: inline-block;
	vertical-align: middle;
}

.note-list .author .name span {
	display: inline-block;
	padding-left: 3px;
	color: #969696;
}

.note-list .abstract {
	margin: 0 0 8px;
	font-size: 13px;
	line-height: 24px;
}

.note-list .hava-img .abstract {
	width: 463px;
	height: 72px;
	overflow: hidden;
	text-overflow: ellipsis;
}

.note-list .no-img .abstract {
	width: 623px;
	height: 48px;
	overflow: hidden;
	text-overflow: ellipsis;
}

.note-list .meta {
	padding-right: 0 !important;
	font-size: 12px;
	font-weight: 400;
	line-height: 20px;
}

.note-list .meta a,.note-list .meta a:hover {
	transition: .1s ease-in;
	-webkit-transition: .1s ease-in;
	-moz-transition: .1s ease-in;
	-o-transition: .1s ease-in;
	-ms-transition: .1s ease-in;
}

.note-list .meta a {
	margin-right: 10px;
	color: #b4b4b4;
}

.note-list .title {
	margin: -7px 0 4px;
	display: inherit;
	font-size: 18px;
	font-weight: 700;
	line-height: 1.5;
}
</style>

	<div class="container">
		
		
		<div class="list-conta" >
		<jsp:include page="/paper/MyFriend.jsp" />

		</div>
		
		
		<div class="list-container">
			<!--文章详情显示列表-->
			<ul class="note-list">
				<c:forEach items="${articlelist}" var="articlelist">
					<c:if test="${not empty articlelist.aimgaddress }">
						<!--有图片的文章详情显示-->
						<li class="hava-img"><a class="wrap-img" href=""
							target="_blank"> <img src="img/135425.jpg" />
						</a>
							<div class="content">
								<div class="author">
									<a class="avatar" target="_blank" href="">
										<img src="${articlelist.img}" />
									</a>
									<div class="name">
                                          
										<a class="blue-link" target="_blank"
											href="user/showOtheruser.do?userid=${articlelist.uid}">

											 ${articlelist.username}</a> <span class="time">${articlelist.articletime}</span>
									</div>
								</div>
								<a class="title" target="_blank"
									href="article/showArticleId.do?aid=${articlelist.aid}">${articlelist.articlename}</a>
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
					<c:if test="${empty articlelist.aimgaddress }">
					
						<li class="no-img">
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
									href="article/showArticleId.do?aid=${articlelist.aid}">${articlelist.articlename}</a>
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

	</div>
</body>



</html>
