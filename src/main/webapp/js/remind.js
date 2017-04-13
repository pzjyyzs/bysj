function startRequest(){
	
	$.ajax({
		url:"json/FlushRemind.do",
		type:"get",
		async: false,
		dataType:'json',
		data:{ 
			"remindid":$("#remindid").val(),
			"remindx1":$("#remindx1").val(),
			},
		success:function(data){
				 $("#remindx1").val(data.remindx2);
				 
				 if(data.bool==true){
				alert("你有新消息");
				 }
		},
		error:function(){
			alert("错了");
		}
	});
	
}


$(document).ready(function () {	
	setInterval("startRequest()",1000);
	});




