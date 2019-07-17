<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<!DOCTYPE html>
<html>
<head>
<c:set var = "LectureControllerUri" value = "${pageContext.request.contextPath}/lecture"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search lecture</title>
</head>
 
   <body>
   
   <span> ${msg}</span>
   
   <h3>Search for a lecture</h3>
<sform:form method="POST" modelAttribute="LectureSearchDto" action="${LectureControllerUri}/search" >
		<table>
			<tr>
				<td>Title:</td>
				<td><sform:input path="title" /></td>				
			</tr>
			<tr>
				<td>Content:</td>
				<td><sform:input path="content" /></td>				
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
        <th>Title</th>
        <th>Content</th>
    </tr>
 <c:forEach items="${lectures}" var="lectures">
    <tr>      
        <td>${lectures.title}</td>
        <td>${lectures.content}</td>
    </tr>
</c:forEach>
</table>
<br />
<a href="${pageContext.request.contextPath}"> Back To Index</a><br/>	

 
   </body>
</html>