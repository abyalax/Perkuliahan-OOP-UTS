package data;

import utils.Utils;

public class Buku {
    private String kodeBuku;
    private String judul;
    private double harga;
    private int stok;
    private int jumlahBeli;

    public Buku(String kodeBuku, String judul, double harga, int stok) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.harga = harga;
        this.stok = stok;
    }

    public void tampilkanInfo() {
        System.out.println("Kode Buku : " + this.kodeBuku);
        System.out.println("Judul     : " + this.judul);
        System.out.println("Harga     : " + Utils.formatRupiah(this.harga));
        System.out.println("Stok      : " + this.stok);
    }

    public void tampilkanPembelianBuku() {
        System.out.println("\n" + " Kode Buku  : " + this.kodeBuku);
        System.out.println(" Judul      : " + this.judul);
        System.out.println(" Harga      : " + Utils.formatRupiah(this.harga));
        System.out.println(" Jumlah     : " + this.jumlahBeli);
    }

    public void kurangiStok(int jumlah) {
        this.stok -= jumlah;
    }

    @Override
    public String toString() {
        return String.format("""
                Kode Buku  : %s
                Judul      : %s
                Harga      : %s
                Stok       : %s
                """, this.kodeBuku, this.judul, Utils.formatRupiah(this.harga), this.stok);
    }

    public int getJumlahBeli() {
        return jumlahBeli;
    }

    public String getJudul() {
        return judul;
    }

    public double getHarga() {
        return harga;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public int getStok() {
        return stok;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setJumlahBeli(int jumlahBeli) {
        this.jumlahBeli = jumlahBeli;
    }

}