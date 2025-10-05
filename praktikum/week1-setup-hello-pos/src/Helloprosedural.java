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