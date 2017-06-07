<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>后台管理</title>
<jsp:include page="../background/shared/manager_headtitle.jsp"></jsp:include>
<body>
	<jsp:include page="../background/shared/manager_head.jsp"></jsp:include>
	<div class="manager_main">
		<div class="content">
			<div class="leftbox">
				<!-- Begin of  #contentlist -->
				<div id="pageIntro">
					<h2>欢迎进入后台管理页面</h2>
					<p>
						您可以在这里删除文章、评论等内容。<br /> <br />
						
					</p>
				</div>

			</div>
			<jsp:include page="../background/shared/manager_siderbar.jsp"></jsp:include>		</div>
	</div>
	<jsp:include page="../background/shared/manager_footer.jsp"></jsp:include>
</body>
</html>
