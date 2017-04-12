$(document).ready(function(){
	$("#collimg").click(function(){
			ajaxFileUpload();
	});
});
function ajaxFileUpload(){
	$.ajaxFileUpload({
		type:'post',
		url:'collection/collectionImage.do',
		fileElementId:'reportFile',
		dataType:'text',
		success:function(data,status){
			var str=data.substring(63,95);
			$("#collimgshow").attr("src",str);
			$("#nick-img").val(str);
		},
		error:function(data){
			alert("失败");
		}
	});
}