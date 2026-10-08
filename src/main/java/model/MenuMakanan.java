package model;

public class MenuMakanan extends Menu {

    private String jenisMakanan;

    public MenuMakanan(
            String idMenu,
            String namaMenu,
            Kategori kategori,
            double harga,
            String jenisMakanan) {

        super(
                idMenu,
                namaMenu,
                kategori,
                harga
        );

        this.jenisMakanan = jenisMakanan;
    }

    public String getJenisMakanan() {
        return jenisMakanan;
    }

    public void setJenisMakanan(String jenisMakanan) {
        this.jenisMakanan = jenisMakanan;
    }

    @Override
    public void tampilkanInfo() {

        System.out.println(
                "ID Menu       : " + getIdMenu()
        );

        System.out.println(
                "Nama Menu     : " + getNamaMenu()
        );

        System.out.println(
                "Kategori      : "
                + getKategori().getNamaKategori()
        );

        System.out.println(
                "Harga         : Rp" + getHarga()
        );

        System.out.println(
                "Jenis Makanan : " + jenisMakanan
        );
    }
}