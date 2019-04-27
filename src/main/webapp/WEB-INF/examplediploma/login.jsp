<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Login Page</title>
</head>
<body>
<p align="center">Login</p>
<form action="${pageContext.request.contextPath}/loginDiploma" method="POST">
	<table align="center">
		<tr>
			<td>Email</td>
			<td><input type="email" name="email"/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<c:if test="${not empty errorMsg}">
			<tr>
				<td style="color:red">${errorMsg }</td>
			</tr>
		</c:if>
		<tr>
			<td><input type="submit" value="Submit Form"/></td>
			<td><input type="reset" value="Clear Form"/></td>
		</tr>
	</table>
</form>


</body>
</html>