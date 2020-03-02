package main;

import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WareHouse {

    public static final WareHouse INSTANCE = new WareHouse();
    private List<Produkty> listaproduktow = new ArrayList<Produkty>();

    public List<Produkty> getListaproduktow() {
        return listaproduktow;
    }

    private WareHouse() {

                try {
                    zapisDoPlik();
                    czytajPlik();
                } catch (IOException e) {
                    e.printStackTrace();
                }



    }

    public void zapisDoPlik() throws IOException {
        String filePath ="ListaProduktow.txt";

        FileWriter zapis = new FileWriter(filePath, true);

        zapis.append(pierwszaDana).append(",").append(drugaDana).append(",").append(trzeciaDana).append(",");
        zapis.close();

    }

    private void czytajPlik() throws IOException {
        String filePath = "ListaProduktow.txt";
        File plik = new File(filePath);
        Scanner czytelnik = new Scanner(plik);
        String wiersz = czytelnik.nextLine();

        String[] wynik = wiersz.split(",");
        for (int index =0; index<wynik.length; index+=3) {

            Produkty produkt = new Produkty(wynik[index],Integer.parseInt(wynik[index+1]),Integer.parseInt(wynik[index+2]));
            listaproduktow.add(produkt);
        }





        }


    public void dodajProdukt(Produkty produkt) {
        listaproduktow.add(produkt);

    }
}


