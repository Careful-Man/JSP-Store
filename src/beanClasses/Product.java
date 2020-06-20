package beanClasses;


//Product bean class; just field declaration, getters and setters
public class Product{
	
	private int id;
	private String name;
	private String shortDesc;
	private String longDesc;
	private int stock;
	private int salePrice;
	private int regularPrice;
	private String category;
	private String image;
	
	private String hrColor;
	
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	public int getStock() {
		return stock;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public int getRegularPrice() {
		return regularPrice;
	}
	public String getCategory() {
		return category;
	}
	public String getImage() {
		return image;
	}
	public String getHrColor() {
		return hrColor;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public void setRegularPrice(int regularPrice) {
		this.regularPrice = regularPrice;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setHrColor(String hrColor) {
		this.hrColor = hrColor;
	}
	
	

	
	
	

}
