package servlets;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanClasses.Customer;
import beanClasses.Product;


@WebServlet("/EditShoppingCart")
public class EditShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer theCustomer = (Customer) session.getAttribute("customer");
		ConcurrentHashMap <Product, Integer> customerProducts =  theCustomer.getCustomerProducts();
		String address = "";
		
		for(Product p: customerProducts.keySet()) {
			if(p.getId() == Integer.parseInt(request.getParameter("productId"))) {
				customerProducts.remove(p);
			}
		}
		address = "/WEB-INF/JSPs/shopping-cart.jsp";
		
		
		//redirect to the right JSP
		request.getRequestDispatcher(address).forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
