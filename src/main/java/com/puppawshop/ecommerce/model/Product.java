package com.puppawshop.ecommerce.model;
import com.puppawshop.ecommerce.exceptions.InvalidProductException;


public abstract class Product {
	
	private int id;
	private String name;
	private String description;
	private double price;
	private int stock;
	
	public Product(int id, String name, String description, double price, int stock) throws InvalidProductException {
	    if (price < 0) {
	        throw new InvalidProductException("El precio no puede ser negativo.");
	    }
	    if (stock < 0) {
	        throw new InvalidProductException("El stock no puede ser negativo.");
	    }
	    this.id = id;
	    this.name = name;
	    this.description = description;
	    this.price = price;
	    this.stock = stock;
	}
	
	public abstract String displayDetails();

	public int getId() {
	    return id;
	}

	public void setId(int id) {
	    this.id = id;
	}

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
	    this.description = description;
	}

	public double getPrice() {
	    return price;
	}

	public void setPrice(double price) throws InvalidProductException {
	    if (price < 0) {
	        throw new InvalidProductException("El precio no puede ser negativo.");
	    }
	    this.price = price;
	}

	public int getStock() {
	    return stock;
	}

	public void setStock(int stock) throws InvalidProductException {
	    if (stock < 0) {
	        throw new InvalidProductException("El stock no puede ser negativo.");
	    }
	    this.stock = stock;
	}
	
	@Override
	public String toString() {
	    return "Producto {" +
	           "ID=" + id +
	           ", Nombre='" + name + '\'' +
	           ", Descripción='" + description + '\'' +
	           ", Precio=$" + price +
	           ", Disponible=" + stock +
	           '}';
	}
}


