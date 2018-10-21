<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
@import url("https://fonts.googleapis.com/css?family=Nanum+Myeongjo:400,700&amp;subset=korean");	
body{
	font-family: Nanum Myeongjo, serif;
}
#container {
	position: absolute;
	width: 80%;
	left: 50%;
	top: 50%;
	transform: translate(-50%,-50%);
	text-align: center;
	padding: 10px 10px 30px 10px;
}
#heading {
	font-size: 2em;
}
#seconds {
	color: rgb(255,100,100);
}
#go-to-main {
	position:relative;
	text-decoration: none;
	color: white;
	background: rgba(100,100,255,0.9);
	border-radius: 5px;
	padding: 10px;
}
</style>

<title>JW's Blog - Modifiy Complete</title>
</head>
<body>
	<div id="container">
		<h1 id="heading">${requestScope.message}<br><span id="seconds">5</span>초 후 메인페이지로 이동합니다.</h1>
		<a id="go-to-main" href="<%=request.getContextPath()%>/main">메인페이지로</a>
	</div>
</body>
<script type="text/javascript" defer="defer">
let mainBtn = document.getElementById("go-to-main");
let seconds = document.getElementById("seconds");
let time = 5;

mainBtn.addEventListener("mouseover",()=>{
	mainBtn.style.backgroundColor="rgba(50,50,255,1)";
	});
mainBtn.addEventListener("mouseout",()=>{
	mainBtn.style.backgroundColor="rgba(100,100,255,0.9)";
	});
	
let countInterval = setInterval(() => {
	seconds.innerHTML = --time;
	if(!time){
		seconds.innerHTML = "잠시후";
		window.location.replace("<%=request.getContextPath()%>/main");
		clearInterval(countInterval);
		return;
	}
	
}, 1000);
</script>
</html>