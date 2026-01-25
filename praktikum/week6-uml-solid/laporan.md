# Laporan Praktikum Minggu 6
Topik: Desain Arsitektur Sistem dengan UML dan Prinsip SOLID

## Identitas
- Nama  : M Khamdan A
- NIM   : 240202839
- Kelas : 3ikra

---

## Tujuan
Mahasiswa mampu mengidentifikasi kebutuhan sistem ke dalam diagram UML

Mahasiswa mampu menggambar UML Class Diagram dengan relasi antar class yang tepat

Mahasiswa mampu menjelaskan prinsip desain OOP (SOLID)

Mahasiswa mampu menerapkan minimal dua prinsip SOLID dalam kode program
---

## Dasar Teori
(Tuliskan ringkasan teori singkat (3–5 poin) yang mendasari praktikum.  
Contoh:  
1. Class adalah blueprint dari objek.  
2. Object adalah instansiasi dari class.  
3. Enkapsulasi digunakan untuk menyembunyikan data.)

---

## Langkah Praktikum
1. UML (Unified Modeling Language) adalah bahasa standar untuk memvisualisasikan, menspesifikasikan, membangun, dan mendokumentasikan artefak dari sistem perangkat lunak.

2. Use Case Diagram menggambarkan interaksi antara aktor (pengguna sistem) dengan fungsionalitas (use case) yang disediakan sistem.

3. Class Diagram menunjukkan struktur statis sistem dalam bentuk kelas, atribut, operasi, dan hubungan antar kelas.

4. Prinsip SOLID adalah lima prinsip desain yang bertujuan membuat perangkat lunak lebih mudah dipahami, fleksibel, dan dapat dipelihara.

5. Dependency Inversion Principle menyatakan bahwa modul tingkat tinggi tidak boleh bergantung pada modul tingkat rendah, tetapi keduanya harus bergantung pada abstraksi.

---

## Kode Program
(Tuliskan kode utama yang dibuat, contoh:  
activity.puml
```puml
@startuml
' Mengatur gaya garis agar siku-siku (Orthogonal)
skinparam linestyle ortho
skinparam monochrome true
skinparam shadowing false

|Pelanggan|
start
:Serahkan barang ke kasir;

|Kasir|
:Scan item dan mulai checkout;

|POS System|
:Ambil daftar item dari Cart;
:Hitung total belanja;

|Pelanggan|
:Pilih metode pembayaran;

|Kasir|
:Menginput metode ke sistem;

|POS System|
if (Metode = E-Wallet?) then (ya)
    |PaymentService|
    :Validasi saldo e-wallet;
    if (Saldo cukup?) then (kurang)
        |POS System|
        :Tampilkan error "Saldo tidak cukup";
        |Kasir|
        :Minta pelanggan memilih tunai;
        |Pelanggan|
        :Berikan uang tunai;
        |Kasir|
        :Input uang tunai;
        |PaymentService|
        goto bayar_tunai
    else (cukup)
        :Kurangi saldo;
    endif
else (Tunai)
    |Pelanggan|
    :Berikan uang tunai;
    |Kasir|
    :Input uang tunai;
    |PaymentService|
    label bayar_tunai
    :Validasi uang tunai;
    :Proses pembayaran tunai;
endif

|POS System|
:Simpan transaksi;

|Kasir|
:Tampilkan / Cetak Struk;

|Pelanggan|
:Ambil struk;
stop
@enduml
```
class.puml
```puml
@startuml
skinparam monochrome true
skinparam shadowing false
skinparam classAttributeIconSize 0
skinparam linestyle ortho

' 1. Single Responsibility: Memisahkan Produk, Transaksi, dan Laporan
class Produk {
    - kodeProduk: String
    - nama: String
    - harga: double
    - stok: int
    + kurangiStok(jumlah: int)
    + updateHarga(hargaBaru: double)
}

class Keranjang {
    - daftarItem: List<Produk>
    + tambahProduk(p: Produk)
    + hapusProduk(p: Produk)
    + hitungTotal(): double
}

' 2. Open/Closed & Dependency Inversion: Menggunakan Interface untuk Pembayaran
interface IPembayaran {
    + prosesBayar(total: double): boolean
}

class BayarTunai {
    - jumlahDiterima: double
    + prosesBayar(total: double): boolean
    + hitungKembalian(total: double): double
}

class BayarEWallet {
    - idAkun: String
    + prosesBayar(total: double): boolean
}

' 3. Transaksi bergantung pada Abstraksi (IPembayaran), bukan kelas konkret
class Transaksi {
    - idTransaksi: String
    - tanggal: Date
    - totalHarga: double
    + selesaikanTransaksi(metode: IPembayaran)
}

class LaporanPenjualan {
    + buatLaporanHarian()
    + buatLaporanPeriodik(tglMulai: Date, tglSelesai: Date)
}

' Relasi
Keranjang "1" *-- "many" Produk : berisi
Transaksi "1" o-- "1" Keranjang : menggunakan
Transaksi ..> IPembayaran : memanggil
IPembayaran <|.. BayarTunai : implementasi
IPembayaran <|.. BayarEWallet : implementasi
LaporanPenjualan ..> Transaksi : merangkum

@enduml
```
sequence.puml
```puml
@startuml
' Konfigurasi gaya minimalis
skinparam sequenceMessageAlign direction
skinparam monochrome true
skinparam shadowing false
skinparam participantPadding 30
skinparam boxPadding 10

actor "Pelanggan" as P
actor "Kasir" as K
participant "Sistem POS" as S
participant "Keranjang" as C
participant "LayananPembayaran" as LP

' Alur Utama
P -> K : Serahkan barang belanjaan
K -> S : mulaiCheckout()
S -> C : ambilDaftarBarang()
C --> S : daftarBarang
S -> LP : hitungTotal()
LP --> S : totalHarga

' Skenario E-Wallet
P -> K : Pilih E-Wallet
K -> S : pilihMetodeBayar("E-Wallet")
S -> LP : validasiEWallet(totalHarga)

' Menggunakan Note atau Label sebagai pengganti kotak Alt agar bersih
note over LP, S : Jika Saldo Kurang
LP -->> S : statusGagal
S -->> K : tampilkanPesan("Saldo Kurang")
K -->> P : Minta bayar tunai

' Alur Berlanjut ke Tunai
note over LP, S : Jika Saldo Cukup / Bayar Tunai
P -> K : Berikan uang tunai
K -> S : pilihMetodeBayar("Tunai")
S -> LP : prosesBayarTunai()
LP -> S : statusBerhasil
S -> S : simpanTransaksi()
S -> K : tampilkanStruk()
K -> P : Berikan struk fisik

@enduml
```
usecase.puml
```puml
@startuml
left to right direction
skinparam shadowing false

actor "Kasir" as K
actor "Admin" as A

rectangle "Sistem Agri-POS" {
    ' Daftar semua Use Case langsung di sini
    usecase "Login & Hak Akses" as UC1
    usecase "Kelola Data Produk" as UC2
    usecase "Update Stok Pertanian" as UC3
    usecase "Input Keranjang Belanja" as UC4
    usecase "Hitung Total Transaksi" as UC5
    usecase "Proses Pembayaran\n(Tunai/E-Wallet)" as UC6
    usecase "Cetak Struk" as UC7
    usecase "Lihat Laporan Penjualan" as UC8
}

' Hubungan Aktor Admin
A --> UC1
A --> UC2
A --> UC3
A --> UC8

' Hubungan Aktor Kasir
K --> UC1
K --> UC4
K --> UC5
K --> UC6
K --> UC7

' Hubungan antar Use Case (Relasi Logika)
UC4 ..> UC5 : <<include>>
UC6 ..> UC7 : <<include>>

@enduml
```

)
---

## Hasil Eksekusi
https://github.com/mhamdana/oop-202501-240202839/blob/main/praktikum/week6-uml-solid/doc/activitydiagram.png
https://github.com/mhamdana/oop-202501-240202839/blob/main/praktikum/week6-uml-solid/doc/classdiagram.png
https://github.com/mhamdana/oop-202501-240202839/blob/main/praktikum/week6-uml-solid/doc/squecediagram.png
https://github.com/mhamdana/oop-202501-240202839/blob/main/praktikum/week6-uml-solid/doc/usecase.png
---

## Analisis
-Bagaimana kode berjalan: Tidak ada implementasi kode pada minggu ini, hanya desain arsitektur menggunakan diagram UML (Use Case, Activity, Sequence, Class).

-Perbedaan pendekatan: Minggu lalu fokus pada implementasi kode konkret (abstraction-interface), sedangkan minggu ini fokus pada desain sistem secara makro menggunakan diagram UML sebelum coding.

-Kendala dan solusi:

Kendala menjaga konsistensi antar diagram → diselesaikan dengan tabel traceability

Kendala menerapkan SOLID dalam konsep → diselesaikan dengan desain interface IPembayaran yang menerapkan OCP dan DIP

---

## Kesimpulan
*Dengan menggunakan diagram UML (Use Case, Activity, Sequence, dan Class Diagram), desain arsitektur sistem Agri-POS menjadi lebih terstruktur, terdokumentasi dengan baik, dan siap untuk diimplementasikan. Penerapan prinsip SOLID, khususnya melalui interface IPembayaran, memastikan sistem bersifat modular, mudah diperluas dengan metode pembayaran baru, dan lebih mudah dipelihara.*

---

## Quiz
1. Jelaskan perbedaan aggregation dan composition serta berikan contoh penerapannya pada desain Anda.
**Jawaban**: Aggregation: Hubungan "has-a" yang longgar, dimana child object dapat hidup mandiri tanpa parent. Contoh: Hubungan antara Keranjang dan Produk - sebuah Produk dapat ada di banyak Keranjang dan tetap eksis meskipun Keranjang dihapus.

Composition: Hubungan "has-a" yang kuat, dimana lifecycle child object sepenuhnya bergantung pada parent. Contoh: Hubungan antara Transaksi dan ItemTransaksi (walau belum dimodelkan detail) - ItemTransaksi hanya bermakna dalam konteks Transaksi induknya.
2. Bagaimana prinsip Open/Closed dapat memastikan sistem mudah dikembangkan? 
**Jawaban**: Prinsip Open/Closed memastikan sistem mudah dikembangkan dengan memungkinkan penambahan fitur baru tanpa mengubah kode yang sudah ada. Contoh pada desain: Untuk menambah metode pembayaran baru seperti BayarQRIS, cukup buat class baru yang implement IPembayaran, tanpa perlu mengubah class Transaksi atau komponen lain yang sudah berjalan.
3. Mengapa Dependency Inversion Principle (DIP) meningkatkan testability? Berikan contoh penerapannya. 
**Jawaban**: DIP meningkatkan testability karena memisahkan modul melalui abstraksi, sehingga memungkinkan penggunaan mock object. Contoh: Class Transaksi bergantung pada interface IPembayaran, bukan implementasi konkret. Saat testing, kita bisa buat MockPembayaran untuk mensimulasikan berbagai skenario tanpa bergantung pada implementasi pembayaran sebenarnya, membuat testing lebih cepat dan terisolasi.
