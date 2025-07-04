import org.junit.jupiter.api.Test;

import com.puppawshop.ecommerce.model.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testCustomerConstructor() {
        User customer = new Customer(1, "Carlos", "carlos@test.com", "pass123");
        assertEquals(1, customer.getId());
        assertEquals("Carlos", customer.getName());
        assertEquals("carlos@test.com", customer.getEmail());
        assertEquals("pass123", customer.getPassword());
    }

    @Test
    public void testAdministratorConstructor() {
        User admin = new Administrator(2, "Laura", "laura@test.com", "adminpass");
        assertEquals(2, admin.getId());
        assertEquals("Laura", admin.getName());
        assertEquals("laura@test.com", admin.getEmail());
        assertEquals("adminpass", admin.getPassword());
    }

    @Test
    public void testCustomerToString() {
        User customer = new Customer(1, "Carlos", "carlos@test.com", "pass123");
        String expectedString = "Customer: User {ID=1, Nombre='Carlos', Email='carlos@test.com'}, Compras: [], Preferencias: []";
        assertEquals(expectedString, customer.toString());
    }

    @Test
    public void testAdministratorToString() {
        Administrator admin = new Administrator(2, "Laura", "laura@test.com", "adminpass");
        String expected = "Administrator: User {ID=2, Nombre='Laura', Email='laura@test.com'}";
        assertEquals(expected, admin.toString());
    }


    @Test
    public void testSettersAndGetters() {
        User customer = new Customer(1, "Carlos", "carlos@test.com", "pass123");
        customer.setName("Carlos Jr.");
        customer.setEmail("carlos.jr@test.com");
        customer.setPassword("newpass123");

        assertEquals("Carlos Jr.", customer.getName());
        assertEquals("carlos.jr@test.com", customer.getEmail());
        assertEquals("newpass123", customer.getPassword());
    }

    @Test
    public void testInvalidEmail() {
        User user = new User(1, "Juan", "juan@test.com", "password123");

        user.setEmail("invalidemail"); 

        assertEquals("juan@test.com", user.getEmail(), "El correo no debe cambiar si es inválido.");
    }
}
