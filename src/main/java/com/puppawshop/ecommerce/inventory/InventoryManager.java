package com.puppawshop.ecommerce.inventory;

public abstract class InventoryManager<T> {
    public abstract void addProduct(T product);
    public abstract void removeProduct(T product);
    public abstract void updateStock(T product, int newStock);
}
