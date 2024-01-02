package DTO;

public class Product {

    private String productId;
    private String name;
    private String description;
    private String price;
    private String quantity;

    public Product(String productId, String name, String description, String price, String quantity) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}
	
	public String getQunatity() {
		return quantity;
	}

	public void setPrice(String price) {
		this.price = price;
	}

   
}
