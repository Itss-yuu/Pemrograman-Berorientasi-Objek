import java.util.ArrayList;
import java.util.Scanner;

// 1. Class Objek Mahasiswa
class Mahasiswa {
    String nim;
    String nama;
    int nilai;
    String grade;
    boolean isLulus;

    // Constructor
    public Mahasiswa(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
        tentukanGrade();
    }

    // Method untuk menentukan grade dan status kelulusan
    private void tentukanGrade() {
        if (nilai >= 80 && nilai <= 100) {
            this.grade = "A";
            this.isLulus = true;
        } else if (nilai >= 70 && nilai <= 79) {
            this.grade = "B";
            this.isLulus = true;
        } else if (nilai >= 60 && nilai <= 69) {
            this.grade = "C";
            this.isLulus = true;
        } else if (nilai >= 50 && nilai <= 59) {
            this.grade = "D";
            this.isLulus = false;
        } else {
            this.grade = "E";
            this.isLulus = false;
        }
    }

    // Method untuk menampilkan detail data
    public void cetakData() {
        System.out.println("NIM  : " + nim);
        System.out.println("Nama: " + nama);
        System.out.println("Nilai : " + nilai);
        System.out.println("Grade: " + grade);
        System.out.println("=========================================");
    }
}

// 2. Class Main / Program Utama
public class PenilaianMahasiswa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mahasiswa> daftarMhs = new ArrayList<>();

        System.out.print("Masukkan jumlah data mahasiswa yang akan diinput: ");
        int jumlahData = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer

        // Proses Input Data
        for (int i = 0; i < jumlahData; i++) {
            System.out.println("\n--- Data ke-" + (i + 1) + " ---");
            System.out.print("Masukkan NIM  : ");
            String nim = scanner.nextLine();

            System.out.print("Masukkan Nama : ");
            String nama = scanner.nextLine();

            int nilai = -1;
            boolean valid = false;

            // Validasi Input Nilai (0 - 100)
            while (!valid) {
                System.out.print("Masukkan Nilai: ");
                nilai = scanner.nextInt();
                scanner.nextLine(); // Membersihkan buffer

                if (nilai >= 0 && nilai <= 100) {
                    valid = true;
                } else {
                    System.out.println("Input nilai anda salah");
                }
            }

            // Memasukkan objek ke dalam ArrayList
            daftarMhs.add(new Mahasiswa(nim, nama, nilai));
        }

        // Variabel untuk menampung statistik rekapitulasi
        ArrayList<String> lulus = new ArrayList<>();
        ArrayList<String> tidakLulus = new ArrayList<>();
        ArrayList<String> gradeA = new ArrayList<>();
        ArrayList<String> gradeB = new ArrayList<>();
        ArrayList<String> gradeC = new ArrayList<>();
        ArrayList<String> gradeD = new ArrayList<>();
        ArrayList<String> gradeE = new ArrayList<>();
        ArrayList<String> deretNilai = new ArrayList<>();
        
        double totalNilai = 0;

        // Mencetak Layout Data Individu dan Memproses Statistik
        System.out.println("\n=========================================");
        for (Mahasiswa mhs : daftarMhs) {
            mhs.cetakData();

            // Pengelompokan status kelulusan
            if (mhs.isLulus) lulus.add(mhs.nama);
            else tidakLulus.add(mhs.nama);

            // Pengelompokan grade
            if (mhs.grade.equals("A")) gradeA.add(mhs.nama);
            else if (mhs.grade.equals("B")) gradeB.add(mhs.nama);
            else if (mhs.grade.equals("C")) gradeC.add(mhs.nama);
            else if (mhs.grade.equals("D")) gradeD.add(mhs.nama);
            else if (mhs.grade.equals("E")) gradeE.add(mhs.nama);

            deretNilai.add(String.valueOf(mhs.nilai));
            totalNilai += mhs.nilai;
        }

        // Mencetak Hasil Akhir (Rekapitulasi)
        System.out.println("Jumlah Mahasiswa : " + daftarMhs.size());
        
        if (!lulus.isEmpty()) {
            System.out.println("Jumlah Mahasiswa yg Lulus : " + lulus.size() + " yaitu " + String.join(", ", lulus));
        }
        if (!tidakLulus.isEmpty()) {
            System.out.println("Jumlah Mahasiswa yg Tidak Lulus : " + tidakLulus.size() + " yaitu " + String.join(", ", tidakLulus));
        }
        
        if (!gradeA.isEmpty()) System.out.println("Jumlah Mahasiswa dengan Nilai A = " + gradeA.size() + " yaitu " + String.join(", ", gradeA));
        if (!gradeB.isEmpty()) System.out.println("Jumlah Mahasiswa dengan Nilai B = " + gradeB.size() + " yaitu " + String.join(", ", gradeB));
        if (!gradeC.isEmpty()) System.out.println("Jumlah Mahasiswa dengan Nilai C = " + gradeC.size() + " yaitu " + String.join(", ", gradeC));
        if (!gradeD.isEmpty()) System.out.println("Jumlah Mahasiswa dengan Nilai D = " + gradeD.size() + " yaitu " + String.join(", ", gradeD));
        if (!gradeE.isEmpty()) System.out.println("Jumlah Mahasiswa dengan Nilai E = " + gradeE.size() + " yaitu " + String.join(", ", gradeE));

        // Mencetak Rata-rata
        double rataRata = totalNilai / daftarMhs.size();
        System.out.println("Rata-rata nilai mahasiswa adalah : " + String.join("+", deretNilai) + " / " + daftarMhs.size() + " = " + rataRata);
        
        scanner.close();
    }
}   