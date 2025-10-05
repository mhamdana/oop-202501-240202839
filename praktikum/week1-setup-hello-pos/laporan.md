# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : Muhammad Khamdan Azkiya
- NIM   : 240202839
- Kelas : 3ikra

---

## Tujuan
1. Mahasiswa dapat memahami dan membandingkan tiga paradigma pemrograman dasar: Prosedural,     Object-Oriented Programming (OOP), dan Fungsional.

2. Mahasiswa mampu mengimplementasikan data yang sama (NIM dan Nama) menggunakan struktur kode yang berbeda sesuai dengan setiap paradigma.

3. Mahasiswa memahami bagaimana Class digunakan sebagai container wajib dalam Java, bahkan dalam kode yang bersifat Prosedural atau Fungsional.

---

## Dasar Teori
1. Pemrograman Prosedural: Fokus pada urutan langkah (prosedur) atau fungsi yang beroperasi pada data. Program dipecah menjadi fungsi/subrutin yang dijalankan secara sekuensial. Data dan fungsi terpisah.

2. Object-Oriented Programming (OOP): Fokus pada Objek yang merupakan instansiasi dari Class. Class menggabungkan data (atribut) dan perilaku (method). Prinsip utamanya adalah Enkapsulasi, Inheritance, dan Polimorfisme.

3. Pemrograman Fungsional: Fokus pada fungsi matematika yang murni (tanpa side-effects) dan immutable data. Dalam Java, ini diimplementasikan menggunakan Lambda Expressions dan Streams untuk memproses koleksi data secara deklaratif.

4. Java sebagai OOP: Java adalah bahasa berorientasi objek. Meskipun dapat menjalankan kode prosedural, ia mewajibkan semua logika dibungkus dalam sebuah Class.

---

## Langkah Praktikum
1. Setup Lingkungan: Memastikan Java Development Kit (JDK) dan Visual Studio Code (VS Code) dengan ekstensi Java terinstal dan berfungsi.

2. Pembuatan File: Membuat tiga file Java utama: Helloprosedural.java, Mahasiswa.java, dan HelloOOP.java, serta HelloFunctional.java.

3. Implementasi Paradigma:

Mengimplementasikan Prosedural dengan mendefinisikan variabel lokal dalam main() dan mencetak langsung.

Mengimplementasikan OOP dengan mendefinisikan Class Mahasiswa (memiliki atribut dan method) dan membuat objek di HelloOOP.java.

Mengimplementasikan Fungsional dengan menggunakan Lists dan Streams (IntStream.range().forEach() dan .stream().sum()) untuk memproses data.

4. Debugging: Mengatasi error penamaan file yang case-sensitive pada VS Code (misalnya, Hellofunctional.java diubah menjadi HelloFunctional.java).

5. Eksekusi: Menjalankan ketiga file untuk membandingkan output dan struktur kode.
 
---

## Kode Program

Kode Helloprosedural
public class Helloprosedural {

    public static class Mahasiswa {
        
        String nama;
        String nim;

        public Mahasiswa(String nama, String nim) {
            this.nama = nama;
            this.nim = nim;
        }

        public String getSalam() {
            return "Hello World, i am " + this.nama + " - " + this.nim;
        }
    }

    public static void main(String[] args) {
        
        Mahasiswa mhsSaya = new Mahasiswa("muhammad khamdan azkiya", "240202039");
        
        System.out.println(mhsSaya.getSalam());
    }
}

Kode HelloOOP
// Mahasiswa.java
// Class ini mewakili objek Mahasiswa
class Mahasiswa {
    // 1. Atribut (State)
    String nim;
    String nama;

    // Konstruktor
    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    // 2. Method (Perilaku) - Mencetak data dalam format satu baris
    public void cetakDataLengkap() {
        // Format disamakan: "NIM: [nim], Nama: [nama]"
        System.out.println("NIM: " + this.nim + ", Nama: " + this.nama);
    }
}

// HelloOOP.java
public class HelloOOP {
    public static void main(String[] args) {
        
        // Data yang digunakan:
        String nimMhs = "240202839";
        String namaMhs = "Muhammad Khamdan Azkiya";
        
        // 3. Membuat Objek Mahasiswa
        Mahasiswa mhs = new Mahasiswa(nimMhs, namaMhs);

        // Output Header "Hello World"
        System.out.println("Hello World, I am Student"); 
        
        // Memanggil Method Objek untuk mencetak data mahasiswa
        // Ini menggantikan dua baris System.out.println terpisah
        mhs.cetakDataLengkap();
        
        /* Output saat dijalankan akan menjadi:
        Hello World, I am Student
        NIM: 240202839, Nama: Muhammad Khamdan Azkiya
        */
    }
}

Kode HelloFunctional
// HelloFunctional.java
import java.util.*;
import java.util.stream.*;

public class HelloFunctional {
    public static void main(String[] args) {
        
        // Data Mahasiswa
        String nim = "240202839";
        String nama = "Muhammad Khamdan Azkiya";

        // Mempertahankan Struktur Fungsional (List untuk Stream)
        List<String> labelData = Arrays.asList("NIM", "NAMA");
        List<String> nilaiData = Arrays.asList(nim, nama);
        
        // Output "Hello World"
        System.out.println("Halo Dunia Mahasiswa"); 
        
        // Mencetak data mahasiswa dalam format satu baris
        System.out.println("NIM: " + nim + ", NAMA: " + nama);
        
        // Mempertahankan Struktur Fungsional (Stream Loop)
        System.out.println("Rincian Data:");
        IntStream.range(0, labelData.size())
            .forEach(i -> System.out.println("- " + labelData.get(i) + ": " + nilaiData.get(i)));
        
        // Mempertahankan Struktur Perhitungan (Sum Stream)
        // List buatan yang menjumlahkan ke 2 (melambangkan 2 item data)
        List<Integer> kodeBuatan = Arrays.asList(1, 1); 
        int totalElemen = kodeBuatan.stream().mapToInt(Integer::intValue).sum();
        
        // Frasa "Dummy Sum" diganti menjadi "Penjumlahan Pola" atau "Penjumlahan Buatan"
        System.out.println("Jumlah Elemen Data (Penjumlahan Pola): " + totalElemen); 
    }
}

```java
// Contoh
Produk p1 = new Produk("BNH-001", "Benih Padi", 25000, 100);
System.out.println(p1.getNama());
```

---
## Hasil Eksekusi
1. Halloprosedural.java
![alt text](<Cuplikan layar 2025-10-05 111226-1.png>)
2. HalloOOP.java
![alt text](<Cuplikan layar 2025-10-05 111240.png>)
3. HallpFunctional.java
![alt text](<Cuplikan layar 2025-10-05 111752.png>)
## Analisis
(
- Jelaskan bagaimana kode berjalan.  
- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.  
- Kendala yang dihadapi dan cara mengatasinya.  
)
1. Jelaskan bagaimana kode berjalan.

Helloprosedural: Mendefinisikan class Mahasiswa sebagai inner class dan kemudian membuat instance objeknya di main(). Meskipun ada class dan object, logika utama masih berpusat pada method main() untuk inisialisasi dan pencetakan.

HelloOOP: Data (nim, nama) dan perilaku (cetakDataLengkap()) dikemas dalam class terpisah (Mahasiswa.java). Di HelloOOP.java, objek mhs dibuat, dan method dipanggil melalui objek tersebut (mhs.cetakDataLengkap()). Ini adalah penerapan OOP yang benar (Enkapsulasi).

HelloFunctional: Menggunakan struktur Lists (labelData, nilaiData) dan Java Stream API (IntStream.range().forEach() dan .stream().sum()) untuk memproses data. Hal ini menunjukkan pendekatan deklaratif, di mana kita mendeskripsikan apa yang harus dilakukan (iterate dan sum) daripada bagaimana melakukannya (loop for tradisional).


2. Kendala yang dihadapi dan cara mengatasinya.

Kendala 1: Error "The public type HelloFunctional must be defined in its own file" (di mana Hellofunctional.java tidak cocok dengan HelloFunctional).

Penyelesaian 1: Mengganti nama file menjadi HelloFunctional.java untuk memastikan case-sensitivity nama class dan nama file sudah sama persis, sesuai aturan Java.

Kendala 2: Memastikan output kode OOP dan Fungsional tetap mengikuti style yang ringkas (satu baris untuk data) sambil mempertahankan struktur inti paradigmanya.

Penyelesaian 2: Logika pencetakan (System.out.println) dimasukkan ke dalam method objek (OOP) atau diletakkan langsung setelah deklarasi variabel (Fungsional) untuk menjaga output konsisten.
 
3. Perbedaan pendekatan minggu ini dengan sebelumnya
Minggu Sebelumnya: Umumnya berfokus pada teori sekilas dan dasar-dasar awal pemrograman Java, seperti struktur class dasar, method main(), dan mungkin hanya membahas variable lokal atau hello world sederhana. Tujuannya adalah setup dan pemahaman konsep dasar praktikum.

Minggu Ini : Fokus bergeser ke implementasi komparatif dari tiga paradigma sekaligus (Prosedural, OOP, dan Fungsional). Kami secara eksplisit membedakan cara mengorganisasi kode: dari kode yang straightforward (Prosedural), kode yang modular dan object-based (OOP), hingga kode yang deklaratif dan functional (Fungsional). Perbedaan ini menunjukkan pendalaman dalam struktur dan design pattern kode.

---

## Kesimpulan
Praktikum ini menegaskan bahwa Java mampu mendukung berbagai paradigma (Prosedural, OOP, dan Fungsional), meskipun ia adalah bahasa yang berakar kuat pada OOP. Pendekatan OOP adalah yang paling terstruktur untuk pengembangan aplikasi besar karena mengorganisasi kode berdasarkan objek dunia nyata. Pendekatan Fungsional sangat efisien untuk pemrosesan koleksi data yang ringkas dan bebas side-effects (efek samping). Pilihan paradigma harus didasarkan pada kompleksitas dan jenis tugas yang dikerjakan.
---

## Quiz
1. Apakah OOP selalu lebih baik dari prosedural? 
**JAWABAN**: Tidak selalu. OOP lebih baik untuk aplikasi besar, kompleks, dan yang membutuhkan maintainability tinggi (karena fitur enkapsulasi dan pewarisan). Namun, untuk program kecil, tugas sederhana, atau script cepat, prosedural sering kali lebih sederhana, lebih cepat ditulis, dan memiliki overhead yang lebih rendah.

2. Kapan functional programming lebih cocok digunakan dibanding OOP atau prosedural? 
**JAWABAN**: Pemrograman fungsional lebih cocok digunakan saat memproses koleksi data yang besar (misalnya, List, Array), ketika operasi data harus bebas side-effects, dan ketika logika dapat diekspresikan sebagai pipa/aliran fungsi (seperti map, filter, reduce). Contohnya termasuk query database, pemrosesan data, atau operasi matematika yang kompleks.

3. Bagaimana paradigma (prosedural, OOP, fungsional) memengaruhi maintainability dan scalability aplikasi? 
**JAWABAN**: Prosedural: Maintainability dan Scalability rendah untuk proyek besar. Perubahan pada satu bagian dapat dengan mudah memengaruhi bagian lain (spaghetti code).

OOP: Maintainability dan Scalability tinggi. Enkapsulasi melindungi data, dan pewarisan memungkinkan penambahan fitur baru tanpa mengubah kode lama. Kode terstruktur berdasarkan tanggung jawab objek.

Fungsional: Maintainability tinggi karena fungsinya murni (bebas side-effects) sehingga mudah diuji dan dijamin perilakunya. Scalability (terutama dalam lingkungan multi-threading) juga tinggi karena data immutable.

4. Mengapa OOP lebih cocok untuk mengembangkan aplikasi POS dibanding prosedural? 
**JAWABAN**:  OOP lebih cocok karena aplikasi POS (Point of Sale) melibatkan banyak entitas dunia nyata yang saling berinteraksi (misalnya, Produk, Pelanggan, Transaksi, Karyawan). OOP memungkinkan setiap entitas ini direpresentasikan sebagai Objek dengan atribut (harga, stok, nama) dan perilaku (hitung diskon, cetak struk), sehingga kode lebih modular, terstruktur, dan mudah ditambahkan fitur baru (misalnya, menambahkan metode pembayaran baru) tanpa mengganggu entitas lain.

5. Bagaimana paradigma fungsional dapat membantu mengurangi kode berulang (boilerplate code)? 
**JAWABAN**: Paradigma fungsional, terutama melalui Lambda Expressions dan Streams di Java, mengurangi boilerplate code yang terkait dengan looping (iterasi) dan manipulasi koleksi. Alih-alih menulis loop for yang panjang dan eksplisit dengan logika if/else untuk setiap iterasi, fungsional memungkinkan penggunaan method deklaratif seperti filter(), map(), atau reduce(), yang secara ringkas menyatakan maksud operasi, bukan langkah demi langkah cara melakukannya.

