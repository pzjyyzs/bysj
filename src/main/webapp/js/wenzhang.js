$(document).ready(function(){
	var converter = new showdown.Converter();
	var text = document.getElementById("wznr").value,  
		html = converter.makeHtml(text);  
	document.getElementById("art-content").innerHTML = html;
});