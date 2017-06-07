$(document).ready(function(){
	$("#uploadp").click(function(){
		$("#kalamu-image-model").css("display","block");
	});
	$("#canelup").click(function(){
		$("#kalamu-image-model").css("display","none");
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
	$("#note_title").keyup(function(e){
		var converter = new showdown.Converter();
		var text = document.getElementById("note_title").value,  
		html = converter.makeHtml(text);  
		document.getElementById("tit_result").innerHTML = html;
	});
	$("#dArticle").click(function(e){
		$("#noty_bar").css("display","block");
	});
	$("#noty_cannel").click(function(e){
		$("#noty_bar").css("display","none");
	});
	$("#noty_sure").click(function(e){
		delArticle();
	});
	$("#addArticle").click(function(e){
		updArticle();
	});
})
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
function delArticle(){
	$.ajax({
		url:"article/delArticle.do",
		type:"post",
		dataType:'json',
		data:{
			aid:$("#aid").val()
		},
		success:function(data){
			$("#notes-list").css("display","none");
			$(".main").css("display","none");
			$(".preview").css("display","none");
			$("#noty_bar").css("display","none");
		}
	})
}
function updArticle(){
	$.ajax({
		url:"article/updArticle.do",
		type:"post",
		dataType:'json',
		data:{
			aid:$("#aid").val(),
			articlename:$("#note_title").val(),
			articlecontent:$("#note_content").val(),
			aimgaddress:$("#aimgaddress").val()
		},
		success:function(data){
			$("#send_success").css("display","block");
			var a = document.getElementById('update_a');
			a.innerText = $("#note_title").val();
		}
	})
}