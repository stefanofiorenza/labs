<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var = "CourseControllerUri" value = "${pageContext.request.contextPath}/course"/>



<div id="menu" class="hidden-phone">
	<div id="menuInner">				
		<ul>
			<li class="heading"><span>COURSES</span></li>
			<li><a href="${CourseControllerUri}/create"><i></i><span>Create Course</span></a></li>		
			<li><a href="finances.html?lang=en"><i></i><span>Courses</span></a></li>	
			<li><a href="module/create"><i></i><span>New Module</span></a></li>	
			<li><a href="finances.html?lang=en"><i></i><span>Modules</span></a></li>			
			<li><a href="edition/create"><i></i><span>New Edition</span></a></li>	
			<li><a href="edition/search"><i></i><span>Editions</span></a></li>				
			<li><a href="lecture/create"><i></i><span>New Lecture</span></a></li>		
			<li><a href="lecture/search"><i></i><span>Lectures</span></a></li>	
		</ul>	
		
		<ul>
			<li class="heading"><span>SCHEDULES</span></li>					
			<li><a href="finances.html?lang=en"><i></i><span>  Schedules</span></a></li>												
		</ul>
		
		<ul>
			<li class="heading"><span>SUBSCRIPTIONS</span></li>					
			<li><a href="finances.html?lang=en"><i></i><span>  Subscriptions</span></a></li>
			<li><a href="finances.html?lang=en"><i></i><span>  Assessments</span></a></li>														
		</ul>
					
		<ul>
			<li class="heading"><span>TRAINERS</span></li>					
			<li><a href="trainer/create"><i></i><span>Create Trainer</span></a></li>	
			<li><a href="trainer/search"><i></i><span>Search Trainers</span></a></li>									
		</ul>
		<ul>
			<li class="heading"><span>EMPLOYEES</span></li>					
			<li><a href="trainer/create"><i></i><span>New Employee</span></a></li>	
			<li><a href="trainer/search"><i></i><span>Search Trainers</span></a></li>									
		</ul>
	</div>
</div>