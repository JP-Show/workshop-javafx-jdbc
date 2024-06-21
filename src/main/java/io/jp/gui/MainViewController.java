package io.jp.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import io.jp.App;
import io.jp.gui.utils.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;
    @FXML
    private MenuItem menuItemDepartment;
    @FXML
    private MenuItem menuItemAbout;

    @FXML
    public void onMenuItemSellerAction() {
        System.out.println("onMenuItemSelllerAction");
    }

    @FXML
    public void onMenuItemmenuItemDepartmentAction() {
        loadView("DeparmentList.fxml");
    }

    @FXML
    public void onMenuItemAboutAction() {
        loadView("About.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    // synchronized garante que esse processo não seja interrompido pelo multithread
    private synchronized void loadView(String absoluteName) {
        try {
            FXMLLoader fx = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVbox = fx.load();
            Scene mainScene = App.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
            VBox mainRouteBox = (VBox) mainVBox.getChildren().get(1);
            mainRouteBox.getChildren().clear();
            mainRouteBox.getChildren().addAll(newVbox);
        } catch (IOException e) {
            Alerts.showAlert("Error painel", null, "Error when trying to open", AlertType.ERROR);
            System.out.println(e.getMessage());
        }

    }

}
