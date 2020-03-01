package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MagazynController {


    @FXML
    TextField poleNazwaProduktu;
    @FXML
    TextField poleCenaProduktu;
    @FXML
    TextField poleIloscProduktu;
    @FXML
    Button przyciskDodajProdukt;
    @FXML
    Button przyciskUsunProdukt;
    @FXML
    TableView<Produkty> tablicaProduktow;
    @FXML
    TableColumn<Produkty, String> kolumnaNazwa;
    @FXML
    TableColumn<Produkty, Integer> kolumnaIlosc;
    @FXML
    TableColumn<Produkty, Float> kolumnaCena;


    public void przyciskDodaj(ActionEvent actionEvent) {
        Produkty produkt = new Produkty();
        produkt.setName(poleNazwaProduktu.getText());
        produkt.setQuantity(Integer.parseInt(poleIloscProduktu.getText()));
        produkt.setPrice(Float.parseFloat(poleCenaProduktu.getText()));
        tablicaProduktow.getItems().add(produkt);
        poleCenaProduktu.clear();
        poleIloscProduktu.clear();
        poleNazwaProduktu.clear();
    }


    public void initialize() {


        tablicaProduktow.getItems().add(new Produkty("Tablet", 40, 32));
        tablicaProduktow.getItems().add(new Produkty("Kawa", 20, 3));


        kolumnaNazwa.setCellValueFactory(new PropertyValueFactory<>("name"));
        kolumnaIlosc.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        kolumnaCena.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    public void przyciskUsun(ActionEvent actionEvent) {
        ObservableList<Produkty> productSelected, allProduct;
        allProduct = tablicaProduktow.getItems();
        productSelected = tablicaProduktow.getSelectionModel().getSelectedItems();
        productSelected.forEach(allProduct::remove);
    }

}




