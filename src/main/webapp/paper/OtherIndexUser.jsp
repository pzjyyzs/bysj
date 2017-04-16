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
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" href="" />
		<script type="text/javascript" src="js/jquery-3.1.1.min.js" ></script>
		<script type="text/javascript" src="js/flushSsession.js"></script>
		<script src="js/bootstrap.min.js"></script>
  </head>
  
  <body>
<jsp:include page="header.jsp"/>

  <input class="myguanzhuId" type="text" value="${user.uid}">
   <input class="otherguanzhuId" type="text" value="${OtherUser.uid}">

  姓名：${OtherUser.username}<br>
    性别：${OtherUser.sex}<br>
     关注：${hisfriend}<br>
     粉丝：${hisfans}<br>
     
   头像：<div class=""><img src=" ${OtherUser.img}">
                 <span id="" style="${str1}"><a href="friend/addfriend.do?username=${OtherUser.username}&userid=${OtherUser.uid}">关注</a></span>
                 <span id="" style="${str2}"><a href="friend/delfriend.do?username=${OtherUser.username}&userid=${OtherUser.uid}">取消关注</a></span>
               
                 <span><a href="mail/showSession.do?userid=${OtherUser.uid}">发私信</a></span>
                 
   
   </div><br>
    自我介绍：${OtherUser.userintroduce}<br>		
  </body>		
  </body>

</html>
