<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 引入自定义分页标签 -->
<%-- <%@ taglib prefix="page" uri="/mvcPager"%> --%>
<!-- 引入标准标签 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>评论管理</title>
<jsp:include page="../background/shared/manager_headtitle.jsp"></jsp:include>
<link href="<%=basePath%>css/manager/bootstrap/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="../background/shared/manager_head.jsp"></jsp:include>
	<div class="manager_main">
		<div class="article">
			<div class="leftbox">
				<!-- Begin of  #articlelist -->
				<div class="articleBox">
					<div class="articleBoxTop">
						<h3>评论列表</h3>
					</div>
					<div class="innerContent">
						<table class="sTable">
							<tr>
								<th><input type="checkbox" value="全选" onclick="ChooseAll()" />
								</th>
								<th>评论内容</th>
								<th>发布时间</th>
								<th>作者</th>
							</tr>
							<c:forEach items="${list}" var="item">
								<tr class="oddRow">
									<td class="check_list"><input type="checkbox" id="list"
										name="list" /></td>
									<td class="list_title"><a
										href="<%=basePath%>announce/details/${item.announce_Id}"
										title="${item.announce_Title}">${item.announce_Title}</a></td>
									<td class="list_time">${item.writeTime}</td>
									<td>${item.manager_name}</td>
									<td class="editItem">
										<ul class="editlist">
											<li class="iconEdit"><a href="<%=basePath%>announce/update/${item.announce_Id}">编辑</a></li>
											<li class="iconDel"><a onclick="return confirm('您确认要删除当前数据吗？')" href="<%=basePath%>announce/delData/${item.announce_Id}">删除</a></li>
										</ul>
									</td>
								</tr>
							</c:forEach>
						</table>
					<%-- 	<!-- 分页开始 -->
						<form method="post" id="searchForm" action="<%=path%>/announce/manager">
							<input type="hidden" name="searchInfo" value="${searchInfo}">
						</form> --%>
						<%-- <page:createPager pageSize="${pageSize}" totalPage="${totalPage}" --%>
						<%-- 	totalCount="${totalCount}" curPage="${pageNum}"
							formId="searchForm" /> --%>
                        <!-- 分页结束 -->
						<!-- End of  #contentlist -->
					</div>
				</div>

				<!-- End of  #articlelist -->

			</div>
			<jsp:include page="../background/shared/manager_siderbar.jsp"></jsp:include>
		</div>
	</div>
	<jsp:include page="../background/shared/manager_footer.jsp"></jsp:include>
</body>
</html>
