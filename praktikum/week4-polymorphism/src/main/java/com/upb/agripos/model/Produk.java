package com.upb.agripos.model;

public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }
    
    // Getter dasar untuk demo
    public String getNama() { return nama; }
    public String getKode() { return kode; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }
    
    // TUGAS 1: OVERLOADING
    public void tambahStok(int jumlah) {
        this.stok += jumlah;
        System.out.println("[Overloading] Stok ditambah " + jumlah + " (tipe integer).");
    }

    public void tambahStok(double jumlah) { // Overloading: parameter berbeda (double)
        this.stok += (int) jumlah;
        System.out.println("[Overloading] Stok ditambah " + jumlah + " (dikonversi ke integer).");
    }

    // TUGAS 2: OVERRIDING (Method default)
    public String getInfo() {
        return "Produk: " + nama + " (Kode: " + kode + ", Harga: " + harga + ", Stok: " + stok + ")";
    }
}

