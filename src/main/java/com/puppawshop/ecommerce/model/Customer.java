package com.puppawshop.ecommerce.model;

import java.util.ArrayList;
import java.util.List;
import com.puppawshop.ecommerce.notification.Observer;

public class Customer extends User implements Observer {

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

    private List<String> notifications = new ArrayList<>();

    @Override
    public void update(String message) {
        notifications.add(message);
        System.out.println("Notificación para " + getName() + ": " + message);
    }

    public List<String> getNotifications() {
        return notifications;
    }


    @Override
    public String toString() {
        return "Customer: " + super.toString() + ", Compras: " + purchaseHistory + ", Preferencias: " + preferences;
    }
}
