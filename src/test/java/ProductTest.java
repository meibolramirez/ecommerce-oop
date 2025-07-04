import com.puppawshop.ecommerce.model.*;
import com.puppawshop.ecommerce.exceptions.InvalidProductException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    // ============================
    // Constructor Tests
    // ============================

    @Test
    void testProductConstructorWithValidValues() throws InvalidProductException {
        Product product = new PhysicalProduct(1, "Harnes", "Harnes largo para perros", 999.99, 5, 0.3, "50x30x20cm");

        assertNotNull(product, "Product should be created successfully with valid values.");
    }

    @Test
    void testProductConstructorWithInvalidPrice() {
        assertThrows(InvalidProductException.class, () -> {
            new PhysicalProduct(1, "Harnes", "Harnes largo para perros", -999.99, 5, 0.3, "50x30x20cm");
        }, "Negative price should throw InvalidProductException.");
    }

    @Test
    void testProductConstructorWithInvalidStock() {
        assertThrows(InvalidProductException.class, () -> {
            new PhysicalProduct(1, "Harnes", "Harnes largo para perros", 999.99, -5, 0.3, "50x30x20cm");
        }, "Negative stock should throw InvalidProductException.");
    }

    // ============================
    // Setters for Price and Stock Tests
    // ============================

    @Test
    void testSetPriceWithValidValue() throws InvalidProductException {
        PhysicalProduct product = new PhysicalProduct(1, "Harnes", "Harnes largo para perros", 999.99, 5, 0.3, "50x30x20cm");

        product.setPrice(1200.00);
        
        assertEquals(1200.00, product.getPrice(), "Price should be updated correctly.");
    }

    @Test
    void testSetStockWithValidValue() throws InvalidProductException {
        PhysicalProduct product = new PhysicalProduct(1, "Harnes", "Harnes largo para perros", 999.99, 5, 0.3, "50x30x20cm");

        product.setStock(10);

        assertEquals(10, product.getStock(), "Stock should be updated correctly.");
    }

    @Test
    void testSetPriceWithInvalidValue() throws InvalidProductException {
        PhysicalProduct product = new PhysicalProduct(1, "Harnes", "Harnes largo para perros", 999.99, 5, 0.3, "50x30x20cm");

        assertThrows(InvalidProductException.class, () -> {
            product.setPrice(-100.00);
        }, "Setting a negative price should throw InvalidProductException.");
    }

    @Test
    void testSetStockWithInvalidValue() throws InvalidProductException {
        PhysicalProduct product = new PhysicalProduct(1, "Harnes", "Harnes largo para perros", 999.99, 5, 0.3, "50x30x20cm");

        assertThrows(InvalidProductException.class, () -> {
            product.setStock(-5);
        }, "Setting a negative stock value should throw InvalidProductException.");
    }

    // ============================
    // Edge Cases
    // ============================

    @Test
    void testSetPriceWithZero() throws InvalidProductException {
        PhysicalProduct product = new PhysicalProduct(1, "Harnes", "Harnes largo para perros", 999.99, 5, 0.3, "50x30x20cm");

        product.setPrice(0.00);
        
        assertEquals(0.00, product.getPrice(), "Price should be set to 0.00 without issues.");
    }

    @Test
    void testSetStockWithZero() throws InvalidProductException {
        PhysicalProduct product = new PhysicalProduct(1, "Harnes", "Harnes largo para perros", 999.99, 5, 0.3, "50x30x20cm");

        product.setStock(0);

        assertEquals(0, product.getStock(), "Stock should be set to 0 without issues.");
    }

    // ============================
    // Getter Tests
    // ============================

    @Test
    void testGetters() throws InvalidProductException {
        Product product = new PhysicalProduct(1, "Harnes", "Harnes largo para perros", 999.99, 5, 0.3, "50x30x20cm");

        assertEquals(1, product.getId(), "ID should be 1.");
        assertEquals("Harnes", product.getName(), "Name should be 'Harnes'.");
        assertEquals("Harnes largo para perros", product.getDescription(), "Description should match.");
        assertEquals(999.99, product.getPrice(), "Price should be 999.99.");
        assertEquals(5, product.getStock(), "Stock should be 5.");
    }

    // ============================
    // Setter Tests
    // ============================

    @Test
    void testSetters() throws InvalidProductException {
        Product product = new PhysicalProduct(1, "Harnes", "Harnes largo para perros", 999.99, 5, 0.3, "50x30x20cm");

        product.setId(2);
        product.setName("Collar");
        product.setDescription("Collar de cuero para perros");

        assertEquals(2, product.getId(), "ID should be updated to 2.");
        assertEquals("Collar", product.getName(), "Name should be updated to 'Collar'.");
        assertEquals("Collar de cuero para perros", product.getDescription(), "Description should be updated.");
    }

    // ============================
    // toString() Test
    // ============================

    @Test
    void testToString() throws InvalidProductException {
        Product product = new PhysicalProduct(1, "Harnes", "Harnes largo para perros", 999.99, 5, 0.3, "50x30x20cm");

        // Update the expected value to include weight and dimensions
        String expected = "Producto {ID=1, Nombre='Harnes', Descripción='Harnes largo para perros', Precio=$999.99, Disponible=5}, Peso: 0.30 kg, Dimensiones: 50x30x20cm";
        
        assertEquals(expected, product.toString(), "toString() should return the correct product string.");
    }

}
