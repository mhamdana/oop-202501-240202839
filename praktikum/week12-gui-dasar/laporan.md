# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Nama Mahasiswa]
- NIM   : [NIM Mahasiswa]
- Kelas : [Kelas]

---

## Tujuan
Menjelaskan konsep event-driven programming pada JavaFX.

Membangun antarmuka grafis sederhana untuk form input data produk Agri-POS.

Mengintegrasikan GUI dengan modul backend (DAO & Service) yang telah dibuat sebelumnya.

Merealisasikan desain Bab 6 (UML & SOLID) ke dalam implementasi kode nyata.
---

## Dasar Teori
Event-Driven Programming: Paradigma pemrograman di mana alur program ditentukan oleh peristiwa (event) seperti klik tombol atau input pengguna.

JavaFX Layouts: Penggunaan kontainer seperti GridPane untuk mengatur posisi komponen UI secara terstruktur (baris dan kolom).

Dependency Inversion Principle (DIP): Prinsip di mana View tidak boleh memanggil DAO secara langsung; akses data harus melalui layer Service.

MVC (Model-View-Controller): Pemisahan logika data (Model), tampilan (View), dan jembatan antar keduanya (Controller) agar kode lebih mudah dikelola.

---

## Langkah Praktikum
Pembuatan View: Menyusun komponen UI (TextField, Label, Button) di dalam class ProductFormView menggunakan GridPane.

Implementasi DAO & Service: Menyiapkan ProductDAOImpl sebagai penyedia logika akses data dan ProductService sebagai perantara.

Penyambungan Controller: Membuat ProductController (sesuai arsitektur MVC) untuk menangani action event dari tombol di View.

Eksekusi Aplikasi: Menjalankan aplikasi melalui AppJavaFX yang menginisialisasi Scene dan Stage.

Commit Progress: Melakukan commit dengan pesan week12-gui-dasar: [fitur] [deskripsi].

---

## Kode Program
(Tuliskan kode utama yang dibuat, contoh:  

```java
public class ProductDAOImpl implements ProductDAO {
    @Override
    public void insert(Product product) throws Exception {
        System.out.println("Data tersimpan: " + product.getName());
    }
    // ... method update, delete, findByCode lainnya
}
```

```java
public class ProductService {
    private ProductDAO dao = new ProductDAOImpl(); 

    public void addProduct(Product p) throws Exception { 
        dao.insert(p);
    }
}
```

```java
public class ProductFormView {
    public TextField txtCode = new TextField();
    public TextField txtName = new TextField();
    public Button btnAdd = new Button("Add Product");
    public ListView<String> listView = new ListView<>();

    public Parent getLayout() {
        GridPane grid = new GridPane();
        // ... layouting logic
        grid.add(new Label("Code:"), 0, 0);  grid.add(txtCode, 1, 0);
        grid.add(btnAdd, 1, 4);
        return grid;
    }
}
```

)
---

## Hasil Eksekusi
![alt text](<screenshots/Cuplikan layar 2026-01-23 162438.png>)
---

## Analisis
Analisis Alur: Saat tombol "Add Product" diklik, Event Handler menangkap data dari TextField, membungkusnya dalam objek Product, lalu mengirimkannya ke ProductService untuk disimpan melalui ProductDAO.

Traceability Bab 6: Implementasi ini mengikuti desain UML sebelumnya. Nama kelas dan metode (seperti addProduct) dijaga agar tetap konsisten dengan rancangan Sequence Diagram.

Kendala: Awalnya terdapat kesalahan pemanggilan metode antara tambahProduk dan addProduct. Solusi: Menyesuaikan nama metode di ProductService agar sesuai dengan desain interface di Bab 6.

| Artefak Bab 6 | Referensi            | Handler GUI                     | Controller/Service                              | DAO                        | Dampak UI/DB                         |
|---------------|----------------------|---------------------------------|-------------------------------------------------|----------------------------|--------------------------------------|
| Use Case      | UC-01 Tambah Produk  | btnAdd (ProductFormView)        | ProductService.addProduct()                     | ProductDAOImpl.insert()    | UI list bertambah + Log data tersimpan |
| Activity      | AD-01 Tambah Produk  | btnAdd.setOnAction              | ProductController menangkap data input          | ProductDAOImpl.insert()    | Validasi → Simpan → Tampil            |
| Sequence      | SD-01 Tambah Produk  | Tombol Tambah                   | View → Controller → Service                     | ProductDAOImpl.insert()    | Urutan panggilan sesuai SD            |


---

## Kesimpulan
Implementasi GUI menggunakan JavaFX berhasil mengintegrasikan layer backend yang telah dibuat sebelumnya. Dengan menerapkan pola MVC dan prinsip SOLID (DIP), kode menjadi lebih terstruktur di mana View hanya fokus pada presentasi dan penanganan event, sementara logika bisnis tetap berada di layer Service dan DAO.

---
