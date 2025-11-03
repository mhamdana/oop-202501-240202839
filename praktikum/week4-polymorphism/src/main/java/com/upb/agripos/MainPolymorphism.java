package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy; 

public class MainPolymorphism {
    public static void main(String[] args) {
        
        // --- A. DEMO OVERLOADING ---
        Produk pupukOverload = new Produk("PK-002", "Pupuk Uji", 10000, 10);
        System.out.println("Stok awal Pupuk Uji: " + pupukOverload.getStok());
        
        // 1. Memanggil tambahStok(int)
        pupukOverload.tambahStok(5);       
        
        // 2. Memanggil tambahStok(double)
        pupukOverload.tambahStok(2.75);    
        System.out.println("Stok akhir Pupuk Uji: " + pupukOverload.getStok());
        System.out.println("-------------------------------------------------");


        // --- B. DEMO OVERRIDING & DYNAMIC BINDING (TUGAS 3) ---
        // Array bertipe Produk (Superclass)
        Produk[] daftarProduk = {
            new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64"),
            new Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea"),
            new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja")
        };

        System.out.println("--- Daftar Produk (Dynamic Binding) ---");
        for (Produk p : daftarProduk) {
            // Dynamic Binding: Java (Runtime) memutuskan method getInfo() 
            // mana yang harus dipanggil berdasarkan tipe objek AKTUAL
            System.out.println(p.getInfo()); 
        }
        System.out.println("-------------------------------------------------");

        // Credit
        CreditBy.print("240202839", "Muhammad Khamdan Azkiya");
    }
}
