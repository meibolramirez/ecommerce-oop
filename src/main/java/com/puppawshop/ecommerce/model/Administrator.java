package com.puppawshop.ecommerce.model;

public class Administrator extends User{
	public Administrator(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public void manageInventory() {
        System.out.println(getName() + " está trabajando el invetario");
    }

    public void setPromotion(String productName, double discountPercent) {
        System.out.println(getName() + " aplicó un " + discountPercent + "% de descuento sobre " + productName);
    }

    @Override
    public String toString() {
        return "Administrator: " + super.toString();
    }

}
