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
    
    <title>My JSP 'indexuser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/MessageIndex.css" />
		<script type="text/javascript" src="js/jquery-3.1.1.min.js" ></script>
		<script src="js/bootstrap.min.js"></script>
  </head>
  
  <body>
  <div><jsp:include page="/paper/header.jsp"/></div>
   		
   		
   				<div class="main">
			<div class="container notification">
				<div class="row">
					<div class="aside">
						<ul>
							<li class="active"><a href="#"><img src="img/pinglun.png"><i class="iconfont ic-comments"></i> <span>评论</span> <!----></a></li>
							<li class=""><a href="mail/showObjectUserList.do"><img src="img/xingfeng.png"><i class="iconfont ic-chats"></i> <span class="privateMail">私信</span> <span class="badge">2</span></a></li>
							<li class=""><a href="#"><img src="img/tougao.png"><i class="iconfont ic-requests"></i> <span> 投稿请求</span> <!----></a></li>
							<li class=""><a href="#"><img src="img/xihuan.png"><i class="iconfont ic-likes"></i> <span> 喜欢和赞</span> <!----></a></li>
							<li class=""><a href="friend/showmyfans.do"><img src="img/guanzhu.png"><i class="iconfont ic-follows"></i> <span  class="myguanzhu"> 关注</span> <span class="badge">1</span></a></li>
						</ul>
					</div>
					<div class="right">
						<div>
							<ul class="note-list">

							</ul>
							<div class="find-nothing"><img src="img/nonono.png">
								<div>这里还木有内容哦~</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
  </body>

</html>
