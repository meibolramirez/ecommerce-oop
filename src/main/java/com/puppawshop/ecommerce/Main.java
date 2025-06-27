package com.puppawshop.ecommerce;
import java.util.ArrayList;
import java.util.List;
import com.puppawshop.ecommerce.model.*;
import com.puppawshop.ecommerce.inventory.*;
import com.puppawshop.ecommerce.payment.*;

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
		
		// Product precio negativo
		PhysicalProduct invalidProduct = new PhysicalProduct(3, "Juguete", "Pelota para perros", -10.00, 10, 0.5, "5cm");
		invalidProduct.setPrice(-50);
		invalidProduct.setStock(-2);
		
		System.out.println("\n--- Gestión de Inventario Físico ---");
		PhysicalInventoryManager physicalInventory = new PhysicalInventoryManager();
		PhysicalProduct cama2 = new PhysicalProduct(2002, "Transportadora", "Transportadora plástica para perros pequeños", 950.00, 20, 1.5, "50x35x35 cm");

		physicalInventory.addProduct(cama2);
		physicalInventory.updateStock(cama2, 18);
		physicalInventory.removeProduct(cama2);

		System.out.println("\n--- Gestión de Inventario Digital ---");
		DigitalInventoryManager digitalInventory = new DigitalInventoryManager();
		DigitalProduct cursoOnline = new DigitalProduct(4001, "Curso de Adiestramiento", "Curso online interactivo", 59.99, 50, "MP4", 2000);

		digitalInventory.addProduct(cursoOnline);
		digitalInventory.updateStock(cursoOnline, 45);
		digitalInventory.removeProduct(cursoOnline);

		
		// User
		User user = new User(1, "Mabel Ramirez", "mramirez@test.com", "securePassword");
		System.out.println("\nClase User:");
		System.out.println(user);
		System.out.println();
		
		// User con formato no valido de email
		User invalidUser = new User(99, "Prueba", "correo_invalido", "1234");
		invalidUser.setEmail("correo_invalido"); 
		
		// Cart
		Cart cart = new Cart();
		System.out.println("Clase Cart:");
		cart.addProduct(product1);
		cart.addProduct(product2);
		System.out.println("\n" + cart + "\n");

		cart.removeProduct(product1);
		System.out.println("\n" + cart);
		
		//Payment
		System.out.println("\n--- Procesamiento de Pago con Tarjeta ---");
		PaymentProcess cardPayment = new CardPayment("1234567890123456");
		cardPayment.initiatePayment(99.99);
		if (cardPayment.verifyPayment()) {
		    cardPayment.confirmPayment();
		}

		System.out.println("\n--- Procesamiento de Pago con PayPal ---");
		PaymentProcess paypalPayment = new PaypalPayment("cliente@correo.com");
		paypalPayment.initiatePayment(49.99);
		if (paypalPayment.verifyPayment()) {
		    paypalPayment.confirmPayment();
		}


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
