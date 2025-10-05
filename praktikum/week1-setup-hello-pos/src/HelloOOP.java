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