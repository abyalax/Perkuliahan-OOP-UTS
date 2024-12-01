package data;

import java.util.ArrayList;

import utils.Utils;

public class Pelanggan {
    private String nama;
    private String id;
    private ArrayList<Buku> daftarBuku;

    public Pelanggan(String nama) {
        this.nama = nama;
        this.id = "PL-" + Utils.generateID();
        this.daftarBuku = new ArrayList<Buku>();
    }

    public void tambahBukuKeKeranjang(Buku buku, int jumlah) {
        buku.setJumlahBeli(jumlah);
        this.daftarBuku.add(buku);
    }

    public void tampilkanBukuYangDibeli() {
        for (Buku buku : this.daftarBuku) {
            buku.tampilkanInfo();
        }
    }

    @Override
    public String toString() {
        return String.format("""
                Nama        : %s
                ID          : %s
                Daftar Buku :
                 - %s
                """, this.nama, this.id, getDaftarJudulBuku());
    }

    // Getter dan Setter
    public String getDaftarJudulBuku() {
        String daftarBuku = "";
        for (Buku buku : this.daftarBuku) {
            daftarBuku += buku.getJudul() + "\n - ";
        }
        return daftarBuku;
    }

    // Getter dan Setter
    public String getDaftarDetailBuku() {
        String daftarBuku = "";
        for (Buku buku : this.daftarBuku) {
            daftarBuku += buku.getJudul() + " ( " + Utils.formatRupiah(buku.getHarga()) + " )" + "\n - ";
        }
        return daftarBuku;
    }

    public ArrayList<Buku> getDaftarBuku() {
        return daftarBuku;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setDaftarBuku(ArrayList<Buku> daftarBuku) {
        this.daftarBuku = daftarBuku;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
