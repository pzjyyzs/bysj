$(document).ready(function(){
	$("#follow").click(function(){
		$.ajax({
			url:"collection/collect.do",
			type:"post",
			dataType:"json",
			success:function(data){
				$("#fosp")
			}
		})
	});
});