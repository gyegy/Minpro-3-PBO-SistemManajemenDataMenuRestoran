package model;

public class MenuMinuman extends Menu {

    private String jenisMinuman;

    public MenuMinuman(
            String idMenu,
            String namaMenu,
            Kategori kategori,
            double harga,
            String jenisMinuman) {

        super(
                idMenu,
                namaMenu,
                kategori,
                harga
        );

        this.jenisMinuman = jenisMinuman;
    }

    public String getJenisMinuman() {
        return jenisMinuman;
    }

    public void setJenisMinuman(String jenisMinuman) {
        this.jenisMinuman = jenisMinuman;
    }

    @Override
    public void tampilkanInfo() {

        System.out.println(
                "ID Menu        : " + getIdMenu()
        );

        System.out.println(
                "Nama Menu      : " + getNamaMenu()
        );

        System.out.println(
                "Kategori       : "
                + getKategori().getNamaKategori()
        );

        System.out.println(
                "Harga          : Rp" + getHarga()
        );

        System.out.println("Jenis Minuman  : " + jenisMinuman);
    }
}