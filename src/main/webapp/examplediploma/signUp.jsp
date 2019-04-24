<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p align="center">Sign Up</p>
<form action="${pageContext.request.contextPath}/signUpDiploma" method="POST">
	<table align="center">
		<tr>
			<td>Name</td>
			<td><input type="text" name="first_name"/></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="last_name"/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit Form"/></td>
			<td><input type="reset" value="Clear Form"/></td>
		</tr>
	</table>
</form>


</body>
</html>