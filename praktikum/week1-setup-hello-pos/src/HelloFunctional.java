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