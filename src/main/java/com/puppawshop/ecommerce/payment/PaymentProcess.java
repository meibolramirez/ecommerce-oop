package com.puppawshop.ecommerce.payment;

public interface PaymentProcess {

    void initiatePayment(double amount);

    boolean verifyPayment();

    void confirmPayment();
}
