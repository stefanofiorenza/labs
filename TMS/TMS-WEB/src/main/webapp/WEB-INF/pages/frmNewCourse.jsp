<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<!DOCTYPE html>
<html>
<head>
<c:set var = "ModuleControllerUri" value = "${pageContext.request.contextPath}/course"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New module</title>
</head>
<body>

<span> ${msg}</span>

<h3>New Module</h3>
<sform:form method="POST" modelAttribute="CourseDto" action="${ModuleControllerUri}/save" >
		<table>
			<tr>
				<td>Title:</td>
				<td><sform:input path="title" /></td>				
			</tr>
			<tr>
				<td>Active:</td>
				<td>			
					<sform:radiobutton path="active" value="true" /> Active	<br/>
					<sform:radiobutton path="active" value="false"/>Deactivated	<br/>		
				</td>			
			</tr>     
			<tr>
				<td>Published:</td>
				<td>			
					<sform:radiobutton path="published" value="true" /> Published <br/>
					<sform:radiobutton path="published" value="false"/>Unpublished<br/>		
				</td>			
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