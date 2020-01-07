<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form>
		<!-- HIDDEN PARAMETERS -->
		<input type="hidden" value="${user.id}" name="userId"/>
		
		<table align="center">
			<tr>
				<td>Name:</td>
				<td><input type="text" value="${user.firstName}" /></td>
			</tr>

			<tr>
				<td>Is Blocked:</td>
				<td><input type="text" value="${user.isBlocked}" /></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="Update User"/> 
				</td>
			</tr>


		</table>
	</form>

</body>
</html>