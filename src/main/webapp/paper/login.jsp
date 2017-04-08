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
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		
		<link rel="stylesheet" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/logincss.css" />
		<script type="text/javascript" src="js/jquery-3.1.1.min.js" ></script>
		<script type="text/javascript" src="js/login.js"></script>
		<script src="js/bootstrap.min.js"></script>
  </head>
  
 <body>
		<div class="sign">
			<div class="logo">
				<a href="/"><img src="img/logo-yd.png" alt="Logo"></a>
			</div>
			<div class="main">
				<div class="kuang">
					<h4 class="title">
  						<div class="normal-title">
    						<a id="js-sign-in-btn" class="active" href="javascript:void(0);">登录</a>
    						<b>·</b>
    						<a id="js-sign-up-btn" class="" href="javascript:void(0);">注册</a>
  						</div>
					</h4>
					<div class="js-sign-in-container">
						<form id="new_session" action="user/showuser.do" accept-charset="UTF-8" method="post">
							<div class="gary">
								<input placeholder="用户名" class="input-prepend_username " type="text" name="username" id="login_username">
							
							</div>
					
							<div >
								<input placeholder="密码" class="input-prepend_password" type="password" name="password" id="login_password">
							</div>
							<c:if test="${sessionScope.error!=null }">
								<div style="color:red"><c:out value="${sessionScope.error }"></c:out></div>
							</c:if>
							
				
							<div class="remember-btn">
								<input type="checkbox" value="true" checked="checked" name="session[remember_me]" id="session_remember_me">
								<span>记住我</span>
							</div>

							<input type="submit" name="commit" value="登录" class="sign-in-button" id="sign-in">
						</form>	
			</div>
					<div class="js-sign-up-container">
						<form class="new_user" id="new_user" action="user/register.do" accept-charset="UTF-8" method="post">
							<div class="input-prepend restyle">
								<input placeholder="你的昵称  最长15字符" style="text" name="username" id="register_username">
								<i class="glyphicon glyphicon-user"></i>
							</div>
							<div class="input-prepend">
								<input placeholder="设置密码  5至15字符" type="password" name="password" id="register_password">
								<i class="glyphicon glyphicon-lock"></i>
							</div>
							<input type="submit" name="commit" value="注册" class="sign-up-button" id="sign-up">
							<input type="hidden" id="hidden">
							<p class="sign-up-msg">点击注册表示您同意遵守易读的
								<br>
								用户协议和隐私政策</p>
						</form>
					</div>
					<div id="error" class="tooltip tooltip-error fade right in" style="top: 220px;left: 820.5px;display: none;">
						<div class="tooltip-arrow tooltip-arrow-border" style="top: 50%;"></div>
						<div class="tooltip-arrow tooltip-arrow-bg" style="top: 50%;"></div>
						<div class="tooltip-inner">
							<i class="glyphicon glyphicon-warning-sign"></i>
							<span id="error-span"></span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>
