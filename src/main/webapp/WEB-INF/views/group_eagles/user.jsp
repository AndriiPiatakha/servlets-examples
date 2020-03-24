<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>User</title>
</head>
<body>
	<%! int i; %>

	<p>Hello!</p>
	<p>Your user name: ${loggedInUser.firstName}</p>
	<p><%= new Date() %></p>
	<%
	
		Date date = new Date();
		request.setAttribute("date", date);
	%>
	
	<p>========</p>
	<%-- <p>${date}</p> --%>
	
	<form action="GetUserController" method="POST">
		<input name="login" type="text" placeholder="Insert your login"/>
		<input name="password" type="password" placeholder="Insert your password"/>
		<input type="submit" value="Login"/>
	</form>

</body>
</html>