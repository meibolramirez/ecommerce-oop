package com.puppawshop.ecommerce.inventory;

import com.puppawshop.ecommerce.model.DigitalProduct;

public class DigitalInventoryManager extends InventoryManager<DigitalProduct> {

    @Override
    public void addProduct(DigitalProduct product) {
        System.out.println("Producto digital '" + product.getName() + "' añadido al inventario digital.");
    }

    @Override
    public void removeProduct(DigitalProduct product) {
        System.out.println("Producto digital '" + product.getName() + "' eliminado del inventario digital.");
    }

    @Override
    public void updateStock(DigitalProduct product, int newStock) {
        product.setStock(newStock);
        System.out.println("Stock del producto digital '" + product.getName() + "' actualizado a " + newStock + " unidades.");
    }
}
