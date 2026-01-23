package com.upb.agripos.model;

public class Product {
    private String code;
    private String name;
    private double price; // Tambahan untuk Bab 12
    private int stock;    // Tambahan untuk Bab 12

    // Constructor untuk Bab 10 (Agar AppMVC.java tidak error)
    public Product(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Constructor LENGKAP untuk Bab 12 (GUI & Database)
    public Product(String code, String name, double price, int stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getter
    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
}