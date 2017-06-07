$(document).ready(function() {
		var converter = new showdown.Converter();
		var text = document.getElementById("wznr").value, html = converter
				.makeHtml(text);
		document.getElementById("art-content").innerHTML = html;
		$("#btn-send-com").click(function() {
			addcomment();
		});
		$(".comment-delete").click(function(e){
			$.ajax({
				url:"comment/delcomment.do",
				type:"post",
				dataType:"json",
				data:{
					comid:$(this).attr('p')
				},
				success:function(){
					location.reload();
				}
			})
		});
		$(".push").click(function(e){
			var that=this;
			$.ajax({
				url:"collection/colladdartic.do",
				type:"post",
				dataType:"json",
				data:{
					cid:$(this).attr('p'),
					aid:$(this).attr('c')
				},
				success:function(){
					$(that).css("display","none");
					$(that).prev().css("display","block");
					$(that).prev().prev().css("display","inline");
				}
			});
		});
		$(".remove").click(function(e){
			var that=this;
			$.ajax({
				url:"collection/colldelartic.do",
				type:"post",
				dataType:"json",
				data:{
					cid:$(this).attr('p'),
					aid:$(this).attr('c')
				},
				success:function(){
					$(that).css("display","none");
					$(that).prev().css("display","none");
					$(that).next().css("display","block");
				}
			});
					
		});
		$("#qvxiao").click(function(){
			
		})
});

function addcomment() {
	$.ajax({
		url : "comment/addcomment.do",
		type : "post",
		dataType : "json",
		data : {
			comtext : $("#writecomment").val()
		},
		success : function(data) {
			location.reload();
		},
		error : function() {
			alert("error");
		}
	});
}

function aaaaa(data) {
	var aid = $("." + data + "");

	if (aid.css("display") == "none") {
		aid.css("display", "block");
	} else {
		aid.css("display", "none");
	}
}
function showModal(){
	$(".modal").css("display","block");
}
function closeModal(){
	$(".modal").css("display","none");
}