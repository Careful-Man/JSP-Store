package utilityClasses;
import beanClasses.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DbAssistant {
	private static ArrayList<Product> products = new ArrayList<>();
	private static ArrayList<Product> productsSortedByPrice = new ArrayList<>();
	private static ArrayList<Product> productsSortedByCategory = new ArrayList<>();
	
	
	
	////////////////////////////////////////////////
	/////////////   REGISTER METHODS   ///////////// 
	////////////////////////////////////////////////
	
	//this method inserts a new customer to the db
	public static void executeInsertIntoCustomerQuery(String firstName, String lastName, String email, String pass) {
		System.out.println("\n###########################################################\n");
		try {//connects to JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Step 1: driver loading for executeInsertIntoCustomerQuery method was successful.");
		} catch (ClassNotFoundException e) {
			System.out.println("Step 1: driver loading for executeInsertIntoCustomerQuery method error:\n" + e.getMessage());
		}
		try {//executes the query
			DriverManager.getConnection("jdbc:mysql://127.0.0.1/final_project_db", "root", "").
			createStatement().
			executeUpdate("INSERT INTO customer (firstName, lastName, email, pass) VALUES ('" + firstName + "', '" + lastName + "', '" + email + "', SHA1('" + pass + "'))");
			System.out.println("Step 2: connection for executeInsertIntoCustomerQuery method established.");
		}catch (SQLException e) {
			System.out.println("Step 2: connection for executeInsertIntoCustomerQuery method could not be established:\n" + e.getMessage());
		}
	}

	//this method checks if the email a user typed is already in use
	public static boolean isEmailAddressUsed(String email) {
		System.out.println("\n###########################################################\n");
		try {//connects to JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Step 1: driver loading for isEmailAddressUsed method was successful.");
		} catch (ClassNotFoundException e) {
			System.out.println("Step 1: driver loading for isEmailAddressUsed method error:\n" + e.getMessage());
		}
		try {//executes the query
			if(
				DriverManager.getConnection("jdbc:mysql://127.0.0.1/final_project_db", "root", "").
				createStatement().
				executeQuery("SELECT email FROM customer WHERE email='" + email.trim() + "'").next()) {
				System.out.println("Step 2: connection for isEmailAddressUsed method established.");
				return true;
			}
			return false;
		}catch (SQLException e) {
			System.out.println("Step 2: connection for isEmailAddressUsed method could not be established:\n" + e.getMessage());
		}
		return true;//default value; address is being used.
	}
	
	
	
	////////////////////////////////////////////////
	/////////////   PRODUCT  METHODS   ///////////// 
	////////////////////////////////////////////////
	
	//this method gets the products from the db
	public static ArrayList<Product> getProducts(){
		System.out.println("\n###########################################################\n");
		try {//connects to JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Step 1: driver loading for getProducts method was successful.");
		} catch (ClassNotFoundException e) {
			System.out.println("Step 1: driver loading for getProducts method error:\n" + e.getMessage());
		}
		try {//executes the query
			Statement statement = DriverManager.getConnection("jdbc:mysql://127.0.0.1/final_project_db", "root", "").createStatement();
			ResultSet result = statement.executeQuery("SELECT " + 
														"id, " + 
														"name, " + 
														"shortDesc, " + 
														"longDesc, " + 
														"stock, " + 
														"salePrice, " + 
														"regularPrice, " + 
														"category, " + 
														"image " +
														"FROM product");
			System.out.println("Step 2: connection for getProducts method established.");
			while(result.next()) {
				Product p = new Product();
				p.setId(result.getInt("id"));
				p.setName(result.getString("name"));
				p.setShortDesc(result.getString("shortDesc"));
				p.setLongDesc(result.getString("longDesc"));
				p.setStock(result.getInt("stock"));
				p.setSalePrice(result.getInt("salePrice"));
				p.setRegularPrice(result.getInt("regularPrice"));
				p.setCategory(result.getString("category"));
				p.setImage(result.getString("image"));
				if(p.getSalePrice() != 0) //if product is on sale, add a message to shortDesc
					p.setShortDesc(p.getShortDesc() + "<br>This product is on sale!");
				else {//else leave it as is
					p.setShortDesc(p.getShortDesc() + "<br>&nbsp;");
					p.setSalePrice(p.getRegularPrice());
				}
				products.add(p);
			}
			return products;
		}catch (SQLException e) {
			System.out.println("Step 2: connection could not be established:\n" + e.getMessage());
			products.add(new Product());
			return products;//if something goes wrong returns an ArrayList with an empty product
		}
	}

	
	//returns products sorted by givenOrder
	public static ArrayList<Product> getProductsSorted(String givenOrder, String givenSortField) {
		System.out.println("\n###########################################################\n");
		try {//connects to JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Step 1: driver loading for getProductsSorted method was successful.");
		} catch (ClassNotFoundException e) {
			System.out.println("Step 1: driver loading for getProductsSorted method error:\n" + e.getMessage());
		}
		try {//executes the query
			System.out.println("Step 2: connection established.");
			ResultSet result = DriverManager.getConnection("jdbc:mysql://127.0.0.1/final_project_db", "root", "").createStatement().
									executeQuery("SELECT " + 
													"id, " + 
													"name, " + 
													"shortDesc, " + 
													"longDesc, " + 
													"stock, " + 
													"salePrice, " + 
													"regularPrice, " + 
													"category, " + 
													"image "+
													"FROM product ORDER BY " + givenOrder);
			while(result.next()) {
				Product p = new Product();
				p.setId(result.getInt("id"));
				p.setName(result.getString("name"));
				p.setShortDesc(result.getString("shortDesc"));
				p.setLongDesc(result.getString("longDesc"));
				p.setStock(result.getInt("stock"));
				p.setSalePrice(result.getInt("salePrice"));
				p.setRegularPrice(result.getInt("regularPrice"));
				p.setCategory(result.getString("category"));
				p.setImage(result.getString("image"));
				if(p.getSalePrice() != 0) //if product is on sale, add a message to shortDesc
					p.setShortDesc(p.getShortDesc() + "<br>This product is on sale!");
				else //else leave it as is
					p.setShortDesc(p.getShortDesc() + "<br>&nbsp;");
				if(givenSortField.equals("price"))
					productsSortedByPrice.add(p);
				else if(givenSortField.equals("category")) 
					productsSortedByCategory.add(p);
			}
			if(givenSortField.equals("price"))
				return productsSortedByPrice;
			else  
				return productsSortedByCategory;
		}catch (SQLException e) {
			System.out.println("Step 2: connection could not be established:\n" + e.getMessage());
			if(givenSortField.equals("price")) {
				productsSortedByPrice.add(new Product());
				return productsSortedByPrice;
			}else {
				productsSortedByCategory.add(new Product());
				return productsSortedByCategory;
			}
		}
	}
	
	
	//returns a product's stock by id
	public static int getProductStock(int productId) {
		System.out.println("\n###########################################################\n");
		try {//connects to JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Step 1: driver loading for getProductStock method was successful.");
		} catch (ClassNotFoundException e) {
			System.out.println("Step 1: driver loading for getProductStock method error:\n" + e.getMessage());
		}
		try {//executes the query
			ResultSet result = DriverManager.getConnection("jdbc:mysql://127.0.0.1/final_project_db", "root", "").createStatement().executeQuery("SELECT stock FROM product WHERE id='" + productId + "'");
			System.out.println("Step 2: connection for getProductStock method established.");
			if(result.next()) 
				return  result.getInt("stock");
		}catch (SQLException e) {
				System.out.println("Step 2: connection for getProductStock method could not be established:\n" + e.getMessage());
		}
		return 0;//if product is not found, return stock 0
	}
	
	
	//this method removes the input quantity from the product in the db
	public static void removeQuantityFromStock(int productId, int quantity) {
		System.out.println("\n###########################################################\n");
		try {//connects to JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Step 1: driver loading for removeQuantityFromStock method was successful.");
		} catch (ClassNotFoundException e) {
			System.out.println("Step 1: driver loading for removeQuantityFromStock method error:\n" + e.getMessage());
		}
		try {//executes the query
			DriverManager.getConnection("jdbc:mysql://127.0.0.1/final_project_db", "root", "").
			createStatement().
			executeUpdate("UPDATE product SET stock = '" + (getProductStock(productId) - quantity) + "' WHERE product.id = " + productId);
			System.out.println("Step 2: connection for removeQuantityFromStock method established.");
		}catch (SQLException e) {
				System.out.println("Step 2: connection for removeQuantityFromStock method could not be established:\n" + e.getMessage());
		}
	}
	
	
	//insert into customer_buys_product if the customer hasn't bought it already
	public static void customerBuysProduct(int customerId, int productId) {
		System.out.println("\n###########################################################\n");
		Connection con;
		try {//connects to JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Step 1: driver loading for customerBuysProduct method was successful.");
		} catch (ClassNotFoundException e) {
			System.out.println("Step 1: driver loading for customerBuysProduct method error:\n" + e.getMessage());
		}
		try {//executes the query
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/final_project_db", "root", "");
			System.out.println("Step 2: connection for customerBuysProduct method established.");
			Statement statement = con.createStatement();
			String condition = "SELECT cbpid FROM customer_buys_product WHERE customerId='" + customerId +"' AND productId='" + productId +"';";
			ResultSet conditionStatement = statement.executeQuery(condition);
			if(!conditionStatement.next()) {//if the customer hasn't bought it already
				String theQuery = "INSERT INTO customer_buys_product (customerId, productId) VALUES ('" + customerId + "', '" + productId + "');";
				statement.executeUpdate(theQuery);
			}
		}catch (SQLException e) {
			System.out.println("Step 2: connection for customerBuysProduct method could not be established:\n" + e.getMessage());
		}
	}
	
	
	//this method returns the products the logged in customer has bought
	public static ArrayList<Product> getBoughtProducts(int customerId){
		System.out.println("\n###########################################################\n");
		ArrayList<Product> boughtProducts = new ArrayList<>();
		try {//connects to JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Step 1: driver loading for getBoughtProducts method was successful.");
		} catch (ClassNotFoundException e) {
			System.out.println("Step 1: driver loading for getBoughtProducts method error:\n" + e.getMessage());
		}
		try {//executes the query
			System.out.println("Step 2: connection for getBoughtProducts method established.");
			ResultSet result = DriverManager.getConnection("jdbc:mysql://127.0.0.1/final_project_db", "root", "").
					createStatement().
					executeQuery("SELECT " +
							"id, " + 
							"name, " + 
							"shortDesc, " + 
							"longDesc, " + 
							"stock, " + 
							"salePrice, " + 
							"regularPrice, " + 
							"category, " + 
							"image " +
							"FROM product JOIN customer_buys_product ON product.id=productId AND customerId=" + customerId);
			while(result.next()) {
				Product p = new Product();
				p.setId(result.getInt("id"));
				p.setName(result.getString("name"));
				p.setShortDesc(result.getString("shortDesc"));
				p.setLongDesc(result.getString("longDesc"));
				p.setStock(result.getInt("stock"));
				p.setSalePrice(result.getInt("salePrice"));
				p.setRegularPrice(result.getInt("regularPrice"));
				p.setCategory(result.getString("category"));
				p.setImage(result.getString("image"));
				if(p.getSalePrice() != 0) //if product is on sale, add a message to shortDesc
					p.setShortDesc(p.getShortDesc() + "<br>This product is on sale!");
				else //else leave it as is
					p.setShortDesc(p.getShortDesc() + "<br>&nbsp;");
				boughtProducts.add(p);
			}
			return boughtProducts;
		}catch (SQLException e) {
			System.out.println("Step 2: connection for getBoughtProducts method could not be established:\n" + e.getMessage());
			boughtProducts.add(new Product());
			return boughtProducts;//default value
		}
	}
	
	
	
	////////////////////////////////////////////////
	/////////////    LOGIN   METHODS   ///////////// 
	////////////////////////////////////////////////
	
	//this method checks if login email and pass match
	public static boolean isPasswordCorrect(String email, String pass) {
		System.out.println("\n###########################################################\n");
		try {//connects to JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Step 1: driver loading for isPasswordCorrect method was successful.");
		} catch (ClassNotFoundException e) {
			System.out.println("Step 1: driver loading for isPasswordCorrect method error:\n" + e.getMessage());
		}
		try {//executes the query
			Statement statement = DriverManager.getConnection("jdbc:mysql://127.0.0.1/final_project_db", "root", "").createStatement();
			System.out.println("Step 2: connection for isPasswordCorrect method established.");
			if(statement.executeQuery("SELECT email FROM customer WHERE email='" + email.trim() + "' AND pass=SHA1('" + pass + "')").next()) 
				return true;
			return false;
		}catch (SQLException e) {
			System.out.println("Step 2: connection for isPasswordCorrect method could not be established:\n" + e.getMessage());
		}
		return true;
	}
	
	
	//this method returns the requested field (firstName, lastName etc) of the logged in customer
	public static String getCustomerField(String email, String field) {
		System.out.println("\n###########################################################\n");
		try {//connects to JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Step 1: driver loading for getCustomerField method was successful.");
		} catch (ClassNotFoundException e) {
			System.out.println("Step 1: driver for getCustomerField method loading error:\n" + e.getMessage());
		}
		try {//executes the query
			ResultSet result = DriverManager.getConnection("jdbc:mysql://127.0.0.1/final_project_db", "root", "").
					createStatement().
					executeQuery("SELECT " + field + " FROM customer WHERE email='" + email + "'");
			System.out.println("Step 2: connection for getCustomerField method established.");
			if(result.next()) 
				return result.getString(field);
		}catch (SQLException e) {
			System.out.println("Step 2: connection for getCustomerField method could not be established:\n" + e.getMessage());
		}
		return "0";//a default value; just in case.
	}
	
	
}