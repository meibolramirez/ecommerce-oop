import com.puppawshop.ecommerce.model.*;
import com.puppawshop.ecommerce.exceptions.InsufficientInventoryException;
import com.puppawshop.ecommerce.exceptions.InvalidProductException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    @Test
    void testAddProductToCart() throws InvalidProductException, InsufficientInventoryException {
        Cart cart = new Cart();
        Product product1 = new PhysicalProduct(1, "Harnes", "Harnes largo para perros", 999.99, 5, 0.3, "50x30x20cm");

        cart.addProduct(product1);

        assertEquals(1, cart.getProducts().size(), "Cart should contain 1 product.");
        assertEquals(999.99, cart.getTotal(), "Cart total should be 999.99.");
    }

    @Test
    void testAddMultipleProductsToCart() throws InvalidProductException, InsufficientInventoryException {
        Cart cart = new Cart();
        Product product1 = new PhysicalProduct(1, "Harnes", "Harnes largo para perros", 999.99, 5, 0.3, "50x30x20cm");
        Product product2 = new DigitalProduct(2, "Correa", "Correa mediana para perros", 95.99, 10, "PDF", 3.5);

        cart.addProduct(product1);
        cart.addProduct(product2);

        assertEquals(2, cart.getProducts().size(), "Cart should contain 2 products.");
        assertEquals(1095.98, cart.getTotal(), "Cart total should be 1095.98.");
    }

    @Test
    void testAddProductWithOverloadedMethod() throws InvalidProductException, InsufficientInventoryException {
        Cart cart = new Cart();

        // Using overloaded method for DigitalProduct
        cart.addProduct(100, "E-Book", "Guía para entrenar perros", 19.99, 50, "PDF", 15.0);
        // Using overloaded method for PhysicalProduct
        cart.addProduct(101, "Cama para Perros", "Cama cómoda y lavable", 499.99, 20, 1.5, "60x40x30cm");

        assertEquals(2, cart.getProducts().size(), "Cart should contain 2 products.");
        assertEquals(519.98, cart.getTotal(), "Cart total should be 519.98.");
    }

    @Test
    void testRemoveProductFromCart() throws InvalidProductException, InsufficientInventoryException {
        Cart cart = new Cart();
        Product product1 = new PhysicalProduct(1, "Harnes", "Harnes largo para perros", 999.99, 5, 0.3, "50x30x20cm");
        Product product2 = new DigitalProduct(2, "Correa", "Correa mediana para perros", 95.99, 10, "PDF", 3.5);

        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.removeProduct(product1);

        assertEquals(1, cart.getProducts().size(), "Cart should contain 1 product.");
        assertEquals(95.99, cart.getTotal(), "Cart total should be 95.99.");
    }

    @Test
    void testAddProductWithInsufficientStock() throws InvalidProductException {
        Cart cart = new Cart();
        Product product1 = new PhysicalProduct(1, "Harnes", "Harnes largo para perros", 999.99, 0, 0.3, "50x30x20cm");

        // Use a try-catch block to verify that the exception is thrown
        try {
            cart.addProduct(product1);
            fail("Expected InsufficientInventoryException to be thrown.");
        } catch (InsufficientInventoryException e) {
            assertEquals("No hay inventario disponible para Harnes", e.getMessage(), "Exception message should match.");
        }

        assertEquals(0, cart.getProducts().size(), "Cart should contain no products when adding a product with insufficient stock.");
        assertEquals(0.00, cart.getTotal(), "Cart total should be 0 when no product is added due to insufficient stock.");
    }

    @Test
    void testToStringOverride() throws InvalidProductException, InsufficientInventoryException {
        Cart cart = new Cart();
        Product product1 = new PhysicalProduct(1, "Harnes", "Harnes largo para perros", 999.99, 5, 0.3, "50x30x20cm");
        Product product2 = new DigitalProduct(2, "Correa", "Correa mediana para perros", 95.99, 10, "PDF", 3.5);

        cart.addProduct(product1);
        cart.addProduct(product2);

        String expectedString = "Carrito de compras:\n" +
                                "Producto {ID=1, Nombre='Harnes', Descripción='Harnes largo para perros', Precio=$999.99, Disponible=5}, Peso: 0.30 kg, Dimensiones: 50x30x20cm\n" +
                                "Producto {ID=2, Nombre='Correa', Descripción='Correa mediana para perros', Precio=$95.99, Disponible=10}, Formato del archivo: PDF, Tamañod del archivo: 3.50 MB\n" +
                                "Total: $1095.98";

        assertEquals(expectedString, cart.toString(), "toString() should return the correct string representation of the cart.");
    }
}
