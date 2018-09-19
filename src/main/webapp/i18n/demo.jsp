<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.text.DateFormat"%>

<%-- 
<fmt:setBundle>
Resource bundle is nothing but a collection of messages in a form of key – 
value pair. We can define one file per locale and all file will have same keys but corresponding values will be locale specific. This tag is used to load the resource bundle in any scoped variable OR in bundle configuration variable.

Syntax of tag is –

<fmt:setBundle basename="bundle_base_name" var="variable_name" 
scope=��page| request | application| session />

· basename- is mandatory attribute and used to specify base name of bundle.

· var- is an optional attribute to store the bundle

· scope- is the scope of variable defined in var tag. Default value is page


<fmt:setLocale>
This tag is used to store the locale in locale configuration variable.

Syntax of this tag is-

<fmt:setLocale value="valid_locale" variant="variant" 
scope=”page| request | application| session”/>cation| session”/>

· value - is the mandatory attribute and is used for specifying a locale. To specify a locale code it must have made from the two-letter (lower case) language code (according to ISO-639) and/or the two-letter (upper-case) of country code (according to the ISO-3166). And if both the language and country code are used for specifying the locale the locale code must be separated by either hyphen (-) or underscore (_).

· variant : is an optional attribute and is used for specifying the browser or vendor specific variant.

· scope : is an optional attribute and specifies the scope of locale configuration variable. Default value is Page

<fmt:message>
This tag is used to display the messages from bundle based on the locale.

Syntax of this tag is-

 <fmt:message key="key_in_bundle_file" bundle="bundle_variable" 
 scope=”page| request | application| session” var=”variable_name”/> 

· var- is an optional attribute to store the resolved localized message.

· scope- is the scope of variable defined in var tag. Default value is page

· key- is the key in resource bundle whose value to display

· bundle- variable in which bundle is stored and this bundle will be used.

Note : If var is used, then message will not be displayed, instead will be stored in a variable for a later use.

--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
 <body>
    <fmt:setBundle basename="myBundle" var="resourceBundle"/>
    Title in default Locale :: <fmt:message key="title" bundle="${resourceBundle}"/>
    <br/>
    <fmt:message key="usernameLbl" var="userMsg" bundle="${resourceBundle}"/>
    Username in Default Locale :: <c:out value="${userMsg}"/>
    <br/>
    <fmt:setLocale value="es_US"/>
    <fmt:setBundle basename="myBundle" var="resourceBundle"/>
    Title in Spanish Locale :: <fmt:message key="title" bundle="${resourceBundle}"/>
    <br/>
    Username in Spanish Locale :: <fmt:message key="usernameLbl" bundle="${resourceBundle}"/>
    
    <br />
    
    <br />
    
    <%@page import="java.util.*" %>
    <h3> Display Current Date and Number based on client request locale </h3>
    <%
     //Locale locale = request.getLocale();
     Date currentDate= new Date();
     DateFormat dateFormat= DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
     NumberFormat numberFormat =  NumberFormat.getNumberInstance(Locale.US);
    %>
    Locale is  <%= Locale.US %>
    <br/> 
    Current date ::  
   <%=
     dateFormat.format(currentDate) 
   %>
   <br/>
   Number (100045.34) ::
   <%= 
     numberFormat.format(100045.34)
   %>
  </body>
</html>