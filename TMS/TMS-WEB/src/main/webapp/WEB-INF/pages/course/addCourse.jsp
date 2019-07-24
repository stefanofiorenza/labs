<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<c:set var = "ModuleControllerUri" value = "${pageContext.request.contextPath}/course"/>

<div id="content">

<div class="span8" >

	<div class="widget-head">
		<div class="heading-buttons">
			<h3 class="glyphicons bank"><i></i> Add Course</h3>					
			<div class="clearfix"></div>
		</div>
	</div><!-- widget-head -->
	
	<hr class="separator bottom">	
	
	<div class="widget-body" style="padding: 10px;">
		<div class="tab-pane active" id="courseDetailsTab">
		
			<div id="courseDetailsInnerDiv" class="row-fluid" >		
			
				<div class="span6">
					<sform:form method="POST" modelAttribute="CourseDto" action="${ModuleControllerUri}/save" >

						<label for="inputTitle">Title</label>
						<sform:input path="title" id="inputTitle" class="span6"  placeholder="Enter Name ..." />
						<div class="separator"></div>
		
						<label for="inputActive">Active</label>
						<sform:radiobutton path="active" value="true" /> Yes<br/>
						<sform:radiobutton path="active" value="false"/>No<br/>
						<div class="separator"></div>
				
						<label for="inputActive">Published</label>
						<sform:radiobutton path="published" value="true" /> Yes<br/>
						<sform:radiobutton path="published" value="false"/>No<br/>
												
						<br/>
						<div class="buttons">
							<input class="btn btn-primary" type="submit" value="Submit"/>
							<input class="btn btn-primary" type="reset" value="Cancel"/>							
						</div>
					
					</sform:form>
					</div><!-- span9 -->
					
			</div><!-- courseDetailsInnerDiv -->
	
		</div><!-- courseDetailsTab -->
	</div><!-- widget-body -->
</div><!-- span12 -->


<%-- 
		<div class="row-fluid" style="background-color:orange;">
			<span> ${msg}</span>
		</div>
		
		<div class="row-fluid" style="background-color:window;">		
			
				<div class="span12" style="background-color: aqua;">
					<sform:form method="POST" modelAttribute="CourseDto" action="${ModuleControllerUri}/save" >

						<label for="inputTitle">Title</label>
						<sform:input path="title" id="inputTitle" class="span10"  placeholder="Enter Name ..." />
						<div class="separator"></div>
		
						<label for="inputActive">Active</label>
						<sform:radiobutton path="active" value="true" /> Yes<br/>
						<sform:radiobutton path="active" value="false"/>No<br/>
						<div class="separator"></div>
				
						<label for="inputActive">Published</label>
						<sform:radiobutton path="published" value="true" /> Yes<br/>
						<sform:radiobutton path="published" value="false"/>No<br/>
							
						<hr class="separator bottom">
						<br/>
						<br/>
						<div class="buttons pull-right">
							<input class="btn btn-primary" type="submit" value="Submit"/>
							<input class="btn btn-primary" type="reset" value="Cancel"/>							
						</div>
					
					</sform:form>
				</div><!-- span12 -->				
		</div><!-- 1st row fluid -->
		--%>			
			
			
			
		<%-- 	
			<div class="span12" >
			
			<div class="widget-head">
				<div class="heading-buttons">
					<h3 class="glyphicons cart_in"><i></i> Add product</h3>					
					<div class="clearfix"></div>
				</div>
			</div>
			<hr class="separator bottom">
			<div class="widget-body" style="padding: 10px;">
				<!-- Description -->
				<div class="tab-pane active" id="productDescriptionTab">
					<div class="row-fluid">
						<div class="span3">
							<strong>Product</strong>
							<p class="muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
						</div>
						<div class="span9">
							<label for="inputTitle">Name</label>
							<input type="text" id="inputTitle" class="span6" value="" placeholder="Enter Name ...">
							<div class="separator"></div>
							
							<label for="inputTitle">Brand</label>
							<input type="text" id="inputTitle" class="span6" value="" placeholder="Enter Brand ...">
							<div class="separator"></div>
							
							<label for="inputTitle">Price</label>
							<input type="text" id="inputTitle" class="span6" value="" placeholder="Enter Price  ...">
							<div class="separator"></div>
							
							<label for="inputTitle">Quantity</label>
							<input type="text" id="inputTitle" class="span6" value="" placeholder="Enter quantity...">
							<div class="separator"></div>
							
							<label for="inputTitle">OtherField</label>
							<input type="text" id="inputTitle" class="span6" value="" placeholder="Enter value ...">
							<div class="separator"></div>
						</div>
						<hr class="separator bottom">
						<br/>
						<br/>
						<div class="buttons pull-right">
							<a href="" class="btn btn-default btn-icon glyphicons share"><i></i> Preview</a>
							<a href="" class="btn btn-primary btn-icon glyphicons ok_2"><i></i> Save</a>
						</div>
					</div>								
				</div>
				<!-- Description END -->			
		</div>
		</div><!--  sPAN 12 -->
			--%>
			
			
		<%-- 
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
				<td><input class="btn btn-primary" type="reset" value="Cancel"/></td>
						<td><input class="btn btn-primary" type="submit" value="Submit"/></td>
				</tr>
	</table>
	</sform:form>

	<a href="${pageContext.request.contextPath}"> Back To Index</a><br/>
	--%>	
</div>