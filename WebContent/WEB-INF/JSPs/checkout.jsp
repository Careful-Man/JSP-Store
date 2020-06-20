<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%= utilityClasses.PageBuilder.getHeaderPartOne()%>
	<h3>Logged in as: ${customer.firstName} ${customer.lastName}</h3> 
<%= utilityClasses.PageBuilder.getHeaderPartTwo(request)%>


	<h1>Checkout</h1>
	<form action="CheckoutServlet" method="post">
		<p>Country: <input id="form" type="text" name="country" size="20" maxlength="20" value="" /></p>
		<p>City: <input id="form" type="text" name="city" size="20" maxlength="20" value="" /></p>
		<p>Address: <input id="form" type="text" name="address" size="20" maxlength="20" value="" /></p>
		<p>Postal Code: <input id="form" type="text" name="postCode" size="5" maxlength="5" value="" /></p>
		<p>Telephone Number: <input id="form" type="text" name="telNum" size="20" maxlength="20" value=""  /> </p>
		<p>Cell phone Number: <input id="form" type="text" name="cellNum" size="20" maxlength="20" /></p>
		<p><input id="btn" type="submit" name="submit" value="  Complete Order  " /></p>
		<input type="hidden" name="submitted" value="TRUE" />
	</form>
	${printCheckoutErrors.theErrors}
	
<%= utilityClasses.PageBuilder.getFooter() %>