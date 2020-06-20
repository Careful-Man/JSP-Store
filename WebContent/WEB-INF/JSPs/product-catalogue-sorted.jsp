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
				<img src=${productSorted1.image }><br>
				<b>Name: ${productSorted1.name }<br>
				Category: ${productSorted1.category }<br>
				${productSorted1.shortDesc }<br>
				Price: ${productSorted1.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted1s.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${productSorted2.image }><br>
				<b>Name: ${productSorted2.name }<br>
				Category: ${productSorted2.category }<br>
				${productSorted2.shortDesc }<br>
				Price: ${productSorted2.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted2.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${productSorted3.image }><br>
				<b>Name: ${productSorted3.name }<br>
				Category: ${productSorted3.category }<br>
				${productSorted3.shortDesc }<br>
				Price: ${productSorted3.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted3.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${productSorted4.image }><br>
				<b>Name: ${productSorted4.name }<br>
				Category: ${productSorted4.category }<br>
				${productSorted4.shortDesc }<br>
				Price: ${productSorted4.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted4.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${productSorted5.image }><br>
				<b>Name: ${productSorted5.name }<br>
				Category: ${productSorted5.category }<br>
				${productSorted5.shortDesc }<br>
				Price: ${productSorted5.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted5.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<%= utilityClasses.PageBuilder.getSortButtons()%>
	</tr>
	<tr>
		<td>
			<form action="product-servlet">
				<img src=${productSorted6.image }><br>
				<b>Name: ${productSorted6.name }<br>
				Category: ${productSorted6.category }<br>
				${productSorted6.shortDesc }<br>
				Price: ${productSorted6.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted6.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${productSorted7.image }><br>
				<b>Name: ${productSorted7.name }<br>
				Category: ${productSorted7.category }<br>
				${productSorted7.shortDesc }<br>
				Price: ${productSorted7.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted7.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${productSorted8.image }><br>
				<b>Name: ${productSorted8.name }<br>
				Category: ${productSorted8.category }<br>
				${productSorted8.shortDesc }<br>
				Price: ${productSorted8.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted8.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${productSorted9.image }><br>
				<b>Name: ${productSorted9.name }<br>
				Category: ${productSorted9.category }<br>
				${productSorted9.shortDesc }<br>
				Price: ${productSorted9.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted9.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${productSorted10.image }><br>
				<b>Name: ${productSorted10.name }<br>
				Category: ${productSorted10.category }<br>
				${productSorted10.shortDesc }<br>
				Price: ${productSorted10.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted10.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td rowspan="3" valign="top" style="border:0px;">
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
				<img src=${productSorted11.image }><br>
				<b>Name: ${productSorted11.name }<br>
				Category: ${productSorted11.category }<br>
				${productSorted11.shortDesc }<br>
				Price: ${productSorted11.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted11.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${productSorted12.image }><br>
				<b>Name: ${productSorted12.name }<br>
				Category: ${productSorted12.category }<br>
				${productSorted12.shortDesc }<br>
				Price: ${productSorted12.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted12.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${productSorted13.image }><br>
				<b>Name: ${productSorted13.name }<br>
				Category: ${productSorted13.category }<br>
				${productSorted13.shortDesc }<br>
				Price: ${productSorted13.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted13.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${productSorted14.image }><br>
				<b>Name: ${productSorted14.name }<br>
				Category: ${productSorted14.category }<br>
				${productSorted14.shortDesc }<br>
				Price: ${productSorted14.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted14.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${productSorted15.image }><br>
				<b>Name: ${productSorted15.name }<br>
				Category: ${productSorted15.category }<br>
				${productSorted15.shortDesc }<br>
				Price: ${productSorted15.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted15.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
	</tr>
	<tr>
		<td>
			<form action="product-servlet">
				<img src=${productSorted16.image }><br>
				<b>Name: ${productSorted16.name }<br>
				Category: ${productSorted16.category }<br>
				${productSorted16.shortDesc }<br>
				Price: ${productSorted16.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted16.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${productSorted17.image }><br>
				<b>Name: ${productSorted17.name }<br>
				Category: ${productSorted17.category }<br>
				${productSorted17.shortDesc }<br>
				Price: ${productSorted17.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted17.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${productSorted18.image }><br>
				<b>Name: ${productSorted18.name }<br>
				Category: ${productSorted18.category }<br>
				${productSorted18.shortDesc }<br>
				Price: ${productSorted18.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted18.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${productSorted19.image }><br>
				<b>Name: ${productSorted19.name }<br>
				Category: ${productSorted19.category }<br>
				${productSorted19.shortDesc }<br>
				Price: ${productSorted19.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted19.id }>
				<input class="right" type="submit" value="View Product">
			</form>
		</td>
		<td>
			<form action="product-servlet">
				<img src=${productSorted20.image }><br>
				<b>Name: ${productSorted20.name }<br>
				Category: ${productSorted20.category }<br>
				${productSorted20.shortDesc }<br>
				Price: ${productSorted20.regularPrice } &euro;</b>
				<input type="hidden" name="product-id" value=${productSorted20.id }>
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