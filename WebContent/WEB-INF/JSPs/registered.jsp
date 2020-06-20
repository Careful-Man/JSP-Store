<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%= utilityClasses.PageBuilder.getHeaderPartOne()%>
	<h3>Logged in as: ${customer.firstName} ${customer.lastName}</h3> 
<%= utilityClasses.PageBuilder.getHeaderPartTwo(request)%>


	<h1>Registered</h1>
	<p>You have successfully registered as: <br>
		${firstName} <br>
		${lastName} <br>
		${email} </p>
	<p>You can start shopping by <a href="ProductCatalogueServlet">clicking here</a></p>
	
<%= utilityClasses.PageBuilder.getFooter() %>