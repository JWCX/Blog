<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Login</title>
</head>
<style>
#title {
	position: relative;
	font-size: 30px;
	font-weight: bold;
	top: 150px;
	left: 45%;
}

.login {
	position: relative;
	top: 40px;
	right: 50px;
	font-size: 20px;
	font-weight: 100;
}

.button {
	position: absolute;
	top: 180px;
	left: 70px;
	border: 2px solid;
	font-size: 20px;
	padding: 5px;
	text-align: center;
	border-radius: 3px;
}

.button:hover {
	background-color: dimgray;
	transition: all 1.5s;
}

a {
	text-decoration: none;
	color: black;
}
</style>
<body>
	<form action="<%=request.getContextPath()%>/login/login_process" method="post">

		<div id='title'>
			Admin Login
			<table>
				<tr>
					<th class='login'>ID</th>
					<td class='login'><input type="text" name="id"></td>
				</tr>
				<tr>
					<th class='login'>password</th>
					<td class='login'><input type="password" name='password'></td>

				</tr>
			</table>
			<input type="submit" value="로그인" class="button">
		</div>
	</form>
</body>
</html>