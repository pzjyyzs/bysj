$(document).ready(function(){
	
	$("#js-sign-up-btn").click(function(){
		$("#js-sign-in-btn").removeClass("active");
		$("#js-sign-up-btn").attr("class","active");
		$(".js-sign-in-container").hide();
		$(".js-sign-up-container").css("display","block");
	});
	$("#js-sign-in-btn").click(function(){
		$("#js-sign-up-btn").removeClass("active");
		$("#js-sign-in-btn").attr("class","active");
		$(".js-sign-up-container").hide();
		$(".js-sign-in-container").css("display","block");
	});
	$("#sign-in").click(function(){
		if(checkLoginUsrname() && checkLloginPassword()){		
			return true;
		}
		return false;
		
	});
	$("#sign-up").click(function(){
		var hidden=$("#hidden").val();
		if(checkRegisterUsername() && checkRegisterPassword()){
			if(hidden==0){
				return true;
			}
		}
		return false;
	});
	$("#login_username").blur(function(){
		if(checkLoginUsrname()){
			$("#error").css("display","none");
			return true;
		}
		return false;
	});
	$("#login_password").blur(function(){
		if(checkLloginPassword()){
			$("#error").css("display","none");
			return true;
		}
		return false;
	});
	$("#register_username").blur(function(){
		if(checkRegisterUsername()){
			$("#error").css("display","none");
			findRegisterUsername();
		}
	});
	$("#register_password").blur(function(){
		if(checkRegisterPassword()){
			$("#error").css("display","none");
			return true;
		}
		return false;
	});
});
	
function checkLoginUsrname(){
	var login_username=$("#login_username").val();
	if(login_username==""){
			$("#error-span").text("用户名不为空");
			$("#error").css({"top":"220px","display":"block"});
			return false;
		}
	return true;
}
function checkLloginPassword(){
	var login_password=$("#login_password").val();
	if(login_password==""){
			$("#error-span").text("密码不为空");
			$("#error").css({"top":"270px","display":"block"});
			return false;
		}
	return true;
}
function checkRegisterUsername(){
	var register_username=$("#register_username").val();
	if(register_username==""){
			$("#error-span").text("昵称不为空");
			$("#error").css({"top":"220px","left":"815px","display":"block"});
			return false;
		}else if(register_username.length>15){
			$("#error-span").text("字符过长，不能超过15个字符");
			$("#error").css({"top":"220px","left":"815px","display":"block"});
			return false;
		}
	return true;
}
function checkRegisterPassword(){
	var register_password=$("#register_password").val();
	if(register_password==""){
			$("#error-span").text("昵称不为空");
			$("#error").css({"top":"288px","left":"815px","display":"block"});
			return false;
		}else if(register_password.length>15 || register_password.length<5){
			$("#error-span").text("密码在5到15个字符之间");
			$("#error").css({"top":"288px","left":"815px","display":"block"});
			return false;
		}
	return true;
}
function findRegisterUsername(){
	$.ajax({
		url:"user/findRegister.do",
		type:"post",
		dataType:"json",
		data:{
			registerUsername:$("#register_username").val()
		},
		success:function(data){
			if(data.boo==false){
			$("#error-span").text(data.message);
			$("#error").css({"top":"220px","left":"815px","display":"block"});
			$("#hidden").val("1");
			}else{
				$("#error").css("display","none");
				$("#hidden").val("0");
			}
		},
		error:function(){
			alert("错了");
		}
	});
}
