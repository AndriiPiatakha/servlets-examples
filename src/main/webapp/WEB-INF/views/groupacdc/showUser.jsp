<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Specific User Page</title>
</head>
<body>

<h1>Specific User Page</h1>

<p>Name: ${user.firstName}</p>
<p>Id: ${user.id}</p>

<%! private int i; %>
<% String s = "Some string"; %>
<%=s %>

<form action="updateUserServlet2" method="GET">
	<input type="hidden" value = "${user.id}" name = "userId"/>
	<input type="submit" value="Update User"/>
</form>

</body>
</html>