<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<c:set var = "LectureControllerUri" value = "${pageContext.request.contextPath}/lecture"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit lecture</title>
</head>
<body>

<span> ${msg}</span>

<h3>Edit a lecture</h3>
<sform:form method="POST" modelAttribute="LectureDto" action="${LectureControllerUri}/edit/${lecture.id}" >
		<table>
		<c:if test="${lecture != null}">
                    <sform:input type="hidden" path="id" value="${lecture.id}" />
                </c:if> 
			<tr>
				<td>Title:</td>
				<td><sform:input path="title" value= "${lecture.title}"/></td>				
			</tr>
			<tr>
				<td>Content:</td>
				<td><sform:input path="content" value= "${lecture.content}"/></td>					
			</tr>
		<tr>
		<td><input type="reset" value="Cancel"/></td>
				<td><input type="submit" value="Edit save"/></td>
	</tr>
</table>
</sform:form>

<a href="${pageContext.request.contextPath}"> Back To Index</a><br/>	

</body>
</html>