<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags/custom"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="logout.jsp" />

	Welcome in account ${loggedInUser.name }! You are our ADMIN!
	
	<c:if test="${empty users}">
		<p>!!!!!!!!!!!!!</p>
	</c:if>
	
	<table>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.name}</td>
				<td>${user.lastName}</td>
			</tr>
		</c:forEach>
	</table>
	
	<custom:footer/>
</body>
</html>