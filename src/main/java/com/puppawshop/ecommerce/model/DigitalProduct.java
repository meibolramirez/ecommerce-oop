package com.puppawshop.ecommerce.model;

public class DigitalProduct extends Product{
	private String fileFormat;
    private double fileSize;
    
    public DigitalProduct(int id, String name, String description, double price, int stock, String fileFormat, double fileSize) {
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
    public void displayDetails() {
        System.out.println("Producto Digital:");
        System.out.println(this.toString());
    }


}
    