package main.java.com.upb.agripos.model;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    // Implementasi Bab 7: Menggunakan List (Collections)
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product p, int qty) {
        items.add(new CartItem(p, qty));
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(CartItem::getSubtotal).sum();
    }

    public Object getItems() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getItems'");
    }

    public void removeItem(Product selected, int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeItem'");
    }
}