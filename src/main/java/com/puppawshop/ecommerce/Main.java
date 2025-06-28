package com.puppawshop.ecommerce;

import java.util.ArrayList;
import java.util.List;

import com.puppawshop.ecommerce.model.*;
import com.puppawshop.ecommerce.inventory.*;
import com.puppawshop.ecommerce.payment.*;
import com.puppawshop.ecommerce.config.SystemConfiguration;
import com.puppawshop.ecommerce.factory.EntityFactory;
import com.puppawshop.ecommerce.notification.OrderStatusNotifier;

public class Main {

    public static void main(String[] args) {

        System.out.println("Ecommerce OOP - Pup Paw Shop!\n");

        // ---------------- Singleton Pattern Test ----------------
        System.out.println("--- Configuración del Sistema (Singleton) ---");
        SystemConfiguration config = SystemConfiguration.getInstance();
        System.out.println("Moneda del sistema: " + config.getCurrency());


        // ---------------- Product Instances ----------------
        Product product1 = new PhysicalProduct(1, "Harnes", "Harnes largo para perros", 999.99, 5, 0.3, "50x30x20cm");
        Product product2 = new DigitalProduct(2, "Correa", "Correa mediana para perros", 95.99, 10, "PDF", 3.5);

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        // ---------------- Polymorphism Test ----------------
        System.out.println("\n--- Productos en Inventario ---");
        for (Product p : productList) {
            p.displayDetails();
        }

        // ---------------- Product Validation Test ----------------
        System.out.println("\n--- Prueba de Validación de Producto ---");
        PhysicalProduct invalidProduct = new PhysicalProduct(3, "Juguete", "Pelota para perros", -10.00, 10, 0.5, "5cm");
        invalidProduct.setPrice(-50);
        invalidProduct.setStock(-2);

        // ---------------- Inventory Management Test ----------------
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

        // ---------------- User Test ----------------
        System.out.println("\n--- Clase User ---");
        User user = new User(1, "Mabel Ramirez", "mramirez@test.com", "securePassword");
        System.out.println(user);

        // User invalid email test
        User invalidUser = new User(99, "Prueba", "correo_invalido", "1234");
        invalidUser.setEmail("correo_invalido");

        // ---------------- Cart Test ----------------
        System.out.println("\n--- Carrito de Compras ---");
        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.addProduct(product2);
        System.out.println("\n" + cart);

        cart.removeProduct(product1);
        System.out.println("\n" + cart);

        // ---------------- Payment Process Test ----------------
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

        // ---------------- Factory Pattern Test ----------------
        System.out.println("\n--- Creación de Entidades con Factory ---");

        Product productoDigital = EntityFactory.createProduct("digital", 100, "eBook Adiestramiento", "Guía para entrenar perros", 19.99, 100);
        Product productoFisico = EntityFactory.createProduct("physical", 101, "Cama para Perros", "Cama cómoda y lavable", 499.99, 20);

        User clienteFactory = EntityFactory.createUser("customer", 200, "Carlos", "carlos@correo.com", "clave123");
        User adminFactory = EntityFactory.createUser("admin", 201, "Laura", "laura@admin.com", "admin456");

        productoDigital.displayDetails();
        productoFisico.displayDetails();
        System.out.println(clienteFactory);
        System.out.println(adminFactory);

        // ---------------- Observer Pattern Test ----------------
        System.out.println("\n--- Notificaciones de Estado de Pedido (Observer) ---");

        Customer customer = new Customer(1, "Melissa", "melissa@example.com", "password123");
        customer.addPurchase("E-Book: El encantador de perros");
        customer.addPreference("Accesorios");

        OrderStatusNotifier notifier = new OrderStatusNotifier();
        notifier.addObserver(customer);

        notifier.notifyObservers("Su pedido ha sido enviado.");
        notifier.notifyObservers("Su pedido ha sido entregado.");

        // ---------------- Administrator Test ----------------
        System.out.println("\n--- Usuario Admin ---");
        Administrator admin = new Administrator(2, "Jane", "admin@example.com", "adminpass");
        admin.manageInventory();
        admin.setPromotion("Correa", 15.0);
        System.out.println(admin);
    }
}
