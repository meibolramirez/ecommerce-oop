package com.puppawshop.ecommerce.model;

import com.puppawshop.ecommerce.exceptions.InvalidProductException;

public class PhysicalProduct extends Product{
	
	private double weight; // Kg
    private String dimensions; // LxWxH

    public PhysicalProduct(int id, String name, String description, double price, int stock, double weight, String dimensions) throws InvalidProductException {
        super(id, name, description, price, stock);
        this.weight = weight;
        this.dimensions = dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Peso: %.2f kg, Dimensiones: %s", weight, dimensions, "\n");
    }
    
    @Override
    public String displayDetails() {
        return "Producto Físico:\n" + this.toString();
    }


}
