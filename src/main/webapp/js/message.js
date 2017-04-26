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
					/* $("#myDiv").append($("<div>"+$("#Chatme").val()+"</div>"));*/
					 
					 $("#myDiv").append ("<li class='message-l'><a class='avatar'><img src="+$("#Chatme").val()+"></a> <div><span class='content'>"+item.cotent+"</span></div><span class='time'>"+item.creattime+"</span> </li>");
				
				}
					 
				else{
					 /*$("#myDiv").append($("<div>"+$("#ChatObject").val()+"</div>"));*/
					 $("#myDiv").append ("<li class='message-r'><a class='avatar'><img src="+$("#ChatObject").val()+"></a> <div class='wdcontent'><span class='content'>"+item.cotent+"</span></div><span class='time'>"+item.creattime+"</span> </li>");
						
				
				}
				 /*$("#myDiv").append($("<div>"+item.cotent+"</div>"));
				 $("#myDiv").append($("<div>"+item.creattime+"</div>"));*/
            });  
		},
	
	});
}

$(document).ready(function () {

	setInterval("startRequest()",100);

});