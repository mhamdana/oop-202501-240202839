package com.upb.agripos;

import java.sql.Connection;
import java.sql.DriverManager;
import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.model.Product;

import com.upb.agripos.dao.ProductDAOImpl;

public class MainDAOTest {
    public static void main(String[] args) {
        // 1. Atur detail koneksi database PostgreSQL kamu
        String url = "jdbc:postgresql://localhost:5432/agripos";
        String user = "postgres";
        String password = "zapzap123"; // Ganti dengan password PostgreSQL-mu!

        try {
            // 2. Membuka koneksi ke database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi ke database berhasil!");

            // 3. Membuat objek DAO
            ProductDAOImpl dao = new ProductDAOImpl(conn);


            // 4. TEST: Menambah data (Create)
            System.out.println("Menambah produk baru...");
            dao.insert(new Product("P01", "Pupuk Organik", 25000, 10));

            // 5. TEST: Mencari data (Read)
            Product p = dao.findByCode("P01");
            if (p != null) {
                System.out.println("Data ditemukan: " + p.getName() + " | Stok: " + p.getStock());
            }

            // 6. TEST: Mengubah data (Update)
            System.out.println("Mengupdate produk...");
            dao.update(new Product("P01", "Pupuk Organik Premium", 30000, 8));

            // 7. Menampilkan hasil setelah update
            Product updatedP = dao.findByCode("P01");
            System.out.println("Nama baru: " + updatedP.getName());

            // 8. Menutup koneksi
            conn.close();
            System.out.println("Koneksi ditutup.");

        } catch (Exception e) {
            // Menampilkan error jika ada masalah
            System.err.println("Terjadi kesalahan: " + e.getMessage());
            e.printStackTrace();
        }
    }
}