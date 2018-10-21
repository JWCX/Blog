<%@page import="dto.Post"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/category/category.css">
</head>
<body>
	<h1 class="headings">Recent Posts</h1>
	<div class="container">
		<div id="list">
		<div id="table-head">
			<span class="post-number" style="font-weight:bold;">#</span>
			<span class="post-title" style="font-weight:bold; text-align: center;">Title</span>
			<span class="post-page-views" style="font-weight:bold;">view</span>
			<span class="post-page-comments" style="font-weight:bold;">cmnt</span>
			<span class="post-page-likes" style="font-weight:bold;">like</span>
			<span class="post-date" style="font-weight:bold;">date</span>
		</div>
			<c:forEach var="post" items="${requestScope.recentList}">
				<div class="post" onclick="redirect(${post.categoryId},${post.postId})">
					<span class="post-number">${post.categoryId}-${post.number}</span>
					<span class="post-title">${post.title}</span>
					<span class="post-page-views">${post.viewCnt}</span>
					<span class="post-page-comments">${post.commentCnt}</span>
					<span class="post-page-likes">${post.evaluationCnt}</span>
					<span class="post-date"><fmt:formatDate value="${post.date}" type="DATE"/></span>
				</div>
			</c:forEach>
		</div>
	</div>
	<h1 class="headings">Popular Posts</h1>
	<div class="container">
		<div id="list">
		<div id="table-head">
			<span class="post-number" style="font-weight:bold;">#</span>
			<span class="post-title" style="font-weight:bold; text-align: center;">Title</span>
			<span class="post-page-views" style="font-weight:bold;">view</span>
			<span class="post-page-comments" style="font-weight:bold;">cmnt</span>
			<span class="post-page-likes" style="font-weight:bold;">like</span>
			<span class="post-date" style="font-weight:bold;">date</span>
		</div>
			<c:forEach var="post" items="${requestScope.popularList}">
				<div class="post" onclick="redirect(${post.categoryId},${post.postId})">
					<span class="post-number">${post.categoryId}-${post.number}</span>
					<span class="post-title">${post.title}</span>
					<span class="post-page-views">${post.viewCnt}</span>
					<span class="post-page-comments">${post.commentCnt}</span>
					<span class="post-page-likes">${post.evaluationCnt}</span>
					<span class="post-date"><fmt:formatDate value="${post.date}" type="DATE"/></span>
				</div>
			</c:forEach>
		</div>
	</div>
	<h1 class="headings">Most Liked Posts</h1>
	<div class="container">
		<div id="list">
		<div id="table-head">
			<span class="post-number" style="font-weight:bold;">#</span>
			<span class="post-title" style="font-weight:bold; text-align: center;">Title</span>
			<span class="post-page-views" style="font-weight:bold;">view</span>
			<span class="post-page-comments" style="font-weight:bold;">cmnt</span>
			<span class="post-page-likes" style="font-weight:bold;">like</span>
			<span class="post-date" style="font-weight:bold;">date</span>
		</div>
			<c:forEach var="post" items="${requestScope.likedList}">
				<div class="post" onclick="redirect(${post.categoryId},${post.postId})">
					<span class="post-number">${post.number}</span>
					<span class="post-title">${post.title}</span>
					<span class="post-page-views">${post.viewCnt}</span>
					<span class="post-page-comments">${post.commentCnt}</span>
					<span class="post-page-likes">${post.evaluationCnt}</span>
					<span class="post-date"><fmt:formatDate value="${post.date}" type="DATE"/></span>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
<script>
function redirect(categoryId, postId){
	window.location.replace("<%=request.getContextPath()%>/post/post?categoryId="+categoryId+"&postId="+postId);
}
$post = document.getElementsByClassName("post");

for(let i=0; i<$post.length; i++){
	let mouseOverInterval, mouseOutInterval;
	let cnt = 0;
	$post[i].addEventListener("mouseover", () => {
		clearInterval(mouseOutInterval);
		mouseOverInterval = setInterval(() => {
			cnt++;
			$post[i].style.backgroundColor = "rgba(255,255,255,"+cnt/100+")";
			if(cnt>=70) 
				clearInterval(mouseOverInterval);
			}, 2);
	});
	$post[i].addEventListener("mouseout", () => {
		clearInterval(mouseOverInterval);
		mouseOutInterval = setInterval(() => {
			cnt--;
			$post[i].style.backgroundColor = "rgba(255,255,255,"+cnt/100+")";
			if(cnt<=0) 
				clearInterval(mouseOutInterval);
		}, 5);
	});
}
</script>
</html>