function startRequest(){ 
	$.ajax({
		url:"json/FlushRemind.do",
		type:"get",
		async: true,
		dataType:'json',
		data:{ 
			"remindid":$("#remindid").val(),
			},
		success:function(data){	 
			
				 jQuery.each(data, function(i,item){  
					 
					 if(!item.mark){ 
						 $("#Allxiaoxi").css("color","red");
						 $(".privateMail").css("color","red");
						 /*$(".readGuanzhu"+item.otherid).css("color","red");*/
						 var str="mail"+item.myid;
						 $("."+str).css("color","red");
						 }
		            });
		},
		/*error:function(){
			alert("错了");
		}*/
	});
	
	$.ajax({
		url:"json/GuanZhuRemind.do",
		type:"get",
		async: true,
		dataType:'json',
		data:{ 
			"remindid":$("#remindid").val(),
			},
		success:function(data){
			jQuery.each(data, function(i,item){
				if(!item.mark){
					 /*alert(".readGuanzhu"+item.otherid);*/
					 $("#Allxiaoxi").css("color","red");
					 $(".myguanzhu").css("color","red");
					 var str="guanzhu"+item.otherid;
					 $("."+str).css("color","red");
				};
			});
		},
	});

}

$(document).ready(function () {	
	setInterval("startRequest()",1000);
	});




