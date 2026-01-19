package com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {
        Product p1 = new Product("P01", "Beras", 50000.0);
        Product p2 = new Product("P02", "Pupuk", 30000.0);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.printCart();

        System.out.println("Setelah menghapus P01 Beras dari keranjang:");
        cart.removeProduct(p1);
        cart.printCart();
    }
}