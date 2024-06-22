package io.jp.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import io.jp.App;
import io.jp.gui.utils.Alerts;
import io.jp.model.entities.services.DepartmentService;
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
        loadView("DeparmentList.fxml", (DeparmentController controller) -> {
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();
        });
    }

    @FXML
    public void onMenuItemAboutAction() {
        loadView("About.fxml", x -> {
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    // synchronized garante que esse processo não seja interrompido pelo multithread
    private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
        try {
            FXMLLoader fx = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVbox = fx.load();
            Scene mainScene = App.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
            VBox mainRouteBox = (VBox) mainVBox.getChildren().get(1);
            mainRouteBox.getChildren().clear();
            mainRouteBox.getChildren().addAll(newVbox);

            // antes do generics era um Object qualquer, agora virou um T,
            T controller = fx.getController();
            initializingAction.accept(controller);

        } catch (IOException e) {
            Alerts.showAlert("Error painel", null, "Error when trying to open", AlertType.ERROR);
            System.out.println(e.getCause());
        }

    }

}
