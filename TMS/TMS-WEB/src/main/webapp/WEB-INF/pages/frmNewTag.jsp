<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<!DOCTYPE html>
<html>
<head>

<c:set var = "TagControllerUri" value = "${pageContext.request.contextPath}/tag"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New tag</title>

</head>
<body>

<span> ${msg}</span>

<h3>Save tag</h3>
<sform:form method="POST" modelAttribute="TagDto" action="${TagControllerUri}/save" >
		<table>
			<tr>
				<td>Tag name:</td>
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