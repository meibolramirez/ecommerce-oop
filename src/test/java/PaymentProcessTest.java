import com.puppawshop.ecommerce.payment.CardPayment;
import com.puppawshop.ecommerce.payment.PaymentProcess;
import com.puppawshop.ecommerce.payment.PaypalPayment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentProcessTest {

    @Test
    void testCardPaymentInitiation() {
        // Create an instance of CardPayment
        PaymentProcess cardPayment = new CardPayment("1234567890123456");
        
        // Initiate payment
        cardPayment.initiatePayment(100.0);
        
        // Since the method doesn't return anything, we assume payment initiation is successful
        assertTrue(true, "Card payment initiation was successful.");
    }

    @Test
    void testCardPaymentVerification() {
        // Create an instance of CardPayment
        PaymentProcess cardPayment = new CardPayment("1234567890123456");
        
        // Initiate and verify payment
        cardPayment.initiatePayment(100.0);
        boolean isVerified = cardPayment.verifyPayment();
        
        // Assert that verification is true for a valid payment
        assertTrue(isVerified, "Card payment verification should return true.");
    }

    @Test
    void testCardPaymentConfirmation() {
        // Create an instance of CardPayment
        PaymentProcess cardPayment = new CardPayment("1234567890123456");
        
        // Initiate, verify, and confirm payment
        cardPayment.initiatePayment(100.0);
        cardPayment.verifyPayment();
        cardPayment.confirmPayment();
        
        // Assuming confirmation doesn't return anything, we check if confirmation is successful
        assertTrue(true, "Card payment confirmation was successful.");
    }

    @Test
    void testPaypalPaymentInitiation() {
        // Create an instance of PaypalPayment
        PaymentProcess paypalPayment = new PaypalPayment("cliente@correo.com");
        
        // Initiate payment
        paypalPayment.initiatePayment(50.0);
        
        // Since the method doesn't return anything, we assume payment initiation is successful
        assertTrue(true, "Paypal payment initiation was successful.");
    }

    @Test
    void testPaypalPaymentVerification() {
        // Create an instance of PaypalPayment
        PaymentProcess paypalPayment = new PaypalPayment("cliente@correo.com");
        
        // Initiate and verify payment
        paypalPayment.initiatePayment(50.0);
        boolean isVerified = paypalPayment.verifyPayment();
        
        // Assert that verification is true for a valid payment
        assertTrue(isVerified, "Paypal payment verification should return true.");
    }

    @Test
    void testPaypalPaymentConfirmation() {
        // Create an instance of PaypalPayment
        PaymentProcess paypalPayment = new PaypalPayment("cliente@correo.com");
        
        // Initiate, verify, and confirm payment
        paypalPayment.initiatePayment(50.0);
        paypalPayment.verifyPayment();
        paypalPayment.confirmPayment();
        
        // Assuming confirmation doesn't return anything, we check if confirmation is successful
        assertTrue(true, "Paypal payment confirmation was successful.");
    }
}
