<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<!DOCTYPE html>
<html>
<head>
<c:set var = "ModuleControllerUri" value = "${pageContext.request.contextPath}/module"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New module</title>
</head>
<body>

<span> ${msg}</span>

<h3>New Module</h3>
<sform:form method="POST" modelAttribute="ModuleDto" action="${ModuleControllerUri}/save" >
		<table>
			<tr>
				<td>Title:</td>
				<td><sform:input path="title" /></td>				
			</tr>
			<tr>
                <td>Program pdf:</td>
                <td><input type="file" name="fileUpload" /></td>
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