<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery, Ajax and Servlet/JSP integration example</title>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="resources/js/app-ajax.js" type="text/javascript"></script>
<script src="resources/js/jquery-3.3.1.js" type="text/javascript"></script>
</head>
<body>

	<form>
		Enter Your Name: <input type="text" id="userName" />
	</form>
	<br/>
	<br/>

	<strong>Ajax Response</strong>:
	<div id="ajaxGetUserServletResponse"></div>
</body>
</html>