<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<%@ attribute name="coll" type="java.util.Collection" %>

<c:forEach items="${coll}" var="item">
	<c:out value="${item}"></c:out>
</c:forEach>