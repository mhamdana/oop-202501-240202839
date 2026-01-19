package com.upb.agripos;
import java.util.*;

public class ShoppingCart {
    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product p, int qty) throws InvalidQuantityException {
        if (qty <= 0) throw new InvalidQuantityException("Jumlah '" + p.getName() + "' tidak valid: " + qty);
        items.put(p, items.getOrDefault(p, 0) + qty);
    }

    public void removeProduct(Product p) throws ProductNotFoundException {
        if (!items.containsKey(p)) throw new ProductNotFoundException("Produk '" + p.getName() + "' tidak ada di keranjang.");
        items.remove(p);
    }

    public void checkout() throws InsufficientStockException {
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            if (entry.getKey().getStock() < entry.getValue()) {
                throw new InsufficientStockException("Stok '" + entry.getKey().getName() + "' tidak cukup!");
            }
        }
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            entry.getKey().reduceStock(entry.getValue());
        }
        System.out.println("Checkout Berhasil!");
    }
}