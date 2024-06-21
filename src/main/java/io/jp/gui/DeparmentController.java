package io.jp.gui;

import java.net.URL;
import java.util.ResourceBundle;

import io.jp.App;
import io.jp.model.entities.Department;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DeparmentController implements Initializable {

    @FXML
    private TableView<Department> tableViewDepartment;
    // first is the type of entity and the second ones is the type of coumn
    @FXML
    private TableColumn<Department, Integer> tableColumnId;
    @FXML
    private TableColumn<Department, String> tableColumnName;

    @FXML
    private Button btNew;

    @FXML
    public void onBtNewAction() {
        System.out.println("op");
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

}
