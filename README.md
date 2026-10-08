# Sistem Manajemen Data Menu Restoran

## Nama: Muhammad Arzad
## Kelas: A'25
## NIM: 2509116014

---

## 1. Deskripsi Singkat Program

Sistem Manajemen Data Menu Restoran merupakan program berbasis Java yang digunakan untuk mengelola data kategori dan menu restoran. Program ini memiliki fitur untuk menambah, menampilkan, mengubah, dan menghapus data menu serta menambah dan menampilkan data kategori.

---

## 2. Tujuan Program

Program ini dibuat dengan beberapa tujuan, yaitu:

1. Membuat sistem sederhana untuk mengelola data menu restoran.
2. Menerapkan konsep Pemrograman Berorientasi Objek dalam bahasa Java.
3. Menerapkan encapsulation untuk menjaga data internal object.
4. Menerapkan inheritance melalui hubungan antara class `Menu`, `MenuMakanan`, dan `MenuMinuman`.
5. Menerapkan polymorphism melalui overriding dan overloading.
6. Menerapkan abstraction menggunakan abstract class dan abstract method.
7. Menerapkan struktur proyek MVC (Model, View, Controller).
8. Menerapkan interface sebagai nilai tambah.
9. Menggunakan `ArrayList` untuk menyimpan data kategori dan menu.
10. Menerapkan validasi input untuk mengurangi kesalahan saat pengguna memasukkan data.

---

## 3. Fitur Program

### 3.1 Tambah Kategori

Pengguna dapat menambahkan kategori baru dengan memasukkan:

- ID kategori
- Nama kategori
- Deskripsi kategori

Program akan melakukan pengecekan terhadap ID kategori untuk memastikan tidak terdapat ID kategori yang sama.

Jika ID kategori belum digunakan, data akan disimpan ke dalam daftar kategori.

### 3.2 Tampilkan Kategori

Program dapat menampilkan seluruh kategori yang telah tersimpan.

Informasi yang ditampilkan meliputi:

- ID kategori
- Nama kategori
- Deskripsi kategori

### 3.3 Tambah Menu

Pengguna dapat menambahkan menu baru dengan memasukkan:

- ID menu
- Nama menu
- Kategori
- Harga
- Jenis menu

Pengguna dapat memilih jenis menu:

1. Makanan
2. Minuman

Jika memilih makanan, program akan membuat object `MenuMakanan`.

Jika memilih minuman, program akan membuat object `MenuMinuman`.

Program juga melakukan pengecekan terhadap ID menu agar tidak terjadi duplikasi.

### 3.4 Tampilkan Menu

Program dapat menampilkan seluruh menu yang tersimpan.

Informasi yang ditampilkan menyesuaikan jenis menu.

Menu makanan akan menampilkan informasi tambahan berupa `jenisMakanan`, sedangkan menu minuman akan menampilkan informasi tambahan berupa `jenisMinuman`.

Proses ini menggunakan method `tampilkanInfo()` yang dioverride oleh masing-masing subclass.

### 3.5 Update Menu

Pengguna dapat memperbarui data menu berdasarkan ID menu.

Data yang dapat diperbarui meliputi:

- Nama menu
- Kategori
- Harga
- Jenis makanan atau jenis minuman

Program terlebih dahulu mencari menu berdasarkan ID yang dimasukkan. Jika menu ditemukan, data akan diperbarui sesuai dengan input pengguna.

### 3.6 Hapus Menu

Pengguna dapat menghapus menu berdasarkan ID menu.

Jika ID menu ditemukan, data menu akan dihapus dari daftar menu.

Jika ID menu tidak ditemukan, program akan memberikan pesan bahwa menu tidak tersedia.

### 3.7 Validasi Input

Program memiliki beberapa validasi untuk mengurangi kesalahan input, antara lain:

- Input tidak boleh kosong.
- Pilihan menu harus berupa angka.
- Pilihan harus berada pada rentang yang ditentukan.
- Harga harus berupa angka.
- Harga tidak boleh bernilai negatif.
- ID menu tidak boleh duplikat.
- ID kategori tidak boleh duplikat.
- Kategori yang dipilih harus tersedia.
- Persentase diskon harus berada antara 0 sampai 100.

### 3.8 Hitung Harga Setelah Diskon

Program menyediakan fitur untuk menghitung harga menu setelah mendapatkan diskon.

Pengguna dapat:

1. Memasukkan ID menu.
2. Melihat harga normal.
3. Memasukkan persentase diskon.
4. Melihat harga akhir setelah diskon.

Fitur ini juga digunakan untuk menerapkan polymorphism overloading melalui dua method:

```java
hitungHargaSetelahDiskon()
```

dan:

```java
hitungHargaSetelahDiskon(double persentaseDiskon)
```

---

## 4. Struktur Package

Program menggunakan struktur package yang menerapkan konsep MVC (Model, View, Controller).

```text
src/main/java/com/mycompany/sistemmanajemendatamenurestoran/
│
├── SistemManajemenDataMenuRestoran.java
│
├── controller/
│   └── RestoranController.java
│
├── model/
│   ├── Diskonable.java
│   ├── Kategori.java
│   ├── Menu.java
│   ├── MenuMakanan.java
│   ├── MenuMinuman.java
│   └── Restoran.java
│
└── view/
    └── RestoranView.java
```

### 4.1 Package `model`

Package `model` digunakan untuk menyimpan data dan proses pengelolaan data pada sistem.

Class yang terdapat di dalam package ini adalah:

- `Kategori`
- `Menu`
- `MenuMakanan`
- `MenuMinuman`
- `Restoran`
- `Diskonable`

### 4.2 Package `view`

Package `view` digunakan untuk menangani interaksi program dengan pengguna melalui console.

Class yang terdapat pada package ini adalah:

- `RestoranView`

Class tersebut menangani tampilan menu utama, input pengguna, validasi input, dan tampilan hasil program.

### 4.3 Package `controller`

Package `controller` digunakan untuk mengatur alur program dan menghubungkan View dengan Model.

Class yang terdapat pada package ini adalah:

- `RestoranController`

Controller menangani proses tambah kategori, tampil kategori, tambah menu, tampil menu, update menu, hapus menu, dan perhitungan harga setelah diskon.

### 4.4 Class Utama

`SistemManajemenDataMenuRestoran` merupakan class utama yang digunakan sebagai titik awal program.

Class ini membuat object `Restoran`, `RestoranView`, dan `RestoranController`, kemudian menjalankan program melalui `RestoranController`.

---

## 5. Penjelasan Class

### 5.1 `SistemManajemenDataMenuRestoran`

Class `SistemManajemenDataMenuRestoran` merupakan class utama yang menjadi titik awal program.

Class ini memiliki method `main()` yang digunakan untuk membuat object Model, View, dan Controller.

Contohnya:

```java
Restoran restoran =
        new Restoran(
                "Restoran Egiluy Sukses Dunia Akhirat Aamiin",
                "Jl. Alip Gelap Karena Lagi Malam",
                "081234567890"
        );

RestoranView view =
        new RestoranView();

RestoranController controller =
        new RestoranController(
                restoran,
                view
        );

controller.jalankanProgram();
```

Class utama tidak lagi menangani seluruh proses program karena proses tersebut telah dipisahkan ke dalam struktur MVC.

### 5.2 `RestoranController`

Class `RestoranController` digunakan untuk mengatur jalannya program.

Class ini menjadi penghubung antara `RestoranView` dengan class-class pada package `model`.

Proses yang ditangani antara lain:

- Inisialisasi data awal
- Tambah kategori
- Tampilkan kategori
- Tambah menu
- Tampilkan menu
- Update menu
- Hapus menu
- Hitung harga setelah diskon

### 5.3 `RestoranView`

Class `RestoranView` digunakan untuk menangani interaksi dengan pengguna melalui console.

Class ini menangani:

- Tampilan menu utama
- Input string
- Input pilihan
- Input harga
- Input persentase diskon
- Tampilan kategori
- Tampilan menu
- Tampilan hasil perhitungan diskon
- Validasi input

### 5.4 `Restoran`

Class `Restoran` digunakan untuk mengelola data yang terdapat pada sistem restoran.

Class ini menyimpan daftar menu dan daftar kategori menggunakan `ArrayList`.

Beberapa proses yang ditangani oleh class `Restoran` meliputi:

- Menambahkan kategori
- Mencari kategori
- Menambahkan menu
- Mencari menu
- Memperbarui menu
- Menghapus menu

Class `Restoran` juga melakukan pengecekan terhadap ID menu dan ID kategori agar tidak terjadi data dengan ID yang sama.

Selain itu, class ini menggunakan `Collections.unmodifiableList()` pada getter daftar menu dan daftar kategori sehingga daftar internal tidak dapat dimodifikasi secara langsung dari luar class.

### 5.5 `Kategori`

Class `Kategori` digunakan untuk merepresentasikan data kategori menu restoran.

Class ini memiliki attribute:

- `idKategori`
- `namaKategori`
- `deskripsi`

Attribute tersebut digunakan untuk menyimpan informasi kategori menu.

### 5.6 `Menu`

Class `Menu` merupakan abstract class yang digunakan sebagai dasar untuk jenis menu yang terdapat dalam program.

Class ini memiliki attribute:

- `idMenu`
- `namaMenu`
- `kategori`
- `harga`

Class `Menu` memiliki abstract method `tampilkanInfo()` yang harus diimplementasikan oleh subclass.

Selain itu, class `Menu` mengimplementasikan interface `Diskonable` dan memiliki method untuk menghitung harga setelah diskon.

### 5.7 `MenuMakanan`

Class `MenuMakanan` merupakan subclass dari `Menu`.

Class ini memiliki attribute tambahan:

- `jenisMakanan`

Class `MenuMakanan` melakukan overriding terhadap method:

- `tampilkanInfo()`

Informasi menu makanan yang ditampilkan meliputi ID menu, nama menu, kategori, harga, dan jenis makanan.

### 5.8 `MenuMinuman`

Class `MenuMinuman` merupakan subclass dari `Menu`.

Class ini memiliki attribute tambahan:

- `jenisMinuman`

Class `MenuMinuman` melakukan overriding terhadap method:

- `tampilkanInfo()`

Informasi menu minuman yang ditampilkan meliputi ID menu, nama menu, kategori, harga, dan jenis minuman.

### 5.9 `Diskonable`

`Diskonable` merupakan interface yang digunakan sebagai kontrak untuk proses perhitungan harga setelah diskon.

Interface ini memiliki dua method:

```java
double hitungHargaSetelahDiskon();

double hitungHargaSetelahDiskon(
        double persentaseDiskon
);
```

Interface tersebut kemudian diimplementasikan oleh class `Menu`.

---

## 6. Alur Program

### 6.1 Inisialisasi Data

Ketika program dijalankan, class utama membuat object `Restoran`, `RestoranView`, dan `RestoranController`.

Selanjutnya, `RestoranController` melakukan inisialisasi data awal berupa dua kategori:

- `K001` - Makanan
- `K002` - Minuman

Program juga memiliki dummy data menu:

- `M001` - Nasi Goreng
- `M002` - Es Teh

Data tersebut dimasukkan ke dalam `ArrayList`.

### 6.2 Menu Utama

Setelah data awal dibuat, program menampilkan menu utama:

```text
=== SISTEM MANAJEMEN MENU RESTORAN ===
1. Tambah Kategori
2. Tampilkan Kategori
3. Tambah Menu
4. Tampilkan Menu
5. Update Menu
6. Hapus Menu
7. Keluar
8. Hitung Harga Setelah Diskon
```

Pengguna dapat memilih salah satu operasi dengan memasukkan nomor pilihan.

### 6.3 Tambah Kategori

Pengguna memilih menu nomor 1.

Program meminta:

- ID Kategori
- Nama Kategori
- Deskripsi

Data kemudian diproses oleh `RestoranController` dan disimpan melalui class `Restoran`.

Sebelum ditambahkan, program melakukan pengecekan terhadap ID kategori.

### 6.4 Tampilkan Kategori

Pengguna memilih menu nomor 2.

Controller mengambil daftar kategori dari Model dan mengirimkannya ke View.

View kemudian menampilkan:

- ID Kategori
- Nama
- Deskripsi

### 6.5 Tambah Menu

Pengguna memilih menu nomor 3.

Program meminta:

- ID Menu
- Nama Menu
- Kategori
- Harga
- Jenis Menu

Jika pengguna memilih makanan, Controller membuat object:

```java
new MenuMakanan(...)
```

Jika pengguna memilih minuman, Controller membuat object:

```java
new MenuMinuman(...)
```

Object tersebut kemudian ditambahkan ke daftar menu pada class `Restoran`.

### 6.6 Tampilkan Menu

Pengguna memilih menu nomor 4.

Controller mengambil seluruh data menu dari Model.

Data kemudian dikirim ke View untuk ditampilkan.

Program menggunakan:

```java
for (Menu menu : restoran.getDaftarMenu()) {
    menu.tampilkanInfo();
}
```

Karena `Menu` merupakan superclass dan `tampilkanInfo()` dioverride oleh subclass, method yang dijalankan akan menyesuaikan jenis object sebenarnya.

### 6.7 Update Menu

Pengguna memilih menu nomor 5.

Program meminta ID menu yang ingin diperbarui.

Jika menu ditemukan, pengguna dapat mengganti:

- Nama menu
- Kategori
- Harga
- Jenis makanan atau minuman

Controller kemudian meneruskan data tersebut ke method `updateMenu()` pada class `Restoran`.

### 6.8 Hapus Menu

Pengguna memilih menu nomor 6.

Program meminta ID menu.

Jika menu ditemukan, data akan dihapus dari daftar menu.

Jika tidak ditemukan, program akan menampilkan pesan:

```text
Menu tidak ditemukan
```

### 6.9 Keluar Program

Pengguna memilih menu nomor 7.

Nilai variabel `berjalan` menjadi `false`, sehingga perulangan program berhenti.

Program kemudian menampilkan:

```text
Program selesai. Terima kasih
```

### 6.10 Hitung Harga Setelah Diskon

Pengguna memilih menu nomor 8.

Program meminta ID menu yang ingin dihitung.

Setelah menu ditemukan, program mendapatkan harga normal menggunakan:

```java
menu.hitungHargaSetelahDiskon();
```

Selanjutnya pengguna memasukkan persentase diskon.

Harga akhir dihitung menggunakan:

```java
menu.hitungHargaSetelahDiskon(
        persentaseDiskon
);
```

Hasil perhitungan kemudian ditampilkan melalui `RestoranView`.

### 6.11 Alur MVC

Alur interaksi pada program adalah:

```text
Pengguna
    ↓
RestoranView
    ↓
RestoranController
    ↓
Model
    ↓
RestoranController
    ↓
RestoranView
    ↓
Pengguna
```

Contoh pada proses tambah menu:

```text
Pengguna
    ↓
Mengisi data menu
    ↓
RestoranView
    ↓
RestoranController
    ↓
Membuat object MenuMakanan / MenuMinuman
    ↓
Restoran
    ↓
Menyimpan data menu
    ↓
RestoranController
    ↓
RestoranView
    ↓
Menampilkan hasil
```

---

## 7. Penerapan Konsep PBO

### 7.1 Class dan Object

Program menggunakan beberapa class untuk merepresentasikan bagian-bagian dari sistem restoran.

Object dibuat berdasarkan class yang telah didefinisikan.

Contoh object kategori:

```java
Kategori kategoriMakanan =
        new Kategori(
                "K001",
                "Makanan",
                "Kategori makanan restoran"
        );
```

Program juga membuat object subclass:

```java
Menu makananAwal =
        new MenuMakanan(
                "M001",
                "Nasi Goreng",
                kategoriMakanan,
                25000,
                "Makanan Nusantara"
        );
```

Object tersebut dibuat dari `MenuMakanan`, tetapi dapat disimpan dalam reference bertipe `Menu`.

### 7.2 Constructor

Constructor digunakan untuk memberikan nilai awal ketika sebuah object dibuat.

Pada program ini constructor terdapat pada beberapa class, yaitu:

- `Kategori`
- `Menu`
- `MenuMakanan`
- `MenuMinuman`
- `Restoran`
- `RestoranView`
- `RestoranController`

Penggunaan constructor membuat object dapat dibuat dengan data yang dibutuhkan sejak awal.

### 7.3 Access Modifier

Program menggunakan access modifier `private` pada attribute untuk membatasi akses langsung dari luar class.

Contohnya:

```java
private String namaMenu;
private double harga;
```

Attribute tersebut tidak dapat diakses secara langsung oleh class lain dan diakses melalui method yang tersedia.

### 7.4 Encapsulation

Encapsulation diterapkan dengan menyembunyikan data internal object melalui attribute `private` serta menyediakan getter dan setter.

Contohnya:

```java
public String getNamaMenu() {
    return namaMenu;
}
```

dan:

```java
public void setNamaMenu(String namaMenu) {
    this.namaMenu = namaMenu;
}
```

Pada class `Restoran`, daftar internal juga dilindungi menggunakan:

```java
Collections.unmodifiableList(daftarMenu)
```

dan:

```java
Collections.unmodifiableList(daftarKategori)
```

Dengan demikian, daftar internal tidak dapat dimodifikasi secara langsung dari luar class.

### 7.5 Inheritance

Inheritance diterapkan melalui hubungan antara class `Menu` dengan `MenuMakanan` dan `MenuMinuman`.

Implementasinya:

```java
public class MenuMakanan extends Menu
```

dan:

```java
public class MenuMinuman extends Menu
```

`MenuMakanan` dan `MenuMinuman` mewarisi attribute dan method dari class `Menu`.

Kedua subclass juga memiliki attribute khusus masing-masing:

- `MenuMakanan` → `jenisMakanan`
- `MenuMinuman` → `jenisMinuman`

### 7.6 Polymorphism Overriding

Polymorphism overriding diterapkan melalui method `tampilkanInfo()`.

Class `Menu` menyediakan abstract method:

```java
public abstract void tampilkanInfo();
```

Kemudian method tersebut diimplementasikan oleh `MenuMakanan`:

```java
@Override
public void tampilkanInfo() {
    ...
}
```

dan `MenuMinuman`:

```java
@Override
public void tampilkanInfo() {
    ...
}
```

Dengan demikian, satu method memiliki implementasi berbeda sesuai dengan jenis object.

Contohnya:

```java
Menu menu = new MenuMakanan(...);
menu.tampilkanInfo();
```

Method `tampilkanInfo()` yang dipanggil akan menggunakan implementasi milik `MenuMakanan`.

### 7.7 Polymorphism Overloading

Polymorphism overloading diterapkan pada method:

```java
hitungHargaSetelahDiskon()
```

dan:

```java
hitungHargaSetelahDiskon(
        double persentaseDiskon
)
```

Kedua method memiliki nama yang sama tetapi parameter yang berbeda.

Implementasinya:

```java
@Override
public double hitungHargaSetelahDiskon() {
    return harga;
}
```

dan:

```java
@Override
public double hitungHargaSetelahDiskon(
        double persentaseDiskon) {

    if (persentaseDiskon < 0
            || persentaseDiskon > 100) {

        throw new IllegalArgumentException(
                "Persentase diskon harus antara 0 sampai 100"
        );
    }

    return harga
            - (harga * persentaseDiskon / 100);
}
```

Kedua method tersebut digunakan pada fitur Hitung Harga Setelah Diskon.

Contohnya:

```java
double hargaNormal =
        menu.hitungHargaSetelahDiskon();

double hargaAkhir =
        menu.hitungHargaSetelahDiskon(
                persentaseDiskon
        );
```

### 7.8 Abstraction

Abstraction diterapkan dengan menjadikan class `Menu` sebagai abstract class.

Implementasinya:

```java
public abstract class Menu
```

Class `Menu` digunakan sebagai dasar untuk subclass `MenuMakanan` dan `MenuMinuman`.

Dengan abstraction, class `Menu` menyediakan struktur umum menu tanpa harus membuat object `Menu` secara langsung.

### 7.9 Abstract Class

Class `Menu` digunakan sebagai abstract class karena merupakan dasar dari beberapa jenis menu.

Deklarasinya:

```java
public abstract class Menu
```

Class tersebut tidak dibuat menjadi object secara langsung, tetapi digunakan melalui subclass.

### 7.10 Abstract Method

Class `Menu` mempunyai abstract method:

```java
public abstract void tampilkanInfo();
```

Abstract method tersebut tidak memiliki implementasi pada class `Menu`.

Method tersebut wajib diimplementasikan oleh subclass:

- `MenuMakanan`
- `MenuMinuman`

---

## 8. Nilai Tambah

Nilai tambah yang diterapkan pada program adalah penggunaan interface.

### 8.1 Interface `Diskonable`

Interface `Diskonable` dibuat untuk menentukan kontrak method yang digunakan dalam proses perhitungan harga setelah diskon.

Isi interface:

```java
public interface Diskonable {

    double hitungHargaSetelahDiskon();

    double hitungHargaSetelahDiskon(
            double persentaseDiskon
    );
}
```

### 8.2 Implementasi Interface

Class `Menu` mengimplementasikan interface `Diskonable` menggunakan:

```java
public abstract class Menu implements Diskonable
```

Dengan implementasi tersebut, class `Menu` wajib menyediakan method yang telah ditentukan oleh interface.

Implementasi method:

```java
@Override
public double hitungHargaSetelahDiskon() {
    return harga;
}
```

dan:

```java
@Override
public double hitungHargaSetelahDiskon(
        double persentaseDiskon) {

    if (persentaseDiskon < 0
            || persentaseDiskon > 100) {

        throw new IllegalArgumentException(
                "Persentase diskon harus antara 0 sampai 100"
        );
    }

    return harga
            - (harga * persentaseDiskon / 100);
}
```

Penggunaan interface ini juga mendukung penerapan polymorphism overloading pada program.

---

## 9. Validasi Program

### 9.1 Validasi Input Kosong

Program tidak menerima input berupa string kosong.

Jika pengguna tidak memasukkan data, program akan menampilkan:

```text
Input tidak boleh kosong
```

### 9.2 Validasi Pilihan

Pilihan menu harus berupa angka dan berada pada rentang yang telah ditentukan.

Jika pengguna memasukkan karakter atau angka di luar rentang, program akan menampilkan:

```text
Input harus berupa angka
```

atau:

```text
Pilihan harus antara 1 dan 8
```

### 9.3 Validasi Harga

Harga harus berupa angka dan tidak boleh bernilai negatif.

Jika harga yang dimasukkan negatif:

```text
Harga tidak boleh negatif
```

### 9.4 Validasi ID Menu

Program melakukan pengecekan ID menu sebelum data ditambahkan.

Jika ID sudah digunakan:

```text
ID Menu sudah digunakan
```

### 9.5 Validasi ID Kategori

Program juga melakukan pengecekan ID kategori.

Jika ID kategori sudah digunakan:

```text
ID Kategori sudah digunakan
```

### 9.6 Validasi Kategori

Saat menambahkan atau memperbarui menu, pengguna harus memilih kategori yang tersedia.

Jika kategori tidak ditemukan:

```text
Kategori tidak ditemukan
```

### 9.7 Validasi Persentase Diskon

Persentase diskon harus berada antara 0 sampai 100.

Jika pengguna memasukkan nilai di luar rentang tersebut:

```text
Persentase harus antara 0 sampai 100
```

---

## 10. Dokumentasi Program

Dokumentasi program digunakan untuk menunjukkan hasil penggunaan fitur dan struktur program.

### 10.1 Tampilan Menu Utama

Menampilkan menu utama yang dapat digunakan oleh pengguna.

**Dokumentasi:**

<img width="363" height="190" alt="image" src="https://github.com/user-attachments/assets/e286c8cb-4a6e-4417-bf8e-50fd823727d7" />

### 10.2 Menampilkan Kategori

Menampilkan data kategori yang tersedia di dalam sistem.

**Dokumentasi:**

<img width="371" height="393" alt="image" src="https://github.com/user-attachments/assets/644f190c-293c-4bdf-8a8f-df0889cdf249" />

### 10.3 Menampilkan Menu

Menampilkan data menu yang tersedia di dalam sistem.

**Dokumentasi:**

<img width="359" height="467" alt="image" src="https://github.com/user-attachments/assets/24e06034-6533-448d-8ef5-21a356f7dfdf" /> <img width="355" height="212" alt="image" src="https://github.com/user-attachments/assets/046e69f0-4e60-4a7e-a87f-8669f6067f50" />

### 10.4 Menambahkan Kategori

Menampilkan proses ketika pengguna menambahkan kategori baru.

**Dokumentasi:**

<img width="359" height="319" alt="image" src="https://github.com/user-attachments/assets/9b331b88-60d6-437e-a75b-db2b01c49c03" />

### 10.5 Menambahkan Menu

Menampilkan proses penambahan menu baru dengan memilih kategori dan jenis menu.

**Dokumentasi:**

<img width="361" height="569" alt="image" src="https://github.com/user-attachments/assets/4fec72c1-fd7d-444e-b223-84da828bb3b6" />

### 10.6 Memperbarui Menu

Menampilkan proses perubahan data menu.

**Dokumentasi:**

<img width="359" height="640" alt="image" src="https://github.com/user-attachments/assets/3dbadf98-e7d6-4f7a-ac08-cc526dd8f5e3" />

### 10.7 Menghapus Menu

Menampilkan proses penghapusan data menu berdasarkan ID menu.

**Dokumentasi:**

<img width="355" height="277" alt="image" src="https://github.com/user-attachments/assets/36ee38a1-c040-4279-9ba8-2670bcd9f3aa" />

### 10.8 Validasi Input

Menampilkan beberapa kondisi ketika program menangani input yang tidak sesuai.

**Dokumentasi:**

<img width="368" height="230" alt="image" src="https://github.com/user-attachments/assets/66fc279f-fc7b-497f-baac-06e3c7769eec" /> <img width="362" height="274" alt="image" src="https://github.com/user-attachments/assets/2c455e39-1725-474f-9ed6-c905e7b48c02" /> <img width="357" height="652" alt="image" src="https://github.com/user-attachments/assets/2e3aba16-bc94-40f1-80f6-cfe5d800e89c" />

### 10.9 Hitung Harga Setelah Diskon

Menampilkan penggunaan fitur perhitungan harga setelah diskon.

<img width="450" height="478" alt="image" src="https://github.com/user-attachments/assets/bcb614ad-a1f5-43f4-ab64-406c4158c129" />


### 10.10 Struktur MVC

Menampilkan struktur package program yang terdiri dari model, view, dan controller.

<img width="297" height="363" alt="image" src="https://github.com/user-attachments/assets/2ef43c34-5471-473a-8ab5-d7ac6fd5cb00" />


## 11. Ringkasan Penerapan Konsep

Berikut ringkasan konsep PBO yang diterapkan pada program:

| Konsep | Penerapan |
|---|---|
| Encapsulation | Attribute `private`, getter, setter, dan `Collections.unmodifiableList()` |
| Inheritance | `MenuMakanan extends Menu` dan `MenuMinuman extends Menu` |
| Polymorphism Overriding | `tampilkanInfo()` pada `MenuMakanan` dan `MenuMinuman` |
| Polymorphism Overloading | `hitungHargaSetelahDiskon()` dan `hitungHargaSetelahDiskon(double)` |
| Abstraction | `abstract class Menu` |
| Abstract Method | `abstract void tampilkanInfo()` |
| MVC | `model`, `view`, dan `controller` |
| Interface | `Diskonable` |

---

## 12. Kesimpulan

Program Sistem Manajemen Data Menu Restoran merupakan pengembangan dari program sebelumnya dengan struktur dan penerapan konsep Pemrograman Berorientasi Objek yang lebih lengkap.

Program telah menerapkan encapsulation melalui penggunaan attribute private, getter, setter, dan perlindungan daftar internal menggunakan `Collections.unmodifiableList()`. Inheritance diterapkan melalui hubungan antara class `Menu` dengan `MenuMakanan` dan `MenuMinuman`.

Polymorphism diterapkan dalam dua bentuk, yaitu overriding melalui method `tampilkanInfo()` dan overloading melalui method `hitungHargaSetelahDiskon()`. Abstraction diterapkan melalui abstract class `Menu` dan abstract method `tampilkanInfo()`.

Selain itu, struktur program telah dipisahkan menggunakan konsep MVC yang terdiri dari Model, View, dan Controller sehingga tanggung jawab setiap bagian program menjadi lebih terstruktur.

Sebagai nilai tambah, program juga menerapkan interface `Diskonable` yang digunakan sebagai kontrak dalam proses perhitungan harga setelah diskon.
