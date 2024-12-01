import java.util.ArrayList;
import java.util.Scanner;
import data.Buku;
import data.Pelanggan;
import data.Transaksi;

public class MainClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Buku> daftarBuku = new ArrayList<>();
        ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();

        System.out.println("==== PROGRAM MANAJEMEN TOKO BUKU ====");
        // Program utama
        while (true) {

            // Menampilkan menu
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Menambahkan Buku");
            System.out.println("2. Menambahkan Pelanggan");
            System.out.println("3. Lakukan Transaksi");
            System.out.println("4. Clear Console");
            System.out.println("5. Keluar\n");
            System.out.print("Pilih menu (1-4): ");
            int pilihanMenu = Integer.parseInt(scanner.nextLine());

            switch (pilihanMenu) {
                case 1:
                    menambahkanBuku(scanner, daftarBuku);
                    break;
                case 2:
                    menambahkanPelanggan(scanner, daftarPelanggan);
                    break;
                case 3:
                    lakukanTransaksi(scanner, daftarBuku, daftarPelanggan);
                    break;
                case 4:
                    clearConsole();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }

    static void menambahkanBuku(Scanner scanner, ArrayList<Buku> daftarBuku) {
        // Menambahkan Buku
        System.out.println("\n=== Menambahkan Buku ===");
        System.out.print("Kode Buku   : ");
        String kodeBuku = scanner.nextLine();
        System.out.print("Judul Buku  : ");
        String judul = scanner.nextLine();
        System.out.print("Harga Buku  : ");
        double harga = Double.parseDouble(scanner.nextLine());
        System.out.print("Jumlah Stok : ");
        int stok = Integer.parseInt(scanner.nextLine());

        Buku buku = new Buku(kodeBuku, judul, harga, stok);
        daftarBuku.add(buku);
        System.out.println("Buku berhasil ditambahkan.");
    }

    static void menambahkanPelanggan(Scanner scanner, ArrayList<Pelanggan> daftarPelanggan) {
        // Menambahkan Pelanggan
        System.out.println("\n=== Membuat Pelanggan Baru ===");
        System.out.print("Nama Pelanggan: ");
        String namaPelanggan = scanner.nextLine();

        Pelanggan pelanggan = new Pelanggan(namaPelanggan);
        daftarPelanggan.add(pelanggan);

        System.out.println("Pelanggan berhasil dibuat.\n" + pelanggan);
    }

    static void lakukanTransaksi(Scanner scanner, ArrayList<Buku> daftarBuku,
            ArrayList<Pelanggan> daftarPelanggan) {
        // Cek apakah daftar pelanggan kosong
        Pelanggan pelanggan;
        if (daftarPelanggan.isEmpty()) {
            System.out.println("\n=== Tidak Ada Pelanggan Tersedia ===");
            System.out.println("Anda harus membuat pelanggan baru terlebih dahulu.");
            System.out.print("Nama Pelanggan: ");
            String namaPelanggan = scanner.nextLine();
            pelanggan = new Pelanggan(namaPelanggan);
            daftarPelanggan.add(pelanggan);
            System.out.println("Pelanggan berhasil ditambahkan: " + namaPelanggan + " (ID: " + pelanggan.getId() + ")");
        } else {
            System.out.println("\n=== Pilih Pelanggan untuk Transaksi ===");
            for (int i = 0; i < daftarPelanggan.size(); i++) {
                System.out.println((i + 1) + ". " + daftarPelanggan.get(i).getNama() + " (ID: "
                        + daftarPelanggan.get(i).getId() + ")");
            }
            System.out.print("Pilih pelanggan berdasarkan nomor (atau masukkan 0 untuk menambahkan pelanggan baru): ");
            int pilihanPelanggan = Integer.parseInt(scanner.nextLine());
            if (pilihanPelanggan == 0) {
                System.out.print("Nama Pelanggan Baru: ");
                String namaPelangganBaru = scanner.nextLine();
                pelanggan = new Pelanggan(namaPelangganBaru);
                daftarPelanggan.add(pelanggan);
                System.out.println(
                        "Pelanggan berhasil ditambahkan: " + namaPelangganBaru + " (ID: " + pelanggan.getId() + ")");
            } else if (pilihanPelanggan < 1 || pilihanPelanggan > daftarPelanggan.size()) {
                System.out.println("Pilihan tidak valid. Transaksi dibatalkan.");
                return;
            } else {
                pelanggan = daftarPelanggan.get(pilihanPelanggan - 1);
            }
        }

        // Cek apakah daftar buku kosong
        if (daftarBuku.isEmpty()) {
            System.out.println("\n=== Tidak Ada Buku Tersedia ===");
            System.out.println("Anda harus menambahkan buku terlebih dahulu.");
            while (true) {
                System.out.println("\n=== Tambahkan Buku Baru ===");
                System.out.print("Kode Buku   : ");
                String kodeBuku = scanner.nextLine();
                System.out.print("Judul Buku  : ");
                String judul = scanner.nextLine();
                System.out.print("Harga Buku  : ");
                double harga = Double.parseDouble(scanner.nextLine());
                System.out.print("Jumlah Stok : ");
                int stok = Integer.parseInt(scanner.nextLine());

                Buku bukuBaru = new Buku(kodeBuku, judul, harga, stok);
                daftarBuku.add(bukuBaru);
                System.out.println("Buku berhasil ditambahkan: " + judul);

                System.out.print("Apakah ingin menambahkan buku lagi? (Y/N): ");
                String pilihan = scanner.nextLine();
                if (pilihan.equalsIgnoreCase("N")) {
                    break;
                }
            }
        }

        // Menambahkan buku ke keranjang belanja
        System.out.println("\n=== Menambahkan Buku ke Keranjang ===");
        while (true) {
            System.out.println("\nDaftar Buku yang Tersedia:");
            for (int i = 0; i < daftarBuku.size(); i++) {
                System.out.println(
                        (i + 1) + ". " + daftarBuku.get(i).getJudul() + " (Stok: " + daftarBuku.get(i).getStok() + ")");
            }
            System.out.println("0. Selesai");
            System.out.print("\nPilih nomor buku untuk menambahkan ke keranjang ");
            int pilihanBuku = Integer.parseInt(scanner.nextLine());

            if (pilihanBuku == 0)
                break;
            if (pilihanBuku < 1 || pilihanBuku > daftarBuku.size()) {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                continue;
            }

            Buku bukuDipilih = daftarBuku.get(pilihanBuku - 1);

            System.out.print("Masukkan jumlah yang ingin dibeli: ");
            int jumlah = Integer.parseInt(scanner.nextLine());

            if (jumlah > bukuDipilih.getStok()) {
                System.out.println("Stok tidak mencukupi!");
            } else {
                pelanggan.tambahBukuKeKeranjang(bukuDipilih, jumlah);
                bukuDipilih.kurangiStok(jumlah);
                System.out.println("Buku berhasil ditambahkan ke keranjang!");
            }

            // Membuat transaksi dan menghitung total pembayaran
            Transaksi transaksi = new Transaksi(pelanggan);
            transaksi.hitungTotalPembayaran();

            // Tampilkan struk transaksi
            System.out.println("\n=== STRUK TRANSAKSI ===");
            transaksi.tampilkanStruk();
        }
    }

    static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++)
                System.out.println();
        }
    }

}
