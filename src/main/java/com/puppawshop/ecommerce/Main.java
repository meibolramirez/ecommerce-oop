package com.puppawshop.ecommerce;

import com.puppawshop.ecommerce.config.SystemConfiguration;
import com.puppawshop.ecommerce.model.*;
import com.puppawshop.ecommerce.inventory.DigitalInventoryManager;
import com.puppawshop.ecommerce.inventory.PhysicalInventoryManager;
import com.puppawshop.ecommerce.notification.OrderStatusNotifier;
import com.puppawshop.ecommerce.payment.PaymentProcess;
import com.puppawshop.ecommerce.payment.PaypalPayment;

public class Main {

    public static void main(String[] args) {

        System.out.println("Pup Paw Shop - Ecommerce Demo \n");

        // Show system configuration
        SystemConfiguration config = SystemConfiguration.getInstance();
        System.out.println("Moneda del sistema: " + config.getCurrency() + "\n");

        try {
            // Basic product examples
            Product harness = new PhysicalProduct(1, "Harness", "Comfortable dog harness", 999.99, 5, 0.3, "50x30x20cm");
            Product ebook = new DigitalProduct(2, "Training Guide", "Dog training guide PDF", 59.99, 20, "PDF", 3.0);

            System.out.println("--- Productos Disponibles ---");
            harness.displayDetails();
            ebook.displayDetails();

            // Users
            Customer customer = new Customer(10, "Melissa", "melissa@example.com", "password");
            Administrator admin = new Administrator(20, "Laura", "admin@example.com", "adminpass");

            System.out.println("\n--- Usuarios ---");
            System.out.println(customer);
            System.out.println(admin);

            // Simple inventory management
            PhysicalInventoryManager physicalInventory = new PhysicalInventoryManager();
            physicalInventory.addProduct((PhysicalProduct) harness);
            physicalInventory.updateStock((PhysicalProduct) harness, 4);

            DigitalInventoryManager digitalInventory = new DigitalInventoryManager();
            digitalInventory.addProduct((DigitalProduct) ebook);
            digitalInventory.updateStock((DigitalProduct) ebook, 15);

            // Cart and payment
            Cart cart = new Cart();
            cart.addProduct(harness);
            cart.addProduct(ebook);
            System.out.println("\n--- Carrito de Compras ---");
            System.out.println(cart);

            PaymentProcess payment = new PaypalPayment(customer.getEmail());
            payment.initiatePayment(cart.getTotal());
            if (payment.verifyPayment()) {
                payment.confirmPayment();
            }

            // Notifications
            OrderStatusNotifier notifier = new OrderStatusNotifier();
            notifier.addObserver(customer);
            notifier.notifyObservers("¡Tu pedido ha sido enviado!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
