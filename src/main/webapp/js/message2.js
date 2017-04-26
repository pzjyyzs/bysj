

$(document).ready(function () {
		$(".submitsend").bind("click",function(){
	         if($.trim($(myMessage).val())==""){
				alert("内容不能为空");
			}else{
			$.ajax({
				url:"mail/writeMail.do",
				type:"post",
				async: true,
				/*dataType:'json',*/
				data:{ 
					"MyUserid":$("#myuseruid").val(),
					"OtherUserid":$("#otheruseruid").val(),
					"myMessage":$("#myMessage").val()
					},
				success:function(data){

				},
				error:function(){
					alert("错了");
					}
			
			});}

});


});