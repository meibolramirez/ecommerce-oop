import com.puppawshop.ecommerce.exceptions.InvalidProductException;
import com.puppawshop.ecommerce.factory.EntityFactory;
import com.puppawshop.ecommerce.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EntityFactoryTest {

    @Test
    public void testCreatePhysicalProduct() throws InvalidProductException {
        Product product = EntityFactory.createProduct("physical", 1, "Collar", "Collar resistente", 49.99, 10);
        assertTrue(product instanceof PhysicalProduct);
        assertEquals("Collar", product.getName());
    }

    @Test
    public void testCreateDigitalProduct() throws InvalidProductException {
        Product product = EntityFactory.createProduct("digital", 2, "Curso Online", "Entrenamiento canino", 29.99, 100);
        assertTrue(product instanceof DigitalProduct);
        assertEquals("Curso Online", product.getName());
    }

    @Test
    public void testCreateEbookProduct() throws InvalidProductException {
        Product product = EntityFactory.createProduct("ebook", 3, "Guía de Adiestramiento", "eBook PDF", 15.99, 50);
        assertTrue(product instanceof DigitalProduct);
        assertEquals("Guía de Adiestramiento", product.getName());
    }

    @Test
    public void testCreateCustomer() {
        User user = EntityFactory.createUser("customer", 1, "Carlos", "carlos@test.com", "pass123");
        assertTrue(user instanceof Customer);
        assertEquals("Carlos", user.getName());
    }

    @Test
    public void testCreateAdministrator() {
        User user = EntityFactory.createUser("admin", 2, "Laura", "laura@test.com", "adminpass");
        assertTrue(user instanceof Administrator);
        assertEquals("Laura", user.getName());
    }

    @Test
    public void testCreateUnknownProductType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            EntityFactory.createProduct("unknown", 4, "Producto", "Descripción", 9.99, 5);
        });
        assertTrue(exception.getMessage().contains("Tipo de producto desconocido"));
    }

    @Test
    public void testCreateUnknownUserType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            EntityFactory.createUser("unknown", 3, "Pedro", "pedro@test.com", "password");
        });
        assertTrue(exception.getMessage().contains("Tipo de usuario desconocido"));
    }
}
