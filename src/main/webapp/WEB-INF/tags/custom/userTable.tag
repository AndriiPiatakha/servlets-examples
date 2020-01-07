<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="users" type="java.util.List" required="true"%>


<table border=1 align="center">
	<tr>
		<td>First Name</td>
		<td>Last Name</td>
		<td>Email</td>
	</tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.name}</td>
			<td>${user.lastName}</td>
			<td>${user.email}</td>
		</tr>
	</c:forEach>
</table>