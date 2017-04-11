$(document).ready(function(){
	var converter = new showdown.Converter();
	var text = document.getElementById("wznr").value,  
		html = converter.makeHtml(text);  
	document.getElementById("art-content").innerHTML = html;
	$("#btn-send-com").click(function(){
		addcomment();
	});
});
function addcomment(){
	$.ajax({
		url:"comment/addcomment.do",
		type:"post",
		dataType:"json",
		data:{
			comtext:$("#writecomment").val()
		},
		success:function(data){
			alert("success!!!");
		}
	})
}