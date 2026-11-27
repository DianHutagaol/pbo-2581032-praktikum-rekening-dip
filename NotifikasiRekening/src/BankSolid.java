public class BankSolid {
    public static void main(String[] args) {
        Tabungan ani = new Tabungan("101", "Ani", 1000000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra", 300000, 2.0);
        Giro budi = new Giro("201", "Budi", 200000, 500000);
        Deposito dewi = new Deposito("301", "Dewi", 5000000, 4.0);

        Rekening[] semua = { ani, citra, budi, dewi };
        BerBunga[] berbunga = { ani, citra, dewi };

        // Ketentuan 5: Array hanya berisi objek yang meng-implement BisaDitarik [2]
        BisaDitarik[] bisaDitarik = { ani, citra, budi };

        // Ketentuan 6 Error Test:
        // BisaDitarik[] salah = { ani, dewi };
        // ERROR COMPILER: incompatible types: Deposito cannot be converted to BisaDitarik
        // Alasan: Deposito tidak meng-implement interface BisaDitarik [2].

        // Ketentuan 7 DIP Test:
        // Untuk mengganti pengiriman notifikasi dari EMAIL ke SMS, HANYA 1 BARIS di bawah ini yang diubah:
        // Notifikasi notifikasi = new SmsNotifikasi(); // (Ubah 1 baris ini tanpa menyentuh class ProsesAkhirBulan)
        Notifikasi notifikasi = new EmailNotifikasi();

        ProsesAkhirBulan proses = new ProsesAkhirBulan(notifikasi);
        LaporanBank laporan = new LaporanBank();

        laporan.cetakDaftar("========== REKENING AWAL ==========", semua);
        System.out.println();
        System.out.println("========== AKHIR BULAN ==========");
        proses.potongBiayaAdmin(semua);
        proses.tambahBunga(berbunga);
        proses.autodebet(bisaDitarik, 50000);
        System.out.println();
        laporan.cetakDaftar("========== REKENING AKHIR ==========", semua);
        laporan.cetakTotal(semua);
    }
}