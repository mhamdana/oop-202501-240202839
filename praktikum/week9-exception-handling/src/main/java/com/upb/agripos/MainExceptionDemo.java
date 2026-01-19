package com.upb.agripos;

public class MainExceptionDemo {
    public static void main(String[] args) {
        // Ganti dengan identitas asli Anda
        System.out.println("==========================================");
        System.out.println("Program Agri-POS: Exception Handling Demo");
        System.out.println("Nama : Muhammad Khamdan Azkiya");
        System.out.println("NIM  : 240202839");
        System.out.println("==========================================\n");

        // 1. Inisialisasi Data (Model)
        Product pupuk = new Product("P01", "Pupuk Organik", 25000, 3);
        ShoppingCart cart = new ShoppingCart();

        // 2. Simulasi Skenario 1: InvalidQuantityException
        System.out.println("[Skenario 1: Input Jumlah Negatif]");
        try {
            cart.addProduct(pupuk, -5); 
        } catch (InvalidQuantityException e) {
            System.err.println("Tertangkap: " + e.getMessage());
        }

        // 3. Simulasi Skenario 2: ProductNotFoundException
        System.out.println("\n[Skenario 2: Hapus Produk yang Tidak Ada]");
        try {
            cart.removeProduct(pupuk);
        } catch (ProductNotFoundException e) {
            System.err.println("Tertangkap: " + e.getMessage());
        }

        // 4. Simulasi Skenario 3: InsufficientStockException
        System.out.println("\n[Skenario 3: Checkout Melebihi Stok]");
        try {
            cart.addProduct(pupuk, 10); // Stok cuma ada 3
            System.out.println("Mencoba checkout " + pupuk.getName() + " sebanyak 10...");
            cart.checkout();
        } catch (Exception e) {
            // Menggunakan Exception umum untuk menangkap sub-class-nya
            System.err.println("Tertangkap: " + e.getMessage());
        } finally {
            System.out.println("\n[Blok Finally] Transaksi selesai diproses.");
        }
    }
}