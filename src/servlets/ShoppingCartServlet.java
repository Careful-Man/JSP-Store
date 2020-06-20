package servlets;

import java.io.IOException;

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


@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String address = "";
		
		if(session.getAttribute("customer") == null) {//if user hasnt logged in
			address = "/WEB-INF/JSPs/not-logged-in.jsp";
		}else {//if user has logged in
			address = "/WEB-INF/JSPs/shopping-cart.jsp";
		}
		
		//redirect to the right JSP
		request.getRequestDispatcher(address).forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer loggedInCustomer;
		String address = "";
		
		FormError errors = new FormError();
		String temp = "<p class=\"error\">The following error(s) occured: <br>";
		
		if(session.getAttribute("customer") == null) {//if user hasnt logged in
			address = "/WEB-INF/JSPs/not-logged-in.jsp";
		}else {//if user has logged in
			loggedInCustomer = (Customer) request.getSession().getAttribute("customer");
			
			
			for(Product p: DbAssistant.getProducts()) {
				if(p.getId() == Integer.parseInt(request.getParameter("productId"))) {
					try {
						if(Integer.parseInt(request.getParameter("quantity")) <= 0){//if input quantity is less than 0
							temp += "Order quantity must be more than 0.";
							address = "/WEB-INF/JSPs/product.jsp";
							
							errors.setTheErrors(temp + "</p>");
							request.setAttribute("printProductErrors", errors);
							request.setAttribute("theProduct", p);
							break;
						}
						if( !(p.getStock() == 0 || p.getStock() < Integer.parseInt(request.getParameter("quantity"))) ) {//if stock is more than 0 and input quantity<=stock
							loggedInCustomer.putIntoCustomerProducts(p, Integer.parseInt(request.getParameter("quantity")));
							address = "/WEB-INF/JSPs/shopping-cart.jsp";
							
							errors.setTheErrors(temp + "</p>");
							request.setAttribute("printProductErrors", errors);
							request.setAttribute("theProduct", p);
							break;
						}else{//if stock is less than 0 or input quantity>stock
							temp += "This product is either out of stock or the desired quantity <br>is greater than the available stock.";
							address = "/WEB-INF/JSPs/product.jsp";
							
							errors.setTheErrors(temp + "</p>");
							request.setAttribute("printProductErrors", errors);
							request.setAttribute("theProduct", p);
							break;
						}
					}catch(NumberFormatException nfe) {
						temp += "You must input an order quantity.";
						address = "/WEB-INF/JSPs/product.jsp";
						
						errors.setTheErrors(temp + "</p>");
						request.setAttribute("printProductErrors", errors);
						request.setAttribute("theProduct", p);
						break;
					}
						
					
				}
			}
		}
		
		//redirect to the right JSP
		request.getRequestDispatcher(address).forward(request, response);
		
	}

}
