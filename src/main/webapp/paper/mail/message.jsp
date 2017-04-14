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
<script type="text/javascript" src="js/message.js"></script>
<script type="text/javascript" src="js/flushSsession.js" ></script>


<script src="js/bootstrap.min.js"></script>

<script type="text/javascript">
	
</script>

</head>



<body>
<jsp:include page="/paper/header.jsp"/> 
<input id="userid" type="hidden" value="${OtherUser.uid} ">
<input id="ChatObject" type="hidden" value="${OtherUser.username} ">

  <input id="myuseruid" type="text" value="${user.uid}">
<input id="otheruseruid" type="text" value="${OtherUser.uid}">

<a href="mail/showObjectUserList.do">返回私信页面</a>
<p>和---${OtherUser.username}的会话</p>
<div id="myDiv">

<jsp:include page="session.jsp"/> 
</div>
<form action="mail/writeMail.do" method="post" accept-charset='UTF-8' >
<textarea  name='myMessage' cols="30" rows="4" > </textarea> 
    <input type="submit">
    </form> 

</body>

</html>
