package com.upb.agripos.model;

public class AlatPertanian extends Produk {
    private String material;

    public AlatPertanian(String kode, String nama, double harga, int stok, String material) {
        super(kode, nama, harga, stok);
        this.material = material;
    }

    // TUGAS 2: OVERRIDING
    @Override
    public String getInfo() {
        return "Alat: " + super.getInfo() + ", Material: " + material;
    }
}

