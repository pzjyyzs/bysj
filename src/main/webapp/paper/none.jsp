<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<html>
  <head>
	

</head>


<body>
    	<jsp:include page="MyFriend.jsp"/>
<div class="right">
					<div class="find-nothing">
						<img src="img/nonono.png">
					</div>
				</div>
 	</body>
 	</html>
