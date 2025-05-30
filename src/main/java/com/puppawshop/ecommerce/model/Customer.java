package com.puppawshop.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
	private List<String> purchaseHistory;
    private List<String> preferences;

    public Customer(int id, String name, String email, String password) {
        super(id, name, email, password);
        this.purchaseHistory = new ArrayList<>();
        this.preferences = new ArrayList<>();
    }

    public List<String> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void addPurchase(String productName) {
        purchaseHistory.add(productName);
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void addPreference(String preference) {
        preferences.add(preference);
    }

    @Override
    public String toString() {
        return super.toString() + ", Compras: " + purchaseHistory + ", Preferencias: " + preferences;
    }

}
