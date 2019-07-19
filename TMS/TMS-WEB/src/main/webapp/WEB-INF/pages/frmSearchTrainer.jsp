<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<!DOCTYPE html>
<html>
<head>
<c:set var = "TrainerControllerUri" value = "${pageContext.request.contextPath}/trainer"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search trainer</title>
</head>
 
   <body>
   
   <span> ${msg}</span>
   
   <h3>Search for a trainer</h3>
<sform:form method="POST" modelAttribute="TrainerSearchDto" action="${TrainerControllerUri}/search" >
		<table>
			<tr>
				<td>First Name:</td>
				<td><sform:input path="firstName" /></td>				
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><sform:input path="lastName" /></td>				
			</tr>
			<tr>
				<td>Email:</td>
				<td><sform:input path="email" /></td>				
			</tr>
			<tr>
				<td>IdCode:</td>
				<td><sform:input path="idCode" /></td>				
			</tr>
		<tr>
		<td><input type="reset" value="Cancel"/></td>
				<td><input type="submit" value="Submit"/></td>
	</tr>
</table>
 </sform:form>  
 <br />
 <h3>Search results:</h3>
 <table>
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Email</th>
        <th>IdCode</th>
         <th>Edit</th>
    </tr>
 <c:forEach items="${trainers}" var="trainers">
    <tr>      
        <td>${trainers.firstName}</td>
        <td>${trainers.lastName}</td>
        <td>${trainers.email}</td>
        <td>${trainers.idCode}</td>
        <td><a href="trainer/edit">edit</a></td>
    </tr>
</c:forEach>
</table>
<br />
<a href="${pageContext.request.contextPath}">Back To Index</a><br/>	
   </body>
</html>