<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%= utilityClasses.PageBuilder.getHeaderPartOne()%>
	<h3>Logged in as: ${customer.firstName} ${customer.lastName}</h3> 
<%= utilityClasses.PageBuilder.getHeaderPartTwo(request)%>

	<p class="error">Oops! Looks like you're not logged in. You must log in to complete this action.</p>
	
<%= utilityClasses.PageBuilder.getFooter() %>