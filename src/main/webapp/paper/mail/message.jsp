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

<script type="text/javascript" src="js/message2.js"></script>
<script src="js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/liaotian.css" />

</head>

  <style type="text/css">
.liaotiankuang .message-show {

}
</style>

<body>
<jsp:include page="/paper/message/MessageIndex.jsp"></jsp:include>
<input id="userid" type="hidden" value="${OtherUser.uid} ">
<input id="ChatObject" type="hidden" value="${OtherUser.img} ">
<input id="Chatme" type="hidden" value="${user.img} ">

  <input id="myuseruid" type="hidden" value="${user.uid}">
<input id="otheruseruid" type="hidden" value="${OtherUser.uid}">

<div  class="liaotiankuang">
			<div class="chat-top">
				<a href="mail/showObjectUserList.do" class="back-to-list active">
					<i class="iconfont ic-back"></i> 返回私信列表
                </a> 
    <b>与<a target="_blank">${OtherUser.username}</a>的对话</b>
				
			</div>
			
          <jsp:include page="session.jsp"/> 
                
			<div class="write-message">
				<form accept-charset='UTF-8'>
					<textarea id="myMessage" name='myMessage' type="text" placeholder="输入内容" class="form-control"></textarea> 
					<input type="reset" class="btn btn-send submitsend" value="发送">
				</form>
				<div class="hint">SHIFT + ENTER 换行，ENTER 直接发送</div>
			</div>
		
		</div>





</body>



<%-- <a href="mail/showObjectUserList.do">返回私信页面</a>
<p>和---${OtherUser.username}的会话</p>

<!-- <form action="mail/writeMail.do" method="post" accept-charset='UTF-8' > -->
<form  action="" accept-charset='UTF-8' >
<textarea  id="myMessage" name='myMessage' cols="30" rows="4" > </textarea> 
    <input class="submitsend" type="reset" value="提交">
    </form>  --%>


</html>
