<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JW's Blog</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/main.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/script/main.js" defer="defer"></script>
</head>
<body>
	<div id="main-page-container">
		<div id="main-page-background"></div>
		<header id="home-button-container">
			<a id="home-button" href="<%=request.getContextPath()%>">__&nbsp;&nbsp;JW's Blog&nbsp;&nbsp;________________________________________________________________________________________________</a>
		</header>
		<div id="container">
			<section id="category-outer-container">
				<nav id="category-container">
					<c:choose>
						<c:when test="${sessionScope.admin eq 'true' }"><div id="menu-image-admin"></div></c:when>
						<c:otherwise><div id="menu-image"></div></c:otherwise>
					</c:choose>
					<input type="hidden" id="selected-category-id" value="${requestScope.categoryId}">
					<c:forEach var="category" items="${requestScope.categoryList}">
						<a id="${category.categoryId}" class="categories category-depth-${category.depth}" 
						href="<%=request.getContextPath()%>/category/category?categoryId=${category.categoryId}">${category.name}</a>
					</c:forEach>
					<c:if test="${sessionScope.admin eq 'true' }">
						<a id="category-modify-button" class="buttons" href="<%=request.getContextPath()%>/category/modify"><span id="category-modify-image"></span></a>
						<a id="new-post-button" class="buttons" href="<%=request.getContextPath()%>/post/new_post"><span id="new-post-image"></span></a>
					</c:if>
				</nav>
				<div id="visit-counter-container">
					<span id="visitors">visitors</span>
					<span id="visit-counter-today">TODAY : <span style="color:rgba(255,50,50,0.9)">${requestScope.visitCntToday}</span></span>
					<span id="visit-counter-total">TOTAL : ${requestScope.visitCntTotal}</span>
				</div>
				<div id="social-container-2">
					<div id="inner-social-container-2">
						<c:forEach begin="0" end="4">
						<a class="social-buttons-2"><img class="social-icons-2"></a></c:forEach>
						<script type="text/javascript">
						let srcSocialMedia2 = [{"id" : "email", "src" : "<%=request.getContextPath()%>/image/icon/social/email_240.png", "url" : "mailto:jw.chox@gmail.com"},
											  {"id" : "github", "src" : "<%=request.getContextPath()%>/image/icon/social/github_240.png", "url" : "https://github.com/JWCX"},
											  {"id" : "kakao", "src" : "<%=request.getContextPath()%>/image/icon/social/kakao_240.png", "url" : "https://open.kakao.com/o/sUtmjtO"},
											  {"id" : "instagram", "src" : "<%=request.getContextPath()%>/image/icon/social/instagram_240.png", "url" : "https://www.instagram.com/b4mv"},
											  {"id" : "soundcloud", "src" : "<%=request.getContextPath()%>/image/icon/social/soundcloud_240.png", "url" : "https://soundcloud.com/jung-woo-cho-3"}];
						</script>
					</div>
				</div>
			</section>
			<section id="article-outer-container">
				<div id="article-container">
				<c:if test="${requestScope.popularList != null }"><jsp:include page="${'/view/popular_list.jsp'}"></jsp:include></c:if>
					<jsp:include page="${pagePath}"></jsp:include>
				</div>
			</section>
		</div>
		<%@ include file="footer.jsp" %>
	</div>
</body>
</html>