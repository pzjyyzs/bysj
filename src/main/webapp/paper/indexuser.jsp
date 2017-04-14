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
function UpdateHtml(){
    //获取页面的高度和宽度
    var sWidth=document.body.scrollWidth || document.documentElement.scrollWidth;
    var sHeight=document.body.scrollHeight || document.documentElement.scrollHeight;
    
    //获取页面的可视区域高度和宽度
    var wHeight=document.documentElement.clientHeight || document.body.clientHeight;
    
                //创建遮罩层
    var oMask=document.createElement("div");
    oMask.id="mask";
    oMask.style.height=sHeight+"px";
    oMask.style.width=sWidth+"px";
    document.body.appendChild(oMask);            //添加到body末尾
      
               //创建登录框
    var oLogin=document.createElement("div");
    oLogin.id="login";
    oLogin.innerHTML=
    "<div class='loginCon'><div id='close'>点击关闭</div><form id='UpdateForm' action='user/updateMyUser.do' accept-charset='UTF-8' method='post' ><textarea rows='16' cols='50' name='myintr'>${user.userintroduce}</textarea></br><input type='submit'  vlaue='提交' /></form></div>";
    
    document.body.appendChild(oLogin);
    
    //获取登陆框的宽和高
    var dHeight=oLogin.offsetHeight;
    var dWidth=oLogin.offsetWidth;

    //设置登陆框的left和top
    oLogin.style.left=sWidth/2-dWidth/2+"px";
    oLogin.style.top=wHeight/2-dHeight/2+"px";

    //获取关闭按钮
    var oClose=document.getElementById("close");
    
    //点击关闭按钮和点击登陆框以外的区域都可以关闭登陆框
    oClose.onclick=function(){
        document.body.removeChild(oLogin);
        document.body.removeChild(oMask);
    };
}
                    


  </script>

  </head>
  
  <body>
  <jsp:include page="header.jsp"/> 
    姓名：${user.username}<br>
    性别：${user.sex}<br>
    关注：${myfriend}<br>
    粉丝：${myfans}<br>
   头像：	<div class="">
   	 <img src=" ${user.img }">
		<a href="user/">更改头像</a>
			</div>
			<br>
    自我介绍：${user.userintroduce}<br>
编辑自我介绍：<input type="button" class='update' vlaue="编辑" onclick="UpdateHtml()"/><br>			
  </body>

</html>
