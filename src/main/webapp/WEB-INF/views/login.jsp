<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div align="center" style="padding-top:10%">
		Login
	</div>
	<div align="center"  style="padding-top:20px">
		<form action="login" method="POST">
			<p><input type="text" name="userEmail" placeholder="Your email"/></p>
			<p><input type="password" name="userPassword" placeholder="Your password"/></p>
			<p><input type="submit" value="Send"/>
		</form>
	</div>

</body>
</html>