# Project UTS - Manajemen Toko Buku

Buat program Java berbasis OOP yang mensimulasikan manajemen sebuah toko buku. Program harus mencakup fungsionalitas berikut:

## Ketentuan Umum:
1. Buatlah sebuah class utama bernama `Main` untuk menjalankan program.
2. Gunakan paradigma Object-Oriented Programming:
   - Setidaknya ada 3 class utama: `Buku`, `Pelanggan`, dan `Transaksi`.
   - Class-class tersebut harus memiliki atribut dan metode sesuai deskripsi tugas di bawah.

---

## Deskripsi Class:

### 1. Class Buku
- **Atribut**:
  - `String kodeBuku` - kode unik buku.
  - `String judul` - judul buku.
  - `double harga` - harga buku.
  - `int stok` - jumlah stok buku.
- **Metode**:
  - Constructor untuk menginisialisasi objek buku.
  - `tampilkanInfo()` - Menampilkan informasi buku (kode, judul, harga, stok).
  - `kurangiStok(int jumlah)` - Mengurangi stok buku berdasarkan jumlah tertentu.

### 2. Class Pelanggan
- **Atribut**:
  - `String nama` - nama pelanggan.
  - `String id` - ID pelanggan.
  - `ArrayList<Buku>` - daftar buku yang dibeli pelanggan.
- **Metode**:
  - Constructor untuk menginisialisasi pelanggan.
  - `tambahkanBuku(Buku buku, int jumlah)` - Menambahkan buku ke daftar belanja.
  - `tampilkanBukuYangDibeli()` - Menampilkan buku-buku yang telah dibeli pelanggan.

### 3. Class Transaksi
- **Atribut**:
  - `Pelanggan pelanggan` - objek pelanggan yang melakukan transaksi.
  - `double totalPembayaran` - total pembayaran transaksi.
- **Metode**:
  - Constructor untuk menginisialisasi transaksi.
  - `hitungTotalPembayaran()` - Menghitung total pembayaran berdasarkan harga buku yang dibeli.
  - `tampilkanStruk()` - Menampilkan detail transaksi: nama pelanggan, buku yang dibeli, dan total pembayaran.

---

## Fungsionalitas Program:
1. Program meminta pengguna untuk memasukkan data awal beberapa buku (gunakan looping untuk input data).
2. Pengguna dapat membuat pelanggan baru dan menambahkan buku ke keranjang belanja.
3. Saat pelanggan selesai berbelanja, program membuat objek `Transaksi` untuk menghitung total pembayaran.
4. Tampilkan struk transaksi.

---

## Output Program
![Output Program](./output.png)
