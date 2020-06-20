package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanClasses.Customer;
import beanClasses.FormError;
import beanClasses.Product;
import utilityClasses.DbAssistant;


@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String address = "";
		
		if(session.getAttribute("customer") == null) {//if user hasnt logged in
			address = "/WEB-INF/JSPs/not-logged-in.jsp";
		}else {//if user has logged in
			address = "/WEB-INF/JSPs/checkout.jsp";
		}
		
		//redirect to the right JSP
		request.getRequestDispatcher(address).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer theCustomer = (Customer) session.getAttribute("customer");
		ConcurrentHashMap <Product, Integer> customerProducts =  theCustomer.getCustomerProducts();
		FormError errors = new FormError();
		String temp = "<p class=\"error\">The following error(s) occured: <br>";
		String address = "";
		
		if(customerProducts.isEmpty()) {//if customer tries to checkout with empty cart
			temp += "Looks like your shopping cart is empty. <br>"
					+ "You must have at least one item in your cart in order to checkout.<br>";
			temp += "</p>";
			address = "/WEB-INF/JSPs/checkout.jsp";
			errors.setTheErrors(temp);
			request.setAttribute("printCheckoutErrors", errors);
		}else {//customer checks out with at least one item in his cart
			String country = request.getParameter("country");
			String city = request.getParameter("city");
			String deliveryAddress = request.getParameter("address");
			String postCode = request.getParameter("postCode");
			String telNum = request.getParameter("telNum");
			String cellNum = request.getParameter("cellNum");
			
			
			if(country.trim().equals("") || 
				city.trim().equals("") ||  
				deliveryAddress.trim().equals("") || 
				postCode.trim().equals("") || 
				telNum.trim().equals("") ||
				cellNum.trim().equals("")) {//if there are empty fields
				
				//show the user which of them are
				if(country.trim().equals("")) 
					temp += "You must fill in the field: Country <br>";
				if(city.trim().equals("")) 
					temp += "You must fill in the field: City <br>";
				if(deliveryAddress.trim().equals("")) 
					temp += "You must fill in the field: Address <br>";
				if(postCode.trim().equals("")) 
					temp += "You must fill in the field: Postal Code <br>";
				if(telNum.trim().equals("")) 
					temp += "You must fill in the field: Telephone Number <br>";
				if(cellNum.trim().equals("")) 
					temp += "You must fill in the field: Cell phone Number <br>";
				
				temp += "</p>";
				address = "/WEB-INF/JSPs/checkout.jsp";
				errors.setTheErrors(temp);
				request.setAttribute("printCheckoutErrors", errors);
				
			}else {//everything is ok! you can checkout!
				address = "/WEB-INF/JSPs/order-complete.jsp";
				ArrayList<Product> alreadyBoughtProducts = theCustomer.getCustomerBoughtProducts();
				boolean found = false;
				for(Product p: customerProducts.keySet()) {//remove products quantity from db stock
					DbAssistant.removeQuantityFromStock(p.getId(), (int) customerProducts.get(p));
					DbAssistant.customerBuysProduct(Integer.parseInt(DbAssistant.getCustomerField(theCustomer.getEmail(), "id")), p.getId());
					for(Product boughtProduct: alreadyBoughtProducts) {
						if(p.getId() == boughtProduct.getId()) {
							found = true;
						}
					}
					if(!found) 
						theCustomer.getCustomerBoughtProducts().add(p);
					found = false;
				}
				
			}
			
			
		}
		
		
		//redirect to the right JSP
		request.getRequestDispatcher(address).forward(request, response);
	}

}
