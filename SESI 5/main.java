import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SIMULASI PROGRAM AKADEMIK ===");

        // ==========================================
        // 1. SIMULASI DOSEN (TEACHER)
        // ==========================================
        System.out.println("\n[1] INPUT DATA DOSEN");
        System.out.print("Masukkan Nama Dosen: ");
        String teacherName = scanner.nextLine();
        System.out.print("Masukkan Alamat Dosen: ");
        String teacherAddress = scanner.nextLine();

        Teacher teacher = new Teacher(teacherName, teacherAddress);
        System.out.println("\nProfil: " + teacher.toString());

        // Mengampu mata kuliah
        System.out.println("\n* Dosen " + teacher.getName() + " akan menambah mata kuliah.");
        String[] mkDosen = {"Pemrograman Java", "Struktur Data", "Pemrograman Java"};
        for (String mk : mkDosen) {
            boolean status = teacher.addCourse(mk);
            if (status) {
                System.out.println("Berhasil menambah: " + mk);
            } else {
                System.out.println("Gagal menambah (Mata kuliah sudah ada): " + mk);
            }
        }

        // Menghapus mata kuliah
        System.out.println("\n* Menghapus mata kuliah 'Struktur Data'...");
        if (teacher.removeCourse("Struktur Data")) {
            System.out.println("Berhasil dihapus.");
        } else {
            System.out.println("Gagal dihapus (Mata kuliah tidak ditemukan).");
        }


        // ==========================================
        // 2. SIMULASI MAHASISWA (STUDENT)
        // ==========================================
        System.out.println("\n------------------------------------");
        System.out.println("\n[2] INPUT DATA MAHASISWA");
        System.out.print("Masukkan Nama Mahasiswa: ");
        String studentName = scanner.nextLine();
        System.out.print("Masukkan Alamat Mahasiswa: ");
        String studentAddress = scanner.nextLine();

        Student student = new Student(studentName, studentAddress);
        System.out.println("\nProfil: " + student.toString());

        // Input Nilai Mata Kuliah
        System.out.print("\nBerapa mata kuliah yang ingin diinput nilainya? ");
        int jmlMk = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer

        for (int i = 0; i < jmlMk; i++) {
            System.out.print("Nama Mata Kuliah ke-" + (i + 1) + ": ");
            String mk = scanner.nextLine();
            System.out.print("Nilai Mata Kuliah " + mk + ": ");
            int nilai = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer
            
            student.addCourseGrade(mk, nilai);
        }

        // Tampilkan Hasil Mahasiswa
        System.out.println("\n=== HASIL REKAP MAHASISWA ===");
        student.printGrades();
        System.out.println("Rata-rata Nilai: " + student.getAverageGrade());

        scanner.close();
    }
}