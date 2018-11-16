<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resources/js/jquery-3.3.1.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	$(document).ready(function() {
		$("#update_button").click(function() {
			var password = $('#pass').val();
			var passwordRepeat = $('#passRepeat').val();
			if (password !== passwordRepeat) {
				$('#passErrorMessage').html('Check password');
				return;
			}

			$.ajax({
				url : 'updateUser',
				data : {
					name : $('#userName').val(),
					userId: $('#userId').val()
				},
				method: 'POST',
				success : function(result) {
					$("#successMessage").html("updated successfully");
					debugger;
					console.log(result);
					window.location = result;
				},
				error: function(smth) {
					console.log(smth)
				}
			});
		});
	});
</script>

</head>
<body>

<form action="updateUser" method="POST">
		<input id="userId" type="hidden" name="userId" value="${user.id }">
		<p>First Name: <input id="userName" type="text" name="name" value="${user.name }" required/> <span style="color:red"> ${nameErrorMessage} </span></p>
		
		<p>Last Name now is ${user.lastName }.</p>
		<input type="text" name="last_name" />
		<p>Password</p>
		<input id="pass" type="password" />
		<p>Repeat Password  <span id="passErrorMessage" style="color:red"/></p>
		<input id="passRepeat" type="password" />
		
		<p>Email now is ${user.email }.</p>
		<input type="email" name="email" />
		<p>Date of Birth now is ${user.dob }</p>
		<p><input type="date" name="dob" /> <input type="submit" /></p>
</form>
<p><button id="update_button">UPDATE</button></p>

<div id="successMessage"/>


</body>
</html>