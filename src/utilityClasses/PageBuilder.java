package utilityClasses;

import javax.servlet.http.HttpServletRequest;

//This class is used to "import" html code into the servlets and jsps
public class PageBuilder {
	//same for all pages, part 1/2 of header
	public static String getHeaderPartOne() {
		return "<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<title>eShop</title>	\r\n" + 
				"		<link rel=\"stylesheet\" href=\"cssFiles/style.css\" type=\"text/css\" media=\"screen\" />\r\n" + 
				"		<meta http-equiv=\"content-type\" content=\"text/html\" charset=\"UTF-8\" />\r\n" + 
				"	</head>\r\n" + 
				"	<body>\r\n" + 
				"		<div id=\"header\">\r\n" + 
				"			<a href=\"index.html\">\r\n" + 
				"				<h1>eShop</h1>\r\n" + 
				"				<h2>of some sort</h2>\r\n" + 
				"			</a>\r\n";
	}
	
	
	
	
	//same for all pages, part 2/2 of header
	//returns "login" if user hasn't logged in or "logout" if user has logged in
	public static String getHeaderPartTwo(HttpServletRequest request) {
		if(request.getSession().getAttribute("customer") == null) 
			return "		</div>\r\n" + 
			"		<div id=\"navigation\">\r\n" + 
			"			<ul>\r\n" + 
			"				<li><a href=\"ProductCatalogueServlet\">Product Catalogue</a></li>\r\n" + 
			"				<li><a href=\"ShoppingCartServlet\">Shopping Cart</a></li>\r\n" + 
			"				<li><a href=\"CheckoutServlet\">Checkout</a></li>\r\n" + 
			"				<li><a href=\"RegisterServlet\">Register</a></li>\r\n" + 
			"				<li><a href=\"LoginServlet\">Login</a></li>\r\n" + 
			"			</ul>\r\n" + 
			"		</div>\r\n" + 
			"		\r\n" + 
			"		<div id=\"content\">";
		else
			return "		</div>\r\n" + 
			"		<div id=\"navigation\">\r\n" + 
			"			<ul>\r\n" + 
			"				<li><a href=\"ProductCatalogueServlet\">Product Catalogue</a></li>\r\n" + 
			"				<li><a href=\"ShoppingCartServlet\">Shopping Cart</a></li>\r\n" + 
			"				<li><a href=\"CheckoutServlet\">Checkout</a></li>\r\n" + 
			"				<li><a href=\"RegisterServlet\">Register</a></li>\r\n" + 
			"				<li><a href=\"LoginServlet\">Logout</a></li>\r\n" + 
			"			</ul>\r\n" + 
			"		</div>\r\n" + 
			"		\r\n" + 
			"		<div id=\"content\">"; 
	}
	
	
	//same for all pages, the entire footer
	public static String getFooter() {
		return "</div>\r\n" + 
				"		\r\n" + 
				"		<div id=\"footer\">\r\n" + 
				"			<p>Copyright &copy; <a href=\"http://compus.uom.gr/MT188/index.php\">Δικτυοκεντρικό Λογισμικό</a> 2020 (τελευταία χρονιά του μαθήματος) | Designed by Θωμάς Ψαλτικίδης - 17315 | Sponsored by <a href=\"https://www.uom.gr/stelios\">Στυλιανός Ξυνόγαλος</a></p>\r\n" + 
				"		</div>\r\n" + 
				"	</body>\r\n" + 
				"</html>";
	}
	
	
	
	//same for all product-catalogue"like".jsps 
	public static String getSortButtons() {
		return "		<td style=\"border:0px;\">\r\n" + 
				"			<form action=\"ProductCatalogueServlet\" method=\"get\">\r\n" + 
				"				<input type=\"hidden\" name=\"orderBy\" value=\"reset\">\r\n" + 
				"				<input type=\"submit\" class=\"right\" value=\"Reset Layout\">\r\n" + 
				"			</form>\r\n" + 
				"			<br><br><br><br>\r\n" + 
				"			<form action=\"SortByPriceServlet\" method=\"get\">\r\n" + 
				"				<input type=\"hidden\" name=\"orderBy\" value=\"regularPrice ASC, salePrice DESC\">\r\n" + 
				"				<input type=\"submit\" class=\"right\" value=\"Sort products by Price\">\r\n" + 
				"			</form>\r\n" + 
				"			<br><br>\r\n" + 
				"			<form action=\"SortByCategoryServlet\" method=\"get\">\r\n" + 
				"				<input type=\"hidden\" name=\"orderBy\" value=\"category ASC, name ASC\">\r\n" + 
				"				<input type=\"submit\" class=\"right\" value=\"Sort products by Category\">\r\n" + 
				"			</form>\r\n" + 
				"		</td>";
	}
	
	
	
	
	
	

}
