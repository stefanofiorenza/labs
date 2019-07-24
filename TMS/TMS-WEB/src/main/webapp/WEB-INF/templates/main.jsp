<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><tiles:insertAttribute name="head-title" /></title>
	<tiles:insertAttribute name="head-meta" />
	<tiles:insertAttribute name="head-bootstrap" />
	<tiles:insertAttribute name="head-jquery" />
	<tiles:insertAttribute name="head-common" />
</head>
<body>

<div  id="root" class="container-fluid fixed">

		<tiles:insertAttribute name="nav-bar" />
					
		<div id="wrapper">	
			<tiles:insertAttribute name="left-menu" />		
			<tiles:insertAttribute name="content" />	
		</div>
	
		<tiles:insertAttribute name="footer" />	
		<tiles:insertAttribute name="footer-js" />	
		
</div>
	
	
</body>
</html>