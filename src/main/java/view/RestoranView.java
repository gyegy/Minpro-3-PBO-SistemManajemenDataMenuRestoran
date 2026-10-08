package view;

import model.Kategori;
import model.Menu;
import java.util.List;
import java.util.Scanner;

public class RestoranView {

    private final Scanner scanner;

    public RestoranView() {
        scanner = new Scanner(System.in);
    }

    public void tampilkanMenuUtama() {

        System.out.println("\n=== SISTEM MANAJEMEN MENU RESTORAN ===");

        System.out.println("1. Tambah Kategori");
        System.out.println("2. Tampilkan Kategori");
        System.out.println("3. Tambah Menu");
        System.out.println("4. Tampilkan Menu");
        System.out.println("5. Update Menu");
        System.out.println("6. Hapus Menu");
        System.out.println("7. Keluar");
        System.out.println("8. Hitung Harga Setelah Diskon");
    }

    public void tampilkanJudul(String judul) {

        System.out.println("\n=== " + judul + " ===");
    }

    public void tampilkanPesan(String pesan) {

        System.out.println(pesan);
    }

    public String inputString(String pesan) {

        while (true) {

            System.out.print(pesan);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input tidak boleh kosong");
        }
    }

    public int inputPilihan(
            String pesan,
            int minimum,
            int maksimum) {

        while (true) {

            System.out.print(pesan);

            String input = scanner.nextLine().trim();

            try {

                int pilihan = Integer.parseInt(input);

                if (pilihan >= minimum
                        && pilihan <= maksimum) {

                    return pilihan;
                }

                System.out.println(
                        "Pilihan harus antara "
                        + minimum
                        + " dan "
                        + maksimum
                );

            } catch (NumberFormatException e) {

                System.out.println("Input harus berupa angka");
            }
        }
    }

    public double inputHarga(String pesan) {

        while (true) {

            System.out.print(pesan);

            String input = scanner.nextLine().trim();

            try {

                double harga = Double.parseDouble(input);

                if (harga >= 0) {
                    return harga;
                }

                System.out.println(
                        "Harga tidak boleh negatif"
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Harga harus berupa angka"
                );
            }
        }
    }

    public double inputPersentase(String pesan) {

        while (true) {

            System.out.print(pesan);

            String input = scanner.nextLine().trim();

            try {

                double persentase = Double.parseDouble(input);

                if (persentase >= 0
                        && persentase <= 100) {

                    return persentase;
                }

                System.out.println(
                        "Persentase harus antara 0 sampai 100"
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Input harus berupa angka"
                );
            }
        }
    }

    public void tampilkanDaftarKategori(
            List<Kategori> daftarKategori) {

        tampilkanJudul("DAFTAR KATEGORI");

        if (daftarKategori.isEmpty()) {

            System.out.println(
                    "Belum ada data kategori"
            );

            return;
        }

        for (Kategori kategori : daftarKategori) {

            System.out.println(
                    "ID Kategori : "
                    + kategori.getIdKategori()
            );

            System.out.println(
                    "Nama        : "
                    + kategori.getNamaKategori()
            );

            System.out.println(
                    "Deskripsi   : "
                    + kategori.getDeskripsi()
            );

            System.out.println();
        }
    }

    public void tampilkanPilihanKategori(
            List<Kategori> daftarKategori) {

        tampilkanJudul("PILIH KATEGORI");

        for (Kategori kategori : daftarKategori) {

            System.out.println(
                    kategori.getIdKategori()
                    + " - "
                    + kategori.getNamaKategori()
            );
        }
    }

    public void tampilkanPilihanJenisMenu() {

        tampilkanJudul("PILIH JENIS MENU");

        System.out.println("1. Makanan");
        System.out.println("2. Minuman");
    }

    public void tampilkanDaftarMenu(
            List<Menu> daftarMenu) {

        tampilkanJudul("DAFTAR MENU");

        if (daftarMenu.isEmpty()) {

            System.out.println(
                    "Belum ada data menu"
            );

            return;
        }

        for (Menu menu : daftarMenu) {

            menu.tampilkanInfo();

            System.out.println();
        }
    }

    public void tampilkanMenuSaatIni(Menu menu) {

        tampilkanJudul("DATA MENU SAAT INI");

        menu.tampilkanInfo();

        System.out.println();
    }

    public void tampilkanHasilDiskon(
            Menu menu,
            double hargaNormal,
            double persentaseDiskon,
            double hargaAkhir) {

        System.out.println(
                "Nama Menu    : "
                + menu.getNamaMenu()
        );

        System.out.println(
                "Harga Normal : Rp"
                + hargaNormal
        );

        System.out.println(
                "Diskon       : "
                + persentaseDiskon
                + "%"
        );

        System.out.println(
                "Harga Akhir  : Rp"
                + hargaAkhir
        );
    }

    public void tutupScanner() {

        scanner.close();
    }
}