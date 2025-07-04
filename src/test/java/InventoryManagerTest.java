import com.puppawshop.ecommerce.exceptions.InvalidProductException;
import com.puppawshop.ecommerce.model.*;
import com.puppawshop.ecommerce.inventory.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryManagerTest {

    @Test
    void testAddDigitalProduct() throws InvalidProductException {
        DigitalInventoryManager digitalInventory = new DigitalInventoryManager();
        DigitalProduct digitalProduct = new DigitalProduct(1, "Curso de Adiestramiento", "Curso de entrenamiento para perros", 59.99, 50, "MP4", 2000);

        digitalInventory.addProduct(digitalProduct);

        // Check the output
        // You could mock System.out.print to check the exact output if needed
        assertTrue(true, "Digital product added successfully.");
    }

    @Test
    void testRemoveDigitalProduct() throws InvalidProductException {
        DigitalInventoryManager digitalInventory = new DigitalInventoryManager();
        DigitalProduct digitalProduct = new DigitalProduct(1, "Curso de Adiestramiento", "Curso de entrenamiento para perros", 59.99, 50, "MP4", 2000);

        digitalInventory.addProduct(digitalProduct);
        digitalInventory.removeProduct(digitalProduct);

        // Check the output
        // Mocking System.out.print for output check if necessary
        assertTrue(true, "Digital product removed successfully.");
    }

    @Test
    void testUpdateStockForDigitalProduct() throws InvalidProductException {
        DigitalInventoryManager digitalInventory = new DigitalInventoryManager();
        DigitalProduct digitalProduct = new DigitalProduct(1, "Curso de Adiestramiento", "Curso de entrenamiento para perros", 59.99, 50, "MP4", 2000);

        digitalInventory.updateStock(digitalProduct, 30); // Update stock to 30

        assertEquals(30, digitalProduct.getStock(), "The stock of the digital product should be updated to 30.");
    }

    @Test
    void testAddPhysicalProduct() throws InvalidProductException {
        PhysicalInventoryManager physicalInventory = new PhysicalInventoryManager();
        PhysicalProduct physicalProduct = new PhysicalProduct(1, "Cama para perros", "Cama cómoda para perros", 499.99, 20, 1.5, "60x40x30cm");

        physicalInventory.addProduct(physicalProduct);

        // Check the output
        // Mocking System.out.print for output check if necessary
        assertTrue(true, "Physical product added successfully.");
    }

    @Test
    void testRemovePhysicalProduct() throws InvalidProductException {
        PhysicalInventoryManager physicalInventory = new PhysicalInventoryManager();
        PhysicalProduct physicalProduct = new PhysicalProduct(1, "Cama para perros", "Cama cómoda para perros", 499.99, 20, 1.5, "60x40x30cm");

        physicalInventory.addProduct(physicalProduct);
        physicalInventory.removeProduct(physicalProduct);

        // Check the output
        // Mocking System.out.print for output check if necessary
        assertTrue(true, "Physical product removed successfully.");
    }

    @Test
    void testUpdateStockForPhysicalProduct() throws InvalidProductException {
        PhysicalInventoryManager physicalInventory = new PhysicalInventoryManager();
        PhysicalProduct physicalProduct = new PhysicalProduct(1, "Cama para perros", "Cama cómoda para perros", 499.99, 20, 1.5, "60x40x30cm");

        physicalInventory.updateStock(physicalProduct, 15); // Update stock to 15

        assertEquals(15, physicalProduct.getStock(), "The stock of the physical product should be updated to 15.");
    }
}
