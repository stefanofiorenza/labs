<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<!DOCTYPE html>
<html>
<head>
<c:set var = "EmployeeControllerUri" value = "${pageContext.request.contextPath}/form"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New employee</title>
</head>
<body>

<span> ${msg}</span>

<h3>Register</h3>
<sform:form method="POST" modelAttribute="EmployeeDto" action="${EmployeeControllerUri}/saveEmployee" >
		<table>
			<tr>
				<td>First name:</td>
				<td><sform:input path="firstName" /></td>				
			</tr>
			<tr>
				<td>Last name:</td>
				<td><sform:input path="lastName" /></td>				
			</tr>
				<tr>
				<td>Email:</td>
				<td><sform:input path="email" /></td>				
			</tr>
				<tr>
				<td>Username:</td>
				<td><sform:input path="username" /></td>				
			</tr>
				<tr>
				<td>Password:</td>
				<td><sform:input path="password" /></td>				
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