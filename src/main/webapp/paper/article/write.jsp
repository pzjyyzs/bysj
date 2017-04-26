<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>写文章-易读</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/write.css" />
	<link rel="stylesheet" href="css/normalize.css"/>
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/ajaxfileupload.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/write.js"></script>
	<script src="js/showdown.min.js"></script>
  </head>
  
  <body>
		<div id="write" class="container-fluid">
			<div class="stack expansion">
				<div class="row-fluid normal-mode active">
					<div class="span2 aside">
						<div class="home-wrap">
							<a href="paper/index.jsp" class="go-home">
								<i class="glyphicon glyglyphicon-home"></i>
								<span>回首页</span>
							</a>
						</div>
						<div id="notes-list">
							<div id="new-note">
								<a href="javascript:void(0)" class="new-note-link">
									<i class="glyphicon glyphicon-plus"></i>
									<span class="win-text">新建文章</span>
								</a>
							</div>
							<ul class="nav nav-list notes ui-sortable">
								<li class="one-note active">
									<p class="abbreviate"></p>
									<a href="javascript:void(0)" class="note-list title">无标题文章</a>
									<a href="javascript:void(0)" class="icon-note">
										<i class="glyphicon glyphicon-file"></i>
									</a>
									<a href="javascript:void(0)" class="share-note dropdown-toggle">
										<i class="glyphicon glyphicon-trash"></i>
									</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="span5 main">
						<form class="note-form markdown">
							<input class="title mousetrap" name="note_name" id="note_title" value="无标题文章"/>
							<ul class="toolbar clearfix">
								<li>
									<a href="javascript:void(null)" title="图片" id="uploadp">
										<i class="glyphicon glyphicon-picture"></i>
									</a>
								</li>
								<li class="pull-right publish-button-item">
									<a href="javascript:void(null)" id="addArticle">
										<i class="glyphicon glyphicon-share-alt"></i>
										发布文章
									</a>
								</li>
								<li class="pull-right">
									<a href="javascript:void(null)" title="保存草稿">
										<i class="glyphicon glyphicon-floppy-disk"></i>
									</a>
								</li>
							</ul>
							<textarea class="text mousetrap" name="note_content" id="note_content"></textarea>
							<input type="hidden" id="aimgaddress"/>
							<div id="kalamu-image-model" class="kalamu-image-modal">
								<div class="modal-header">
									<h3>插入图片</h3>
								</div>
								<div class="modal-body">
									<div class="tab-content">
										<input type="file" id="reportFile" class="ipload-picture" name="reportFile"/>
										<input type="button" value="上传图片" id="sctp" />
									</div>
								</div>
								<button class="btn-link" id="canelup">取消</button>
							</div>
							<div id="send_success" class="kalamu-image-modal" style="display: none;">
								<a class="btn-link" id="send_success_dis" href="javascript:void(null)">X</a>
								<div class="modal-header">
									<h3>发表成功</h3>
								</div>
							</div>
						</form>
					</div>
					<div class="span5 preview">
						<h1 class="title mousetrap"></h1>
						<div class="content mousetrap" id="result"></div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
