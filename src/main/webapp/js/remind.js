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
						 $(".xiaoxi").html("你有新消息");
						 }
		            });
		},
		/*error:function(){
			alert("错了");
		}*/
	});
	
}


$(document).ready(function () {	
	setInterval("startRequest()",1000);
	
	$(".readxiaoxi").click(function(){
	
		$.ajax({
			url:"json/readmail.do",
			type:"get",
			async: true,
			/*dataType:'json',*/
			data:{ 
				"useruid":$("#useruid").val(),
				"userlistuid":$("#userlistuid").val(),
				},
			success:function(){
				
			},
		});
	  });
	
	});




