function startRequest(){
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
		
		/*error:function(){
			alert("错了");
		}*/
}


$(document).ready(function () {	
	setInterval("startRequest()",1000);
	});




