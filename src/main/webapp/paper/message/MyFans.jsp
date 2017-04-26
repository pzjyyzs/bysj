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
		<link rel="stylesheet" href="css/myfans.css" />
		<script type="text/javascript" src="js/jquery-3.1.1.min.js" ></script>
		<script src="js/bootstrap.min.js"></script>
  </head>
  
  <body>
   		<jsp:include page="MessageIndex.jsp"/> 
   		
   		<%-- <c:forEach var="userlist" items="${userlist}">
	    <div>${userlist.img}</div>
	     <div  class="">
 
	     <span class="guanzhu${userlist.uid}">
	     <a href="user/showOtheruser.do?userid=${userlist.uid}">${userlist.username}</a>
	        关注了你
	     </span>
	             
	     </div>
   </c:forEach> --%>
   		
   		<div class="userlistbb">
			<div class="menu">我的粉丝</div>
			<ul class="like-list">
				<c:forEach var="userlist" items="${userlist}">
		      <li class="">
					<a  class="avatar"><img src="${userlist.img}"></a>
					<div class="info"><a href="user/showOtheruser.do?userid=${userlist.uid}" class="user">${userlist.username}</a> <span class="guanzhu${userlist.uid}">关注了你</span> 
						<div class="time">
						<span class="guanzhu2${userlist.uid}"></span>
						</div>
					</div>
				</li>
				 </c:forEach>
			</ul>
		</div>
   		
  </body>

</html>
