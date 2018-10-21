<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login 실패</title>
</head>
<body>
	<script>
		alert("정보가 올바르지 않습니다.");
		location.href = "<%=request.getContextPath()%>/login/login";
	</script>
</body>
</html>