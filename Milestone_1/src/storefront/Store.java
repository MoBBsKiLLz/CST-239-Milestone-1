package storefront;

import java.util.ArrayList;

public class Store {
    private ArrayList<Product> inventory;
    private ArrayList<Product> shoppingCart;
    
    public Store(){
	inventory = new ArrayList<Product>();
	shoppingCart = new ArrayList<Product>();
    }
    
    public Store(String type, ArrayList<Product> inventory, ArrayList<Product> shoppingCart) {
	this.inventory = inventory;
	this.shoppingCart = shoppingCart;
    }

    public ArrayList<Product> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Product> inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    
    public boolean addToCart(String productName, int quantity) {
		// Loop through inventory
		for(int i = 0; i < inventory.size(); i++) {
		    if(inventory.get(i).getName().compareTo(productName) == 0) {
				if(inventory.get(i).getQuantity() >= quantity) {
				    if(shoppingCart.size() > 0) {
						// Loop through shoppingCart
						for(int s = 0; s < shoppingCart.size(); s++) {
						    if(shoppingCart.get(s).getName().compareTo(productName) == 0) {
								shoppingCart.get(s).setQuantity(shoppingCart.get(s).getQuantity() + quantity);
								return true;
						    } 
						}
						
						Product newProduct = new Product();
						newProduct.setName(productName);
						newProduct.setQuantity(quantity);
						newProduct.setDescription(inventory.get(i).getDescription());
						shoppingCart.add(newProduct);
						return true;
				    }
				    else {
				    	Product newProduct = new Product();
						newProduct.setName(productName);
						newProduct.setQuantity(quantity);
						newProduct.setDescription(inventory.get(i).getDescription());
						shoppingCart.add(newProduct);
						return true;
				    }
				}
				else {
				    System.out.println("The quantity entered exceeds the inventory quantity of " + 
					    inventory.get(i).getQuantity() + ".");
				    System.out.println();
				}
		    }
		}
		
		return false;
    }
    
    public boolean removeFromCart(String productName, int quantity) {
    	if (shoppingCart.size() > 0) {
    		// Loop through shoppingCart
			for(int s = 0; s < shoppingCart.size(); s++) {
			    Product currentProduct = shoppingCart.get(s);
			    if(currentProduct.getName().compareTo(productName) == 0) {
					if(currentProduct.getQuantity() == quantity) {
					    shoppingCart.remove(s);
					    System.out.println("Item removed from shopping cart.");
					    return true;
					}
					else if (currentProduct.getQuantity() > quantity) {
					    currentProduct.setQuantity(currentProduct.getQuantity() + quantity);
					    System.out.println("Item removed from shopping cart.");
					    return true;
					}
			    }
			}
    	}
    	else {
    		System.out.println();
    		System.out.println("Shopping cart is empty.");
    		return false;
    	}
    	
    	System.out.println();
    	System.out.println("Product was not found.");
    	return false;
    }
    
    public ArrayList<Product> purchase() {
	ArrayList<Product> receipt = new ArrayList<Product>();
	shoppingCart.forEach(cart ->{
		receipt.add(cart);
	});
	
	if(shoppingCart.size() > 0) {
	    // Loop through shoppingCart
	    for(int s = 0; s < shoppingCart.size(); s++) {
	    	// Loop through inventory
	    	for(int i = 0; i < inventory.size(); i++) {
	    	    Product currentSC = shoppingCart.get(s);
	    	    Product currentInv = inventory.get(i);
	    	    // Check if product name matches
	    	    if(currentSC.getName() == currentInv.getName()) {
	    	    	// Set the new inventory product quantity based on the quantity being purchased
	    	    	currentInv.setQuantity(currentInv.getQuantity() - currentSC.getQuantity());
	    	    }
	    	}
	    }
		
	    // Clear the shopping cart
	    shoppingCart.clear();
	    
	    System.out.println("Purchase successful!");
	    
	    return receipt;
	}
	else {
	    System.out.println("Shopping cart is empty.");
	    return null;
	}
	
	
	
	
    }
    
    public boolean cancel(ArrayList<Product> receipt) {
	boolean result = false;
	// Loop through receipt
	for(int r = 0; r < receipt.size(); r++) {
	    // Loop through inventory
	    for(int i = 0; i < inventory.size(); i++) {
		Product currentRec = receipt.get(r);
		Product currentInv = inventory.get(i);
		// Check if product name matches
		if(currentRec.getName() == currentInv.getName()) {
		    // Set the new inventory product quantity based on the quantity being purchased
		    currentInv.setQuantity(currentInv.getQuantity() + currentRec.getQuantity());
		    result = true;
		}
	    }
	}
	
	return result;
    }
}
