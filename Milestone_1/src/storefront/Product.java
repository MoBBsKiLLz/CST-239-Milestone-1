package storefront;

/**
 * Product class
 * @author migg_
 *
 */
public class Product {
	/**
	 * Fields include name (String), description (String) and quantity (int)
	 */
    private String name;
    private String description;
    private int quantity;
    
    /**
     * Product default constructor initiates fields to empty string or 0 respectively. 
     */
    public Product() {
	this.name = "";
	this.description = "";
	this.quantity = 0;
    }
    
    /**
     * Product constructor with parameters name, description and quantity
     * @param name Name parameter of type String
     * @param description Description parameter of type String
     * @param quantity Quantity parameter of type int
     */
    public Product(String name, String description, int quantity) {
	this.name = name;
	this.description = description;
	this.quantity = quantity;
    }

    /**
     * Returns the name of the Product
     * @return Returns the name as a String
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the name of the Product taking a parameter
     * @param name Name parameter as a String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description of the Product
     * @return Returns the description as a String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the Product taking a parameter
     * @param description Description parameter as a String
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
