package com.puppawshop.ecommerce.model;

public abstract class Product {
	
	private int id;
	private String name;
	private String description;
	private double price;
	private int stock;

	public Product(int id, String name, String description, double price, int stock) {
	    this.id = id;
	    this.name = name;
	    this.description = description;
	    this.price = price;
	    this.stock = stock;
	}
	
	public abstract void displayDetails();

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

	public void setPrice(double price) {
	    if (price >= 0) {
	        this.price = price;
	    } else {
	        System.out.println("Error: El precio no puede ser negativo.");
	    }
	}

	public int getStock() {
	    return stock;
	}

	public void setStock(int stock) {
	    if (stock >= 0) {
	        this.stock = stock;
	    } else {
	        System.out.println("Error: El stock no puede ser negativo.");
	    }
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


