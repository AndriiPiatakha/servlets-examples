<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags/custom" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<custom:userTable users="${users}"/>
	<div align="center">
		<c:if test="${loggedInUser.role == 'admin'}">
			<button>Destroy the World</button>
		</c:if>
	</div>
	<custom:footer/>

</body>
</html>