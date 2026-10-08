package com.mycompany.sistemmanajemendatamenurestoran;

import controller.RestoranController;
import model.Restoran;
import view.RestoranView;

public class SistemManajemenDataMenuRestoran {

    public static void main(String[] args) {

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
    }
}