# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Muhammad Khamdan Azkiya]
- NIM   : [240202839]
- Kelas : [3ikra]

---

## Tujuan
Mahasiswa memahami konsep Class dan Object serta dapat membuat class Produk dengan menerapkan Enkapsulasi (menggunakan private fields dan public accessors/mutators) serta membuat method untuk memanipulasi stok.


---

## Dasar Teori 
1. Class adalah blueprint yang mendefinisikan atribut dan perilaku dari objek.

2. Object adalah instansiasi nyata dari class.

3. Enkapsulasi dilakukan dengan membuat atribut menjadi private dan menyediakan method public (getter dan setter) untuk mengontrol akses data.

4. this merujuk pada objek saat ini untuk membedakan antara variabel instance dan parameter method.)


## Langkah Praktikum

1. Membuat class Produk.java dengan atribut private (kode, nama, harga, stok).

2. Membuat constructor untuk inisialisasi awal.

3. Membuat getter dan setter untuk setiap atribut.

4. Membuat method tambahStok(int jumlah) dan kurangStok(int jumlah) dengan validasi stok.

5. Membuat class MainProduk.java untuk membuat objek dan memanggil method manipulasi stok, serta menampilkan hasilnya.

---

## Kode Program

```Produk.java (Class Model)
Java

package com.upb.agripos.model;

public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    // Constructor
    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getters
    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }

    // Setters
    public void setKode(String kode) { this.kode = kode; }
    public void setNama(String nama) { this.nama = nama; }
    public void setHarga(double harga) { this.harga = harga; }
    public void setStok(int stok) { this.stok = stok; }

    // Custom Methods
    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void kurangStok(int jumlah) {
        if (this.stok >= jumlah) {
            this.stok -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi!");
        }
    }
}
```

```CreditBy.java (Utility Class)
Java

package com.upb.agripos.util;

public class CreditBy {
    public static void printCredit(String nim, String nama) {
        System.out.println("credit by: " + nim + " - " + nama);
    }
}
```

```MainProduk.java (Main Class - Rekonstruksi Berdasarkan Output)
Java

package com.upb.agripos;

import com.upb.agripos.model.Produk;
import com.upb.agripos.util.CreditBy;

public class MainProduk {
    public static void main(String[] args) {
        // Objek inisialisasi berdasarkan output
        Produk pPupuk = new Produk("PK-301", "Pupuk Urea 50kg", 350000.0, 40);
        Produk pCangkul = new Produk("ALT-501", "Cangkul Baja", 90000.0, 15);
        Produk pBenih = new Produk("BNH-001", "Benih Padi IR64", 25000.0, 100);

        // --- Aksi Pupuk (Kurang Stok) ---
        System.out.println("Stok awal pupuk: " + pPupuk.getStok()); // Output: 40
        pPupuk.kurangStok(40); // Stok berhasil dikurangi (Stok = 0)
        
        System.out.println("Stok awal pupuk: " + pPupuk.getStok()); // Output: 0
        pPupuk.kurangStok(40); // Output: Stok tidak mencukupi! (Stok tetap 0)
        System.out.println("Sisa stok Pupuk Urea 50kg setelah permintaan: " + pPupuk.getStok()); // Output: 0
        
        // --- Aksi Cangkul (Tambah Stok) ---
        System.out.println("\nStok awal cangkul: " + pCangkul.getStok()); // Output: 15
        pCangkul.tambahStok(25); // Stok ditambah 25 (Stok = 40)
        System.out.println("Stok Cangkul Baja setelah ditambah: " + pCangkul.getStok()); // Output: 40
        
        // --- Tampilkan Detail Benih ---
        System.out.println("\nKode: " + pBenih.getKode() + ", Nama: " + pBenih.getNama() + ", Harga: " + pBenih.getHarga() + ", Stok: " + pBenih.getStok());
        
        // --- Credit ---
        System.out.println("\nStok awal Benih Padi: " + pBenih.getStok()); // Output: 100
        pBenih.kurangStok(25); // Asumsi ada aksi ini karena ada output "berkurang: 25"
        System.out.println("Sisa stok Benih Padi IR64 setelah berkurang: " + pBenih.getStok()); // Output: 75

        // Asumsi CreditBy dipanggil di akhir atau di bagian tengah
        CreditBy.printCredit("240202839", "Muhammad Khamdan Akziya");
    }
}
```
---

## Hasil Eksekusi
(![alt text](<Cuplikan layar 2025-10-07 231739.png>))
---

## Analisis
- Jelaskan bagaimana kode berjalan: Kode menginstansiasi tiga objek Produk. Pada objek pupuk, method kurangStok() diuji, dan pada panggilan kedua, berhasil memicu    validasi if karena stoknya sudah habis (0 < 40 bernilai false), sehingga mencetak pesan error dan mempertahankan stok pada nilai 0. Ini menunjukkan bahwa Enkapsulasi berjalan dengan benar, melindungi data.

- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya (Minggu 1: Paradigma)?
Minggu ini fokus pada integritas data melalui Enkapsulasi. Pada Minggu 1 (Prosedural), data stok rentan diubah menjadi nilai yang tidak logis (negatif) oleh fungsi mana pun. Pada Minggu 2, data stok dilindungi oleh keyword private dan perubahannya hanya dapat melalui method yang terkontrol, memastikan data stok tetap valid.

- Kendala yang dihadapi dan cara mengatasinya:
Kendala: Mencoba memodifikasi atribut stok langsung dari MainProduk (misalnya pPupuk.stok = 5), yang akan menghasilkan compile error karena atribut bersifat private.
Cara Mengatasi: Menggunakan method public yang telah disediakan (setStok(), kurangStok()) dan memastikan semua logika bisnis (validasi stok minimum) ditempatkan di dalam class Produk itu sendiri.

---

## Kesimpulan
*Praktikum Minggu 2 berhasil mengimplementasikan Class, Object, dan Enkapsulasi. Dengan membatasi akses langsung ke data dan menyertakan validasi dalam method seperti kurangStok(), integritas data inventaris produk terjaga secara fundamental, menjadikan program lebih aman, terstruktur, dan sesuai dengan prinsip utama Pemrograman Berorientasi Objek.*

---

## Quiz
1. [Mengapa keyword private diperlukan dalam class Produk?]
   
   **Jawaban:** Untuk menerapkan Enkapsulasi, melindungi atribut (data) seperti stok agar tidak diubah sembarangan dari luar class, dan memaksa pengguna untuk mengaksesnya melalui method kontrol (getter/setter).

 2. [Apa yang terjadi jika method kurangStok() tidak memiliki pemeriksaan if (this.stok >= jumlah)?]

   **Jawaban:**  Stok dapat memiliki nilai negatif (misalnya -5), yang secara logis salah dalam konteks inventaris. Validasi tersebut menjaga integritas data aplikasi.

 3. [Jelaskan peran constructor dalam class Produk!]
   **Jawaban:** Constructor digunakan untuk menginisialisasi objek baru. Ini memastikan bahwa setiap objek Produk segera memiliki nilai yang valid (kode, nama, harga, dan stok awal) segera setelah dibuat menggunakan keyword new.

