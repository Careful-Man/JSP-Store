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


@WebServlet("/ProductCatalogueServlet")
public class ProductCatalogueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/JSPs/product-catalogue.jsp";
		ArrayList<Product> products = DbAssistant.getProducts();
		int counter = 1;
		for(Product p: products) {
			request.setAttribute("product" + counter, p);
			counter++;
		}
		
		
		request.getRequestDispatcher(address).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
