<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateColl.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <jsp:include page="../header.jsp"/>
    <div class="container new-collection">
			<div class="row">
				<div class="col-xs-9 col-xs-offset-3 main">
				<form action="collection/updatecollection.do" method="post">
					<h3>编辑专题</h3>
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
										<img src="img/${sessionScope.collection.collectionimg }" id="collimgshow">
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
										<input type="text" name="nick-name" id="nick-name" placeholder="填写名字 不超过50字" value="${sessionScope.collection.collectionname }" />
										<input type="hidden" name="nick-img" id="nick-img" value="img/${sessionScope.collection.collectionimg }">
									</td>
								</tr>
								<tr>
									<td class="setting-title pull-left setting-input">描述</td>
									<td>
										<textarea placeholder="填写描述" id="nick-content" name="nick-content">
										${sessionScope.collection.collectionintroduce }
										</textarea>
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
