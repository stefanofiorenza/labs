<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<!DOCTYPE html>
<html>
<head>

<c:set var = "TopicControllerUri" value = "${pageContext.request.contextPath}/topic"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New topic</title>

</head>
<body>

<span> ${msg}</span>

<h3>Save topic</h3>
<sform:form method="POST" modelAttribute="TopicDto" action="${TopicControllerUri}/save" >
		<table>
			<tr>
				<td>Topic name:</td>
				<td><sform:input path="name" /></td>				
			</tr>
						
			<tr>
			<td><input type="reset" value="Cancel"/></td>
					<td><input type="submit" value="Submit"/></td>
			</tr>
</table>
</sform:form>

<a href="${pageContext.request.contextPath}"> Back To Index</a><br/>	

</body>
</html>