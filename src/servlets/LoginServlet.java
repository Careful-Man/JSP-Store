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
import utilityClasses.DbAssistant;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    //this block gets executed when the user navigates to this page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/JSPs/login.jsp";
		FormError errors = new FormError();
		errors.setTheErrors("");
		request.setAttribute("printErrors", errors);
		request.getRequestDispatcher(address).forward(request, response);
	}

	//this block gets executed when the user tries to login
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "";
		FormError errors = new FormError();
		String temp = "<p class=\"error\">The following error(s) occured: <br>";
		String email = request.getParameter("email").trim();
		
		if(!DbAssistant.isEmailAddressUsed(email) || email == "") {//if email is not registered
			temp += "This email is not registered. You can register by <a href=\"RegisterServlet\">clicking here</a>.";
			address = "/WEB-INF/JSPs/login.jsp";
			errors.setTheErrors(temp);
			request.setAttribute("printLoginErrors", errors);
		}else if(!DbAssistant.isPasswordCorrect(email, request.getParameter("pass"))) {//if pass is wrong
			temp += "This email does not match with this password.<br>";
			temp += "Please try again.";
			address = "/WEB-INF/JSPs/login.jsp";
			errors.setTheErrors(temp);
			request.setAttribute("printLoginErrors", errors);
		}else {//user has successfully logged in
			Customer loggedInCustomer = new Customer();
			loggedInCustomer.setId(Integer.parseInt(DbAssistant.getCustomerField(email, "id")));
			loggedInCustomer.setFirstName(DbAssistant.getCustomerField(email, "firstName"));
			loggedInCustomer.setLastName(DbAssistant.getCustomerField(email, "lastName"));
			loggedInCustomer.setEmail(email);
			loggedInCustomer.setCustomerBoughtProducts(DbAssistant.getBoughtProducts(loggedInCustomer.getId()));
			
			HttpSession session = request.getSession();
			session.setAttribute("customer", loggedInCustomer);
			address = "ProductCatalogueServlet";
		}
		
		
		
		//redirect to the right JSP
		request.getRequestDispatcher(address).forward(request, response);
		
	}

}
