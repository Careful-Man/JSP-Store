<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%= utilityClasses.PageBuilder.getHeaderPartOne()%>
	<h3>Logged in as: ${customer.firstName} ${customer.lastName}</h3> 
<%= utilityClasses.PageBuilder.getHeaderPartTwo(request)%>

<style>
	img{
		width:450px;
		height:450px;
	}
	p.product{
		font-weight:bold;
		font-size:20;
	}
	input.productInput{
		float:left;
		padding:5px;
	}
</style>


<br>
<table>
	<tr>
		<td>
			<img src=${theProduct.image } alt=${theProduct.image }>
		</td>
		<td>
			<form action="ShoppingCartServlet" method="post">
				<p class="product">
					${theProduct.name }
				</p>
				<hr style="border: 3px solid ${theProduct.hrColor };border-radius: 5px;">
				<p class="product">	
					Category: ${theProduct.category }
					<br><br>
					${theProduct.longDesc }
					<br><br><br><br>
					Stock: ${theProduct.stock }
					<br><br>
					Price: ${theProduct.regularPrice } &euro;
					<br><br><br><br>
					Select Quantity:
					<br><br>
					<input type="number" size="5" name="quantity" value="1" class="productInput">
					<input type="hidden" name="productId" value=${theProduct.id }>
					<input type="submit" size="20" value="Add to Cart" class="productInput">
					<br><br>
					${printProductErrors.theErrors }
					<br>
					<p style="font-weight:bold;">You can continue shopping by <a href="ProductCatalogueServlet">clicking here</a>.</p>
				</p>
			</form>
		</td>
	</tr>
</table>



<%= utilityClasses.PageBuilder.getFooter() %>