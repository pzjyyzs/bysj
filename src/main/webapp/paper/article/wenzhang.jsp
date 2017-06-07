<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'wenzhang.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="icon" href="img/logo.ico" />
		<link rel="stylesheet" href="css/normalize.css" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/wenzhang.css" />
		<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script src="js/showdown.min.js"></script>
		<script type="text/javascript" src="js/wenzhang.js"></script>
  </head>
<script type="text/JavaScript"> 
 </script>
  <body onscroll="doScroll()" onload="scrollback()">
 
		<!-- 	全局顶部导航-->
		<div><jsp:include page="/paper/header.jsp"/> </div>
		<div class="note">
			<div class="article">
				<div class="nierong-information">
					<h1 class="art-title"><c:out value="${sessionScope.article.articlename }"></c:out>  </h1>
					<!-- 作者区域 -->
					<div class="art-author">

						<a class="avatar" href="/u/5c83f83802db">
							<img src="img/icon1.png" alt="144">
						</a>
						<div class="info">
							<span class="tag">作者</span>
							<span class="name"><a href="user/showOtheruser.do?userid=${sessionScope.auser.uid}"><c:out value="${sessionScope.auser.username }"></c:out></a></span>
							<!-- 关注用户按钮 -->
							<!-- <a class="btn btn-success follow"><i class="iconfont ic-follow"></i>
							</a> -->
							<!-- 文章数据信息 -->
							<div class="meta">
								<!-- 如果文章更新时间大于发布时间，那么使用 tooltip 显示更新时间 -->
								<span class="publish-time" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="最后编辑于 2017.04.07 20:42">2017.04.07 20:26*</span>
					
								<span class="views-count">阅读 <c:out value="${sessionScope.article.articleread }"></c:out></span>
								<span class="comments-count">评论${comcount}</span>
								<span class="likes-count">喜欢 ${sessionScope.likecount}</span>
						</div>
						<!-- 如果是当前作者，加入编辑按钮 -->
					</div>
						<c:if test="${sessionScope.article.uid == sessionScope.user.uid }">
						<a href="article/updateArticle.do" target="_blank" class="edit">编辑文章</a>
						</c:if>
					</div>
				<input type="hidden" value="${sessionScope.article.articlecontent }" id="wznr"/>
				<div class="art-content" id="art-content"></div>
			</div>
			<div class="meta-bottom">
				<div class="like">
					<div class="btn like-group">
						<div class="btn-like">
							<span style="${sessionScope.str1}"><a href="like/addLike.do?articleaid=${sessionScope.article.aid}&useruid=${sessionScope.user.uid}">
								<i class="glyphicon glyphicon-heart">喜欢</i>
							</a>
							</span>
								<span style="${sessionScope.str2}"><a href="like/delLike.do?articleaid=${sessionScope.article.aid}&useruid=${sessionScope.user.uid}">
								<i class="glyphicon glyphicon-heart">取消喜欢</i>
							</a>
							</span>
							
						</div>
						<div class="modal-wrap">
							<a>
							${sessionScope.likecount}
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="pinglun">
				<div>
					<form class="new-comment">
						<textarea placeholder="写下你的评论" id="writecomment"></textarea>
						<a class="btn btn-send" id="btn-send-com">发送</a>
					</form>
				</div>
				<div id="comment-list" class="comment-list">
				<%
				int markid=1;
				 %>
				<c:forEach items="${sessionScope.comlist }" var="comment">
				<%
				String myreplycomform="myreplycomform"+markid;
				 %>
					<div class="comment">
						<div class="author">
							<a target="_blank" class="avatar">
								<img src="">
							</a>
							<div class="info">
							<c:set var="flag" value="0" />
							<c:forEach items="${sessionScope.usercomlist }" var="user">
							
							<c:if test="${flag==0}">
								<c:if test="${comment.comuserid == user.uid }">
									<a target="_blank" class="name">${user.username }</a>
									 <c:set var="flag" value="1"/>
								</c:if>	
							</c:if>
							</c:forEach>
								<div class="meta">
									<span>${comment.comtime }</span>
								</div>
							</div>
						</div>
						<div class="comment-wrap">
							<p>${comment.comtext }</p>
							<c:if test="${sessionScope.user.uid == comment.comuserid || sessionScope.article.uid == sessionScope.user.uid}">
							<a class="comment-delete" p="${comment.comid }">
								<span>删除</span>
							</a>
							</c:if>
							<c:forEach items="${sessionScope.comreplylist}" var="comreply">
							
							
								<c:if test="${comreply.comid == comment.comid }">
								<div class="sub-comment-list">
									<div class="sub-comment">
										<p>${comreply.replyuname}</p>
										<span>${comreply.replycotent}</span>
										<div class="sub-tool-group">
											<span>${comreply.replytime}</span>
										</div>
									</div>
								</div>
								
							</c:if>
							</c:forEach>

							<div class="tool-group">
								<a>
									<i class="glyphicon glyphicon-comment"></i>
			
									<span   onclick="aaaaa(this.title)"  title="<%=myreplycomform%>">回复</span>
		
									</a>
							
								<form  style="display:none"  class="<%=myreplycomform%>" action="comment/replycomment.do" method="post">
                                   
                                    <input class="commentcomid" name="commentcomid" type="hidden" value="${comment.comid}">
                 
									 <input name="useruid" type="hidden" value="${user.uid}">
									  <input name="articleid" type="hidden" value="${sessionScope.article.aid}">
				
                               <textarea  placeholder="写下你的评论" name='replycomment' cols="30" rows="4" class="repcom"></textarea>      
                                <input type="submit" class="btn btn-send"/>

                               </form>
								<% markid++; %>
								
							</div>
						</div>
					</div>
				 	
				 </c:forEach>
				</div>
			</div>
		</div>
		</div>
		<div class="include-collection">
			<div class="main">
				<div class="title">被以下专题收入</div>
				<div class="include-collection">
					<div class="modal-wrap add-collection-wrap">
						<a class="add-collection" href="javascript:void(null)" onclick="showModal()">
							<i class="glyphicon glyphicon-plus"></i>
							<div>我的专题</div>
						</a>
					</div>
					<c:forEach items="${sessionScope.articleCollection }" var='collection'>
					<a href="collection/showcollection.do?cid=${collection.cid }" target="_blank" class="item">
						<img src="${collection.collectionimg }">
						<div class="name">${collection.collectionname }</div>
					</a>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="modal animated add-self">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" onclick="closeModal()">x</button>
						<h4 class="modal-title">加入我的专题</h4>
					</div>
					<div class="modal-body">
						<ul>
						<c:forEach items="${sessionScope.userCollection }" var="collection">
							<li>
								<a href="" class="avatar-collection">
									<img src="${collection.collectionimg }">
								</a>
								<div class="collection-info">
									<a href="" class="collection-name">${collection.collectionname }</a>
									<div class="meta">${sessionScope.user.username } 编</div>
									<c:set var="flag" value="0" />
									<c:forEach items="${sessionScope.articleCollection }" var='c'>
									<c:if test="${collection.cid == c.cid }">
									<span class="status has-add">已收入</span>
									<a class="action-btn remove" p="${collection.cid }" c="${sessionScope.article.aid }">移除</a>
									<a class="action-btn push" id="push" p="${collection.cid }"  c="${sessionScope.article.aid }" style="display: none">收入</a>
									<c:set var="flag" value="1"/>
									</c:if>
									</c:forEach>
									<c:if test="${flag==0 }">
									<span class="status has-add"  style="display: none">已收入</span>
									<a class="action-btn remove" p="${collection.cid }" c="${sessionScope.article.aid }"  style="display: none">移除</a>
									<a class="action-btn push" id="push" p="${collection.cid }"  c="${sessionScope.article.aid }">收入</a>
									</c:if>
								</div>
							</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>
