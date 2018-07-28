
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags/custom"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "ex" uri = "WEB-INF/custom.tld"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! int i = 10; %>
${session.getAttribute("bean").name }

<!--  -->
<%-- --%>
	<custom:hello a="2333"/>
	<custom:printArray coll="${array}" />
	<br />
	<c:out value="${null} <hello> asda" default="default" escapeXml="false"></c:out>
	<br />
	<ex:Hello message="message" coll="${array}"/>
	<br />
	
	<%-- scopes: page, request, session, application --%>
	<c:set var="salary" value="${2000*2}"/>
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

	<c:if test="${not empty catchException}">
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
	url is = ${myURL}
	<br />
	<c:import url="${myURL}" />
	
	<input type="submit" onclick="somefunction()" value="Submit">
	
	<%-- FORMATTING TAGS --%>
	<h3>Number Format:</h3>
      <c:set var = "balance" value = "120000.2309" />
         
      <p>Formatted Number (1): <fmt:formatNumber value = "${balance}" 
         type = "currency"/></p>
         
      <p>Formatted Number (2): <fmt:formatNumber type = "number" 
         maxIntegerDigits = "3" value = "${balance}" /></p>
         
      <p>Formatted Number (3): <fmt:formatNumber type = "number" 
         maxFractionDigits = "3" value = "${balance}" /></p>
         
      <p>Formatted Number (4): <fmt:formatNumber type = "number" 
         groupingUsed = "false" value = "${balance}" /></p>
         
      <p>Formatted Number (5): <fmt:formatNumber type = "percent" 
         maxIntegerDigits="3" value = "${balance}" /></p>
         
      <p>Formatted Number (6): <fmt:formatNumber type = "percent" 
         minFractionDigits = "10" value = "${balance}" /></p>
         
      <p>Formatted Number (7): <fmt:formatNumber type = "percent" 
         maxIntegerDigits = "3" value = "${balance}" /></p>
         
      <p>Formatted Number (8): <fmt:formatNumber type = "number" 
         pattern = "###.###E0" value = "${balance}" /></p>
         
      <p>Currency in USA :
         <fmt:setLocale value = "en_US"/>
         <fmt:formatNumber value = "${balance}" type = "currency"/>
      </p>
      
      <%-- FORMAT DATE DEMO --%>
       <h3>Date Format:</h3>
      <c:set var = "now" value = "<%= new java.util.Date()%>" />

      <p>Formatted Date (1): <fmt:formatDate type = "time" 
         value = "${now}" /></p>
      
      <p>Formatted Date (2): <fmt:formatDate type = "date" 
         value = "${now}" /></p>
      
      <p>Formatted Date (3): <fmt:formatDate type = "both" 
         value = "${now}" /></p>
      
      <p>Formatted Date (4): <fmt:formatDate type = "both" 
         dateStyle = "short" timeStyle = "short" value = "${now}" /></p>
      
      <p>Formatted Date (5): <fmt:formatDate type = "both" 
         dateStyle = "medium" timeStyle = "medium" value = "${now}" /></p>
      
      <p>Formatted Date (6): <fmt:formatDate type = "both" 
         dateStyle = "long" timeStyle = "long" value = "${now}" /></p>
      
      <p>Formatted Date (7): <fmt:formatDate pattern = "yyyy-MM-dd" 
         value = "${now}" /></p>
         
      <%--FN DEMO contains --%>
       <c:set var = "theString" value = "I am a test String"/>

      <c:if test = "${fn:contains(theString, 'test')}">
         <p>Found test string<p>
      </c:if>

      <c:if test = "${fn:contains(theString, 'TEST')}">
         <p>Found TEST string<p>
      </c:if>
      
       <c:if test = "${fn:containsIgnoreCase(theString, 'test')}">
         <p>Found test string<p>
      </c:if>

      <c:if test = "${fn:containsIgnoreCase(theString, 'TEST')}">
         <p>Found TEST string<p>
      </c:if>
      
      <%--FN ends with --%>
        <c:set var = "theString" value = "I am a test String 123"/>

      <c:if test = "${fn:endsWith(theString, '123')}">
         <p>String ends with 123<p>
      </c:if>

      <c:if test = "${fn:endsWith(theString, 'TEST')}">
         <p>String ends with TEST<p>
      </c:if>
      
      <br />
      <%-- DEMO index of --%>
      DEMO INDEX OF
      <c:set var = "string1" value = "This is first String."/>
      <c:set var = "string2" value = "This <abc>is second String.</abc>"/>
      <p>Index (1) : ${fn:indexOf(string1, "first")}</p>
      <p>Index (2) : ${fn:indexOf(string2, "second")}</p>
      
      <br />
      <%-- SPLIT and JOIN FN --%>
      
      <c:set var = "string1" value = "This is first String."/>
      <c:set var = "string2" value = "${fn:split(string1, ' ')}" />
      <c:set var = "string3" value = "${fn:join(string2, '-')}" />
      <p>Final String : ${string3}</p>
      
      <%--FN LENGTH --%>
      
      <c:set var = "string1" value = "This is first String."/>
      <c:set var = "string2" value = "This is second String." />
      <p>Length of String (1) : ${fn:length(string1)}</p>
      <p>Length of String (2) : ${fn:length(string2)}</p>
      
      
      <%-- FN replace --%>
      <c:set var = "string1" value = "This is first String."/>
      <c:set var = "string2" value = "${fn:replace(string1, 'first', 'second')}" />
      <p>Final String : ${string2}</p>
      
      <%-- FN starts with --%>
      <c:set var = "string" value = "Second: This is first String."/>
      
      <c:if test = "${fn:startsWith(string, 'First')}">
         <p>String starts with First</p>
      </c:if>
      
      <br />
      <c:if test = "${fn:startsWith(string, 'Second')}">
         <p>String starts with Second</p>
      </c:if>
	

</body>
</html>