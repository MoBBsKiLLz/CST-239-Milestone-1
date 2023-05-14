package app;

import storefront.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreFront {

    public static void main(String[] args) {
	Store myStore = new Store(); // Create new store
	ArrayList<Product> products = new ArrayList<Product>(); // Create new products ArrayList
	ArrayList<Product> receipt = new ArrayList<Product>(); // Create a receipt
	
	// Create 3 products for inventory
	Product product1 = new Product();
	product1.setName("Shirt");
	product1.setDescription("Plain t-shirt with fitted style.");
	product1.setQuantity(7);
	
	Product product2 = new Product();
	product2.setName("Pants");
	product2.setDescription("Jeans with 5 pockets and straight fit.");
	product2.setQuantity(3);
	
	Product product3 = new Product();
	product3.setName("Shoes");
	product3.setDescription("Pair of fashion sneakers.");
	product3.setQuantity(5);
	
	// Add the products to the products array
	products.add(product1);
	products.add(product2);
	products.add(product3);
	
	// Add products to the inventory
	myStore.setInventory(products);
	
	System.out.println("STORE INVENTORY");
	
	// Show the inventory
	myStore.getInventory().forEach(p -> {
	    System.out.println("Product: " + p.getName());
	    System.out.println("Description: " + p.getDescription());
	    System.out.println("Qty: " + p.getQuantity());
	    System.out.println();
	});
	
	// Ask user what they would like to purchase
	Scanner input = new Scanner(System.in);
	
	System.out.println("Enter -1 at any time to end.");
	System.out.print("Enter the product you want to purchase: ");
	String product = input.next();
	
	System.out.println();
	
	if(product.compareTo("-1") != 0) {
	    System.out.print("Enter the quantity you want to purchase: ");
	    String quantity = input.next();
	    
	    System.out.println();
	    
	    if(quantity.compareTo("-1") != 0) {
		while(product.compareTo("-1") != 0 && quantity.compareTo("-1") != 0) {
		    myStore.addToCart(product, Integer.parseInt(quantity));
		    
		    // Ask user if they would like to check-out
		    System.out.print("Would you like to check-out? (Y/N) ");
		    String checkOut = input.next();
		    if(checkOut.toUpperCase().compareTo("Y") == 0) {
				System.out.println();
				receipt = myStore.purchase();
				
				if(receipt != null) {
				    break;
				}
		    }
		    else if (checkOut.compareTo("-1") == 0) {
			break;
		    }
		    
		    System.out.println();
		    
		    // Ask user if they would like to remove an item
		    System.out.print("Would you like to remove a product? (Y/N) ");
		    String remove = input.next();
		    if(remove.toUpperCase().compareTo("Y") == 0) {
				System.out.println();
				
				System.out.print("Enter the name of the product: ");
				product = input.next();
				System.out.println();
				System.out.print("Enter the quantity: ");
				quantity = input.next();
				myStore.removeFromCart(product, Integer.parseInt(quantity));
		    }
		    else if (remove.compareTo("-1") == 0) {
		    	break;
		    }
		    
		    System.out.println();
		    
		    // Ask user if they would like to add another product
		    System.out.print("Would you like to add another product? (Y/N) ");
		    String addProduct = input.next();
		    System.out.println();
		    if(addProduct.toUpperCase().compareTo("Y") == 0) {
				System.out.print("Enter the product you want to purchase: ");
				product = input.next();
				System.out.println();
				System.out.print("Enter the quantity you want to purchase: ");
				quantity = input.next();
				System.out.println();
		    }
		    else if (addProduct.compareTo("-1") == 0) {
		    	break;
		    }
		}
	    }
	}
	
	if (receipt != null && receipt.size() > 0) {
		System.out.println();
		System.out.println("Receipt: ");
		receipt.forEach(r -> {
			System.out.println("Product: " + r.getName() + " Qty: " + r.getQuantity());
		});
		
		System.out.println();
		
	    // The user if they want to cancel their purchase
	    System.out.print("Would you like to cancel your purchase? (Y/N) ");
	    String cancel = input.next();
	    if (cancel.toUpperCase().compareTo("Y") == 0) {
	    	myStore.cancel(receipt);
	    }
	}
	
	System.out.println();
	System.out.println("Goodbye.");
	input.close();
    }

}
