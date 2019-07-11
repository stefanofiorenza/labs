<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var = "LectureControllerUri" value = "${pageContext.request.contextPath}/form"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Lecture</title>
</head>
<body>

<span> ${msg}</span>

<h3>Insert a new course</h3>
<sform:form method="POST" commandName="lecture" action="${LectureControllerUri}/save" >
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


</body>
</html>