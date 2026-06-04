public class HandPhone {
    String jenis_hp;
    int tahun_pembuatan;

    // Perbaikan pada urutan modifier, tipe void, dan penggunaan 'this'
    public void setDataHP(String jenis_hp, int tahun_pembuatan) {
        this.jenis_hp = jenis_hp;
        this.tahun_pembuatan = tahun_pembuatan;
    }

    // Perbaikan body method dan menambahkan return value
    public String getJenisHP() {
        return jenis_hp;
    }

    // Perbaikan tipe data return menjadi int dan menambahkan return value
    public int getTahunPembuatan() {
        return tahun_pembuatan;
    }

    // Perbaikan urutan penulisan main method
    public static void main(String args[]) {
        HandPhone hp = new HandPhone();
        
        // Perbaikan pengisian argumen dengan nilai konkret/literal
        hp.setDataHP("Samsung", 2024);
        
        // Perbaikan agar nilai yang diambil dapat dicetak ke layar
        System.out.println(hp.getJenisHP());
        System.out.println(hp.getTahunPembuatan());
    }
}