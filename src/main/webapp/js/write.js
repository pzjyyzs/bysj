$(document).ready(function(){
	$("#uploadp").click(function(){
		$("#kalamu-image-model").css("display","block");
	});
	$("#canelup").click(function(){
		$("#kalamu-image-model").css("display","none");
	});
	$("#addArticle").click(function(){
		addArticle();
	});
	$("#sctp").click(function(){
		ajaxFileUpload();
	});
	$("#send_success_dis").click(function(){
		$("#send_success").css("display","none");
	});
	$("#note_content").keyup(function(e){
		var converter = new showdown.Converter();
		var text = document.getElementById("note_content").value,  
    		html = converter.makeHtml(text);  
    	document.getElementById("result").innerHTML = html;
	});
});
function addArticle(){
	$.ajax({
		type:"post",
		url:"article/addarticle.do",
		dataType:"json",
		data:{
			note_title:$("#note_title").val(),
			note_content:$("#note_content").val(),
			aimgaddress:$("#aimgaddress").val()
		},
		success:function(data){
			$("#send_success").css("display","block");
		}
	});
}
function ajaxFileUpload(){
	$.ajaxFileUpload({
		type:'post',
		url:'article/editImage.do',
		fileElementId:'reportFile',
		dataType:'text',
		success:function(data,status){
			$("#kalamu-image-model").css("display","none");
			var str="![]("+data.substring(63,92)+")";
			var note_content=$("#note_content").val()+str;
			$("#note_content").val(note_content);
			
			var aimgaddress=$("#aimgaddress").val()+data.substring(63,92);
			$("#aimgaddress").val(aimgaddress.substring(0,29));
		},
		error:function(data){
			alert("失败");
		}
	});
}

