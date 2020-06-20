package beanClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

//Customer bean class; just field declaration, getters and setters
public class Customer {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String pass;
	
	private ConcurrentHashMap<Product, Integer> customerProducts = new ConcurrentHashMap<>();
	private ArrayList<Product> customerBoughtProducts = new ArrayList<>();

	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getPass() {
		return pass;
	}
	public ConcurrentHashMap<Product, Integer> getCustomerProducts(){
		return customerProducts;
	}
	public ArrayList<Product> getCustomerBoughtProducts(){
		return customerBoughtProducts;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setCustomerBoughtProducts(ArrayList<Product> theArrayList) {
		this.customerBoughtProducts = theArrayList;
	}
	
	
	public void putIntoCustomerProducts(Product theProduct, int quantity){
		customerProducts.put(theProduct, new Integer(quantity));
	}
	
	public float getOrderSum(ConcurrentHashMap<Product, Integer> hashMap) {
		float sum = 0;
		
		for(Product p: hashMap.keySet()) {
			sum += (int) p.getRegularPrice()*hashMap.get(p);
		}
		
		return sum;
	}
	
	
	

}
