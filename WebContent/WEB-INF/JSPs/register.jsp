<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%= utilityClasses.PageBuilder.getHeaderPartOne()%>
	<h3>Logged in as: ${customer.firstName} ${customer.lastName}</h3> 
<%= utilityClasses.PageBuilder.getHeaderPartTwo(request)%>


	<h1>Register</h1>
	<form action="RegisterServlet" method="post">
		<p>First Name: <input id="form" type="text" name="first_name" size="20" maxlength="20" value="" /></p>
		<p>Last Name: <input id="form" type="text" name="last_name" size="20" maxlength="40" value="" /></p>
		<p>Email Address: <input id="form" type="text" name="email" size="30" maxlength="80" value=""  /> </p>
		<p>Password: <input id="form" type="password" name="pass1" size="15" maxlength="20" /></p>
		<p>Confirm Password: <input id="form" type="password" name="pass2" size="15" maxlength="20" /></p>
		<p><input id="btn" type="submit" name="submit" value="  Register  " /></p>
		<input type="hidden" name="submitted" value="TRUE" />
	</form>
	${printRegisterErrors.theErrors}
	
<%= utilityClasses.PageBuilder.getFooter() %>