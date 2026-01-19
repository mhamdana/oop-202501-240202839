# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : Muhammad Khamdan Aakiya
- NIM   : 240202839
- Kelas : 3ikra

---

## Tujuan
Menjelaskan konsep collection dalam Java seperti List, Map, dan Set.

Menggunakan ArrayList untuk menyimpan dan mengelola objek secara dinamis.

Mengimplementasikan Map untuk pengelolaan data yang membutuhkan pasangan key-value.

Melakukan operasi dasar pada collection seperti tambah, hapus, dan hitung total.
---

## Dasar Teori
1. Java Collections Framework menyediakan struktur data untuk        mengelola objek secara dinamis dan efisien.

2. List (ArrayList) merupakan koleksi yang terurut dan memperbolehkan elemen duplikat.

3. Map (HashMap) menyimpan data dalam pasangan key-value, sangat cepat untuk akses data berdasarkan key tertentu.

4. Set (HashSet) digunakan untuk menyimpan kumpulan data unik tanpa memperbolehkan adanya duplikasi.

---

## Langkah Praktikum
1. Setup: Membuat paket com.upb.agripos dan menyiapkan struktur folder proyek.

2. Coding: Mengimplementasikan class Product, ShoppingCart (ArrayList), ShoppingCartMap (Map), dan MainCart.

3. Run: Menjalankan file MainCart.java untuk memverifikasi fungsionalitas keranjang belanja.

4. Commit: Melakukan commit dengan format week7-collections: [fitur] [deskripsi singkat].
---

## Kode Program

```java
Product.java
package com.upb.agripos;

public class Product {
    private final String code;
    private final String name;
    private final double price;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}

ShoppingCart.java
package com.upb.agripos;

import java.util.ArrayList;

public class ShoppingCart {
    private final ArrayList<Product> items = new ArrayList<>();

    public void addProduct(Product p) { items.add(p); }
    public void removeProduct(Product p) { items.remove(p); }

    public double getTotal() {
        double sum = 0;
        for (Product p : items) {
            sum += p.getPrice();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("Isi Keranjang:");
        for (Product p : items) {
            System.out.println("- " + p.getCode() + " " + p.getName() + " = " + p.getPrice());
        }
        System.out.println("Total: " + getTotal());
        System.out.println();
    }
}

ShoppingCartMap.java
package com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartMap {
    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product p) { items.put(p, items.getOrDefault(p, 0) + 1); }

    public void removeProduct(Product p) {
        if (!items.containsKey(p)) return;
        int qty = items.get(p);
        if (qty > 1) items.put(p, qty - 1);
        else items.remove(p);
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void printCart() {
        System.out.println("Isi Keranjang (Map):");
        for (Map.Entry<Product, Integer> e : items.entrySet()) {
            System.out.println("- " + e.getKey().getCode() + " " + e.getKey().getName() + " x" + e.getValue());
        }
        System.out.println("Total: " + getTotal());
    }
}

MainCart.java
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

---

## Hasil Eksekusi
![alt text](<screenshots/Cuplikan layar 2026-01-19 114852.png>)
---

## Analisis
(
- Implementasi Diagram: Kode minggu ini merupakan realisasi teknis dari Class Diagram yang dibuat minggu lalu. Atribut code, name, dan price pada class Product diimplementasikan dengan visibilitas private sesuai prinsip enkapsulasi.

- Alur Kerja: Proses addProduct dan removeProduct pada ShoppingCart menjalankan logika yang sebelumnya digambarkan pada Activity Diagram "Checkout". Penggunaan ArrayList memungkinkan sistem menangani skenario "tambah item" secara dinamis sebelum masuk ke tahap pembayaran.

- Konsistensi: Metode getTotal() merupakan bagian dari pemetaan kebutuhan untuk menghitung nilai transaksi sebelum dikirim ke Payment Gateway (sesuai Sequence Diagram minggu lalu).

- Perbedaan: Minggu lalu fokus pada perancangan logika visual (diagram), sedangkan minggu ini fokus pada implementasi struktur data nyata untuk menyimpan status aplikasi sementara.  
)
---

## Kesimpulan
*Implementasi Java Collections (khususnya ArrayList) berhasil menerjemahkan rancangan diagram minggu lalu ke dalam kode program fungsional. Hal ini membuktikan bahwa perancangan yang konsisten mempermudah proses koding, terutama dalam mengelola data transaksi pada sistem Agri-POS.*

---

## Quiz

1. Jelaskan perbedaan mendasar antara List, Map, dan Set.

    **Jawaban:** List menyimpan elemen secara terurut dan mengizinkan duplikat; Map menyimpan pasangan kunci-nilai (key-value); Set menyimpan elemen unik tanpa urutan tertentu.

2. Mengapa ArrayList cocok digunakan untuk keranjang belanja sederhana?

**Jawaban:** Karena ArrayList bersifat dinamis, sehingga mempermudah penambahan dan penghapusan produk tanpa harus mendeklarasikan ukuran tetap di awal.

3. Bagaimana struktur Set mencegah duplikasi data?

**Jawaban:** Set menggunakan nilai hash untuk memastikan setiap objek yang dimasukkan belum ada dalam koleksi tersebut.

4. Kapan sebaiknya menggunakan Map dibandingkan List? Jelaskan dengan contoh.

**Jawaban:** Gunakan Map jika data memerlukan identitas unik (Key) untuk akses cepat atau jika ingin menyimpan kuantitas produk. Contoh: Map<Product, Integer> di mana kunci adalah produk dan nilainya adalah jumlah (Quantity) barang tersebut.