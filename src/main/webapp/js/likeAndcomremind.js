function mystartRequest(){
	$.ajax({
		url:"json/LikeRemind.do",
		type:"get",
		async: true,
		dataType:'json',
		data:{ 
			"remindid":$("#remindid").val(),
			},
		success:function(data){
			jQuery.each(data, function(i,item){
				 var str="Like"+item.id;
				 $(".Gainlikediv").append("<span class="+str+">"+item.otherid+"喜欢了你的文章"+item.myid+"---"+item.creattime+"</span>");
				if(!item.mark){
					 /*alert(".readGuanzhu"+item.otherid);*/
					 $("#Allxiaoxi").css("color","red");
					 $(".myLike").css("color","red");
					 $("."+str).css("color","red");
					
				};
			});
		},
	});
	
	$.ajax({
		url:"json/CommentRemind.do",
		type:"get",
		async: true,
		dataType:'json',
		data:{ 
			"remindid":$("#remindid").val(),
			},
		success:function(data){
			jQuery.each(data, function(i,item){
				 var str="Com"+item.id;
				 $(".GainComdiv").append("<span onclik='readCom()' class="+str+">"+item.otherid+"评论了你的文章"+item.myid+"---"+item.creattime+"</span>");
				
				 
				 if(!item.mark){
					 /*alert(".readGuanzhu"+item.otherid);*/
					 $("#Allxiaoxi").css("color","red");
					 $(".myCom").css("color","red");
					 $("."+str).css("color","red");
				};
			});
		},
	});
}


$(document).ready(function () {
	mystartRequest();

});



