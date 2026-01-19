# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : Muhammad Khamdan Azkiya
- NIM   : 240202839
- Kelas : 3ikra

---

## Tujuan
*Mahasiswa mampu menjelaskan perbedaan antara error dan exception, mengimplementasikan struktur try–catch–finally, membuat serta mengintegrasikan custom exception ke dalam aplikasi keranjang belanja sederhana, serta memahami penerapan design pattern dasar.*

---

## Dasar Teori
  
1. Error vs Exception: Error adalah kondisi fatal yang tidak dapat ditangani (seperti OutOfMemoryError), sedangkan Exception adalah kondisi tidak normal yang dapat ditangani oleh program.

2. Struktur Penanganan: Menggunakan blok try untuk kode berisiko, catch untuk penanganan kesalahan, dan finally untuk kode yang selalu dijalankan.

3. Custom Exception: Class pengecualian buatan sendiri yang mewarisi class Exception untuk menangani logika bisnis spesifik.

4. Design Pattern: Pola desain seperti Singleton untuk memastikan hanya ada satu instance layanan dan MVC untuk memisahkan logika data, tampilan, dan kontrol.
---

## Langkah Praktikum

1. Setup Custom Exception: Membuat class InvalidQuantityException, ProductNotFoundException, dan InsufficientStockException.

2. Coding Model: Membuat class Product dengan atribut kode, nama, harga, dan stok beserta metode enkapsulasinya.

3. Coding Logic: Mengimplementasikan ShoppingCart yang melempar (throws) custom exception pada metode tambah, hapus, dan checkout.

4. Run & Test: Membuat MainExceptionDemo untuk menguji skenario kesalahan menggunakan blok try-catch.

5. Git Versioning: Melakukan commit dengan pesan week9-exception dan melakukan push ke repository.

---

## Kode Program
(Tuliskan kode utama yang dibuat, contoh:  

```java
InsufficientStockException.java
package com.upb.agripos;
public class InsufficientStockException extends Exception {
    public InsufficientStockException(String msg) { super(msg); }
}

InvalidQuantityException.java
package com.upb.agripos;
public class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String msg) { super(msg); }
    
}

MainExceptionDemo.java
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

Product.java
package com.upb.agripos;
public class Product {
    private final String code, name;
    private final double price;
    private int stock;

    public Product(String code, String name, double price, int stock) {
        this.code = code; this.name = name; this.price = price; this.stock = stock;
    }
    public String getName() { return name; }
    public int getStock() { return stock; }
    public void reduceStock(int qty) { this.stock -= qty; }
}

ProductNotFoundException.java
package com.upb.agripos;
public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String msg) { super(msg); }
}

ShoppingCart.java
package com.upb.agripos;
import java.util.*;

public class ShoppingCart {
    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product p, int qty) throws InvalidQuantityException {
        if (qty <= 0) throw new InvalidQuantityException("Jumlah '" + p.getName() + "' tidak valid: " + qty);
        items.put(p, items.getOrDefault(p, 0) + qty);
    }

    public void removeProduct(Product p) throws ProductNotFoundException {
        if (!items.containsKey(p)) throw new ProductNotFoundException("Produk '" + p.getName() + "' tidak ada di keranjang.");
        items.remove(p);
    }

    public void checkout() throws InsufficientStockException {
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            if (entry.getKey().getStock() < entry.getValue()) {
                throw new InsufficientStockException("Stok '" + entry.getKey().getName() + "' tidak cukup!");
            }
        }
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            entry.getKey().reduceStock(entry.getValue());
        }
        System.out.println("Checkout Berhasil!");
    }
}

```
)
---

## Hasil Eksekusi
![alt text](<screenshots/Cuplikan layar 2026-01-19 133652.png>)
---

## Analisis

- Kode berjalan dengan memvalidasi setiap input; jika kondisi tidak terpenuhi (seperti jumlah $\le$ 0), program akan melempar exception yang kemudian ditangkap oleh blok catch untuk menampilkan pesan informatif.
- Dibandingkan minggu sebelumnya, pendekatan ini membuat program lebih tangguh karena alur eksekusi tidak langsung berhenti saat terjadi kesalahan (crash), melainkan diarahkan ke penanganan yang sesuai.
- Kendala seperti variabel yang tidak terpakai (warning) diatasi dengan menambahkan metode getter seperti getPrice().
---

## Kesimpulan
*Penerapan Exception Handling dan Custom Exception memungkinkan pembuatan aplikasi yang lebih stabil dan informatif bagi pengguna, sementara Design Pattern membantu dalam pengorganisasian kode yang lebih terstruktur dan efisien.*

---

## Quiz
1. Jelaskan perbedaan error dan exception. 
**Jawaban:** Error adalah kondisi fatal sistem yang tidak dapat ditangani oleh program (contoh: OutOfMemory), sedangkan Exception adalah kondisi tidak normal yang muncul saat runtime dan dapat ditangani oleh kode program.

2. Apa fungsi finally dalam blok try–catch–finally? 
**Jawaban:** Blok finally berfungsi untuk mengeksekusi kode yang harus tetap berjalan, baik saat terjadi pengecualian maupun tidak (misalnya untuk menutup koneksi data).

3. Mengapa custom exception diperlukan? 
**Jawaban:** Untuk menangani kasus kesalahan spesifik yang berkaitan dengan logika bisnis aplikasi yang tidak tercakup oleh pengecualian standar Java.

4. Berikan contoh kasus bisnis dalam POS yang membutuhkan custom exception. 
**Jawaban:** Validasi jumlah pembelian yang harus lebih dari nol, pengecekan ketersediaan produk di keranjang sebelum dihapus, dan validasi kecukupan stok barang saat proses checkout.