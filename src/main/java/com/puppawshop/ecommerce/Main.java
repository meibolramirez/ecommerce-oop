package com.puppawshop.ecommerce;
import java.util.ArrayList;
import java.util.List;
import com.puppawshop.ecommerce.model.*;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Ecommerce OOP - Pup Paw Shop!\n");

		// Instancias de Product
		Product product1 = new PhysicalProduct(1, "Harnes", "Harnes largo para perros", 999.99, 5, 0.3, "50x30x20cm");
		Product product2 = new DigitalProduct(2, "Correa", "Correa mediana para perros", 95.99, 10, "PDF", 3.5);
		
		List<Product> productList = new ArrayList<>();
		productList.add(product1);
		productList.add(product2);

		// Polimorfismo
		System.out.println("\nClase Product:");
		for (Product p : productList) {
		    p.displayDetails();
		}
		
		
		
		// User
		User user = new User(1, "Mabel Ramirez", "mramirez@test.com", "securePassword");
		System.out.println("\nClase User:");
		System.out.println(user);
		System.out.println();
		
		// Cart
		Cart cart = new Cart();
		System.out.println("Clase Cart:");
		cart.addProduct(product1);
		cart.addProduct(product2);
		System.out.println("\n" + cart + "\n");

		cart.removeProduct(product1);
		System.out.println("\n" + cart);

		// Customer
		Customer customer = new Customer(1, "Melissa", "melissa@example.com", "password123");
		customer.addPurchase("E-Book: El encantador de perros");
		customer.addPurchase("Harnes Mediano");
		customer.addPreference("Accesorios");
		customer.addPreference("E-Books");

		System.out.println("\nCliente:");
		System.out.println(customer);
		System.out.println();
		
		// Administrator
		Administrator admin = new Administrator(2, "Jane", "admin@example.com", "adminpass");
		admin.manageInventory();
		admin.setPromotion("Correa", 15.0);

		System.out.println("\nUsuario Admin:");
		System.out.println(admin);
		System.out.println();
	}
}
