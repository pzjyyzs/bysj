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
		
		<script type="text/javascript">//<![CDATA[
        function readCom(){
	alert("choushabi");
	}
  
  </script>
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
   		<input id="remindid" type="hidden" value="${user.uid}">

   		<div class="userlistbb GainComdiv">
			<div class="menu">我收到的评论</div>
        </div>
</body>	
</html>