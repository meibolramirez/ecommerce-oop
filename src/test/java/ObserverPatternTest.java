import com.puppawshop.ecommerce.model.Customer;
import com.puppawshop.ecommerce.notification.OrderStatusNotifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObserverPatternTest {

    private OrderStatusNotifier notifier;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        notifier = new OrderStatusNotifier();
        customer = new Customer(1, "Test User", "test@example.com", "password123");
    }

    @Test
    public void testObserverReceivesNotification() {
        notifier.addObserver(customer);

        notifier.notifyObservers("New order update");

        assertTrue(customer.getNotifications().contains("New order update"), 
                   "Customer should have received the notification.");
    }
}
