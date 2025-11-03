# Laporan Praktikum Minggu 4
Topik: **Polymorphism (Overloading, Overriding, Dynamic Binding)**

## Identitas
- Nama : Muhammad Khamdan Azkiya
- NIM : 240202839
- Kelas : [Kelas]

---

## Tujuan
Mahasiswa mampu **menjelaskan konsep polymorphism** dalam OOP, **membedakan method overloading dan overriding**, serta mampu **mengimplementasikan polymorphism (overriding, overloading, dynamic binding)** dalam program.

---

## Dasar Teori
1.  **Polymorphism:** Berarti "banyak bentuk" dan memungkinkan objek yang berbeda merespons panggilan method yang sama dengan cara yang berbeda.
2.  **Overloading:** Mendefinisikan method dengan **nama sama** tetapi **parameter berbeda** (tipe atau jumlah). Ini terjadi saat *compile time*.
3.  **Overriding:** *Subclass* mengganti implementasi method dari *Superclass*.
4.  **Dynamic Binding:** Mekanisme di mana Java menentukan *method* mana yang akan dipanggil berdasarkan **tipe objek aktual** saat *runtime*, bukan tipe referensinya. 

---

## Langkah Praktikum
1.  **Overloading:** Menambahkan method `tambahStok(int jumlah)` dan `tambahStok(double jumlah)` pada class `Produk`.
2.  **Overriding:** Menambahkan method `getInfo()` pada `Produk` dan menimpanya (`@Override`) pada *subclass* `Benih`, `Pupuk`, dan `AlatPertanian`.
3.  **Dynamic Binding:** Membuat *array* `Produk[] daftarProduk` yang berisi objek *subclass* dan memanggil `getInfo()` dalam *loop*.
4.  **Main Class:** Membuat `MainPolymorphism.java` untuk mendemonstrasikan ketiga konsep di atas.
5.  **Commit Message:** `week4-polymorphism`.

---

## Kode Program

### 1. `Produk.java` (Superclass - Termasuk Overloading dan Method Default)
```java
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
    
    // Getter methods
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

### 2. `Benih.java` (Superclass - Termasuk Overloading dan Method Default)
```java
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

### 3. `Pupuk.java`
```java
package com.upb.agripos.model;

public class Pupuk extends Produk {
    private String jenis;

    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    // TUGAS 2: OVERRIDING
    @Override
    public String getInfo() {
        return "Pupuk: " + super.getInfo() + ", Jenis: " + jenis;
    }
}

### 4. `AlatPertanian.java`
```java
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

### 5. `CreditBy.java`
```java
package com.upb.agripos.util;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\n--- Credit ---");
        System.out.println("Praktikum Week 4: Polymorphism");
        System.out.println("NIM: " + nim);
        System.out.println("Nama: " + nama);
        System.out.println("--------------");
    }
}

### 6. `MainPolymorphism.java`
```java
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
```

---

## Hasil Eksekusi

praktikum/week4-polymorphism/screenshots/Cuplikan layar dari 2025-11-03 18-46-31.png

---

## Analisis
* **Jelaskan bagaimana kode berjalan.**
    Kode mendemonstrasikan ketiga jenis polymorphism. **Overloading** ditunjukkan ketika pemanggilan `tambahStok(5)` (int) dan `tambahStok(2.75)` (double) memanggil *method* yang berbeda di `Produk.java`. **Dynamic Binding** terjadi di *loop* `for (Produk p : daftarProduk)`. Meskipun variabel `p` bertipe `Produk` (Superclass), Java saat *runtime* menjalankan *method* `getInfo()` yang sesuai dengan **tipe objek aktual** (`Benih`, `Pupuk`, dll.), menampilkan detail yang spesifik. 

* **Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.**
    **Minggu Lalu (Inheritance)** berfokus pada **Hierarki** dan **Reusabilitas Kode** (mewarisi atribut). **Minggu Ini (Polymorphism)** berfokus pada **Perilaku**; yaitu, bagaimana *method* yang sama (`getInfo()`) dapat memiliki *banyak bentuk* implementasi yang berbeda di sepanjang hierarki class, memungkinkan penanganan objek heterogen secara seragam.

* **Kendala yang dihadapi dan cara mengatasinya (Kendala Buatan).**
    * **Kendala:** Awalnya terjadi *compile error* karena lupa memanggil `super()` sebagai baris pertama di konstruktor *subclass* (misalnya di `Benih.java`), sehingga Java menganggap atribut *superclass* belum diinisialisasi.
    * **Cara Mengatasi:** Memperbaiki semua konstruktor *subclass* dengan memastikan bahwa pemanggilan `super(kode, nama, harga, stok);` selalu menjadi baris kode pertama sebelum menginisialisasi atribut khusus.

---

## Kesimpulan
Praktikum Minggu 4 berhasil mengimplementasikan **Polymorphism**. Penggunaan *method overloading* pada `tambahStok()` meningkatkan fleksibilitas *input*. Melalui *overriding* dan *dynamic binding*, program berhasil menangani array berisi berbagai jenis produk secara efisien, membuktikan kemampuan OOP untuk menciptakan kode yang dinamis dan terstruktur.

---

## Quiz
1.  Apa perbedaan overloading dan overriding?
       **Jawaban:** **Overloading** adalah membuat method dengan **nama sama** tetapi **parameter berbeda** (terjadi saat *compile time*). **Overriding** adalah *subclass* **mengganti** implementasi method yang diwarisi dari *superclass* (terjadi saat *runtime*).

2.  Bagaimana Java menentukan method mana yang dipanggil dalam dynamic binding?
       **Jawaban:** Java menentukan *method* yang dipanggil berdasarkan **tipe objek aktual** (*runtime* type) yang disimpan dalam variabel referensi, bukan tipe variabel referensi itu sendiri.

3.  Berikan contoh kasus polymorphism dalam sistem POS selain produk pertanian.
       **Jawaban:** Method **`hitungDiskon()`** dapat dioverride oleh *subclass* `CustomerPremium` dan `CustomerReguler`. `CustomerPremium.hitungDiskon()` memberikan diskon 10%, sedangkan `CustomerReguler.hitungDiskon()` memberikan diskon 5%.








