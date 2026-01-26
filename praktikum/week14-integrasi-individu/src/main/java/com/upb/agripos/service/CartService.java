package main.java.com.upb.agripos.service;
import main.java.com.upb.agripos.model.*;

public class CartService {
    private Cart cart = new Cart();

    public void add(Product p, int qty) throws Exception {
        if (p == null) return;
        if (p.getStock() < qty) {
            throw new Exception("Stok tidak cukup!");
        }
        cart.addItem(p, qty);
    }

    // Fungsi untuk Reset/Refresh Keranjang
    public void clearCart() {
        cart.getItems().clear();
    }

    public String getTotal() {
        return String.format("%.2f", cart.calculateTotal());
    }
}