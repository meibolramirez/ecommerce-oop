/**
 * 
 */
package com.puppawshop.ecommerce;

import com.puppawshop.ecommerce.model.*;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Ecommerce OOP - Pup Paw Shop!\n");
		
		Product product1 = new Product(1, "Harnes", "Harnes largo para perros", 999.99, 5);
        Product product2 = new Product(2, "Correa", "Correa mediana para perros", 95.99, 10);
        
        System.out.println("Clase Product:");
        System.out.println(product1);
        System.out.println(product2);
        System.out.println();
        
        User user = new User(1, "Mabel Ramirez", "mramirez@test.com", "securePassword");
        
        System.out.println("Clase User:");
        System.out.println(user);
        System.out.println();
        
        Cart cart = new Cart();
        
        System.out.println("Clase Cart:");
        cart.addProduct(product1);
        cart.addProduct(product2);
        System.out.println("\n" + cart + "\n");

        cart.removeProduct(product1);
        System.out.println("\n" + cart);       
        

	}

}
