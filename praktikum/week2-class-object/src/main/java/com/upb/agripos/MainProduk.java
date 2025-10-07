package main.java.com.upb.agripos;

import main.java.com.upb.agripos.model.Produk; 
import main.java.com.upb.agripos.util.CreditBy; 

public class MainProduk {
    public static void main(String[] args) {
        Produk p1 = new Produk("BNH-001", "Benih Padi IR64", 25000, 100);
        Produk p2 = new Produk("PPK-101", "Pupuk Urea 50kg", 350000, 40);
        Produk p3 = new Produk("ALT-501", "Cangkul Baja", 90000, 15);

        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: " + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: " + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: " + p3.getHarga() + ", Stok: " + p3.getStok());

        System.out.println(); //
        System.out.println( "Stok awal padi: " + p1.getStok());
        p1.kurangiStok(100);
        System.out.println("sisa stok " + p1.getNama() + " setelah berkurang: " + p1.getStok());

        System.out.println();
        System.out.println("Stok awal pupuk: " + p2.getStok());
        p2.kurangiStok(50); 
        System.out.println("sisa stok " + p2.getNama() + " setelah permintaan: " + p2.getStok());

        System.out.println();
        System.out.println("Stok awal cangkul: " + p3.getStok());
        p3.tambahStok(10);
        System.out.println("stok " + p3.getNama() + " setelah ditambah: " + p3.getStok());

        CreditBy.print("240202839", "Muhammad Khamdan Azkiya");
    }
}