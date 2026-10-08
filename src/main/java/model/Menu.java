package model;

public abstract class Menu implements Diskonable {

    private String idMenu;
    private String namaMenu;
    private Kategori kategori;
    private double harga;

    public Menu(
            String idMenu,
            String namaMenu,
            Kategori kategori,
            double harga) {

        this.idMenu = idMenu;
        this.namaMenu = namaMenu;
        this.kategori = kategori;
        this.harga = harga;
    }

    public String getIdMenu() {
        return idMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public double getHarga() {
        return harga;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public abstract void tampilkanInfo();

    @Override
    public double hitungHargaSetelahDiskon() {
        return harga;
    }

    @Override
    public double hitungHargaSetelahDiskon(double persentaseDiskon) {

        if (persentaseDiskon < 0 || persentaseDiskon > 100) {
            throw new IllegalArgumentException(
                    "Persentase diskon harus antara 0 sampai 100"
            );
        }

        return harga - (harga * persentaseDiskon / 100);
    }
}