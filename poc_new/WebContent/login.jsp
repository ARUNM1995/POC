<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${msg}
	<form action="login.do"  method="post">
		UserName:<input type="text" id="userName" name="userName">
		Password:<input type="text" id="password" name="password">
		<input type="submit" value="Login">
	</form>
	<a href="register.jsp">Register</a>
	<a href="forgot.jsp">Forgot Password</a>
</body>
</html>