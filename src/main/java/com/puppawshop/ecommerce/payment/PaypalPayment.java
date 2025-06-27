package com.puppawshop.ecommerce.payment;

public class PaypalPayment implements PaymentProcess {

    private String email;

    public PaypalPayment(String email) {
        this.email = email;
    }

    @Override
    public void initiatePayment(double amount) {
        System.out.println("Iniciando pago con PayPal por $" + amount + " para la cuenta: " + email);
    }

    @Override
    public boolean verifyPayment() {
        System.out.println("Verificando pago con PayPal...");
        return true;
    }

    @Override
    public void confirmPayment() {
        System.out.println("Pago con PayPal confirmado.");
    }
}
