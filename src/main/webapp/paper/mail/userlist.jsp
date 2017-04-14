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
		<link rel="stylesheet" href="css/indexuser.css" />
		<script type="text/javascript" src="js/jquery-3.1.1.min.js" ></script>
		<script type="text/javascript" src="js/login.js"></script>
		<script src="js/bootstrap.min.js"></script>
	<script>               


  </script>

  </head>
  
  <body>
 
  	<jsp:include page="/paper/message/MessageIndex.jsp"></jsp:include>
  	 <p>全部私信：</p>
<c:forEach var="userlist" items="${userlist}">
	  <div class="freitem">
	<%--   <input id="useruid" type="text" value="${user.uid}">
	   <input id="userlistuid" type="text" value="${userlist.uid}"> --%>
	    <div class="mail${userlist.uid}">名字：<a href="mail/showSession.do?userid=${userlist.uid}">${userlist.username}</a></div>
		<div class="">头像：<a href="user/showOtheruser.do?userid=${userlist.uid}">${userlist.img}</a></div>
		<div><a href="mail/delSession.do?userId1=${user.uid}&userId2=${userlist.uid}">删除会话</a></div>
	  </div>
   </c:forEach>
   			
  </body>

</html>
