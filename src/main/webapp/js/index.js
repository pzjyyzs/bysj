$(document).ready(function(){
	var stop =true;
	if($("#zs").val()==1){
		stop=false;
	}
	
	$(window).scroll( function(event){
		if(stop){
			var range = 50;             //距下边界长度/单位px  
			var elemt = 500;           //插入元素高度/单位px   
			var num = 1;  
			var totalheight = 0;   
			var srollPos = $(window).scrollTop();
			totalheight = parseFloat($(window).height()) + parseFloat(srollPos);
			if(($(document).height()-range) <= totalheight ){
				$.ajax({
					url:"user/xljz.do",
					type:"post",
					dataType:"json",
					data:{
						zs:$("#zs").val()-1
					},
					success:function(data){
						location.reload();
					}
				})
			}
		}
	})
	$("#newarc").click(function(){
		$("#newarc").css("display","none");
		location.reload();
	});
	window.setInterval(cheArtcle, 3000);
});
function cheArtcle(){
	$.ajax({
		url:"user/ts.do",
		type:"post",
		dataType:"json",
		success:function(data){
			if(data.temp==true){
				$("#newarc").animate({
					height:'toggle'
				});
			}
		}
	})
}