// 1. Kelas Bank (Parent Class) yang menerapkan Method Overloading
class Bank {
    
    // Method Overloading 1: Transfer ke rekening lain (asumsi sesama bank)
    public void transferUang(int jumlah, String rekeningTujuan) {
        System.out.println("Transfer Rp" + jumlah + " ke rekening " + rekeningTujuan + " diproses.");
        System.out.println("Biaya Transfer: Rp0 (Sesama Bank)");
    }

    // Method Overloading 2: Transfer ke rekening lain di bank berbeda
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        System.out.println("Transfer Rp" + jumlah + " ke rekening " + rekeningTujuan + " di Bank " + bankTujuan + " diproses.");
        System.out.println("Biaya Transfer: Rp" + hitungBiayaTransfer("Umum", bankTujuan));
    }

    // Method Overloading 3: Transfer dengan tambahan pesan/berita
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        System.out.println("Transfer Rp" + jumlah + " ke rekening " + rekeningTujuan + " di Bank " + bankTujuan + " diproses.");
        System.out.println("Berita: " + berita);
        System.out.println("Biaya Transfer: Rp" + hitungBiayaTransfer("Umum", bankTujuan));
    }

    // Method untuk Suku Bunga (akan di-override nanti)
    public void sukuBunga() {
        System.out.println("Suku Bunga standar adalah 3%");
    }

    // [Bonus Challenge] Method helper untuk menghitung biaya transfer
    protected int hitungBiayaTransfer(String bankAsal, String bankTujuan) {
        if (bankAsal.equalsIgnoreCase(bankTujuan)) {
            return 0; // Gratis jika bank asal dan tujuan sama
        } else {
            return 6500; // Biaya antar bank
        }
    }
}

// 2. Kelas BankBNI (Child Class) yang menerapkan Method Overriding
class BankBNI extends Bank {
    
    // Overriding method sukuBunga
    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga dari BNI adalah : 4%");
    }

    // Overriding method transferUang (menambahkan identitas BNI & cek biaya)
    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = hitungBiayaTransfer("BNI", bankTujuan);
        System.out.println("[Sistem BNI] Transfer Rp" + jumlah + " ke rek " + rekeningTujuan + " di Bank " + bankTujuan);
        System.out.println("[Sistem BNI] Biaya Transfer: Rp" + biaya);
    }
}

// 3. Kelas BankBCA (Child Class) yang menerapkan Method Overriding
class BankBCA extends Bank {
    
    // Overriding method sukuBunga
    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga dari BCA adalah : 4.5%");
    }

    // Overriding method transferUang (menambahkan identitas BCA & cek biaya)
    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = hitungBiayaTransfer("BCA", bankTujuan);
        System.out.println("[Sistem BCA] Transfer Rp" + jumlah + " ke rek " + rekeningTujuan + " di Bank " + bankTujuan);
        System.out.println("[Sistem BCA] Biaya Transfer: Rp" + biaya);
    }
}

// 4. Kelas Utama untuk menguji jalannya program
public class Main {
    public static void main(String[] args) {
        System.out.println("=== PENGUJIAN KELAS BANK (OVERLOADING) ===");
        Bank bankUmum = new Bank();
        bankUmum.sukuBunga();
        bankUmum.transferUang(50000, "12345678"); // Memanggil variasi 1
        System.out.println("---");
        bankUmum.transferUang(100000, "87654321", "Mandiri"); // Memanggil variasi 2
        System.out.println("---");
        bankUmum.transferUang(150000, "11223344", "BRI", "Pembayaran kos"); // Memanggil variasi 3
        
        System.out.println("\n=== PENGUJIAN KELAS BANK BNI (OVERRIDING) ===");
        BankBNI bni = new BankBNI();
        bni.sukuBunga();
        bni.transferUang(200000, "99887766", "BNI"); // Ke sesama BNI (biaya 0)
        System.out.println("---");
        bni.transferUang(300000, "55443322", "BCA"); // Ke bank lain (biaya 6500)

        System.out.println("\n=== PENGUJIAN KELAS BANK BCA (OVERRIDING) ===");
        BankBCA bca = new BankBCA();
        bca.sukuBunga();
        bca.transferUang(500000, "10203040", "BCA"); // Ke sesama BCA (biaya 0)
        System.out.println("---");
        bca.transferUang(750000, "50607080", "Mandiri"); // Ke bank lain (biaya 6500)
    }
}