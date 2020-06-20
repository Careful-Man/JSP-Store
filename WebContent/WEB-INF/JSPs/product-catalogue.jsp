<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="beanClasses.Customer" %>
<%@ page import="beanClasses.Product" %>
<%@ page import="java.util.ArrayList" %>      
    
<%= utilityClasses.PageBuilder.getHeaderPartOne()%>
	<h3>Logged in as: ${customer.firstName} ${customer.lastName}</h3> 
<%= utilityClasses.PageBuilder.getHeaderPartTwo(request)%>




<style>
	th, td {
		border: 2px solid black;
	  	padding:5px;
	}
	table.center {
	 	margin-left: auto;
	  	margin-right: auto;
	  	border-spacing:10px 10px;
	}
	img{
		width:210px;
		height:210px;
	}
	input.right{
		float:right;
		padding:5px;
	}
</style>


<table class="center">
	<tr>
		<td>
			<form action="product-servlet">
				<img src=${product1.image }><br>
				<b>Name: ${product1.name }<br>
				Category: ${product1.category }<br>
				${product1.shortDesc }<br>
				Price: ${product1.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product1.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${product2.image }><br>
				<b>Name: ${product2.name }<br>
				Category: ${product2.category }<br>
				${product2.shortDesc }<br>
				Price: ${product2.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product2.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${product3.image }><br>
				<b>Name: ${product3.name }<br>
				Category: ${product3.category }<br>
				${product3.shortDesc }<br>
				Price: ${product3.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product3.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${product4.image }><br>
				<b>Name: ${product4.name }<br>
				Category: ${product4.category }<br>
				${product4.shortDesc }<br>
				Price: ${product4.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product4.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${product5.image }><br>
				<b>Name: ${product5.name }<br>
				Category: ${product5.category }<br>
				${product5.shortDesc }<br>
				Price: ${product5.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product5.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<%= utilityClasses.PageBuilder.getSortButtons()%>
	</tr>
	<tr>
		<td>
			<form action="product-servlet">
				<img src=${product6.image }><br>
				<b>Name: ${product6.name }<br>
				Category: ${product6.category }<br>
				${product6.shortDesc }<br>
				Price: ${product6.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product6.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${product7.image }><br>
				<b>Name: ${product7.name }<br>
				Category: ${product7.category }<br>
				${product7.shortDesc }<br>
				Price: ${product7.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product7.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${product8.image }><br>
				<b>Name: ${product8.name }<br>
				Category: ${product8.category }<br>
				${product8.shortDesc }<br>
				Price: ${product8.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product8.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${product9.image }><br>
				<b>Name: ${product9.name }<br>
				Category: ${product9.category }<br>
				${product9.shortDesc }<br>
				Price: ${product9.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product9.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${product10.image }><br>
				<b>Name: ${product10.name }<br>
				Category: ${product10.category }<br>
				${product10.shortDesc }<br>
				Price: ${product10.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product10.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td rowspan="5" valign="top" style="border:0px;">
			<table>
				<th colspan="2" style="border:0px;">
					Products you've bought:
				</th>
				<%  Customer theCustomer = (Customer) session.getAttribute("customer");
					try{
						ArrayList<Product> customerBoughtProducts = theCustomer.getCustomerBoughtProducts();
						for(Product p: customerBoughtProducts){%>
					
						<tr>
							<td style="border:0px;">
								<img src=<%= p.getImage()%> style="width:50px;height:50px;">
							</td>
							<td style="border:0px;">
								<%= p.getName()%>
							</td>
						</tr>
					<%}
					}catch(Exception e){
						
					}%>		
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<form action="product-servlet">
				<img src=${product11.image }><br>
				<b>Name: ${product11.name }<br>
				Category: ${product11.category }<br>
				${product11.shortDesc }<br>
				Price: ${product11.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product11.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${product12.image }><br>
				<b>Name: ${product12.name }<br>
				Category: ${product12.category }<br>
				${product12.shortDesc }<br>
				Price: ${product12.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product12.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${product13.image }><br>
				<b>Name: ${product13.name }<br>
				Category: ${product13.category }<br>
				${product13.shortDesc }<br>
				Price: ${product13.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product13.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${product14.image }><br>
				<b>Name: ${product14.name }<br>
				Category: ${product14.category }<br>
				${product14.shortDesc }<br>
				Price: ${product14.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product14.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${product15.image }><br>
				<b>Name: ${product15.name }<br>
				Category: ${product15.category }<br>
				${product15.shortDesc }<br>
				Price: ${product15.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product15.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
	</tr>
	<tr>
		<td>
			<form action="product-servlet">
				<img src=${product16.image }><br>
				<b>Name: ${product16.name }<br>
				Category: ${product16.category }<br>
				${product16.shortDesc }<br>
				Price: ${product16.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product16.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${product17.image }><br>
				<b>Name: ${product17.name }<br>
				Category: ${product17.category }<br>
				${product17.shortDesc }<br>
				Price: ${product17.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product17.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${product18.image }><br>
				<b>Name: ${product18.name }<br>
				Category: ${product18.category }<br>
				${product18.shortDesc }<br>
				Price: ${product18.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product18.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${product19.image }><br>
				<b>Name: ${product19.name }<br>
				Category: ${product19.category }<br>
				${product19.shortDesc }<br>
				Price: ${product19.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product19.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${product20.image }><br>
				<b>Name: ${product20.name }<br>
				Category: ${product20.category }<br>
				${product20.shortDesc }<br>
				Price: ${product20.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${product20.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
	</tr>
	<tr>
		<td style="border:0px;"><br><br><br><br><br><br></td>
	</tr>
	<tr>
		<td style="border:0px;"><br><br><br><br><br><br></td>
	</tr>
</table>



<%= utilityClasses.PageBuilder.getFooter() %>