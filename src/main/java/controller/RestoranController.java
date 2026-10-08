package controller;

import model.Kategori;
import model.Menu;
import model.MenuMakanan;
import model.MenuMinuman;
import model.Restoran;
import view.RestoranView;

public class RestoranController {

    private final Restoran restoran;
    private final RestoranView view;

    public RestoranController(
            Restoran restoran,
            RestoranView view) {

        this.restoran = restoran;
        this.view = view;

        inisialisasiDataAwal();
    }

    public void jalankanProgram() {

        boolean berjalan = true;

        while (berjalan) {

            view.tampilkanMenuUtama();

            int pilihan = view.inputPilihan(
                    "Pilih menu (1-8): ",
                    1,
                    8
            );

            switch (pilihan) {

                case 1 -> tambahKategori();

                case 2 -> tampilkanKategori();

                case 3 -> tambahMenu();

                case 4 -> tampilkanMenu();

                case 5 -> updateMenu();

                case 6 -> hapusMenu();

                case 7 -> {

                    berjalan = false;

                    view.tampilkanPesan(
                            "Program selesai. Terima kasih"
                    );
                }

                case 8 -> hitungHargaSetelahDiskon();
            }
        }

        view.tutupScanner();
    }

    private void inisialisasiDataAwal() {

        Kategori kategoriMakanan = new Kategori(
                "K001",
                "Makanan",
                "Kategori makanan restoran"
        );

        Kategori kategoriMinuman = new Kategori(
                "K002",
                "Minuman",
                "Kategori minuman restoran"
        );

        restoran.tambahKategori(kategoriMakanan);
        restoran.tambahKategori(kategoriMinuman);

        Menu makananAwal = new MenuMakanan(
                "M001",
                "Nasi Goreng",
                kategoriMakanan,
                25000,
                "Makanan Nusantara"
        );

        Menu minumanAwal = new MenuMinuman(
                "M002",
                "Es Teh",
                kategoriMinuman,
                8000,
                "Minuman Dingin"
        );

        restoran.tambahMenu(makananAwal);
        restoran.tambahMenu(minumanAwal);
    }

    private void tambahKategori() {

        view.tampilkanJudul("TAMBAH KATEGORI");

        String idKategori = view.inputString("ID Kategori: ");
        String namaKategori = view.inputString("Nama Kategori: ");
        String deskripsi = view.inputString("Deskripsi: ");

        Kategori kategoriBaru = new Kategori(
                idKategori,
                namaKategori,
                deskripsi
        );

        if (restoran.tambahKategori(kategoriBaru)) {

            view.tampilkanPesan(
                    "Kategori berhasil ditambahkan"
            );

        } else {

            view.tampilkanPesan(
                    "ID Kategori sudah digunakan"
            );
        }
    }

    private void tampilkanKategori() {

        view.tampilkanDaftarKategori(
                restoran.getDaftarKategori()
        );
    }

    private void tambahMenu() {

        view.tampilkanJudul("TAMBAH MENU");

        String idMenu = view.inputString("ID Menu: ");
        String namaMenu = view.inputString("Nama Menu: ");

        Kategori kategoriDipilih = pilihKategori();

        if (kategoriDipilih == null) {
            return;
        }

        double harga = view.inputHarga("Harga Menu: ");

        view.tampilkanPilihanJenisMenu();

        int jenisMenu = view.inputPilihan(
                "Pilih jenis menu (1-2): ",
                1,
                2
        );

        Menu menuBaru;

        if (jenisMenu == 1) {

            String jenisMakanan = view.inputString(
                    "Jenis Makanan: "
            );

            menuBaru = new MenuMakanan(
                    idMenu,
                    namaMenu,
                    kategoriDipilih,
                    harga,
                    jenisMakanan
            );

        } else {

            String jenisMinuman = view.inputString(
                    "Jenis Minuman: "
            );

            menuBaru = new MenuMinuman(
                    idMenu,
                    namaMenu,
                    kategoriDipilih,
                    harga,
                    jenisMinuman
            );
        }

        if (restoran.tambahMenu(menuBaru)) {

            view.tampilkanPesan(
                    "Menu berhasil ditambahkan"
            );

        } else {

            view.tampilkanPesan(
                    "ID Menu sudah digunakan"
            );
        }
    }

    private void tampilkanMenu() {

        view.tampilkanDaftarMenu(
                restoran.getDaftarMenu()
        );
    }

    private void updateMenu() {

        view.tampilkanJudul("UPDATE MENU");

        String idTarget = view.inputString("Masukkan ID Menu: ");

        Menu menu = restoran.cariMenu(idTarget);

        if (menu == null) {

            view.tampilkanPesan(
                    "Menu tidak ditemukan"
            );

            return;
        }

        view.tampilkanMenuSaatIni(menu);

        String namaBaru = view.inputString(
                "Nama Menu Baru: "
        );

        Kategori kategoriBaru = pilihKategori();

        if (kategoriBaru == null) {
            return;
        }

        double hargaBaru = view.inputHarga("Harga Baru: ");

        String jenisBaru;

        if (menu instanceof MenuMakanan) {

            jenisBaru = view.inputString(
                    "Jenis Makanan Baru: "
            );

        } else {

            jenisBaru = view.inputString(
                    "Jenis Minuman Baru: "
            );
        }

        if (restoran.updateMenu(
                idTarget,
                namaBaru,
                kategoriBaru,
                hargaBaru,
                jenisBaru
        )) {

            view.tampilkanPesan(
                    "Menu berhasil diperbarui"
            );

        } else {

            view.tampilkanPesan(
                    "Menu gagal diperbarui"
            );
        }
    }

    private void hapusMenu() {

        view.tampilkanJudul("HAPUS MENU");

        String idTarget = view.inputString("Masukkan ID Menu: ");

        if (restoran.hapusMenu(idTarget)) {

            view.tampilkanPesan(
                    "Menu berhasil dihapus"
            );

        } else {

            view.tampilkanPesan(
                    "Menu tidak ditemukan"
            );
        }
    }

    private void hitungHargaSetelahDiskon() {

        view.tampilkanJudul(
                "HITUNG HARGA SETELAH DISKON"
        );

        String idMenu = view.inputString("Masukkan ID Menu: ");

        Menu menu = restoran.cariMenu(idMenu);

        if (menu == null) {

            view.tampilkanPesan(
                    "Menu tidak ditemukan"
            );

            return;
        }

        double hargaNormal = menu.hitungHargaSetelahDiskon();

        double persentaseDiskon = view.inputPersentase(
                "Persentase Diskon (%): "
        );

        double hargaAkhir = menu.hitungHargaSetelahDiskon(
                persentaseDiskon
        );

        view.tampilkanHasilDiskon(
                menu,
                hargaNormal,
                persentaseDiskon,
                hargaAkhir
        );
    }

    private Kategori pilihKategori() {

        if (restoran.getDaftarKategori().isEmpty()) {

            view.tampilkanPesan(
                    "Belum ada kategori. "
                    + "Tambahkan kategori terlebih dahulu."
            );

            return null;
        }

        view.tampilkanPilihanKategori(
                restoran.getDaftarKategori()
        );

        String idKategori = view.inputString("ID Kategori: ");

        Kategori kategori = restoran.cariKategori(idKategori);

        if (kategori == null) {

            view.tampilkanPesan(
                    "Kategori tidak ditemukan"
            );
        }

        return kategori;
    }
}