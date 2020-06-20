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
	  	font-size:20px;
	}
	td {
		text-align:center;
	  	font-weight:bold;
	  	font-size:15px;
	}
	table.center {
	 	margin-left: auto;
	  	margin-right: auto;
	  	border-spacing:10px 10px;
	}
	p.cart{
		font-weight:bold;
	  	font-size:20px;
	}
</style>



	<h1>Order Complete!</h1>
	<p class="cart">You have successfully ordered the following items: <br>
	<table class="center">
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
						* <%= (int) customerProducts.get(p)%> pieces
					</td>
					<td>
						 = <%= p.getSalePrice()*((int) customerProducts.get(p))%>&euro;
					</td>
				</tr>
			<%}%>
		</table>
		<p class="cart">With a total sum of: <%= orderSum%>&euro;</p>
	</p>
	
	
	<%
		customerProducts.clear();//empty customer's cart, since he/she/it checked out
	%>

<%= utilityClasses.PageBuilder.getFooter() %>