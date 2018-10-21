<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JW's Blog - Modify Categories</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/category/modify.css">
<link href="https://fonts.googleapis.com/css?family=Nanum+Myeongjo:400,700&amp;subset=korean" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/script/category/modify.js" defer="defer"></script>
	<style></style>
</head>
<body>
	<form action="<%=request.getContextPath()%>/category/modify_process" method="post">
	<div id="category-modify-container">
		<div id="category-modify-field">
			<c:forEach var="category" items="${requestScope.categoryList }">
			<%-- DEPTH별 카테고리 속성부여는 JS로 해야 하나? 최대 DEPTH를 구하기위해.. css로는 불가능할듯 --%>
				<div id="category-row-${category.categoryId}" class="category-depth-${category.depth}">	
					<input type="hidden" id="category-groupId-${category.categoryId}" class="category-groupId" name="${category.categoryId}" value="${category.groupId}">
					<input type="hidden" id="category-depth-${category.categoryId}" name="${category.categoryId}" value="${category.depth}">
					<input type="hidden" id="category-order-${category.categoryId}" name="${category.categoryId}" value="${category.order}">
					<input type="hidden" id="category-type-${category.categoryId}" name="${category.categoryId}" value="${category.type}">
					<input type="hidden" id="category-name-${category.categoryId}" name="${category.categoryId}" value="${category.name}">
					
					<c:if test="${category.type eq 0}"><label>블로그</label></c:if>
					<c:if test="${category.type eq 1}"><label>갤러리</label></c:if>
					<input type="text" id="category-text-${category.categoryId}" class="categories" value="${category.name}" disabled="disabled">
					<input type="button" id="category-modi-btn-${category.categoryId}" value="수정" onclick="modiBtnClick(${category.categoryId});">
					<input type="button" id="category-delete-btn-${category.categoryId}" class="category-delete-btn" value="삭제" onclick="deleteBtnClick(${category.categoryId});">
					<c:if test="${category.depth eq 1}"><input type="button" id="category-insert-btn-${category.categoryId}" class="category-insert-btn" value="+" onclick="insertBtnClick(${category.categoryId});"></c:if>
				</div>
			</c:forEach>
		</div>
			<input type="button" id="category-insert-btn-0" class="category-insert-btn" value="+" onclick="insertBtnClick(0);">
			<input id="submit-btn" type="submit" value="확인">
			<input type="button" value="취소" onclick="history.go(-1);">
	</div>
	</form>
</body>
</html>
