<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="update.do" method="post">
		<pre>
			UserName:<input readonly="readonly" type="text" id="userName" name="userName" value="${dto.userName}">
			Password:<input type="text" id="password" name="password" value="${dto.password}">
			MobileNumber:<input type="text" id="mobileNumber" name="mobileNumber" value="${dto.mobileNumber}">
			Country:<input type="text" id="country" name="country" value="${dto.country}"> <input
				type="submit" value="Update">
		</pre>
	</form>
</body>
</html>