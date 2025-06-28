package com.puppawshop.ecommerce.factory;

import com.puppawshop.ecommerce.model.*;

public class EntityFactory {

    public static Product createProduct(String type, int id, String name, String description, double price, int stock) {
        if (type.equalsIgnoreCase("physical")) {
            return new PhysicalProduct(id, name, description, price, stock, 0, "N/A");
        } else if (type.equalsIgnoreCase("digital")) {
            return new DigitalProduct(id, name, description, price, stock, "PDF", 1.0);
        }
        throw new IllegalArgumentException("Tipo de producto desconocido: " + type);
    }

    public static User createUser(String type, int id, String name, String email, String password) {
        if (type.equalsIgnoreCase("customer")) {
            return new Customer(id, name, email, password);
        } else if (type.equalsIgnoreCase("admin")) {
            return new Administrator(id, name, email, password);
        }
        throw new IllegalArgumentException("Tipo de usuario desconocido: " + type);
    }
}
