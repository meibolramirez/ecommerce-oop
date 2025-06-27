package com.puppawshop.ecommerce.payment;

public class CardPayment implements PaymentProcess {

    private String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void initiatePayment(double amount) {
        System.out.println("Iniciando pago con tarjeta por $" + amount + " usando la tarjeta: " + maskedCard());
    }

    @Override
    public boolean verifyPayment() {
        System.out.println("Verificando pago con tarjeta...");
        return true;
    }

    @Override
    public void confirmPayment() {
        System.out.println("Pago con tarjeta confirmado.");
    }

    private String maskedCard() {
        if (cardNumber.length() >= 4) {
            return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
        }
        return cardNumber;
    }
}
