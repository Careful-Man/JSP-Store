<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="beanClasses.Customer" %>
<%@ page import="beanClasses.Product" %>
<%@ page import="java.util.concurrent.ConcurrentHashMap" %>
    
    
<%= utilityClasses.PageBuilder.getHeaderPartOne()%>
	<h3>Logged in as: ${customer.firstName} ${customer.lastName}</h3> 
<%= utilityClasses.PageBuilder.getHeaderPartTwo(request)%>


<style>
	th {
		border: 2px solid black;
	  	padding:5px;
	  	font-size:25px;
	}
	td {
		text-align:center;
	  	font-weight:bold;
	  	font-size:20px;
	}
	table.center {
	 	margin-left: auto;
	  	margin-right: auto;
	  	border-spacing:10px 10px;
	}
	input.right{
		float:right;
		padding:5px;
		margin:-15px;
	}
	input.left{
		float:left;
		padding:5px;
		margin:-15px;
	}
	p.cart{
		font-weight:bold;
	  	font-size:25px;
	}
</style>

<p class="cart">${customer.firstName}'s cart:</p>
<table class="center">
	<tr>
		<th>Product Image</th>
		<th>Product Name</th>
		<th>Product Unit Price</th>
		<th>Quantity</th>
		<th>Total Price</th>
	</tr>
	<%  Customer theCustomer = (Customer) session.getAttribute("customer");
		ConcurrentHashMap<Product, Integer> customerProducts = (ConcurrentHashMap<Product, Integer>) theCustomer.getCustomerProducts();
		float orderSum = theCustomer.getOrderSum(customerProducts); 
		for(Product p: customerProducts.keySet()){%>
			<tr>
				<td>
					<img src=<%= p.getImage()%> style="width:50px;height:50px;">
				</td>
				<td>
					<%= p.getName()%>
				</td>
				<td>
					<%= p.getSalePrice()%>&euro;
				</td>
				<td>
					<%= (int) customerProducts.get(p)%> pieces
				</td>
				<td>
					<%= p.getSalePrice()*((int) customerProducts.get(p))%>&euro;
				</td>
				<td>
					<form action="EditShoppingCart" method="get">
						<input type="hidden" name="productId" value=<%= p.getId()%>>
						<input type="submit" class="left" value="Remove from Cart">
					</form>
				</td>
			</tr>
		<%}%>
</table>
<p class="cart">The sum of the order is: <%= orderSum%>&euro;</p><br><br><br>
<form action="ProductCatalogueServlet" method="get">
	<input class="left" type="submit" value="  Continue Shopping  ">
</form>
<form action="CheckoutServlet" method="get">
	<input class="right" type="submit" value="  Procceed to Checkout  ">
</form>
	
	
<%= utilityClasses.PageBuilder.getFooter() %>