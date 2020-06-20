package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanClasses.Product;
import utilityClasses.DbAssistant;


@WebServlet("/product-servlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//checks stock and sets a red or green color, depending on the stock
	//also gets the product's id and makes a separate view for each product
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/JSPs/product.jsp";
		ArrayList<Product> products = DbAssistant.getProducts();
		for(Product p: products) {
			if(Integer.parseInt(request.getParameter("product-id")) == p.getId()) {
				if(p.getStock() != 0) 
					p.setHrColor("green");
				else 
					p.setHrColor("red");
				
				if(p.getSalePrice() != 0) 
					p.setRegularPrice(p.getSalePrice());
				
				request.setAttribute("theProduct", p);
			}
			
		} 
		
		
		request.getRequestDispatcher(address).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
