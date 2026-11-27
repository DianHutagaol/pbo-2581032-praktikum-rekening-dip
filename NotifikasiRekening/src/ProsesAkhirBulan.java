public class ProsesAkhirBulan {
    private final Notifikasi notifikasi;

    // Constructor Injection untuk menyuntikkan dependency Notifikasi [2]
    public ProsesAkhirBulan(Notifikasi notifikasi) {
        this.notifikasi = notifikasi;
    }

    public void potongBiayaAdmin(Rekening[] semua) {
        for (Rekening r : semua) {
            int biaya = r.potongBiayaAdmin();
            notifikasi.kirim(r.getNomor(), "biaya admin " + Rekening.formatRupiah(biaya));
        }
    }

    public void tambahBunga(BerBunga[] berbunga) {
        for (BerBunga b : berbunga) {
            int bunga = b.tambahBunga();
            notifikasi.kirim(b.getNomor(), "bunga " + Rekening.formatRupiah(bunga));
        }
    }

    // Menerima parameter bertipe interface BisaDitarik[] [2]
    public void autodebet(BisaDitarik[] bisaDitarik, int jumlah) {
        for (BisaDitarik bd : bisaDitarik) {
            boolean sukses = bd.tarik(jumlah);
            String status = sukses ? "berhasil" : "gagal";
            notifikasi.kirim(bd.getNomor(), "autodebet " + Rekening.formatRupiah(jumlah) + " " + status);
        }
    }
}