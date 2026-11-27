public class SmsNotifikasi implements Notifikasi {
    @Override
    public void kirim(String nomor, String pesan) {
        // Tiga spasi sesudah SMS sesuai Ketentuan 3 [2]
        System.out.println("[SMS   " + nomor + "] " + pesan);
    }
}
