package com.upb.agripos.model;

public class Benih extends Produk {
    private String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    // TUGAS 2: OVERRIDING
    @Override
    public String getInfo() {
        // Memanggil getInfo() dari Superclass, lalu menambahkan detail unik
        return "Benih: " + super.getInfo() + ", Varietas: " + varietas;
    }
}
