<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JW's Blog</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/home.css">
<script
  src="https://code.jquery.com/jquery-3.3.1.js"							<%-- Scroll Down Button uses Jquery --%>
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
<script type="text/javascript" defer="defer" src="<%=request.getContextPath()%>/script/home.js"></script>
</head>
<body>
	<div id="first-page-container">
		<div class="first-page-backgrounds"></div>
		<div class="first-page-backgrounds"></div>
		<span id="first-page-heading"></span>
		
		<div id="scroll-down-button">
		<c:forEach begin="0" end="2">
			<img class="arrows" src="<%=request.getContextPath()%>/image/icon/arrows/arrow_down_240.png"></c:forEach>
		</div>
		<div id="social-container">
		<c:forEach begin="0" end="4">
			<a class="social-buttons"><img class="social-icons"></a></c:forEach>
		</div>
		
	</div>
	<%@ include file="main.jsp" %>	
</body>
</html>

