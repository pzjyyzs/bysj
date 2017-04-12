<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>collection</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="icon" href="img/logo.ico"/>
	<link rel="stylesheet" href="css/newColllection.css">
	<link rel="stylesheet" href="css/index.css" />
	<link rel="stylesheet" href="css/normalize.css"/>
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<script type="text/javascript" src="js/jquery-3.1.1.min.js" ></script>
	<script type="text/javascript" src="js/ajaxfileupload.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/newCollection.js"></script>
  </head>
  
  <body>
		<jsp:include page="../header.jsp"/> 
		<div class="container new-collection">
			<div class="row">
				<div class="col-xs-9 col-xs-offset-3 main">
				<form action="collection/addcollection.do" method="post">
					<h3>新建专题</h3>
					<table>
						<thead>
							<tr>
								<th class="setting-head"></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<div class="avatar-collection">
										<img src="img/collimgempty.png" id="collimgshow">
									</div>
								</td>
								<td>
									<input type="file" id="reportFile" name="reportFile"/>
									<a class="btn btn-hollow" id="collimg" href="javascript:void(0)">
										上传专题封面
									</a>
								</td>
							</tr>
							
								<tr>
									<td class="setting-title">名称</td>
									<td>
										<input type="text" name="nick-name" id="nick-name" placeholder="填写名字 不超过50字" />
										<input type="hidden" name="nick-img" id="nick-img">
									</td>
								</tr>
								<tr>
									<td class="setting-title pull-left setting-input">描述</td>
									<td>
										<textarea placeholder="填写描述" id="nick-content" name="nick-content"></textarea>
									</td>
								</tr>
								<tr>
									<td>
										<div class="btn btn-success follow create">
											<input type="submit"/>
										</div>
									</td>
								</tr>
							</form>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>
