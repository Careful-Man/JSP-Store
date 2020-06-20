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


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    //this block is executed when the user navigates to the register tab
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String address = "";
		
		if(session.getAttribute("customer") == null) {//if user hasnt logged in
			address = "/WEB-INF/JSPs/register.jsp";
			FormError errors = new FormError();
			errors.setTheErrors("");
			request.setAttribute("printErrors", errors);
		}else {//if user has logged in
			address = "/WEB-INF/JSPs/already-logged-in.jsp";
		}
		
		request.getRequestDispatcher(address).forward(request, response);
	}

	
	
	//this block is executed when the user registers
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "";
		FormError errors = new FormError();
		String temp = "<p class=\"error\">The following error(s) occured: <br>";
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		
		
		if(firstName.trim().equals("") || lastName.trim().equals("") || 
				email.trim() .equals("") || 
				pass1.trim().equals("") || 
				pass2.trim().equals("") || 
				!(pass1.trim().equals(pass2.trim()))) {//if there are empty fields
			
			//show the user which of them are
			if(firstName.trim().equals("")) 
				temp += "You must fill in the field: First Name <br>";
			if (lastName.trim().equals(""))
				temp += "You must fill in the field: Last Name <br>";
			if(email.trim().equals(""))
				temp += "You must fill in the field: E-mail <br>";
			if(pass1.trim().equals(""))
				temp += "You must fill in the field: Password <br>";
			if(pass2.trim().equals(""))
				temp += "You must fill in the field: Confirm Password <br>";
			if(!pass1.trim().equals(pass2.trim()))
				temp += "The two password fields must match <br>";
			
			temp += "Please try again.</p>";
			errors.setTheErrors(temp);
			
			request.setAttribute("printRegisterErrors", errors);
			address = "/WEB-INF/JSPs/register.jsp";		
			
		
		}else if(DbAssistant.isEmailAddressUsed(email)) {//show the user that this email is already in use
			temp += "This email is already in use. <br>";
			temp += "Please try again.</p>";
			errors.setTheErrors(temp);
			
			request.setAttribute("printRegisterErrors", errors);
			address = "/WEB-INF/JSPs/register.jsp";
		}else {//everything is ok! you can register!
			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
			request.setAttribute("email", email);
			utilityClasses.DbAssistant.executeInsertIntoCustomerQuery(
					firstName, 
					lastName, 
					email, 
					pass1);
			
			Customer loggedInCustomer = new Customer();
			loggedInCustomer.setFirstName(DbAssistant.getCustomerField(email, "firstName"));
			loggedInCustomer.setLastName(DbAssistant.getCustomerField(email, "firstName"));
			loggedInCustomer.setEmail(email);
			
			address = "/WEB-INF/JSPs/registered.jsp";
		}

		
		
		//redirect to the right JSP
		request.getRequestDispatcher(address).forward(request, response);
		
		
		
		
	}

}
