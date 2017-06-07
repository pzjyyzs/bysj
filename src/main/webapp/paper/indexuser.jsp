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
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/indexuser.js"></script>
<!-- <link rel="stylesheet" href="css/friendatlist.css" /> -->


</head>

<%--   <body>

 <div class="container">
 <div class=myIntroduce>
   姓名：${user.username}<br>
    性别：${user.sex}<br>
    关注：${myfriend}<br>
    粉丝：${myfans}<br>
   头像：	<div class="">
   	 <img src=" ${user.img }">
		<a href="user/">更改头像</a>
			</div>
			<br>
    自我介绍：${user.userintroduce}<br>
<!-- 编辑自我介绍：<input type="button" class='update' vlaue="编辑" onclick="UpdateHtml()"/><br> -->	

 <a class="function-btn" data-action="start-edit-intro" href="javascript:void(0)" onclick="UpdateHtml()"><i class="iconfont ic-edit-s"></i>编辑</a><br>		
 </div>
  </div>
  </body> --%>
<style type="text/css">
.rightttt {
	width: 630;
	float: left;
	font-size: 15px;
	color: #fff;
}

.personintr {
	float: right;
	width: 280px;
	margin-top: 70px;
}

div.row {
	margin-left: -15px;
	margin-right: -15px;
	height: 180;
	width: 680;
}

.list-container {
	text-align: left;
	margin-top: 75px;
	margin-left: 0px;
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
.main .main-top .info {
margin-top: 5px;
padding-left: 100px;
font-size: 29px;
}
.info li
{
width:80px;
}
</style>


<body>
	<!-- 	全局顶部导航-->
	<jsp:include page="header.jsp" />
	<!–#include virtual=”header.html” –>
	<!--<iframe src="header.html" width="100%" height="56" ></iframe>-->
	<div class="container person">
		<div class="rightttt">
			<div class="row">
				<div class=" main">
					<div class="main-top">
						<a class="avatar"> <img src="${user.img }"
							style="width: 80px;height: 80px;"> <!--<img src="${user.img }">-->
						</a>

						<div class="title">
							<a class="name" >${user.username}</a>
						</div>
						<div class="info">
							<ul>
								<li>
									<div class="meta-block">
										<a>
											<p>${myfriend}</p> 关注 <i class="iconfont ic-arrow"></i>
										</a>
									</div>
								</li>
								<li>
									<div class="meta-block">
										<a >
											<p>${myfans}</p> 粉丝 <i class="iconfont ic-arrow"></i>
										</a>
									</div>
								</li>
								<li>
									<div class="meta-block">
										<a >
											<p>${articlecount}</p> 文章 <i class="iconfont ic-arrow"></i>
										</a>
									</div>
								</li>
								
							</ul>
						</div>
					</div>
					<div id="outer-container">
						<ul class="trigger-menu" data-pjax-container="#list-container">
							<li class="active"><a
								><i
									class="iconfont ic-articles"></i> 我的文章</a></li>
							
						</ul>

						<div id="list-container">
							<!-- 文章列表模块 -->
							<ul class="note-list"
								infinite-scroll-url="/u/b795f5968940?order_by=shared_at">
							</ul>
						</div>
					</div>

				</div>

			</div>

<div class="list-container">
			<!--文章详情显示列表-->
			<ul class="note-list">
				<c:forEach items="${MyArticleList}" var="MyArticleList">


					<!--没有图片的文章详情显示-->
					<c:if test="${empty MyArticleList.aimgaddress }">

						<li class="no-img">
							<div class="content">
								<div class="author">
									<a class="avatar" target="_blank" href="javascript:void(null)">
										<img src="${MyArticleList.img}" />
									</a>
									<div class="name">


										<a class="blue-link" target="_blank"
											>
											${MyArticleList.username} </a> <span class="time">${MyArticleList.articletime}</span>
									</div>
								</div>
								<a class="title" target="_blank"
									href="article/showArticleId.do?aid=${MyArticleList.aid}">${MyArticleList.articlename}</a>
								<p class="abstract">${MyArticleList.articlecontent}</p>
								<div class="meta">
									<a target="_blank" href="javascript:void(null)"> <i
										class="glyphicon glyphicon-record"></i> 阅读量
									</a> <a target="_blank" href="javascript:void(null)"> <i
										class="glyphicon glyphicon-comment"></i>
										评论数量${MyArticleList.comcount}
									</a> <a target="_blank" href="javascript:void(null)"> <i
										class="glyphicon glyphicon-heart"></i>
										点赞数量${MyArticleList.likecount}
									</a>
								</div>
							</div>
						</li>
					</c:if>

				</c:forEach>
			</ul>
		</div>





			</div>
			<div class="personintr">


				<div class="aside">
					<div class="title">个人介绍</div>
					<a class="function-btn" data-action="start-edit-intro"
						href="javascript:void(0)" onclick="UpdateHtml()"><i
						class="iconfont ic-edit-s"></i>编辑</a>


					<div class="description">${user.userintroduce}</div>

					<div>
						<div>
							<!---->
							<div class="title">我创建的专题</div>
							<div class="new-collection-block">
								<a href="/collections/new" class="new-collection-btn"><i
									class="iconfont ic-follow"></i><span>创建一个新专题</span></a>
							</div>
						</div>
						<!---->
						<!---->
					</div>
				</div>

	</div>

		</div>
		
	
			





	<%--  <jsp:include page="article/personArticle.jsp" /> --%>





</body>




</html>
