package main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController {

    @FXML
    private BorderPane glownyEkran;

    @FXML
    ManuButtonsController topManuButtonsController;

    @FXML
    public void initialize() {
        topManuButtonsController.setMainController(this);
    }

    public void setCenter(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource(fxmlPath));
        Parent parent = null;

        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();

        }
        glownyEkran.setCenter(parent);

    }
public static void zamknijProgram() {
    try {
        WareHouse.INSTANCE.zapisDoPlik();
    } catch (IOException e) {
        e.printStackTrace();
    }
    Platform.exit();
    System.exit(0);
}
}
