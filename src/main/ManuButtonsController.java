package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.ToggleButton;



public class ManuButtonsController {

    private MainController mainController;

    @FXML
    ToggleButton magazynButton, sklepButton;


    public void openMagazyn(ActionEvent actionEvent) {
        mainController.setCenter("Magazyn.fxml");
    }


    public void openSklep(ActionEvent actionEvent) {
        mainController.setCenter("Sklep.fxml");

    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
