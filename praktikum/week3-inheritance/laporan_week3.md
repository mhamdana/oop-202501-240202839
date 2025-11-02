# Laporan Praktikum Minggu 3
Topik: **Inheritance (Pewarisan Class) untuk Kategori Produk**

## Identitas
- Nama : Muhammad Khamdan Azkiya
- NIM : 240202839
- Kelas : [Kelas]

---

## Tujuan
Mahasiswa mampu **menjelaskan konsep inheritance (pewarisan class)** dalam OOP, **membuat superclass dan subclass** untuk produk pertanian, serta mampu **menggunakan `super` untuk memanggil konstruktor parent class** untuk membuat kode yang lebih *reusable* dan terstruktur.

---

## Dasar Teori
1.  **Inheritance (Pewarisan):** Mekanisme OOP yang memungkinkan satu class (**Subclass**) mewarisi atribut dan method dari class lain (**Superclass**).
2.  **Superclass:** Class induk yang mendefinisikan atribut dan method yang bersifat umum dan akan diwariskan ke class turunannya (contoh: `Produk`).
3.  **Subclass:** Class turunan yang mewarisi semua anggota *Superclass* dan dapat menambahkan anggota khusus miliknya sendiri (contoh: `Benih`, `Pupuk`).
4.  **Keyword `super`:** Digunakan di dalam Subclass, terutama di konstruktor, untuk memanggil konstruktor atau method dari Superclass dan menginisialisasi atribut yang diwarisi. 

---

## Langkah Praktikum
1.  **Membuat Superclass `Produk`:** Class `Produk` dari Bab 2 digunakan kembali sebagai *superclass*.
2.  **Membuat Subclass:** Dibuat tiga *subclass* (`Benih`, `Pupuk`, `AlatPertanian`) yang masing-masing `extends Produk` dan memiliki atribut khusus (`varietas`, `jenis`, `material`).
3.  **Instansiasi dan Uji:** Objek dari setiap *subclass* dibuat di `MainInheritance.java` untuk menguji pewarisan method dan atribut.
4.  **Menambahkan Credit:** Class `CreditBy` dipanggil di akhir eksekusi untuk menampilkan identitas mahasiswa.
5.  **Commit Message:** `week3-inheritance`.

---

## Kode Program
(Tuliskan kode utama yang dibuat:  

``` 
//produk.java
package com.upb.agripos.model;

public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    // Konstruktor Superclass
    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter methods
    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }

    // Setter methods
    public void setKode(String kode) { this.kode = kode; }
    public void setNama(String nama) { this.nama = nama; }
    public void setHarga(double harga) { this.harga = harga; }
    public void setStok(int stok) { this.stok = stok; }
}


// Benih.java
package com.upb.agripos.model;

public class Benih extends Produk {
    private String varietas;

    // Konstruktor Subclass memanggil Konstruktor Superclass (Produk)
    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    public String getVarietas() { return varietas; }
    public void setVarietas(String varietas) { this.varietas = varietas; }
}

//Pupuk.java
package com.upb.agripos.model;

public class Pupuk extends Produk {
    private String jenis;

    // Konstruktor Subclass memanggil Konstruktor Superclass (Produk)
    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }
}

//AlatPertanian.java
package com.upb.agripos.model;

public class AlatPertanian extends Produk {
    private String material;

    // Konstruktor Subclass memanggil Konstruktor Superclass (Produk)
    public AlatPertanian(String kode, String nama, double harga, int stok, String material) {
        super(kode, nama, harga, stok);
        this.material = material;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
}

//CreditBy.java
package com.upb.agripos.util;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\n--- Credit ---");
        System.out.println("Praktikum Week 3: Inheritance");
        System.out.println("NIM: " + nim);
        System.out.println("Nama: " + nama);
        System.out.println("--------------");
    }
}

//MainInheritance.java
package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy;

public class MainInheritance {
    public static void main(String[] args) {
        // Instansiasi objek dari tiap Subclass
        Benih b = new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64");
        Pupuk p = new Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea");
        AlatPertanian a = new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja");

        System.out.println("--- Daftar Produk Pertanian ---");
        
        // Menampilkan data produk, memanfaatkan method yang diwarisi
        System.out.println("Benih: " + b.getNama() + " (Kode: " + b.getKode() + ")");
        System.out.println("  Varietas: " + b.getVarietas() + ", Harga: " + b.getHarga());

        System.out.println("Pupuk: " + p.getNama() + " (Kode: " + p.getKode() + ")");
        System.out.println("  Jenis: " + p.getJenis() + ", Harga: " + p.getHarga());
        
        System.out.println("Alat Pertanian: " + a.getNama() + " (Kode: " + a.getKode() + ")");
        System.out.println("  Material: " + a.getMaterial() + ", Harga: " + a.getHarga());

        // Memanggil CreditBy
        CreditBy.print("240202839", "Muhammad Khamdan Azkiya");
    }
}
```
)
---

## Hasil Eksekusi

![alt text](<Cuplikan layar dari 2025-11-02 22-50-28.png>)

---

## Analisis
(
- Jelaskan bagaimana kode berjalan. Program dimulai di MainInheritance.java. Ketika objek subclass (misalnya Benih) dibuat, konstruktornya akan dieksekusi. Baris pertama di konstruktor tersebut adalah super(kode, nama, harga, stok), yang memanggil konstruktor dari Superclass (Produk) untuk menginisialisasi semua atribut yang diwarisi. Setelah itu, konstruktor subclass menginisialisasi atribut spesifiknya (varietas). Ketika data ditampilkan, method seperti getNama() diwarisi dari Produk, sementara getVarietas() adalah method unik milik Benih.
- Apa perbedaan pendekatan minggu ini (Inheritance) dibanding minggu lalu (Class/Object & Enkapsulasi).

    - Minggu Lalu (Enkapsulasi) berfokus pada Integritas Data satu entitas (Produk). Tujuannya adalah mengamankan data internal objek (misalnya, stok tidak negatif).

    - Minggu Ini (Inheritance) berfokus pada Hierarki Class dan Reusabilitas Kode. Tujuannya adalah membangun hubungan IS-A (misal: Benih IS-A Produk) untuk menghindari penulisan ulang atribut umum (kode, nama, dll.) di banyak class.  
- Kendala yang dihadapi dan cara mengatasinya.

    - Kendala utama yang dihadapi adalah eror package yang tersisa setelah pemindahan file ("The declared package... does not match the expected package").

    - Masalah ini diatasi dengan mengatur ulang struktur folder agar sesuai dengan hierarki package Java dan melakukan restart IDE untuk membersihkan cache kompilasi, yang berhasil menyelesaikan semua eror.
    
    - Terjadi compile error karena lupa memanggil super() sebagai baris pertama di konstruktor subclass (misalnya di Benih.java), sehingga Java menganggap atribut superclass belum diinisialisasi. 
    - Diatasi dengan Memperbaiki semua konstruktor subclass dengan memastikan bahwa pemanggilan super(kode, nama, harga, stok); selalu menjadi baris kode pertama sebelum menginisialisasi atribut khusus (this.varietas = varietas;).
)
---

## Kesimpulan
Praktikum Minggu 3 berhasil mengimplementasikan konsep Inheritance. Dengan menetapkan Produk sebagai Superclass dan kategori spesifik sebagai Subclass, kode menjadi lebih terstruktur, modular, dan reusable. Penggunaan keyword super memastikan inisialisasi yang efisien pada atribut yang diwarisi, yang merupakan prinsip fundamental dalam Pemrograman Berorientasi Objek.
---

## Quiz
(1. Apa keuntungan menggunakan inheritance dibanding membuat class terpisah tanpa hubungan?  
   **Jawaban:** Keuntungan utama adalah Reusabilitas Kode dan Struktur Kode yang Jelas (Hierarki). Atribut dan method umum hanya ditulis satu kali di Superclass dan diwarisi oleh semua Subclass, sehingga mengurangi duplikasi dan mempermudah pemeliharaan kode.

2. Bagaimana cara subclass memanggil konstruktor superclass?  
   **Jawaban:** Menggunakan keyword super(...) sebagai baris pertama dalam konstruktor subclass.

3. Berikan contoh kasus di POS pertanian selain Benih, Pupuk, dan Alat Pertanian yang bisa dijadikan subclass.  
   **Jawaban:** Pestisida (dengan atribut tambahan: kandunganaktif) atau Media Tanam (dengan atribut tambahan: komposisi).)
