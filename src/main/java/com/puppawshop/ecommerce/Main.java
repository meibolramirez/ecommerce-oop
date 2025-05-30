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
        
        //Product        
        System.out.println("Clase Product:");
        System.out.println(product1);
        System.out.println(product2);
        System.out.println();
        
        User user = new User(1, "Mabel Ramirez", "mramirez@test.com", "securePassword");
        
        //User 
        System.out.println("Clase User:");
        System.out.println(user);
        System.out.println();
        
        Cart cart = new Cart();
        
        //Cart         
        System.out.println("Clase Cart:");
        cart.addProduct(product1);
        cart.addProduct(product2);
        System.out.println("\n" + cart + "\n");

        cart.removeProduct(product1);
        System.out.println("\n" + cart);
        
        //Tipos de Users
        
        //User Customer
        Customer customer = new Customer(1, "Melissa", "melissa@example.com", "password123");
        customer.addPurchase("E-Book: El encantador de perros");
        customer.addPurchase("Harnes Mediano");
        customer.addPreference("Accesorios");
        customer.addPreference("E-Books");

        System.out.println("\nCliente:");
        System.out.println(customer);
        System.out.println();
        
        //User Admin                
        Administrator admin = new Administrator(2, "Jane", "admin@example.com", "adminpass");
        admin.manageInventory();
        admin.setPromotion("Correa", 15.0);

        System.out.println("\nUsuario Admin:");
        System.out.println(admin);
        System.out.println();
        
        //Tipos de Products
        
        //Producto digital
        DigitalProduct ebook = new DigitalProduct(1001, "eBook de entrenamiento canino", "El encantador de perros", 29.99, 100, "PDF", 5.2);
        System.out.println("Producto Digital:");
        System.out.println(ebook);
        System.out.println();

        // Producto fisico
        PhysicalProduct cama = new PhysicalProduct(1002, "Cama", "cama pequeña para perros", 1300.00, 50, 0.2, "17x11 in");
        System.out.println("Producto Fisico:");
        System.out.println(cama);
        
        

	}

}
