<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/style/post/dracula.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js"></script>
<link href="https://rawgit.com/amka/quill-focus/master/src/focus.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.9.0-alpha1/katex.min.css" 
integrity="sha384-8QOKbPtTFvh/lMY0qPVbXj9hDh+v8US0pD//FcoYFst2lCIf0BmT58+Heqj0IGyx" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.9.0-alpha1/katex.min.js" 
integrity="sha384-GR8SEkOO1rBN/jnOcQDFcFmwXAevSLx7/Io9Ps1rkxWp983ZIuUGfxivlF/5f5eJ" crossorigin="anonymous"></script>
<link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
<script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/post/post.css">
</head>
<body>
	<div class="container">
		<div id="regdate">${post.date}</div>
		<div id="hits">hits: ${post.viewCnt}</div>
		<div id="post-title">${post.title}</div>
	</div>
	<div class="container">
		<div id="editor"></div>
		<div id="content-menu">
			<div class="comment-icon" id="commentCnt">Comments : ${post.commentCnt }</div>
			<div class="comment-icon" id="evaluationCnt">Likes : ${post.evaluationCnt }</div>
			<div id="modify-remove">
				<c:if test="${requestScope.like eq 'true'}"><div id="like" onclick="window.location.replace('<%=request.getContextPath()%>/post/like_post?categoryId=${param.categoryId}&postId=${post.postId}')"></div></c:if>
				<c:if test="${requestScope.like != 'true'}"><div id="like" style="background-image: url(../image/icon/like/heart_240.png);" onclick="window.location.replace('<%=request.getContextPath()%>/post/like_post?categoryId=${param.categoryId}&postId=${post.postId}')"></div></c:if>
				<div id="modify"><a href="edit_post?postId=${post.postId}">edit</a></div>
				<div id="remove"><a href="remove_post?postId=${post.postId}&postNumber=${post.number}&categoryId=${param.categoryId}">remove</a></div>
			</div>
  		</div>
	</div>
	<div class="container">
		<c:forEach var="comment" items="${requestScope.commentList}">
			<div class="comment">
					<div class="nickname">
						${comment.writer} <span class="comment-date">등록일: ${comment.date}</span> 
						<span><input type="button" value="수정" class="button comment-modi-btn" onclick="commentModify(${param.categoryId},${comment.postId},${comment.commentId},'${comment.password}')"></span>
						<span><input type="button" value="삭제" class="button comment-delete-btn" onclick="commentDelete(${param.categoryId},${comment.postId},${comment.commentId},'${comment.password}')"></span>
					</div>
				<div class="comment-content"><c:choose>
				<c:when test="${comment.visible eq 0 || sessionScope.admin eq 'true'}">${comment.content}</c:when>
				<c:otherwise><span style="color:rgb(200,100,100)">비밀글입니다.</span></c:otherwise>
				</c:choose> </div>
			</div>
		</c:forEach>
		<form id="comment-write-box" action="<%=request.getContextPath()%>/comment/new_comment" method="post">
			<input type="hidden" name="postId" value="${requestScope.post.postId}">
			<input type="hidden" name="categoryId" value="${param.categoryId}">
			<div id="comment-info-outer">
				<div id="comment-info">
					<span id="comment-name">
						<label>Name&nbsp;</label>
						<input class="input-field key-listener" type="text" name="writer">
					</span>
					<span id="comment-pw">
						<label>Password&nbsp;</label>
						<input class="input-field key-listener" type="password" name="password">
					</span>
				</div>
				<div id="visible">
					<div id="visible-sub">
						<label for="check">비공개</label>
						<input type="checkbox" id="check" name="visible">
					</div>
					<input id="submit" type="submit" value="등록" disabled="disabled">
				</div>
			</div>
			<div id="textarea">
				<textarea class="key-listener" name="content"></textarea>
			</div>
		</form>
	</div>
</body>
<script>
	var content = ${requestScope.post.content};
</script>
<script src="<%=request.getContextPath()%>/script/post/post.js">
</script>
</html>