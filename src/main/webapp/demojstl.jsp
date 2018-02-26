<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags/custom"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<custom:printArray coll="${array}" />
	<br />
	<c:out value="${null}" default="default" escapeXml="false"></c:out>
	<br />

	<%-- scopes: page, request, session. application --%>
	<c:set var="salary" value="${2000*2}" />
	<c:out value="${salary}" />

	<br />
	<%-- REMOVE --%>
	<c:set var="salary" scope="session" value="${2000*2}" />
	<p>
		Before Remove Value:
		<c:out value="${salary}" />
	</p>
	<c:remove var="salary" />
	<p>
		After Remove Value:
		<c:out value="${salary}" />
	</p>

	<br />

	<%-- CATCH DEMO --%>
	<c:catch var="catchException">
		<%
			int x = 5 / 0;
		%>
	</c:catch>

	<c:if test="${catchException != null}">
		<p>
			The exception is : ${catchException} <br /> There is an exception:
			${catchException.message}
		</p>
	</c:if>

	<br />

	<%-- CHOOSE  --%>

	<c:set var="salary" scope="session" value="${2000*2}" />
	<p>
		Your salary is :
		<c:out value="${salary}" />
	</p>
	<c:choose>

		<c:when test="${salary <= 0}">
            Salary is very low to survive.
         </c:when>

		<c:when test="${salary > 1000}">
            Salary is very good.
         </c:when>

		<c:otherwise>
            No comment sir...
         </c:otherwise>
	</c:choose>

	<br />

	<%-- URL PARAM AND IMPORT  --%>
	<c:url value="index.html" var="myURL">
		<c:param name="trackingId" value="1234" />
		<c:param name="reportType" value="summary" />
	</c:url>
	url is = ${myURL }
	<br />
	<c:import url="${myURL}" />

</body>
</html>