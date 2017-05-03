$(document).ready(function(){
	$("#uploadp").click(function(){
		$("#kalamu-image-model").css("display","block");
	});
	$("#canelup").click(function(){
		$("#kalamu-image-model").css("display","none");
	});
	$("#addArticle").click(function(){
		var id=$("#mytSAid").val();
	
		addArticle(id);
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
	
	$(".new-note-link").click(function(){
	$.ajax({
			url:"json/savearticle.do",
			type:"get",
			async: true,
			dataType:'json',
			success:function(data){
				$(".ui-sortable").append("<li class='one-note active' id='xinjianwz"+data+"'><p class='abbreviate'></p><a href='javascript:void(0)' onclick='clickTitle("+data+")' class='note-list title'><span id='xiugaititle"+data+"'>无标题文</span></a><a href='javascript:void(0)' class='icon-note' onclick='Updatecotent("+data+")'><i class='glyphicon glyphicon-file'></i></a><a href='javascript:void(0)' onclick='DeleteCotent("+data+")' class='share-note dropdown-toggle'><i class='glyphicon glyphicon-trash'></i></a></li>");
				$(".span5").css('display','block'); 
			},
		
		
		});

	});
});
function addArticle(id){
	DeleteCotent(id);
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


function clickTitle(id){
	$.ajax({
		url:"json/showsavearticle.do",
		type:"get",
		async: true,
		dataType:'json',
		data:{
			id:id
		},
		success:function(data){
			$("#note_title").val(data.articlename);
			$("#note_content").val(data.articlecontent);
			$("#mytSAid").val(data.id);
		},
	});
}
function Updatecotent(id){
	$.ajax({
		url:"json/updatesavearticle.do",
		type:"post",
		dataType:'json',
		data:{
			id:id,
			note_title:$("#note_title").val(),
			note_content:$("#note_content").val(),
		},
		success:function(data){
			$("#xiugaititle"+data.id+"").html(data.articlename);
			$("#mytSAid").val(data.id);
		},
	});
}

function DeleteCotent(id){
	$.ajax({
		url:"json/DeletesaveArticle.do",
		type:"get",
		dataType:'json',
		data:{
			id:id
		},
		success:function(data){
			
			$("#xinjianwz"+data+"").remove();
			$("#note_title").val("");
			$("#note_content").val("");
			
			if($("ul").has("li").length>1){
			}else{
				$(".span5").css('display','none'); 
			}
			
			
		},
	});
}
