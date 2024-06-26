package io.jp.gui;

import java.net.URL;
import java.util.ResourceBundle;

import io.jp.gui.utils.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormController implements Initializable {

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtName;
    @FXML
    private Label labelErrorName;
    @FXML
    private Button btCancel;
    @FXML
    private Button btSave;

    @FXML
    public void onBtSaveAction() {
        System.out.println("opa opa");
    }

    @FXML
    public void onBtCancelAction() {

    }

    private void InitializeNode() {
        Constraints.setTextFieldInteger(txtId);
        Constraints.setTextFieldMaxLength(txtName, 30);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        InitializeNode();
    }

}
