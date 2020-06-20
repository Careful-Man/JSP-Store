<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%= utilityClasses.PageBuilder.getHeaderPartOne()%>
	<h3>Logged in as: ${customer.firstName} ${customer.lastName}</h3> 
<%= utilityClasses.PageBuilder.getHeaderPartTwo(request)%>

	
	
	<% if(session.getAttribute("customer") == null){%>
	<h1>Login</h1>
	<form action="LoginServlet" method="post">
		<p>Email: <input id="form" type="text" name="email" size="20" maxlength="20" value="" /></p>
		<p>Password: <input id="form" type="password" name="pass" size="15" maxlength="20" /></p>
		<p><input id="btn" type="submit" name="submit" value="  Login  " /></p>
		<input type="hidden" name="submitted" value="TRUE" />
	</form>
	<%}else{ %>
	<h1>Logout</h1>
	<form action="LogoutServlet" method="post">
		<p><input id="btn" type="submit" name="submit" value="  Logout  " /></p>
	</form>
	<%} %>
	${printLoginErrors.theErrors}
	
<%= utilityClasses.PageBuilder.getFooter() %>