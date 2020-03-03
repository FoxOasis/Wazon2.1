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
        String filePath = "ListaProduktow.txt";
        FileWriter zapis = new FileWriter(filePath);
        for (Produkty item : listaproduktow) {
            String nazwa = item.name;
            Integer ile = item.quantity;
            Float cena = item.price;
            zapis.write(nazwa).write (",").append(ile.toString()).append(",").append(cena.toString()).append(",").append("\n");
            }
        zapis.close();
    }

    private void czytajPlik() throws IOException {
        String filePath = "ListaProduktow.txt";
        File plik = new File(filePath);
        Scanner czytelnik = new Scanner(plik);
        while (czytelnik.hasNextLine()) {
            String wiersz = czytelnik.nextLine();
            String[] wynik = wiersz.split(",");
            Produkty produkt = new Produkty(wynik[0], Integer.parseInt(wynik[1]), Float.parseFloat(wynik[2]));
            listaproduktow.add(produkt);
        }

    }


    public void dodajProdukt(Produkty produkt) {
        listaproduktow.add(produkt);

    }

    public void usunProdukt(Produkty item) {
        listaproduktow.remove(item);
    }
}


