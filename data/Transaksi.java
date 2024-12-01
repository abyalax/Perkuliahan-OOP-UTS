package data;

import utils.Utils;

public class Transaksi {
    Pelanggan pelanggan;
    double totalPembayaran;

    public Transaksi(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
        this.totalPembayaran = 0;
    }

    public void hitungTotalPembayaran() {
        for (Buku buku : this.pelanggan.getDaftarBuku()) {
            this.totalPembayaran += buku.getHarga() * buku.getJumlahBeli();
        }
    }

    public void tampilkanStruk() {
        System.out.println("Nama Pelanggan   : " + this.pelanggan.getNama());
        System.out.println("Buku yang dibeli :");
        for (Buku buku : this.pelanggan.getDaftarBuku()) {
            buku.tampilkanPembelianBuku();
        }
        System.out.println("\nTotal Pembayaran   : " + Utils.formatRupiah(this.totalPembayaran));
    }
    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public double getTotalPembayaran() {
        return totalPembayaran;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public void setTotalPembayaran(double totalPembayaran) {
        this.totalPembayaran = totalPembayaran;
    }

    @Override
    public String toString() {
        return String.format("""
                Nama Pelanggan   : %s
                Buku yang dibeli :
                 - %s
                Total Pembayaran : %s
                """, this.pelanggan.getNama(), this.pelanggan.getDaftarDetailBuku(), Utils.formatRupiah(this.totalPembayaran));
    }
}