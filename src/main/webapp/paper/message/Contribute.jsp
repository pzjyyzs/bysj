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
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/contribute.css">
	
  </head>
  
  <body>
    <jsp:include page="/paper/message/MessageIndex.jsp"></jsp:include>
    
    <div class="col-xs-8 col-xs-offset-4 lmain">
			<div>
				<div class="menu">全部投稿请求</div>
				<ul class="push-list">
					<li>
						<a href="" class="wrap">
							<div class="all-push">
								<i class="glyphicon glyphicon-open"></i>
							</div>
							<div class="name">全部未处理请求</div>
						</a>
					</li>
					<c:forEach var="collection" items="${sessionScope.uidCollection }">
					<li>
						<a href="" class="wrap">
							<div class="avatar-collection">
								<img src="${collection.collectionimg }">
							</div>
							<div class="name">
								<c:out value="${collection.collectionname }"/>
								<div>还有1个投稿未处理</div>
							</div>
							
						</a>
					</li>
					</c:forEach>
			</div>
		</div>
  </body>
</html>
