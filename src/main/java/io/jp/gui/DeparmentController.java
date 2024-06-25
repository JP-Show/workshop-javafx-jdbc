package io.jp.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import io.jp.App;
import io.jp.gui.utils.Alerts;
import io.jp.gui.utils.Utils;
import io.jp.model.entities.Department;
import io.jp.model.entities.services.DepartmentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DeparmentController implements Initializable {

    // why won't we instance? Because the hard coupling.
    // SOLID principle, inversion of control
    private DepartmentService service;

    @FXML
    private TableView<Department> tableViewDepartment;
    // first is the type of entity and the second ones is the type of coumn
    @FXML
    private TableColumn<Department, Integer> tableColumnId;
    @FXML
    private TableColumn<Department, String> tableColumnName;

    @FXML
    private Button btNew;

    private ObservableList<Department> obsList;

    @FXML
    public void onBtNewAction(ActionEvent event) {
        Stage parenStage = Utils.currentStage(event);
        createDialogForm("DapartmentForm.fxml", parenStage);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNode();
    }

    private void initializeNode() {
        // Isso é um padrão para iniciar o comportamento das colunas
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        // // fazer o tabela chegar até o final da janela
        Stage stage = (Stage) App.getMainScene().getWindow();
        tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());

    }

    public void updateTableView() {
        if (service == null)
            throw new IllegalStateException("service was null");
        List<Department> list = service.findall();
        obsList = FXCollections.observableArrayList(list);
        tableViewDepartment.setItems(obsList);
    }

    public void setDepartmentService(DepartmentService service) {
        this.service = service;
    }

    private void createDialogForm(String absoluteName, Stage parentStage) {
        try {
            FXMLLoader fx = new FXMLLoader(getClass().getResource(absoluteName));
            Pane pane = fx.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Enter Department data");
            dialogStage.setScene(new Scene(pane));
            dialogStage.setResizable(false);
            dialogStage.initOwner(parentStage);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.showAndWait();

        } catch (IOException e) {
            Alerts.showAlert("IoExecption", e.getCause().getMessage(), e.getMessage(), AlertType.ERROR);
        }
    }
}
