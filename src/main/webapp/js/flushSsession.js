function start(){
	$.ajax({
		url:"json/readmail.do",
		type:"get",
		async: true,
		/*dataType:'json',*/
		data:{ 
			"myuseruid":$("#myuseruid").val(),
			"otheruseruid":$("#otheruseruid").val(),
			},
	});
		
		/*error:function(){
			alert("错了");
		}*/
}
function s(){
	$.ajax({
		url:"json/readGuanzhu.do",
		type:"get",
		async: false,
		/*dataType:'json',*/
		data:{ 
			"myguanzhuId":$(".myguanzhuId").val(),
			"otherguanzhuId":$(".otherguanzhuId").val(),
			},
	     }
	)};

$(document).ready(function () {	
	s();
	start();
	});




