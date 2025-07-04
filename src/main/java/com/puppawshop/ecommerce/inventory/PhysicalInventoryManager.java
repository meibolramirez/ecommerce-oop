package com.puppawshop.ecommerce.inventory;

import com.puppawshop.ecommerce.exceptions.InvalidProductException;
import com.puppawshop.ecommerce.model.PhysicalProduct;

public class PhysicalInventoryManager extends InventoryManager<PhysicalProduct> {

    @Override
    public void addProduct(PhysicalProduct product) {
        System.out.println("Producto físico '" + product.getName() + "' añadido al inventario.");
    }

    @Override
    public void removeProduct(PhysicalProduct product) {
        System.out.println("Producto físico '" + product.getName() + "' eliminado del inventario.");
    }

    @Override
    public void updateStock(PhysicalProduct product, int newStock) {
        try {
			product.setStock(newStock);
		} catch (InvalidProductException e) {
			e.printStackTrace();
		}
        System.out.println("Stock del producto físico '" + product.getName() + "' actualizado a " + newStock + " unidades.");
    }
}
