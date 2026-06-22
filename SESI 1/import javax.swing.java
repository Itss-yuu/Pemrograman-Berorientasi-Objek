import javax.swing.JOptionPane;

public class SoalDua {
    public static void main(String[] args) {
        // 1. Menampilkan kotak dialog Input
        String inputBelajar = JOptionPane.showInputDialog(
                null, 
                "Anda sedang belajar apa?", 
                "Input", 
                JOptionPane.QUESTION_MESSAGE
        );

        // 2. Mengecek apakah input tidak kosong (user menekan OK)
        if (inputBelajar != null && !inputBelajar.trim().isEmpty()) {
            // Menampilkan kotak dialog Message dengan hasil inputan
            JOptionPane.showMessageDialog(
                    null, 
                    "Belajar " + inputBelajar + " sangat mudah", 
                    "Message", 
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}