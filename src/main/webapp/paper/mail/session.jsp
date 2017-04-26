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
		<script type="text/javascript" src="js/message.js" ></script>
		<script src="js/bootstrap.min.js"></script>



  </head>
  
  <body>

	<%-- 	
	<c:forEach  var="OurSession"  items="${OurSession}">
	 <c:if test="${OtherUser.uid==OurSession.sendid}">
       ${OtherUser.username}:
    </c:if>
    <c:if test="${user.uid==OurSession.sendid}">
       ${user.username}:
    </c:if> 
		<div>${OurSession.cotent}</div>
		<div>${OurSession.creattime}</div>
   </c:forEach> --%>
       
   				<div  class="message-show">
				<ul id="myDiv" class="message-list">
					<c:forEach var="OurSession" items="${OurSession}">
						<c:if test="${OtherUser.uid==OurSession.sendid}">
 
					<li class="message-l">
						<a class="avatar"><img src="${OtherUser.img}"></a>
						<div><span class="content">${OurSession.cotent}</span></div> 
						<span class="time">${OurSession.creattime}</span>
					</li>
                             </c:if>
                             
                             
                             
                             <c:if test="${user.uid==OurSession.sendid}">
					<li class="message-r">
						<a  class="avatar"><img src="${user.img}"></a>
						<div class="wdcontent"><span class="content">${OurSession.cotent}</span></div> 
						<span class="time">${OurSession.creattime}</span>
					</li>
						</c:if>
				</c:forEach>
				</ul>
			</div>
			

   				
   			
   			
   			  
  </body>

</html>
