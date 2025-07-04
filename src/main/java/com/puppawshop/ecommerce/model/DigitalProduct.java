package com.puppawshop.ecommerce.model;

import com.puppawshop.ecommerce.exceptions.InvalidProductException;

public class DigitalProduct extends Product{
	private String fileFormat;
    private double fileSize;
    
    public DigitalProduct(int id, String name, String description, double price, int stock, String fileFormat, double fileSize) throws InvalidProductException {
        super(id, name, description, price, stock);
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
    }
    
    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }
    

    @Override
    public String toString() {
        return super.toString() + String.format(", Formato del archivo: %s, Tamañod del archivo: %.2f MB", fileFormat, fileSize, "\n");
    }
    
    @Override
    public String displayDetails() {
        // Return the product details as a string instead of printing it
        return "Producto Digital:\n" + this.toString();
    }


}
    