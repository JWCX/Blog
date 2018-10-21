<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error 404</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/error.css">
</head>
<body>
    <div class="error">Error 404... :(
        <div class="error2">
            <p>Page not found</p>
            <p>페이지를 찾을 수 없습니다.</p>

        </div>
        <div id="simulook"></div>
        <a href="javascript:history.go(-1)" class="button">돌아가기</a>
        <a href="<%=request.getContextPath()%>" class="button">홈으로</a>
    </div>
</body>
</html>