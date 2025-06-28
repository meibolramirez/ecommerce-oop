package com.puppawshop.ecommerce.config;

public class SystemConfiguration {
    private static SystemConfiguration instance;
    private String currency;

    private SystemConfiguration() {
        this.currency = "DOP";
    }

    public static SystemConfiguration getInstance() {
        if (instance == null) {
            instance = new SystemConfiguration();
        }
        return instance;
    }

    public String getCurrency() {
        return currency;
    }
}
