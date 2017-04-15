function startRequest(){
	$.ajax({
		url:"json/flushSession.do",
		type:"get",
		async: true,
		dataType:'json',
		data:{ 
			"userid":$("#userid").val()
			},
		success:function(data){
			$("#myDiv").html("");
			jQuery.each(data, function(i,item){    
				if(item.userid==item.sendid){
					 $("#myDiv").append($("<div>"+item.username+"</div>"));
				}
				else{
					 $("#myDiv").append($("<div>"+$("#ChatObject").val()+"</div>"));
				}
				 $("#myDiv").append($("<div>"+item.cotent+"</div>"));
				 $("#myDiv").append($("<div>"+item.creattime+"</div>"));
            });  
		},
	
	});
}

$(document).ready(function () {
	setInterval("startRequest()",100);
	});
	