<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%= utilityClasses.PageBuilder.getHeaderPartOne()%>
	<h3>Logged in as: ${customer.firstName} ${customer.lastName}</h3> 
<%= utilityClasses.PageBuilder.getHeaderPartTwo(request)%>

	<p>You have successfully logged out.</p>
	
<%= utilityClasses.PageBuilder.getFooter() %>