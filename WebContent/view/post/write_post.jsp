<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JW's Blog</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/style/post/dracula.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js"></script>
<link href="https://rawgit.com/amka/quill-focus/master/src/focus.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.9.0-alpha1/katex.min.css" 
integrity="sha384-8QOKbPtTFvh/lMY0qPVbXj9hDh+v8US0pD//FcoYFst2lCIf0BmT58+Heqj0IGyx" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.9.0-alpha1/katex.min.js" 
integrity="sha384-GR8SEkOO1rBN/jnOcQDFcFmwXAevSLx7/Io9Ps1rkxWp983ZIuUGfxivlF/5f5eJ" crossorigin="anonymous"></script>
<link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
<script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
<script src="<%=request.getContextPath()%>/script/post/post_image_resize.js"></script>
<script src="<%=request.getContextPath()%>/script/post/write_post.js" defer="defer"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/post/write_post.css">
</head>
<input type="hidden" id="context-path" value="<%=request.getContextPath()%>">
<body id="body">
	<div id="background"></div>
	<div id="container">
		<c:choose>
			<c:when test="${requestScope.post.postId != null}">${url="/blog/post/edit_post_process";""}</c:when>
			<c:otherwise>${url="/blog/post/new_post_process";""}</c:otherwise>
		</c:choose>
		<form id="form" action="${url}" method="post">
			<div id="editor-container">
				<div id="title-container">
					<c:if test="${requestScope.post.postId != null}">
						<input type="hidden" name="postId" value="${requestScope.post.postId }">
						<input id="title" type="text" name="title" value="${requestScope.post.title }">
					</c:if>
					<c:if test="${requestScope.post.postId eq null}">
						<input id="title" type="text" name="title" placeholder="제목을 입력하세요">
					</c:if>
				</div>
				<div id="category-container">
					<select id="category" name="categoryId">
						<c:if test="${requestScope.post.postId != null}">
							<option class="category-depth-2" selected="selected" value="${requestScope.post.categoryId}">${requestScope.categoryName}</option>
						</c:if>
						<c:if test="${requestScope.post.postId eq null}">
							<option selected hidden="">Select Category</option>
							<c:forEach var="category" items="${requestScope.categoryList }">
							<c:if test="${category.depth eq 1}"><option class="category-depth-1" disabled="disabled">${category.name}</option></c:if>
							<c:if test="${category.depth eq 2}"><option class="category-depth-2" value="${category.categoryId}">　-${category.name}</option></c:if>
							</c:forEach>
						</c:if>
					</select>
				</div>
				<div id="secret-container">
					<div id="secret">비공개
						<c:if test="${requestScope.post.secret != true }"><input id="secret-checkbox" type="checkbox" name="secret" value="1"></c:if>
						<c:if test="${requestScope.post.secret eq true }"><input id="secret-checkbox" type="checkbox" name="secret" value="1" checked="checked"></c:if>
					</div>
				</div>
				<div id="editor">
				</div>
			</div>
			<div id="btn-container">
				<button id="submit-btn" class="btns" type="submit" disabled="disabled">등록</button>
				<button id="cancel-btn" class="btns" type="button">취소</button>
			</div>
			<input id="content" type="hidden" name="content">
		</form>
	</div>
</body>
<script>
	var content = ${requestScope.post.content};
</script>
</html>
