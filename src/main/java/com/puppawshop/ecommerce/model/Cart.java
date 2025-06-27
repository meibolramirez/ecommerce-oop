package com.puppawshop.ecommerce.model;
import java.util.ArrayList;
import java.util.List;


public class Cart {
	
	private List<Product> products;
    private double total;
    
    public Cart() {
        this.products = new ArrayList<>();
        this.total = 0.0;
    }
    
    public void addProduct(Product product) {
        products.add(product);
        calculateTotal();
        System.out.println(product.getName() + " agregado al carrito.");
    }
    
    // Overloading Product
    public void addProduct(int id, String name, String description, double price, int stock, String fileFormat, double fileSize) {
        Product p = new DigitalProduct(id, name, description, price, stock, fileFormat, fileSize);
        addProduct(p);
    }

    // Overloading Product
    public void addProduct(int id, String name, String description, double price, int stock, double weight, String dimensions) {
        Product p = new PhysicalProduct(id, name, description, price, stock, weight, dimensions);
        addProduct(p);
    }
    
    public void removeProduct(Product product) {
        if (products.remove(product)) {
            calculateTotal();
            System.out.println(product.getName() + " eliminado del carrito.");
        } else {
            System.out.println("Producto no encontrado en el carrito.");
        }
    }
    
    public void calculateTotal() {
        total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
    }
    
    public List<Product> getProducts() {
        return products;
    }

    public double getTotal() {
        return total;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Carrito de compras:\n");
        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }
        sb.append("Total: $").append(String.format("%.2f", total));
        return sb.toString();
    }

}