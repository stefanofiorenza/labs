<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<!DOCTYPE html>
<html>
<head>

<c:set var = "EditionControllerUri" value = "${pageContext.request.contextPath}/edition"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New edition</title>

</head>
<body>

<span> ${msg}</span>

<h3>Save edition</h3>
<sform:form method="POST" modelAttribute="EditionDto" action="${EditionControllerUri}/save" >
		<table>
			<tr>
				<td>Start date:</td>
				<td><sform:input path="startDate" /></td>				
			</tr>
			<tr>
				<td>End date:</td>
				<td><sform:input path="endDate" /></td>				
			</tr>
			<tr>
				<td>Deadline:</td>
				<td><sform:input path="deadline" /></td>				
			</tr>
			<tr>
				<td>Open:</td>
				<td>			
					<sform:radiobutton path="open" value="true" /> Open <br/>
					<sform:radiobutton path="open" value="false"/>Closed<br/>		
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